package com.fang.bigdata.metadata.entity.imstatics;

import lombok.Getter;
import lombok.Setter;

/**
 * @project:imWebReport
 * @packname:com.fang.bigdata.metadata.entity.imstatics
 * @name: ImShopUv
 * @describe: 城市平均聊天数
 * @author: niujiaxin
 * @create: 2019-01-05-16:32
 */
@Setter
@Getter
public class ImShopUv {
    private String city;
    private String shopid;
    private String uvcount;
    private String logday;

}
