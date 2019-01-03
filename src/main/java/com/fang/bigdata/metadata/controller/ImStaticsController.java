package com.fang.bigdata.metadata.controller;

import com.fang.bigdata.metadata.entity.imstatics.*;
import com.fang.bigdata.metadata.service.ImStaticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/imstatics")
public class ImStaticsController {
    @Autowired
    ImStaticsService imStaticsService;

    @Deprecated
    @RequestMapping("/getcitypercentage1")
    public Object getCityPercentage1(String actionday, String city) {
        if (actionday == null || city == null)
            throw new RuntimeException("参数异常");
        return imStaticsService.getCityPercentage1(actionday, city);

    }

    @Deprecated
    @RequestMapping("/getonecitypercentage2")
    public Object getOneCityPercentage2(String actionday, String city) {
        if (actionday == null || city == null)
            throw new RuntimeException("参数异常");
        return imStaticsService.getOneCityPercentage2(actionday, city);

    }

    /**
     * 多个城市对比 首页 列表 想请 im点击 回话 有效反馈 无效反馈
     * 横轴大单元是城市  小单元是 首页 列表。。。。
     * 纵轴是数量
     *
     * @param actionday
     * @param city
     * @return
     */
    @RequestMapping("/getcitycount1")
    public Object getCityCount1(String actionday, String city, String business) {
        if (actionday == null || city == null)
            throw new RuntimeException("参数异常");
        return imStaticsService.getCityCount1(actionday, city, business);

    }

    /**
     * 单个城市分业务  首页 列表 想请 im点击 回话 有效反馈 无效反馈
     * 横轴大单元是业务（新房 租房 二手房 家居）  小单元是 首页 列表。。。。
     * 纵轴是数量
     *
     * @param actionday
     * @param city
     * @return
     */
    @RequestMapping("/getonecitycount2")
    public Object getOneCityCount2(String actionday, String city) {
        if (actionday == null || city == null)
            throw new RuntimeException("参数异常");
        return imStaticsService.getOneCityCount2(actionday, city);

    }

    /**
     * 单个城市分业务  首页 列表 想请 im点击 回话 有效反馈 无效反馈
     * 横轴大单元日期  小单元是 首页 列表。。。。
     * 纵轴是数量
     *
     * @param actionday
     * @param city
     * @return
     */
    @RequestMapping("/getonecitydaycount3")
    public Object getOneCityDayCount3(String actionday, String city, String business) {
        if (actionday == null || city == null)
            throw new RuntimeException("参数异常");
        return imStaticsService.getOneCityDayCount3(actionday, city, business);

    }

    /**
     * 传入日期，城市 城市非必填
     * 查出城市转化率
     * 纵轴是数量
     *
     * @param actionday
     * @param city
     * @return
     */
    @RequestMapping("/citypercentageorder1")
    public Object getCityPercentageOrder1(String actionday, String city) {
        if (actionday == null)
            throw new RuntimeException("参数异常");

        return imStaticsService.getCityPercentageOrder1(actionday, city);
    }

    /**
     * 传入日期，城市
     * 查业务转化率
     * 纵轴是数量
     *
     * @param actionday
     * @return
     */
    @RequestMapping("/getpercentrankbybusiness2")
    public Object getPercentRankByBusiness2(String actionday) {
        if (actionday == null)
            throw new RuntimeException("参数异常");

        return imStaticsService.getPercentRankByBusiness(actionday);
    }

    /**
     * 传入日期，城市
     * 查业务转化率
     * 纵轴是数量
     *
     * @param actionday
     * @return
     */
    @RequestMapping("/getclickcountrankbybusiness3")
    public Object getClickCountRankByBusiness3(String actionday, String platform, String business, Integer limit) {
        if (actionday == null || limit == null)
            throw new RuntimeException("参数异常");

        return imStaticsService.getClickCountRankByBusiness3(actionday, platform, business, limit);
    }


    /**
     * 传入日期，城市
     * 查业务转化率
     * 纵轴是数量
     *
     * @param actionday
     * @return
     */
    @RequestMapping("/getclickpercentrankbybusiness4")
    public Object getClickPercentRankByBusiness4(String actionday, String platform, String business, Integer limit) {
        if (actionday == null || limit == null)
            throw new RuntimeException("参数异常");

        return imStaticsService.getClickPercentRankByBusiness4(actionday, platform, business, limit);
    }

//    /**
//     * 传入日期，城市
//     * 查业务转化率
//     * 纵轴是数量
//     *
//     * @param actionday
//     * @return
//     */
//    @RequestMapping("/getClickPercentRankByBusiness5")
//    public Object getClickPercentRankByBusiness5(String actionday, String platform, String business, Integer limit) {
//        if (actionday == null || limit == null)
//            throw new RuntimeException("参数异常");
//
//        return imStaticsService.getClickPercentRankByBusiness5(actionday, platform, business, limit);
//    }

    @RequestMapping("/getYesterdayUV")
    public ImEntity getYesterdayUV(String actionday){
        return imStaticsService.getOneImEntity(actionday);
    }

    @RequestMapping("/getAPPNewHouseUV")
    public Object getAPPNewHouseUV(String actionday){
        return imStaticsService.getAPPNewHouseUV(actionday);
    }

    @RequestMapping("/getAPPNewHouseUVList")
    public List<ProjnameImEntity> getAPPNewHouseUVList(String actionday){
        return imStaticsService.getTop10UvCountByProjName(actionday);
    }

    @RequestMapping("/getImStaticsPageuvChatByProducttype")
    public List<ImStaticsPageuvChat> getImStaticsPageuvChatByProducttype(String actionday, String producttype){
        return imStaticsService.getImStaticsPageuvChatByProducttype(actionday, producttype);
    }

}
