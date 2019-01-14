package com.fang.bigdata.metadata.entity.passport;

import lombok.*;

/**
 * @project:imWebReport
 * @packname:com.fang.bigdata.metadata.entity.passport
 * @name: BaseInfo
 * @describe:
 * @author: niujiaxin
 * @create: 2019-01-09-10:05
 */
@Getter
@Setter
@ToString
public class BaseInfo {
    private FormInfo formInfo;
    private SendtoInfo sendtoInfo;
    private MessageInfo messageInfo;
}
