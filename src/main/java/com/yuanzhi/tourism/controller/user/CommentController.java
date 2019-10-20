package com.yuanzhi.tourism.controller.user;

import com.yuanzhi.tourism.dto.CommentCreateDTO;
import com.yuanzhi.tourism.dto.ResultDTO;
import com.yuanzhi.tourism.entity.Comment;
import com.yuanzhi.tourism.entity.User;
import com.yuanzhi.tourism.exception.CustomizeErrorCode;
import com.yuanzhi.tourism.service.CommentService;
import com.yuanzhi.tourism.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;

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

    @PostMapping(value = "/comment")
    @ResponseBody
    public Object post(@RequestBody CommentCreateDTO commentCreateDTO){

        System.out.println(commentCreateDTO);
        if (commentCreateDTO == null || StringUtils.isBlank(commentCreateDTO.getContent())) {
            return ResultDTO.errorOf(CustomizeErrorCode.CONTENT_IS_EMPTY);
        }
        Comment comment = new Comment();
        Date date = new Date();
        SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd HH:mm"); //HH代表24小时制，hh代表12小时制
        String publishTime = dateFormat.format(date);
        comment.setLastcommentid(commentCreateDTO.getLastCommentId());
        comment.setCommentcomment(commentCreateDTO.getContent());
//        comment.setJourneyid(commentCreateDTO.getTypeId());
        comment.setCommenttime(publishTime);
        comment.setUserid(commentCreateDTO.getUserId());
        User user = userService.selectUserByPrimary(commentCreateDTO.getUserId());
//        comment.setLikeCount(0L);
        commentService.insert(comment, user);
        return ResultDTO.okOf();
    }

}
