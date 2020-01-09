package com.yuanzhi.tourism.entity;

import java.util.ArrayList;
import java.util.List;

public class PraiseExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PraiseExample() {
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

        public Criteria andPraiseIdIsNull() {
            addCriterion("praise_id is null");
            return (Criteria) this;
        }

        public Criteria andPraiseIdIsNotNull() {
            addCriterion("praise_id is not null");
            return (Criteria) this;
        }

        public Criteria andPraiseIdEqualTo(Integer value) {
            addCriterion("praise_id =", value, "praiseId");
            return (Criteria) this;
        }

        public Criteria andPraiseIdNotEqualTo(Integer value) {
            addCriterion("praise_id <>", value, "praiseId");
            return (Criteria) this;
        }

        public Criteria andPraiseIdGreaterThan(Integer value) {
            addCriterion("praise_id >", value, "praiseId");
            return (Criteria) this;
        }

        public Criteria andPraiseIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("praise_id >=", value, "praiseId");
            return (Criteria) this;
        }

        public Criteria andPraiseIdLessThan(Integer value) {
            addCriterion("praise_id <", value, "praiseId");
            return (Criteria) this;
        }

        public Criteria andPraiseIdLessThanOrEqualTo(Integer value) {
            addCriterion("praise_id <=", value, "praiseId");
            return (Criteria) this;
        }

        public Criteria andPraiseIdIn(List<Integer> values) {
            addCriterion("praise_id in", values, "praiseId");
            return (Criteria) this;
        }

        public Criteria andPraiseIdNotIn(List<Integer> values) {
            addCriterion("praise_id not in", values, "praiseId");
            return (Criteria) this;
        }

        public Criteria andPraiseIdBetween(Integer value1, Integer value2) {
            addCriterion("praise_id between", value1, value2, "praiseId");
            return (Criteria) this;
        }

        public Criteria andPraiseIdNotBetween(Integer value1, Integer value2) {
            addCriterion("praise_id not between", value1, value2, "praiseId");
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

        public Criteria andPraiseTypeIsNull() {
            addCriterion("praise_type is null");
            return (Criteria) this;
        }

        public Criteria andPraiseTypeIsNotNull() {
            addCriterion("praise_type is not null");
            return (Criteria) this;
        }

        public Criteria andPraiseTypeEqualTo(String value) {
            addCriterion("praise_type =", value, "praiseType");
            return (Criteria) this;
        }

        public Criteria andPraiseTypeNotEqualTo(String value) {
            addCriterion("praise_type <>", value, "praiseType");
            return (Criteria) this;
        }

        public Criteria andPraiseTypeGreaterThan(String value) {
            addCriterion("praise_type >", value, "praiseType");
            return (Criteria) this;
        }

        public Criteria andPraiseTypeGreaterThanOrEqualTo(String value) {
            addCriterion("praise_type >=", value, "praiseType");
            return (Criteria) this;
        }

        public Criteria andPraiseTypeLessThan(String value) {
            addCriterion("praise_type <", value, "praiseType");
            return (Criteria) this;
        }

        public Criteria andPraiseTypeLessThanOrEqualTo(String value) {
            addCriterion("praise_type <=", value, "praiseType");
            return (Criteria) this;
        }

        public Criteria andPraiseTypeLike(String value) {
            addCriterion("praise_type like", value, "praiseType");
            return (Criteria) this;
        }

        public Criteria andPraiseTypeNotLike(String value) {
            addCriterion("praise_type not like", value, "praiseType");
            return (Criteria) this;
        }

        public Criteria andPraiseTypeIn(List<String> values) {
            addCriterion("praise_type in", values, "praiseType");
            return (Criteria) this;
        }

        public Criteria andPraiseTypeNotIn(List<String> values) {
            addCriterion("praise_type not in", values, "praiseType");
            return (Criteria) this;
        }

        public Criteria andPraiseTypeBetween(String value1, String value2) {
            addCriterion("praise_type between", value1, value2, "praiseType");
            return (Criteria) this;
        }

        public Criteria andPraiseTypeNotBetween(String value1, String value2) {
            addCriterion("praise_type not between", value1, value2, "praiseType");
            return (Criteria) this;
        }

        public Criteria andPraiseTypeIdIsNull() {
            addCriterion("praise_type_id is null");
            return (Criteria) this;
        }

        public Criteria andPraiseTypeIdIsNotNull() {
            addCriterion("praise_type_id is not null");
            return (Criteria) this;
        }

        public Criteria andPraiseTypeIdEqualTo(Integer value) {
            addCriterion("praise_type_id =", value, "praiseTypeId");
            return (Criteria) this;
        }

        public Criteria andPraiseTypeIdNotEqualTo(Integer value) {
            addCriterion("praise_type_id <>", value, "praiseTypeId");
            return (Criteria) this;
        }

        public Criteria andPraiseTypeIdGreaterThan(Integer value) {
            addCriterion("praise_type_id >", value, "praiseTypeId");
            return (Criteria) this;
        }

        public Criteria andPraiseTypeIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("praise_type_id >=", value, "praiseTypeId");
            return (Criteria) this;
        }

        public Criteria andPraiseTypeIdLessThan(Integer value) {
            addCriterion("praise_type_id <", value, "praiseTypeId");
            return (Criteria) this;
        }

        public Criteria andPraiseTypeIdLessThanOrEqualTo(Integer value) {
            addCriterion("praise_type_id <=", value, "praiseTypeId");
            return (Criteria) this;
        }

        public Criteria andPraiseTypeIdIn(List<Integer> values) {
            addCriterion("praise_type_id in", values, "praiseTypeId");
            return (Criteria) this;
        }

        public Criteria andPraiseTypeIdNotIn(List<Integer> values) {
            addCriterion("praise_type_id not in", values, "praiseTypeId");
            return (Criteria) this;
        }

        public Criteria andPraiseTypeIdBetween(Integer value1, Integer value2) {
            addCriterion("praise_type_id between", value1, value2, "praiseTypeId");
            return (Criteria) this;
        }

        public Criteria andPraiseTypeIdNotBetween(Integer value1, Integer value2) {
            addCriterion("praise_type_id not between", value1, value2, "praiseTypeId");
            return (Criteria) this;
        }

        public Criteria andPraiseTimeIsNull() {
            addCriterion("praise_time is null");
            return (Criteria) this;
        }

        public Criteria andPraiseTimeIsNotNull() {
            addCriterion("praise_time is not null");
            return (Criteria) this;
        }

        public Criteria andPraiseTimeEqualTo(String value) {
            addCriterion("praise_time =", value, "praiseTime");
            return (Criteria) this;
        }

        public Criteria andPraiseTimeNotEqualTo(String value) {
            addCriterion("praise_time <>", value, "praiseTime");
            return (Criteria) this;
        }

        public Criteria andPraiseTimeGreaterThan(String value) {
            addCriterion("praise_time >", value, "praiseTime");
            return (Criteria) this;
        }

        public Criteria andPraiseTimeGreaterThanOrEqualTo(String value) {
            addCriterion("praise_time >=", value, "praiseTime");
            return (Criteria) this;
        }

        public Criteria andPraiseTimeLessThan(String value) {
            addCriterion("praise_time <", value, "praiseTime");
            return (Criteria) this;
        }

        public Criteria andPraiseTimeLessThanOrEqualTo(String value) {
            addCriterion("praise_time <=", value, "praiseTime");
            return (Criteria) this;
        }

        public Criteria andPraiseTimeLike(String value) {
            addCriterion("praise_time like", value, "praiseTime");
            return (Criteria) this;
        }

        public Criteria andPraiseTimeNotLike(String value) {
            addCriterion("praise_time not like", value, "praiseTime");
            return (Criteria) this;
        }

        public Criteria andPraiseTimeIn(List<String> values) {
            addCriterion("praise_time in", values, "praiseTime");
            return (Criteria) this;
        }

        public Criteria andPraiseTimeNotIn(List<String> values) {
            addCriterion("praise_time not in", values, "praiseTime");
            return (Criteria) this;
        }

        public Criteria andPraiseTimeBetween(String value1, String value2) {
            addCriterion("praise_time between", value1, value2, "praiseTime");
            return (Criteria) this;
        }

        public Criteria andPraiseTimeNotBetween(String value1, String value2) {
            addCriterion("praise_time not between", value1, value2, "praiseTime");
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