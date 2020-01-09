package com.yuanzhi.tourism.service;

import com.yuanzhi.tourism.dao.QuestionMapper;
import com.yuanzhi.tourism.dto.QuestionDTO;
import com.yuanzhi.tourism.entity.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: yuanzhi...
 * @Date: created in  2019/11/9 12:09
 */

@Service
public class QuestionService {

    @Autowired
    QuestionMapper questionMapper;

    public void addQuestion(Question question) {
        questionMapper.insertSelective(question);
    }

    public List<QuestionDTO> getAll() {
        return questionMapper.selectWithUser();
    }

    public QuestionDTO getDetail(Integer questionId) {
        questionMapper.incView(questionId);
        return questionMapper.selectWithUserByPrimarry(questionId);
    }
}
