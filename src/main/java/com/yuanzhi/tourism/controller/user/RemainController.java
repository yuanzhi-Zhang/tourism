package com.yuanzhi.tourism.controller.user;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yuanzhi.tourism.dto.RemainCreateDTO;
import com.yuanzhi.tourism.dto.RemainResultDTO;
import com.yuanzhi.tourism.entity.Remain;
import com.yuanzhi.tourism.service.RemainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @Author: yuanzhi...
 * @Date: created in  2019/10/24 10:50
 */

@Controller
public class RemainController {

    @Autowired
    RemainService remainService;

    /**
     * 查询用户的留言信息
     * @param uid 用户id
     * @return
     */
    @PostMapping("/own/remain")
    @ResponseBody
    public Map<String,Object> getAllRemain(@RequestParam(value = "uid")Integer uid,
                                              @RequestParam(value = "page",defaultValue = "1")int page,
                                              @RequestParam(value = "size",defaultValue = "5")int size){
        PageHelper.startPage(page,size);
        List<RemainResultDTO>remains = remainService.getAllRemain(uid);
        Map<String, Object> remain = getPage(page, size, remains);
        return remain;
    }
    private Map<String, Object> getPage(int page, int size, List<RemainResultDTO> remains) {
        PageHelper.startPage(page,size);
        Map<String,Object> remain = new HashMap<>();
        PageInfo<RemainResultDTO> pageInfo = new PageInfo<>(remains);
        List<Integer>pages = new ArrayList<>();
        remain.put("total_size",pageInfo.getTotal());//总条数
        remain.put("total_page",pageInfo.getPages());//总页数
        remain.put("current_page",page);//当前页
        remain.put("data",pageInfo.getList());//数据
        pages.add(page);
        for (int i = 1; i < 4; i++) {
            if (page - i > 0) {
                pages.add(0, page - i);
            }

            if (page + i <= pageInfo.getPages()) {
                pages.add(page + i);
            }
        }
        remain.put("pages",pages);//数据
        return remain;
    }

    /**
     * 用户添加留言
     * @param remainCreateDTO
     * @param request
     * @param response
     * @param page
     * @param size
     * @return
     * @throws UnsupportedEncodingException
     */
    @PostMapping("/addRemain")
    @ResponseBody
    public Map<String,Object> addRemain(@RequestBody RemainCreateDTO remainCreateDTO,
                                        HttpServletRequest request, HttpServletResponse response,
                                        @RequestParam(value = "page",defaultValue = "1")int page,
                                        @RequestParam(value = "size",defaultValue = "5")int size) throws UnsupportedEncodingException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("application/json;charset=utf-8");
        PageHelper.startPage(page,size);
        Remain remain = new Remain();
        Date date = new Date();
        SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); //HH代表24小时制，hh代表12小时制
        remain.setRemainTime(dateFormat.format(date));
        remain.setRemainSenderId(remainCreateDTO.getRemainSenderId());
        remain.setRemainContent(remainCreateDTO.getRemainContent());
        remain.setRemainReceiverId(remainCreateDTO.getRemainReceiverId());
        remainService.addRemain(remain);
        List<RemainResultDTO>remains = remainService.getAllRemain(remainCreateDTO.getRemainReceiverId());
        Map<String, Object> remain1 = getPage(page, size, remains);
        return remain1;
    }

    /**
     * 删除留言
     * @param remainId
     * @param page
     * @param size
     * @param uid
     * @return
     */
    @RequestMapping("/deleteRemain")
    @ResponseBody
    public Map<String,Object> deleteRemain(@RequestParam(value = "remainId") Integer remainId,
                                           @RequestParam(value = "page",defaultValue = "1")int page,
                                           @RequestParam(value = "size",defaultValue = "5")int size,
                                              @RequestParam(value = "uid") Integer uid){
        PageHelper.startPage(page,size);
        remainService.deleteRemain(remainId);
        List<RemainResultDTO>remains = remainService.getAllRemain(uid);
        Map<String, Object> remain = getPage(page, size, remains);
        return remain;
    }

    /**
     * 留言总数
     * @return
     */
    @PostMapping("/remain/remainNum")
    @ResponseBody
    public Map<String,Object> noteNum(){
        Map<String,Object> map = new HashMap<>();
        Long num = remainService.remainNum();
        map.put("remainNum",num);
        return map;
    }

    /**
     * 分页获取所有
     * @param page
     * @param limit
     * @return
     */
    @GetMapping("/remain/getAll")
    @ResponseBody
    public Map<String,Object> userList(@RequestParam(value="page")Integer page,
                                       @RequestParam(value="limit")Integer limit){
        Map<String,Object> map = new HashMap<>();
        page = (page-1) * limit;
        List<Remain> strategyDTOS = remainService.getAll(page,limit);
        Long num = remainService.remainNum();
        map.put("code",0);
        map.put("msg","查询成功");
        map.put("count",num);
        map.put("data",strategyDTOS);
        return map;
    }

    /**
     * 删除单个
     * @param data
     * @return
     */
    @PostMapping("/remain/deleteRemain")
    @ResponseBody
    public Map<String,Object> deleteRemain(@RequestBody Map<String,String> data){
        Map<String,Object> map = new HashMap<>();
        Integer companyId = Integer.parseInt(data.get("companyId"));
        remainService.deleteRemain(companyId);
        map.put("msg","删除成功");
        return map;
    }

    /**
     * 批量删除
     * @param data
     * @return
     */
    @PostMapping("/remain/batchDelRemain")
    @ResponseBody
    public Map<String,Object> batchDelRemain(@RequestBody Map<String,Object> data){
        Map<String, Object>map = new HashMap<String, Object>();
        List<Integer>uidLst = (List<Integer>) data.get("userLists");
        remainService.batchDelRemain(uidLst);
        map.put("msg","删除成功");
        return map;
    }

}
