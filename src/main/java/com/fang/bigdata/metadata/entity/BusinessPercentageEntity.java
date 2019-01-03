package com.fang.bigdata.metadata.entity;

public class BusinessPercentageEntity {
    private String business; // 业务
    private String listIndexRatio; // 首页到列表的uv转化率
    private String detailListRatio; // 列表到详情页的uv转化率
    private String detailImRatio; // 详情到IM的uv转化率
    private String validSessionRatio; // 有效会话转化率
    private String invalidSessionRatio; // 无效会话转化率

    public BusinessPercentageEntity() {
    }

    public BusinessPercentageEntity(String business, String listIndexRatio, String detailListRatio, String detailImRatio, String validSessionRatio, String invalidSessionRatio) {
        this.business = business;
        this.listIndexRatio = listIndexRatio;
        this.detailListRatio = detailListRatio;
        this.detailImRatio = detailImRatio;
        this.validSessionRatio = validSessionRatio;
        this.invalidSessionRatio = invalidSessionRatio;
    }

    public String getBusiness() {
        return business;
    }

    public void setBusiness(String business) {
        this.business = business;
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
