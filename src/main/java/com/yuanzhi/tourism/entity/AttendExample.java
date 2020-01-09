package com.yuanzhi.tourism.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AttendExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AttendExample() {
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

        public Criteria andAttendIdIsNull() {
            addCriterion("attend_id is null");
            return (Criteria) this;
        }

        public Criteria andAttendIdIsNotNull() {
            addCriterion("attend_id is not null");
            return (Criteria) this;
        }

        public Criteria andAttendIdEqualTo(Integer value) {
            addCriterion("attend_id =", value, "attendId");
            return (Criteria) this;
        }

        public Criteria andAttendIdNotEqualTo(Integer value) {
            addCriterion("attend_id <>", value, "attendId");
            return (Criteria) this;
        }

        public Criteria andAttendIdGreaterThan(Integer value) {
            addCriterion("attend_id >", value, "attendId");
            return (Criteria) this;
        }

        public Criteria andAttendIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("attend_id >=", value, "attendId");
            return (Criteria) this;
        }

        public Criteria andAttendIdLessThan(Integer value) {
            addCriterion("attend_id <", value, "attendId");
            return (Criteria) this;
        }

        public Criteria andAttendIdLessThanOrEqualTo(Integer value) {
            addCriterion("attend_id <=", value, "attendId");
            return (Criteria) this;
        }

        public Criteria andAttendIdIn(List<Integer> values) {
            addCriterion("attend_id in", values, "attendId");
            return (Criteria) this;
        }

        public Criteria andAttendIdNotIn(List<Integer> values) {
            addCriterion("attend_id not in", values, "attendId");
            return (Criteria) this;
        }

        public Criteria andAttendIdBetween(Integer value1, Integer value2) {
            addCriterion("attend_id between", value1, value2, "attendId");
            return (Criteria) this;
        }

        public Criteria andAttendIdNotBetween(Integer value1, Integer value2) {
            addCriterion("attend_id not between", value1, value2, "attendId");
            return (Criteria) this;
        }

        public Criteria andAttendTypeIsNull() {
            addCriterion("attend_type is null");
            return (Criteria) this;
        }

        public Criteria andAttendTypeIsNotNull() {
            addCriterion("attend_type is not null");
            return (Criteria) this;
        }

        public Criteria andAttendTypeEqualTo(Integer value) {
            addCriterion("attend_type =", value, "attendType");
            return (Criteria) this;
        }

        public Criteria andAttendTypeNotEqualTo(Integer value) {
            addCriterion("attend_type <>", value, "attendType");
            return (Criteria) this;
        }

        public Criteria andAttendTypeGreaterThan(Integer value) {
            addCriterion("attend_type >", value, "attendType");
            return (Criteria) this;
        }

        public Criteria andAttendTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("attend_type >=", value, "attendType");
            return (Criteria) this;
        }

        public Criteria andAttendTypeLessThan(Integer value) {
            addCriterion("attend_type <", value, "attendType");
            return (Criteria) this;
        }

        public Criteria andAttendTypeLessThanOrEqualTo(Integer value) {
            addCriterion("attend_type <=", value, "attendType");
            return (Criteria) this;
        }

        public Criteria andAttendTypeIn(List<Integer> values) {
            addCriterion("attend_type in", values, "attendType");
            return (Criteria) this;
        }

        public Criteria andAttendTypeNotIn(List<Integer> values) {
            addCriterion("attend_type not in", values, "attendType");
            return (Criteria) this;
        }

        public Criteria andAttendTypeBetween(Integer value1, Integer value2) {
            addCriterion("attend_type between", value1, value2, "attendType");
            return (Criteria) this;
        }

        public Criteria andAttendTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("attend_type not between", value1, value2, "attendType");
            return (Criteria) this;
        }

        public Criteria andAttendTypeIdIsNull() {
            addCriterion("attend_type_id is null");
            return (Criteria) this;
        }

        public Criteria andAttendTypeIdIsNotNull() {
            addCriterion("attend_type_id is not null");
            return (Criteria) this;
        }

        public Criteria andAttendTypeIdEqualTo(Integer value) {
            addCriterion("attend_type_id =", value, "attendTypeId");
            return (Criteria) this;
        }

        public Criteria andAttendTypeIdNotEqualTo(Integer value) {
            addCriterion("attend_type_id <>", value, "attendTypeId");
            return (Criteria) this;
        }

        public Criteria andAttendTypeIdGreaterThan(Integer value) {
            addCriterion("attend_type_id >", value, "attendTypeId");
            return (Criteria) this;
        }

        public Criteria andAttendTypeIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("attend_type_id >=", value, "attendTypeId");
            return (Criteria) this;
        }

        public Criteria andAttendTypeIdLessThan(Integer value) {
            addCriterion("attend_type_id <", value, "attendTypeId");
            return (Criteria) this;
        }

        public Criteria andAttendTypeIdLessThanOrEqualTo(Integer value) {
            addCriterion("attend_type_id <=", value, "attendTypeId");
            return (Criteria) this;
        }

        public Criteria andAttendTypeIdIn(List<Integer> values) {
            addCriterion("attend_type_id in", values, "attendTypeId");
            return (Criteria) this;
        }

        public Criteria andAttendTypeIdNotIn(List<Integer> values) {
            addCriterion("attend_type_id not in", values, "attendTypeId");
            return (Criteria) this;
        }

        public Criteria andAttendTypeIdBetween(Integer value1, Integer value2) {
            addCriterion("attend_type_id between", value1, value2, "attendTypeId");
            return (Criteria) this;
        }

        public Criteria andAttendTypeIdNotBetween(Integer value1, Integer value2) {
            addCriterion("attend_type_id not between", value1, value2, "attendTypeId");
            return (Criteria) this;
        }

        public Criteria andAttendUserIdIsNull() {
            addCriterion("attend_user_id is null");
            return (Criteria) this;
        }

        public Criteria andAttendUserIdIsNotNull() {
            addCriterion("attend_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andAttendUserIdEqualTo(Integer value) {
            addCriterion("attend_user_id =", value, "attendUserId");
            return (Criteria) this;
        }

        public Criteria andAttendUserIdNotEqualTo(Integer value) {
            addCriterion("attend_user_id <>", value, "attendUserId");
            return (Criteria) this;
        }

        public Criteria andAttendUserIdGreaterThan(Integer value) {
            addCriterion("attend_user_id >", value, "attendUserId");
            return (Criteria) this;
        }

        public Criteria andAttendUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("attend_user_id >=", value, "attendUserId");
            return (Criteria) this;
        }

        public Criteria andAttendUserIdLessThan(Integer value) {
            addCriterion("attend_user_id <", value, "attendUserId");
            return (Criteria) this;
        }

        public Criteria andAttendUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("attend_user_id <=", value, "attendUserId");
            return (Criteria) this;
        }

        public Criteria andAttendUserIdIn(List<Integer> values) {
            addCriterion("attend_user_id in", values, "attendUserId");
            return (Criteria) this;
        }

        public Criteria andAttendUserIdNotIn(List<Integer> values) {
            addCriterion("attend_user_id not in", values, "attendUserId");
            return (Criteria) this;
        }

        public Criteria andAttendUserIdBetween(Integer value1, Integer value2) {
            addCriterion("attend_user_id between", value1, value2, "attendUserId");
            return (Criteria) this;
        }

        public Criteria andAttendUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("attend_user_id not between", value1, value2, "attendUserId");
            return (Criteria) this;
        }

        public Criteria andAttendTimeIsNull() {
            addCriterion("attend_time is null");
            return (Criteria) this;
        }

        public Criteria andAttendTimeIsNotNull() {
            addCriterion("attend_time is not null");
            return (Criteria) this;
        }

        public Criteria andAttendTimeEqualTo(Date value) {
            addCriterion("attend_time =", value, "attendTime");
            return (Criteria) this;
        }

        public Criteria andAttendTimeNotEqualTo(Date value) {
            addCriterion("attend_time <>", value, "attendTime");
            return (Criteria) this;
        }

        public Criteria andAttendTimeGreaterThan(Date value) {
            addCriterion("attend_time >", value, "attendTime");
            return (Criteria) this;
        }

        public Criteria andAttendTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("attend_time >=", value, "attendTime");
            return (Criteria) this;
        }

        public Criteria andAttendTimeLessThan(Date value) {
            addCriterion("attend_time <", value, "attendTime");
            return (Criteria) this;
        }

        public Criteria andAttendTimeLessThanOrEqualTo(Date value) {
            addCriterion("attend_time <=", value, "attendTime");
            return (Criteria) this;
        }

        public Criteria andAttendTimeIn(List<Date> values) {
            addCriterion("attend_time in", values, "attendTime");
            return (Criteria) this;
        }

        public Criteria andAttendTimeNotIn(List<Date> values) {
            addCriterion("attend_time not in", values, "attendTime");
            return (Criteria) this;
        }

        public Criteria andAttendTimeBetween(Date value1, Date value2) {
            addCriterion("attend_time between", value1, value2, "attendTime");
            return (Criteria) this;
        }

        public Criteria andAttendTimeNotBetween(Date value1, Date value2) {
            addCriterion("attend_time not between", value1, value2, "attendTime");
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