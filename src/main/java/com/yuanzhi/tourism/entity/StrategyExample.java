package com.yuanzhi.tourism.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class StrategyExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public StrategyExample() {
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
        }

        public Criteria andStrategyIdIsNull() {
            addCriterion("strategy_id is null");
            return (Criteria) this;
        }

        public Criteria andStrategyIdIsNotNull() {
            addCriterion("strategy_id is not null");
            return (Criteria) this;
        }

        public Criteria andStrategyIdEqualTo(Integer value) {
            addCriterion("strategy_id =", value, "strategyId");
            return (Criteria) this;
        }

        public Criteria andStrategyIdNotEqualTo(Integer value) {
            addCriterion("strategy_id <>", value, "strategyId");
            return (Criteria) this;
        }

        public Criteria andStrategyIdGreaterThan(Integer value) {
            addCriterion("strategy_id >", value, "strategyId");
            return (Criteria) this;
        }

        public Criteria andStrategyIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("strategy_id >=", value, "strategyId");
            return (Criteria) this;
        }

        public Criteria andStrategyIdLessThan(Integer value) {
            addCriterion("strategy_id <", value, "strategyId");
            return (Criteria) this;
        }

        public Criteria andStrategyIdLessThanOrEqualTo(Integer value) {
            addCriterion("strategy_id <=", value, "strategyId");
            return (Criteria) this;
        }

        public Criteria andStrategyIdIn(List<Integer> values) {
            addCriterion("strategy_id in", values, "strategyId");
            return (Criteria) this;
        }

        public Criteria andStrategyIdNotIn(List<Integer> values) {
            addCriterion("strategy_id not in", values, "strategyId");
            return (Criteria) this;
        }

        public Criteria andStrategyIdBetween(Integer value1, Integer value2) {
            addCriterion("strategy_id between", value1, value2, "strategyId");
            return (Criteria) this;
        }

        public Criteria andStrategyIdNotBetween(Integer value1, Integer value2) {
            addCriterion("strategy_id not between", value1, value2, "strategyId");
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

        public Criteria andPublishTimeIsNull() {
            addCriterion("publish_time is null");
            return (Criteria) this;
        }

        public Criteria andPublishTimeIsNotNull() {
            addCriterion("publish_time is not null");
            return (Criteria) this;
        }

        public Criteria andPublishTimeEqualTo(Date value) {
            addCriterionForJDBCDate("publish_time =", value, "publishTime");
            return (Criteria) this;
        }

        public Criteria andPublishTimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("publish_time <>", value, "publishTime");
            return (Criteria) this;
        }

        public Criteria andPublishTimeGreaterThan(Date value) {
            addCriterionForJDBCDate("publish_time >", value, "publishTime");
            return (Criteria) this;
        }

        public Criteria andPublishTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("publish_time >=", value, "publishTime");
            return (Criteria) this;
        }

        public Criteria andPublishTimeLessThan(Date value) {
            addCriterionForJDBCDate("publish_time <", value, "publishTime");
            return (Criteria) this;
        }

        public Criteria andPublishTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("publish_time <=", value, "publishTime");
            return (Criteria) this;
        }

        public Criteria andPublishTimeIn(List<Date> values) {
            addCriterionForJDBCDate("publish_time in", values, "publishTime");
            return (Criteria) this;
        }

        public Criteria andPublishTimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("publish_time not in", values, "publishTime");
            return (Criteria) this;
        }

        public Criteria andPublishTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("publish_time between", value1, value2, "publishTime");
            return (Criteria) this;
        }

        public Criteria andPublishTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("publish_time not between", value1, value2, "publishTime");
            return (Criteria) this;
        }

        public Criteria andFirstImgIsNull() {
            addCriterion("first_img is null");
            return (Criteria) this;
        }

        public Criteria andFirstImgIsNotNull() {
            addCriterion("first_img is not null");
            return (Criteria) this;
        }

        public Criteria andFirstImgEqualTo(String value) {
            addCriterion("first_img =", value, "firstImg");
            return (Criteria) this;
        }

        public Criteria andFirstImgNotEqualTo(String value) {
            addCriterion("first_img <>", value, "firstImg");
            return (Criteria) this;
        }

        public Criteria andFirstImgGreaterThan(String value) {
            addCriterion("first_img >", value, "firstImg");
            return (Criteria) this;
        }

        public Criteria andFirstImgGreaterThanOrEqualTo(String value) {
            addCriterion("first_img >=", value, "firstImg");
            return (Criteria) this;
        }

        public Criteria andFirstImgLessThan(String value) {
            addCriterion("first_img <", value, "firstImg");
            return (Criteria) this;
        }

        public Criteria andFirstImgLessThanOrEqualTo(String value) {
            addCriterion("first_img <=", value, "firstImg");
            return (Criteria) this;
        }

        public Criteria andFirstImgLike(String value) {
            addCriterion("first_img like", value, "firstImg");
            return (Criteria) this;
        }

        public Criteria andFirstImgNotLike(String value) {
            addCriterion("first_img not like", value, "firstImg");
            return (Criteria) this;
        }

        public Criteria andFirstImgIn(List<String> values) {
            addCriterion("first_img in", values, "firstImg");
            return (Criteria) this;
        }

        public Criteria andFirstImgNotIn(List<String> values) {
            addCriterion("first_img not in", values, "firstImg");
            return (Criteria) this;
        }

        public Criteria andFirstImgBetween(String value1, String value2) {
            addCriterion("first_img between", value1, value2, "firstImg");
            return (Criteria) this;
        }

        public Criteria andFirstImgNotBetween(String value1, String value2) {
            addCriterion("first_img not between", value1, value2, "firstImg");
            return (Criteria) this;
        }

        public Criteria andSecondImgIsNull() {
            addCriterion("second_img is null");
            return (Criteria) this;
        }

        public Criteria andSecondImgIsNotNull() {
            addCriterion("second_img is not null");
            return (Criteria) this;
        }

        public Criteria andSecondImgEqualTo(String value) {
            addCriterion("second_img =", value, "secondImg");
            return (Criteria) this;
        }

        public Criteria andSecondImgNotEqualTo(String value) {
            addCriterion("second_img <>", value, "secondImg");
            return (Criteria) this;
        }

        public Criteria andSecondImgGreaterThan(String value) {
            addCriterion("second_img >", value, "secondImg");
            return (Criteria) this;
        }

        public Criteria andSecondImgGreaterThanOrEqualTo(String value) {
            addCriterion("second_img >=", value, "secondImg");
            return (Criteria) this;
        }

        public Criteria andSecondImgLessThan(String value) {
            addCriterion("second_img <", value, "secondImg");
            return (Criteria) this;
        }

        public Criteria andSecondImgLessThanOrEqualTo(String value) {
            addCriterion("second_img <=", value, "secondImg");
            return (Criteria) this;
        }

        public Criteria andSecondImgLike(String value) {
            addCriterion("second_img like", value, "secondImg");
            return (Criteria) this;
        }

        public Criteria andSecondImgNotLike(String value) {
            addCriterion("second_img not like", value, "secondImg");
            return (Criteria) this;
        }

        public Criteria andSecondImgIn(List<String> values) {
            addCriterion("second_img in", values, "secondImg");
            return (Criteria) this;
        }

        public Criteria andSecondImgNotIn(List<String> values) {
            addCriterion("second_img not in", values, "secondImg");
            return (Criteria) this;
        }

        public Criteria andSecondImgBetween(String value1, String value2) {
            addCriterion("second_img between", value1, value2, "secondImg");
            return (Criteria) this;
        }

        public Criteria andSecondImgNotBetween(String value1, String value2) {
            addCriterion("second_img not between", value1, value2, "secondImg");
            return (Criteria) this;
        }

        public Criteria andThirdImgIsNull() {
            addCriterion("third_img is null");
            return (Criteria) this;
        }

        public Criteria andThirdImgIsNotNull() {
            addCriterion("third_img is not null");
            return (Criteria) this;
        }

        public Criteria andThirdImgEqualTo(String value) {
            addCriterion("third_img =", value, "thirdImg");
            return (Criteria) this;
        }

        public Criteria andThirdImgNotEqualTo(String value) {
            addCriterion("third_img <>", value, "thirdImg");
            return (Criteria) this;
        }

        public Criteria andThirdImgGreaterThan(String value) {
            addCriterion("third_img >", value, "thirdImg");
            return (Criteria) this;
        }

        public Criteria andThirdImgGreaterThanOrEqualTo(String value) {
            addCriterion("third_img >=", value, "thirdImg");
            return (Criteria) this;
        }

        public Criteria andThirdImgLessThan(String value) {
            addCriterion("third_img <", value, "thirdImg");
            return (Criteria) this;
        }

        public Criteria andThirdImgLessThanOrEqualTo(String value) {
            addCriterion("third_img <=", value, "thirdImg");
            return (Criteria) this;
        }

        public Criteria andThirdImgLike(String value) {
            addCriterion("third_img like", value, "thirdImg");
            return (Criteria) this;
        }

        public Criteria andThirdImgNotLike(String value) {
            addCriterion("third_img not like", value, "thirdImg");
            return (Criteria) this;
        }

        public Criteria andThirdImgIn(List<String> values) {
            addCriterion("third_img in", values, "thirdImg");
            return (Criteria) this;
        }

        public Criteria andThirdImgNotIn(List<String> values) {
            addCriterion("third_img not in", values, "thirdImg");
            return (Criteria) this;
        }

        public Criteria andThirdImgBetween(String value1, String value2) {
            addCriterion("third_img between", value1, value2, "thirdImg");
            return (Criteria) this;
        }

        public Criteria andThirdImgNotBetween(String value1, String value2) {
            addCriterion("third_img not between", value1, value2, "thirdImg");
            return (Criteria) this;
        }

        public Criteria andStrategyTitleIsNull() {
            addCriterion("strategy_title is null");
            return (Criteria) this;
        }

        public Criteria andStrategyTitleIsNotNull() {
            addCriterion("strategy_title is not null");
            return (Criteria) this;
        }

        public Criteria andStrategyTitleEqualTo(String value) {
            addCriterion("strategy_title =", value, "strategyTitle");
            return (Criteria) this;
        }

        public Criteria andStrategyTitleNotEqualTo(String value) {
            addCriterion("strategy_title <>", value, "strategyTitle");
            return (Criteria) this;
        }

        public Criteria andStrategyTitleGreaterThan(String value) {
            addCriterion("strategy_title >", value, "strategyTitle");
            return (Criteria) this;
        }

        public Criteria andStrategyTitleGreaterThanOrEqualTo(String value) {
            addCriterion("strategy_title >=", value, "strategyTitle");
            return (Criteria) this;
        }

        public Criteria andStrategyTitleLessThan(String value) {
            addCriterion("strategy_title <", value, "strategyTitle");
            return (Criteria) this;
        }

        public Criteria andStrategyTitleLessThanOrEqualTo(String value) {
            addCriterion("strategy_title <=", value, "strategyTitle");
            return (Criteria) this;
        }

        public Criteria andStrategyTitleLike(String value) {
            addCriterion("strategy_title like", value, "strategyTitle");
            return (Criteria) this;
        }

        public Criteria andStrategyTitleNotLike(String value) {
            addCriterion("strategy_title not like", value, "strategyTitle");
            return (Criteria) this;
        }

        public Criteria andStrategyTitleIn(List<String> values) {
            addCriterion("strategy_title in", values, "strategyTitle");
            return (Criteria) this;
        }

        public Criteria andStrategyTitleNotIn(List<String> values) {
            addCriterion("strategy_title not in", values, "strategyTitle");
            return (Criteria) this;
        }

        public Criteria andStrategyTitleBetween(String value1, String value2) {
            addCriterion("strategy_title between", value1, value2, "strategyTitle");
            return (Criteria) this;
        }

        public Criteria andStrategyTitleNotBetween(String value1, String value2) {
            addCriterion("strategy_title not between", value1, value2, "strategyTitle");
            return (Criteria) this;
        }

        public Criteria andStrategyIntroIsNull() {
            addCriterion("strategy_intro is null");
            return (Criteria) this;
        }

        public Criteria andStrategyIntroIsNotNull() {
            addCriterion("strategy_intro is not null");
            return (Criteria) this;
        }

        public Criteria andStrategyIntroEqualTo(String value) {
            addCriterion("strategy_intro =", value, "strategyIntro");
            return (Criteria) this;
        }

        public Criteria andStrategyIntroNotEqualTo(String value) {
            addCriterion("strategy_intro <>", value, "strategyIntro");
            return (Criteria) this;
        }

        public Criteria andStrategyIntroGreaterThan(String value) {
            addCriterion("strategy_intro >", value, "strategyIntro");
            return (Criteria) this;
        }

        public Criteria andStrategyIntroGreaterThanOrEqualTo(String value) {
            addCriterion("strategy_intro >=", value, "strategyIntro");
            return (Criteria) this;
        }

        public Criteria andStrategyIntroLessThan(String value) {
            addCriterion("strategy_intro <", value, "strategyIntro");
            return (Criteria) this;
        }

        public Criteria andStrategyIntroLessThanOrEqualTo(String value) {
            addCriterion("strategy_intro <=", value, "strategyIntro");
            return (Criteria) this;
        }

        public Criteria andStrategyIntroLike(String value) {
            addCriterion("strategy_intro like", value, "strategyIntro");
            return (Criteria) this;
        }

        public Criteria andStrategyIntroNotLike(String value) {
            addCriterion("strategy_intro not like", value, "strategyIntro");
            return (Criteria) this;
        }

        public Criteria andStrategyIntroIn(List<String> values) {
            addCriterion("strategy_intro in", values, "strategyIntro");
            return (Criteria) this;
        }

        public Criteria andStrategyIntroNotIn(List<String> values) {
            addCriterion("strategy_intro not in", values, "strategyIntro");
            return (Criteria) this;
        }

        public Criteria andStrategyIntroBetween(String value1, String value2) {
            addCriterion("strategy_intro between", value1, value2, "strategyIntro");
            return (Criteria) this;
        }

        public Criteria andStrategyIntroNotBetween(String value1, String value2) {
            addCriterion("strategy_intro not between", value1, value2, "strategyIntro");
            return (Criteria) this;
        }

        public Criteria andStrategyContentIsNull() {
            addCriterion("strategy_content is null");
            return (Criteria) this;
        }

        public Criteria andStrategyContentIsNotNull() {
            addCriterion("strategy_content is not null");
            return (Criteria) this;
        }

        public Criteria andStrategyContentEqualTo(String value) {
            addCriterion("strategy_content =", value, "strategyContent");
            return (Criteria) this;
        }

        public Criteria andStrategyContentNotEqualTo(String value) {
            addCriterion("strategy_content <>", value, "strategyContent");
            return (Criteria) this;
        }

        public Criteria andStrategyContentGreaterThan(String value) {
            addCriterion("strategy_content >", value, "strategyContent");
            return (Criteria) this;
        }

        public Criteria andStrategyContentGreaterThanOrEqualTo(String value) {
            addCriterion("strategy_content >=", value, "strategyContent");
            return (Criteria) this;
        }

        public Criteria andStrategyContentLessThan(String value) {
            addCriterion("strategy_content <", value, "strategyContent");
            return (Criteria) this;
        }

        public Criteria andStrategyContentLessThanOrEqualTo(String value) {
            addCriterion("strategy_content <=", value, "strategyContent");
            return (Criteria) this;
        }

        public Criteria andStrategyContentLike(String value) {
            addCriterion("strategy_content like", value, "strategyContent");
            return (Criteria) this;
        }

        public Criteria andStrategyContentNotLike(String value) {
            addCriterion("strategy_content not like", value, "strategyContent");
            return (Criteria) this;
        }

        public Criteria andStrategyContentIn(List<String> values) {
            addCriterion("strategy_content in", values, "strategyContent");
            return (Criteria) this;
        }

        public Criteria andStrategyContentNotIn(List<String> values) {
            addCriterion("strategy_content not in", values, "strategyContent");
            return (Criteria) this;
        }

        public Criteria andStrategyContentBetween(String value1, String value2) {
            addCriterion("strategy_content between", value1, value2, "strategyContent");
            return (Criteria) this;
        }

        public Criteria andStrategyContentNotBetween(String value1, String value2) {
            addCriterion("strategy_content not between", value1, value2, "strategyContent");
            return (Criteria) this;
        }

        public Criteria andReadTimesIsNull() {
            addCriterion("read_times is null");
            return (Criteria) this;
        }

        public Criteria andReadTimesIsNotNull() {
            addCriterion("read_times is not null");
            return (Criteria) this;
        }

        public Criteria andReadTimesEqualTo(Integer value) {
            addCriterion("read_times =", value, "readTimes");
            return (Criteria) this;
        }

        public Criteria andReadTimesNotEqualTo(Integer value) {
            addCriterion("read_times <>", value, "readTimes");
            return (Criteria) this;
        }

        public Criteria andReadTimesGreaterThan(Integer value) {
            addCriterion("read_times >", value, "readTimes");
            return (Criteria) this;
        }

        public Criteria andReadTimesGreaterThanOrEqualTo(Integer value) {
            addCriterion("read_times >=", value, "readTimes");
            return (Criteria) this;
        }

        public Criteria andReadTimesLessThan(Integer value) {
            addCriterion("read_times <", value, "readTimes");
            return (Criteria) this;
        }

        public Criteria andReadTimesLessThanOrEqualTo(Integer value) {
            addCriterion("read_times <=", value, "readTimes");
            return (Criteria) this;
        }

        public Criteria andReadTimesIn(List<Integer> values) {
            addCriterion("read_times in", values, "readTimes");
            return (Criteria) this;
        }

        public Criteria andReadTimesNotIn(List<Integer> values) {
            addCriterion("read_times not in", values, "readTimes");
            return (Criteria) this;
        }

        public Criteria andReadTimesBetween(Integer value1, Integer value2) {
            addCriterion("read_times between", value1, value2, "readTimes");
            return (Criteria) this;
        }

        public Criteria andReadTimesNotBetween(Integer value1, Integer value2) {
            addCriterion("read_times not between", value1, value2, "readTimes");
            return (Criteria) this;
        }

        public Criteria andPraiseTimesIsNull() {
            addCriterion("praise_times is null");
            return (Criteria) this;
        }

        public Criteria andPraiseTimesIsNotNull() {
            addCriterion("praise_times is not null");
            return (Criteria) this;
        }

        public Criteria andPraiseTimesEqualTo(Integer value) {
            addCriterion("praise_times =", value, "praiseTimes");
            return (Criteria) this;
        }

        public Criteria andPraiseTimesNotEqualTo(Integer value) {
            addCriterion("praise_times <>", value, "praiseTimes");
            return (Criteria) this;
        }

        public Criteria andPraiseTimesGreaterThan(Integer value) {
            addCriterion("praise_times >", value, "praiseTimes");
            return (Criteria) this;
        }

        public Criteria andPraiseTimesGreaterThanOrEqualTo(Integer value) {
            addCriterion("praise_times >=", value, "praiseTimes");
            return (Criteria) this;
        }

        public Criteria andPraiseTimesLessThan(Integer value) {
            addCriterion("praise_times <", value, "praiseTimes");
            return (Criteria) this;
        }

        public Criteria andPraiseTimesLessThanOrEqualTo(Integer value) {
            addCriterion("praise_times <=", value, "praiseTimes");
            return (Criteria) this;
        }

        public Criteria andPraiseTimesIn(List<Integer> values) {
            addCriterion("praise_times in", values, "praiseTimes");
            return (Criteria) this;
        }

        public Criteria andPraiseTimesNotIn(List<Integer> values) {
            addCriterion("praise_times not in", values, "praiseTimes");
            return (Criteria) this;
        }

        public Criteria andPraiseTimesBetween(Integer value1, Integer value2) {
            addCriterion("praise_times between", value1, value2, "praiseTimes");
            return (Criteria) this;
        }

        public Criteria andPraiseTimesNotBetween(Integer value1, Integer value2) {
            addCriterion("praise_times not between", value1, value2, "praiseTimes");
            return (Criteria) this;
        }

        public Criteria andCommentNumIsNull() {
            addCriterion("comment_num is null");
            return (Criteria) this;
        }

        public Criteria andCommentNumIsNotNull() {
            addCriterion("comment_num is not null");
            return (Criteria) this;
        }

        public Criteria andCommentNumEqualTo(Integer value) {
            addCriterion("comment_num =", value, "commentNum");
            return (Criteria) this;
        }

        public Criteria andCommentNumNotEqualTo(Integer value) {
            addCriterion("comment_num <>", value, "commentNum");
            return (Criteria) this;
        }

        public Criteria andCommentNumGreaterThan(Integer value) {
            addCriterion("comment_num >", value, "commentNum");
            return (Criteria) this;
        }

        public Criteria andCommentNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("comment_num >=", value, "commentNum");
            return (Criteria) this;
        }

        public Criteria andCommentNumLessThan(Integer value) {
            addCriterion("comment_num <", value, "commentNum");
            return (Criteria) this;
        }

        public Criteria andCommentNumLessThanOrEqualTo(Integer value) {
            addCriterion("comment_num <=", value, "commentNum");
            return (Criteria) this;
        }

        public Criteria andCommentNumIn(List<Integer> values) {
            addCriterion("comment_num in", values, "commentNum");
            return (Criteria) this;
        }

        public Criteria andCommentNumNotIn(List<Integer> values) {
            addCriterion("comment_num not in", values, "commentNum");
            return (Criteria) this;
        }

        public Criteria andCommentNumBetween(Integer value1, Integer value2) {
            addCriterion("comment_num between", value1, value2, "commentNum");
            return (Criteria) this;
        }

        public Criteria andCommentNumNotBetween(Integer value1, Integer value2) {
            addCriterion("comment_num not between", value1, value2, "commentNum");
            return (Criteria) this;
        }

        public Criteria andCollectNumIsNull() {
            addCriterion("collect_num is null");
            return (Criteria) this;
        }

        public Criteria andCollectNumIsNotNull() {
            addCriterion("collect_num is not null");
            return (Criteria) this;
        }

        public Criteria andCollectNumEqualTo(Integer value) {
            addCriterion("collect_num =", value, "collectNum");
            return (Criteria) this;
        }

        public Criteria andCollectNumNotEqualTo(Integer value) {
            addCriterion("collect_num <>", value, "collectNum");
            return (Criteria) this;
        }

        public Criteria andCollectNumGreaterThan(Integer value) {
            addCriterion("collect_num >", value, "collectNum");
            return (Criteria) this;
        }

        public Criteria andCollectNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("collect_num >=", value, "collectNum");
            return (Criteria) this;
        }

        public Criteria andCollectNumLessThan(Integer value) {
            addCriterion("collect_num <", value, "collectNum");
            return (Criteria) this;
        }

        public Criteria andCollectNumLessThanOrEqualTo(Integer value) {
            addCriterion("collect_num <=", value, "collectNum");
            return (Criteria) this;
        }

        public Criteria andCollectNumIn(List<Integer> values) {
            addCriterion("collect_num in", values, "collectNum");
            return (Criteria) this;
        }

        public Criteria andCollectNumNotIn(List<Integer> values) {
            addCriterion("collect_num not in", values, "collectNum");
            return (Criteria) this;
        }

        public Criteria andCollectNumBetween(Integer value1, Integer value2) {
            addCriterion("collect_num between", value1, value2, "collectNum");
            return (Criteria) this;
        }

        public Criteria andCollectNumNotBetween(Integer value1, Integer value2) {
            addCriterion("collect_num not between", value1, value2, "collectNum");
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