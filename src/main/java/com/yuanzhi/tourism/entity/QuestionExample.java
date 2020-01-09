package com.yuanzhi.tourism.entity;

import java.util.ArrayList;
import java.util.List;

public class QuestionExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public QuestionExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andQuestionIdIsNull() {
            addCriterion("question_id is null");
            return (Criteria) this;
        }

        public Criteria andQuestionIdIsNotNull() {
            addCriterion("question_id is not null");
            return (Criteria) this;
        }

        public Criteria andQuestionIdEqualTo(Integer value) {
            addCriterion("question_id =", value, "questionId");
            return (Criteria) this;
        }

        public Criteria andQuestionIdNotEqualTo(Integer value) {
            addCriterion("question_id <>", value, "questionId");
            return (Criteria) this;
        }

        public Criteria andQuestionIdGreaterThan(Integer value) {
            addCriterion("question_id >", value, "questionId");
            return (Criteria) this;
        }

        public Criteria andQuestionIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("question_id >=", value, "questionId");
            return (Criteria) this;
        }

        public Criteria andQuestionIdLessThan(Integer value) {
            addCriterion("question_id <", value, "questionId");
            return (Criteria) this;
        }

        public Criteria andQuestionIdLessThanOrEqualTo(Integer value) {
            addCriterion("question_id <=", value, "questionId");
            return (Criteria) this;
        }

        public Criteria andQuestionIdIn(List<Integer> values) {
            addCriterion("question_id in", values, "questionId");
            return (Criteria) this;
        }

        public Criteria andQuestionIdNotIn(List<Integer> values) {
            addCriterion("question_id not in", values, "questionId");
            return (Criteria) this;
        }

        public Criteria andQuestionIdBetween(Integer value1, Integer value2) {
            addCriterion("question_id between", value1, value2, "questionId");
            return (Criteria) this;
        }

        public Criteria andQuestionIdNotBetween(Integer value1, Integer value2) {
            addCriterion("question_id not between", value1, value2, "questionId");
            return (Criteria) this;
        }

        public Criteria andQuestionTimeIsNull() {
            addCriterion("question_time is null");
            return (Criteria) this;
        }

        public Criteria andQuestionTimeIsNotNull() {
            addCriterion("question_time is not null");
            return (Criteria) this;
        }

        public Criteria andQuestionTimeEqualTo(String value) {
            addCriterion("question_time =", value, "questionTime");
            return (Criteria) this;
        }

        public Criteria andQuestionTimeNotEqualTo(String value) {
            addCriterion("question_time <>", value, "questionTime");
            return (Criteria) this;
        }

        public Criteria andQuestionTimeGreaterThan(String value) {
            addCriterion("question_time >", value, "questionTime");
            return (Criteria) this;
        }

        public Criteria andQuestionTimeGreaterThanOrEqualTo(String value) {
            addCriterion("question_time >=", value, "questionTime");
            return (Criteria) this;
        }

        public Criteria andQuestionTimeLessThan(String value) {
            addCriterion("question_time <", value, "questionTime");
            return (Criteria) this;
        }

        public Criteria andQuestionTimeLessThanOrEqualTo(String value) {
            addCriterion("question_time <=", value, "questionTime");
            return (Criteria) this;
        }

        public Criteria andQuestionTimeLike(String value) {
            addCriterion("question_time like", value, "questionTime");
            return (Criteria) this;
        }

        public Criteria andQuestionTimeNotLike(String value) {
            addCriterion("question_time not like", value, "questionTime");
            return (Criteria) this;
        }

        public Criteria andQuestionTimeIn(List<String> values) {
            addCriterion("question_time in", values, "questionTime");
            return (Criteria) this;
        }

        public Criteria andQuestionTimeNotIn(List<String> values) {
            addCriterion("question_time not in", values, "questionTime");
            return (Criteria) this;
        }

        public Criteria andQuestionTimeBetween(String value1, String value2) {
            addCriterion("question_time between", value1, value2, "questionTime");
            return (Criteria) this;
        }

        public Criteria andQuestionTimeNotBetween(String value1, String value2) {
            addCriterion("question_time not between", value1, value2, "questionTime");
            return (Criteria) this;
        }

        public Criteria andQuestionCreatorIdIsNull() {
            addCriterion("question_creator_id is null");
            return (Criteria) this;
        }

        public Criteria andQuestionCreatorIdIsNotNull() {
            addCriterion("question_creator_id is not null");
            return (Criteria) this;
        }

        public Criteria andQuestionCreatorIdEqualTo(Integer value) {
            addCriterion("question_creator_id =", value, "questionCreatorId");
            return (Criteria) this;
        }

        public Criteria andQuestionCreatorIdNotEqualTo(Integer value) {
            addCriterion("question_creator_id <>", value, "questionCreatorId");
            return (Criteria) this;
        }

        public Criteria andQuestionCreatorIdGreaterThan(Integer value) {
            addCriterion("question_creator_id >", value, "questionCreatorId");
            return (Criteria) this;
        }

        public Criteria andQuestionCreatorIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("question_creator_id >=", value, "questionCreatorId");
            return (Criteria) this;
        }

        public Criteria andQuestionCreatorIdLessThan(Integer value) {
            addCriterion("question_creator_id <", value, "questionCreatorId");
            return (Criteria) this;
        }

        public Criteria andQuestionCreatorIdLessThanOrEqualTo(Integer value) {
            addCriterion("question_creator_id <=", value, "questionCreatorId");
            return (Criteria) this;
        }

        public Criteria andQuestionCreatorIdIn(List<Integer> values) {
            addCriterion("question_creator_id in", values, "questionCreatorId");
            return (Criteria) this;
        }

        public Criteria andQuestionCreatorIdNotIn(List<Integer> values) {
            addCriterion("question_creator_id not in", values, "questionCreatorId");
            return (Criteria) this;
        }

        public Criteria andQuestionCreatorIdBetween(Integer value1, Integer value2) {
            addCriterion("question_creator_id between", value1, value2, "questionCreatorId");
            return (Criteria) this;
        }

        public Criteria andQuestionCreatorIdNotBetween(Integer value1, Integer value2) {
            addCriterion("question_creator_id not between", value1, value2, "questionCreatorId");
            return (Criteria) this;
        }

        public Criteria andQuestionTitleIsNull() {
            addCriterion("question_title is null");
            return (Criteria) this;
        }

        public Criteria andQuestionTitleIsNotNull() {
            addCriterion("question_title is not null");
            return (Criteria) this;
        }

        public Criteria andQuestionTitleEqualTo(String value) {
            addCriterion("question_title =", value, "questionTitle");
            return (Criteria) this;
        }

        public Criteria andQuestionTitleNotEqualTo(String value) {
            addCriterion("question_title <>", value, "questionTitle");
            return (Criteria) this;
        }

        public Criteria andQuestionTitleGreaterThan(String value) {
            addCriterion("question_title >", value, "questionTitle");
            return (Criteria) this;
        }

        public Criteria andQuestionTitleGreaterThanOrEqualTo(String value) {
            addCriterion("question_title >=", value, "questionTitle");
            return (Criteria) this;
        }

        public Criteria andQuestionTitleLessThan(String value) {
            addCriterion("question_title <", value, "questionTitle");
            return (Criteria) this;
        }

        public Criteria andQuestionTitleLessThanOrEqualTo(String value) {
            addCriterion("question_title <=", value, "questionTitle");
            return (Criteria) this;
        }

        public Criteria andQuestionTitleLike(String value) {
            addCriterion("question_title like", value, "questionTitle");
            return (Criteria) this;
        }

        public Criteria andQuestionTitleNotLike(String value) {
            addCriterion("question_title not like", value, "questionTitle");
            return (Criteria) this;
        }

        public Criteria andQuestionTitleIn(List<String> values) {
            addCriterion("question_title in", values, "questionTitle");
            return (Criteria) this;
        }

        public Criteria andQuestionTitleNotIn(List<String> values) {
            addCriterion("question_title not in", values, "questionTitle");
            return (Criteria) this;
        }

        public Criteria andQuestionTitleBetween(String value1, String value2) {
            addCriterion("question_title between", value1, value2, "questionTitle");
            return (Criteria) this;
        }

        public Criteria andQuestionTitleNotBetween(String value1, String value2) {
            addCriterion("question_title not between", value1, value2, "questionTitle");
            return (Criteria) this;
        }

        public Criteria andQuestionImgIsNull() {
            addCriterion("question_img is null");
            return (Criteria) this;
        }

        public Criteria andQuestionImgIsNotNull() {
            addCriterion("question_img is not null");
            return (Criteria) this;
        }

        public Criteria andQuestionImgEqualTo(String value) {
            addCriterion("question_img =", value, "questionImg");
            return (Criteria) this;
        }

        public Criteria andQuestionImgNotEqualTo(String value) {
            addCriterion("question_img <>", value, "questionImg");
            return (Criteria) this;
        }

        public Criteria andQuestionImgGreaterThan(String value) {
            addCriterion("question_img >", value, "questionImg");
            return (Criteria) this;
        }

        public Criteria andQuestionImgGreaterThanOrEqualTo(String value) {
            addCriterion("question_img >=", value, "questionImg");
            return (Criteria) this;
        }

        public Criteria andQuestionImgLessThan(String value) {
            addCriterion("question_img <", value, "questionImg");
            return (Criteria) this;
        }

        public Criteria andQuestionImgLessThanOrEqualTo(String value) {
            addCriterion("question_img <=", value, "questionImg");
            return (Criteria) this;
        }

        public Criteria andQuestionImgLike(String value) {
            addCriterion("question_img like", value, "questionImg");
            return (Criteria) this;
        }

        public Criteria andQuestionImgNotLike(String value) {
            addCriterion("question_img not like", value, "questionImg");
            return (Criteria) this;
        }

        public Criteria andQuestionImgIn(List<String> values) {
            addCriterion("question_img in", values, "questionImg");
            return (Criteria) this;
        }

        public Criteria andQuestionImgNotIn(List<String> values) {
            addCriterion("question_img not in", values, "questionImg");
            return (Criteria) this;
        }

        public Criteria andQuestionImgBetween(String value1, String value2) {
            addCriterion("question_img between", value1, value2, "questionImg");
            return (Criteria) this;
        }

        public Criteria andQuestionImgNotBetween(String value1, String value2) {
            addCriterion("question_img not between", value1, value2, "questionImg");
            return (Criteria) this;
        }

        public Criteria andQuestionContentIsNull() {
            addCriterion("question_content is null");
            return (Criteria) this;
        }

        public Criteria andQuestionContentIsNotNull() {
            addCriterion("question_content is not null");
            return (Criteria) this;
        }

        public Criteria andQuestionContentEqualTo(String value) {
            addCriterion("question_content =", value, "questionContent");
            return (Criteria) this;
        }

        public Criteria andQuestionContentNotEqualTo(String value) {
            addCriterion("question_content <>", value, "questionContent");
            return (Criteria) this;
        }

        public Criteria andQuestionContentGreaterThan(String value) {
            addCriterion("question_content >", value, "questionContent");
            return (Criteria) this;
        }

        public Criteria andQuestionContentGreaterThanOrEqualTo(String value) {
            addCriterion("question_content >=", value, "questionContent");
            return (Criteria) this;
        }

        public Criteria andQuestionContentLessThan(String value) {
            addCriterion("question_content <", value, "questionContent");
            return (Criteria) this;
        }

        public Criteria andQuestionContentLessThanOrEqualTo(String value) {
            addCriterion("question_content <=", value, "questionContent");
            return (Criteria) this;
        }

        public Criteria andQuestionContentLike(String value) {
            addCriterion("question_content like", value, "questionContent");
            return (Criteria) this;
        }

        public Criteria andQuestionContentNotLike(String value) {
            addCriterion("question_content not like", value, "questionContent");
            return (Criteria) this;
        }

        public Criteria andQuestionContentIn(List<String> values) {
            addCriterion("question_content in", values, "questionContent");
            return (Criteria) this;
        }

        public Criteria andQuestionContentNotIn(List<String> values) {
            addCriterion("question_content not in", values, "questionContent");
            return (Criteria) this;
        }

        public Criteria andQuestionContentBetween(String value1, String value2) {
            addCriterion("question_content between", value1, value2, "questionContent");
            return (Criteria) this;
        }

        public Criteria andQuestionContentNotBetween(String value1, String value2) {
            addCriterion("question_content not between", value1, value2, "questionContent");
            return (Criteria) this;
        }

        public Criteria andQuestionDestinyIsNull() {
            addCriterion("question_destiny is null");
            return (Criteria) this;
        }

        public Criteria andQuestionDestinyIsNotNull() {
            addCriterion("question_destiny is not null");
            return (Criteria) this;
        }

        public Criteria andQuestionDestinyEqualTo(String value) {
            addCriterion("question_destiny =", value, "questionDestiny");
            return (Criteria) this;
        }

        public Criteria andQuestionDestinyNotEqualTo(String value) {
            addCriterion("question_destiny <>", value, "questionDestiny");
            return (Criteria) this;
        }

        public Criteria andQuestionDestinyGreaterThan(String value) {
            addCriterion("question_destiny >", value, "questionDestiny");
            return (Criteria) this;
        }

        public Criteria andQuestionDestinyGreaterThanOrEqualTo(String value) {
            addCriterion("question_destiny >=", value, "questionDestiny");
            return (Criteria) this;
        }

        public Criteria andQuestionDestinyLessThan(String value) {
            addCriterion("question_destiny <", value, "questionDestiny");
            return (Criteria) this;
        }

        public Criteria andQuestionDestinyLessThanOrEqualTo(String value) {
            addCriterion("question_destiny <=", value, "questionDestiny");
            return (Criteria) this;
        }

        public Criteria andQuestionDestinyLike(String value) {
            addCriterion("question_destiny like", value, "questionDestiny");
            return (Criteria) this;
        }

        public Criteria andQuestionDestinyNotLike(String value) {
            addCriterion("question_destiny not like", value, "questionDestiny");
            return (Criteria) this;
        }

        public Criteria andQuestionDestinyIn(List<String> values) {
            addCriterion("question_destiny in", values, "questionDestiny");
            return (Criteria) this;
        }

        public Criteria andQuestionDestinyNotIn(List<String> values) {
            addCriterion("question_destiny not in", values, "questionDestiny");
            return (Criteria) this;
        }

        public Criteria andQuestionDestinyBetween(String value1, String value2) {
            addCriterion("question_destiny between", value1, value2, "questionDestiny");
            return (Criteria) this;
        }

        public Criteria andQuestionDestinyNotBetween(String value1, String value2) {
            addCriterion("question_destiny not between", value1, value2, "questionDestiny");
            return (Criteria) this;
        }

        public Criteria andViewCountIsNull() {
            addCriterion("view_count is null");
            return (Criteria) this;
        }

        public Criteria andViewCountIsNotNull() {
            addCriterion("view_count is not null");
            return (Criteria) this;
        }

        public Criteria andViewCountEqualTo(Integer value) {
            addCriterion("view_count =", value, "viewCount");
            return (Criteria) this;
        }

        public Criteria andViewCountNotEqualTo(Integer value) {
            addCriterion("view_count <>", value, "viewCount");
            return (Criteria) this;
        }

        public Criteria andViewCountGreaterThan(Integer value) {
            addCriterion("view_count >", value, "viewCount");
            return (Criteria) this;
        }

        public Criteria andViewCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("view_count >=", value, "viewCount");
            return (Criteria) this;
        }

        public Criteria andViewCountLessThan(Integer value) {
            addCriterion("view_count <", value, "viewCount");
            return (Criteria) this;
        }

        public Criteria andViewCountLessThanOrEqualTo(Integer value) {
            addCriterion("view_count <=", value, "viewCount");
            return (Criteria) this;
        }

        public Criteria andViewCountIn(List<Integer> values) {
            addCriterion("view_count in", values, "viewCount");
            return (Criteria) this;
        }

        public Criteria andViewCountNotIn(List<Integer> values) {
            addCriterion("view_count not in", values, "viewCount");
            return (Criteria) this;
        }

        public Criteria andViewCountBetween(Integer value1, Integer value2) {
            addCriterion("view_count between", value1, value2, "viewCount");
            return (Criteria) this;
        }

        public Criteria andViewCountNotBetween(Integer value1, Integer value2) {
            addCriterion("view_count not between", value1, value2, "viewCount");
            return (Criteria) this;
        }

        public Criteria andLikeCountIsNull() {
            addCriterion("like_count is null");
            return (Criteria) this;
        }

        public Criteria andLikeCountIsNotNull() {
            addCriterion("like_count is not null");
            return (Criteria) this;
        }

        public Criteria andLikeCountEqualTo(Integer value) {
            addCriterion("like_count =", value, "likeCount");
            return (Criteria) this;
        }

        public Criteria andLikeCountNotEqualTo(Integer value) {
            addCriterion("like_count <>", value, "likeCount");
            return (Criteria) this;
        }

        public Criteria andLikeCountGreaterThan(Integer value) {
            addCriterion("like_count >", value, "likeCount");
            return (Criteria) this;
        }

        public Criteria andLikeCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("like_count >=", value, "likeCount");
            return (Criteria) this;
        }

        public Criteria andLikeCountLessThan(Integer value) {
            addCriterion("like_count <", value, "likeCount");
            return (Criteria) this;
        }

        public Criteria andLikeCountLessThanOrEqualTo(Integer value) {
            addCriterion("like_count <=", value, "likeCount");
            return (Criteria) this;
        }

        public Criteria andLikeCountIn(List<Integer> values) {
            addCriterion("like_count in", values, "likeCount");
            return (Criteria) this;
        }

        public Criteria andLikeCountNotIn(List<Integer> values) {
            addCriterion("like_count not in", values, "likeCount");
            return (Criteria) this;
        }

        public Criteria andLikeCountBetween(Integer value1, Integer value2) {
            addCriterion("like_count between", value1, value2, "likeCount");
            return (Criteria) this;
        }

        public Criteria andLikeCountNotBetween(Integer value1, Integer value2) {
            addCriterion("like_count not between", value1, value2, "likeCount");
            return (Criteria) this;
        }

        public Criteria andCommentCountIsNull() {
            addCriterion("comment_count is null");
            return (Criteria) this;
        }

        public Criteria andCommentCountIsNotNull() {
            addCriterion("comment_count is not null");
            return (Criteria) this;
        }

        public Criteria andCommentCountEqualTo(Integer value) {
            addCriterion("comment_count =", value, "commentCount");
            return (Criteria) this;
        }

        public Criteria andCommentCountNotEqualTo(Integer value) {
            addCriterion("comment_count <>", value, "commentCount");
            return (Criteria) this;
        }

        public Criteria andCommentCountGreaterThan(Integer value) {
            addCriterion("comment_count >", value, "commentCount");
            return (Criteria) this;
        }

        public Criteria andCommentCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("comment_count >=", value, "commentCount");
            return (Criteria) this;
        }

        public Criteria andCommentCountLessThan(Integer value) {
            addCriterion("comment_count <", value, "commentCount");
            return (Criteria) this;
        }

        public Criteria andCommentCountLessThanOrEqualTo(Integer value) {
            addCriterion("comment_count <=", value, "commentCount");
            return (Criteria) this;
        }

        public Criteria andCommentCountIn(List<Integer> values) {
            addCriterion("comment_count in", values, "commentCount");
            return (Criteria) this;
        }

        public Criteria andCommentCountNotIn(List<Integer> values) {
            addCriterion("comment_count not in", values, "commentCount");
            return (Criteria) this;
        }

        public Criteria andCommentCountBetween(Integer value1, Integer value2) {
            addCriterion("comment_count between", value1, value2, "commentCount");
            return (Criteria) this;
        }

        public Criteria andCommentCountNotBetween(Integer value1, Integer value2) {
            addCriterion("comment_count not between", value1, value2, "commentCount");
            return (Criteria) this;
        }

        public Criteria andAttentionCountIsNull() {
            addCriterion("attention_count is null");
            return (Criteria) this;
        }

        public Criteria andAttentionCountIsNotNull() {
            addCriterion("attention_count is not null");
            return (Criteria) this;
        }

        public Criteria andAttentionCountEqualTo(Integer value) {
            addCriterion("attention_count =", value, "attentionCount");
            return (Criteria) this;
        }

        public Criteria andAttentionCountNotEqualTo(Integer value) {
            addCriterion("attention_count <>", value, "attentionCount");
            return (Criteria) this;
        }

        public Criteria andAttentionCountGreaterThan(Integer value) {
            addCriterion("attention_count >", value, "attentionCount");
            return (Criteria) this;
        }

        public Criteria andAttentionCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("attention_count >=", value, "attentionCount");
            return (Criteria) this;
        }

        public Criteria andAttentionCountLessThan(Integer value) {
            addCriterion("attention_count <", value, "attentionCount");
            return (Criteria) this;
        }

        public Criteria andAttentionCountLessThanOrEqualTo(Integer value) {
            addCriterion("attention_count <=", value, "attentionCount");
            return (Criteria) this;
        }

        public Criteria andAttentionCountIn(List<Integer> values) {
            addCriterion("attention_count in", values, "attentionCount");
            return (Criteria) this;
        }

        public Criteria andAttentionCountNotIn(List<Integer> values) {
            addCriterion("attention_count not in", values, "attentionCount");
            return (Criteria) this;
        }

        public Criteria andAttentionCountBetween(Integer value1, Integer value2) {
            addCriterion("attention_count between", value1, value2, "attentionCount");
            return (Criteria) this;
        }

        public Criteria andAttentionCountNotBetween(Integer value1, Integer value2) {
            addCriterion("attention_count not between", value1, value2, "attentionCount");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}