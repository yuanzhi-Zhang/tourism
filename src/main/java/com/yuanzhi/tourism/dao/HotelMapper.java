package com.yuanzhi.tourism.dao;

import com.yuanzhi.tourism.entity.Hotel;
import com.yuanzhi.tourism.entity.HotelExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface HotelMapper {
    long countByExample(HotelExample example);

    int deleteByExample(HotelExample example);

    int deleteByPrimaryKey(Integer hotelId);

    int insert(Hotel record);

    int insertSelective(Hotel record);

    List<Hotel> selectByExample(HotelExample example);

    List<Hotel> selectByPage(@Param("hotelCity")String localCity,@Param("page")Integer page,@Param("limit")Integer limit);

    Hotel selectByPrimaryKey(Integer hotelId);

    int updateByExampleSelective(@Param("record") Hotel record, @Param("example") HotelExample example);

    int updateByExample(@Param("record") Hotel record, @Param("example") HotelExample example);

    int updateByPrimaryKeySelective(Hotel record);

    int updateByPrimaryKey(Hotel record);

    List<Hotel> getAll(@Param("page")Integer page, @Param("limit")Integer limit);
}