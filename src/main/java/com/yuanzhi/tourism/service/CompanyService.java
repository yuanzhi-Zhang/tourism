package com.yuanzhi.tourism.service;

import com.yuanzhi.tourism.dao.CompanyMapper;
import com.yuanzhi.tourism.dto.CompanyDTO;
import com.yuanzhi.tourism.dto.CompanyDTOS;
import com.yuanzhi.tourism.entity.Company;
import com.yuanzhi.tourism.entity.CompanyExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @Author: yuanzhi...
 * @Date: created in  2019/12/5 13:16
 */

@Service
public class CompanyService {

    @Autowired
    CompanyMapper companyMapper;

    public List<Company> getCompany() {
        return companyMapper.selectByExample(null);
    }

    /**
     * 发表结伴
     * @param company
     */
    public void addCompany(Company company) {
        companyMapper.insertSelective(company);
    }

    /**
     * 获取所有的结伴
     * @return
     */
    public List<CompanyDTO> selectWithUser() {
        return companyMapper.selectWithUser();
    }

    /**
     * 获取总数量
     * @return
     */
    public Long countNum() {
        return companyMapper.countByExample(null);
    }

    /**
     * 获取当前时间
     * @return
     * @throws ParseException
     */
    private Date getTime() throws ParseException {
        Date date1 = new Date();
        SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); //HH代表24小时制，hh代表12小时制
        Date time = dateFormat.parse(dateFormat.format(date1));
        return time;
    }

    /**
     * 以当前时间为根据，获取某个时间
     * @param amount
     * @return
     * @throws ParseException
     */
    private Date getTransformTime(Integer amount) throws ParseException {
        Calendar calendar1 = Calendar.getInstance();
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        calendar1.add(Calendar.DATE, amount);
        String three_days_ago = sdf1.format(calendar1.getTime());
        Date date = sdf1.parse(three_days_ago);
        return date;
    }
    /**
     * 获取六十天内将要出发的
     * @return
     * @throws ParseException
     */
    public List<CompanyDTO> selectWithUserNew() throws ParseException {
        Date time = getTime();
        Date date = getTransformTime(60);
        List<CompanyDTO> companyDTOS = companyMapper.selectWithUserNew(time,date);
        return companyDTOS;
    }

    /**
     * 获取一个月内将要出发的
     * @return
     * @throws ParseException
     */
    public List<CompanyDTO> selectWithUserMonth() throws ParseException {
        Date time = getTime();
        Date date = getTransformTime(30);
        List<CompanyDTO> companyDTOS = companyMapper.selectWithUserNew(time,date);
        return companyDTOS;
    }

    /**
     * 获取一到三个月内将要出发的
     * @return
     * @throws ParseException
     */
    public List<CompanyDTO> selectWithUserThreeMonth() throws ParseException {
        Date time = getTransformTime(30);
        Date date = getTransformTime(91);
        List<CompanyDTO> companyDTOS = companyMapper.selectWithUserNew(time,date);
        return companyDTOS;
    }

    /**
     * 获取最近15内发表的
     * @return
     * @throws ParseException
     */
    public List<CompanyDTO> selectWithUserNewUp() throws ParseException {
        Date time = getTime();
        Date date = getTransformTime(-15);
        List<CompanyDTO> companyDTOS = companyMapper.selectWithUserNewUp(date,time);
        return companyDTOS;
    }

    /**
     * 查询今天将要出发的结伴数量
     * @return
     */
    public Long selectWithUserTodayNum() {
        return companyMapper.selectWithUserTodayNum();
    }

    /**
     * 查询今天将要出发的结伴
     * @return
     */
    public List<CompanyDTO> selectWithUserToday() {
        return companyMapper.selectWithUserToday();
    }

    /**
     * 查询三个月以上将要出发的结伴
     * @return
     */
    public List<CompanyDTO> selectWithUserMoreThreeMonth() {
        return companyMapper.selectWithUserMoreThreeMonth();
    }

    /**
     * 查询三个月以上将要出发的结伴数
     * @return
     */
    public Long selectWithUserMoreThreeMonthNum() {
        return companyMapper.selectWithUserMoreThreeMonthNum();
    }

    /**
     * 查询一到三个月内将要出发的结伴数
     * @return
     */
    public Long selectWithUserThreeMonthNum() {
        return companyMapper.selectWithUserThreeMonthNum();
    }

    /**
     * 查询一个月内将要出发的结伴数
     * @return
     */
    public Long selectWithUserMonthNum() {
        return companyMapper.selectWithUserMonthNum();
    }

    /**
     * 根据id查询对应的结伴
     * @param companyId
     * @return
     */
    public CompanyDTO selectWithUserById(Integer companyId) {
        return companyMapper.selectWithUserById(companyId);
    }

    /**
     * 结伴的浏览量加一
     * @param companyId
     */
    public void incView(Integer companyId) {
        companyMapper.incView(companyId);
    }

    /**
     * 结伴的报名数加一
     * @param companyId
     */
    public void incEnterNum(Integer companyId) {
        companyMapper.incEnterNum(companyId);
    }

    /**
     * 结伴的关注数加一
     * @param companyId
     */
    public void incAttendNum(Integer companyId) {
        companyMapper.incAttendNum(companyId);
    }

    /**
     * 浏览数最多的三篇游记
     * @return
     */
    public List<CompanyDTO> selectWithUserThreeNumMost() {
        return companyMapper.selectWithUserThreeNumMost();
    }

    public List<CompanyDTO> getAllOwn(Integer userId) {
        return companyMapper.getAllOwn(userId);
    }

    public List<Company> selectLike(String content) {
        CompanyExample companyExample = new CompanyExample();
        companyExample.createCriteria().andCompanyTitleLike("%" + content + "%");
        return companyMapper.selectByExample(companyExample);
    }

    public List<CompanyDTOS> getAll(Integer page, Integer limit) {
        return companyMapper.getAll(page,limit);
    }

    public void deleteCompany(Integer companyId) {
        companyMapper.deleteByPrimaryKey(companyId);
    }

    public void batchDelCompany(List<Integer> uidLst) {
        for (int i = 0; i < uidLst.size(); i++) {
            companyMapper.deleteByPrimaryKey(uidLst.get(i));
        }
    }

    public List<CompanyDTO> getByDestiny(String destiny) {
        return companyMapper.getByDestiny(destiny);
    }

    /**
     * 获取关注数最多的三个结伴
     * @return
     */
    public List<CompanyDTO> selectWithUserThreeAttendNumMost() {
        return companyMapper.selectWithUserThreeAttendNumMost();
    }
}
