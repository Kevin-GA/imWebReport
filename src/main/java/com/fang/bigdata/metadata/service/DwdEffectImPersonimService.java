package com.fang.bigdata.metadata.service;

import com.fang.bigdata.metadata.entity.DwdEffectImPersonim;
import com.fang.bigdata.metadata.entity.ImCity;

import java.util.List;

/**
 * @project:metadata
 * @author: niujiaxin
 * @create: 2018-12-12-20:06
 */
public interface DwdEffectImPersonimService {

    DwdEffectImPersonim queryByImChatMessageMessageid (String imChatMessageMessageid, String logday);

    List<DwdEffectImPersonim> queryByCity(String city);

    List<DwdEffectImPersonim> queryPages(String startTime, String endTime,String city,String imChatMessageType,Integer pageNum,Integer pageSize);

    int queryPagesCount(String startTime, String endTime,String city,String imChatMessageType);
}
