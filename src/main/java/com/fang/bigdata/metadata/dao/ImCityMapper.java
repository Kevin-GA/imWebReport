package com.fang.bigdata.metadata.dao;

import com.fang.bigdata.metadata.entity.ImCity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
public interface ImCityMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ImCity record);

    int insertSelective(ImCity record);

    ImCity selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ImCity record);

    int updateByPrimaryKey(ImCity record);

    List<ImCity> queryAllCitys();
}