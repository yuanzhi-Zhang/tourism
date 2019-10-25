package com.yuanzhi.tourism.service;

import com.yuanzhi.tourism.dao.JourneyMapper;
import com.yuanzhi.tourism.entity.Journey;
import com.yuanzhi.tourism.entity.JourneyExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: yuanzhi...
 * @Date: created in  2019/10/14 20:44
 */
@Service
public class JourneyService {

    @Autowired
    JourneyMapper journeyMapper;

    /**
     * 用户发表游记（游记添加）
     * @param journey 游记内容（对象）
     */
    public void addJourney(Journey journey){
        journeyMapper.insertSelective(journey);
    }

    /**
     * 获取具体某篇游记
     * @param id
     * @return
     */
    public Journey getJourney(Integer id) {
//        Journey journey = new Journey();
//        journey.setTid(id);
//        journey.setReadtimes(1);
        journeyMapper.incView(id);
        return journeyMapper.selectWithUserByPrimaryKey(id);
    }

    /**
     * 获取带有用户信息的游记
     * @return
     */
    public List<Journey> getAllJourney() {
        return journeyMapper.selectWithUser();
    }


    public List<Journey> findAll() {
        return journeyMapper.selectByExample(null);
    }

    /**
     * 获取某一用户的游记
     * @param uid
     * @return
     */
    public List<Journey> getOwnJourney(Integer uid) {
        JourneyExample journeyExample = new JourneyExample();
        journeyExample.createCriteria().andUseridEqualTo(uid);
        journeyExample.setOrderByClause("publishTime desc");
        return journeyMapper.selectByExample(journeyExample);
    }
}
