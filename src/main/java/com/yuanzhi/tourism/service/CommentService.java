package com.yuanzhi.tourism.service;

import com.yuanzhi.tourism.dao.CommentMapper;
import com.yuanzhi.tourism.dao.JourneyMapper;
import com.yuanzhi.tourism.dto.CommentCreateDTO;
import com.yuanzhi.tourism.entity.Comment;
import com.yuanzhi.tourism.entity.Journey;
import com.yuanzhi.tourism.entity.User;
import com.yuanzhi.tourism.enums.CommentTypeEnum;
import com.yuanzhi.tourism.exception.CustomizeErrorCode;
import com.yuanzhi.tourism.exception.CustomizeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public void insert(Comment comment, User user) {
        if (comment.getLastcommentid() == null || comment.getLastcommentid() == 0) {
            throw new CustomizeException(CustomizeErrorCode.TARGET_PARAM_NOT_FOUND);
        }
//        if (comment.getJourneyid() == null || !CommentTypeEnum.isExist(comment.getJourneyid())) {
//            throw new CustomizeException(CustomizeErrorCode.TYPE_PARAM_WRONG);
//        }
//        if (comment.getJourneyid() == CommentTypeEnum.JOURNEY.getType()) {
            // 回复游记评论
        CommentCreateDTO commentCreateDTO = new CommentCreateDTO();
        if(commentCreateDTO.getType() == CommentTypeEnum.JOURNEY.getType()){
            comment.setJourneyid(commentCreateDTO.getTypeId());
            Journey journey = journeyMapper.selectByPrimaryKey(comment.getJourneyid());
        }else if(commentCreateDTO.getType() == CommentTypeEnum.STRATEGY.getType()){
            comment.setStrategyid(commentCreateDTO.getTypeId());
        }else if(commentCreateDTO.getType() == CommentTypeEnum.ALBUM.getType()){
            comment.setAlbumid(commentCreateDTO.getTypeId());
        }else {
            comment.setSceneid(commentCreateDTO.getTypeId());
        }
            Comment dbComment = commentMapper.selectByPrimaryKey(comment.getLastcommentid());
            if (dbComment == null) {
                throw new CustomizeException(CustomizeErrorCode.COMMENT_NOT_FOUND);
            }

            // 回复问题
//            Journey journey = journeyMapper.selectByPrimaryKey(dbComment.getJourneyid());
//            if (journey == null) {
//                throw new CustomizeException(CustomizeErrorCode.QUESTION_NOT_FOUND);
//            }

            commentMapper.insert(comment);

            // 增加评论数
            commentMapper.incCommentCount(1);

            // 创建通知
//        }
//        } else if(comment.getTypeid() == CommentTypeEnum.STRATEGY.getType()) {
//            // 回复攻略评论
//            Question question = questionMapper.selectByPrimaryKey(comment.getParentId());
//            if (question == null) {
//                throw new CustomizeException(CustomizeErrorCode.QUESTION_NOT_FOUND);
//            }
//            comment.setCommentCount(0);
//            commentMapper.insert(comment);
//            question.setCommentCount(1);
//            questionExtMapper.incCommentCount(question);
//
//            // 创建通知
//            createNotify(comment, question.getCreator(), commentator.getName(), question.getTitle(), NotificationTypeEnum.REPLY_QUESTION, question.getId());
//        }
    }
}
