package com.fang.bigdata.metadata.service;

import com.fang.bigdata.metadata.commons.ImStaticsRetBean;
import com.fang.bigdata.metadata.commons.ImStaticsRetBeanCount;
import com.fang.bigdata.metadata.commons.SeriesBean;
import com.fang.bigdata.metadata.commons.SeriesBeanCount;
import com.fang.bigdata.metadata.dao.ImStaticsMapper;
import com.fang.bigdata.metadata.daoimpala.ImStaticsProjnameMapper;
import com.fang.bigdata.metadata.entity.*;
import com.fang.bigdata.metadata.entity.imstatics.*;
import com.fang.bigdata.metadata.utils.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.ParseException;
import java.util.*;

@Service("ImStaticsService")
public class ImStaticsServiceImpl implements ImStaticsService {

    @Autowired
    ImStaticsMapper imStaticsMapper;

    @Override
    public ImStaticsRetBean getCityPercentage1(String actionday, String city) {
        ImStaticsRetBean imStaticsRetBean = new ImStaticsRetBean();
        List<String> citys = Arrays.asList(city.split(",", -1));
        List<String> actiondays = Arrays.asList(actionday.split(",", -1));
        List<CityPercentageEntity> cityPercentageEntitys = imStaticsMapper.getCityPercentage1(actiondays.get(0), actiondays.get(1), citys);
//        cityPercentageEntitys.get(0).getCity();
        Map<String, CityPercentageEntity> cityPercentageEntityMap = new HashMap();
//        for(String cityone:citys){
//            cityPercentageEntityMap.put(cityone,new ArrayList<CityPercentageEntity>());
//        }

        for (CityPercentageEntity c : cityPercentageEntitys) {
            cityPercentageEntityMap.put(c.getCity(), c);
        }


        List<SeriesBean> seriesBeans = new ArrayList<>();

        SeriesBean seriesBean1 = new SeriesBean();
        seriesBean1.setName("首页->列表");
        List<String> datas1 = new ArrayList<>();
        for (String c : citys)
            if (cityPercentageEntityMap.get(c) != null)
                datas1.add(cityPercentageEntityMap.get(c).getListIndexRatio());
            else datas1.add("0.00");
//        datas1.add();
//        datas1.add("8.02%");
//        datas1.add("84.08%");
        seriesBean1.setData(datas1);
        seriesBeans.add(seriesBean1);

        SeriesBean seriesBean2 = new SeriesBean();
        seriesBean2.setName("列表->详情");
        List<String> datas2 = new ArrayList<>();
        for (String c : citys)
            if (cityPercentageEntityMap.get(c) != null)
                datas2.add(cityPercentageEntityMap.get(c).getDetailListRatio());
            else datas2.add("0.00");
//        datas2.add("27.01%");
//        datas2.add("38.02%");
//        datas2.add("10.08%");
        seriesBean2.setData(datas2);
        seriesBeans.add(seriesBean2);

        SeriesBean seriesBean3 = new SeriesBean();
        seriesBean3.setName("详情->IM");
        List<String> datas3 = new ArrayList<>();
        for (String c : citys)
            if (cityPercentageEntityMap.get(c) != null)
                datas3.add(cityPercentageEntityMap.get(c).getDetailImRatio());
            else datas3.add("0.00");
//        datas3.add("29.01%");
//        datas3.add("77.02%");
//        datas3.add("16.08%");
        seriesBean3.setData(datas3);
        seriesBeans.add(seriesBean3);

        SeriesBean seriesBean4 = new SeriesBean();
        seriesBean4.setName("会话->有反馈会话");
        List<String> datas4 = new ArrayList<>();
        for (String c : citys)
            if (cityPercentageEntityMap.get(c) != null)
                datas4.add(cityPercentageEntityMap.get(c).getValidSessionRatio());
            else datas4.add("0.00");
//        datas4.add("13.01%");
//        datas4.add("57.02%");
//        datas4.add("26.08%");
        seriesBean4.setData(datas4);
        seriesBeans.add(seriesBean4);

        SeriesBean seriesBean5 = new SeriesBean();
        seriesBean5.setName("会话->无反馈");
        List<String> datas5 = new ArrayList<>();
        for (String c : citys)
            if (cityPercentageEntityMap.get(c) != null)
                datas5.add(cityPercentageEntityMap.get(c).getInvalidSessionRatio());
            else datas5.add("0.00");
//        datas5.add("90.01%");
//        datas5.add("58.02%");
//        datas5.add("36.08%");
        seriesBean5.setData(datas5);
        seriesBeans.add(seriesBean5);


//        List<String> cityList = Arrays.asList(city.split(",", -1));
//        List<String> cityList = new ArrayList<>();
//        cityList.add("北京");
//        cityList.add("上海");
//        cityList.add("广州");
        imStaticsRetBean.setSeries(seriesBeans);
        imStaticsRetBean.setX(citys);

        return imStaticsRetBean;
    }

    @Override
    public ImStaticsRetBean getOneCityPercentage2(String actionday, String city) {
        ImStaticsRetBean imStaticsRetBean = new ImStaticsRetBean();
//        List<String> citys = Arrays.asList(city.split(",", -1));
        List<String> gptypes = Arrays.asList("新房挂牌,二手房挂牌,租房挂牌,家居挂牌".split(",", -1));
        List<String> actiondays = Arrays.asList(actionday.split(",", -1));
        List<BusinessPercentageEntity> businessPercentageEntities = imStaticsMapper.getCityPercentage2(actiondays.get(0), actiondays.get(1), city);
//        cityPercentageEntitys.get(0).getCity();
        Map<String, BusinessPercentageEntity> businessPercentageEntityMap = new HashMap();
//        for(String cityone:citys){
//            cityPercentageEntityMap.put(cityone,new ArrayList<CityPercentageEntity>());
//        }

        for (BusinessPercentageEntity b : businessPercentageEntities) {
            businessPercentageEntityMap.put(b.getBusiness(), b);
        }


        List<SeriesBean> seriesBeans = new ArrayList<>();

        SeriesBean seriesBean1 = new SeriesBean();
        seriesBean1.setName("首页->列表");
        List<String> datas1 = new ArrayList<>();
        for (String c : gptypes)
            if (businessPercentageEntityMap.get(c) != null)
                datas1.add(businessPercentageEntityMap.get(c).getListIndexRatio());
            else datas1.add("0.00");
//        datas1.add();
//        datas1.add("8.02%");
//        datas1.add("84.08%");
        seriesBean1.setData(datas1);
        seriesBeans.add(seriesBean1);

        SeriesBean seriesBean2 = new SeriesBean();
        seriesBean2.setName("列表->详情");
        List<String> datas2 = new ArrayList<>();
        for (String c : gptypes)
            if (businessPercentageEntityMap.get(c) != null)
                datas2.add(businessPercentageEntityMap.get(c).getDetailListRatio());
            else datas2.add("0.00");
//        datas2.add("27.01%");
//        datas2.add("38.02%");
//        datas2.add("10.08%");
        seriesBean2.setData(datas2);
        seriesBeans.add(seriesBean2);

        SeriesBean seriesBean3 = new SeriesBean();
        seriesBean3.setName("详情->IM");
        List<String> datas3 = new ArrayList<>();
        for (String c : gptypes)
            if (businessPercentageEntityMap.get(c) != null)
                datas3.add(businessPercentageEntityMap.get(c).getDetailImRatio());
            else datas3.add("0.00");
//        datas3.add("29.01%");
//        datas3.add("77.02%");
//        datas3.add("16.08%");
        seriesBean3.setData(datas3);
        seriesBeans.add(seriesBean3);

        SeriesBean seriesBean4 = new SeriesBean();
        seriesBean4.setName("会话->有反馈会话");
        List<String> datas4 = new ArrayList<>();
        for (String c : gptypes)
            if (businessPercentageEntityMap.get(c) != null && businessPercentageEntityMap.get(c).getValidSessionRatio() != null)
                datas4.add(businessPercentageEntityMap.get(c).getValidSessionRatio());
            else datas4.add("0.00");
//        datas4.add("13.01%");
//        datas4.add("57.02%");
//        datas4.add("26.08%");
        seriesBean4.setData(datas4);
        seriesBeans.add(seriesBean4);

        SeriesBean seriesBean5 = new SeriesBean();
        seriesBean5.setName("会话->无反馈");
        List<String> datas5 = new ArrayList<>();
        for (String c : gptypes)
            if (businessPercentageEntityMap.get(c) != null && businessPercentageEntityMap.get(c).getInvalidSessionRatio() != null)
                datas5.add(businessPercentageEntityMap.get(c).getInvalidSessionRatio());
            else datas5.add("0.00");
//        datas5.add("90.01%");
//        datas5.add("58.02%");
//        datas5.add("36.08%");
        seriesBean5.setData(datas5);
        seriesBeans.add(seriesBean5);


//        List<String> cityList = Arrays.asList(city.split(",", -1));
//        List<String> cityList = new ArrayList<>();
//        cityList.add("北京");
//        cityList.add("上海");
//        cityList.add("广州");
        imStaticsRetBean.setSeries(seriesBeans);
        imStaticsRetBean.setX(gptypes);

        return imStaticsRetBean;
    }

    @Override
    public ImStaticsRetBeanCount getCityCount1(String actionday, String city, String business) {
        ImStaticsRetBeanCount imStaticsRetBeanCount = new ImStaticsRetBeanCount();
        List<String> citys = Arrays.asList(city.split(",", -1));
        List<String> actiondays = Arrays.asList(actionday.split(",", -1));
        List<CityImEntity> cityImEntities = imStaticsMapper.getCityCount1(actiondays.get(0), actiondays.get(1), citys, business);
//        cityPercentageEntitys.get(0).getCity();
        Map<String, CityImEntity> cityImEntityMap = new HashMap();
//        for(String cityone:citys){
//            cityPercentageEntityMap.put(cityone,new ArrayList<CityPercentageEntity>());
//        }

        for (CityImEntity c : cityImEntities) {
            cityImEntityMap.put(c.getCity(), c);
        }


        List<SeriesBeanCount> seriesBeanCounts = new ArrayList<>();

        SeriesBeanCount seriesBeanCount1 = new SeriesBeanCount();
        seriesBeanCount1.setName("首页");
        List<String> datas1 = new ArrayList<>();
        for (String c : citys)
            if (cityImEntityMap.get(c) != null && cityImEntityMap.get(c).getIndexPageUv() != null)
                datas1.add(cityImEntityMap.get(c).getIndexPageUv().toString());
            else datas1.add("0");
        seriesBeanCount1.setData(datas1);
        seriesBeanCounts.add(seriesBeanCount1);

        SeriesBeanCount seriesBeanCount2 = new SeriesBeanCount();
        seriesBeanCount2.setName("列表页");
        List<String> datas2 = new ArrayList<>();
        for (String c : citys)
            if (cityImEntityMap.get(c) != null && cityImEntityMap.get(c).getListPageUv() != null)
                datas2.add(cityImEntityMap.get(c).getListPageUv().toString());
            else datas2.add("0");
        seriesBeanCount2.setData(datas2);
        seriesBeanCounts.add(seriesBeanCount2);

        SeriesBeanCount seriesBeanCount3 = new SeriesBeanCount();
        seriesBeanCount3.setName("详情页");
        List<String> datas3 = new ArrayList<>();
        for (String c : citys)
            if (cityImEntityMap.get(c) != null && cityImEntityMap.get(c).getDetailPageUv() != null)
                datas3.add(cityImEntityMap.get(c).getDetailPageUv().toString());
            else datas3.add("0");
        seriesBeanCount3.setData(datas3);
        seriesBeanCounts.add(seriesBeanCount3);

        SeriesBeanCount seriesBeanCount4 = new SeriesBeanCount();
        seriesBeanCount4.setName("im点击人数");
        List<String> datas4 = new ArrayList<>();
        for (String c : citys)
            if (cityImEntityMap.get(c) != null && cityImEntityMap.get(c).getImCount() != null)
                datas4.add(cityImEntityMap.get(c).getImCount().toString());
            else datas4.add("0");
        seriesBeanCount4.setData(datas4);
        seriesBeanCounts.add(seriesBeanCount4);

        SeriesBeanCount seriesBeanCount5 = new SeriesBeanCount();
        seriesBeanCount5.setName("会话总数");
        List<String> datas5 = new ArrayList<>();
        for (String c : citys)
            if (cityImEntityMap.get(c) != null && cityImEntityMap.get(c).getSessionCount() != null)
                datas5.add(cityImEntityMap.get(c).getSessionCount().toString());
            else datas5.add("0");
        seriesBeanCount5.setData(datas5);
        seriesBeanCounts.add(seriesBeanCount5);


        SeriesBeanCount seriesBeanCount6 = new SeriesBeanCount();
        seriesBeanCount6.setName("有反馈会话数");
        List<String> datas6 = new ArrayList<>();
        for (String c : citys)
            if (cityImEntityMap.get(c) != null && cityImEntityMap.get(c).getValidSessionCount() != null)
                datas6.add(cityImEntityMap.get(c).getValidSessionCount().toString());
            else datas6.add("0");
        seriesBeanCount6.setData(datas6);
        seriesBeanCounts.add(seriesBeanCount6);

        SeriesBeanCount seriesBeanCount7 = new SeriesBeanCount();
        seriesBeanCount7.setName("无反馈会话数");
        List<String> datas7 = new ArrayList<>();
        for (String c : citys)
            if (cityImEntityMap.get(c) != null && cityImEntityMap.get(c).getInvalidSessionCount() != null)
                datas7.add(cityImEntityMap.get(c).getInvalidSessionCount().toString());
            else datas7.add("0");
        seriesBeanCount7.setData(datas7);
        seriesBeanCounts.add(seriesBeanCount7);


        SeriesBeanCount seriesBeanCount8 = new SeriesBeanCount();
        seriesBeanCount8.setName("IM点击转化率");
        seriesBeanCount8.setType("line");
        List<String> datas8 = new ArrayList<>();
//        for (String c : citys){
        for (String c : citys) {
            //im
            Integer im = 0;
            if (cityImEntityMap.get(c) != null && cityImEntityMap.get(c).getImCount() != null)
                im = cityImEntityMap.get(c).getImCount();
//            else im = datas4.add("0");

            //详情
            Integer xq = 0;
            if (cityImEntityMap.get(c) != null && cityImEntityMap.get(c).getDetailPageUv() != null)
                xq = cityImEntityMap.get(c).getDetailPageUv();

            if (xq == 0)
                datas8.add("0");
            else
                datas8.add(new BigDecimal(im).multiply(new BigDecimal("100")).divide(new BigDecimal(xq), 2, RoundingMode.HALF_UP).toString());
//            else datas3.add("0");
        }
//            if (cityImEntityMap.get(c) != null && cityImEntityMap.get(c).getInvalidSessionCount() != null)
//                datas8.add(cityImEntityMap.get(c).getInvalidSessionCount().toString());
//            else datas8.add("0");
        seriesBeanCount8.setData(datas8);
        seriesBeanCount8.setyAxisIndex(1);
        seriesBeanCounts.add(seriesBeanCount8);


        imStaticsRetBeanCount.setSeries(seriesBeanCounts);
        imStaticsRetBeanCount.setX(citys);

        return imStaticsRetBeanCount;
    }


    @Override
    public ImStaticsRetBeanCount getOneCityCount2(String actionday, String city) {
        ImStaticsRetBeanCount imStaticsRetBeanCount = new ImStaticsRetBeanCount();
        List<String> gptypes = Arrays.asList("新房挂牌,二手房挂牌,租房挂牌,家居挂牌".split(",", -1));
        List<String> actiondays = Arrays.asList(actionday.split(",", -1));
        List<BusinessImEntity> businessImEntities = imStaticsMapper.getOneCityCount2(actiondays.get(0), actiondays.get(1), city);
        Map<String, BusinessImEntity> businessImEntityMap = new HashMap();

        for (BusinessImEntity b : businessImEntities) {
            businessImEntityMap.put(b.getBusiness(), b);
        }


        List<SeriesBeanCount> seriesBeanCounts = new ArrayList<>();

        SeriesBeanCount seriesBeanCount1 = new SeriesBeanCount();
        seriesBeanCount1.setName("首页");
        List<String> datas1 = new ArrayList<>();
        for (String c : gptypes)
            if (businessImEntityMap.get(c) != null && businessImEntityMap.get(c).getIndexPageUv() != null)
                datas1.add(businessImEntityMap.get(c).getIndexPageUv().toString());
            else datas1.add("0");
        seriesBeanCount1.setData(datas1);
        seriesBeanCounts.add(seriesBeanCount1);

        SeriesBeanCount seriesBeanCount2 = new SeriesBeanCount();
        seriesBeanCount2.setName("列表页");
        List<String> datas2 = new ArrayList<>();
        for (String c : gptypes)
            if (businessImEntityMap.get(c) != null && businessImEntityMap.get(c).getListPageUv() != null)
                datas2.add(businessImEntityMap.get(c).getListPageUv().toString());
            else datas2.add("0");
        seriesBeanCount2.setData(datas2);
        seriesBeanCounts.add(seriesBeanCount2);

        SeriesBeanCount seriesBeanCount3 = new SeriesBeanCount();
        seriesBeanCount3.setName("详情页");
        List<String> datas3 = new ArrayList<>();
        for (String c : gptypes)
            if (businessImEntityMap.get(c) != null && businessImEntityMap.get(c).getDetailPageUv() != null)
                datas3.add(businessImEntityMap.get(c).getDetailPageUv().toString());
            else datas3.add("0");
        seriesBeanCount3.setData(datas3);
        seriesBeanCounts.add(seriesBeanCount3);

        SeriesBeanCount seriesBeanCount4 = new SeriesBeanCount();
        seriesBeanCount4.setName("im点击人数");
        List<String> datas4 = new ArrayList<>();
        for (String c : gptypes)
            if (businessImEntityMap.get(c) != null && businessImEntityMap.get(c).getImCount() != null)
                datas4.add(businessImEntityMap.get(c).getImCount().toString());
            else datas4.add("0");
        seriesBeanCount4.setData(datas4);
        seriesBeanCounts.add(seriesBeanCount4);

        SeriesBeanCount seriesBeanCount5 = new SeriesBeanCount();
        seriesBeanCount5.setName("会话总数");
        List<String> datas5 = new ArrayList<>();
        for (String c : gptypes)
            if (businessImEntityMap.get(c) != null && businessImEntityMap.get(c).getSessionCount() != null)
                datas5.add(businessImEntityMap.get(c).getSessionCount().toString());
            else datas5.add("0");
        seriesBeanCount5.setData(datas5);
        seriesBeanCounts.add(seriesBeanCount5);

        SeriesBeanCount seriesBeanCount6 = new SeriesBeanCount();
        seriesBeanCount6.setName("有反馈会话数");
        List<String> datas6 = new ArrayList<>();
        for (String c : gptypes)
            if (businessImEntityMap.get(c) != null && businessImEntityMap.get(c).getValidSessionCount() != null)
                datas6.add(businessImEntityMap.get(c).getValidSessionCount().toString());
            else datas6.add("0");
        seriesBeanCount6.setData(datas6);
        seriesBeanCounts.add(seriesBeanCount6);

        SeriesBeanCount seriesBeanCount7 = new SeriesBeanCount();
        seriesBeanCount7.setName("无反馈会话数");
        List<String> datas7 = new ArrayList<>();
        for (String c : gptypes)
            if (businessImEntityMap.get(c) != null && businessImEntityMap.get(c).getInvalidSessionCount() != null)
                datas7.add(businessImEntityMap.get(c).getInvalidSessionCount().toString());
            else datas7.add("0");
        seriesBeanCount7.setData(datas7);
        seriesBeanCounts.add(seriesBeanCount7);

        SeriesBeanCount seriesBeanCount8 = new SeriesBeanCount();
        seriesBeanCount8.setName("IM点击转化率");
        seriesBeanCount8.setType("line");
        List<String> datas8 = new ArrayList<>();
//        for (String c : citys){
        for (String c : gptypes) {
            //im
            Integer im = 0;
            if (businessImEntityMap.get(c) != null && businessImEntityMap.get(c).getImCount() != null)
                im = businessImEntityMap.get(c).getImCount();
//            else im = datas4.add("0");

            //详情
            Integer xq = 0;
            if (businessImEntityMap.get(c) != null && businessImEntityMap.get(c).getDetailPageUv() != null)
                xq = businessImEntityMap.get(c).getDetailPageUv();

            if (xq == 0)
                datas8.add("0");
            else
                datas8.add(new BigDecimal(im).multiply(new BigDecimal("100")).divide(new BigDecimal(xq), 2, RoundingMode.HALF_UP).toString());
//            else datas3.add("0");
        }
//            if (cityImEntityMap.get(c) != null && cityImEntityMap.get(c).getInvalidSessionCount() != null)
//                datas8.add(cityImEntityMap.get(c).getInvalidSessionCount().toString());
//            else datas8.add("0");
        seriesBeanCount8.setData(datas8);
        seriesBeanCount8.setyAxisIndex(1);
        seriesBeanCounts.add(seriesBeanCount8);

        imStaticsRetBeanCount.setSeries(seriesBeanCounts)
        ;
        imStaticsRetBeanCount.setX(gptypes);

        return imStaticsRetBeanCount;
    }

    @Override
    public ImStaticsRetBeanCount getOneCityDayCount3(String actionday, String city, String business) {
        ImStaticsRetBeanCount imStaticsRetBeanCount = new ImStaticsRetBeanCount();
//        List<String> gptypes = Arrays.asList("新房挂牌,二手房挂牌,租房挂牌,家居挂牌".split(",", -1));
        List<String> actiondays = Arrays.asList(actionday.split(",", -1));
        List<String> actiondaysAll = null;
        try {
            actiondaysAll = Arrays.asList(DateUtil.getDays(actiondays.get(0), actiondays.get(1)).split(",", -1));
        } catch (ParseException e) {
            e.printStackTrace();
            throw new RuntimeException("日期转换异常：" + actiondays.get(0) + "," + actiondays.get(1));
        }

        List<ActionDayImEntity> actionDayImEntities = imStaticsMapper.getImCountByActionDay(actiondays.get(0), actiondays.get(1), city, business);
        Map<String, ActionDayImEntity> actionDayImEntityMap = new HashMap();

        for (ActionDayImEntity b : actionDayImEntities) {
            actionDayImEntityMap.put(b.getActionDay(), b);
        }


        List<SeriesBeanCount> seriesBeanCounts = new ArrayList<>();

        SeriesBeanCount seriesBeanCount1 = new SeriesBeanCount();
        seriesBeanCount1.setName("首页");
        List<String> datas1 = new ArrayList<>();
        for (String c : actiondaysAll)
            if (actionDayImEntityMap.get(c) != null && actionDayImEntityMap.get(c).getIndexPageUv() != null)
                datas1.add(actionDayImEntityMap.get(c).getIndexPageUv().toString());
            else datas1.add("0");
        seriesBeanCount1.setData(datas1);
        seriesBeanCounts.add(seriesBeanCount1);

        SeriesBeanCount seriesBeanCount2 = new SeriesBeanCount();
        seriesBeanCount2.setName("列表页");
        List<String> datas2 = new ArrayList<>();
        for (String c : actiondaysAll)
            if (actionDayImEntityMap.get(c) != null && actionDayImEntityMap.get(c).getListPageUv() != null)
                datas2.add(actionDayImEntityMap.get(c).getListPageUv().toString());
            else datas2.add("0");
        seriesBeanCount2.setData(datas2);
        seriesBeanCounts.add(seriesBeanCount2);

        SeriesBeanCount seriesBeanCount3 = new SeriesBeanCount();
        seriesBeanCount3.setName("详情页");
        List<String> datas3 = new ArrayList<>();
        for (String c : actiondaysAll)
            if (actionDayImEntityMap.get(c) != null && actionDayImEntityMap.get(c).getDetailPageUv() != null)
                datas3.add(actionDayImEntityMap.get(c).getDetailPageUv().toString());
            else datas3.add("0");
        seriesBeanCount3.setData(datas3);
        seriesBeanCounts.add(seriesBeanCount3);

        SeriesBeanCount seriesBeanCount4 = new SeriesBeanCount();
        seriesBeanCount4.setName("im点击人数");
        List<String> datas4 = new ArrayList<>();
        for (String c : actiondaysAll)
            if (actionDayImEntityMap.get(c) != null && actionDayImEntityMap.get(c).getImCount() != null)
                datas4.add(actionDayImEntityMap.get(c).getImCount().toString());
            else datas4.add("0");
        seriesBeanCount4.setData(datas4);
        seriesBeanCounts.add(seriesBeanCount4);

        SeriesBeanCount seriesBeanCount5 = new SeriesBeanCount();
        seriesBeanCount5.setName("会话总数");
        List<String> datas5 = new ArrayList<>();
        for (String c : actiondaysAll)
            if (actionDayImEntityMap.get(c) != null && actionDayImEntityMap.get(c).getSessionCount() != null)
                datas5.add(actionDayImEntityMap.get(c).getSessionCount().toString());
            else datas5.add("0");
        seriesBeanCount5.setData(datas5);
        seriesBeanCounts.add(seriesBeanCount5);

        SeriesBeanCount seriesBeanCount6 = new SeriesBeanCount();
        seriesBeanCount6.setName("有反馈会话数");
        List<String> datas6 = new ArrayList<>();
        for (String c : actiondaysAll)
            if (actionDayImEntityMap.get(c) != null && actionDayImEntityMap.get(c).getValidSessionCount() != null)
                datas6.add(actionDayImEntityMap.get(c).getValidSessionCount().toString());
            else datas6.add("0");
        seriesBeanCount6.setData(datas6);
        seriesBeanCounts.add(seriesBeanCount6);

        SeriesBeanCount seriesBeanCount7 = new SeriesBeanCount();
        seriesBeanCount7.setName("无反馈会话数");
        List<String> datas7 = new ArrayList<>();
        for (String c : actiondaysAll)
            if (actionDayImEntityMap.get(c) != null && actionDayImEntityMap.get(c).getInvalidSessionCount() != null)
                datas7.add(actionDayImEntityMap.get(c).getInvalidSessionCount().toString());
            else datas7.add("0");
        seriesBeanCount7.setData(datas7);
        seriesBeanCounts.add(seriesBeanCount7);
        SeriesBeanCount seriesBeanCount8 = new SeriesBeanCount();
        seriesBeanCount8.setName("IM点击转化率");
        seriesBeanCount8.setType("line");
        List<String> datas8 = new ArrayList<>();
//        for (String c : citys){
        for (String c : actiondaysAll) {
            //im
            Integer im = 0;
            if (actionDayImEntityMap.get(c) != null && actionDayImEntityMap.get(c).getImCount() != null)
                im = actionDayImEntityMap.get(c).getImCount();
//            else im = datas4.add("0");

            //详情
            Integer xq = 0;
            if (actionDayImEntityMap.get(c) != null && actionDayImEntityMap.get(c).getDetailPageUv() != null)
                xq = actionDayImEntityMap.get(c).getDetailPageUv();

            if (xq == 0)
                datas8.add("0");
            else
                datas8.add(new BigDecimal(im).multiply(new BigDecimal("100")).divide(new BigDecimal(xq), 2, RoundingMode.HALF_UP).toString());
//            else datas3.add("0");
        }
//            if (cityImEntityMap.get(c) != null && cityImEntityMap.get(c).getInvalidSessionCount() != null)
//                datas8.add(cityImEntityMap.get(c).getInvalidSessionCount().toString());
//            else datas8.add("0");
        seriesBeanCount8.setData(datas8);
        seriesBeanCount8.setyAxisIndex(1);
        seriesBeanCounts.add(seriesBeanCount8);
        imStaticsRetBeanCount.setSeries(seriesBeanCounts);
        imStaticsRetBeanCount.setX(actiondaysAll);

        return imStaticsRetBeanCount;
    }

    @Override
    public List<PercentRankBaseEntity> getCityPercentageOrder1(String actionday, String city) {

        String[] actiondays = actionday.split(",", -1);
        List<String> l = null;
        if (city != null)
            l = Arrays.asList(city.split(",", -1));
        List<PercentRankBaseEntity> ll = imStaticsMapper.getPercentRankByCity(actiondays[0], actiondays[1], l);
        int count = 0;
        for (PercentRankBaseEntity percentRankBaseEntity : ll)
            percentRankBaseEntity.setRank(++count);

        return ll;

    }

    @Override
    public List<PercentRankBaseEntity> getPercentRankByBusiness(String actionday) {
        String[] actiondays = actionday.split(",", -1);
        List<PercentRankBaseEntity> ll = imStaticsMapper.getPercentRankByBusiness(actiondays[0], actiondays[1]);
        int count = 0;
        for (PercentRankBaseEntity percentRankBaseEntity : ll)
            percentRankBaseEntity.setRank(++count);

        return ll;
    }

    @Override
    public List<PageClickRankEntity> getClickCountRankByBusiness3(String actionday, String platform, String business, Integer limit) {
        List<PageClickRankEntity> ll = imStaticsMapper.getClickCountRankByBusiness(actionday, platform, business, limit);
        int count = 0;
        for (PageClickRankEntity percentRankBaseEntity : ll)
            percentRankBaseEntity.setRank(++count);
        return ll;
    }

    @Override
    public ImStaticsRetBeanCount getClickPercentRankByBusiness4(String actionday, String platform, String business, Integer limit) {
        ImStaticsRetBeanCount imStaticsRetBeanCount = new ImStaticsRetBeanCount();
        List<String> line = new ArrayList<>();
        line.add("IM点击量");
        line.add("访问量");
        line.add("转化率");
        imStaticsRetBeanCount.setLine(line);
//        List<String> gptypes = Arrays.asList("新房挂牌,二手房挂牌,租房挂牌,家居挂牌".split(",", -1));
        List<String> actiondays = Arrays.asList(actionday.split(",", -1));
//        List<String> actiondaysAll = null;
//        try {
//            actiondaysAll = Arrays.asList(DateUtil.getDays(actiondays.get(0), actiondays.get(1)).split(",", -1));
//        } catch (ParseException e) {
//            e.printStackTrace();
//            throw new RuntimeException("日期转换异常：" + actiondays.get(0) + "," + actiondays.get(1));
//        }

        List<PageClickRankEntity> actionDayImEntities = imStaticsMapper.getClickPercentRankByBusiness(actionday, platform, business, limit);
        Map<String, PageClickRankEntity> actionDayImEntityMap = new HashMap();
        Set<String> pageNameSet = new HashSet<>();

        List<String> l = new ArrayList<>();
        for (PageClickRankEntity b : actionDayImEntities) {
            actionDayImEntityMap.put(b.getPageName(), b);
            l.add(b.getPageName());
        }

//        for (String s : pageNameSet)
//            l.add(s);

        List<SeriesBeanCount> seriesBeanCounts = new ArrayList<>();

        SeriesBeanCount seriesBeanCount1 = new SeriesBeanCount();
        seriesBeanCount1.setName("IM点击量");
        List<String> datas1 = new ArrayList<>();
        for (String c : l)
            if (actionDayImEntityMap.get(c) != null && actionDayImEntityMap.get(c).getChatuv() != null)
                datas1.add(actionDayImEntityMap.get(c).getChatuv().toString());
            else datas1.add("0");
        seriesBeanCount1.setData(datas1);
        seriesBeanCounts.add(seriesBeanCount1);

        SeriesBeanCount seriesBeanCount2 = new SeriesBeanCount();
        seriesBeanCount2.setName("访问量");
        List<String> datas2 = new ArrayList<>();
        for (String c : l)
            if (actionDayImEntityMap.get(c) != null && actionDayImEntityMap.get(c) != null)
                datas2.add(actionDayImEntityMap.get(c).getExploreuv().toString());
            else datas2.add("0");
        seriesBeanCount2.setData(datas2);
        seriesBeanCounts.add(seriesBeanCount2);

//        SeriesBeanCount seriesBeanCount3 = new SeriesBeanCount();
//        seriesBeanCount3.setName("详情页");
//        List<String> datas3 = new ArrayList<>();
//        for (String c : actiondaysAll)
//            if (actionDayImEntityMap.get(c) != null && actionDayImEntityMap.get(c).getDetailPageUv() != null)
//                datas3.add(actionDayImEntityMap.get(c).getDetailPageUv().toString());
//            else datas3.add("0");
//        seriesBeanCount3.setData(datas3);
//        seriesBeanCounts.add(seriesBeanCount3);
//
//        SeriesBeanCount seriesBeanCount4 = new SeriesBeanCount();
//        seriesBeanCount4.setName("im点击人数");
//        List<String> datas4 = new ArrayList<>();
//        for (String c : actiondaysAll)
//            if (actionDayImEntityMap.get(c) != null && actionDayImEntityMap.get(c).getImCount() != null)
//                datas4.add(actionDayImEntityMap.get(c).getImCount().toString());
//            else datas4.add("0");
//        seriesBeanCount4.setData(datas4);
//        seriesBeanCounts.add(seriesBeanCount4);
//
//        SeriesBeanCount seriesBeanCount5 = new SeriesBeanCount();
//        seriesBeanCount5.setName("会话总数");
//        List<String> datas5 = new ArrayList<>();
//        for (String c : actiondaysAll)
//            if (actionDayImEntityMap.get(c) != null && actionDayImEntityMap.get(c).getSessionCount() != null)
//                datas5.add(actionDayImEntityMap.get(c).getSessionCount().toString());
//            else datas5.add("0");
//        seriesBeanCount5.setData(datas5);
//        seriesBeanCounts.add(seriesBeanCount5);
//
//        SeriesBeanCount seriesBeanCount6 = new SeriesBeanCount();
//        seriesBeanCount6.setName("有反馈会话数");
//        List<String> datas6 = new ArrayList<>();
//        for (String c : actiondaysAll)
//            if (actionDayImEntityMap.get(c) != null && actionDayImEntityMap.get(c).getValidSessionCount() != null)
//                datas6.add(actionDayImEntityMap.get(c).getValidSessionCount().toString());
//            else datas6.add("0");
//        seriesBeanCount6.setData(datas6);
//        seriesBeanCounts.add(seriesBeanCount6);
//
//        SeriesBeanCount seriesBeanCount7 = new SeriesBeanCount();
//        seriesBeanCount7.setName("无反馈会话数");
//        List<String> datas7 = new ArrayList<>();
//        for (String c : actiondaysAll)
//            if (actionDayImEntityMap.get(c) != null && actionDayImEntityMap.get(c).getInvalidSessionCount() != null)
//                datas7.add(actionDayImEntityMap.get(c).getInvalidSessionCount().toString());
//            else datas7.add("0");
//        seriesBeanCount7.setData(datas7);
//        seriesBeanCounts.add(seriesBeanCount7);
        SeriesBeanCount seriesBeanCount8 = new SeriesBeanCount();
        seriesBeanCount8.setName("转化率");
        seriesBeanCount8.setType("line");
        List<String> datas8 = new ArrayList<>();
//        for (String c : citys){
        for (String c : l) {
            //im
            if (actionDayImEntityMap.get(c) != null && actionDayImEntityMap.get(c).getPercent() != null)
                datas8.add(actionDayImEntityMap.get(c).getPercent());
            else datas8.add("0.00");
//            else im = datas4.add("0");

//            //详情
//            Integer xq = 0;
//            if (actionDayImEntityMap.get(c) != null && actionDayImEntityMap.get(c).getDetailPageUv() != null)
//                xq = actionDayImEntityMap.get(c).getDetailPageUv();
//
//            if (xq == 0)
//                datas8.add("0");
//            else
//                datas8.add(new BigDecimal(im).multiply(new BigDecimal("100")).divide(new BigDecimal(xq), 2, RoundingMode.HALF_UP).toString());
//            else datas3.add("0");
        }
//            if (cityImEntityMap.get(c) != null && cityImEntityMap.get(c).getInvalidSessionCount() != null)
//                datas8.add(cityImEntityMap.get(c).getInvalidSessionCount().toString());
//            else datas8.add("0");
        seriesBeanCount8.setData(datas8);
        seriesBeanCount8.setyAxisIndex(1);
        seriesBeanCounts.add(seriesBeanCount8);
        imStaticsRetBeanCount.setSeries(seriesBeanCounts);
        imStaticsRetBeanCount.setX(l);
        return imStaticsRetBeanCount;
    }

    @Override
    public ImEntity getOneImEntity(String actionday) {
        String[] actiondays = actionday.split(",", -1);
        return imStaticsMapper.getOneImEntity(actiondays[0], actiondays[1]);
    }


    @Autowired
    ImStaticsProjnameMapper imStaticsProjnameMapper;

    @Override
    public ImStaticsRetBean getAPPNewHouseUV(String actionday){
        String[] actiondays = actionday.split(",", -1);
        List<ProjnameImEntity> top10UvCountByProjName = imStaticsProjnameMapper.getTop10UvCountByProjName(actiondays[0], actiondays[1]);
        ImStaticsRetBean imStaticsRetBean = new ImStaticsRetBean();
        List<String> l = new ArrayList<>();
        ArrayList<SeriesBean> seriesBean = new ArrayList<>();

        SeriesBean seriesBean1 = new SeriesBean();
        seriesBean1.setName("'聊天数'");
        seriesBean1.setType("bar");
        ArrayList<String> data = new ArrayList<>();

        seriesBean.add(seriesBean1);

        for (ProjnameImEntity pi:
        top10UvCountByProjName)
        {
            l.add(pi.getProjname());
            data.add(pi.getImchats()+"");
        }
        imStaticsRetBean.setX(l);
        seriesBean1.setData(data);

        imStaticsRetBean.setSeries(seriesBean);

        return imStaticsRetBean;
    }

    @Override
    public List<ProjnameImEntity> getTop10UvCountByProjName(String actionday){
        String[] actiondays = actionday.split(",", -1);
        return imStaticsProjnameMapper.getTop10UvCountByProjName(actiondays[0], actiondays[1]);
    }

    @Override
    public List<ImStaticsPageuvChat> getImStaticsPageuvChatByProducttype(String actionDay, String producttype) {
        return imStaticsMapper.getImStaticsPageuvChatByProducttype(actionDay, producttype);
    }


    @Override
    public ImStaticsRetBeanCount getLoupanAvgUv(String actionday, String city) {
        String[] actiondays = actionday.split(",", -1);
        List<String> citys = Arrays.asList(city.split(",", -1));
        ImStaticsRetBeanCount imStaticsRetBeanCount = new ImStaticsRetBeanCount();

        List<String> lineList = new ArrayList<>();
        lineList.add("聊天量");
        lineList.add("全国平均聊天量");
        imStaticsRetBeanCount.setLine(lineList);

        List<String> xList = Arrays.asList(city.split(",", -1));
        imStaticsRetBeanCount.setX(xList);

        Double avgCount = imStaticsProjnameMapper.getAvgShopidUv(actiondays[0], actiondays[1]);
        List<ImShopUv> shopidUvCity = imStaticsProjnameMapper.getAvgShopidUvByCity(actiondays[0], actiondays[1], citys);
        List<SeriesBeanCount> seriesList = new ArrayList<>();
        SeriesBeanCount seriesBeanCount1 = new SeriesBeanCount();
        seriesBeanCount1.setName("聊天量");
        List<String> dataList1 = new ArrayList<>();
        for (ImShopUv imShopUv:
        shopidUvCity)
        {
            dataList1.add(imShopUv.getUvcount());
        }
        seriesBeanCount1.setData(dataList1);

        SeriesBeanCount seriesBeanCount2 = new SeriesBeanCount();
        seriesBeanCount2.setName("全国平均聊天量");
        seriesBeanCount2.setType("line");
        List<String> dataList2 = new ArrayList<>();
        for (ImShopUv imShopUv:
        shopidUvCity)
        {
            dataList2.add(avgCount + "");
        }
        seriesBeanCount2.setData(dataList2);

        seriesList.add(seriesBeanCount1);
        seriesList.add(seriesBeanCount2);
        imStaticsRetBeanCount.setSeries(seriesList);

        return imStaticsRetBeanCount;
    }

    @Override
    public ImStaticsRetBeanCount getLoupanAvgUvBycity(String actionday, String city) {
        String[] actiondays = actionday.split(",", -1);
        ImStaticsRetBeanCount imStaticsRetBeanCount = new ImStaticsRetBeanCount();
        List<String> lineList = new ArrayList<>();
        lineList.add("聊天量");
        lineList.add("平均聊天量");
        imStaticsRetBeanCount.setLine(lineList);

        Double avgLoupanUv = imStaticsProjnameMapper.getAvgLoupanUv(actiondays[0], actiondays[1],city);
        List<ImShopUv> loupanUvByCity = imStaticsProjnameMapper.getAvgLoupanUvByCity(actiondays[0], actiondays[1], city);

        List<String> xList = new ArrayList<>();
        List<SeriesBeanCount> seriesList = new ArrayList<>();
        SeriesBeanCount seriesBeanCount1 = new SeriesBeanCount();
        SeriesBeanCount seriesBeanCount2 = new SeriesBeanCount();
        seriesBeanCount1.setName("聊天量");
        seriesBeanCount2.setName("平均聊天量");
        seriesBeanCount2.setType("line");
        List<String> dataList1 = new ArrayList<>();
        List<String> dataList2 = new ArrayList<>();

        for (ImShopUv imShopUv:
        loupanUvByCity)
        {
            xList.add(imShopUv.getShopid());
            dataList1.add(imShopUv.getUvcount());
            dataList2.add(avgLoupanUv+"");
        }
        seriesBeanCount1.setData(dataList1);
        seriesBeanCount2.setData(dataList2);

        seriesList.add(seriesBeanCount1);
        seriesList.add(seriesBeanCount2);

        imStaticsRetBeanCount.setX(xList);
        imStaticsRetBeanCount.setSeries(seriesList);

        return imStaticsRetBeanCount;
    }
}
