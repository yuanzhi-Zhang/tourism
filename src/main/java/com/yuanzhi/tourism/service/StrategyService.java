package com.yuanzhi.tourism.service;

import com.yuanzhi.tourism.dao.StrategyMapper;
import com.yuanzhi.tourism.dto.RefreshNumDTO;
import com.yuanzhi.tourism.dto.StrategyDTO;
import com.yuanzhi.tourism.entity.Strategy;
import com.yuanzhi.tourism.entity.StrategyExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: yuanzhi...
 * @Date: created in  2019/12/3 10:53
 */

@Service
public class StrategyService {

    @Autowired
    StrategyMapper strategyMapper;

    public List<Strategy> getStrategyPage(int page, int size) {
        return strategyMapper.getStrategyPage(page,size);
    }

    /**
     * 添加攻略
     * @param strategy
     */
    public void addStrategy(Strategy strategy) {
        strategyMapper.insertSelective(strategy);
    }

    /**
     * 获取分页攻略
     * @return
     */
    public List<Strategy> getStrategy() {
        return strategyMapper.selectByExample(null);
    }

    /**
     * 获取攻略详情
     * @param strategyId
     * @return
     */
    public Strategy getDetail(Integer strategyId) {
        return strategyMapper.selectByPrimaryKey(strategyId);
    }

    /**
     * 阅读数加一
     * @param strategyId
     */
    public void incView(Integer strategyId) {
        strategyMapper.incView(strategyId);
    }

    /**
     * 点赞数加一
     * @param strategyId
     */
    public void incPraise(Integer strategyId) {
        strategyMapper.incPraise(strategyId);
    }

    /**
     * 评论数加一
     * @param strategyId
     */
    public void incComment(Integer strategyId) {
        strategyMapper.incComment(strategyId);
    }

    /**
     * 收藏数加一
     * @param strategyId
     */
    public void incCollect(Integer strategyId) {
        strategyMapper.incCollect(strategyId);
    }

    /**
     * 点赞数减一
     * @param typeId
     */
    public void downPraise(Integer typeId) {
        strategyMapper.downPraise(typeId);
    }

    /**
     * 收藏数减一
     * @param typeId
     */
    public void downCollect(Integer typeId) {
        strategyMapper.downCollect(typeId);
    }

    public RefreshNumDTO refreshNum(Integer strategyId) {
        return strategyMapper.refreshNum(strategyId);
    }

    /**
     * 获取个人发表过的攻略
     * @param uid
     * @return
     */
    public List<Strategy> getStrategyOwn(int uid) {
        StrategyExample strategyExample = new StrategyExample();
        strategyExample.createCriteria().andUserIdEqualTo(uid);
        return strategyMapper.selectByExample(strategyExample);
    }

    /**
     * 根据地名模糊查询
     * @param title
     * @return
     */
    public List<Strategy> getStrategyLike(String title) {
        StrategyExample strategyExample = new StrategyExample();
        strategyExample.createCriteria().andStrategyTitleLike("%" +title+ "%");
        return strategyMapper.selectByExample(strategyExample);
    }

    public List<Strategy> getStrategyByValue(String values) {
        StrategyExample strategyExample = new StrategyExample();
        strategyExample.createCriteria().andStrategyTitleEqualTo(values);
        return strategyMapper.selectByExample(strategyExample);
    }

    public List<Strategy> selectThreePraiseMost() {
        return strategyMapper.selectThreePraiseMost();
    }

    public Long countNum() {
        return strategyMapper.countByExample(null);
    }

    public List<StrategyDTO> getAll(Integer page, Integer limit) {
        return strategyMapper.getAll(page,limit);
    }

    public void deleteStrategy(Integer strategyId) {
        strategyMapper.deleteByPrimaryKey(strategyId);
    }

    public void batchDelStrategy(List<Integer> uidLst) {
        for (int i = 0; i < uidLst.size(); i++) {
            strategyMapper.deleteByPrimaryKey(uidLst.get(i));
        }
    }

}
