package com.fang.bigdata.metadata.entity;

public class CityPercentageEntity {
    private String city; // 城市
    private String listIndexRatio; // 首页到列表的uv转化率
    private String detailListRatio; // 列表到详情页的uv转化率
    private String detailImRatio; // 详情到IM的uv转化率
    private String validSessionRatio; // 有效会话转化率
    private String invalidSessionRatio; // 无效会话转化率

    public CityPercentageEntity() {

    }

    public CityPercentageEntity(String city, String listIndexRatio, String detailListRatio, String detailImRatio, String validSessionRatio, String invalidSessionRatio) {
        this.city = city;
        this.listIndexRatio = listIndexRatio;
        this.detailListRatio = detailListRatio;
        this.detailImRatio = detailImRatio;
        this.validSessionRatio = validSessionRatio;
        this.invalidSessionRatio = invalidSessionRatio;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getListIndexRatio() {
        return listIndexRatio;
    }

    public void setListIndexRatio(String listIndexRatio) {
        this.listIndexRatio = listIndexRatio;
    }

    public String getDetailListRatio() {
        return detailListRatio;
    }

    public void setDetailListRatio(String detailListRatio) {
        this.detailListRatio = detailListRatio;
    }

    public String getDetailImRatio() {
        return detailImRatio;
    }

    public void setDetailImRatio(String detailImRatio) {
        this.detailImRatio = detailImRatio;
    }

    public String getValidSessionRatio() {
        return validSessionRatio;
    }

    public void setValidSessionRatio(String validSessionRatio) {
        this.validSessionRatio = validSessionRatio;
    }

    public String getInvalidSessionRatio() {
        return invalidSessionRatio;
    }

    public void setInvalidSessionRatio(String invalidSessionRatio) {
        this.invalidSessionRatio = invalidSessionRatio;
    }
}
