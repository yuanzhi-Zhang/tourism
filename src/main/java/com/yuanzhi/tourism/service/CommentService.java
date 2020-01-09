package com.yuanzhi.tourism.service;

import com.yuanzhi.tourism.dao.*;
import com.yuanzhi.tourism.dto.CommentDTO;
import com.yuanzhi.tourism.entity.*;
import com.yuanzhi.tourism.enums.CommentTypeEnum;
import com.yuanzhi.tourism.enums.NotificationStatusEnum;
import com.yuanzhi.tourism.enums.NotificationTypeEnum;
import com.yuanzhi.tourism.exception.CustomizeErrorCode;
import com.yuanzhi.tourism.exception.CustomizeException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @Author: yuanzhi...
 * @Date: created in  2019/10/20 12:01
 */

@Service
public class CommentService {

    @Autowired
    CommentMapper commentMapper;
    @Autowired
    JourneyMapper journeyMapper;
    @Autowired
    StrategyMapper strategyMapper;
    @Autowired
    CompanyMapper companyMapper;
    @Autowired
    UserMapper userMapper;
    @Autowired
    NotificationMapper notificationMapper;

    /**
     * 添加一级和二级评论以及创建对应的通知给被评论者
     * @param comment 评论的相关信息
     * @param user 评论人
     */
    @Transactional
    public void insert(Comment comment, User user) {
        if (comment.getParentid() == null || comment.getParentid() == 0) {
            throw new CustomizeException(CustomizeErrorCode.TARGET_PARAM_NOT_FOUND);
        }
        if (comment.getType() == null || !CommentTypeEnum.isExist(comment.getType())) {
            throw new CustomizeException(CustomizeErrorCode.TYPE_PARAM_WRONG);
        }
        if (comment.getType() == CommentTypeEnum.COMMENT.getType()) {
            // 回复评论
            Comment dbComment = commentMapper.selectByPrimaryKey(comment.getParentid());
            if (dbComment == null) {
                throw new CustomizeException(CustomizeErrorCode.COMMENT_NOT_FOUND);
            }

            commentMapper.insert(comment);

            // 增加评论数
            commentMapper.incCommentCount(comment.getParentid());

            //创建通知
            if(dbComment.getUserid() != user.getUid()){
                createNotify(comment,dbComment.getUserid(),dbComment.getCommentcomment(),NotificationTypeEnum.REPLY_COMMENT,comment.getParentid(), user);
            }
        } else if (comment.getType() == CommentTypeEnum.JOURNEY.getType()){
            // 回复游记
            Journey journey = journeyMapper.selectByPrimaryKey(comment.getParentid());
            if (journey == null) {
                throw new CustomizeException(CustomizeErrorCode.QUESTION_NOT_FOUND);
            }
            comment.setCommentcount(0);
            commentMapper.insert(comment);
            journeyMapper.incCommentCount(comment.getParentid());

            //创建通知
            if(journey.getUserid() != user.getUid()){
                createNotify(comment,journey.getUserid(),journey.getJourtitle(),NotificationTypeEnum.REPLY_JOURNEY,journey.getTid(),user);
            }
        }else if(comment.getType() == CommentTypeEnum.STRATEGY.getType()){
            //回复攻略
            Strategy strategy = strategyMapper.selectByPrimaryKey(comment.getParentid());
            if (strategy == null){
                throw new CustomizeException(CustomizeErrorCode.QUESTION_NOT_FOUND);
            }
            comment.setCommentcount(0);
            comment.setPraiseNum(0);
            commentMapper.insertSelective(comment);
            strategyMapper.incComment(comment.getParentid());

            //创建通知
            if(strategy.getUserId() != user.getUid()){
                createNotify(comment,strategy.getUserId(),strategy.getStrategyTitle(),NotificationTypeEnum.REPLY_STRATEGY,strategy.getStrategyId(),user);
            }
        }else if(comment.getType() == CommentTypeEnum.COMPANY.getType()){
            //回复结伴
            Company company = companyMapper.selectByPrimaryKey(comment.getParentid());
            if (company == null){
                throw new CustomizeException(CustomizeErrorCode.QUESTION_NOT_FOUND);
            }
            comment.setCommentcount(0);
            comment.setPraiseNum(0);
            commentMapper.insertSelective(comment);
            companyMapper.incComment(comment.getParentid());

            //创建通知
            if(company.getCompanyOwnerId() != user.getUid()){
                createNotify(comment,company.getCompanyOwnerId(),company.getCompanyTitle(),NotificationTypeEnum.REPLY_COMPANY,company.getCompanyId(),user);
            }
        }
    }

    /**
     * 创建通知
     * @param comment 评论
     * @param receiver 接收者
     * @param notificationTypeEnum 类型
     * @param typeId 具体类型的哪一个
     * @param user 通知者
     */
    private void createNotify(Comment comment, Integer receiver,String title,NotificationTypeEnum notificationTypeEnum,Integer typeId, User user) {
        if(user.getUid() == receiver){
            return;
        }
        Notification notification = new Notification();
        Date date = new Date();
        SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd HH:mm"); //HH代表24小时制，hh代表12小时制
        notification.setSendtime(dateFormat.format(date));
        notification.setType(notificationTypeEnum.getType());
        notification.setTypeid(typeId);
        notification.setNotificationer(user.getUid());
        notification.setStatus(NotificationStatusEnum.UNREAD.getStatus());
        notification.setReceiver(receiver);
        notification.setNotificationername(user.getUsername());
        notification.setTypename(comment.getCommentcomment());
        notification.setTypeidname(title);
        notificationMapper.insert(notification);
    }

    /**
     * 获取对应文章或评论的所有的评论以及评论人信息
     * @param id 对应文章或评论id
     * @param type 表明是游记还是攻略、相册、景点或者评论
     * @return 文章或评论的所有的评论以及评论人信息
     */
    public List<CommentDTO> listByTargetId(Integer id, CommentTypeEnum type) {
        CommentExample commentExample = new CommentExample();
        commentExample.createCriteria().andParentidEqualTo(id).andTypeEqualTo(type.getType());
        commentExample.setOrderByClause("commentTime desc");
        List<Comment> comments = commentMapper.selectByExample(commentExample);

        if (comments.size() == 0) {
            return new ArrayList<>();
        }
        // 获取去重的评论人
        Set<Integer> commentators = comments.stream().map(comment -> comment.getUserid()).collect(Collectors.toSet());
        List<Integer> userIds = new ArrayList();
        userIds.addAll(commentators);


        // 获取评论人并转换为 Map
        UserExample userExample = new UserExample();
        userExample.createCriteria().andUidIn(userIds);
        List<User> users = userMapper.selectByExample(userExample);
        Map<Integer, User> userMap = users.stream().collect(Collectors.toMap(user -> user.getUid(), user -> user));


        // 转换 comment 为 commentDTO
        List<CommentDTO> commentDTOS = comments.stream().map(comment -> {
            CommentDTO commentDTO = new CommentDTO();
            BeanUtils.copyProperties(comment, commentDTO);
            commentDTO.setUser(userMap.get(comment.getUserid()));
            return commentDTO;
        }).collect(Collectors.toList());


        return commentDTOS;
    }

    public List<Comment> listComments() {
        return commentMapper.selectWithUser();
    }

    public void incCommentCount(Integer typeId) {
        commentMapper.incCommentCount(typeId);
    }

    public void downCommentCount(Integer typeId) {
        commentMapper.downCommentCount(typeId);
    }

    public void incCommentPraiseNum(Integer typeId) {
        commentMapper.incCommentPraiseNum(typeId);
    }

    public void downCommentPraiseNum(Integer typeId) {
        commentMapper.downCommentPraiseNum(typeId);
    }

    public List<Comment> countNum() {
        return commentMapper.selectByExample(null);
    }
}
