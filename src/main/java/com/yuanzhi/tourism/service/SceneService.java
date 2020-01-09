package com.yuanzhi.tourism.service;

import com.yuanzhi.tourism.dao.SceneMapper;
import com.yuanzhi.tourism.entity.Scene;
import com.yuanzhi.tourism.entity.SceneExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: yuanzhi...
 * @Date: created in  2019/9/28 17:31
 */

@Service
public class SceneService {

    @Autowired
    SceneMapper sceneMapper;

    public void addScene(Scene scene){
        sceneMapper.insertSelective(scene);
    }

    public List<Scene> getScene() {
        SceneExample sceneExample = new SceneExample();
        sceneExample.createCriteria().andSceneNameEqualTo("青羊宫");
        return sceneMapper.selectByExample(sceneExample);
    }

    public Scene getById(Integer sid) {
        return sceneMapper.selectByPrimaryKey(sid);
    }

    public List<Scene> getAll() {
        return sceneMapper.selectByExample(null);
    }

    public Scene selectById(Integer sceneId) {
        return sceneMapper.selectByPrimaryKey(sceneId);
    }

    public List<Scene> getAllScene(Integer page, Integer limit) {
        return sceneMapper.getAll(page,limit);
    }

    public Long countNum() {
        return sceneMapper.countByExample(null);
    }
}
