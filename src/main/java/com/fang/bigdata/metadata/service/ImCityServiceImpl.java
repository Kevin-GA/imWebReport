package com.fang.bigdata.metadata.service;

import com.fang.bigdata.metadata.dao.ImCityMapper;
import com.fang.bigdata.metadata.entity.ImCity;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.lang.reflect.Array;
import java.util.*;

/**
 * @project:metadata
 * @packname:com.fang.bigdata.metadata.service
 * @name: ImCityServiceImpl
 * @describe:
 * @author: niujiaxin
 * @create: 2018-12-13-22:24
 */
@Service("ImCityService")
public class ImCityServiceImpl implements ImCityService{
    @Resource
    private ImCityMapper imCityMapper;

    @Override
    public List<ImCity> getCitys() {
        return imCityMapper.queryAllCitys();
    }

    @Override
    public List<Map<String,Object>> selectCitys() {
        List<ImCity> imCities = imCityMapper.queryAllCitys();
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        for (ImCity tmp: imCities)
        {
            Map<String, Object> citysMap = new HashMap<>();
            citysMap.put(tmp.getName(),tmp.getName());
            list.add(citysMap);
        }
        return list;
    }
}
