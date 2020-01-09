package com.yuanzhi.tourism.dao;

import com.yuanzhi.tourism.entity.Comment;
import com.yuanzhi.tourism.entity.CommentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentMapper {
    long countByExample(CommentExample example);

    int deleteByExample(CommentExample example);

    int deleteByPrimaryKey(Integer cid);

    int insert(Comment record);

    int insertSelective(Comment record);

    List<Comment> selectByExample(CommentExample example);

    Comment selectByPrimaryKey(Integer cid);

    int updateByExampleSelective(@Param("record") Comment record, @Param("example") CommentExample example);

    int updateByExample(@Param("record") Comment record, @Param("example") CommentExample example);

    int updateByPrimaryKeySelective(Comment record);

    int updateByPrimaryKey(Comment record);

    List<Comment> selectWithUser();

    int incCommentCount(Integer cid);

    void downCommentCount(Integer cid);

    void incCommentPraiseNum(Integer cid);

    void downCommentPraiseNum(Integer cid);
}