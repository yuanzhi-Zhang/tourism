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
import java.util.Collection;
import java.util.Date;
import java.util.List;

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
        Collection<User> users = userService.getAllUser();
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

}
