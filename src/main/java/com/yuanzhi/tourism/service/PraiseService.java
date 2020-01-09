package com.yuanzhi.tourism.service;

import com.yuanzhi.tourism.dao.PraiseMapper;
import com.yuanzhi.tourism.entity.Praise;
import com.yuanzhi.tourism.entity.PraiseExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: yuanzhi...
 * @Date: created in  2019/12/3 22:18
 */

@Service
public class PraiseService {

    @Autowired
    PraiseMapper praiseMapper;

    public void addPraise(Praise praise) {
        praiseMapper.insertSelective(praise);
    }

    public void deletePraise(Praise praise) {
        PraiseExample praiseExample = new PraiseExample();
        praiseExample.createCriteria().andPraiseTypeEqualTo(praise.getPraiseType())
                .andPraiseTypeIdEqualTo(praise.getPraiseTypeId())
                .andUseridEqualTo(praise.getUserid());
        praiseMapper.deleteByExample(praiseExample);
    }

    public Integer selectPraise(Praise praise) {
        PraiseExample praiseExample = new PraiseExample();
        praiseExample.createCriteria().andUseridEqualTo(praise.getUserid())
                .andPraiseTypeIdEqualTo(praise.getPraiseTypeId())
                .andPraiseTypeEqualTo(praise.getPraiseType());
        return praiseMapper.selectByExample(praiseExample).size();
    }
}
