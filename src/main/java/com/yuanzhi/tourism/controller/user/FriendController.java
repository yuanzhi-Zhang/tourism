package com.yuanzhi.tourism.controller.user;

import com.yuanzhi.tourism.dto.FriendResultDTO;
import com.yuanzhi.tourism.entity.Friend;
import com.yuanzhi.tourism.service.FriendService;
import com.yuanzhi.tourism.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: yuanzhi...
 * @Date: created in  2019/10/24 21:40
 */

@Controller
public class FriendController {

    @Autowired
    FriendService friendService;
    @Autowired
    UserService userService;

    /**
     * 查询用户的关注和粉丝
     * @param uid
     * @param friendType
     * @return
     */
    @PostMapping("/own/friend")
    @ResponseBody
    public List<FriendResultDTO> getTypeFriend(@RequestParam(value = "uid")Integer uid,
                                               @RequestParam(value = "friendType")Integer friendType){
        List<FriendResultDTO> friendResultDTOS = friendService.getTypeFriend(uid,friendType);
        return friendResultDTOS;
    }

    @PostMapping("/own/isAttended")
    @ResponseBody
    public Map<String,Object> isAttended(@RequestBody Map<String,String> data){
        Map<String,Object> map = new HashMap<String, Object>();
        Integer uid = Integer.parseInt(data.get("uid"));
        Integer friendType = Integer.parseInt(data.get("friendType"));
        Integer friendId = Integer.parseInt(data.get("friendId"));
        boolean isAttended = friendService.isAttended(uid,friendType,friendId);
        map.put("isAttended",isAttended);
        return map;
    }

    /**
     * 添加关注
     * @param uid 用户id
     * @param friendId 用户要关注的人id
     * @param friendType 类型（关注，粉丝等）
     * @return
     */
    @RequestMapping(value = "/own/friend/attend")
    @ResponseBody
    public Map<String,Object> attendFriend(@RequestParam(value = "uid")Integer uid,
                                              @RequestParam(value = "friendId")Integer friendId,
                                              @RequestParam(value = "friendType")Integer friendType){
        Friend friend = new Friend();
        friend.setFriendId(friendId);
        friend.setUserId(uid);
        friend.setFriendType(friendType);
        Date date = new Date();
        SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); //HH代表24小时制，hh代表12小时制
        String publishTime = dateFormat.format(date);
        friend.setJoinTime(publishTime);
        Friend fans = new Friend();
        fans.setJoinTime(publishTime);
        fans.setUserId(friendId);
        fans.setFriendType(2);
        fans.setFriendId(uid);
        Map<String,Object> result = friendService.addAttention(friend,fans);
        if (result.get("code").equals(2000)){
            userService.incFans(friendId);
            List<FriendResultDTO>friendResultDTOS = friendService.getTypeFriend(uid,2);
            result.put("friendResultDTOS",friendResultDTOS);
        }
        return result;
    }

    /**
     * 取消关注
     * @param fid
     * @param uid
     * @param friendType
     * @param friendId
     * @return
     */
    @RequestMapping(value = "/own/friend/cancel")
    @ResponseBody
    public List<FriendResultDTO> cancelFriend(@RequestParam(required = false,value = "fid")Integer fid,
                                              @RequestParam(value = "uid")Integer uid,
                                              @RequestParam(value = "friendType")Integer friendType,
                                              @RequestParam(value = "friendId")Integer friendId){
        Friend friend = new Friend();
        friend.setFriendId(uid);
        friend.setFriendType(2);
        friend.setUserId(friendId);
        friendService.cancelAttention(fid,friend);
        userService.downFansCount(friendId);
        List<FriendResultDTO>friendResultDTOS = getTypeFriend(uid,friendType);
        return friendResultDTOS;
    }

}
