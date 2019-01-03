package com.fang.bigdata.metadata.daoimpala;

import com.fang.bigdata.metadata.entity.imstatics.ProjnameImEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ImStaticsProjnameMapper {

    /**
     * 计算某段时间uv量楼盘排行 top10
     * @return
     */
    List<ProjnameImEntity> getTop10UvCountByProjName(@Param("startDay") String startDay, @Param("endDay") String endDay);
}
