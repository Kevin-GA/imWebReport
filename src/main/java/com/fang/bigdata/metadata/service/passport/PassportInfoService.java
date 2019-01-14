package com.fang.bigdata.metadata.service.passport;

import com.fang.bigdata.metadata.entity.passport.BaseInfo;

import java.util.List;

/**
 * @project:imWebReport
 * @author: niujiaxin
 * @create: 2019-01-09-16:41
 */
public interface PassportInfoService {
    List<BaseInfo> queryBypassortid(String passportid, Integer limitnum);
}
