package com.yuanzhi.tourism.entity;

import java.util.ArrayList;
import java.util.List;

public class RemainExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public RemainExample() {
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

        public Criteria andRemainIdIsNull() {
            addCriterion("remain_id is null");
            return (Criteria) this;
        }

        public Criteria andRemainIdIsNotNull() {
            addCriterion("remain_id is not null");
            return (Criteria) this;
        }

        public Criteria andRemainIdEqualTo(Integer value) {
            addCriterion("remain_id =", value, "remainId");
            return (Criteria) this;
        }

        public Criteria andRemainIdNotEqualTo(Integer value) {
            addCriterion("remain_id <>", value, "remainId");
            return (Criteria) this;
        }

        public Criteria andRemainIdGreaterThan(Integer value) {
            addCriterion("remain_id >", value, "remainId");
            return (Criteria) this;
        }

        public Criteria andRemainIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("remain_id >=", value, "remainId");
            return (Criteria) this;
        }

        public Criteria andRemainIdLessThan(Integer value) {
            addCriterion("remain_id <", value, "remainId");
            return (Criteria) this;
        }

        public Criteria andRemainIdLessThanOrEqualTo(Integer value) {
            addCriterion("remain_id <=", value, "remainId");
            return (Criteria) this;
        }

        public Criteria andRemainIdIn(List<Integer> values) {
            addCriterion("remain_id in", values, "remainId");
            return (Criteria) this;
        }

        public Criteria andRemainIdNotIn(List<Integer> values) {
            addCriterion("remain_id not in", values, "remainId");
            return (Criteria) this;
        }

        public Criteria andRemainIdBetween(Integer value1, Integer value2) {
            addCriterion("remain_id between", value1, value2, "remainId");
            return (Criteria) this;
        }

        public Criteria andRemainIdNotBetween(Integer value1, Integer value2) {
            addCriterion("remain_id not between", value1, value2, "remainId");
            return (Criteria) this;
        }

        public Criteria andRemainSenderIdIsNull() {
            addCriterion("remain_sender_id is null");
            return (Criteria) this;
        }

        public Criteria andRemainSenderIdIsNotNull() {
            addCriterion("remain_sender_id is not null");
            return (Criteria) this;
        }

        public Criteria andRemainSenderIdEqualTo(Integer value) {
            addCriterion("remain_sender_id =", value, "remainSenderId");
            return (Criteria) this;
        }

        public Criteria andRemainSenderIdNotEqualTo(Integer value) {
            addCriterion("remain_sender_id <>", value, "remainSenderId");
            return (Criteria) this;
        }

        public Criteria andRemainSenderIdGreaterThan(Integer value) {
            addCriterion("remain_sender_id >", value, "remainSenderId");
            return (Criteria) this;
        }

        public Criteria andRemainSenderIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("remain_sender_id >=", value, "remainSenderId");
            return (Criteria) this;
        }

        public Criteria andRemainSenderIdLessThan(Integer value) {
            addCriterion("remain_sender_id <", value, "remainSenderId");
            return (Criteria) this;
        }

        public Criteria andRemainSenderIdLessThanOrEqualTo(Integer value) {
            addCriterion("remain_sender_id <=", value, "remainSenderId");
            return (Criteria) this;
        }

        public Criteria andRemainSenderIdIn(List<Integer> values) {
            addCriterion("remain_sender_id in", values, "remainSenderId");
            return (Criteria) this;
        }

        public Criteria andRemainSenderIdNotIn(List<Integer> values) {
            addCriterion("remain_sender_id not in", values, "remainSenderId");
            return (Criteria) this;
        }

        public Criteria andRemainSenderIdBetween(Integer value1, Integer value2) {
            addCriterion("remain_sender_id between", value1, value2, "remainSenderId");
            return (Criteria) this;
        }

        public Criteria andRemainSenderIdNotBetween(Integer value1, Integer value2) {
            addCriterion("remain_sender_id not between", value1, value2, "remainSenderId");
            return (Criteria) this;
        }

        public Criteria andRemainReceiverIdIsNull() {
            addCriterion("remain_receiver_id is null");
            return (Criteria) this;
        }

        public Criteria andRemainReceiverIdIsNotNull() {
            addCriterion("remain_receiver_id is not null");
            return (Criteria) this;
        }

        public Criteria andRemainReceiverIdEqualTo(Integer value) {
            addCriterion("remain_receiver_id =", value, "remainReceiverId");
            return (Criteria) this;
        }

        public Criteria andRemainReceiverIdNotEqualTo(Integer value) {
            addCriterion("remain_receiver_id <>", value, "remainReceiverId");
            return (Criteria) this;
        }

        public Criteria andRemainReceiverIdGreaterThan(Integer value) {
            addCriterion("remain_receiver_id >", value, "remainReceiverId");
            return (Criteria) this;
        }

        public Criteria andRemainReceiverIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("remain_receiver_id >=", value, "remainReceiverId");
            return (Criteria) this;
        }

        public Criteria andRemainReceiverIdLessThan(Integer value) {
            addCriterion("remain_receiver_id <", value, "remainReceiverId");
            return (Criteria) this;
        }

        public Criteria andRemainReceiverIdLessThanOrEqualTo(Integer value) {
            addCriterion("remain_receiver_id <=", value, "remainReceiverId");
            return (Criteria) this;
        }

        public Criteria andRemainReceiverIdIn(List<Integer> values) {
            addCriterion("remain_receiver_id in", values, "remainReceiverId");
            return (Criteria) this;
        }

        public Criteria andRemainReceiverIdNotIn(List<Integer> values) {
            addCriterion("remain_receiver_id not in", values, "remainReceiverId");
            return (Criteria) this;
        }

        public Criteria andRemainReceiverIdBetween(Integer value1, Integer value2) {
            addCriterion("remain_receiver_id between", value1, value2, "remainReceiverId");
            return (Criteria) this;
        }

        public Criteria andRemainReceiverIdNotBetween(Integer value1, Integer value2) {
            addCriterion("remain_receiver_id not between", value1, value2, "remainReceiverId");
            return (Criteria) this;
        }

        public Criteria andRemainContentIsNull() {
            addCriterion("remain_content is null");
            return (Criteria) this;
        }

        public Criteria andRemainContentIsNotNull() {
            addCriterion("remain_content is not null");
            return (Criteria) this;
        }

        public Criteria andRemainContentEqualTo(String value) {
            addCriterion("remain_content =", value, "remainContent");
            return (Criteria) this;
        }

        public Criteria andRemainContentNotEqualTo(String value) {
            addCriterion("remain_content <>", value, "remainContent");
            return (Criteria) this;
        }

        public Criteria andRemainContentGreaterThan(String value) {
            addCriterion("remain_content >", value, "remainContent");
            return (Criteria) this;
        }

        public Criteria andRemainContentGreaterThanOrEqualTo(String value) {
            addCriterion("remain_content >=", value, "remainContent");
            return (Criteria) this;
        }

        public Criteria andRemainContentLessThan(String value) {
            addCriterion("remain_content <", value, "remainContent");
            return (Criteria) this;
        }

        public Criteria andRemainContentLessThanOrEqualTo(String value) {
            addCriterion("remain_content <=", value, "remainContent");
            return (Criteria) this;
        }

        public Criteria andRemainContentLike(String value) {
            addCriterion("remain_content like", value, "remainContent");
            return (Criteria) this;
        }

        public Criteria andRemainContentNotLike(String value) {
            addCriterion("remain_content not like", value, "remainContent");
            return (Criteria) this;
        }

        public Criteria andRemainContentIn(List<String> values) {
            addCriterion("remain_content in", values, "remainContent");
            return (Criteria) this;
        }

        public Criteria andRemainContentNotIn(List<String> values) {
            addCriterion("remain_content not in", values, "remainContent");
            return (Criteria) this;
        }

        public Criteria andRemainContentBetween(String value1, String value2) {
            addCriterion("remain_content between", value1, value2, "remainContent");
            return (Criteria) this;
        }

        public Criteria andRemainContentNotBetween(String value1, String value2) {
            addCriterion("remain_content not between", value1, value2, "remainContent");
            return (Criteria) this;
        }

        public Criteria andRemainTimeIsNull() {
            addCriterion("remain_time is null");
            return (Criteria) this;
        }

        public Criteria andRemainTimeIsNotNull() {
            addCriterion("remain_time is not null");
            return (Criteria) this;
        }

        public Criteria andRemainTimeEqualTo(String value) {
            addCriterion("remain_time =", value, "remainTime");
            return (Criteria) this;
        }

        public Criteria andRemainTimeNotEqualTo(String value) {
            addCriterion("remain_time <>", value, "remainTime");
            return (Criteria) this;
        }

        public Criteria andRemainTimeGreaterThan(String value) {
            addCriterion("remain_time >", value, "remainTime");
            return (Criteria) this;
        }

        public Criteria andRemainTimeGreaterThanOrEqualTo(String value) {
            addCriterion("remain_time >=", value, "remainTime");
            return (Criteria) this;
        }

        public Criteria andRemainTimeLessThan(String value) {
            addCriterion("remain_time <", value, "remainTime");
            return (Criteria) this;
        }

        public Criteria andRemainTimeLessThanOrEqualTo(String value) {
            addCriterion("remain_time <=", value, "remainTime");
            return (Criteria) this;
        }

        public Criteria andRemainTimeLike(String value) {
            addCriterion("remain_time like", value, "remainTime");
            return (Criteria) this;
        }

        public Criteria andRemainTimeNotLike(String value) {
            addCriterion("remain_time not like", value, "remainTime");
            return (Criteria) this;
        }

        public Criteria andRemainTimeIn(List<String> values) {
            addCriterion("remain_time in", values, "remainTime");
            return (Criteria) this;
        }

        public Criteria andRemainTimeNotIn(List<String> values) {
            addCriterion("remain_time not in", values, "remainTime");
            return (Criteria) this;
        }

        public Criteria andRemainTimeBetween(String value1, String value2) {
            addCriterion("remain_time between", value1, value2, "remainTime");
            return (Criteria) this;
        }

        public Criteria andRemainTimeNotBetween(String value1, String value2) {
            addCriterion("remain_time not between", value1, value2, "remainTime");
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