package com.fang.bigdata.metadata.service;

import com.fang.bigdata.metadata.commons.ImStaticsRetBean;
import com.fang.bigdata.metadata.commons.ImStaticsRetBeanCount;
import com.fang.bigdata.metadata.entity.*;
import com.fang.bigdata.metadata.entity.imstatics.*;

import java.util.List;

public interface ImStaticsService {
    ImStaticsRetBean getCityPercentage1(String actionday, String city);

    ImStaticsRetBean getOneCityPercentage2(String actionday, String city);


    ImStaticsRetBeanCount getCityCount1(String actionday, String city, String business);

    ImStaticsRetBeanCount getOneCityCount2(String actionday, String city);

    ImStaticsRetBeanCount getOneCityDayCount3(String actionday, String city, String business);

    List<PercentRankBaseEntity> getCityPercentageOrder1(String actionday, String city);

    List<PercentRankBaseEntity> getPercentRankByBusiness(String actionday);

    List<PageClickRankEntity> getClickCountRankByBusiness3(String actionday, String platform, String business, Integer limit);

    ImStaticsRetBeanCount getClickPercentRankByBusiness4(String actionday, String platform, String business, Integer limit);

    /**
     * 计算某段时间内各页面uv量求和
     * @param actionday
     * @return
     */
    ImEntity getOneImEntity(String actionday);

    /**
     * 计算某天按uv量排行的楼盘排名 top10
     * @param actionday
     * @return
     */
    ImStaticsRetBean getAPPNewHouseUV(String actionday);

    List<ProjnameImEntity> getTop10UvCountByProjName(String actionday);

    List<ImStaticsPageuvChat> getImStaticsPageuvChatByProducttype(String actionDay, String producttype);

/**
 * 全国楼盘平均聊天数和一线城市楼盘聊天数对比
 */
    ImStaticsRetBeanCount getLoupanAvgUv(String actionday,String city);

    /**
     * 某城市楼盘平均聊天数和楼盘聊天数对比
     */
    ImStaticsRetBeanCount getLoupanAvgUvBycity(String actionday,String city);
}
