package com.yuanzhi.tourism.entity;

import lombok.Data;

@Data
public class Question {
    private Integer questionId;

    private String questionTime;

    private Integer questionCreatorId;

    private String questionTitle;

    private String questionImg;

    private String questionContent;

    private String questionDestiny;

    private Integer viewCount;

    private Integer likeCount;

    private Integer commentCount;

    private Integer attentionCount;

    public Integer getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Integer questionId) {
        this.questionId = questionId;
    }

    public String getQuestionTime() {
        return questionTime;
    }

    public void setQuestionTime(String questionTime) {
        this.questionTime = questionTime == null ? null : questionTime.trim();
    }

    public Integer getQuestionCreatorId() {
        return questionCreatorId;
    }

    public void setQuestionCreatorId(Integer questionCreatorId) {
        this.questionCreatorId = questionCreatorId;
    }

    public String getQuestionTitle() {
        return questionTitle;
    }

    public void setQuestionTitle(String questionTitle) {
        this.questionTitle = questionTitle == null ? null : questionTitle.trim();
    }

    public String getQuestionImg() {
        return questionImg;
    }

    public void setQuestionImg(String questionImg) {
        this.questionImg = questionImg == null ? null : questionImg.trim();
    }

    public String getQuestionContent() {
        return questionContent;
    }

    public void setQuestionContent(String questionContent) {
        this.questionContent = questionContent == null ? null : questionContent.trim();
    }

    public String getQuestionDestiny() {
        return questionDestiny;
    }

    public void setQuestionDestiny(String questionDestiny) {
        this.questionDestiny = questionDestiny == null ? null : questionDestiny.trim();
    }

    public Integer getViewCount() {
        return viewCount;
    }

    public void setViewCount(Integer viewCount) {
        this.viewCount = viewCount;
    }

    public Integer getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(Integer likeCount) {
        this.likeCount = likeCount;
    }

    public Integer getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(Integer commentCount) {
        this.commentCount = commentCount;
    }

    public Integer getAttentionCount() {
        return attentionCount;
    }

    public void setAttentionCount(Integer attentionCount) {
        this.attentionCount = attentionCount;
    }
}