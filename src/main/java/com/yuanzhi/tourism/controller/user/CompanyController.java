package com.yuanzhi.tourism.controller.user;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yuanzhi.tourism.common.CosineSimilarity;
import com.yuanzhi.tourism.common.SimilarCompute;
import com.yuanzhi.tourism.dto.CompanyDTO;
import com.yuanzhi.tourism.dto.CompanyDTOS;
import com.yuanzhi.tourism.entity.Company;
import com.yuanzhi.tourism.service.CompanyService;
import com.yuanzhi.tourism.utils.QiniuUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @Author: yuanzhi...
 * @Date: created in  2019/12/5 13:16
 */

@Controller
public class CompanyController {

    @Autowired
    CompanyService companyService;

    /**
     * 查询结伴
     * @param page
     * @param size
     * @return
     */
    @PostMapping("/company/getAll")
    @ResponseBody
    public Map<String,Object> getAll(@RequestParam(value = "page",defaultValue = "1")int page,
                                     @RequestParam(value = "size",defaultValue = "7")int size){
        Map<String,Object> map = new HashMap<String, Object>();
        PageHelper.startPage(page,size);
        List<CompanyDTO> companyList = companyService.selectWithUser();
        List<Integer> pages = getIntegers(page, map, companyList);
        map.put("pages",pages);
        return map;
    }

    /**
     * 查询个人的所有结伴
     * @param page
     * @param size
     * @return
     */
    @PostMapping("/company/getAllOwn")
    @ResponseBody
    public Map<String,Object> getAllOwn(@RequestParam(value = "page",defaultValue = "1")int page,
                                     @RequestParam(value = "size",defaultValue = "7")int size,
                                     @RequestParam(value = "userId")Integer userId){
        Map<String,Object> map = new HashMap<String, Object>();
        PageHelper.startPage(page,size);
        List<CompanyDTO> companyList = companyService.getAllOwn(userId);
        List<Integer> pages = getIntegers(page, map, companyList);
        map.put("pages",pages);
        return map;
    }

    /**
     * 获取近六十天内将要出发的
     * @param page
     * @param size
     * @return
     * @throws ParseException
     */
    @PostMapping("/company/getAllNew")
    @ResponseBody
    public Map<String,Object> getAllNew(@RequestParam(value = "page",defaultValue = "1")int page,
                                     @RequestParam(value = "size",defaultValue = "7")int size) throws ParseException {
        Map<String,Object> map = new HashMap<String, Object>();
        PageHelper.startPage(page,size);
        List<CompanyDTO> companyList = companyService.selectWithUserNew();
        List<Integer> pages = getIntegers(page, map, companyList);
        map.put("pages",pages);
        return map;
    }

    /**
     * 获取今天内将要出发的结伴
     * @param page
     * @param size
     * @return
     * @throws ParseException
     */
    @PostMapping("/company/selectWithUserToday")
    @ResponseBody
    public Map<String,Object> selectWithUserToday(@RequestParam(value = "page",defaultValue = "1")int page,
                                     @RequestParam(value = "size",defaultValue = "7")int size) throws ParseException {
        Map<String,Object> map = new HashMap<String, Object>();
        PageHelper.startPage(page,size);
        List<CompanyDTO> companyList = companyService.selectWithUserToday();
        List<Integer> pages = getIntegers(page, map, companyList);
        map.put("pages",pages);
        return map;
    }

    /**
     * 查询一个月内将要出发的结伴
     * @param page
     * @param size
     * @return
     * @throws ParseException
     */
    @PostMapping("/company/selectWithUserMonth")
    @ResponseBody
    public Map<String,Object> selectWithUserMonth(@RequestParam(value = "page",defaultValue = "1")int page,
                                     @RequestParam(value = "size",defaultValue = "7")int size) throws ParseException {
        Map<String,Object> map = new HashMap<String, Object>();
        PageHelper.startPage(page,size);
        List<CompanyDTO> companyList = companyService.selectWithUserMonth();
        List<Integer> pages = getIntegers(page, map, companyList);
        map.put("pages",pages);
        return map;
    }

    /**
     * 查询一到三个月内将要出发的结伴
     * @param page
     * @param size
     * @return
     * @throws ParseException
     */
    @PostMapping("/company/selectWithUserThreeMonth")
    @ResponseBody
    public Map<String,Object> selectWithUserThreeMonth(@RequestParam(value = "page",defaultValue = "1")int page,
                                     @RequestParam(value = "size",defaultValue = "7")int size) throws ParseException {
        Map<String,Object> map = new HashMap<String, Object>();
        PageHelper.startPage(page,size);
        List<CompanyDTO> companyList = companyService.selectWithUserThreeMonth();
        List<Integer> pages = getIntegers(page, map, companyList);
        map.put("pages",pages);
        return map;
    }

    /**
     * 查询三个月以上将要出发的结伴
     * @param page
     * @param size
     * @return
     * @throws ParseException
     */
    @PostMapping("/company/selectWithUserMoreThreeMonth")
    @ResponseBody
    public Map<String,Object> selectWithUserMoreThreeMonth(@RequestParam(value = "page",defaultValue = "1")int page,
                                     @RequestParam(value = "size",defaultValue = "7")int size) throws ParseException {
        Map<String,Object> map = new HashMap<String, Object>();
        PageHelper.startPage(page,size);
        List<CompanyDTO> companyList = companyService.selectWithUserMoreThreeMonth();
        List<Integer> pages = getIntegers(page, map, companyList);
        map.put("pages",pages);
        return map;
    }

    /**
     * 查询阅读次数最多的前三个结伴
     * @return
     * @throws ParseException
     */
    @PostMapping("/company/selectWithUserThreeNumMost")
    @ResponseBody
    public Map<String,Object> selectWithUserThreeNumMost() throws ParseException {
        Map<String,Object> map = new HashMap<String, Object>();
        List<CompanyDTO> companyList = companyService.selectWithUserThreeNumMost();
        map.put("companyList",companyList);
        return map;
    }

    /**
     * 根据用户点击的攻略或游记推荐相似的结伴，若不满足形似条件，则推荐关注数最多的三个结伴
     * @return
     * @throws ParseException
     */
    @PostMapping("/company/adviceSimilar")
    @ResponseBody
    public Map<String,Object> adviceSimilar(@RequestBody Map<String,String> data){
        Map<String,Object> map = new HashMap<String, Object>();
        String values = data.get("values");
        List<CompanyDTO> companyList = companyService.selectWithUser();
        List<CompanyDTO> companyList1 = new ArrayList<CompanyDTO>();
        CosineSimilarity cosineSimilarity = new CosineSimilarity();
        for (int i = 0; i < companyList.size(); i++) {
            if(cosineSimilarity.cos(values, companyList.get(i).getCompanyTitle()) >= 0.3){
                companyList1.add(companyList.get(i));
            }
        }
        if (companyList1.size() == 0){
            List<CompanyDTO> companyList2 = companyService.selectWithUserThreeAttendNumMost();
            map.put("companyList",companyList2);
            return map;
        }
        map.put("companyList",companyList1);
        return map;
    }

    /**
     * 根据目的地查询对应的结伴
     * @param
     * @return
     */
    @PostMapping("/company/getByDestiny")
    @ResponseBody
    public Map<String,Object> getByDestiny(@RequestParam(value = "page",defaultValue = "1")int page,
                                           @RequestParam(value = "size",defaultValue = "7")int size,
                                           @RequestParam(value = "destiny")String destiny){
        Map<String,Object> map = new HashMap<String, Object>();
        List<CompanyDTO> companyList = companyService.getByDestiny(destiny);
        List<Integer> pages = getIntegers(page, map, companyList);
        map.put("pages",pages);
        return map;
    }

    /**
     * 分页的公共方法
     * @param page
     * @param map
     * @param companyList
     * @return
     */
    private List<Integer> getIntegers(@RequestParam(value = "page", defaultValue = "1") int page, Map<String, Object> map, List<CompanyDTO> companyList) {
        PageInfo<CompanyDTO> pageInfo = new PageInfo<>(companyList);
        List<Integer>pages = new ArrayList<>();
        map.put("total_size",pageInfo.getTotal());//总条数
        map.put("total_page",pageInfo.getPages());//总页数
        map.put("current_page",page);//当前页
        map.put("companyList",pageInfo.getList());//数据
        pages.add(page);
        for (int i = 1; i <= 5; i++) {
            if (page - i > 0) {
                pages.add(0, page - i);
            }

            if (page + i <= pageInfo.getPages()) {
                pages.add(page + i);
            }
        }
        return pages;
    }

    /**
     * 获取最近15天内发布的结伴
     * @param page
     * @param size
     * @return
     * @throws ParseException
     */
    @PostMapping("/company/getAllNewUp")
    @ResponseBody
    public Map<String,Object> getAllNewUp(@RequestParam(value = "page",defaultValue = "1")int page,
                                     @RequestParam(value = "size",defaultValue = "7")int size) throws ParseException {
        Map<String,Object> map = new HashMap<String, Object>();
        PageHelper.startPage(page,size);
        List<CompanyDTO> companyList = companyService.selectWithUserNewUp();
        List<Integer> pages = getIntegers(page, map, companyList);
        map.put("pages",pages);
        return map;
    }

    /**
     * 发布结伴
     * @param file
     * @param uid
     * @param title
     * @param companyPeopleNum
     * @param companyStartTime
     * @param companyDuringTime
     * @param content
     * @param companyStartArea
     * @param companyEndArea
     * @return
     */
    @PostMapping("/company/add")
    @ResponseBody
    public Map<String ,Object> addStrategy(@RequestParam(value="file", required = false) MultipartFile file,
                                           @RequestParam(value = "uid",required = false) Integer uid,
                                           @RequestParam(value = "title",required = false) String title,
                                           @RequestParam(value = "companyPeopleNum",required = false) Integer companyPeopleNum,
                                           @RequestParam(value = "companyStartTime",required = false) String companyStartTime,
                                           @RequestParam(value = "companyDuringTime",required = false) String companyDuringTime,
                                           @RequestParam(value = "content",required = false) String content,
                                           @RequestParam(value = "companyStartArea",required = false) String companyStartArea,
                                           @RequestParam(value = "companyEndArea",required = false) String companyEndArea){
        Map<String,Object> map = new HashMap<String,Object>();
        try {
            byte[] bytes1 = file.getBytes();
            String imageName1 = UUID.randomUUID().toString();
            try {
                Date date = new Date();
                SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd"); //HH代表24小时制，hh代表12小时制
                String publishTime = dateFormat.format(date);
                Company company = new Company();
                String url1 = QiniuUtil.put64image(bytes1, imageName1);
                company.setCompanyContent(content);
                company.setCompanyDuringTime(companyDuringTime);
                company.setCompanyEndArea(companyEndArea);
                company.setCompanyMainImg(url1);
                company.setCompanyOwnerId(uid);
                company.setCompanyPeopleNum(companyPeopleNum);
                company.setCompanyStartArea(companyStartArea);
                company.setCompanyStartTime(dateFormat.parse(companyStartTime));
                company.setCompanyTitle(title);
                company.setCompanyTime(publishTime);
                company.setCompanyAttendNum(0);
                company.setCompanyEnterNum(0);
                company.setCompanyViewNum(0);
                company.setCompanyCommentNum(0);
                map.put("imgUrl1",url1);
                companyService.addCompany(company);
                map.put("success",1);
            } catch (Exception e) {
                e.printStackTrace();
                map.put("success",0);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return map;
    }

    /**
     * 获取结伴的总数量
     * @return
     */
    @PostMapping("/company/countNum")
    @ResponseBody
    public Map<String ,Object> countNum(){
        Map<String,Object> map = new HashMap<String,Object>();
        Long companyNum = companyService.countNum();
        map.put("companyNum",companyNum);
        return map;
    }

    /**
     * 查询今天之内，一个月内，一到三个月内，三个月以上将要出发的结伴数
     * @return
     */
    @PostMapping("/company/selectWithUserTypeNum")
    @ResponseBody
    public Map<String ,Object> selectWithUserTodayNum(){
        Map<String,Object> map = new HashMap<String,Object>();
        Long companyTodayNum = companyService.selectWithUserTodayNum();
        Long companyMonthNum = companyService.selectWithUserMonthNum();
        Long companyThreeMonthNum = companyService.selectWithUserThreeMonthNum();
        Long companyMoreThreeMonthNum = companyService.selectWithUserMoreThreeMonthNum();
        map.put("companyTodayNum",companyTodayNum);
        map.put("companyMonthNum",companyMonthNum);
        map.put("companyThreeMonthNum",companyThreeMonthNum);
        map.put("companyMoreThreeMonthNum",companyMoreThreeMonthNum);
        return map;
    }

    /**
     * 阅读数加一
     * @param data
     */
    @PostMapping("/company/incView")
    @ResponseBody
    public Map<String,Object> incView(@RequestBody Map<String,String> data){
        Map<String,Object> map = new HashMap<String, Object>();
        Integer companyId = Integer.parseInt(data.get("companyId"));
        companyService.incView(companyId);
        map.put("code",200);
        return map;
    }

    /**
     * 关注数加一
     * @param data
     * @return
     */
    @PostMapping("/company/incAttendNum")
    @ResponseBody
    public Map<String,Object> incAttendNum(@RequestBody Map<String,String> data){
        Map<String,Object> map = new HashMap<String, Object>();
        Integer companyId = Integer.parseInt(data.get("companyId"));
        companyService.incAttendNum(companyId);
        map.put("code",200);
        return map;
    }

    /**
     * 获取某篇结伴的详情
     * @param companyId
     * @return
     */
    @PostMapping("/company/getOneDetail")
    @ResponseBody
    public Map<String ,Object> getOneDetail(@RequestParam(value = "companyId",required = false) Integer companyId){
        Map<String,Object> map = new HashMap<String,Object>();
        CompanyDTO companyDTO = companyService.selectWithUserById(companyId);
        map.put("companyDetail",companyDTO);
        return map;
    }

    /**
     * 跳转到结伴详情
     * @param companyId
     * @return
     */
    @GetMapping("/company/{companyId}.html")
    public String toCompany(@PathVariable(name = "companyId")Integer companyId, Model model){
        /*CompanyDTO companyDTO = companyService.selectWithUserById(companyId);
        model.addAttribute("company",companyDTO);*/
        return "user/companyDetail";
    }

    /**
     * 分页查询所有结伴
     * @param page
     * @param limit
     * @return
     */
    @GetMapping("/company/getAll")
    @ResponseBody
    public Map<String,Object> userList(@RequestParam(value="page")Integer page,
                                       @RequestParam(value="limit")Integer limit){
        Map<String,Object> map = new HashMap<>();
        page = (page-1) * limit;
        List<CompanyDTOS> strategyDTOS = companyService.getAll(page,limit);
        Long companyNum = companyService.countNum();
        map.put("code",0);
        map.put("msg","查询成功");
        map.put("count",companyNum);
        map.put("data",strategyDTOS);
        return map;
    }

    /**
     * 删除单个
     * @param data
     * @return
     */
    @PostMapping("/company/deleteCompany")
    @ResponseBody
    public Map<String,Object> deleteStrategy(@RequestBody Map<String,String> data){
        Map<String,Object> map = new HashMap<>();
        Integer companyId = Integer.parseInt(data.get("companyId"));
        companyService.deleteCompany(companyId);
        map.put("msg","删除成功");
        return map;
    }

    /**
     * 批量删除
     * @param data
     * @return
     */
    @PostMapping("/company/batchDelCompany")
    @ResponseBody
    public Map<String,Object> batchDelCompany(@RequestBody Map<String,Object> data){
        Map<String, Object>map = new HashMap<String, Object>();
        List<Integer>uidLst = (List<Integer>) data.get("userLists");
        companyService.batchDelCompany(uidLst);
        map.put("msg","删除成功");
        return map;
    }

}
