package com.fang.bigdata.metadata.service;

import com.fang.bigdata.metadata.entity.imstatics.ImAnalyse;

import java.util.List;

/**
 * @project:metadata
 * @author: niujiaxin
 * @create: 2019-01-02-14:13
 */
public interface ImAnalyseService {
    List<ImAnalyse> queryPages(String startTime, String endTime, String city, String pagetype, String producttype,Integer pageNum, Integer pageSize);

    Integer queryCount(String startTime, String endTime, String city, String pagetype, String producttype);

    ImAnalyse selectByMessageidActionday(String mid,String actionday);
}
