package com.yuanzhi.tourism.service;

import com.yuanzhi.tourism.dao.RemainMapper;
import com.yuanzhi.tourism.dto.RemainResultDTO;
import com.yuanzhi.tourism.entity.Remain;
import com.yuanzhi.tourism.entity.RemainExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: yuanzhi...
 * @Date: created in  2019/10/24 10:51
 */
@Service
public class RemainService {

    @Autowired
    RemainMapper remainMapper;

    public List<RemainResultDTO> getAllRemain(Integer uid) {
        return remainMapper.selectWithUser(uid);
    }

    public void addRemain(Remain remain) {
        remainMapper.insertSelective(remain);
    }

    public void deleteRemain(Integer remainId) {
        remainMapper.deleteByPrimaryKey(remainId);
    }
}
