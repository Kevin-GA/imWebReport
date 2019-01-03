package com.fang.bigdata.metadata.service;

import com.fang.bigdata.metadata.entity.ImCity;

import java.util.List;
import java.util.Map;

/**
 * @project:metadata
 * @author: niujiaxin
 * @create: 2018-12-13-22:23
 */
public interface ImCityService {
    List<ImCity> getCitys();

    List<Map<String,Object>> selectCitys();
}
