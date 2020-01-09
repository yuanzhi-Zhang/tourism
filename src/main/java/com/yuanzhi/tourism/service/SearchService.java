package com.yuanzhi.tourism.service;

import com.yuanzhi.tourism.dao.SearchMapper;
import com.yuanzhi.tourism.dto.SearchDTO;
import com.yuanzhi.tourism.entity.Search;
import com.yuanzhi.tourism.entity.SearchExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @Author: yuanzhi...
 * @Date: created in  2019/12/9 11:29
 */

@Service
public class SearchService {

    @Autowired
    SearchMapper searchMapper;

    public void addSearch(Search search) {
        Date date1 = new Date();
        SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); //HH代表24小时制，hh代表12小时制
        String time = dateFormat.format(date1);
        search.setSearchTime(time);
        SearchExample searchExample = new SearchExample();
        searchExample.createCriteria().andUserIdEqualTo(search.getUserId())
                .andSearchContentEqualTo(search.getSearchContent());
        List<Search> searchList = searchMapper.selectByExample(searchExample);
        if(searchList.size() == 0){
            searchMapper.insertSelective(search);
        }else {
            searchMapper.incTimes(searchList.get(0).getSearchId());
        }

    }

    public List<SearchDTO> getAll(Integer page, Integer limit) {
        return searchMapper.getAll(page,limit);
    }

    public Long countNum() {
        return searchMapper.countByExample(null);
    }
}
