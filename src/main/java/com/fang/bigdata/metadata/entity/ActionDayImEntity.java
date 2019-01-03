package com.fang.bigdata.metadata.entity;
/**

* @Description:    某一城市中某一业务，以时间为维度的Im指标实体

* @Author:         linan

* @CreateDate:     2018/12/17 15:26

* @UpdateUser:     linan

* @UpdateDate:     2018/12/17 15:26

* @UpdateRemark:   修改内容

* @Version:        1.0

*/
public class ActionDayImEntity {
    private String actionDay;
    private Integer indexPageUv; // 房app首页uv
    private Integer listPageUv; // 房app列表页uv
    private Integer detailPageUv; // 房app详情页uv
    private Integer imCount; // im聊天数
    private Integer sessionCount; // 会话总数
    private Integer validSessionCount; // 有效会话数
    private Integer invalidSessionCount; // 无效会话数

    public ActionDayImEntity() {
    }

    public ActionDayImEntity(String actionDay, Integer indexPageUv, Integer listPageUv, Integer detailPageUv, Integer imCount, Integer sessionCount, Integer validSessionCount, Integer invalidSessionCount) {
        this.actionDay = actionDay;
        this.indexPageUv = indexPageUv;
        this.listPageUv = listPageUv;
        this.detailPageUv = detailPageUv;
        this.imCount = imCount;
        this.sessionCount = sessionCount;
        this.validSessionCount = validSessionCount;
        this.invalidSessionCount = invalidSessionCount;
    }

    public String getActionDay() {
        return actionDay;
    }

    public void setActionDay(String actionDay) {
        this.actionDay = actionDay;
    }

    public Integer getIndexPageUv() {
        return indexPageUv;
    }

    public void setIndexPageUv(Integer indexPageUv) {
        this.indexPageUv = indexPageUv;
    }

    public Integer getListPageUv() {
        return listPageUv;
    }

    public void setListPageUv(Integer listPageUv) {
        this.listPageUv = listPageUv;
    }

    public Integer getDetailPageUv() {
        return detailPageUv;
    }

    public void setDetailPageUv(Integer detailPageUv) {
        this.detailPageUv = detailPageUv;
    }

    public Integer getImCount() {
        return imCount;
    }

    public void setImCount(Integer imCount) {
        this.imCount = imCount;
    }

    public Integer getSessionCount() {
        return sessionCount;
    }

    public void setSessionCount(Integer sessionCount) {
        this.sessionCount = sessionCount;
    }

    public Integer getValidSessionCount() {
        return validSessionCount;
    }

    public void setValidSessionCount(Integer validSessionCount) {
        this.validSessionCount = validSessionCount;
    }

    public Integer getInvalidSessionCount() {
        return invalidSessionCount;
    }

    public void setInvalidSessionCount(Integer invalidSessionCount) {
        this.invalidSessionCount = invalidSessionCount;
    }
}
