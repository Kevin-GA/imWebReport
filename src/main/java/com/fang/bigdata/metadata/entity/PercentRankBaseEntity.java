package com.fang.bigdata.metadata.entity;
/**

* @Description:    转化率排名基础实体

* @Author:         linan

* @CreateDate:     2018/12/19 17:18

* @UpdateUser:     linan

* @UpdateDate:     2018/12/19 17:18

* @UpdateRemark:   修改内容

* @Version:        1.0

*/
public class PercentRankBaseEntity {
    String name;
    String percent; // 转化率
    Integer rank; // 排名

    public PercentRankBaseEntity() {
    }

    public PercentRankBaseEntity(String name, String percent, Integer rank) {
        this.name = name;
        this.percent = percent;
        this.rank = rank;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPercent() {
        return percent;
    }

    public void setPercent(String percent) {
        this.percent = percent;
    }

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }
}
