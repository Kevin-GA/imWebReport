package com.fang.bigdata.metadata.daoimpala;


import com.fang.bigdata.metadata.entity.imstatics.ImAnalyse;
import com.fang.bigdata.metadata.entity.imstatics.ImAnalyseExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ImAnalyseMapper {
    int insert(ImAnalyse record);

    int insertSelective(ImAnalyse record);

    List<ImAnalyse> selectByExample(ImAnalyseExample example);

    List<ImAnalyse> queryPages(@Param("startTime")String startTime, @Param("endTime") String endTime, @Param("city")String city, @Param("pagetype")String pagetype,@Param("producttype")String producttype, @Param("rows")Integer rows, @Param("pageSize")Integer pageSize);

    Integer queryCount(@Param("startTime")String startTime, @Param("endTime") String endTime, @Param("city")String city,  @Param("pagetype")String pagetype,@Param("producttype")String producttype);
    //ImAnalyse selectOne();

    ImAnalyse selectByMessageidActionday(@Param("messageid")String mid,@Param("actionday")String actionday);
}