package com.yuanzhi.tourism.entity;

import java.util.ArrayList;
import java.util.List;

public class EnterExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public EnterExample() {
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

        public Criteria andEnterIdIsNull() {
            addCriterion("enter_id is null");
            return (Criteria) this;
        }

        public Criteria andEnterIdIsNotNull() {
            addCriterion("enter_id is not null");
            return (Criteria) this;
        }

        public Criteria andEnterIdEqualTo(Integer value) {
            addCriterion("enter_id =", value, "enterId");
            return (Criteria) this;
        }

        public Criteria andEnterIdNotEqualTo(Integer value) {
            addCriterion("enter_id <>", value, "enterId");
            return (Criteria) this;
        }

        public Criteria andEnterIdGreaterThan(Integer value) {
            addCriterion("enter_id >", value, "enterId");
            return (Criteria) this;
        }

        public Criteria andEnterIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("enter_id >=", value, "enterId");
            return (Criteria) this;
        }

        public Criteria andEnterIdLessThan(Integer value) {
            addCriterion("enter_id <", value, "enterId");
            return (Criteria) this;
        }

        public Criteria andEnterIdLessThanOrEqualTo(Integer value) {
            addCriterion("enter_id <=", value, "enterId");
            return (Criteria) this;
        }

        public Criteria andEnterIdIn(List<Integer> values) {
            addCriterion("enter_id in", values, "enterId");
            return (Criteria) this;
        }

        public Criteria andEnterIdNotIn(List<Integer> values) {
            addCriterion("enter_id not in", values, "enterId");
            return (Criteria) this;
        }

        public Criteria andEnterIdBetween(Integer value1, Integer value2) {
            addCriterion("enter_id between", value1, value2, "enterId");
            return (Criteria) this;
        }

        public Criteria andEnterIdNotBetween(Integer value1, Integer value2) {
            addCriterion("enter_id not between", value1, value2, "enterId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdIsNull() {
            addCriterion("company_id is null");
            return (Criteria) this;
        }

        public Criteria andCompanyIdIsNotNull() {
            addCriterion("company_id is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyIdEqualTo(Integer value) {
            addCriterion("company_id =", value, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdNotEqualTo(Integer value) {
            addCriterion("company_id <>", value, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdGreaterThan(Integer value) {
            addCriterion("company_id >", value, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("company_id >=", value, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdLessThan(Integer value) {
            addCriterion("company_id <", value, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdLessThanOrEqualTo(Integer value) {
            addCriterion("company_id <=", value, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdIn(List<Integer> values) {
            addCriterion("company_id in", values, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdNotIn(List<Integer> values) {
            addCriterion("company_id not in", values, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdBetween(Integer value1, Integer value2) {
            addCriterion("company_id between", value1, value2, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdNotBetween(Integer value1, Integer value2) {
            addCriterion("company_id not between", value1, value2, "companyId");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(Integer value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(Integer value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(Integer value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(Integer value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<Integer> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<Integer> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(Integer value1, Integer value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserPhoneIsNull() {
            addCriterion("user_phone is null");
            return (Criteria) this;
        }

        public Criteria andUserPhoneIsNotNull() {
            addCriterion("user_phone is not null");
            return (Criteria) this;
        }

        public Criteria andUserPhoneEqualTo(String value) {
            addCriterion("user_phone =", value, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneNotEqualTo(String value) {
            addCriterion("user_phone <>", value, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneGreaterThan(String value) {
            addCriterion("user_phone >", value, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("user_phone >=", value, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneLessThan(String value) {
            addCriterion("user_phone <", value, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneLessThanOrEqualTo(String value) {
            addCriterion("user_phone <=", value, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneLike(String value) {
            addCriterion("user_phone like", value, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneNotLike(String value) {
            addCriterion("user_phone not like", value, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneIn(List<String> values) {
            addCriterion("user_phone in", values, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneNotIn(List<String> values) {
            addCriterion("user_phone not in", values, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneBetween(String value1, String value2) {
            addCriterion("user_phone between", value1, value2, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneNotBetween(String value1, String value2) {
            addCriterion("user_phone not between", value1, value2, "userPhone");
            return (Criteria) this;
        }

        public Criteria andEnterTimeIsNull() {
            addCriterion("enter_time is null");
            return (Criteria) this;
        }

        public Criteria andEnterTimeIsNotNull() {
            addCriterion("enter_time is not null");
            return (Criteria) this;
        }

        public Criteria andEnterTimeEqualTo(String value) {
            addCriterion("enter_time =", value, "enterTime");
            return (Criteria) this;
        }

        public Criteria andEnterTimeNotEqualTo(String value) {
            addCriterion("enter_time <>", value, "enterTime");
            return (Criteria) this;
        }

        public Criteria andEnterTimeGreaterThan(String value) {
            addCriterion("enter_time >", value, "enterTime");
            return (Criteria) this;
        }

        public Criteria andEnterTimeGreaterThanOrEqualTo(String value) {
            addCriterion("enter_time >=", value, "enterTime");
            return (Criteria) this;
        }

        public Criteria andEnterTimeLessThan(String value) {
            addCriterion("enter_time <", value, "enterTime");
            return (Criteria) this;
        }

        public Criteria andEnterTimeLessThanOrEqualTo(String value) {
            addCriterion("enter_time <=", value, "enterTime");
            return (Criteria) this;
        }

        public Criteria andEnterTimeLike(String value) {
            addCriterion("enter_time like", value, "enterTime");
            return (Criteria) this;
        }

        public Criteria andEnterTimeNotLike(String value) {
            addCriterion("enter_time not like", value, "enterTime");
            return (Criteria) this;
        }

        public Criteria andEnterTimeIn(List<String> values) {
            addCriterion("enter_time in", values, "enterTime");
            return (Criteria) this;
        }

        public Criteria andEnterTimeNotIn(List<String> values) {
            addCriterion("enter_time not in", values, "enterTime");
            return (Criteria) this;
        }

        public Criteria andEnterTimeBetween(String value1, String value2) {
            addCriterion("enter_time between", value1, value2, "enterTime");
            return (Criteria) this;
        }

        public Criteria andEnterTimeNotBetween(String value1, String value2) {
            addCriterion("enter_time not between", value1, value2, "enterTime");
            return (Criteria) this;
        }

        public Criteria andEnterRemarksIsNull() {
            addCriterion("enter_remarks is null");
            return (Criteria) this;
        }

        public Criteria andEnterRemarksIsNotNull() {
            addCriterion("enter_remarks is not null");
            return (Criteria) this;
        }

        public Criteria andEnterRemarksEqualTo(String value) {
            addCriterion("enter_remarks =", value, "enterRemarks");
            return (Criteria) this;
        }

        public Criteria andEnterRemarksNotEqualTo(String value) {
            addCriterion("enter_remarks <>", value, "enterRemarks");
            return (Criteria) this;
        }

        public Criteria andEnterRemarksGreaterThan(String value) {
            addCriterion("enter_remarks >", value, "enterRemarks");
            return (Criteria) this;
        }

        public Criteria andEnterRemarksGreaterThanOrEqualTo(String value) {
            addCriterion("enter_remarks >=", value, "enterRemarks");
            return (Criteria) this;
        }

        public Criteria andEnterRemarksLessThan(String value) {
            addCriterion("enter_remarks <", value, "enterRemarks");
            return (Criteria) this;
        }

        public Criteria andEnterRemarksLessThanOrEqualTo(String value) {
            addCriterion("enter_remarks <=", value, "enterRemarks");
            return (Criteria) this;
        }

        public Criteria andEnterRemarksLike(String value) {
            addCriterion("enter_remarks like", value, "enterRemarks");
            return (Criteria) this;
        }

        public Criteria andEnterRemarksNotLike(String value) {
            addCriterion("enter_remarks not like", value, "enterRemarks");
            return (Criteria) this;
        }

        public Criteria andEnterRemarksIn(List<String> values) {
            addCriterion("enter_remarks in", values, "enterRemarks");
            return (Criteria) this;
        }

        public Criteria andEnterRemarksNotIn(List<String> values) {
            addCriterion("enter_remarks not in", values, "enterRemarks");
            return (Criteria) this;
        }

        public Criteria andEnterRemarksBetween(String value1, String value2) {
            addCriterion("enter_remarks between", value1, value2, "enterRemarks");
            return (Criteria) this;
        }

        public Criteria andEnterRemarksNotBetween(String value1, String value2) {
            addCriterion("enter_remarks not between", value1, value2, "enterRemarks");
            return (Criteria) this;
        }

        public Criteria andCompanyMaleNumIsNull() {
            addCriterion("company_male_num is null");
            return (Criteria) this;
        }

        public Criteria andCompanyMaleNumIsNotNull() {
            addCriterion("company_male_num is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyMaleNumEqualTo(Integer value) {
            addCriterion("company_male_num =", value, "companyMaleNum");
            return (Criteria) this;
        }

        public Criteria andCompanyMaleNumNotEqualTo(Integer value) {
            addCriterion("company_male_num <>", value, "companyMaleNum");
            return (Criteria) this;
        }

        public Criteria andCompanyMaleNumGreaterThan(Integer value) {
            addCriterion("company_male_num >", value, "companyMaleNum");
            return (Criteria) this;
        }

        public Criteria andCompanyMaleNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("company_male_num >=", value, "companyMaleNum");
            return (Criteria) this;
        }

        public Criteria andCompanyMaleNumLessThan(Integer value) {
            addCriterion("company_male_num <", value, "companyMaleNum");
            return (Criteria) this;
        }

        public Criteria andCompanyMaleNumLessThanOrEqualTo(Integer value) {
            addCriterion("company_male_num <=", value, "companyMaleNum");
            return (Criteria) this;
        }

        public Criteria andCompanyMaleNumIn(List<Integer> values) {
            addCriterion("company_male_num in", values, "companyMaleNum");
            return (Criteria) this;
        }

        public Criteria andCompanyMaleNumNotIn(List<Integer> values) {
            addCriterion("company_male_num not in", values, "companyMaleNum");
            return (Criteria) this;
        }

        public Criteria andCompanyMaleNumBetween(Integer value1, Integer value2) {
            addCriterion("company_male_num between", value1, value2, "companyMaleNum");
            return (Criteria) this;
        }

        public Criteria andCompanyMaleNumNotBetween(Integer value1, Integer value2) {
            addCriterion("company_male_num not between", value1, value2, "companyMaleNum");
            return (Criteria) this;
        }

        public Criteria andCompanyFemaleNumIsNull() {
            addCriterion("company_female_num is null");
            return (Criteria) this;
        }

        public Criteria andCompanyFemaleNumIsNotNull() {
            addCriterion("company_female_num is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyFemaleNumEqualTo(Integer value) {
            addCriterion("company_female_num =", value, "companyFemaleNum");
            return (Criteria) this;
        }

        public Criteria andCompanyFemaleNumNotEqualTo(Integer value) {
            addCriterion("company_female_num <>", value, "companyFemaleNum");
            return (Criteria) this;
        }

        public Criteria andCompanyFemaleNumGreaterThan(Integer value) {
            addCriterion("company_female_num >", value, "companyFemaleNum");
            return (Criteria) this;
        }

        public Criteria andCompanyFemaleNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("company_female_num >=", value, "companyFemaleNum");
            return (Criteria) this;
        }

        public Criteria andCompanyFemaleNumLessThan(Integer value) {
            addCriterion("company_female_num <", value, "companyFemaleNum");
            return (Criteria) this;
        }

        public Criteria andCompanyFemaleNumLessThanOrEqualTo(Integer value) {
            addCriterion("company_female_num <=", value, "companyFemaleNum");
            return (Criteria) this;
        }

        public Criteria andCompanyFemaleNumIn(List<Integer> values) {
            addCriterion("company_female_num in", values, "companyFemaleNum");
            return (Criteria) this;
        }

        public Criteria andCompanyFemaleNumNotIn(List<Integer> values) {
            addCriterion("company_female_num not in", values, "companyFemaleNum");
            return (Criteria) this;
        }

        public Criteria andCompanyFemaleNumBetween(Integer value1, Integer value2) {
            addCriterion("company_female_num between", value1, value2, "companyFemaleNum");
            return (Criteria) this;
        }

        public Criteria andCompanyFemaleNumNotBetween(Integer value1, Integer value2) {
            addCriterion("company_female_num not between", value1, value2, "companyFemaleNum");
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