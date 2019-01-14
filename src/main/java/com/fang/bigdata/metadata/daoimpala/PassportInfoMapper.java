package com.fang.bigdata.metadata.daoimpala;

import com.fang.bigdata.metadata.entity.passport.BaseInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @project:imWebReport
 * @author: niujiaxin
 * @create: 2019-01-09-16:12
 */
public interface PassportInfoMapper {
    List<BaseInfo> queryBypassortid(@Param("passportid")String passportid, @Param("limitnum")Integer limitnum);
}
