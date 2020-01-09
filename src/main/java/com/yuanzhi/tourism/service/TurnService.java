package com.yuanzhi.tourism.service;

import com.yuanzhi.tourism.dao.TurnMapper;
import com.yuanzhi.tourism.entity.Turn;
import com.yuanzhi.tourism.entity.TurnExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: yuanzhi...
 * @Date: created in  2019/12/2 17:27
 */

@Service
public class TurnService {

    @Autowired
    TurnMapper turnMapper;

    public List<Turn> getTypeTurn(String turnType) {
        TurnExample turnExample = new TurnExample();
        turnExample.createCriteria().andTurnTypeEqualTo(turnType);
        return turnMapper.selectByExample(turnExample);
    }

    public List<Turn> getAll(Integer page, Integer limit) {
        return turnMapper.getAll(page,limit);
    }

    public Long getTurnNum() {
        return turnMapper.countByExample(null);
    }

    public void delTurn(Integer turnId) {
        turnMapper.deleteByPrimaryKey(turnId);
    }

    public void batchDelTurn(List<Integer> uidLst) {
        for (int i = 0; i < uidLst.size(); i++) {
            turnMapper.deleteByPrimaryKey(uidLst.get(i));
        }
    }

    public void upTurn(Turn turn) {
        TurnExample turnExample = new TurnExample();
        turnExample.createCriteria().andTurnIdEqualTo(turn.getTurnId());
        turnMapper.updateByExample(turn,turnExample);
    }

    public void addTurn(Turn turn) {
        turnMapper.insertSelective(turn);
    }

    public Turn getById(Integer turnId) {
        return turnMapper.selectByPrimaryKey(turnId);
    }
}
