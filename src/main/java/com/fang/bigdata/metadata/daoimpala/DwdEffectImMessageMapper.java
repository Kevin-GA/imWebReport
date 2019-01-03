package com.fang.bigdata.metadata.daoimpala;


import com.fang.bigdata.metadata.entity.DwdEffectImMessage;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface DwdEffectImMessageMapper {
    int insert(DwdEffectImMessage record);

    int insertSelective(DwdEffectImMessage record);

    DwdEffectImMessage queryByImChatMessageMessageid (@Param("imChatMessageMessageid")String imChatMessageMessageid, @Param("logday")String logday);

    List<DwdEffectImMessage> queryPage(@Param("startTime")String startTime, @Param("endTime") String endTime, @Param("city")String city,@Param("qx")String qx,@Param("sq")String sq,@Param("passportid")String passportid, @Param("imChatMessageType")String imChatMessageType, @Param("rows")Integer rows, @Param("pageSize")Integer pageSize,@Param("imChatMessageShopid")String imChatMessageShopid);

    Integer queryCounts(@Param("startTime")String startTime, @Param("endTime") String endTime, @Param("city")String city, @Param("qx")String qx,@Param("sq")String sq,@Param("passportid")String passportid,@Param("imChatMessageType")String imChatMessageType,@Param("imChatMessageShopid")String imChatMessageShopid);

    List<String> uvInBestHour(@Param("startTime")String startTime, @Param("endTime") String endTime,@Param("city")String city);

    List<String> uvInBestWeek(@Param("startTime")String startTime, @Param("endTime") String endTime,@Param("city")String city);
}