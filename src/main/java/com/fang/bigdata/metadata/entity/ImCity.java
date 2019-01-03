package com.fang.bigdata.metadata.entity;

import lombok.*;

@Data
@Getter
@Setter
public class ImCity {
    private Integer id;
//城市名
    private String name;
//区县
    private String qx;
//商圈
    private String sq;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}