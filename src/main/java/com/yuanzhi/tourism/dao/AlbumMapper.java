package com.yuanzhi.tourism.dao;

import com.yuanzhi.tourism.dto.AlbumWithViewDTO;
import com.yuanzhi.tourism.entity.Album;
import com.yuanzhi.tourism.entity.AlbumExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AlbumMapper {
    long countByExample(AlbumExample example);

    int deleteByExample(AlbumExample example);

    int deleteByPrimaryKey(Integer albumid);

    int insert(Album record);

    int insertSelective(Album record);

    List<Album> selectByExample(AlbumExample example);

    Album selectByPrimaryKey(Integer albumid);

    int updateByExampleSelective(@Param("record") Album record, @Param("example") AlbumExample example);

    int updateByExample(@Param("record") Album record, @Param("example") AlbumExample example);

    int updateByPrimaryKeySelective(Album record);

    int updateByPrimaryKey(Album record);

    List<AlbumWithViewDTO> getByViewNum();

    void incView(Integer albumId);

    List<AlbumWithViewDTO> getByAlbumId(Integer albumId);

    List<AlbumWithViewDTO> getAll(@Param("page")Integer page, @Param("limit")Integer limit);

    List<AlbumWithViewDTO> getAllAlbum();
}