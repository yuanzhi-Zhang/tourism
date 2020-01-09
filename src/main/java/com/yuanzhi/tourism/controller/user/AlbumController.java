package com.yuanzhi.tourism.controller.user;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yuanzhi.tourism.dto.AlbumWithViewDTO;
import com.yuanzhi.tourism.entity.Album;
import com.yuanzhi.tourism.entity.Picture;
import com.yuanzhi.tourism.service.AlbumService;
import com.yuanzhi.tourism.service.PictureService;
import com.yuanzhi.tourism.utils.QiniuUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @Author: yuanzhi...
 * @Date: created in  2019/11/27 14:45
 */

@Controller
public class AlbumController {

    @Autowired
    AlbumService albumService;
    @Autowired
    PictureService pictureService;

    /**
     * 相册的图片上传（多图）
     * @param file
     * @return
     */
    @PostMapping("/album/upload")
    @ResponseBody
    public Map<String,Object> albumUpload(@RequestParam(value="file", required = false) MultipartFile file){
        Map<String,Object>map = new HashMap<>();
        Map<String,Object>mapDTO = new HashMap<>();
        System.out.println(file.getOriginalFilename());
        try {
            byte[] bytes = file.getBytes();
            String imageName = UUID.randomUUID().toString();
            try {
                String url = QiniuUtil.put64image(bytes, imageName);
                map.put("code", 0);
                map.put("msg","上传成功");
                mapDTO.put("imgUrl", url);
                mapDTO.put("title", file.getOriginalFilename());
                map.put("data", mapDTO);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return map;
    }

    /**
     * 发布新相册
     * @param data
     * @return
     * @throws ParseException
     */
    @PostMapping("/album/upAlbum")
    @ResponseBody
    public Map<String,Object> upAlbum(@RequestBody Map<String,Object> data) throws ParseException {
        Map<String,Object> map = new HashMap<>();
        Integer userId = Integer.parseInt(data.get("userId").toString());
        List<String> url = (List<String>) data.get("imgUrl");
        String albumInfo = data.get("albumInfo").toString();
        String albumTitle = data.get("albumTitle").toString();
        Album album = new Album();
        Date date = new Date();
        SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd HH:mm"); //HH代表24小时制，hh代表12小时制
        Date publishTime = dateFormat.parse(dateFormat.format(date));
        album.setPublishtime(publishTime);
        album.setUserid(userId);
        album.setAlbuminfo(albumInfo);
        album.setAlbumtitle(albumTitle);
        album.setViewtimes(0);
        albumService.addAlbum(album);
        Album album1 = albumService.selectAlbum(album);
        Integer albumId = album1.getAlbumid();
        pictureService.addPicture(url,albumId,publishTime);
        map.put("msg","发表成功");
        map.put("code",200);
        return map;
    }

    /**
     * 查询四个浏览次数最多的相册
     * @return
     * @throws ParseException
     */
    @PostMapping("/album/getWithView")
    @ResponseBody
    public Map<String,Object> getOne(){
        Map<String,Object> map = new HashMap<>();
        List<AlbumWithViewDTO>albumWithViewDTOList = albumService.getByViewNum();
        map.put("albumList",albumWithViewDTOList);
        map.put("msg","查询成功");
        map.put("code",200);
        return map;
    }

    @PostMapping("/album/getAll")
    @ResponseBody
    public Map<String,Object> getAll(@RequestParam(value = "page",defaultValue = "1")int page,
                                     @RequestParam(value = "size",defaultValue = "12")int size){
        Map<String,Object> map = new HashMap<>();
        PageHelper.startPage(page,size);
        List<AlbumWithViewDTO>albumList = albumService.getAllAlbum();
        List<Integer> pages = getIntegers(page, map, albumList);
        map.put("msg","查询成功");
        map.put("pages",pages);
        return map;
    }
    private List<Integer> getIntegers(@RequestParam(value = "page", defaultValue = "1") int page, Map<String, Object> map, List<AlbumWithViewDTO> companyList) {
        PageInfo<AlbumWithViewDTO> pageInfo = new PageInfo<>(companyList);
        List<Integer>pages = new ArrayList<>();
        map.put("total_size",pageInfo.getTotal());//总条数
        map.put("total_page",pageInfo.getPages());//总页数
        map.put("current_page",page);//当前页
        map.put("albumList",pageInfo.getList());//数据
        pages.add(page);
        for (int i = 1; i <= 5; i++) {
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
     * 获取对应相册所有图片
     * @param data
     * @return
     */
    @PostMapping("/album/getById")
    @ResponseBody
    public Map<String,Object> getById(@RequestBody Map<String,Object> data){
        Map<String,Object> map = new HashMap<>();
        Integer albumId = Integer.parseInt(data.get("albumId").toString());
        List<AlbumWithViewDTO> album = albumService.getById(albumId);
//        List<Picture>pictureList = pictureService.getByAlbumId(albumId);
        map.put("album",album);
//        map.put("pictureList",pictureList);
        map.put("msg","查询成功");
        map.put("code",200);
        return map;
    }

    /**
     * 浏览次数加一
     * @param data
     * @return
     */
    @PostMapping("/album/incView")
    @ResponseBody
    public Map<String,Object> incView(@RequestBody Map<String,String> data){
        Map<String,Object> map = new HashMap<>();
        Integer albumId = Integer.parseInt(data.get("albumId"));
        albumService.incView(albumId);
        map.put("msg","查询成功");
        map.put("code",200);
        return map;
    }

    @GetMapping("/album/{albumId}.html")
    public String toAlbum(){
        return "user/album";
    }

    //后台请求

    /**
     * 分页获取所有
     * @param page
     * @param limit
     * @return
     */
    @GetMapping("/album/getAll")
    @ResponseBody
    public Map<String,Object> getAll(@RequestParam(value="page")Integer page,
                                       @RequestParam(value="limit")Integer limit){
        Map<String,Object> map = new HashMap<>();
        page = (page-1) * limit;
        List<AlbumWithViewDTO> strategyDTOS = albumService.getAll(page,limit);
        Long companyNum = albumService.countNum();
        map.put("code",0);
        map.put("msg","查询成功");
        map.put("count",companyNum);
        map.put("data",strategyDTOS);
        return map;
    }

    /**
     * 删除单个
     * @param data
     * @return
     */
    @PostMapping("/album/deleteAlbum")
    @ResponseBody
    public Map<String,Object> deleteAlbum(@RequestBody Map<String,String> data){
        Map<String,Object> map = new HashMap<>();
        Integer albumId = Integer.parseInt(data.get("albumId"));
        albumService.deleteAlbum(albumId);
        map.put("msg","删除成功");
        return map;
    }

    /**
     * 批量删除
     * @param data
     * @return
     */
    @PostMapping("/album/batchDelAlbum")
    @ResponseBody
    public Map<String,Object> batchDelAlbum(@RequestBody Map<String,Object> data){
        Map<String, Object>map = new HashMap<String, Object>();
        List<Integer>uidLst = (List<Integer>) data.get("userLists");
        albumService.batchDelAlbum(uidLst);
        map.put("msg","删除成功");
        return map;
    }

}
