package com.yuanzhi.tourism.entity;

import lombok.Data;

@Data
public class Hotel {
    private Integer hotelId;

    private String hotelCity;

    private String hotelNameZn;

    private String hotelNameEn;

    private String hotelAddress;

    private String hotelStar;

    private String hotelStarName;

    private String hotelMainId;

    private String hotelPicture;

    private String hotelPrice;

    public Integer getHotelId() {
        return hotelId;
    }

    public void setHotelId(Integer hotelId) {
        this.hotelId = hotelId;
    }

    public String getHotelCity() {
        return hotelCity;
    }

    public void setHotelCity(String hotelCity) {
        this.hotelCity = hotelCity == null ? null : hotelCity.trim();
    }

    public String getHotelNameZn() {
        return hotelNameZn;
    }

    public void setHotelNameZn(String hotelNameZn) {
        this.hotelNameZn = hotelNameZn == null ? null : hotelNameZn.trim();
    }

    public String getHotelNameEn() {
        return hotelNameEn;
    }

    public void setHotelNameEn(String hotelNameEn) {
        this.hotelNameEn = hotelNameEn == null ? null : hotelNameEn.trim();
    }

    public String getHotelAddress() {
        return hotelAddress;
    }

    public void setHotelAddress(String hotelAddress) {
        this.hotelAddress = hotelAddress == null ? null : hotelAddress.trim();
    }

    public String getHotelStar() {
        return hotelStar;
    }

    public void setHotelStar(String hotelStar) {
        this.hotelStar = hotelStar == null ? null : hotelStar.trim();
    }

    public String getHotelStarName() {
        return hotelStarName;
    }

    public void setHotelStarName(String hotelStarName) {
        this.hotelStarName = hotelStarName == null ? null : hotelStarName.trim();
    }

    public String getHotelMainId() {
        return hotelMainId;
    }

    public void setHotelMainId(String hotelMainId) {
        this.hotelMainId = hotelMainId == null ? null : hotelMainId.trim();
    }

    public String getHotelPicture() {
        return hotelPicture;
    }

    public void setHotelPicture(String hotelPicture) {
        this.hotelPicture = hotelPicture == null ? null : hotelPicture.trim();
    }

    public String getHotelPrice() {
        return hotelPrice;
    }

    public void setHotelPrice(String hotelPrice) {
        this.hotelPrice = hotelPrice == null ? null : hotelPrice.trim();
    }
}