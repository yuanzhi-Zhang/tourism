package com.yuanzhi.tourism.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class AlbumExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AlbumExample() {
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

        public Criteria andAlbumtitleIsNull() {
            addCriterion("albumTitle is null");
            return (Criteria) this;
        }

        public Criteria andAlbumtitleIsNotNull() {
            addCriterion("albumTitle is not null");
            return (Criteria) this;
        }

        public Criteria andAlbumtitleEqualTo(String value) {
            addCriterion("albumTitle =", value, "albumtitle");
            return (Criteria) this;
        }

        public Criteria andAlbumtitleNotEqualTo(String value) {
            addCriterion("albumTitle <>", value, "albumtitle");
            return (Criteria) this;
        }

        public Criteria andAlbumtitleGreaterThan(String value) {
            addCriterion("albumTitle >", value, "albumtitle");
            return (Criteria) this;
        }

        public Criteria andAlbumtitleGreaterThanOrEqualTo(String value) {
            addCriterion("albumTitle >=", value, "albumtitle");
            return (Criteria) this;
        }

        public Criteria andAlbumtitleLessThan(String value) {
            addCriterion("albumTitle <", value, "albumtitle");
            return (Criteria) this;
        }

        public Criteria andAlbumtitleLessThanOrEqualTo(String value) {
            addCriterion("albumTitle <=", value, "albumtitle");
            return (Criteria) this;
        }

        public Criteria andAlbumtitleLike(String value) {
            addCriterion("albumTitle like", value, "albumtitle");
            return (Criteria) this;
        }

        public Criteria andAlbumtitleNotLike(String value) {
            addCriterion("albumTitle not like", value, "albumtitle");
            return (Criteria) this;
        }

        public Criteria andAlbumtitleIn(List<String> values) {
            addCriterion("albumTitle in", values, "albumtitle");
            return (Criteria) this;
        }

        public Criteria andAlbumtitleNotIn(List<String> values) {
            addCriterion("albumTitle not in", values, "albumtitle");
            return (Criteria) this;
        }

        public Criteria andAlbumtitleBetween(String value1, String value2) {
            addCriterion("albumTitle between", value1, value2, "albumtitle");
            return (Criteria) this;
        }

        public Criteria andAlbumtitleNotBetween(String value1, String value2) {
            addCriterion("albumTitle not between", value1, value2, "albumtitle");
            return (Criteria) this;
        }

        public Criteria andAlbuminfoIsNull() {
            addCriterion("albumInfo is null");
            return (Criteria) this;
        }

        public Criteria andAlbuminfoIsNotNull() {
            addCriterion("albumInfo is not null");
            return (Criteria) this;
        }

        public Criteria andAlbuminfoEqualTo(String value) {
            addCriterion("albumInfo =", value, "albuminfo");
            return (Criteria) this;
        }

        public Criteria andAlbuminfoNotEqualTo(String value) {
            addCriterion("albumInfo <>", value, "albuminfo");
            return (Criteria) this;
        }

        public Criteria andAlbuminfoGreaterThan(String value) {
            addCriterion("albumInfo >", value, "albuminfo");
            return (Criteria) this;
        }

        public Criteria andAlbuminfoGreaterThanOrEqualTo(String value) {
            addCriterion("albumInfo >=", value, "albuminfo");
            return (Criteria) this;
        }

        public Criteria andAlbuminfoLessThan(String value) {
            addCriterion("albumInfo <", value, "albuminfo");
            return (Criteria) this;
        }

        public Criteria andAlbuminfoLessThanOrEqualTo(String value) {
            addCriterion("albumInfo <=", value, "albuminfo");
            return (Criteria) this;
        }

        public Criteria andAlbuminfoLike(String value) {
            addCriterion("albumInfo like", value, "albuminfo");
            return (Criteria) this;
        }

        public Criteria andAlbuminfoNotLike(String value) {
            addCriterion("albumInfo not like", value, "albuminfo");
            return (Criteria) this;
        }

        public Criteria andAlbuminfoIn(List<String> values) {
            addCriterion("albumInfo in", values, "albuminfo");
            return (Criteria) this;
        }

        public Criteria andAlbuminfoNotIn(List<String> values) {
            addCriterion("albumInfo not in", values, "albuminfo");
            return (Criteria) this;
        }

        public Criteria andAlbuminfoBetween(String value1, String value2) {
            addCriterion("albumInfo between", value1, value2, "albuminfo");
            return (Criteria) this;
        }

        public Criteria andAlbuminfoNotBetween(String value1, String value2) {
            addCriterion("albumInfo not between", value1, value2, "albuminfo");
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

        public Criteria andPublishtimeEqualTo(Date value) {
            addCriterionForJDBCDate("publishTime =", value, "publishtime");
            return (Criteria) this;
        }

        public Criteria andPublishtimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("publishTime <>", value, "publishtime");
            return (Criteria) this;
        }

        public Criteria andPublishtimeGreaterThan(Date value) {
            addCriterionForJDBCDate("publishTime >", value, "publishtime");
            return (Criteria) this;
        }

        public Criteria andPublishtimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("publishTime >=", value, "publishtime");
            return (Criteria) this;
        }

        public Criteria andPublishtimeLessThan(Date value) {
            addCriterionForJDBCDate("publishTime <", value, "publishtime");
            return (Criteria) this;
        }

        public Criteria andPublishtimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("publishTime <=", value, "publishtime");
            return (Criteria) this;
        }

        public Criteria andPublishtimeIn(List<Date> values) {
            addCriterionForJDBCDate("publishTime in", values, "publishtime");
            return (Criteria) this;
        }

        public Criteria andPublishtimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("publishTime not in", values, "publishtime");
            return (Criteria) this;
        }

        public Criteria andPublishtimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("publishTime between", value1, value2, "publishtime");
            return (Criteria) this;
        }

        public Criteria andPublishtimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("publishTime not between", value1, value2, "publishtime");
            return (Criteria) this;
        }

        public Criteria andViewtimesIsNull() {
            addCriterion("viewTimes is null");
            return (Criteria) this;
        }

        public Criteria andViewtimesIsNotNull() {
            addCriterion("viewTimes is not null");
            return (Criteria) this;
        }

        public Criteria andViewtimesEqualTo(Integer value) {
            addCriterion("viewTimes =", value, "viewtimes");
            return (Criteria) this;
        }

        public Criteria andViewtimesNotEqualTo(Integer value) {
            addCriterion("viewTimes <>", value, "viewtimes");
            return (Criteria) this;
        }

        public Criteria andViewtimesGreaterThan(Integer value) {
            addCriterion("viewTimes >", value, "viewtimes");
            return (Criteria) this;
        }

        public Criteria andViewtimesGreaterThanOrEqualTo(Integer value) {
            addCriterion("viewTimes >=", value, "viewtimes");
            return (Criteria) this;
        }

        public Criteria andViewtimesLessThan(Integer value) {
            addCriterion("viewTimes <", value, "viewtimes");
            return (Criteria) this;
        }

        public Criteria andViewtimesLessThanOrEqualTo(Integer value) {
            addCriterion("viewTimes <=", value, "viewtimes");
            return (Criteria) this;
        }

        public Criteria andViewtimesIn(List<Integer> values) {
            addCriterion("viewTimes in", values, "viewtimes");
            return (Criteria) this;
        }

        public Criteria andViewtimesNotIn(List<Integer> values) {
            addCriterion("viewTimes not in", values, "viewtimes");
            return (Criteria) this;
        }

        public Criteria andViewtimesBetween(Integer value1, Integer value2) {
            addCriterion("viewTimes between", value1, value2, "viewtimes");
            return (Criteria) this;
        }

        public Criteria andViewtimesNotBetween(Integer value1, Integer value2) {
            addCriterion("viewTimes not between", value1, value2, "viewtimes");
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