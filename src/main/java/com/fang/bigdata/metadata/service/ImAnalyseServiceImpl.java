package com.fang.bigdata.metadata.service;

import com.fang.bigdata.metadata.daoimpala.ImAnalyseMapper;
import com.fang.bigdata.metadata.entity.imstatics.ImAnalyse;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @project:metadata
 * @packname:com.fang.bigdata.metadata.service
 * @name: ImAnalyseServiceImpl
 * @describe:
 * @author: niujiaxin
 * @create: 2019-01-02-14:48
 */
@Service("ImAnalyseService")
public class ImAnalyseServiceImpl implements ImAnalyseService {
    @Resource
    private ImAnalyseMapper imAnalyseMapper;

    @Override
    public List<ImAnalyse> queryPages(String startTime, String endTime, String city, String pagetype, String producttype, Integer pageNum, Integer pageSize) {
        Integer rows = 0;
        if(pageNum==0){
            rows=pageNum*pageSize;
        }else if(pageNum>=1){
            rows=(pageNum-1)*pageSize;
        }
        return imAnalyseMapper.queryPages(startTime, endTime, city, pagetype, producttype, rows, pageSize);
    }

    @Override
    public Integer queryCount(String startTime, String endTime, String city, String pagetype, String producttype) {
        return imAnalyseMapper.queryCount(startTime, endTime, city, pagetype, producttype);
    }

    @Override
    public ImAnalyse selectByMessageidActionday(String mid, String actionday) {
        return imAnalyseMapper.selectByMessageidActionday(mid, actionday);
    }

}
