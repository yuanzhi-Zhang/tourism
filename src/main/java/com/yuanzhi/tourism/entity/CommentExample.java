package com.yuanzhi.tourism.entity;

import java.util.ArrayList;
import java.util.List;

public class CommentExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CommentExample() {
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

        public Criteria andCidIsNull() {
            addCriterion("cid is null");
            return (Criteria) this;
        }

        public Criteria andCidIsNotNull() {
            addCriterion("cid is not null");
            return (Criteria) this;
        }

        public Criteria andCidEqualTo(Integer value) {
            addCriterion("cid =", value, "cid");
            return (Criteria) this;
        }

        public Criteria andCidNotEqualTo(Integer value) {
            addCriterion("cid <>", value, "cid");
            return (Criteria) this;
        }

        public Criteria andCidGreaterThan(Integer value) {
            addCriterion("cid >", value, "cid");
            return (Criteria) this;
        }

        public Criteria andCidGreaterThanOrEqualTo(Integer value) {
            addCriterion("cid >=", value, "cid");
            return (Criteria) this;
        }

        public Criteria andCidLessThan(Integer value) {
            addCriterion("cid <", value, "cid");
            return (Criteria) this;
        }

        public Criteria andCidLessThanOrEqualTo(Integer value) {
            addCriterion("cid <=", value, "cid");
            return (Criteria) this;
        }

        public Criteria andCidIn(List<Integer> values) {
            addCriterion("cid in", values, "cid");
            return (Criteria) this;
        }

        public Criteria andCidNotIn(List<Integer> values) {
            addCriterion("cid not in", values, "cid");
            return (Criteria) this;
        }

        public Criteria andCidBetween(Integer value1, Integer value2) {
            addCriterion("cid between", value1, value2, "cid");
            return (Criteria) this;
        }

        public Criteria andCidNotBetween(Integer value1, Integer value2) {
            addCriterion("cid not between", value1, value2, "cid");
            return (Criteria) this;
        }

        public Criteria andUseridIsNull() {
            addCriterion("userId is null");
            return (Criteria) this;
        }

        public Criteria andUseridIsNotNull() {
            addCriterion("userId is not null");
            return (Criteria) this;
        }

        public Criteria andUseridEqualTo(Integer value) {
            addCriterion("userId =", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotEqualTo(Integer value) {
            addCriterion("userId <>", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThan(Integer value) {
            addCriterion("userId >", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThanOrEqualTo(Integer value) {
            addCriterion("userId >=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThan(Integer value) {
            addCriterion("userId <", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThanOrEqualTo(Integer value) {
            addCriterion("userId <=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridIn(List<Integer> values) {
            addCriterion("userId in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotIn(List<Integer> values) {
            addCriterion("userId not in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridBetween(Integer value1, Integer value2) {
            addCriterion("userId between", value1, value2, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotBetween(Integer value1, Integer value2) {
            addCriterion("userId not between", value1, value2, "userid");
            return (Criteria) this;
        }

        public Criteria andCommenttimeIsNull() {
            addCriterion("commentTime is null");
            return (Criteria) this;
        }

        public Criteria andCommenttimeIsNotNull() {
            addCriterion("commentTime is not null");
            return (Criteria) this;
        }

        public Criteria andCommenttimeEqualTo(String value) {
            addCriterion("commentTime =", value, "commenttime");
            return (Criteria) this;
        }

        public Criteria andCommenttimeNotEqualTo(String value) {
            addCriterion("commentTime <>", value, "commenttime");
            return (Criteria) this;
        }

        public Criteria andCommenttimeGreaterThan(String value) {
            addCriterion("commentTime >", value, "commenttime");
            return (Criteria) this;
        }

        public Criteria andCommenttimeGreaterThanOrEqualTo(String value) {
            addCriterion("commentTime >=", value, "commenttime");
            return (Criteria) this;
        }

        public Criteria andCommenttimeLessThan(String value) {
            addCriterion("commentTime <", value, "commenttime");
            return (Criteria) this;
        }

        public Criteria andCommenttimeLessThanOrEqualTo(String value) {
            addCriterion("commentTime <=", value, "commenttime");
            return (Criteria) this;
        }

        public Criteria andCommenttimeLike(String value) {
            addCriterion("commentTime like", value, "commenttime");
            return (Criteria) this;
        }

        public Criteria andCommenttimeNotLike(String value) {
            addCriterion("commentTime not like", value, "commenttime");
            return (Criteria) this;
        }

        public Criteria andCommenttimeIn(List<String> values) {
            addCriterion("commentTime in", values, "commenttime");
            return (Criteria) this;
        }

        public Criteria andCommenttimeNotIn(List<String> values) {
            addCriterion("commentTime not in", values, "commenttime");
            return (Criteria) this;
        }

        public Criteria andCommenttimeBetween(String value1, String value2) {
            addCriterion("commentTime between", value1, value2, "commenttime");
            return (Criteria) this;
        }

        public Criteria andCommenttimeNotBetween(String value1, String value2) {
            addCriterion("commentTime not between", value1, value2, "commenttime");
            return (Criteria) this;
        }

        public Criteria andCommentcommentIsNull() {
            addCriterion("commentComment is null");
            return (Criteria) this;
        }

        public Criteria andCommentcommentIsNotNull() {
            addCriterion("commentComment is not null");
            return (Criteria) this;
        }

        public Criteria andCommentcommentEqualTo(String value) {
            addCriterion("commentComment =", value, "commentcomment");
            return (Criteria) this;
        }

        public Criteria andCommentcommentNotEqualTo(String value) {
            addCriterion("commentComment <>", value, "commentcomment");
            return (Criteria) this;
        }

        public Criteria andCommentcommentGreaterThan(String value) {
            addCriterion("commentComment >", value, "commentcomment");
            return (Criteria) this;
        }

        public Criteria andCommentcommentGreaterThanOrEqualTo(String value) {
            addCriterion("commentComment >=", value, "commentcomment");
            return (Criteria) this;
        }

        public Criteria andCommentcommentLessThan(String value) {
            addCriterion("commentComment <", value, "commentcomment");
            return (Criteria) this;
        }

        public Criteria andCommentcommentLessThanOrEqualTo(String value) {
            addCriterion("commentComment <=", value, "commentcomment");
            return (Criteria) this;
        }

        public Criteria andCommentcommentLike(String value) {
            addCriterion("commentComment like", value, "commentcomment");
            return (Criteria) this;
        }

        public Criteria andCommentcommentNotLike(String value) {
            addCriterion("commentComment not like", value, "commentcomment");
            return (Criteria) this;
        }

        public Criteria andCommentcommentIn(List<String> values) {
            addCriterion("commentComment in", values, "commentcomment");
            return (Criteria) this;
        }

        public Criteria andCommentcommentNotIn(List<String> values) {
            addCriterion("commentComment not in", values, "commentcomment");
            return (Criteria) this;
        }

        public Criteria andCommentcommentBetween(String value1, String value2) {
            addCriterion("commentComment between", value1, value2, "commentcomment");
            return (Criteria) this;
        }

        public Criteria andCommentcommentNotBetween(String value1, String value2) {
            addCriterion("commentComment not between", value1, value2, "commentcomment");
            return (Criteria) this;
        }

        public Criteria andLastcommentidIsNull() {
            addCriterion("lastCommentId is null");
            return (Criteria) this;
        }

        public Criteria andLastcommentidIsNotNull() {
            addCriterion("lastCommentId is not null");
            return (Criteria) this;
        }

        public Criteria andLastcommentidEqualTo(Integer value) {
            addCriterion("lastCommentId =", value, "lastcommentid");
            return (Criteria) this;
        }

        public Criteria andLastcommentidNotEqualTo(Integer value) {
            addCriterion("lastCommentId <>", value, "lastcommentid");
            return (Criteria) this;
        }

        public Criteria andLastcommentidGreaterThan(Integer value) {
            addCriterion("lastCommentId >", value, "lastcommentid");
            return (Criteria) this;
        }

        public Criteria andLastcommentidGreaterThanOrEqualTo(Integer value) {
            addCriterion("lastCommentId >=", value, "lastcommentid");
            return (Criteria) this;
        }

        public Criteria andLastcommentidLessThan(Integer value) {
            addCriterion("lastCommentId <", value, "lastcommentid");
            return (Criteria) this;
        }

        public Criteria andLastcommentidLessThanOrEqualTo(Integer value) {
            addCriterion("lastCommentId <=", value, "lastcommentid");
            return (Criteria) this;
        }

        public Criteria andLastcommentidIn(List<Integer> values) {
            addCriterion("lastCommentId in", values, "lastcommentid");
            return (Criteria) this;
        }

        public Criteria andLastcommentidNotIn(List<Integer> values) {
            addCriterion("lastCommentId not in", values, "lastcommentid");
            return (Criteria) this;
        }

        public Criteria andLastcommentidBetween(Integer value1, Integer value2) {
            addCriterion("lastCommentId between", value1, value2, "lastcommentid");
            return (Criteria) this;
        }

        public Criteria andLastcommentidNotBetween(Integer value1, Integer value2) {
            addCriterion("lastCommentId not between", value1, value2, "lastcommentid");
            return (Criteria) this;
        }

        public Criteria andAlbumidIsNull() {
            addCriterion("albumId is null");
            return (Criteria) this;
        }

        public Criteria andAlbumidIsNotNull() {
            addCriterion("albumId is not null");
            return (Criteria) this;
        }

        public Criteria andAlbumidEqualTo(Integer value) {
            addCriterion("albumId =", value, "albumid");
            return (Criteria) this;
        }

        public Criteria andAlbumidNotEqualTo(Integer value) {
            addCriterion("albumId <>", value, "albumid");
            return (Criteria) this;
        }

        public Criteria andAlbumidGreaterThan(Integer value) {
            addCriterion("albumId >", value, "albumid");
            return (Criteria) this;
        }

        public Criteria andAlbumidGreaterThanOrEqualTo(Integer value) {
            addCriterion("albumId >=", value, "albumid");
            return (Criteria) this;
        }

        public Criteria andAlbumidLessThan(Integer value) {
            addCriterion("albumId <", value, "albumid");
            return (Criteria) this;
        }

        public Criteria andAlbumidLessThanOrEqualTo(Integer value) {
            addCriterion("albumId <=", value, "albumid");
            return (Criteria) this;
        }

        public Criteria andAlbumidIn(List<Integer> values) {
            addCriterion("albumId in", values, "albumid");
            return (Criteria) this;
        }

        public Criteria andAlbumidNotIn(List<Integer> values) {
            addCriterion("albumId not in", values, "albumid");
            return (Criteria) this;
        }

        public Criteria andAlbumidBetween(Integer value1, Integer value2) {
            addCriterion("albumId between", value1, value2, "albumid");
            return (Criteria) this;
        }

        public Criteria andAlbumidNotBetween(Integer value1, Integer value2) {
            addCriterion("albumId not between", value1, value2, "albumid");
            return (Criteria) this;
        }

        public Criteria andSceneidIsNull() {
            addCriterion("sceneId is null");
            return (Criteria) this;
        }

        public Criteria andSceneidIsNotNull() {
            addCriterion("sceneId is not null");
            return (Criteria) this;
        }

        public Criteria andSceneidEqualTo(Integer value) {
            addCriterion("sceneId =", value, "sceneid");
            return (Criteria) this;
        }

        public Criteria andSceneidNotEqualTo(Integer value) {
            addCriterion("sceneId <>", value, "sceneid");
            return (Criteria) this;
        }

        public Criteria andSceneidGreaterThan(Integer value) {
            addCriterion("sceneId >", value, "sceneid");
            return (Criteria) this;
        }

        public Criteria andSceneidGreaterThanOrEqualTo(Integer value) {
            addCriterion("sceneId >=", value, "sceneid");
            return (Criteria) this;
        }

        public Criteria andSceneidLessThan(Integer value) {
            addCriterion("sceneId <", value, "sceneid");
            return (Criteria) this;
        }

        public Criteria andSceneidLessThanOrEqualTo(Integer value) {
            addCriterion("sceneId <=", value, "sceneid");
            return (Criteria) this;
        }

        public Criteria andSceneidIn(List<Integer> values) {
            addCriterion("sceneId in", values, "sceneid");
            return (Criteria) this;
        }

        public Criteria andSceneidNotIn(List<Integer> values) {
            addCriterion("sceneId not in", values, "sceneid");
            return (Criteria) this;
        }

        public Criteria andSceneidBetween(Integer value1, Integer value2) {
            addCriterion("sceneId between", value1, value2, "sceneid");
            return (Criteria) this;
        }

        public Criteria andSceneidNotBetween(Integer value1, Integer value2) {
            addCriterion("sceneId not between", value1, value2, "sceneid");
            return (Criteria) this;
        }

        public Criteria andStrategyidIsNull() {
            addCriterion("strategyId is null");
            return (Criteria) this;
        }

        public Criteria andStrategyidIsNotNull() {
            addCriterion("strategyId is not null");
            return (Criteria) this;
        }

        public Criteria andStrategyidEqualTo(Integer value) {
            addCriterion("strategyId =", value, "strategyid");
            return (Criteria) this;
        }

        public Criteria andStrategyidNotEqualTo(Integer value) {
            addCriterion("strategyId <>", value, "strategyid");
            return (Criteria) this;
        }

        public Criteria andStrategyidGreaterThan(Integer value) {
            addCriterion("strategyId >", value, "strategyid");
            return (Criteria) this;
        }

        public Criteria andStrategyidGreaterThanOrEqualTo(Integer value) {
            addCriterion("strategyId >=", value, "strategyid");
            return (Criteria) this;
        }

        public Criteria andStrategyidLessThan(Integer value) {
            addCriterion("strategyId <", value, "strategyid");
            return (Criteria) this;
        }

        public Criteria andStrategyidLessThanOrEqualTo(Integer value) {
            addCriterion("strategyId <=", value, "strategyid");
            return (Criteria) this;
        }

        public Criteria andStrategyidIn(List<Integer> values) {
            addCriterion("strategyId in", values, "strategyid");
            return (Criteria) this;
        }

        public Criteria andStrategyidNotIn(List<Integer> values) {
            addCriterion("strategyId not in", values, "strategyid");
            return (Criteria) this;
        }

        public Criteria andStrategyidBetween(Integer value1, Integer value2) {
            addCriterion("strategyId between", value1, value2, "strategyid");
            return (Criteria) this;
        }

        public Criteria andStrategyidNotBetween(Integer value1, Integer value2) {
            addCriterion("strategyId not between", value1, value2, "strategyid");
            return (Criteria) this;
        }

        public Criteria andJourneyidIsNull() {
            addCriterion("journeyId is null");
            return (Criteria) this;
        }

        public Criteria andJourneyidIsNotNull() {
            addCriterion("journeyId is not null");
            return (Criteria) this;
        }

        public Criteria andJourneyidEqualTo(Integer value) {
            addCriterion("journeyId =", value, "journeyid");
            return (Criteria) this;
        }

        public Criteria andJourneyidNotEqualTo(Integer value) {
            addCriterion("journeyId <>", value, "journeyid");
            return (Criteria) this;
        }

        public Criteria andJourneyidGreaterThan(Integer value) {
            addCriterion("journeyId >", value, "journeyid");
            return (Criteria) this;
        }

        public Criteria andJourneyidGreaterThanOrEqualTo(Integer value) {
            addCriterion("journeyId >=", value, "journeyid");
            return (Criteria) this;
        }

        public Criteria andJourneyidLessThan(Integer value) {
            addCriterion("journeyId <", value, "journeyid");
            return (Criteria) this;
        }

        public Criteria andJourneyidLessThanOrEqualTo(Integer value) {
            addCriterion("journeyId <=", value, "journeyid");
            return (Criteria) this;
        }

        public Criteria andJourneyidIn(List<Integer> values) {
            addCriterion("journeyId in", values, "journeyid");
            return (Criteria) this;
        }

        public Criteria andJourneyidNotIn(List<Integer> values) {
            addCriterion("journeyId not in", values, "journeyid");
            return (Criteria) this;
        }

        public Criteria andJourneyidBetween(Integer value1, Integer value2) {
            addCriterion("journeyId between", value1, value2, "journeyid");
            return (Criteria) this;
        }

        public Criteria andJourneyidNotBetween(Integer value1, Integer value2) {
            addCriterion("journeyId not between", value1, value2, "journeyid");
            return (Criteria) this;
        }

        public Criteria andCommentcountIsNull() {
            addCriterion("commentCount is null");
            return (Criteria) this;
        }

        public Criteria andCommentcountIsNotNull() {
            addCriterion("commentCount is not null");
            return (Criteria) this;
        }

        public Criteria andCommentcountEqualTo(Integer value) {
            addCriterion("commentCount =", value, "commentcount");
            return (Criteria) this;
        }

        public Criteria andCommentcountNotEqualTo(Integer value) {
            addCriterion("commentCount <>", value, "commentcount");
            return (Criteria) this;
        }

        public Criteria andCommentcountGreaterThan(Integer value) {
            addCriterion("commentCount >", value, "commentcount");
            return (Criteria) this;
        }

        public Criteria andCommentcountGreaterThanOrEqualTo(Integer value) {
            addCriterion("commentCount >=", value, "commentcount");
            return (Criteria) this;
        }

        public Criteria andCommentcountLessThan(Integer value) {
            addCriterion("commentCount <", value, "commentcount");
            return (Criteria) this;
        }

        public Criteria andCommentcountLessThanOrEqualTo(Integer value) {
            addCriterion("commentCount <=", value, "commentcount");
            return (Criteria) this;
        }

        public Criteria andCommentcountIn(List<Integer> values) {
            addCriterion("commentCount in", values, "commentcount");
            return (Criteria) this;
        }

        public Criteria andCommentcountNotIn(List<Integer> values) {
            addCriterion("commentCount not in", values, "commentcount");
            return (Criteria) this;
        }

        public Criteria andCommentcountBetween(Integer value1, Integer value2) {
            addCriterion("commentCount between", value1, value2, "commentcount");
            return (Criteria) this;
        }

        public Criteria andCommentcountNotBetween(Integer value1, Integer value2) {
            addCriterion("commentCount not between", value1, value2, "commentcount");
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