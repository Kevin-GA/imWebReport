package com.fang.bigdata.metadata.daoimpala;


import com.fang.bigdata.metadata.entity.DwdEffectImPersonim;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DwdEffectImPersonimMapper {
    int insert(DwdEffectImPersonim record);

    int insertSelective(DwdEffectImPersonim record);

    DwdEffectImPersonim queryByImChatMessageMessageid (@Param("imChatMessageMessageid")String imChatMessageMessageid,@Param("logday")String logday);

    List<DwdEffectImPersonim> queryByCity(String city);

    List<DwdEffectImPersonim> queryPage(@Param("startTime")String startTime,@Param("endTime") String endTime,@Param("city")String city,@Param("imChatMessageType")String imChatMessageType,@Param("rows")Integer rows,@Param("pageSize")Integer pageSize);

    Integer queryPageCount(@Param("startTime")String startTime,@Param("endTime") String endTime,@Param("city")String city,@Param("imChatMessageType")String imChatMessageType);
}