package com.yuanzhi.tourism.service;

import com.yuanzhi.tourism.dao.HotelMapper;
import com.yuanzhi.tourism.entity.Hotel;
import com.yuanzhi.tourism.entity.HotelExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: yuanzhi...
 * @Date: created in  2019/12/2 11:21
 */

@Service
public class HotelService {

    @Autowired
    HotelMapper hotelMapper;

    public void addHotel(Hotel apidata) {
        hotelMapper.insertSelective(apidata);
    }

    public List<Hotel> getHotel(String localCity) {
        HotelExample hotelExample = new HotelExample();
        hotelExample.createCriteria().andHotelCityEqualTo(localCity);
        return hotelMapper.selectByExample(hotelExample);
    }

    public long count(String localCity) {
        HotelExample hotelExample = new HotelExample();
        hotelExample.createCriteria().andHotelCityEqualTo(localCity);
        return hotelMapper.countByExample(hotelExample);
    }

    public void getDetail(String hotelId) {
    }

    public List<Hotel> getAll(Integer page, Integer limit) {
        return hotelMapper.getAll(page,limit);
    }

    public Long hotelNum() {
        return hotelMapper.countByExample(null);
    }

    public void deleteHotel(Integer companyId) {
        hotelMapper.deleteByPrimaryKey(companyId);
    }

    public void batchDelHotel(List<Integer> uidLst) {
        for (int i = 0; i < uidLst.size(); i++) {
            hotelMapper.deleteByPrimaryKey(uidLst.get(i));
        }
    }
}
