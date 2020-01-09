package com.yuanzhi.tourism.entity;

import java.util.ArrayList;
import java.util.List;

public class HotelExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public HotelExample() {
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

        public Criteria andHotelIdIsNull() {
            addCriterion("hotel_id is null");
            return (Criteria) this;
        }

        public Criteria andHotelIdIsNotNull() {
            addCriterion("hotel_id is not null");
            return (Criteria) this;
        }

        public Criteria andHotelIdEqualTo(Integer value) {
            addCriterion("hotel_id =", value, "hotelId");
            return (Criteria) this;
        }

        public Criteria andHotelIdNotEqualTo(Integer value) {
            addCriterion("hotel_id <>", value, "hotelId");
            return (Criteria) this;
        }

        public Criteria andHotelIdGreaterThan(Integer value) {
            addCriterion("hotel_id >", value, "hotelId");
            return (Criteria) this;
        }

        public Criteria andHotelIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("hotel_id >=", value, "hotelId");
            return (Criteria) this;
        }

        public Criteria andHotelIdLessThan(Integer value) {
            addCriterion("hotel_id <", value, "hotelId");
            return (Criteria) this;
        }

        public Criteria andHotelIdLessThanOrEqualTo(Integer value) {
            addCriterion("hotel_id <=", value, "hotelId");
            return (Criteria) this;
        }

        public Criteria andHotelIdIn(List<Integer> values) {
            addCriterion("hotel_id in", values, "hotelId");
            return (Criteria) this;
        }

        public Criteria andHotelIdNotIn(List<Integer> values) {
            addCriterion("hotel_id not in", values, "hotelId");
            return (Criteria) this;
        }

        public Criteria andHotelIdBetween(Integer value1, Integer value2) {
            addCriterion("hotel_id between", value1, value2, "hotelId");
            return (Criteria) this;
        }

        public Criteria andHotelIdNotBetween(Integer value1, Integer value2) {
            addCriterion("hotel_id not between", value1, value2, "hotelId");
            return (Criteria) this;
        }

        public Criteria andHotelCityIsNull() {
            addCriterion("hotel_city is null");
            return (Criteria) this;
        }

        public Criteria andHotelCityIsNotNull() {
            addCriterion("hotel_city is not null");
            return (Criteria) this;
        }

        public Criteria andHotelCityEqualTo(String value) {
            addCriterion("hotel_city =", value, "hotelCity");
            return (Criteria) this;
        }

        public Criteria andHotelCityNotEqualTo(String value) {
            addCriterion("hotel_city <>", value, "hotelCity");
            return (Criteria) this;
        }

        public Criteria andHotelCityGreaterThan(String value) {
            addCriterion("hotel_city >", value, "hotelCity");
            return (Criteria) this;
        }

        public Criteria andHotelCityGreaterThanOrEqualTo(String value) {
            addCriterion("hotel_city >=", value, "hotelCity");
            return (Criteria) this;
        }

        public Criteria andHotelCityLessThan(String value) {
            addCriterion("hotel_city <", value, "hotelCity");
            return (Criteria) this;
        }

        public Criteria andHotelCityLessThanOrEqualTo(String value) {
            addCriterion("hotel_city <=", value, "hotelCity");
            return (Criteria) this;
        }

        public Criteria andHotelCityLike(String value) {
            addCriterion("hotel_city like", value, "hotelCity");
            return (Criteria) this;
        }

        public Criteria andHotelCityNotLike(String value) {
            addCriterion("hotel_city not like", value, "hotelCity");
            return (Criteria) this;
        }

        public Criteria andHotelCityIn(List<String> values) {
            addCriterion("hotel_city in", values, "hotelCity");
            return (Criteria) this;
        }

        public Criteria andHotelCityNotIn(List<String> values) {
            addCriterion("hotel_city not in", values, "hotelCity");
            return (Criteria) this;
        }

        public Criteria andHotelCityBetween(String value1, String value2) {
            addCriterion("hotel_city between", value1, value2, "hotelCity");
            return (Criteria) this;
        }

        public Criteria andHotelCityNotBetween(String value1, String value2) {
            addCriterion("hotel_city not between", value1, value2, "hotelCity");
            return (Criteria) this;
        }

        public Criteria andHotelNameZnIsNull() {
            addCriterion("hotel_name_ZN is null");
            return (Criteria) this;
        }

        public Criteria andHotelNameZnIsNotNull() {
            addCriterion("hotel_name_ZN is not null");
            return (Criteria) this;
        }

        public Criteria andHotelNameZnEqualTo(String value) {
            addCriterion("hotel_name_ZN =", value, "hotelNameZn");
            return (Criteria) this;
        }

        public Criteria andHotelNameZnNotEqualTo(String value) {
            addCriterion("hotel_name_ZN <>", value, "hotelNameZn");
            return (Criteria) this;
        }

        public Criteria andHotelNameZnGreaterThan(String value) {
            addCriterion("hotel_name_ZN >", value, "hotelNameZn");
            return (Criteria) this;
        }

        public Criteria andHotelNameZnGreaterThanOrEqualTo(String value) {
            addCriterion("hotel_name_ZN >=", value, "hotelNameZn");
            return (Criteria) this;
        }

        public Criteria andHotelNameZnLessThan(String value) {
            addCriterion("hotel_name_ZN <", value, "hotelNameZn");
            return (Criteria) this;
        }

        public Criteria andHotelNameZnLessThanOrEqualTo(String value) {
            addCriterion("hotel_name_ZN <=", value, "hotelNameZn");
            return (Criteria) this;
        }

        public Criteria andHotelNameZnLike(String value) {
            addCriterion("hotel_name_ZN like", value, "hotelNameZn");
            return (Criteria) this;
        }

        public Criteria andHotelNameZnNotLike(String value) {
            addCriterion("hotel_name_ZN not like", value, "hotelNameZn");
            return (Criteria) this;
        }

        public Criteria andHotelNameZnIn(List<String> values) {
            addCriterion("hotel_name_ZN in", values, "hotelNameZn");
            return (Criteria) this;
        }

        public Criteria andHotelNameZnNotIn(List<String> values) {
            addCriterion("hotel_name_ZN not in", values, "hotelNameZn");
            return (Criteria) this;
        }

        public Criteria andHotelNameZnBetween(String value1, String value2) {
            addCriterion("hotel_name_ZN between", value1, value2, "hotelNameZn");
            return (Criteria) this;
        }

        public Criteria andHotelNameZnNotBetween(String value1, String value2) {
            addCriterion("hotel_name_ZN not between", value1, value2, "hotelNameZn");
            return (Criteria) this;
        }

        public Criteria andHotelNameEnIsNull() {
            addCriterion("hotel_name_EN is null");
            return (Criteria) this;
        }

        public Criteria andHotelNameEnIsNotNull() {
            addCriterion("hotel_name_EN is not null");
            return (Criteria) this;
        }

        public Criteria andHotelNameEnEqualTo(String value) {
            addCriterion("hotel_name_EN =", value, "hotelNameEn");
            return (Criteria) this;
        }

        public Criteria andHotelNameEnNotEqualTo(String value) {
            addCriterion("hotel_name_EN <>", value, "hotelNameEn");
            return (Criteria) this;
        }

        public Criteria andHotelNameEnGreaterThan(String value) {
            addCriterion("hotel_name_EN >", value, "hotelNameEn");
            return (Criteria) this;
        }

        public Criteria andHotelNameEnGreaterThanOrEqualTo(String value) {
            addCriterion("hotel_name_EN >=", value, "hotelNameEn");
            return (Criteria) this;
        }

        public Criteria andHotelNameEnLessThan(String value) {
            addCriterion("hotel_name_EN <", value, "hotelNameEn");
            return (Criteria) this;
        }

        public Criteria andHotelNameEnLessThanOrEqualTo(String value) {
            addCriterion("hotel_name_EN <=", value, "hotelNameEn");
            return (Criteria) this;
        }

        public Criteria andHotelNameEnLike(String value) {
            addCriterion("hotel_name_EN like", value, "hotelNameEn");
            return (Criteria) this;
        }

        public Criteria andHotelNameEnNotLike(String value) {
            addCriterion("hotel_name_EN not like", value, "hotelNameEn");
            return (Criteria) this;
        }

        public Criteria andHotelNameEnIn(List<String> values) {
            addCriterion("hotel_name_EN in", values, "hotelNameEn");
            return (Criteria) this;
        }

        public Criteria andHotelNameEnNotIn(List<String> values) {
            addCriterion("hotel_name_EN not in", values, "hotelNameEn");
            return (Criteria) this;
        }

        public Criteria andHotelNameEnBetween(String value1, String value2) {
            addCriterion("hotel_name_EN between", value1, value2, "hotelNameEn");
            return (Criteria) this;
        }

        public Criteria andHotelNameEnNotBetween(String value1, String value2) {
            addCriterion("hotel_name_EN not between", value1, value2, "hotelNameEn");
            return (Criteria) this;
        }

        public Criteria andHotelAddressIsNull() {
            addCriterion("hotel_address is null");
            return (Criteria) this;
        }

        public Criteria andHotelAddressIsNotNull() {
            addCriterion("hotel_address is not null");
            return (Criteria) this;
        }

        public Criteria andHotelAddressEqualTo(String value) {
            addCriterion("hotel_address =", value, "hotelAddress");
            return (Criteria) this;
        }

        public Criteria andHotelAddressNotEqualTo(String value) {
            addCriterion("hotel_address <>", value, "hotelAddress");
            return (Criteria) this;
        }

        public Criteria andHotelAddressGreaterThan(String value) {
            addCriterion("hotel_address >", value, "hotelAddress");
            return (Criteria) this;
        }

        public Criteria andHotelAddressGreaterThanOrEqualTo(String value) {
            addCriterion("hotel_address >=", value, "hotelAddress");
            return (Criteria) this;
        }

        public Criteria andHotelAddressLessThan(String value) {
            addCriterion("hotel_address <", value, "hotelAddress");
            return (Criteria) this;
        }

        public Criteria andHotelAddressLessThanOrEqualTo(String value) {
            addCriterion("hotel_address <=", value, "hotelAddress");
            return (Criteria) this;
        }

        public Criteria andHotelAddressLike(String value) {
            addCriterion("hotel_address like", value, "hotelAddress");
            return (Criteria) this;
        }

        public Criteria andHotelAddressNotLike(String value) {
            addCriterion("hotel_address not like", value, "hotelAddress");
            return (Criteria) this;
        }

        public Criteria andHotelAddressIn(List<String> values) {
            addCriterion("hotel_address in", values, "hotelAddress");
            return (Criteria) this;
        }

        public Criteria andHotelAddressNotIn(List<String> values) {
            addCriterion("hotel_address not in", values, "hotelAddress");
            return (Criteria) this;
        }

        public Criteria andHotelAddressBetween(String value1, String value2) {
            addCriterion("hotel_address between", value1, value2, "hotelAddress");
            return (Criteria) this;
        }

        public Criteria andHotelAddressNotBetween(String value1, String value2) {
            addCriterion("hotel_address not between", value1, value2, "hotelAddress");
            return (Criteria) this;
        }

        public Criteria andHotelStarIsNull() {
            addCriterion("hotel_star is null");
            return (Criteria) this;
        }

        public Criteria andHotelStarIsNotNull() {
            addCriterion("hotel_star is not null");
            return (Criteria) this;
        }

        public Criteria andHotelStarEqualTo(String value) {
            addCriterion("hotel_star =", value, "hotelStar");
            return (Criteria) this;
        }

        public Criteria andHotelStarNotEqualTo(String value) {
            addCriterion("hotel_star <>", value, "hotelStar");
            return (Criteria) this;
        }

        public Criteria andHotelStarGreaterThan(String value) {
            addCriterion("hotel_star >", value, "hotelStar");
            return (Criteria) this;
        }

        public Criteria andHotelStarGreaterThanOrEqualTo(String value) {
            addCriterion("hotel_star >=", value, "hotelStar");
            return (Criteria) this;
        }

        public Criteria andHotelStarLessThan(String value) {
            addCriterion("hotel_star <", value, "hotelStar");
            return (Criteria) this;
        }

        public Criteria andHotelStarLessThanOrEqualTo(String value) {
            addCriterion("hotel_star <=", value, "hotelStar");
            return (Criteria) this;
        }

        public Criteria andHotelStarLike(String value) {
            addCriterion("hotel_star like", value, "hotelStar");
            return (Criteria) this;
        }

        public Criteria andHotelStarNotLike(String value) {
            addCriterion("hotel_star not like", value, "hotelStar");
            return (Criteria) this;
        }

        public Criteria andHotelStarIn(List<String> values) {
            addCriterion("hotel_star in", values, "hotelStar");
            return (Criteria) this;
        }

        public Criteria andHotelStarNotIn(List<String> values) {
            addCriterion("hotel_star not in", values, "hotelStar");
            return (Criteria) this;
        }

        public Criteria andHotelStarBetween(String value1, String value2) {
            addCriterion("hotel_star between", value1, value2, "hotelStar");
            return (Criteria) this;
        }

        public Criteria andHotelStarNotBetween(String value1, String value2) {
            addCriterion("hotel_star not between", value1, value2, "hotelStar");
            return (Criteria) this;
        }

        public Criteria andHotelStarNameIsNull() {
            addCriterion("hotel_star_name is null");
            return (Criteria) this;
        }

        public Criteria andHotelStarNameIsNotNull() {
            addCriterion("hotel_star_name is not null");
            return (Criteria) this;
        }

        public Criteria andHotelStarNameEqualTo(String value) {
            addCriterion("hotel_star_name =", value, "hotelStarName");
            return (Criteria) this;
        }

        public Criteria andHotelStarNameNotEqualTo(String value) {
            addCriterion("hotel_star_name <>", value, "hotelStarName");
            return (Criteria) this;
        }

        public Criteria andHotelStarNameGreaterThan(String value) {
            addCriterion("hotel_star_name >", value, "hotelStarName");
            return (Criteria) this;
        }

        public Criteria andHotelStarNameGreaterThanOrEqualTo(String value) {
            addCriterion("hotel_star_name >=", value, "hotelStarName");
            return (Criteria) this;
        }

        public Criteria andHotelStarNameLessThan(String value) {
            addCriterion("hotel_star_name <", value, "hotelStarName");
            return (Criteria) this;
        }

        public Criteria andHotelStarNameLessThanOrEqualTo(String value) {
            addCriterion("hotel_star_name <=", value, "hotelStarName");
            return (Criteria) this;
        }

        public Criteria andHotelStarNameLike(String value) {
            addCriterion("hotel_star_name like", value, "hotelStarName");
            return (Criteria) this;
        }

        public Criteria andHotelStarNameNotLike(String value) {
            addCriterion("hotel_star_name not like", value, "hotelStarName");
            return (Criteria) this;
        }

        public Criteria andHotelStarNameIn(List<String> values) {
            addCriterion("hotel_star_name in", values, "hotelStarName");
            return (Criteria) this;
        }

        public Criteria andHotelStarNameNotIn(List<String> values) {
            addCriterion("hotel_star_name not in", values, "hotelStarName");
            return (Criteria) this;
        }

        public Criteria andHotelStarNameBetween(String value1, String value2) {
            addCriterion("hotel_star_name between", value1, value2, "hotelStarName");
            return (Criteria) this;
        }

        public Criteria andHotelStarNameNotBetween(String value1, String value2) {
            addCriterion("hotel_star_name not between", value1, value2, "hotelStarName");
            return (Criteria) this;
        }

        public Criteria andHotelMainIdIsNull() {
            addCriterion("hotel_main_id is null");
            return (Criteria) this;
        }

        public Criteria andHotelMainIdIsNotNull() {
            addCriterion("hotel_main_id is not null");
            return (Criteria) this;
        }

        public Criteria andHotelMainIdEqualTo(String value) {
            addCriterion("hotel_main_id =", value, "hotelMainId");
            return (Criteria) this;
        }

        public Criteria andHotelMainIdNotEqualTo(String value) {
            addCriterion("hotel_main_id <>", value, "hotelMainId");
            return (Criteria) this;
        }

        public Criteria andHotelMainIdGreaterThan(String value) {
            addCriterion("hotel_main_id >", value, "hotelMainId");
            return (Criteria) this;
        }

        public Criteria andHotelMainIdGreaterThanOrEqualTo(String value) {
            addCriterion("hotel_main_id >=", value, "hotelMainId");
            return (Criteria) this;
        }

        public Criteria andHotelMainIdLessThan(String value) {
            addCriterion("hotel_main_id <", value, "hotelMainId");
            return (Criteria) this;
        }

        public Criteria andHotelMainIdLessThanOrEqualTo(String value) {
            addCriterion("hotel_main_id <=", value, "hotelMainId");
            return (Criteria) this;
        }

        public Criteria andHotelMainIdLike(String value) {
            addCriterion("hotel_main_id like", value, "hotelMainId");
            return (Criteria) this;
        }

        public Criteria andHotelMainIdNotLike(String value) {
            addCriterion("hotel_main_id not like", value, "hotelMainId");
            return (Criteria) this;
        }

        public Criteria andHotelMainIdIn(List<String> values) {
            addCriterion("hotel_main_id in", values, "hotelMainId");
            return (Criteria) this;
        }

        public Criteria andHotelMainIdNotIn(List<String> values) {
            addCriterion("hotel_main_id not in", values, "hotelMainId");
            return (Criteria) this;
        }

        public Criteria andHotelMainIdBetween(String value1, String value2) {
            addCriterion("hotel_main_id between", value1, value2, "hotelMainId");
            return (Criteria) this;
        }

        public Criteria andHotelMainIdNotBetween(String value1, String value2) {
            addCriterion("hotel_main_id not between", value1, value2, "hotelMainId");
            return (Criteria) this;
        }

        public Criteria andHotelPictureIsNull() {
            addCriterion("hotel_picture is null");
            return (Criteria) this;
        }

        public Criteria andHotelPictureIsNotNull() {
            addCriterion("hotel_picture is not null");
            return (Criteria) this;
        }

        public Criteria andHotelPictureEqualTo(String value) {
            addCriterion("hotel_picture =", value, "hotelPicture");
            return (Criteria) this;
        }

        public Criteria andHotelPictureNotEqualTo(String value) {
            addCriterion("hotel_picture <>", value, "hotelPicture");
            return (Criteria) this;
        }

        public Criteria andHotelPictureGreaterThan(String value) {
            addCriterion("hotel_picture >", value, "hotelPicture");
            return (Criteria) this;
        }

        public Criteria andHotelPictureGreaterThanOrEqualTo(String value) {
            addCriterion("hotel_picture >=", value, "hotelPicture");
            return (Criteria) this;
        }

        public Criteria andHotelPictureLessThan(String value) {
            addCriterion("hotel_picture <", value, "hotelPicture");
            return (Criteria) this;
        }

        public Criteria andHotelPictureLessThanOrEqualTo(String value) {
            addCriterion("hotel_picture <=", value, "hotelPicture");
            return (Criteria) this;
        }

        public Criteria andHotelPictureLike(String value) {
            addCriterion("hotel_picture like", value, "hotelPicture");
            return (Criteria) this;
        }

        public Criteria andHotelPictureNotLike(String value) {
            addCriterion("hotel_picture not like", value, "hotelPicture");
            return (Criteria) this;
        }

        public Criteria andHotelPictureIn(List<String> values) {
            addCriterion("hotel_picture in", values, "hotelPicture");
            return (Criteria) this;
        }

        public Criteria andHotelPictureNotIn(List<String> values) {
            addCriterion("hotel_picture not in", values, "hotelPicture");
            return (Criteria) this;
        }

        public Criteria andHotelPictureBetween(String value1, String value2) {
            addCriterion("hotel_picture between", value1, value2, "hotelPicture");
            return (Criteria) this;
        }

        public Criteria andHotelPictureNotBetween(String value1, String value2) {
            addCriterion("hotel_picture not between", value1, value2, "hotelPicture");
            return (Criteria) this;
        }

        public Criteria andHotelPriceIsNull() {
            addCriterion("hotel_price is null");
            return (Criteria) this;
        }

        public Criteria andHotelPriceIsNotNull() {
            addCriterion("hotel_price is not null");
            return (Criteria) this;
        }

        public Criteria andHotelPriceEqualTo(String value) {
            addCriterion("hotel_price =", value, "hotelPrice");
            return (Criteria) this;
        }

        public Criteria andHotelPriceNotEqualTo(String value) {
            addCriterion("hotel_price <>", value, "hotelPrice");
            return (Criteria) this;
        }

        public Criteria andHotelPriceGreaterThan(String value) {
            addCriterion("hotel_price >", value, "hotelPrice");
            return (Criteria) this;
        }

        public Criteria andHotelPriceGreaterThanOrEqualTo(String value) {
            addCriterion("hotel_price >=", value, "hotelPrice");
            return (Criteria) this;
        }

        public Criteria andHotelPriceLessThan(String value) {
            addCriterion("hotel_price <", value, "hotelPrice");
            return (Criteria) this;
        }

        public Criteria andHotelPriceLessThanOrEqualTo(String value) {
            addCriterion("hotel_price <=", value, "hotelPrice");
            return (Criteria) this;
        }

        public Criteria andHotelPriceLike(String value) {
            addCriterion("hotel_price like", value, "hotelPrice");
            return (Criteria) this;
        }

        public Criteria andHotelPriceNotLike(String value) {
            addCriterion("hotel_price not like", value, "hotelPrice");
            return (Criteria) this;
        }

        public Criteria andHotelPriceIn(List<String> values) {
            addCriterion("hotel_price in", values, "hotelPrice");
            return (Criteria) this;
        }

        public Criteria andHotelPriceNotIn(List<String> values) {
            addCriterion("hotel_price not in", values, "hotelPrice");
            return (Criteria) this;
        }

        public Criteria andHotelPriceBetween(String value1, String value2) {
            addCriterion("hotel_price between", value1, value2, "hotelPrice");
            return (Criteria) this;
        }

        public Criteria andHotelPriceNotBetween(String value1, String value2) {
            addCriterion("hotel_price not between", value1, value2, "hotelPrice");
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