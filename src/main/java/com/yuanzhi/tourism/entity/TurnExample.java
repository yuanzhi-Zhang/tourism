package com.yuanzhi.tourism.entity;

import java.util.ArrayList;
import java.util.List;

public class TurnExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TurnExample() {
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

        public Criteria andTurnIdIsNull() {
            addCriterion("turn_id is null");
            return (Criteria) this;
        }

        public Criteria andTurnIdIsNotNull() {
            addCriterion("turn_id is not null");
            return (Criteria) this;
        }

        public Criteria andTurnIdEqualTo(Integer value) {
            addCriterion("turn_id =", value, "turnId");
            return (Criteria) this;
        }

        public Criteria andTurnIdNotEqualTo(Integer value) {
            addCriterion("turn_id <>", value, "turnId");
            return (Criteria) this;
        }

        public Criteria andTurnIdGreaterThan(Integer value) {
            addCriterion("turn_id >", value, "turnId");
            return (Criteria) this;
        }

        public Criteria andTurnIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("turn_id >=", value, "turnId");
            return (Criteria) this;
        }

        public Criteria andTurnIdLessThan(Integer value) {
            addCriterion("turn_id <", value, "turnId");
            return (Criteria) this;
        }

        public Criteria andTurnIdLessThanOrEqualTo(Integer value) {
            addCriterion("turn_id <=", value, "turnId");
            return (Criteria) this;
        }

        public Criteria andTurnIdIn(List<Integer> values) {
            addCriterion("turn_id in", values, "turnId");
            return (Criteria) this;
        }

        public Criteria andTurnIdNotIn(List<Integer> values) {
            addCriterion("turn_id not in", values, "turnId");
            return (Criteria) this;
        }

        public Criteria andTurnIdBetween(Integer value1, Integer value2) {
            addCriterion("turn_id between", value1, value2, "turnId");
            return (Criteria) this;
        }

        public Criteria andTurnIdNotBetween(Integer value1, Integer value2) {
            addCriterion("turn_id not between", value1, value2, "turnId");
            return (Criteria) this;
        }

        public Criteria andTurnUrlIsNull() {
            addCriterion("turn_url is null");
            return (Criteria) this;
        }

        public Criteria andTurnUrlIsNotNull() {
            addCriterion("turn_url is not null");
            return (Criteria) this;
        }

        public Criteria andTurnUrlEqualTo(String value) {
            addCriterion("turn_url =", value, "turnUrl");
            return (Criteria) this;
        }

        public Criteria andTurnUrlNotEqualTo(String value) {
            addCriterion("turn_url <>", value, "turnUrl");
            return (Criteria) this;
        }

        public Criteria andTurnUrlGreaterThan(String value) {
            addCriterion("turn_url >", value, "turnUrl");
            return (Criteria) this;
        }

        public Criteria andTurnUrlGreaterThanOrEqualTo(String value) {
            addCriterion("turn_url >=", value, "turnUrl");
            return (Criteria) this;
        }

        public Criteria andTurnUrlLessThan(String value) {
            addCriterion("turn_url <", value, "turnUrl");
            return (Criteria) this;
        }

        public Criteria andTurnUrlLessThanOrEqualTo(String value) {
            addCriterion("turn_url <=", value, "turnUrl");
            return (Criteria) this;
        }

        public Criteria andTurnUrlLike(String value) {
            addCriterion("turn_url like", value, "turnUrl");
            return (Criteria) this;
        }

        public Criteria andTurnUrlNotLike(String value) {
            addCriterion("turn_url not like", value, "turnUrl");
            return (Criteria) this;
        }

        public Criteria andTurnUrlIn(List<String> values) {
            addCriterion("turn_url in", values, "turnUrl");
            return (Criteria) this;
        }

        public Criteria andTurnUrlNotIn(List<String> values) {
            addCriterion("turn_url not in", values, "turnUrl");
            return (Criteria) this;
        }

        public Criteria andTurnUrlBetween(String value1, String value2) {
            addCriterion("turn_url between", value1, value2, "turnUrl");
            return (Criteria) this;
        }

        public Criteria andTurnUrlNotBetween(String value1, String value2) {
            addCriterion("turn_url not between", value1, value2, "turnUrl");
            return (Criteria) this;
        }

        public Criteria andTurnTypeIsNull() {
            addCriterion("turn_type is null");
            return (Criteria) this;
        }

        public Criteria andTurnTypeIsNotNull() {
            addCriterion("turn_type is not null");
            return (Criteria) this;
        }

        public Criteria andTurnTypeEqualTo(String value) {
            addCriterion("turn_type =", value, "turnType");
            return (Criteria) this;
        }

        public Criteria andTurnTypeNotEqualTo(String value) {
            addCriterion("turn_type <>", value, "turnType");
            return (Criteria) this;
        }

        public Criteria andTurnTypeGreaterThan(String value) {
            addCriterion("turn_type >", value, "turnType");
            return (Criteria) this;
        }

        public Criteria andTurnTypeGreaterThanOrEqualTo(String value) {
            addCriterion("turn_type >=", value, "turnType");
            return (Criteria) this;
        }

        public Criteria andTurnTypeLessThan(String value) {
            addCriterion("turn_type <", value, "turnType");
            return (Criteria) this;
        }

        public Criteria andTurnTypeLessThanOrEqualTo(String value) {
            addCriterion("turn_type <=", value, "turnType");
            return (Criteria) this;
        }

        public Criteria andTurnTypeLike(String value) {
            addCriterion("turn_type like", value, "turnType");
            return (Criteria) this;
        }

        public Criteria andTurnTypeNotLike(String value) {
            addCriterion("turn_type not like", value, "turnType");
            return (Criteria) this;
        }

        public Criteria andTurnTypeIn(List<String> values) {
            addCriterion("turn_type in", values, "turnType");
            return (Criteria) this;
        }

        public Criteria andTurnTypeNotIn(List<String> values) {
            addCriterion("turn_type not in", values, "turnType");
            return (Criteria) this;
        }

        public Criteria andTurnTypeBetween(String value1, String value2) {
            addCriterion("turn_type between", value1, value2, "turnType");
            return (Criteria) this;
        }

        public Criteria andTurnTypeNotBetween(String value1, String value2) {
            addCriterion("turn_type not between", value1, value2, "turnType");
            return (Criteria) this;
        }

        public Criteria andTurnTypeIdIsNull() {
            addCriterion("turn_type_id is null");
            return (Criteria) this;
        }

        public Criteria andTurnTypeIdIsNotNull() {
            addCriterion("turn_type_id is not null");
            return (Criteria) this;
        }

        public Criteria andTurnTypeIdEqualTo(Integer value) {
            addCriterion("turn_type_id =", value, "turnTypeId");
            return (Criteria) this;
        }

        public Criteria andTurnTypeIdNotEqualTo(Integer value) {
            addCriterion("turn_type_id <>", value, "turnTypeId");
            return (Criteria) this;
        }

        public Criteria andTurnTypeIdGreaterThan(Integer value) {
            addCriterion("turn_type_id >", value, "turnTypeId");
            return (Criteria) this;
        }

        public Criteria andTurnTypeIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("turn_type_id >=", value, "turnTypeId");
            return (Criteria) this;
        }

        public Criteria andTurnTypeIdLessThan(Integer value) {
            addCriterion("turn_type_id <", value, "turnTypeId");
            return (Criteria) this;
        }

        public Criteria andTurnTypeIdLessThanOrEqualTo(Integer value) {
            addCriterion("turn_type_id <=", value, "turnTypeId");
            return (Criteria) this;
        }

        public Criteria andTurnTypeIdIn(List<Integer> values) {
            addCriterion("turn_type_id in", values, "turnTypeId");
            return (Criteria) this;
        }

        public Criteria andTurnTypeIdNotIn(List<Integer> values) {
            addCriterion("turn_type_id not in", values, "turnTypeId");
            return (Criteria) this;
        }

        public Criteria andTurnTypeIdBetween(Integer value1, Integer value2) {
            addCriterion("turn_type_id between", value1, value2, "turnTypeId");
            return (Criteria) this;
        }

        public Criteria andTurnTypeIdNotBetween(Integer value1, Integer value2) {
            addCriterion("turn_type_id not between", value1, value2, "turnTypeId");
            return (Criteria) this;
        }

        public Criteria andTurnRemarksIsNull() {
            addCriterion("turn_remarks is null");
            return (Criteria) this;
        }

        public Criteria andTurnRemarksIsNotNull() {
            addCriterion("turn_remarks is not null");
            return (Criteria) this;
        }

        public Criteria andTurnRemarksEqualTo(String value) {
            addCriterion("turn_remarks =", value, "turnRemarks");
            return (Criteria) this;
        }

        public Criteria andTurnRemarksNotEqualTo(String value) {
            addCriterion("turn_remarks <>", value, "turnRemarks");
            return (Criteria) this;
        }

        public Criteria andTurnRemarksGreaterThan(String value) {
            addCriterion("turn_remarks >", value, "turnRemarks");
            return (Criteria) this;
        }

        public Criteria andTurnRemarksGreaterThanOrEqualTo(String value) {
            addCriterion("turn_remarks >=", value, "turnRemarks");
            return (Criteria) this;
        }

        public Criteria andTurnRemarksLessThan(String value) {
            addCriterion("turn_remarks <", value, "turnRemarks");
            return (Criteria) this;
        }

        public Criteria andTurnRemarksLessThanOrEqualTo(String value) {
            addCriterion("turn_remarks <=", value, "turnRemarks");
            return (Criteria) this;
        }

        public Criteria andTurnRemarksLike(String value) {
            addCriterion("turn_remarks like", value, "turnRemarks");
            return (Criteria) this;
        }

        public Criteria andTurnRemarksNotLike(String value) {
            addCriterion("turn_remarks not like", value, "turnRemarks");
            return (Criteria) this;
        }

        public Criteria andTurnRemarksIn(List<String> values) {
            addCriterion("turn_remarks in", values, "turnRemarks");
            return (Criteria) this;
        }

        public Criteria andTurnRemarksNotIn(List<String> values) {
            addCriterion("turn_remarks not in", values, "turnRemarks");
            return (Criteria) this;
        }

        public Criteria andTurnRemarksBetween(String value1, String value2) {
            addCriterion("turn_remarks between", value1, value2, "turnRemarks");
            return (Criteria) this;
        }

        public Criteria andTurnRemarksNotBetween(String value1, String value2) {
            addCriterion("turn_remarks not between", value1, value2, "turnRemarks");
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