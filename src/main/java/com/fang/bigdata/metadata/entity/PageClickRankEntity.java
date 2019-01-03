package com.fang.bigdata.metadata.entity;
/**

* @Description:    页面位置点击量排名实体

* @Author:         linan

* @CreateDate:     2018/12/19 19:30

* @UpdateUser:     linan

* @UpdateDate:     2018/12/19 19:30

* @UpdateRemark:   修改内容

* @Version:        1.0

*/
public class PageClickRankEntity extends PercentRankBaseEntity {

    String pageName; // 页面名称
    Integer chatuv;
    Integer exploreuv;

    public String getPageName() {
        return pageName;
    }

    public void setPageName(String pageName) {
        this.pageName = pageName;
    }

    public Integer getChatuv() {
        return chatuv;
    }

    public void setChatuv(Integer chatuv) {
        this.chatuv = chatuv;
    }

    public Integer getExploreuv() {
        return exploreuv;
    }

    public void setExploreuv(Integer exploreuv) {
        this.exploreuv = exploreuv;
    }
}
