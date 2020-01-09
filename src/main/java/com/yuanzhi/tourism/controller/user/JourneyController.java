package com.yuanzhi.tourism.controller.user;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yuanzhi.tourism.common.CosineSimilarity;
import com.yuanzhi.tourism.dto.CommentDTO;
import com.yuanzhi.tourism.dto.JourneyDTO;
import com.yuanzhi.tourism.dto.RefreshNumDTO;
import com.yuanzhi.tourism.entity.History;
import com.yuanzhi.tourism.entity.Journey;
import com.yuanzhi.tourism.enums.CommentTypeEnum;
import com.yuanzhi.tourism.service.CommentService;
import com.yuanzhi.tourism.service.HistoryService;
import com.yuanzhi.tourism.service.JourneyService;
import com.yuanzhi.tourism.service.UserService;
import com.yuanzhi.tourism.utils.QiniuUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @Author: yuanzhi...
 * @Date: created in  2019/10/16 10:51
 */

@Controller
public class JourneyController {

    @Autowired
    JourneyService journeyService;
    @Autowired
    CommentService commentService;
    @Autowired
    UserService userService;

    /**
     * 游记发表的富文本中的图片上传
     * @param file
     * @return
     */
    @PostMapping(value = "/editImg")
    @ResponseBody
    public Map<String, Object> editImg(MultipartFile file){
        Map<String,Object> map = new HashMap<String,Object>();
        Map<String,Object> map2 = new HashMap<String,Object>();
        try {
            byte[] bytes = file.getBytes();
            String imageName = UUID.randomUUID().toString();
            try {
                String url = QiniuUtil.put64image(bytes, imageName);
                map.put("code", 0);	//0表示上传成功
                map.put("msg","上传成功"); //提示消息
                map2.put("src", url);
                map2.put("title", file.getOriginalFilename());
                map.put("data", map2);
//                System.out.println(file.getOriginalFilename());
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return map;
    }

    /**
     * 用户发表新的游记
     * @param file 游记正图
     * @param uid 用户id
     * @param title 游记标题
     * @param content 游记内容
     * @param daysNum 历时天数
     * @param money 所花金额
     * @param people 人物
     * @param startTime 开始时间
     * @return
     */
    @RequestMapping(value = "/addJourney")
    @ResponseBody
    public Map<String, Object> addJourney(@RequestParam(value="file", required = false) MultipartFile file,
                                          @RequestParam(value = "uid",required = false) Integer uid,
                                          @RequestParam(value = "title",required = false) String title,
                                          @RequestParam(value = "content",required = false) String content,
                                          @RequestParam(value = "daysNum",required = false) String daysNum,
                                          @RequestParam(value = "money",required = false) String money,
                                          @RequestParam(value = "people",required = false) String people,
                                          @RequestParam(value = "startTime",required = false) String startTime){
        Map<String, Object> result = new HashMap<String, Object>();
        System.out.println(file);
        try {
            byte[] bytes = file.getBytes();
            String imageName = UUID.randomUUID().toString();
            //使用base64方式上传到七牛云
            try {
                Date date = new Date();
                SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd HH:mm"); //HH代表24小时制，hh代表12小时制
                String publishTime = dateFormat.format(date);
                Journey journey = new Journey();
                journey.setUserid(uid);
                journey.setPublishtime(publishTime);
                journey.setJourtitle(title.replaceAll("[\ud800\udc00-\udbff\udfff\ud800-\udfff]", ""));
                journey.setJourcontent(content.replaceAll("[\ud800\udc00-\udbff\udfff\ud800-\udfff]", ""));
                journey.setDaysnum(daysNum);
                journey.setMoney(money);
                journey.setPeople(people);
                journey.setStarttime(startTime);
                String url = QiniuUtil.put64image(bytes, imageName);
                journey.setMainimg(url);
                System.out.println(url);
                result.put("imgUrl",url);
                journeyService.addJourney(journey);
                userService.incJourneyCount(uid);
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

    @GetMapping("/")
    public String getAllJourney(@RequestParam(value = "page",defaultValue = "1")int page,
                                @RequestParam(value = "size",defaultValue = "4")int size,
                                Model model){
        PageHelper.startPage(page,size);
        List<Journey>list = journeyService.getAllJourney();
        Map<String,Object>journey = new HashMap<>();
        PageInfo<Journey>pageInfo = new PageInfo<>(list);
        List<Integer>pages = new ArrayList<>();
        journey.put("total_size",pageInfo.getTotal());//总条数
        journey.put("total_page",pageInfo.getPages());//总页数
        journey.put("current_page",page);//当前页
        journey.put("data",pageInfo.getList());//数据
        pages.add(page);
        for (int i = 1; i <= 4; i++) {
            if (page - i > 0) {
                pages.add(0, page - i);
            }

            if (page + i <= pageInfo.getPages()) {
                pages.add(page + i);
            }
        }
        journey.put("pages",pages);//数据
        model.addAttribute("journeyWithUser",journey);
        return "user/index";
    }

    /**
     * 查询游记详情
     * @param tid 游记id
     * @param model
     * @return
     */
    @GetMapping("/journey/{tid}")
    public String getJourney(@PathVariable(name = "tid") Integer tid,Model model){
        Journey journey = journeyService.getJourney(tid);
        List<CommentDTO> comments = commentService.listByTargetId(tid, CommentTypeEnum.JOURNEY);
        model.addAttribute("journey",journey);
        model.addAttribute("comments",comments);
        return "user/journeyDetail";
    }

    /**
     * 查询个人中心页面的我的游记
     * @param uid
     * @return
     */
    @PostMapping("/own/journey")
    @ResponseBody
    public Map<String,Object> getOwnJourney(@RequestParam(required = false,value = "uid")Integer uid,
                                       @RequestParam(value = "page",defaultValue = "1")int page,
                                       @RequestParam(value = "size",defaultValue = "5")int size){
        PageHelper.startPage(page,size);
        List<Journey>journeys = journeyService.getOwnJourney(uid);
        Map<String,Object>journey = new HashMap<>();
        PageInfo<Journey>pageInfo = new PageInfo<>(journeys);
        List<Integer>pages = new ArrayList<>();
        journey.put("total_size",pageInfo.getTotal());//总条数
        journey.put("total_page",pageInfo.getPages());//总页数
        journey.put("current_page",page);//当前页
        journey.put("data",pageInfo.getList());//数据
        pages.add(page);
        for (int i = 1; i <= 3; i++) {
            if (page - i > 0) {
                pages.add(0, page - i);
            }

            if (page + i <= pageInfo.getPages()) {
                pages.add(page + i);
            }
        }
        journey.put("pages",pages);//数据
        return journey;
    }

    /**
     * 根据用户点击的结伴或游记推荐相似的攻略，若不满足攻略相似，则推荐点赞和收藏加起来最多的三个攻略
     * @return
     */
    @PostMapping("/journey/adviceSimilar")
    @ResponseBody
    public Map<String,Object> adviceSimilar(@RequestBody Map<String,String> data){
        return getStringObjectMap(data,0);
    }
    private Map<String, Object> getStringObjectMap(@RequestBody Map<String, String> data, int size) {
        Map<String,Object> map = new HashMap<String, Object>();
        String values = data.get("values");
        List<Journey> journeyList = journeyService.getAllJourney();
        List<Journey> journeyList1 = new ArrayList<Journey>();
        CosineSimilarity cosineSimilarity = new CosineSimilarity();
        for (int i = 0; i < journeyList.size(); i++) {
            if(cosineSimilarity.cos(values, journeyList.get(i).getJourtitle()) > 0.3){
                journeyList1.add(journeyList.get(i));
            }
        }
        if (journeyList1.size() == size){
            List<Journey>strategyList2 = journeyService.selectThreePraiseMost();
            map.put("journeyList",strategyList2);
            return map;
        }
        map.put("journeyList",journeyList1);
        return map;
    }
    @PostMapping("/journey/adviceSimilarSelf")
    @ResponseBody
    public Map<String,Object> adviceSimilarSelf(@RequestBody Map<String,String> data){
        return getStringObjectMap(data,1);
    }

    /**
     * 更新数量
     * @param data
     * @return
     */
    @PostMapping("/journey/refreshNum")
    @ResponseBody
    public Map<String,Object> refreshNum(@RequestBody Map<String,String> data){
        Map<String,Object> map = new HashMap<String, Object>();
        Integer journeyId = Integer.parseInt(data.get("typeId"));
        RefreshNumDTO refreshNumDTO = journeyService.refreshNum(journeyId);
        map.put("refreshNum",refreshNumDTO);
        return map;
    }

    /**
     * 游记总数
     * @return
     */
    @PostMapping("/journey/countNum")
    @ResponseBody
    public Map<String ,Object> countNum(){
        Map<String,Object> map = new HashMap<String,Object>();
        Long journeyNum = journeyService.countNum();
        map.put("journeyNum",journeyNum);
        return map;
    }

    /**
     * 分页查询所有游记
     * @param page
     * @param limit
     * @return
     */
    @GetMapping("/journey/getAll")
    @ResponseBody
    public Map<String,Object> userList(@RequestParam(value="page")Integer page,
                                       @RequestParam(value="limit")Integer limit){
        Map<String,Object> map = new HashMap<>();
        page = (page-1) * limit;
        List<JourneyDTO> journeys = journeyService.getAll(page,limit);
        Long journeyNum = journeyService.countNum();
        map.put("code",0);
        map.put("msg","查询成功");
        map.put("count",journeyNum);
        map.put("data",journeys);
        return map;
    }

    /**
     * 删除游记
     * @param data
     * @return
     */
    @PostMapping("/journey/deleteJour")
    @ResponseBody
    public Map<String,Object> deleteJour(@RequestBody Map<String,String> data){
        Map<String,Object> map = new HashMap<>();
        Integer journeyId = Integer.parseInt(data.get("journeyId"));
        journeyService.deleteJour(journeyId);
        map.put("msg","删除成功");
        return map;
    }

    /**
     * 批量删除
     * @param data
     * @return
     */
    @PostMapping("/journey/batchDelJour")
    @ResponseBody
    public Map<String,Object> batchDelJour(@RequestBody Map<String,Object> data){
        Map<String, Object>map = new HashMap<String, Object>();
        List<Integer>uidLst = (List<Integer>) data.get("userLists");
        journeyService.batchDelJour(uidLst);
        map.put("msg","删除成功");
        return map;
    }

}
