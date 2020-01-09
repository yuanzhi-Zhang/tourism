package com.yuanzhi.tourism.entity;

import java.util.ArrayList;
import java.util.List;

public class SceneExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SceneExample() {
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

        public Criteria andSceneIdIsNull() {
            addCriterion("scene_id is null");
            return (Criteria) this;
        }

        public Criteria andSceneIdIsNotNull() {
            addCriterion("scene_id is not null");
            return (Criteria) this;
        }

        public Criteria andSceneIdEqualTo(Integer value) {
            addCriterion("scene_id =", value, "sceneId");
            return (Criteria) this;
        }

        public Criteria andSceneIdNotEqualTo(Integer value) {
            addCriterion("scene_id <>", value, "sceneId");
            return (Criteria) this;
        }

        public Criteria andSceneIdGreaterThan(Integer value) {
            addCriterion("scene_id >", value, "sceneId");
            return (Criteria) this;
        }

        public Criteria andSceneIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("scene_id >=", value, "sceneId");
            return (Criteria) this;
        }

        public Criteria andSceneIdLessThan(Integer value) {
            addCriterion("scene_id <", value, "sceneId");
            return (Criteria) this;
        }

        public Criteria andSceneIdLessThanOrEqualTo(Integer value) {
            addCriterion("scene_id <=", value, "sceneId");
            return (Criteria) this;
        }

        public Criteria andSceneIdIn(List<Integer> values) {
            addCriterion("scene_id in", values, "sceneId");
            return (Criteria) this;
        }

        public Criteria andSceneIdNotIn(List<Integer> values) {
            addCriterion("scene_id not in", values, "sceneId");
            return (Criteria) this;
        }

        public Criteria andSceneIdBetween(Integer value1, Integer value2) {
            addCriterion("scene_id between", value1, value2, "sceneId");
            return (Criteria) this;
        }

        public Criteria andSceneIdNotBetween(Integer value1, Integer value2) {
            addCriterion("scene_id not between", value1, value2, "sceneId");
            return (Criteria) this;
        }

        public Criteria andSceneNameIsNull() {
            addCriterion("scene_name is null");
            return (Criteria) this;
        }

        public Criteria andSceneNameIsNotNull() {
            addCriterion("scene_name is not null");
            return (Criteria) this;
        }

        public Criteria andSceneNameEqualTo(String value) {
            addCriterion("scene_name =", value, "sceneName");
            return (Criteria) this;
        }

        public Criteria andSceneNameNotEqualTo(String value) {
            addCriterion("scene_name <>", value, "sceneName");
            return (Criteria) this;
        }

        public Criteria andSceneNameGreaterThan(String value) {
            addCriterion("scene_name >", value, "sceneName");
            return (Criteria) this;
        }

        public Criteria andSceneNameGreaterThanOrEqualTo(String value) {
            addCriterion("scene_name >=", value, "sceneName");
            return (Criteria) this;
        }

        public Criteria andSceneNameLessThan(String value) {
            addCriterion("scene_name <", value, "sceneName");
            return (Criteria) this;
        }

        public Criteria andSceneNameLessThanOrEqualTo(String value) {
            addCriterion("scene_name <=", value, "sceneName");
            return (Criteria) this;
        }

        public Criteria andSceneNameLike(String value) {
            addCriterion("scene_name like", value, "sceneName");
            return (Criteria) this;
        }

        public Criteria andSceneNameNotLike(String value) {
            addCriterion("scene_name not like", value, "sceneName");
            return (Criteria) this;
        }

        public Criteria andSceneNameIn(List<String> values) {
            addCriterion("scene_name in", values, "sceneName");
            return (Criteria) this;
        }

        public Criteria andSceneNameNotIn(List<String> values) {
            addCriterion("scene_name not in", values, "sceneName");
            return (Criteria) this;
        }

        public Criteria andSceneNameBetween(String value1, String value2) {
            addCriterion("scene_name between", value1, value2, "sceneName");
            return (Criteria) this;
        }

        public Criteria andSceneNameNotBetween(String value1, String value2) {
            addCriterion("scene_name not between", value1, value2, "sceneName");
            return (Criteria) this;
        }

        public Criteria andSceneCityNameIsNull() {
            addCriterion("scene_city_name is null");
            return (Criteria) this;
        }

        public Criteria andSceneCityNameIsNotNull() {
            addCriterion("scene_city_name is not null");
            return (Criteria) this;
        }

        public Criteria andSceneCityNameEqualTo(String value) {
            addCriterion("scene_city_name =", value, "sceneCityName");
            return (Criteria) this;
        }

        public Criteria andSceneCityNameNotEqualTo(String value) {
            addCriterion("scene_city_name <>", value, "sceneCityName");
            return (Criteria) this;
        }

        public Criteria andSceneCityNameGreaterThan(String value) {
            addCriterion("scene_city_name >", value, "sceneCityName");
            return (Criteria) this;
        }

        public Criteria andSceneCityNameGreaterThanOrEqualTo(String value) {
            addCriterion("scene_city_name >=", value, "sceneCityName");
            return (Criteria) this;
        }

        public Criteria andSceneCityNameLessThan(String value) {
            addCriterion("scene_city_name <", value, "sceneCityName");
            return (Criteria) this;
        }

        public Criteria andSceneCityNameLessThanOrEqualTo(String value) {
            addCriterion("scene_city_name <=", value, "sceneCityName");
            return (Criteria) this;
        }

        public Criteria andSceneCityNameLike(String value) {
            addCriterion("scene_city_name like", value, "sceneCityName");
            return (Criteria) this;
        }

        public Criteria andSceneCityNameNotLike(String value) {
            addCriterion("scene_city_name not like", value, "sceneCityName");
            return (Criteria) this;
        }

        public Criteria andSceneCityNameIn(List<String> values) {
            addCriterion("scene_city_name in", values, "sceneCityName");
            return (Criteria) this;
        }

        public Criteria andSceneCityNameNotIn(List<String> values) {
            addCriterion("scene_city_name not in", values, "sceneCityName");
            return (Criteria) this;
        }

        public Criteria andSceneCityNameBetween(String value1, String value2) {
            addCriterion("scene_city_name between", value1, value2, "sceneCityName");
            return (Criteria) this;
        }

        public Criteria andSceneCityNameNotBetween(String value1, String value2) {
            addCriterion("scene_city_name not between", value1, value2, "sceneCityName");
            return (Criteria) this;
        }

        public Criteria andSceneAreaNameIsNull() {
            addCriterion("scene_area_name is null");
            return (Criteria) this;
        }

        public Criteria andSceneAreaNameIsNotNull() {
            addCriterion("scene_area_name is not null");
            return (Criteria) this;
        }

        public Criteria andSceneAreaNameEqualTo(String value) {
            addCriterion("scene_area_name =", value, "sceneAreaName");
            return (Criteria) this;
        }

        public Criteria andSceneAreaNameNotEqualTo(String value) {
            addCriterion("scene_area_name <>", value, "sceneAreaName");
            return (Criteria) this;
        }

        public Criteria andSceneAreaNameGreaterThan(String value) {
            addCriterion("scene_area_name >", value, "sceneAreaName");
            return (Criteria) this;
        }

        public Criteria andSceneAreaNameGreaterThanOrEqualTo(String value) {
            addCriterion("scene_area_name >=", value, "sceneAreaName");
            return (Criteria) this;
        }

        public Criteria andSceneAreaNameLessThan(String value) {
            addCriterion("scene_area_name <", value, "sceneAreaName");
            return (Criteria) this;
        }

        public Criteria andSceneAreaNameLessThanOrEqualTo(String value) {
            addCriterion("scene_area_name <=", value, "sceneAreaName");
            return (Criteria) this;
        }

        public Criteria andSceneAreaNameLike(String value) {
            addCriterion("scene_area_name like", value, "sceneAreaName");
            return (Criteria) this;
        }

        public Criteria andSceneAreaNameNotLike(String value) {
            addCriterion("scene_area_name not like", value, "sceneAreaName");
            return (Criteria) this;
        }

        public Criteria andSceneAreaNameIn(List<String> values) {
            addCriterion("scene_area_name in", values, "sceneAreaName");
            return (Criteria) this;
        }

        public Criteria andSceneAreaNameNotIn(List<String> values) {
            addCriterion("scene_area_name not in", values, "sceneAreaName");
            return (Criteria) this;
        }

        public Criteria andSceneAreaNameBetween(String value1, String value2) {
            addCriterion("scene_area_name between", value1, value2, "sceneAreaName");
            return (Criteria) this;
        }

        public Criteria andSceneAreaNameNotBetween(String value1, String value2) {
            addCriterion("scene_area_name not between", value1, value2, "sceneAreaName");
            return (Criteria) this;
        }

        public Criteria andSceneAddressIsNull() {
            addCriterion("scene_address is null");
            return (Criteria) this;
        }

        public Criteria andSceneAddressIsNotNull() {
            addCriterion("scene_address is not null");
            return (Criteria) this;
        }

        public Criteria andSceneAddressEqualTo(String value) {
            addCriterion("scene_address =", value, "sceneAddress");
            return (Criteria) this;
        }

        public Criteria andSceneAddressNotEqualTo(String value) {
            addCriterion("scene_address <>", value, "sceneAddress");
            return (Criteria) this;
        }

        public Criteria andSceneAddressGreaterThan(String value) {
            addCriterion("scene_address >", value, "sceneAddress");
            return (Criteria) this;
        }

        public Criteria andSceneAddressGreaterThanOrEqualTo(String value) {
            addCriterion("scene_address >=", value, "sceneAddress");
            return (Criteria) this;
        }

        public Criteria andSceneAddressLessThan(String value) {
            addCriterion("scene_address <", value, "sceneAddress");
            return (Criteria) this;
        }

        public Criteria andSceneAddressLessThanOrEqualTo(String value) {
            addCriterion("scene_address <=", value, "sceneAddress");
            return (Criteria) this;
        }

        public Criteria andSceneAddressLike(String value) {
            addCriterion("scene_address like", value, "sceneAddress");
            return (Criteria) this;
        }

        public Criteria andSceneAddressNotLike(String value) {
            addCriterion("scene_address not like", value, "sceneAddress");
            return (Criteria) this;
        }

        public Criteria andSceneAddressIn(List<String> values) {
            addCriterion("scene_address in", values, "sceneAddress");
            return (Criteria) this;
        }

        public Criteria andSceneAddressNotIn(List<String> values) {
            addCriterion("scene_address not in", values, "sceneAddress");
            return (Criteria) this;
        }

        public Criteria andSceneAddressBetween(String value1, String value2) {
            addCriterion("scene_address between", value1, value2, "sceneAddress");
            return (Criteria) this;
        }

        public Criteria andSceneAddressNotBetween(String value1, String value2) {
            addCriterion("scene_address not between", value1, value2, "sceneAddress");
            return (Criteria) this;
        }

        public Criteria andScenePriceIsNull() {
            addCriterion("scene_price is null");
            return (Criteria) this;
        }

        public Criteria andScenePriceIsNotNull() {
            addCriterion("scene_price is not null");
            return (Criteria) this;
        }

        public Criteria andScenePriceEqualTo(String value) {
            addCriterion("scene_price =", value, "scenePrice");
            return (Criteria) this;
        }

        public Criteria andScenePriceNotEqualTo(String value) {
            addCriterion("scene_price <>", value, "scenePrice");
            return (Criteria) this;
        }

        public Criteria andScenePriceGreaterThan(String value) {
            addCriterion("scene_price >", value, "scenePrice");
            return (Criteria) this;
        }

        public Criteria andScenePriceGreaterThanOrEqualTo(String value) {
            addCriterion("scene_price >=", value, "scenePrice");
            return (Criteria) this;
        }

        public Criteria andScenePriceLessThan(String value) {
            addCriterion("scene_price <", value, "scenePrice");
            return (Criteria) this;
        }

        public Criteria andScenePriceLessThanOrEqualTo(String value) {
            addCriterion("scene_price <=", value, "scenePrice");
            return (Criteria) this;
        }

        public Criteria andScenePriceLike(String value) {
            addCriterion("scene_price like", value, "scenePrice");
            return (Criteria) this;
        }

        public Criteria andScenePriceNotLike(String value) {
            addCriterion("scene_price not like", value, "scenePrice");
            return (Criteria) this;
        }

        public Criteria andScenePriceIn(List<String> values) {
            addCriterion("scene_price in", values, "scenePrice");
            return (Criteria) this;
        }

        public Criteria andScenePriceNotIn(List<String> values) {
            addCriterion("scene_price not in", values, "scenePrice");
            return (Criteria) this;
        }

        public Criteria andScenePriceBetween(String value1, String value2) {
            addCriterion("scene_price between", value1, value2, "scenePrice");
            return (Criteria) this;
        }

        public Criteria andScenePriceNotBetween(String value1, String value2) {
            addCriterion("scene_price not between", value1, value2, "scenePrice");
            return (Criteria) this;
        }

        public Criteria andSceneProvinceNameIsNull() {
            addCriterion("scene_province_name is null");
            return (Criteria) this;
        }

        public Criteria andSceneProvinceNameIsNotNull() {
            addCriterion("scene_province_name is not null");
            return (Criteria) this;
        }

        public Criteria andSceneProvinceNameEqualTo(String value) {
            addCriterion("scene_province_name =", value, "sceneProvinceName");
            return (Criteria) this;
        }

        public Criteria andSceneProvinceNameNotEqualTo(String value) {
            addCriterion("scene_province_name <>", value, "sceneProvinceName");
            return (Criteria) this;
        }

        public Criteria andSceneProvinceNameGreaterThan(String value) {
            addCriterion("scene_province_name >", value, "sceneProvinceName");
            return (Criteria) this;
        }

        public Criteria andSceneProvinceNameGreaterThanOrEqualTo(String value) {
            addCriterion("scene_province_name >=", value, "sceneProvinceName");
            return (Criteria) this;
        }

        public Criteria andSceneProvinceNameLessThan(String value) {
            addCriterion("scene_province_name <", value, "sceneProvinceName");
            return (Criteria) this;
        }

        public Criteria andSceneProvinceNameLessThanOrEqualTo(String value) {
            addCriterion("scene_province_name <=", value, "sceneProvinceName");
            return (Criteria) this;
        }

        public Criteria andSceneProvinceNameLike(String value) {
            addCriterion("scene_province_name like", value, "sceneProvinceName");
            return (Criteria) this;
        }

        public Criteria andSceneProvinceNameNotLike(String value) {
            addCriterion("scene_province_name not like", value, "sceneProvinceName");
            return (Criteria) this;
        }

        public Criteria andSceneProvinceNameIn(List<String> values) {
            addCriterion("scene_province_name in", values, "sceneProvinceName");
            return (Criteria) this;
        }

        public Criteria andSceneProvinceNameNotIn(List<String> values) {
            addCriterion("scene_province_name not in", values, "sceneProvinceName");
            return (Criteria) this;
        }

        public Criteria andSceneProvinceNameBetween(String value1, String value2) {
            addCriterion("scene_province_name between", value1, value2, "sceneProvinceName");
            return (Criteria) this;
        }

        public Criteria andSceneProvinceNameNotBetween(String value1, String value2) {
            addCriterion("scene_province_name not between", value1, value2, "sceneProvinceName");
            return (Criteria) this;
        }

        public Criteria andSceneSummaryIsNull() {
            addCriterion("scene_summary is null");
            return (Criteria) this;
        }

        public Criteria andSceneSummaryIsNotNull() {
            addCriterion("scene_summary is not null");
            return (Criteria) this;
        }

        public Criteria andSceneSummaryEqualTo(String value) {
            addCriterion("scene_summary =", value, "sceneSummary");
            return (Criteria) this;
        }

        public Criteria andSceneSummaryNotEqualTo(String value) {
            addCriterion("scene_summary <>", value, "sceneSummary");
            return (Criteria) this;
        }

        public Criteria andSceneSummaryGreaterThan(String value) {
            addCriterion("scene_summary >", value, "sceneSummary");
            return (Criteria) this;
        }

        public Criteria andSceneSummaryGreaterThanOrEqualTo(String value) {
            addCriterion("scene_summary >=", value, "sceneSummary");
            return (Criteria) this;
        }

        public Criteria andSceneSummaryLessThan(String value) {
            addCriterion("scene_summary <", value, "sceneSummary");
            return (Criteria) this;
        }

        public Criteria andSceneSummaryLessThanOrEqualTo(String value) {
            addCriterion("scene_summary <=", value, "sceneSummary");
            return (Criteria) this;
        }

        public Criteria andSceneSummaryLike(String value) {
            addCriterion("scene_summary like", value, "sceneSummary");
            return (Criteria) this;
        }

        public Criteria andSceneSummaryNotLike(String value) {
            addCriterion("scene_summary not like", value, "sceneSummary");
            return (Criteria) this;
        }

        public Criteria andSceneSummaryIn(List<String> values) {
            addCriterion("scene_summary in", values, "sceneSummary");
            return (Criteria) this;
        }

        public Criteria andSceneSummaryNotIn(List<String> values) {
            addCriterion("scene_summary not in", values, "sceneSummary");
            return (Criteria) this;
        }

        public Criteria andSceneSummaryBetween(String value1, String value2) {
            addCriterion("scene_summary between", value1, value2, "sceneSummary");
            return (Criteria) this;
        }

        public Criteria andSceneSummaryNotBetween(String value1, String value2) {
            addCriterion("scene_summary not between", value1, value2, "sceneSummary");
            return (Criteria) this;
        }

        public Criteria andSceneAttentionIsNull() {
            addCriterion("scene_attention is null");
            return (Criteria) this;
        }

        public Criteria andSceneAttentionIsNotNull() {
            addCriterion("scene_attention is not null");
            return (Criteria) this;
        }

        public Criteria andSceneAttentionEqualTo(String value) {
            addCriterion("scene_attention =", value, "sceneAttention");
            return (Criteria) this;
        }

        public Criteria andSceneAttentionNotEqualTo(String value) {
            addCriterion("scene_attention <>", value, "sceneAttention");
            return (Criteria) this;
        }

        public Criteria andSceneAttentionGreaterThan(String value) {
            addCriterion("scene_attention >", value, "sceneAttention");
            return (Criteria) this;
        }

        public Criteria andSceneAttentionGreaterThanOrEqualTo(String value) {
            addCriterion("scene_attention >=", value, "sceneAttention");
            return (Criteria) this;
        }

        public Criteria andSceneAttentionLessThan(String value) {
            addCriterion("scene_attention <", value, "sceneAttention");
            return (Criteria) this;
        }

        public Criteria andSceneAttentionLessThanOrEqualTo(String value) {
            addCriterion("scene_attention <=", value, "sceneAttention");
            return (Criteria) this;
        }

        public Criteria andSceneAttentionLike(String value) {
            addCriterion("scene_attention like", value, "sceneAttention");
            return (Criteria) this;
        }

        public Criteria andSceneAttentionNotLike(String value) {
            addCriterion("scene_attention not like", value, "sceneAttention");
            return (Criteria) this;
        }

        public Criteria andSceneAttentionIn(List<String> values) {
            addCriterion("scene_attention in", values, "sceneAttention");
            return (Criteria) this;
        }

        public Criteria andSceneAttentionNotIn(List<String> values) {
            addCriterion("scene_attention not in", values, "sceneAttention");
            return (Criteria) this;
        }

        public Criteria andSceneAttentionBetween(String value1, String value2) {
            addCriterion("scene_attention between", value1, value2, "sceneAttention");
            return (Criteria) this;
        }

        public Criteria andSceneAttentionNotBetween(String value1, String value2) {
            addCriterion("scene_attention not between", value1, value2, "sceneAttention");
            return (Criteria) this;
        }

        public Criteria andSceneOpentimeIsNull() {
            addCriterion("scene_opentime is null");
            return (Criteria) this;
        }

        public Criteria andSceneOpentimeIsNotNull() {
            addCriterion("scene_opentime is not null");
            return (Criteria) this;
        }

        public Criteria andSceneOpentimeEqualTo(String value) {
            addCriterion("scene_opentime =", value, "sceneOpentime");
            return (Criteria) this;
        }

        public Criteria andSceneOpentimeNotEqualTo(String value) {
            addCriterion("scene_opentime <>", value, "sceneOpentime");
            return (Criteria) this;
        }

        public Criteria andSceneOpentimeGreaterThan(String value) {
            addCriterion("scene_opentime >", value, "sceneOpentime");
            return (Criteria) this;
        }

        public Criteria andSceneOpentimeGreaterThanOrEqualTo(String value) {
            addCriterion("scene_opentime >=", value, "sceneOpentime");
            return (Criteria) this;
        }

        public Criteria andSceneOpentimeLessThan(String value) {
            addCriterion("scene_opentime <", value, "sceneOpentime");
            return (Criteria) this;
        }

        public Criteria andSceneOpentimeLessThanOrEqualTo(String value) {
            addCriterion("scene_opentime <=", value, "sceneOpentime");
            return (Criteria) this;
        }

        public Criteria andSceneOpentimeLike(String value) {
            addCriterion("scene_opentime like", value, "sceneOpentime");
            return (Criteria) this;
        }

        public Criteria andSceneOpentimeNotLike(String value) {
            addCriterion("scene_opentime not like", value, "sceneOpentime");
            return (Criteria) this;
        }

        public Criteria andSceneOpentimeIn(List<String> values) {
            addCriterion("scene_opentime in", values, "sceneOpentime");
            return (Criteria) this;
        }

        public Criteria andSceneOpentimeNotIn(List<String> values) {
            addCriterion("scene_opentime not in", values, "sceneOpentime");
            return (Criteria) this;
        }

        public Criteria andSceneOpentimeBetween(String value1, String value2) {
            addCriterion("scene_opentime between", value1, value2, "sceneOpentime");
            return (Criteria) this;
        }

        public Criteria andSceneOpentimeNotBetween(String value1, String value2) {
            addCriterion("scene_opentime not between", value1, value2, "sceneOpentime");
            return (Criteria) this;
        }

        public Criteria andSceneCouponIsNull() {
            addCriterion("scene_coupon is null");
            return (Criteria) this;
        }

        public Criteria andSceneCouponIsNotNull() {
            addCriterion("scene_coupon is not null");
            return (Criteria) this;
        }

        public Criteria andSceneCouponEqualTo(String value) {
            addCriterion("scene_coupon =", value, "sceneCoupon");
            return (Criteria) this;
        }

        public Criteria andSceneCouponNotEqualTo(String value) {
            addCriterion("scene_coupon <>", value, "sceneCoupon");
            return (Criteria) this;
        }

        public Criteria andSceneCouponGreaterThan(String value) {
            addCriterion("scene_coupon >", value, "sceneCoupon");
            return (Criteria) this;
        }

        public Criteria andSceneCouponGreaterThanOrEqualTo(String value) {
            addCriterion("scene_coupon >=", value, "sceneCoupon");
            return (Criteria) this;
        }

        public Criteria andSceneCouponLessThan(String value) {
            addCriterion("scene_coupon <", value, "sceneCoupon");
            return (Criteria) this;
        }

        public Criteria andSceneCouponLessThanOrEqualTo(String value) {
            addCriterion("scene_coupon <=", value, "sceneCoupon");
            return (Criteria) this;
        }

        public Criteria andSceneCouponLike(String value) {
            addCriterion("scene_coupon like", value, "sceneCoupon");
            return (Criteria) this;
        }

        public Criteria andSceneCouponNotLike(String value) {
            addCriterion("scene_coupon not like", value, "sceneCoupon");
            return (Criteria) this;
        }

        public Criteria andSceneCouponIn(List<String> values) {
            addCriterion("scene_coupon in", values, "sceneCoupon");
            return (Criteria) this;
        }

        public Criteria andSceneCouponNotIn(List<String> values) {
            addCriterion("scene_coupon not in", values, "sceneCoupon");
            return (Criteria) this;
        }

        public Criteria andSceneCouponBetween(String value1, String value2) {
            addCriterion("scene_coupon between", value1, value2, "sceneCoupon");
            return (Criteria) this;
        }

        public Criteria andSceneCouponNotBetween(String value1, String value2) {
            addCriterion("scene_coupon not between", value1, value2, "sceneCoupon");
            return (Criteria) this;
        }

        public Criteria andScenePicsIsNull() {
            addCriterion("scene_pics is null");
            return (Criteria) this;
        }

        public Criteria andScenePicsIsNotNull() {
            addCriterion("scene_pics is not null");
            return (Criteria) this;
        }

        public Criteria andScenePicsEqualTo(String value) {
            addCriterion("scene_pics =", value, "scenePics");
            return (Criteria) this;
        }

        public Criteria andScenePicsNotEqualTo(String value) {
            addCriterion("scene_pics <>", value, "scenePics");
            return (Criteria) this;
        }

        public Criteria andScenePicsGreaterThan(String value) {
            addCriterion("scene_pics >", value, "scenePics");
            return (Criteria) this;
        }

        public Criteria andScenePicsGreaterThanOrEqualTo(String value) {
            addCriterion("scene_pics >=", value, "scenePics");
            return (Criteria) this;
        }

        public Criteria andScenePicsLessThan(String value) {
            addCriterion("scene_pics <", value, "scenePics");
            return (Criteria) this;
        }

        public Criteria andScenePicsLessThanOrEqualTo(String value) {
            addCriterion("scene_pics <=", value, "scenePics");
            return (Criteria) this;
        }

        public Criteria andScenePicsLike(String value) {
            addCriterion("scene_pics like", value, "scenePics");
            return (Criteria) this;
        }

        public Criteria andScenePicsNotLike(String value) {
            addCriterion("scene_pics not like", value, "scenePics");
            return (Criteria) this;
        }

        public Criteria andScenePicsIn(List<String> values) {
            addCriterion("scene_pics in", values, "scenePics");
            return (Criteria) this;
        }

        public Criteria andScenePicsNotIn(List<String> values) {
            addCriterion("scene_pics not in", values, "scenePics");
            return (Criteria) this;
        }

        public Criteria andScenePicsBetween(String value1, String value2) {
            addCriterion("scene_pics between", value1, value2, "scenePics");
            return (Criteria) this;
        }

        public Criteria andScenePicsNotBetween(String value1, String value2) {
            addCriterion("scene_pics not between", value1, value2, "scenePics");
            return (Criteria) this;
        }

        public Criteria andSceneStarIsNull() {
            addCriterion("scene_star is null");
            return (Criteria) this;
        }

        public Criteria andSceneStarIsNotNull() {
            addCriterion("scene_star is not null");
            return (Criteria) this;
        }

        public Criteria andSceneStarEqualTo(String value) {
            addCriterion("scene_star =", value, "sceneStar");
            return (Criteria) this;
        }

        public Criteria andSceneStarNotEqualTo(String value) {
            addCriterion("scene_star <>", value, "sceneStar");
            return (Criteria) this;
        }

        public Criteria andSceneStarGreaterThan(String value) {
            addCriterion("scene_star >", value, "sceneStar");
            return (Criteria) this;
        }

        public Criteria andSceneStarGreaterThanOrEqualTo(String value) {
            addCriterion("scene_star >=", value, "sceneStar");
            return (Criteria) this;
        }

        public Criteria andSceneStarLessThan(String value) {
            addCriterion("scene_star <", value, "sceneStar");
            return (Criteria) this;
        }

        public Criteria andSceneStarLessThanOrEqualTo(String value) {
            addCriterion("scene_star <=", value, "sceneStar");
            return (Criteria) this;
        }

        public Criteria andSceneStarLike(String value) {
            addCriterion("scene_star like", value, "sceneStar");
            return (Criteria) this;
        }

        public Criteria andSceneStarNotLike(String value) {
            addCriterion("scene_star not like", value, "sceneStar");
            return (Criteria) this;
        }

        public Criteria andSceneStarIn(List<String> values) {
            addCriterion("scene_star in", values, "sceneStar");
            return (Criteria) this;
        }

        public Criteria andSceneStarNotIn(List<String> values) {
            addCriterion("scene_star not in", values, "sceneStar");
            return (Criteria) this;
        }

        public Criteria andSceneStarBetween(String value1, String value2) {
            addCriterion("scene_star between", value1, value2, "sceneStar");
            return (Criteria) this;
        }

        public Criteria andSceneStarNotBetween(String value1, String value2) {
            addCriterion("scene_star not between", value1, value2, "sceneStar");
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