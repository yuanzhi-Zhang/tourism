package com.yuanzhi.tourism.controller.user;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yuanzhi.tourism.dto.QuestionDTO;
import com.yuanzhi.tourism.entity.Question;
import com.yuanzhi.tourism.service.QuestionService;
import com.yuanzhi.tourism.utils.QiniuUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @Author: yuanzhi...
 * @Date: created in  2019/11/9 12:06
 */

@Controller
public class QuestionController {

    @Autowired
    QuestionService questionService;

    /**
     * 查询问题
     * @param page
     * @param size
     * @return
     */
    @PostMapping("/askAnswer")
    @ResponseBody
    public Map<String,Object> getAskAnswer(@RequestParam(value = "page",defaultValue = "1")int page,
                                          @RequestParam(value = "size",defaultValue = "3")int size){
        PageHelper.startPage(page,size);
        List<QuestionDTO>questionDTOList = questionService.getAll();
        Map<String,Object>askAnswer = new HashMap<>();
        PageInfo<QuestionDTO>pageInfo = new PageInfo<>(questionDTOList);
        List<Integer>pages = new ArrayList<>();
        askAnswer.put("total_size",pageInfo.getTotal());//总条数
        askAnswer.put("total_page",pageInfo.getPages());//总页数
        askAnswer.put("current_page",page);//当前页
        askAnswer.put("data",pageInfo.getList());//数据
        pages.add(page);
        for (int i = 1; i <= 4; i++) {
            if (page - i > 0) {
                pages.add(0, page - i);
            }
            if (page + i <= pageInfo.getPages()) {
                pages.add(page + i);
            }
        }
        askAnswer.put("pages",pages);//数据
        return askAnswer;
    }

    /**
     * 提问
     * @param questionCreatorId 用户
     * @param questionContent 问题内容
     * @param questionTitle 问题标题
     * @param questionDestiny 目的地
     * @param questionImg 问题的封面
     * @return
     */
    @PostMapping("/addQuestion")
    @ResponseBody
    public Map<String,Object> questionPublish(@RequestParam(value = "questionCreatorId", required = false)Integer questionCreatorId,
                                              @RequestParam(value = "questionContent", required = false)String questionContent,
                                              @RequestParam(value = "questionTitle", required = false)String questionTitle,
                                              @RequestParam(value = "questionDestiny", required = false)String questionDestiny,
                                              @RequestParam(value = "questionImg", required = false)MultipartFile questionImg){
        Map<String, Object> result = new HashMap<String, Object>();
        try {
            byte[] bytes = questionImg.getBytes();
            String imageName = UUID.randomUUID().toString();
            try {
                String url = QiniuUtil.put64image(bytes, imageName);
                Question question = new Question();
                question.setQuestionContent(questionContent);
                question.setQuestionCreatorId(questionCreatorId);
                question.setQuestionTitle(questionTitle);
                question.setQuestionDestiny(questionDestiny);
                question.setQuestionImg(url);
                Date date = new Date();
                SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd HH:mm"); //HH代表24小时制，hh代表12小时制
                String publishTime = dateFormat.format(date);
                question.setQuestionTime(publishTime);
                questionService.addQuestion(question);
                result.put("success",1);
            } catch (Exception e) {
                e.printStackTrace();
                result.put("success",0);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    @GetMapping("/qt/{questionId}")
    @ResponseBody
    public Map<String,Object> toAskDetail(@PathVariable(value = "questionId")Integer questionId){
        QuestionDTO questionDTO = questionService.getDetail(questionId);
        Map<String,Object>qtDetail = new HashMap<>();
        qtDetail.put("data",questionDTO);
        return qtDetail;
    }

}
