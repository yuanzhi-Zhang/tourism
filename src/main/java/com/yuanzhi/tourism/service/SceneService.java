package com.yuanzhi.tourism.service;

import com.yuanzhi.tourism.dao.SceneMapper;
import com.yuanzhi.tourism.entity.Scene;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Author: yuanzhi...
 * @Date: created in  2019/9/28 17:31
 */
public class SceneService {

    @Autowired
    SceneMapper sceneMapper;

    public int addScene(Scene scene){
        return sceneMapper.insert(scene);
    }

}
