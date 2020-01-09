package com.yuanzhi.tourism.service;

import com.yuanzhi.tourism.dao.AlbumMapper;
import com.yuanzhi.tourism.dto.AlbumWithViewDTO;
import com.yuanzhi.tourism.entity.Album;
import com.yuanzhi.tourism.entity.AlbumExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: yuanzhi...
 * @Date: created in  2019/11/27 14:45
 */

@Service
public class AlbumService {

    @Autowired
    AlbumMapper albumMapper;


    public void addAlbum(Album album) {
        albumMapper.insertSelective(album);
    }

    public Album selectAlbum(Album album) {
        AlbumExample albumExample = new AlbumExample();
        albumExample.createCriteria().andAlbumtitleEqualTo(album.getAlbumtitle()).andAlbuminfoEqualTo(album.getAlbuminfo())
                .andUseridEqualTo(album.getUserid());
        return albumMapper.selectByExample(albumExample).get(0);
    }

    public Album getOne(Integer albumId) {
        return albumMapper.selectByPrimaryKey(albumId);
    }

    public List<AlbumWithViewDTO> getByViewNum() {
        return albumMapper.getByViewNum();
    }

    public List<AlbumWithViewDTO> getById(Integer albumId) {
        return albumMapper.getByAlbumId(albumId);
    }

    public void incView(Integer albumId) {
        albumMapper.incView(albumId);
    }

    public Long countNum() {
        return albumMapper.countByExample(null);
    }

    public List<AlbumWithViewDTO> getAll(Integer page, Integer limit) {
        return albumMapper.getAll(page,limit);
    }

    public void deleteAlbum(Integer albumId) {
        albumMapper.deleteByPrimaryKey(albumId);
    }

    public void batchDelAlbum(List<Integer> uidLst) {
        for (int i = 0; i < uidLst.size(); i++) {
            albumMapper.deleteByPrimaryKey(uidLst.get(i));
        }
    }

    public List<AlbumWithViewDTO> getAllAlbum() {
        return albumMapper.getAllAlbum();
    }
}
