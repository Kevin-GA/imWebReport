package com.fang.bigdata.metadata.daoimpala;

import com.fang.bigdata.metadata.entity.imstatics.ImShopUv;
import com.fang.bigdata.metadata.entity.imstatics.ProjnameImEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ImStaticsProjnameMapper {

    /**
     * 计算某段时间uv量楼盘排行 top10
     * @return
     */
    List<ProjnameImEntity> getTop10UvCountByProjName(@Param("startDay") String startDay, @Param("endDay") String endDay);

    /**
     * 计算全国平均聊天量
     */
    Double getAvgShopidUv(@Param("startDay") String startDay, @Param("endDay") String endDay);

    /**
     * 计算城市聊天量
     */
    List<ImShopUv> getAvgShopidUvByCity(@Param("startDay") String startDay, @Param("endDay") String endDay,@Param("citys")List<String> citys);

    /**
     * 某城市所有楼盘平均聊天量
     * @param startDay
     * @param endDay
     * @param city
     * @return
     */
    Double getAvgLoupanUv(@Param("startDay") String startDay, @Param("endDay") String endDay,@Param("city")String city);

    /**
     * 计算该城市楼盘聊天量
     */
    List<ImShopUv> getAvgLoupanUvByCity (@Param("startDay") String startDay, @Param("endDay") String endDay,@Param("city")String city);
}
