package com.yuanzhi.tourism.controller.user;

import com.yuanzhi.tourism.dto.FriendResultDTO;
import com.yuanzhi.tourism.service.FriendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Author: yuanzhi...
 * @Date: created in  2019/10/24 21:40
 */

@Controller
public class FriendController {

    @Autowired
    FriendService friendService;

    @PostMapping("/own/friend")
    @ResponseBody
    public List<FriendResultDTO> getTypeFriend(@RequestParam(value = "uid")Integer uid,
                                               @RequestParam(value = "friendType")Integer friendType){
        friendService.getTypeFriend(uid,friendType);
        return null;
    }

}
