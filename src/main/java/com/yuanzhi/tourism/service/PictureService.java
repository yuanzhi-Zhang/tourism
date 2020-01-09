package com.yuanzhi.tourism.service;

import com.yuanzhi.tourism.dao.PictureMapper;
import com.yuanzhi.tourism.entity.Picture;
import com.yuanzhi.tourism.entity.PictureExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @Author: yuanzhi...
 * @Date: created in  2019/11/27 16:08
 */

@Service
public class PictureService {

    @Autowired
    PictureMapper pictureMapper;

    public void addPicture(List<String> url, Integer albumId, Date publishTime) {
        Picture picture = new Picture();
        picture.setAlbumId(albumId);
        picture.setUploadTime(publishTime);
        for (int i = 0; i < url.size(); i++) {
            picture.setPictureUrl(url.get(i));
            pictureMapper.insertSelective(picture);
        }
    }

    public List<Picture> getByAlbumId(Integer albumId) {
        /*PictureExample pictureExample = new PictureExample();
        pictureExample.createCriteria().andAlbumIdEqualTo(albumId);*/
        return pictureMapper.getByAlbumId(albumId);
    }
}
