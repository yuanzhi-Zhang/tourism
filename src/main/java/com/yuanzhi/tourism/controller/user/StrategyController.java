package com.yuanzhi.tourism.controller.user;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yuanzhi.tourism.common.CosineSimilarity;
import com.yuanzhi.tourism.common.SimilarCompute;
import com.yuanzhi.tourism.dto.RefreshNumDTO;
import com.yuanzhi.tourism.dto.StrategyDTO;
import com.yuanzhi.tourism.entity.Strategy;
import com.yuanzhi.tourism.entity.User;
import com.yuanzhi.tourism.service.StrategyService;
import com.yuanzhi.tourism.service.UserService;
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
 * @Date: created in  2019/12/3 10:52
 */

@Controller
public class StrategyController {

    @Autowired
    StrategyService strategyService;
    @Autowired
    UserService userService;

    /**
     * 分页查询攻略
     * @param page
     * @param size
     * @return
     */
    @PostMapping("/strategy/getPage")
    @ResponseBody
    public Map<String,Object> getStrategyPage(@RequestParam(value = "page",defaultValue = "1")int page,
                                              @RequestParam(value = "size",defaultValue = "7")int size){
        Map<String,Object> map = new HashMap<String,Object>();
        PageHelper.startPage(page,size);
        List<Strategy>strategyList = strategyService.getStrategy();
        List<Integer> pages = getPage(page, map, strategyList);
        map.put("pages",pages);
        return map;
    }

    /**
     * 获取个人发布表过的攻略
     * @param page
     * @param size
     * @param uid
     * @return
     */
    @PostMapping("/strategyOwn/getPage")
    @ResponseBody
    public Map<String,Object> getStrategyOwn(@RequestParam(value = "page",defaultValue = "1")int page,
                                              @RequestParam(value = "size",defaultValue = "7")int size,
                                             @RequestParam(value = "uid",defaultValue = "7")int uid){
        Map<String,Object> map = new HashMap<String,Object>();
        PageHelper.startPage(page,size);
        List<Strategy>strategyList = strategyService.getStrategyOwn(uid);
        List<Integer> pages = getPage(page, map, strategyList);
        map.put("pages",pages);
        return map;
    }

    /**
     * 获取城市名的攻略
     * @param page
     * @param size
     * @param title
     * @return
     */
    @PostMapping("/strategy/getStrategyLike")
    @ResponseBody
    public Map<String,Object> getStrategyLike(@RequestParam(value = "page",defaultValue = "1")int page,
                                              @RequestParam(value = "size",defaultValue = "7")int size,
                                             @RequestParam(value = "title")String title){
        Map<String,Object> map = new HashMap<String,Object>();
        PageHelper.startPage(page,size);
        List<Strategy>strategyList = strategyService.getStrategyLike(title);
        List<Integer> pages = getPage(page, map, strategyList);
        map.put("pages",pages);
        return map;
    }

    /**
     * 分页的公共方法
     * @param page
     * @param map
     * @param strategyList
     * @return
     */
    private List<Integer> getPage(@RequestParam(value = "page", defaultValue = "1") int page, Map<String, Object> map, List<Strategy> strategyList) {
        PageInfo<Strategy> pageInfo = new PageInfo<>(strategyList);
        List<Integer> pages = new ArrayList<>();
        map.put("total_size",pageInfo.getTotal());//总条数
        map.put("total_page",pageInfo.getPages());//总页数
        map.put("current_page",page);//当前页
        map.put("strategyList",pageInfo.getList());//数据
        pages.add(page);
        for (int i = 1; i <= 3; i++) {
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
     * 用户发表新的攻略
     * @param file1
     * @param file2
     * @param file3
     * @param uid
     * @param title
     * @param content
     * @param strategy_info
     * @return
     */
    @PostMapping("/strategy/add")
    @ResponseBody
    public Map<String ,Object> addStrategy(@RequestParam(value="file1", required = false) MultipartFile file1,
                                           @RequestParam(value="file2", required = false) MultipartFile file2,
                                           @RequestParam(value="file3", required = false) MultipartFile file3,
                                           @RequestParam(value = "uid",required = false) Integer uid,
                                           @RequestParam(value = "title",required = false) String title,
                                           @RequestParam(value = "content",required = false) String content,
                                           @RequestParam(value = "strategy_info",required = false) String strategy_info){
        Map<String,Object> map = new HashMap<String,Object>();
        try {
            byte[] bytes1 = file1.getBytes();
            byte[] bytes2 = file2.getBytes();
            byte[] bytes3 = file3.getBytes();
            String imageName1 = UUID.randomUUID().toString();
            String imageName2 = UUID.randomUUID().toString();
            String imageName3 = UUID.randomUUID().toString();
            try {
                Date date = new Date();
                SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); //HH代表24小时制，hh代表12小时制
                Date publishTime = dateFormat.parse(dateFormat.format(date));
                Strategy strategy = new Strategy();
                strategy.setUserId(uid);
                strategy.setStrategyTitle(title.replaceAll("[\ud800\udc00-\udbff\udfff\ud800-\udfff]", ""));
                strategy.setStrategyContent(content.replaceAll("[\ud800\udc00-\udbff\udfff\ud800-\udfff]", ""));
                strategy.setPublishTime(publishTime);
                strategy.setStrategyIntro(strategy_info);
                String url1 = QiniuUtil.put64image(bytes1, imageName1);
                String url2 = QiniuUtil.put64image(bytes2, imageName2);
                String url3 = QiniuUtil.put64image(bytes3, imageName3);
                strategy.setFirstImg(url1);
                strategy.setSecondImg(url2);
                strategy.setThirdImg(url3);
                System.out.println(url1);
                System.out.println(url2);
                System.out.println(url3);
                map.put("imgUrl1",url1);
                map.put("imgUrl2",url2);
                map.put("imgUrl3",url3);
                strategyService.addStrategy(strategy);
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
     * 跳转到攻略页面
     * @param strategyId
     * @return
     */
    @GetMapping("/strategy/{strategyId}.html")
    public String toDetail(@PathVariable(name = "strategyId")String strategyId){
        return "user/strategyDetail";
    }

    /**
     * 获取具体攻略详情
     * @param strategyId
     * @return
     */
    @PostMapping("/strategy/getDetail")
    @ResponseBody
    public Map<String,Object> getDetail(@RequestParam(value = "strategyId")Integer strategyId){
        Map<String,Object> map = new HashMap<String, Object>();
        Strategy strategy = strategyService.getDetail(strategyId);
        User user = userService.selectUserByPrimary(strategy.getUserId());
        map.put("strategy",strategy);
        map.put("user",user);
        return map;
    }

    /**
     * 阅读数加一
     * @param data
     * @return
     */
    @PostMapping("/strategy/incView")
    @ResponseBody
    public Map<String,Object> incView(@RequestBody Map<String,String> data){
        Map<String,Object> map = new HashMap<String, Object>();
        Integer strategyId = Integer.parseInt(data.get("strategyId"));
        strategyService.incView(strategyId);
        map.put("code",200);
        return map;
    }

    /**
     * 点赞数加一
     * @param data
     * @return
     */
    @PostMapping("/strategy/incPraise")
    @ResponseBody
    public Map<String,Object> incPraise(@RequestBody Map<String,String> data){
        Map<String,Object> map = new HashMap<String, Object>();
        Integer strategyId = Integer.parseInt(data.get("strategyId"));
        strategyService.incPraise(strategyId);
        map.put("code",200);
        return map;
    }

    /**
     * 收藏数加一
     * @param data
     * @return
     */
    @PostMapping("/strategy/incCollect")
    @ResponseBody
    public Map<String,Object> incCollect(@RequestBody Map<String,String> data){
        Map<String,Object> map = new HashMap<String, Object>();
        Integer strategyId = Integer.parseInt(data.get("strategyId"));
        strategyService.incCollect(strategyId);
        map.put("code",200);
        return map;
    }

    /**
     * 评论数加一
     * @param data
     * @return
     */
    @PostMapping("/strategy/incComment")
    @ResponseBody
    public Map<String,Object> incComment(@RequestBody Map<String,String> data){
        Map<String,Object> map = new HashMap<String, Object>();
        Integer strategyId = Integer.parseInt(data.get("strategyId"));
        strategyService.incComment(strategyId);
        map.put("code",200);
        return map;
    }

    /**
     * 更新数量
     * @param data
     * @return
     */
    @PostMapping("/strategy/refreshNum")
    @ResponseBody
    public Map<String,Object> refreshNum(@RequestBody Map<String,String> data){
        Map<String,Object> map = new HashMap<String, Object>();
        Integer strategyId = Integer.parseInt(data.get("typeId"));
        RefreshNumDTO refreshNumDTO = strategyService.refreshNum(strategyId);
        map.put("refreshNum",refreshNumDTO);
        return map;
    }

    /**
     * 根据用户点击的结伴或游记推荐相似的攻略，若不满足攻略相似，则推荐点赞和收藏加起来最多的三个攻略
     * @return
     */
    @PostMapping("/strategy/adviceSimilar")
    @ResponseBody
    public Map<String,Object> adviceSimilar(@RequestBody Map<String,String> data){
        Map<String,Object> map = new HashMap<String, Object>();
        String values = data.get("values");
        List<Strategy> strategyList = strategyService.getStrategy();
        List<Strategy> strategyList1 = new ArrayList<Strategy>();
        CosineSimilarity cosineSimilarity = new CosineSimilarity();
        for (int i = 0; i < strategyList.size(); i++) {
            if(cosineSimilarity.cos(values, strategyList.get(i).getStrategyTitle()) > 0.3){
                strategyList1.add(strategyList.get(i));
            }
        }
        if (strategyList1.size() == 0){
            List<Strategy>strategyList2 = strategyService.selectThreePraiseMost();
            map.put("strategyList",strategyList2);
            return map;
        }
        map.put("strategyList",strategyList1);
        return map;
    }

    /**
     * 查询点赞次数和收藏次数加起来最多的三个攻略
     * @return
     */
    @PostMapping("/strategy/selectThreeMost")
    @ResponseBody
    public Map<String,Object> selectWithUserThreeNumMost(){
        Map<String,Object> map = new HashMap<String, Object>();
        List<Strategy> strategyList = strategyService.selectThreePraiseMost();
        map.put("strategyList",strategyList);
        return map;
    }

    /**
     * 获取总数
     * @return
     */
    @PostMapping("/strategy/countNum")
    @ResponseBody
    public Map<String ,Object> countNum(){
        Map<String,Object> map = new HashMap<String,Object>();
        Long strategyNum = strategyService.countNum();
        map.put("strategyNum",strategyNum);
        return map;
    }

    /**
     * 分页获取所有攻略
     * @param page
     * @param limit
     * @return
     */
    @GetMapping("/strategy/getAll")
    @ResponseBody
    public Map<String,Object> userList(@RequestParam(value="page")Integer page,
                                       @RequestParam(value="limit")Integer limit){
        Map<String,Object> map = new HashMap<>();
        page = (page-1) * limit;
        List<StrategyDTO> strategyDTOS = strategyService.getAll(page,limit);
        Long strategyNum = strategyService.countNum();
        map.put("code",0);
        map.put("msg","查询成功");
        map.put("count",strategyNum);
        map.put("data",strategyDTOS);
        return map;
    }

    /**
     * 删除单个
     * @param data
     * @return
     */
    @PostMapping("/strategy/deleteStrategy")
    @ResponseBody
    public Map<String,Object> deleteStrategy(@RequestBody Map<String,String> data){
        Map<String,Object> map = new HashMap<>();
        Integer strategyId = Integer.parseInt(data.get("strategyId"));
        strategyService.deleteStrategy(strategyId);
        map.put("msg","删除成功");
        return map;
    }

    /**
     * 批量删除
     * @param data
     * @return
     */
    @PostMapping("/strategy/batchDelStrategy")
    @ResponseBody
    public Map<String,Object> batchDelJour(@RequestBody Map<String,Object> data){
        Map<String, Object>map = new HashMap<String, Object>();
        List<Integer>uidLst = (List<Integer>) data.get("userLists");
        strategyService.batchDelStrategy(uidLst);
        map.put("msg","删除成功");
        return map;
    }

}
