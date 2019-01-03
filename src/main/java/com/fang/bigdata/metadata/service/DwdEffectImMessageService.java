package com.fang.bigdata.metadata.service;

import com.fang.bigdata.metadata.entity.DwdEffectImMessage;
import com.fang.bigdata.metadata.entity.DwdEffectImPersonim;

import java.util.List;

/**
 * @project:metadata
 * @author: niujiaxin
 * @create: 2018-12-14-19:26
 */
public interface DwdEffectImMessageService {

    DwdEffectImMessage queryByImChatMessageMessageid (String imChatMessageMessageid, String logday);

    List<DwdEffectImMessage> queryPages(String startTime, String endTime, String city,String qx,String sq,String passportid, String imChatMessageType, Integer pageNum, Integer pageSize,String imChatMessageShopid);

    int queryPagesCount(String startTime, String endTime,String city,String qx,String sq,String passportid,String imChatMessageType,String imChatMessageShopid);

    List<String> uvInBestHour(String actionday,String city);

    List<String> uvInBestWeek(String actionday,String city);
}
