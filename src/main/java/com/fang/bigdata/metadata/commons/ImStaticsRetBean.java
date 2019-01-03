package com.fang.bigdata.metadata.commons;

import java.util.ArrayList;
import java.util.List;

public class ImStaticsRetBean {
    List<String> line;
    List<String> X;
    List<SeriesBean> series;

    public List<String> getLine() {
        if (this.line != null)
            return line;
        line = new ArrayList<String>();
        line.add("首页->列表");
        line.add("列表->详情");
        line.add("详情->IM");
        line.add("会话->有反馈会话");
        line.add("会话->无反馈");
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

    public List<SeriesBean> getSeries() {
        return series;
    }

    public void setSeries(List<SeriesBean> series) {
        this.series = series;
    }
}
