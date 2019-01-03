package com.fang.bigdata.metadata.commons;

import java.util.ArrayList;
import java.util.List;

public class ImStaticsRetBeanCount {
    List<String> line;
    List<String> X;
    List<SeriesBeanCount> series;

    public List<String> getLine() {
        if (this.line != null)
            return line;
        line = new ArrayList<String>();
        line.add("首页");
        line.add("列表页");
        line.add("详情页");
        line.add("im点击人数");
        line.add("会话总数");
        line.add("有反馈会话数");
        line.add("无反馈会话数");
        line.add("IM点击转化率");
        return line;

    }

    public void setLine(List<String> line) {
        this.line = line;
    }

    public List<String> getX() {
        return X;
    }

    public void setX(List<String> x) {
        X = x;
    }

    public List<SeriesBeanCount> getSeries() {
        return series;
    }

    public void setSeries(List<SeriesBeanCount> series) {
        this.series = series;
    }
}
