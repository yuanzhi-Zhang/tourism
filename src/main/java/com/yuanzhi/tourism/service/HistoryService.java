package com.yuanzhi.tourism.service;

import com.yuanzhi.tourism.dao.HistoryMapper;
import com.yuanzhi.tourism.dto.HistoryDTO;
import com.yuanzhi.tourism.entity.History;
import com.yuanzhi.tourism.entity.HistoryExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: yuanzhi...
 * @Date: created in  2019/11/6 19:15
 */

@Service
public class HistoryService {

    @Autowired
    HistoryMapper historyMapper;

    public void addHistory(History history) {
        historyMapper.insertSelective(history);
    }

    public void incTimes(Integer historyId) {
        historyMapper.incTimes(historyId);
    }

    public List<History> isExist(Integer type, Integer typeId, Integer userId) {
        HistoryExample historyExample = new HistoryExample();
        historyExample.createCriteria().andTypeIdEqualTo(typeId)
                .andHistoryTypeEqualTo(type)
                .andUserIdEqualTo(userId);
        return historyMapper.selectByExample(historyExample);
    }

    public List<History> getByUser(Integer userId) {
        HistoryExample historyExample = new HistoryExample();
        historyExample.createCriteria().andUserIdEqualTo(userId);
        return historyMapper.selectByExample(historyExample);
    }

    public List<HistoryDTO> getAll(Integer page, Integer limit) {
        return historyMapper.getAll(page,limit);
    }

    public Long countNum() {
        return historyMapper.countByExample(null);
    }
}
