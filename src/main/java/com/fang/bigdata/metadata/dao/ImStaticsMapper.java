package com.fang.bigdata.metadata.dao;

import com.fang.bigdata.metadata.entity.*;

import com.fang.bigdata.metadata.entity.imstatics.ImEntity;
import com.fang.bigdata.metadata.entity.imstatics.ImStaticsPageuvChat;
import org.apache.ibatis.annotations.Param;

import java.util.List;
public interface ImStaticsMapper {
    /**
     * 计算所选城市的uv转化率以及会话转化率
     *
     * @return java.util.List<com.fang.bigdata.metadata.entity.CityPercentageEntity>
     * @author linan
     * @Param [startDay, endDay, citys]
     * @date 2018/12/15 18:35
     */

    List<CityPercentageEntity> getCityPercentage1(@Param("startDay") String startDay, @Param("endDay") String endDay, @Param("citys") List<String> citys);

    /**
     * 计算某一城市的各个业务线的转化率
     *
     * @return java.util.List<com.fang.bigdata.metadata.entity.BusinessPercentageEntity>
     * @author linan
     * @Param [startDay, endDay, city]
     * @date 2018/12/15 22:45
     */
    List<BusinessPercentageEntity> getCityPercentage2(@Param("startDay") String startDay, @Param("endDay") String endDay, @Param("city") String city);

    /**
     * 已城市为维度，计算全部业务或者某一业务的首页uv、列表uv、详情页uv、IM聊天人数、会话数、有反馈会话数、无反馈会话数
     *
     * @return java.util.List<com.fang.bigdata.metadata.entity.CityImEntity>
     * @author linan
     * @Param [startDay, endDay, citys]
     * @date 2018/12/17 14:48
     */
    List<CityImEntity> getCityCount1(@Param("startDay") String startDay, @Param("endDay") String endDay, @Param("citys") List<String> citys, @Param("business") String business);

    /**
     * 以业务为维度，获取全国或者某个城市的首页uv、列表uv、详情页uv、IM聊天人数、会话数、有反馈会话数、无反馈会话数
     *
     * @return java.util.List<com.fang.bigdata.metadata.entity.BusinessPercentageEntity>
     * @author linan
     * @Param [startDay, endDay, city]
     * @date 2018/12/17 15:01
     */
    List<BusinessImEntity> getOneCityCount2(@Param("startDay") String startDay, @Param("endDay") String endDay, @Param("city") String city);

    /**
     * 计算某个城市中某个业务每天的首页uv、列表uv、详情页uv、IM聊天人数、会话数、有反馈会话数、无反馈会话数
     *
     * @return java.util.List<com.fang.bigdata.metadata.entity.ActionDayImEntity>
     * @author linan
     * @Param [startDay, endDay, city, business]
     * @date 2018/12/17 15:33
     */
    List<ActionDayImEntity> getImCountByActionDay(@Param("startDay") String startDay, @Param("endDay") String endDay, @Param("city") String city, @Param("business") String business);

    /**
     * 计算全国或者某些指定城市的转化率排名---不分业务
     *
     * @return java.util.List<com.fang.bigdata.metadata.entity.PercentRankBaseEntity>
     * @author linan
     * @Param [startDay, endDay, citys]
     * @date 2018/12/19 17:25
     */
    List<PercentRankBaseEntity> getPercentRankByCity(@Param("startDay") String startDay, @Param("endDay") String endDay, @Param("citys") List<String> citys);

    /**
     * 计算全部业务抓化率排名 ----不分城市
     *
     * @return java.util.List<com.fang.bigdata.metadata.entity.PercentRankBaseEntity>
     * @author linan
     * @Param [startDay, endDay]
     * @date 2018/12/19 18:50
     */
    List<PercentRankBaseEntity> getPercentRankByBusiness(@Param("startDay") String startDay, @Param("endDay") String endDay);

    /**
     * 计算app各个页面的点击量排名----区分业务
     *
     * @return java.util.List<com.fang.bigdata.metadata.entity.PageClickRankEntity>
     * @author linan
     * @Param [actionDay, platform, business, limit]
     * @date 2018/12/19 19:37
     */
    List<PageClickRankEntity> getClickCountRankByBusiness(@Param("actionDay") String actionDay, @Param("platform") String paltform, @Param("business") String business,@Param("limit") Integer limit);
    /**

     * 计算app各个页面的点击转化率排名----区分业务

     * @author  linan

     * @Param   [actionDay, paltform, business, limit]

     * @return  java.util.List<com.fang.bigdata.metadata.entity.PageClickRankEntity>

     * @date    2018/12/25 14:52

     */
    List<PageClickRankEntity> getClickPercentRankByBusiness(@Param("actionDay") String actionDay, @Param("platform") String paltform, @Param("business") String business,@Param("limit") Integer limit);


    /**
     * 计算某段时间内各页面uv量求和
     * @param startDay
     * @param endDay
     * @return
     */
    ImEntity getOneImEntity(@Param("startDay") String startDay, @Param("endDay") String endDay);

    /**
     * 获取某天某产品的会话总数、有无反馈数
     * @param actionDay
     * @param producttype
     * @return
     */
    List<ImStaticsPageuvChat> getImStaticsPageuvChatByProducttype(@Param("actionDay") String actionDay,@Param("producttype") String producttype);
}
