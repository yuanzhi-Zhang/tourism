package com.yuanzhi.tourism.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CompanyExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CompanyExample() {
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

        public Criteria andCompanyTitleIsNull() {
            addCriterion("company_title is null");
            return (Criteria) this;
        }

        public Criteria andCompanyTitleIsNotNull() {
            addCriterion("company_title is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyTitleEqualTo(String value) {
            addCriterion("company_title =", value, "companyTitle");
            return (Criteria) this;
        }

        public Criteria andCompanyTitleNotEqualTo(String value) {
            addCriterion("company_title <>", value, "companyTitle");
            return (Criteria) this;
        }

        public Criteria andCompanyTitleGreaterThan(String value) {
            addCriterion("company_title >", value, "companyTitle");
            return (Criteria) this;
        }

        public Criteria andCompanyTitleGreaterThanOrEqualTo(String value) {
            addCriterion("company_title >=", value, "companyTitle");
            return (Criteria) this;
        }

        public Criteria andCompanyTitleLessThan(String value) {
            addCriterion("company_title <", value, "companyTitle");
            return (Criteria) this;
        }

        public Criteria andCompanyTitleLessThanOrEqualTo(String value) {
            addCriterion("company_title <=", value, "companyTitle");
            return (Criteria) this;
        }

        public Criteria andCompanyTitleLike(String value) {
            addCriterion("company_title like", value, "companyTitle");
            return (Criteria) this;
        }

        public Criteria andCompanyTitleNotLike(String value) {
            addCriterion("company_title not like", value, "companyTitle");
            return (Criteria) this;
        }

        public Criteria andCompanyTitleIn(List<String> values) {
            addCriterion("company_title in", values, "companyTitle");
            return (Criteria) this;
        }

        public Criteria andCompanyTitleNotIn(List<String> values) {
            addCriterion("company_title not in", values, "companyTitle");
            return (Criteria) this;
        }

        public Criteria andCompanyTitleBetween(String value1, String value2) {
            addCriterion("company_title between", value1, value2, "companyTitle");
            return (Criteria) this;
        }

        public Criteria andCompanyTitleNotBetween(String value1, String value2) {
            addCriterion("company_title not between", value1, value2, "companyTitle");
            return (Criteria) this;
        }

        public Criteria andCompanyStartAreaIsNull() {
            addCriterion("company_start_area is null");
            return (Criteria) this;
        }

        public Criteria andCompanyStartAreaIsNotNull() {
            addCriterion("company_start_area is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyStartAreaEqualTo(String value) {
            addCriterion("company_start_area =", value, "companyStartArea");
            return (Criteria) this;
        }

        public Criteria andCompanyStartAreaNotEqualTo(String value) {
            addCriterion("company_start_area <>", value, "companyStartArea");
            return (Criteria) this;
        }

        public Criteria andCompanyStartAreaGreaterThan(String value) {
            addCriterion("company_start_area >", value, "companyStartArea");
            return (Criteria) this;
        }

        public Criteria andCompanyStartAreaGreaterThanOrEqualTo(String value) {
            addCriterion("company_start_area >=", value, "companyStartArea");
            return (Criteria) this;
        }

        public Criteria andCompanyStartAreaLessThan(String value) {
            addCriterion("company_start_area <", value, "companyStartArea");
            return (Criteria) this;
        }

        public Criteria andCompanyStartAreaLessThanOrEqualTo(String value) {
            addCriterion("company_start_area <=", value, "companyStartArea");
            return (Criteria) this;
        }

        public Criteria andCompanyStartAreaLike(String value) {
            addCriterion("company_start_area like", value, "companyStartArea");
            return (Criteria) this;
        }

        public Criteria andCompanyStartAreaNotLike(String value) {
            addCriterion("company_start_area not like", value, "companyStartArea");
            return (Criteria) this;
        }

        public Criteria andCompanyStartAreaIn(List<String> values) {
            addCriterion("company_start_area in", values, "companyStartArea");
            return (Criteria) this;
        }

        public Criteria andCompanyStartAreaNotIn(List<String> values) {
            addCriterion("company_start_area not in", values, "companyStartArea");
            return (Criteria) this;
        }

        public Criteria andCompanyStartAreaBetween(String value1, String value2) {
            addCriterion("company_start_area between", value1, value2, "companyStartArea");
            return (Criteria) this;
        }

        public Criteria andCompanyStartAreaNotBetween(String value1, String value2) {
            addCriterion("company_start_area not between", value1, value2, "companyStartArea");
            return (Criteria) this;
        }

        public Criteria andCompanyEndAreaIsNull() {
            addCriterion("company_end_area is null");
            return (Criteria) this;
        }

        public Criteria andCompanyEndAreaIsNotNull() {
            addCriterion("company_end_area is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyEndAreaEqualTo(String value) {
            addCriterion("company_end_area =", value, "companyEndArea");
            return (Criteria) this;
        }

        public Criteria andCompanyEndAreaNotEqualTo(String value) {
            addCriterion("company_end_area <>", value, "companyEndArea");
            return (Criteria) this;
        }

        public Criteria andCompanyEndAreaGreaterThan(String value) {
            addCriterion("company_end_area >", value, "companyEndArea");
            return (Criteria) this;
        }

        public Criteria andCompanyEndAreaGreaterThanOrEqualTo(String value) {
            addCriterion("company_end_area >=", value, "companyEndArea");
            return (Criteria) this;
        }

        public Criteria andCompanyEndAreaLessThan(String value) {
            addCriterion("company_end_area <", value, "companyEndArea");
            return (Criteria) this;
        }

        public Criteria andCompanyEndAreaLessThanOrEqualTo(String value) {
            addCriterion("company_end_area <=", value, "companyEndArea");
            return (Criteria) this;
        }

        public Criteria andCompanyEndAreaLike(String value) {
            addCriterion("company_end_area like", value, "companyEndArea");
            return (Criteria) this;
        }

        public Criteria andCompanyEndAreaNotLike(String value) {
            addCriterion("company_end_area not like", value, "companyEndArea");
            return (Criteria) this;
        }

        public Criteria andCompanyEndAreaIn(List<String> values) {
            addCriterion("company_end_area in", values, "companyEndArea");
            return (Criteria) this;
        }

        public Criteria andCompanyEndAreaNotIn(List<String> values) {
            addCriterion("company_end_area not in", values, "companyEndArea");
            return (Criteria) this;
        }

        public Criteria andCompanyEndAreaBetween(String value1, String value2) {
            addCriterion("company_end_area between", value1, value2, "companyEndArea");
            return (Criteria) this;
        }

        public Criteria andCompanyEndAreaNotBetween(String value1, String value2) {
            addCriterion("company_end_area not between", value1, value2, "companyEndArea");
            return (Criteria) this;
        }

        public Criteria andCompanyPeopleNumIsNull() {
            addCriterion("company_people_num is null");
            return (Criteria) this;
        }

        public Criteria andCompanyPeopleNumIsNotNull() {
            addCriterion("company_people_num is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyPeopleNumEqualTo(Integer value) {
            addCriterion("company_people_num =", value, "companyPeopleNum");
            return (Criteria) this;
        }

        public Criteria andCompanyPeopleNumNotEqualTo(Integer value) {
            addCriterion("company_people_num <>", value, "companyPeopleNum");
            return (Criteria) this;
        }

        public Criteria andCompanyPeopleNumGreaterThan(Integer value) {
            addCriterion("company_people_num >", value, "companyPeopleNum");
            return (Criteria) this;
        }

        public Criteria andCompanyPeopleNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("company_people_num >=", value, "companyPeopleNum");
            return (Criteria) this;
        }

        public Criteria andCompanyPeopleNumLessThan(Integer value) {
            addCriterion("company_people_num <", value, "companyPeopleNum");
            return (Criteria) this;
        }

        public Criteria andCompanyPeopleNumLessThanOrEqualTo(Integer value) {
            addCriterion("company_people_num <=", value, "companyPeopleNum");
            return (Criteria) this;
        }

        public Criteria andCompanyPeopleNumIn(List<Integer> values) {
            addCriterion("company_people_num in", values, "companyPeopleNum");
            return (Criteria) this;
        }

        public Criteria andCompanyPeopleNumNotIn(List<Integer> values) {
            addCriterion("company_people_num not in", values, "companyPeopleNum");
            return (Criteria) this;
        }

        public Criteria andCompanyPeopleNumBetween(Integer value1, Integer value2) {
            addCriterion("company_people_num between", value1, value2, "companyPeopleNum");
            return (Criteria) this;
        }

        public Criteria andCompanyPeopleNumNotBetween(Integer value1, Integer value2) {
            addCriterion("company_people_num not between", value1, value2, "companyPeopleNum");
            return (Criteria) this;
        }

        public Criteria andCompanyStartTimeIsNull() {
            addCriterion("company_start_time is null");
            return (Criteria) this;
        }

        public Criteria andCompanyStartTimeIsNotNull() {
            addCriterion("company_start_time is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyStartTimeEqualTo(Date value) {
            addCriterion("company_start_time =", value, "companyStartTime");
            return (Criteria) this;
        }

        public Criteria andCompanyStartTimeNotEqualTo(Date value) {
            addCriterion("company_start_time <>", value, "companyStartTime");
            return (Criteria) this;
        }

        public Criteria andCompanyStartTimeGreaterThan(Date value) {
            addCriterion("company_start_time >", value, "companyStartTime");
            return (Criteria) this;
        }

        public Criteria andCompanyStartTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("company_start_time >=", value, "companyStartTime");
            return (Criteria) this;
        }

        public Criteria andCompanyStartTimeLessThan(Date value) {
            addCriterion("company_start_time <", value, "companyStartTime");
            return (Criteria) this;
        }

        public Criteria andCompanyStartTimeLessThanOrEqualTo(Date value) {
            addCriterion("company_start_time <=", value, "companyStartTime");
            return (Criteria) this;
        }

        public Criteria andCompanyStartTimeIn(List<Date> values) {
            addCriterion("company_start_time in", values, "companyStartTime");
            return (Criteria) this;
        }

        public Criteria andCompanyStartTimeNotIn(List<Date> values) {
            addCriterion("company_start_time not in", values, "companyStartTime");
            return (Criteria) this;
        }

        public Criteria andCompanyStartTimeBetween(Date value1, Date value2) {
            addCriterion("company_start_time between", value1, value2, "companyStartTime");
            return (Criteria) this;
        }

        public Criteria andCompanyStartTimeNotBetween(Date value1, Date value2) {
            addCriterion("company_start_time not between", value1, value2, "companyStartTime");
            return (Criteria) this;
        }

        public Criteria andCompanyDuringTimeIsNull() {
            addCriterion("company_during_time is null");
            return (Criteria) this;
        }

        public Criteria andCompanyDuringTimeIsNotNull() {
            addCriterion("company_during_time is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyDuringTimeEqualTo(String value) {
            addCriterion("company_during_time =", value, "companyDuringTime");
            return (Criteria) this;
        }

        public Criteria andCompanyDuringTimeNotEqualTo(String value) {
            addCriterion("company_during_time <>", value, "companyDuringTime");
            return (Criteria) this;
        }

        public Criteria andCompanyDuringTimeGreaterThan(String value) {
            addCriterion("company_during_time >", value, "companyDuringTime");
            return (Criteria) this;
        }

        public Criteria andCompanyDuringTimeGreaterThanOrEqualTo(String value) {
            addCriterion("company_during_time >=", value, "companyDuringTime");
            return (Criteria) this;
        }

        public Criteria andCompanyDuringTimeLessThan(String value) {
            addCriterion("company_during_time <", value, "companyDuringTime");
            return (Criteria) this;
        }

        public Criteria andCompanyDuringTimeLessThanOrEqualTo(String value) {
            addCriterion("company_during_time <=", value, "companyDuringTime");
            return (Criteria) this;
        }

        public Criteria andCompanyDuringTimeLike(String value) {
            addCriterion("company_during_time like", value, "companyDuringTime");
            return (Criteria) this;
        }

        public Criteria andCompanyDuringTimeNotLike(String value) {
            addCriterion("company_during_time not like", value, "companyDuringTime");
            return (Criteria) this;
        }

        public Criteria andCompanyDuringTimeIn(List<String> values) {
            addCriterion("company_during_time in", values, "companyDuringTime");
            return (Criteria) this;
        }

        public Criteria andCompanyDuringTimeNotIn(List<String> values) {
            addCriterion("company_during_time not in", values, "companyDuringTime");
            return (Criteria) this;
        }

        public Criteria andCompanyDuringTimeBetween(String value1, String value2) {
            addCriterion("company_during_time between", value1, value2, "companyDuringTime");
            return (Criteria) this;
        }

        public Criteria andCompanyDuringTimeNotBetween(String value1, String value2) {
            addCriterion("company_during_time not between", value1, value2, "companyDuringTime");
            return (Criteria) this;
        }

        public Criteria andCompanyOwnerIdIsNull() {
            addCriterion("company_owner_id is null");
            return (Criteria) this;
        }

        public Criteria andCompanyOwnerIdIsNotNull() {
            addCriterion("company_owner_id is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyOwnerIdEqualTo(Integer value) {
            addCriterion("company_owner_id =", value, "companyOwnerId");
            return (Criteria) this;
        }

        public Criteria andCompanyOwnerIdNotEqualTo(Integer value) {
            addCriterion("company_owner_id <>", value, "companyOwnerId");
            return (Criteria) this;
        }

        public Criteria andCompanyOwnerIdGreaterThan(Integer value) {
            addCriterion("company_owner_id >", value, "companyOwnerId");
            return (Criteria) this;
        }

        public Criteria andCompanyOwnerIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("company_owner_id >=", value, "companyOwnerId");
            return (Criteria) this;
        }

        public Criteria andCompanyOwnerIdLessThan(Integer value) {
            addCriterion("company_owner_id <", value, "companyOwnerId");
            return (Criteria) this;
        }

        public Criteria andCompanyOwnerIdLessThanOrEqualTo(Integer value) {
            addCriterion("company_owner_id <=", value, "companyOwnerId");
            return (Criteria) this;
        }

        public Criteria andCompanyOwnerIdIn(List<Integer> values) {
            addCriterion("company_owner_id in", values, "companyOwnerId");
            return (Criteria) this;
        }

        public Criteria andCompanyOwnerIdNotIn(List<Integer> values) {
            addCriterion("company_owner_id not in", values, "companyOwnerId");
            return (Criteria) this;
        }

        public Criteria andCompanyOwnerIdBetween(Integer value1, Integer value2) {
            addCriterion("company_owner_id between", value1, value2, "companyOwnerId");
            return (Criteria) this;
        }

        public Criteria andCompanyOwnerIdNotBetween(Integer value1, Integer value2) {
            addCriterion("company_owner_id not between", value1, value2, "companyOwnerId");
            return (Criteria) this;
        }

        public Criteria andCompanyContentIsNull() {
            addCriterion("company_content is null");
            return (Criteria) this;
        }

        public Criteria andCompanyContentIsNotNull() {
            addCriterion("company_content is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyContentEqualTo(String value) {
            addCriterion("company_content =", value, "companyContent");
            return (Criteria) this;
        }

        public Criteria andCompanyContentNotEqualTo(String value) {
            addCriterion("company_content <>", value, "companyContent");
            return (Criteria) this;
        }

        public Criteria andCompanyContentGreaterThan(String value) {
            addCriterion("company_content >", value, "companyContent");
            return (Criteria) this;
        }

        public Criteria andCompanyContentGreaterThanOrEqualTo(String value) {
            addCriterion("company_content >=", value, "companyContent");
            return (Criteria) this;
        }

        public Criteria andCompanyContentLessThan(String value) {
            addCriterion("company_content <", value, "companyContent");
            return (Criteria) this;
        }

        public Criteria andCompanyContentLessThanOrEqualTo(String value) {
            addCriterion("company_content <=", value, "companyContent");
            return (Criteria) this;
        }

        public Criteria andCompanyContentLike(String value) {
            addCriterion("company_content like", value, "companyContent");
            return (Criteria) this;
        }

        public Criteria andCompanyContentNotLike(String value) {
            addCriterion("company_content not like", value, "companyContent");
            return (Criteria) this;
        }

        public Criteria andCompanyContentIn(List<String> values) {
            addCriterion("company_content in", values, "companyContent");
            return (Criteria) this;
        }

        public Criteria andCompanyContentNotIn(List<String> values) {
            addCriterion("company_content not in", values, "companyContent");
            return (Criteria) this;
        }

        public Criteria andCompanyContentBetween(String value1, String value2) {
            addCriterion("company_content between", value1, value2, "companyContent");
            return (Criteria) this;
        }

        public Criteria andCompanyContentNotBetween(String value1, String value2) {
            addCriterion("company_content not between", value1, value2, "companyContent");
            return (Criteria) this;
        }

        public Criteria andCompanyMainImgIsNull() {
            addCriterion("company_main_img is null");
            return (Criteria) this;
        }

        public Criteria andCompanyMainImgIsNotNull() {
            addCriterion("company_main_img is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyMainImgEqualTo(String value) {
            addCriterion("company_main_img =", value, "companyMainImg");
            return (Criteria) this;
        }

        public Criteria andCompanyMainImgNotEqualTo(String value) {
            addCriterion("company_main_img <>", value, "companyMainImg");
            return (Criteria) this;
        }

        public Criteria andCompanyMainImgGreaterThan(String value) {
            addCriterion("company_main_img >", value, "companyMainImg");
            return (Criteria) this;
        }

        public Criteria andCompanyMainImgGreaterThanOrEqualTo(String value) {
            addCriterion("company_main_img >=", value, "companyMainImg");
            return (Criteria) this;
        }

        public Criteria andCompanyMainImgLessThan(String value) {
            addCriterion("company_main_img <", value, "companyMainImg");
            return (Criteria) this;
        }

        public Criteria andCompanyMainImgLessThanOrEqualTo(String value) {
            addCriterion("company_main_img <=", value, "companyMainImg");
            return (Criteria) this;
        }

        public Criteria andCompanyMainImgLike(String value) {
            addCriterion("company_main_img like", value, "companyMainImg");
            return (Criteria) this;
        }

        public Criteria andCompanyMainImgNotLike(String value) {
            addCriterion("company_main_img not like", value, "companyMainImg");
            return (Criteria) this;
        }

        public Criteria andCompanyMainImgIn(List<String> values) {
            addCriterion("company_main_img in", values, "companyMainImg");
            return (Criteria) this;
        }

        public Criteria andCompanyMainImgNotIn(List<String> values) {
            addCriterion("company_main_img not in", values, "companyMainImg");
            return (Criteria) this;
        }

        public Criteria andCompanyMainImgBetween(String value1, String value2) {
            addCriterion("company_main_img between", value1, value2, "companyMainImg");
            return (Criteria) this;
        }

        public Criteria andCompanyMainImgNotBetween(String value1, String value2) {
            addCriterion("company_main_img not between", value1, value2, "companyMainImg");
            return (Criteria) this;
        }

        public Criteria andCompanyTimeIsNull() {
            addCriterion("company_time is null");
            return (Criteria) this;
        }

        public Criteria andCompanyTimeIsNotNull() {
            addCriterion("company_time is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyTimeEqualTo(String value) {
            addCriterion("company_time =", value, "companyTime");
            return (Criteria) this;
        }

        public Criteria andCompanyTimeNotEqualTo(String value) {
            addCriterion("company_time <>", value, "companyTime");
            return (Criteria) this;
        }

        public Criteria andCompanyTimeGreaterThan(String value) {
            addCriterion("company_time >", value, "companyTime");
            return (Criteria) this;
        }

        public Criteria andCompanyTimeGreaterThanOrEqualTo(String value) {
            addCriterion("company_time >=", value, "companyTime");
            return (Criteria) this;
        }

        public Criteria andCompanyTimeLessThan(String value) {
            addCriterion("company_time <", value, "companyTime");
            return (Criteria) this;
        }

        public Criteria andCompanyTimeLessThanOrEqualTo(String value) {
            addCriterion("company_time <=", value, "companyTime");
            return (Criteria) this;
        }

        public Criteria andCompanyTimeLike(String value) {
            addCriterion("company_time like", value, "companyTime");
            return (Criteria) this;
        }

        public Criteria andCompanyTimeNotLike(String value) {
            addCriterion("company_time not like", value, "companyTime");
            return (Criteria) this;
        }

        public Criteria andCompanyTimeIn(List<String> values) {
            addCriterion("company_time in", values, "companyTime");
            return (Criteria) this;
        }

        public Criteria andCompanyTimeNotIn(List<String> values) {
            addCriterion("company_time not in", values, "companyTime");
            return (Criteria) this;
        }

        public Criteria andCompanyTimeBetween(String value1, String value2) {
            addCriterion("company_time between", value1, value2, "companyTime");
            return (Criteria) this;
        }

        public Criteria andCompanyTimeNotBetween(String value1, String value2) {
            addCriterion("company_time not between", value1, value2, "companyTime");
            return (Criteria) this;
        }

        public Criteria andCompanyAttendNumIsNull() {
            addCriterion("company_attend_num is null");
            return (Criteria) this;
        }

        public Criteria andCompanyAttendNumIsNotNull() {
            addCriterion("company_attend_num is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyAttendNumEqualTo(Integer value) {
            addCriterion("company_attend_num =", value, "companyAttendNum");
            return (Criteria) this;
        }

        public Criteria andCompanyAttendNumNotEqualTo(Integer value) {
            addCriterion("company_attend_num <>", value, "companyAttendNum");
            return (Criteria) this;
        }

        public Criteria andCompanyAttendNumGreaterThan(Integer value) {
            addCriterion("company_attend_num >", value, "companyAttendNum");
            return (Criteria) this;
        }

        public Criteria andCompanyAttendNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("company_attend_num >=", value, "companyAttendNum");
            return (Criteria) this;
        }

        public Criteria andCompanyAttendNumLessThan(Integer value) {
            addCriterion("company_attend_num <", value, "companyAttendNum");
            return (Criteria) this;
        }

        public Criteria andCompanyAttendNumLessThanOrEqualTo(Integer value) {
            addCriterion("company_attend_num <=", value, "companyAttendNum");
            return (Criteria) this;
        }

        public Criteria andCompanyAttendNumIn(List<Integer> values) {
            addCriterion("company_attend_num in", values, "companyAttendNum");
            return (Criteria) this;
        }

        public Criteria andCompanyAttendNumNotIn(List<Integer> values) {
            addCriterion("company_attend_num not in", values, "companyAttendNum");
            return (Criteria) this;
        }

        public Criteria andCompanyAttendNumBetween(Integer value1, Integer value2) {
            addCriterion("company_attend_num between", value1, value2, "companyAttendNum");
            return (Criteria) this;
        }

        public Criteria andCompanyAttendNumNotBetween(Integer value1, Integer value2) {
            addCriterion("company_attend_num not between", value1, value2, "companyAttendNum");
            return (Criteria) this;
        }

        public Criteria andCompanyEnterNumIsNull() {
            addCriterion("company_enter_num is null");
            return (Criteria) this;
        }

        public Criteria andCompanyEnterNumIsNotNull() {
            addCriterion("company_enter_num is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyEnterNumEqualTo(Integer value) {
            addCriterion("company_enter_num =", value, "companyEnterNum");
            return (Criteria) this;
        }

        public Criteria andCompanyEnterNumNotEqualTo(Integer value) {
            addCriterion("company_enter_num <>", value, "companyEnterNum");
            return (Criteria) this;
        }

        public Criteria andCompanyEnterNumGreaterThan(Integer value) {
            addCriterion("company_enter_num >", value, "companyEnterNum");
            return (Criteria) this;
        }

        public Criteria andCompanyEnterNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("company_enter_num >=", value, "companyEnterNum");
            return (Criteria) this;
        }

        public Criteria andCompanyEnterNumLessThan(Integer value) {
            addCriterion("company_enter_num <", value, "companyEnterNum");
            return (Criteria) this;
        }

        public Criteria andCompanyEnterNumLessThanOrEqualTo(Integer value) {
            addCriterion("company_enter_num <=", value, "companyEnterNum");
            return (Criteria) this;
        }

        public Criteria andCompanyEnterNumIn(List<Integer> values) {
            addCriterion("company_enter_num in", values, "companyEnterNum");
            return (Criteria) this;
        }

        public Criteria andCompanyEnterNumNotIn(List<Integer> values) {
            addCriterion("company_enter_num not in", values, "companyEnterNum");
            return (Criteria) this;
        }

        public Criteria andCompanyEnterNumBetween(Integer value1, Integer value2) {
            addCriterion("company_enter_num between", value1, value2, "companyEnterNum");
            return (Criteria) this;
        }

        public Criteria andCompanyEnterNumNotBetween(Integer value1, Integer value2) {
            addCriterion("company_enter_num not between", value1, value2, "companyEnterNum");
            return (Criteria) this;
        }

        public Criteria andCompanyViewNumIsNull() {
            addCriterion("company_view_num is null");
            return (Criteria) this;
        }

        public Criteria andCompanyViewNumIsNotNull() {
            addCriterion("company_view_num is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyViewNumEqualTo(Integer value) {
            addCriterion("company_view_num =", value, "companyViewNum");
            return (Criteria) this;
        }

        public Criteria andCompanyViewNumNotEqualTo(Integer value) {
            addCriterion("company_view_num <>", value, "companyViewNum");
            return (Criteria) this;
        }

        public Criteria andCompanyViewNumGreaterThan(Integer value) {
            addCriterion("company_view_num >", value, "companyViewNum");
            return (Criteria) this;
        }

        public Criteria andCompanyViewNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("company_view_num >=", value, "companyViewNum");
            return (Criteria) this;
        }

        public Criteria andCompanyViewNumLessThan(Integer value) {
            addCriterion("company_view_num <", value, "companyViewNum");
            return (Criteria) this;
        }

        public Criteria andCompanyViewNumLessThanOrEqualTo(Integer value) {
            addCriterion("company_view_num <=", value, "companyViewNum");
            return (Criteria) this;
        }

        public Criteria andCompanyViewNumIn(List<Integer> values) {
            addCriterion("company_view_num in", values, "companyViewNum");
            return (Criteria) this;
        }

        public Criteria andCompanyViewNumNotIn(List<Integer> values) {
            addCriterion("company_view_num not in", values, "companyViewNum");
            return (Criteria) this;
        }

        public Criteria andCompanyViewNumBetween(Integer value1, Integer value2) {
            addCriterion("company_view_num between", value1, value2, "companyViewNum");
            return (Criteria) this;
        }

        public Criteria andCompanyViewNumNotBetween(Integer value1, Integer value2) {
            addCriterion("company_view_num not between", value1, value2, "companyViewNum");
            return (Criteria) this;
        }

        public Criteria andCompanyCommentNumIsNull() {
            addCriterion("company_comment_num is null");
            return (Criteria) this;
        }

        public Criteria andCompanyCommentNumIsNotNull() {
            addCriterion("company_comment_num is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyCommentNumEqualTo(Integer value) {
            addCriterion("company_comment_num =", value, "companyCommentNum");
            return (Criteria) this;
        }

        public Criteria andCompanyCommentNumNotEqualTo(Integer value) {
            addCriterion("company_comment_num <>", value, "companyCommentNum");
            return (Criteria) this;
        }

        public Criteria andCompanyCommentNumGreaterThan(Integer value) {
            addCriterion("company_comment_num >", value, "companyCommentNum");
            return (Criteria) this;
        }

        public Criteria andCompanyCommentNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("company_comment_num >=", value, "companyCommentNum");
            return (Criteria) this;
        }

        public Criteria andCompanyCommentNumLessThan(Integer value) {
            addCriterion("company_comment_num <", value, "companyCommentNum");
            return (Criteria) this;
        }

        public Criteria andCompanyCommentNumLessThanOrEqualTo(Integer value) {
            addCriterion("company_comment_num <=", value, "companyCommentNum");
            return (Criteria) this;
        }

        public Criteria andCompanyCommentNumIn(List<Integer> values) {
            addCriterion("company_comment_num in", values, "companyCommentNum");
            return (Criteria) this;
        }

        public Criteria andCompanyCommentNumNotIn(List<Integer> values) {
            addCriterion("company_comment_num not in", values, "companyCommentNum");
            return (Criteria) this;
        }

        public Criteria andCompanyCommentNumBetween(Integer value1, Integer value2) {
            addCriterion("company_comment_num between", value1, value2, "companyCommentNum");
            return (Criteria) this;
        }

        public Criteria andCompanyCommentNumNotBetween(Integer value1, Integer value2) {
            addCriterion("company_comment_num not between", value1, value2, "companyCommentNum");
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