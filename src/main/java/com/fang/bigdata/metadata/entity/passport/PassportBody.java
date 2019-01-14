package com.fang.bigdata.metadata.entity.passport;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @project:imWebReport
 * @packname:com.fang.bigdata.metadata.entity.passport
 * @name: PassportBody
 * @describe:
 * @author: niujiaxin
 * @create: 2019-01-09-10:04
 */
@Getter
@Setter
public class PassportBody {
    private String status;
    private String message;
    private List<BaseInfo> baseInfoList;
}
