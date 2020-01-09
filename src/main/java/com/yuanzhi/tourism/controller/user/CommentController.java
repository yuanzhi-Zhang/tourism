package com.yuanzhi.tourism.controller.user;

import com.yuanzhi.tourism.dto.CommentCreateDTO;
import com.yuanzhi.tourism.dto.CommentDTO;
import com.yuanzhi.tourism.dto.ResultDTO;
import com.yuanzhi.tourism.entity.Comment;
import com.yuanzhi.tourism.entity.User;
import com.yuanzhi.tourism.enums.CommentTypeEnum;
import com.yuanzhi.tourism.service.CommentService;
import com.yuanzhi.tourism.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @Author: yuanzhi...
 * @Date: created in  2019/10/20 12:00
 */

@Controller
public class CommentController {

    @Autowired
    CommentService commentService;
    @Autowired
    UserService userService;

    /**
     * 发表游记、攻略、相册、景点的一级评论以及二级评论
     * @param request
     * @param response
     * @param commentCreateDTO 辅助类
     * @return 成功与否的状态码和信息
     * @throws UnsupportedEncodingException
     */
    @PostMapping(value = "/comment")
    @ResponseBody
    public Object post(HttpServletRequest request, HttpServletResponse response,
                       @RequestBody CommentCreateDTO commentCreateDTO) throws UnsupportedEncodingException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("application/json;charset=utf-8");
        Comment comment = new Comment();
        Date date = new Date();
        SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); //HH代表24小时制，hh代表12小时制
        String publishTime = dateFormat.format(date);
        comment.setParentid(commentCreateDTO.getParentId());
        comment.setCommentcomment(commentCreateDTO.getContent());
        comment.setType(commentCreateDTO.getType());
        comment.setCommenttime(publishTime);
        comment.setUserid(commentCreateDTO.getUserId());
//        Collection<User> users = userService.getAllUser(page, limit);
        User user = userService.selectUserByPrimary(commentCreateDTO.getUserId());
        commentService.insert(comment, user);
        return ResultDTO.okOf();
    }

    /**
     * 查询所有带有用户的评论
     * @param id
     * @return
     */
    @ResponseBody
    @GetMapping(value = "/comment/{id}")
    public ResultDTO<List<CommentDTO>> comments(@PathVariable(name = "id") Integer id) {
        List<CommentDTO> commentDTOS = commentService.listByTargetId(id, CommentTypeEnum.COMMENT);
        return ResultDTO.okOf(commentDTOS);
    }

    @PostMapping(value = "/comment/getByType")
    @ResponseBody
    public ResultDTO<List<CommentDTO>> commentsType(@RequestBody Map<String,String> data) {
        Integer id = Integer.parseInt(data.get("id"));
        Integer type = Integer.parseInt(data.get("type"));
        List<CommentDTO> commentDTOS = new ArrayList<CommentDTO>();
        if(CommentTypeEnum.STRATEGY.getType() == type){
            commentDTOS = commentService.listByTargetId(id, CommentTypeEnum.STRATEGY);
        }else if(CommentTypeEnum.JOURNEY.getType() == type){
            commentDTOS = commentService.listByTargetId(id, CommentTypeEnum.JOURNEY);
        }else if(CommentTypeEnum.COMPANY.getType() == type){
            commentDTOS = commentService.listByTargetId(id,CommentTypeEnum.COMPANY);
        }
        return ResultDTO.okOf(commentDTOS);
    }

    /**
     * 查询评论总数
     * @return
     */
    @PostMapping("/comment/countNum")
    @ResponseBody
    public Map<String ,Object> countNum(){
        Map<String,Object> map = new HashMap<String,Object>();
        List<Comment> commentList = commentService.countNum();
        List<Comment> jornuyNum = new ArrayList<>();
        List<Comment> strategyNum = new ArrayList<>();
        List<Comment> companyNum = new ArrayList<>();
        List<Comment> commentsNum = new ArrayList<>();
        for (int i = 0; i < commentList.size(); i++) {
            if (commentList.get(i).getType() == CommentTypeEnum.JOURNEY.getType()){
                jornuyNum.add(commentList.get(i));
            }
            if (commentList.get(i).getType() == CommentTypeEnum.STRATEGY.getType()){
                strategyNum.add(commentList.get(i));
            }
            if (commentList.get(i).getType() == CommentTypeEnum.COMPANY.getType()){
                companyNum.add(commentList.get(i));
            }
            if (commentList.get(i).getType() == CommentTypeEnum.COMMENT.getType()){
                commentsNum.add(commentList.get(i));
            }
        }
        Integer commentNum = commentService.countNum().size();
        map.put("commentNum",commentNum);
        map.put("jornuyNum",jornuyNum);
        map.put("strategyNum",strategyNum);
        map.put("companyNum",companyNum);
        map.put("commentsNum",commentsNum);
        return map;
    }

}
