package com.yuanzhi.tourism.entity;

import java.util.ArrayList;
import java.util.List;

public class JourneyExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public JourneyExample() {
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

        public Criteria andTidIsNull() {
            addCriterion("tid is null");
            return (Criteria) this;
        }

        public Criteria andTidIsNotNull() {
            addCriterion("tid is not null");
            return (Criteria) this;
        }

        public Criteria andTidEqualTo(Integer value) {
            addCriterion("tid =", value, "tid");
            return (Criteria) this;
        }

        public Criteria andTidNotEqualTo(Integer value) {
            addCriterion("tid <>", value, "tid");
            return (Criteria) this;
        }

        public Criteria andTidGreaterThan(Integer value) {
            addCriterion("tid >", value, "tid");
            return (Criteria) this;
        }

        public Criteria andTidGreaterThanOrEqualTo(Integer value) {
            addCriterion("tid >=", value, "tid");
            return (Criteria) this;
        }

        public Criteria andTidLessThan(Integer value) {
            addCriterion("tid <", value, "tid");
            return (Criteria) this;
        }

        public Criteria andTidLessThanOrEqualTo(Integer value) {
            addCriterion("tid <=", value, "tid");
            return (Criteria) this;
        }

        public Criteria andTidIn(List<Integer> values) {
            addCriterion("tid in", values, "tid");
            return (Criteria) this;
        }

        public Criteria andTidNotIn(List<Integer> values) {
            addCriterion("tid not in", values, "tid");
            return (Criteria) this;
        }

        public Criteria andTidBetween(Integer value1, Integer value2) {
            addCriterion("tid between", value1, value2, "tid");
            return (Criteria) this;
        }

        public Criteria andTidNotBetween(Integer value1, Integer value2) {
            addCriterion("tid not between", value1, value2, "tid");
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

        public Criteria andPublishtimeIsNull() {
            addCriterion("publishTime is null");
            return (Criteria) this;
        }

        public Criteria andPublishtimeIsNotNull() {
            addCriterion("publishTime is not null");
            return (Criteria) this;
        }

        public Criteria andPublishtimeEqualTo(String value) {
            addCriterion("publishTime =", value, "publishtime");
            return (Criteria) this;
        }

        public Criteria andPublishtimeNotEqualTo(String value) {
            addCriterion("publishTime <>", value, "publishtime");
            return (Criteria) this;
        }

        public Criteria andPublishtimeGreaterThan(String value) {
            addCriterion("publishTime >", value, "publishtime");
            return (Criteria) this;
        }

        public Criteria andPublishtimeGreaterThanOrEqualTo(String value) {
            addCriterion("publishTime >=", value, "publishtime");
            return (Criteria) this;
        }

        public Criteria andPublishtimeLessThan(String value) {
            addCriterion("publishTime <", value, "publishtime");
            return (Criteria) this;
        }

        public Criteria andPublishtimeLessThanOrEqualTo(String value) {
            addCriterion("publishTime <=", value, "publishtime");
            return (Criteria) this;
        }

        public Criteria andPublishtimeLike(String value) {
            addCriterion("publishTime like", value, "publishtime");
            return (Criteria) this;
        }

        public Criteria andPublishtimeNotLike(String value) {
            addCriterion("publishTime not like", value, "publishtime");
            return (Criteria) this;
        }

        public Criteria andPublishtimeIn(List<String> values) {
            addCriterion("publishTime in", values, "publishtime");
            return (Criteria) this;
        }

        public Criteria andPublishtimeNotIn(List<String> values) {
            addCriterion("publishTime not in", values, "publishtime");
            return (Criteria) this;
        }

        public Criteria andPublishtimeBetween(String value1, String value2) {
            addCriterion("publishTime between", value1, value2, "publishtime");
            return (Criteria) this;
        }

        public Criteria andPublishtimeNotBetween(String value1, String value2) {
            addCriterion("publishTime not between", value1, value2, "publishtime");
            return (Criteria) this;
        }

        public Criteria andStarttimeIsNull() {
            addCriterion("startTime is null");
            return (Criteria) this;
        }

        public Criteria andStarttimeIsNotNull() {
            addCriterion("startTime is not null");
            return (Criteria) this;
        }

        public Criteria andStarttimeEqualTo(String value) {
            addCriterion("startTime =", value, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeNotEqualTo(String value) {
            addCriterion("startTime <>", value, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeGreaterThan(String value) {
            addCriterion("startTime >", value, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeGreaterThanOrEqualTo(String value) {
            addCriterion("startTime >=", value, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeLessThan(String value) {
            addCriterion("startTime <", value, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeLessThanOrEqualTo(String value) {
            addCriterion("startTime <=", value, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeLike(String value) {
            addCriterion("startTime like", value, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeNotLike(String value) {
            addCriterion("startTime not like", value, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeIn(List<String> values) {
            addCriterion("startTime in", values, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeNotIn(List<String> values) {
            addCriterion("startTime not in", values, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeBetween(String value1, String value2) {
            addCriterion("startTime between", value1, value2, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeNotBetween(String value1, String value2) {
            addCriterion("startTime not between", value1, value2, "starttime");
            return (Criteria) this;
        }

        public Criteria andPeopleIsNull() {
            addCriterion("people is null");
            return (Criteria) this;
        }

        public Criteria andPeopleIsNotNull() {
            addCriterion("people is not null");
            return (Criteria) this;
        }

        public Criteria andPeopleEqualTo(String value) {
            addCriterion("people =", value, "people");
            return (Criteria) this;
        }

        public Criteria andPeopleNotEqualTo(String value) {
            addCriterion("people <>", value, "people");
            return (Criteria) this;
        }

        public Criteria andPeopleGreaterThan(String value) {
            addCriterion("people >", value, "people");
            return (Criteria) this;
        }

        public Criteria andPeopleGreaterThanOrEqualTo(String value) {
            addCriterion("people >=", value, "people");
            return (Criteria) this;
        }

        public Criteria andPeopleLessThan(String value) {
            addCriterion("people <", value, "people");
            return (Criteria) this;
        }

        public Criteria andPeopleLessThanOrEqualTo(String value) {
            addCriterion("people <=", value, "people");
            return (Criteria) this;
        }

        public Criteria andPeopleLike(String value) {
            addCriterion("people like", value, "people");
            return (Criteria) this;
        }

        public Criteria andPeopleNotLike(String value) {
            addCriterion("people not like", value, "people");
            return (Criteria) this;
        }

        public Criteria andPeopleIn(List<String> values) {
            addCriterion("people in", values, "people");
            return (Criteria) this;
        }

        public Criteria andPeopleNotIn(List<String> values) {
            addCriterion("people not in", values, "people");
            return (Criteria) this;
        }

        public Criteria andPeopleBetween(String value1, String value2) {
            addCriterion("people between", value1, value2, "people");
            return (Criteria) this;
        }

        public Criteria andPeopleNotBetween(String value1, String value2) {
            addCriterion("people not between", value1, value2, "people");
            return (Criteria) this;
        }

        public Criteria andMoneyIsNull() {
            addCriterion("money is null");
            return (Criteria) this;
        }

        public Criteria andMoneyIsNotNull() {
            addCriterion("money is not null");
            return (Criteria) this;
        }

        public Criteria andMoneyEqualTo(String value) {
            addCriterion("money =", value, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyNotEqualTo(String value) {
            addCriterion("money <>", value, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyGreaterThan(String value) {
            addCriterion("money >", value, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyGreaterThanOrEqualTo(String value) {
            addCriterion("money >=", value, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyLessThan(String value) {
            addCriterion("money <", value, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyLessThanOrEqualTo(String value) {
            addCriterion("money <=", value, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyLike(String value) {
            addCriterion("money like", value, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyNotLike(String value) {
            addCriterion("money not like", value, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyIn(List<String> values) {
            addCriterion("money in", values, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyNotIn(List<String> values) {
            addCriterion("money not in", values, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyBetween(String value1, String value2) {
            addCriterion("money between", value1, value2, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyNotBetween(String value1, String value2) {
            addCriterion("money not between", value1, value2, "money");
            return (Criteria) this;
        }

        public Criteria andDaysnumIsNull() {
            addCriterion("daysNum is null");
            return (Criteria) this;
        }

        public Criteria andDaysnumIsNotNull() {
            addCriterion("daysNum is not null");
            return (Criteria) this;
        }

        public Criteria andDaysnumEqualTo(String value) {
            addCriterion("daysNum =", value, "daysnum");
            return (Criteria) this;
        }

        public Criteria andDaysnumNotEqualTo(String value) {
            addCriterion("daysNum <>", value, "daysnum");
            return (Criteria) this;
        }

        public Criteria andDaysnumGreaterThan(String value) {
            addCriterion("daysNum >", value, "daysnum");
            return (Criteria) this;
        }

        public Criteria andDaysnumGreaterThanOrEqualTo(String value) {
            addCriterion("daysNum >=", value, "daysnum");
            return (Criteria) this;
        }

        public Criteria andDaysnumLessThan(String value) {
            addCriterion("daysNum <", value, "daysnum");
            return (Criteria) this;
        }

        public Criteria andDaysnumLessThanOrEqualTo(String value) {
            addCriterion("daysNum <=", value, "daysnum");
            return (Criteria) this;
        }

        public Criteria andDaysnumLike(String value) {
            addCriterion("daysNum like", value, "daysnum");
            return (Criteria) this;
        }

        public Criteria andDaysnumNotLike(String value) {
            addCriterion("daysNum not like", value, "daysnum");
            return (Criteria) this;
        }

        public Criteria andDaysnumIn(List<String> values) {
            addCriterion("daysNum in", values, "daysnum");
            return (Criteria) this;
        }

        public Criteria andDaysnumNotIn(List<String> values) {
            addCriterion("daysNum not in", values, "daysnum");
            return (Criteria) this;
        }

        public Criteria andDaysnumBetween(String value1, String value2) {
            addCriterion("daysNum between", value1, value2, "daysnum");
            return (Criteria) this;
        }

        public Criteria andDaysnumNotBetween(String value1, String value2) {
            addCriterion("daysNum not between", value1, value2, "daysnum");
            return (Criteria) this;
        }

        public Criteria andJourtitleIsNull() {
            addCriterion("jourTitle is null");
            return (Criteria) this;
        }

        public Criteria andJourtitleIsNotNull() {
            addCriterion("jourTitle is not null");
            return (Criteria) this;
        }

        public Criteria andJourtitleEqualTo(String value) {
            addCriterion("jourTitle =", value, "jourtitle");
            return (Criteria) this;
        }

        public Criteria andJourtitleNotEqualTo(String value) {
            addCriterion("jourTitle <>", value, "jourtitle");
            return (Criteria) this;
        }

        public Criteria andJourtitleGreaterThan(String value) {
            addCriterion("jourTitle >", value, "jourtitle");
            return (Criteria) this;
        }

        public Criteria andJourtitleGreaterThanOrEqualTo(String value) {
            addCriterion("jourTitle >=", value, "jourtitle");
            return (Criteria) this;
        }

        public Criteria andJourtitleLessThan(String value) {
            addCriterion("jourTitle <", value, "jourtitle");
            return (Criteria) this;
        }

        public Criteria andJourtitleLessThanOrEqualTo(String value) {
            addCriterion("jourTitle <=", value, "jourtitle");
            return (Criteria) this;
        }

        public Criteria andJourtitleLike(String value) {
            addCriterion("jourTitle like", value, "jourtitle");
            return (Criteria) this;
        }

        public Criteria andJourtitleNotLike(String value) {
            addCriterion("jourTitle not like", value, "jourtitle");
            return (Criteria) this;
        }

        public Criteria andJourtitleIn(List<String> values) {
            addCriterion("jourTitle in", values, "jourtitle");
            return (Criteria) this;
        }

        public Criteria andJourtitleNotIn(List<String> values) {
            addCriterion("jourTitle not in", values, "jourtitle");
            return (Criteria) this;
        }

        public Criteria andJourtitleBetween(String value1, String value2) {
            addCriterion("jourTitle between", value1, value2, "jourtitle");
            return (Criteria) this;
        }

        public Criteria andJourtitleNotBetween(String value1, String value2) {
            addCriterion("jourTitle not between", value1, value2, "jourtitle");
            return (Criteria) this;
        }

        public Criteria andJourcontentIsNull() {
            addCriterion("jourContent is null");
            return (Criteria) this;
        }

        public Criteria andJourcontentIsNotNull() {
            addCriterion("jourContent is not null");
            return (Criteria) this;
        }

        public Criteria andJourcontentEqualTo(String value) {
            addCriterion("jourContent =", value, "jourcontent");
            return (Criteria) this;
        }

        public Criteria andJourcontentNotEqualTo(String value) {
            addCriterion("jourContent <>", value, "jourcontent");
            return (Criteria) this;
        }

        public Criteria andJourcontentGreaterThan(String value) {
            addCriterion("jourContent >", value, "jourcontent");
            return (Criteria) this;
        }

        public Criteria andJourcontentGreaterThanOrEqualTo(String value) {
            addCriterion("jourContent >=", value, "jourcontent");
            return (Criteria) this;
        }

        public Criteria andJourcontentLessThan(String value) {
            addCriterion("jourContent <", value, "jourcontent");
            return (Criteria) this;
        }

        public Criteria andJourcontentLessThanOrEqualTo(String value) {
            addCriterion("jourContent <=", value, "jourcontent");
            return (Criteria) this;
        }

        public Criteria andJourcontentLike(String value) {
            addCriterion("jourContent like", value, "jourcontent");
            return (Criteria) this;
        }

        public Criteria andJourcontentNotLike(String value) {
            addCriterion("jourContent not like", value, "jourcontent");
            return (Criteria) this;
        }

        public Criteria andJourcontentIn(List<String> values) {
            addCriterion("jourContent in", values, "jourcontent");
            return (Criteria) this;
        }

        public Criteria andJourcontentNotIn(List<String> values) {
            addCriterion("jourContent not in", values, "jourcontent");
            return (Criteria) this;
        }

        public Criteria andJourcontentBetween(String value1, String value2) {
            addCriterion("jourContent between", value1, value2, "jourcontent");
            return (Criteria) this;
        }

        public Criteria andJourcontentNotBetween(String value1, String value2) {
            addCriterion("jourContent not between", value1, value2, "jourcontent");
            return (Criteria) this;
        }

        public Criteria andReadtimesIsNull() {
            addCriterion("readTimes is null");
            return (Criteria) this;
        }

        public Criteria andReadtimesIsNotNull() {
            addCriterion("readTimes is not null");
            return (Criteria) this;
        }

        public Criteria andReadtimesEqualTo(Integer value) {
            addCriterion("readTimes =", value, "readtimes");
            return (Criteria) this;
        }

        public Criteria andReadtimesNotEqualTo(Integer value) {
            addCriterion("readTimes <>", value, "readtimes");
            return (Criteria) this;
        }

        public Criteria andReadtimesGreaterThan(Integer value) {
            addCriterion("readTimes >", value, "readtimes");
            return (Criteria) this;
        }

        public Criteria andReadtimesGreaterThanOrEqualTo(Integer value) {
            addCriterion("readTimes >=", value, "readtimes");
            return (Criteria) this;
        }

        public Criteria andReadtimesLessThan(Integer value) {
            addCriterion("readTimes <", value, "readtimes");
            return (Criteria) this;
        }

        public Criteria andReadtimesLessThanOrEqualTo(Integer value) {
            addCriterion("readTimes <=", value, "readtimes");
            return (Criteria) this;
        }

        public Criteria andReadtimesIn(List<Integer> values) {
            addCriterion("readTimes in", values, "readtimes");
            return (Criteria) this;
        }

        public Criteria andReadtimesNotIn(List<Integer> values) {
            addCriterion("readTimes not in", values, "readtimes");
            return (Criteria) this;
        }

        public Criteria andReadtimesBetween(Integer value1, Integer value2) {
            addCriterion("readTimes between", value1, value2, "readtimes");
            return (Criteria) this;
        }

        public Criteria andReadtimesNotBetween(Integer value1, Integer value2) {
            addCriterion("readTimes not between", value1, value2, "readtimes");
            return (Criteria) this;
        }

        public Criteria andPraisetimesIsNull() {
            addCriterion("praiseTimes is null");
            return (Criteria) this;
        }

        public Criteria andPraisetimesIsNotNull() {
            addCriterion("praiseTimes is not null");
            return (Criteria) this;
        }

        public Criteria andPraisetimesEqualTo(Integer value) {
            addCriterion("praiseTimes =", value, "praisetimes");
            return (Criteria) this;
        }

        public Criteria andPraisetimesNotEqualTo(Integer value) {
            addCriterion("praiseTimes <>", value, "praisetimes");
            return (Criteria) this;
        }

        public Criteria andPraisetimesGreaterThan(Integer value) {
            addCriterion("praiseTimes >", value, "praisetimes");
            return (Criteria) this;
        }

        public Criteria andPraisetimesGreaterThanOrEqualTo(Integer value) {
            addCriterion("praiseTimes >=", value, "praisetimes");
            return (Criteria) this;
        }

        public Criteria andPraisetimesLessThan(Integer value) {
            addCriterion("praiseTimes <", value, "praisetimes");
            return (Criteria) this;
        }

        public Criteria andPraisetimesLessThanOrEqualTo(Integer value) {
            addCriterion("praiseTimes <=", value, "praisetimes");
            return (Criteria) this;
        }

        public Criteria andPraisetimesIn(List<Integer> values) {
            addCriterion("praiseTimes in", values, "praisetimes");
            return (Criteria) this;
        }

        public Criteria andPraisetimesNotIn(List<Integer> values) {
            addCriterion("praiseTimes not in", values, "praisetimes");
            return (Criteria) this;
        }

        public Criteria andPraisetimesBetween(Integer value1, Integer value2) {
            addCriterion("praiseTimes between", value1, value2, "praisetimes");
            return (Criteria) this;
        }

        public Criteria andPraisetimesNotBetween(Integer value1, Integer value2) {
            addCriterion("praiseTimes not between", value1, value2, "praisetimes");
            return (Criteria) this;
        }

        public Criteria andMainimgIsNull() {
            addCriterion("mainImg is null");
            return (Criteria) this;
        }

        public Criteria andMainimgIsNotNull() {
            addCriterion("mainImg is not null");
            return (Criteria) this;
        }

        public Criteria andMainimgEqualTo(String value) {
            addCriterion("mainImg =", value, "mainimg");
            return (Criteria) this;
        }

        public Criteria andMainimgNotEqualTo(String value) {
            addCriterion("mainImg <>", value, "mainimg");
            return (Criteria) this;
        }

        public Criteria andMainimgGreaterThan(String value) {
            addCriterion("mainImg >", value, "mainimg");
            return (Criteria) this;
        }

        public Criteria andMainimgGreaterThanOrEqualTo(String value) {
            addCriterion("mainImg >=", value, "mainimg");
            return (Criteria) this;
        }

        public Criteria andMainimgLessThan(String value) {
            addCriterion("mainImg <", value, "mainimg");
            return (Criteria) this;
        }

        public Criteria andMainimgLessThanOrEqualTo(String value) {
            addCriterion("mainImg <=", value, "mainimg");
            return (Criteria) this;
        }

        public Criteria andMainimgLike(String value) {
            addCriterion("mainImg like", value, "mainimg");
            return (Criteria) this;
        }

        public Criteria andMainimgNotLike(String value) {
            addCriterion("mainImg not like", value, "mainimg");
            return (Criteria) this;
        }

        public Criteria andMainimgIn(List<String> values) {
            addCriterion("mainImg in", values, "mainimg");
            return (Criteria) this;
        }

        public Criteria andMainimgNotIn(List<String> values) {
            addCriterion("mainImg not in", values, "mainimg");
            return (Criteria) this;
        }

        public Criteria andMainimgBetween(String value1, String value2) {
            addCriterion("mainImg between", value1, value2, "mainimg");
            return (Criteria) this;
        }

        public Criteria andMainimgNotBetween(String value1, String value2) {
            addCriterion("mainImg not between", value1, value2, "mainimg");
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