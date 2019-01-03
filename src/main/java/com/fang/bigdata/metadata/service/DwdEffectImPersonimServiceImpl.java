package com.fang.bigdata.metadata.service;

import com.fang.bigdata.metadata.daoimpala.DwdEffectImPersonimMapper;
import com.fang.bigdata.metadata.entity.DwdEffectImPersonim;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @project:metadata
 * @packname:com.fang.bigdata.metadata.service
 * @name: DwdEffectImPersonimServiceImpl
 * @describe:
 * @author: niujiaxin
 * @create: 2018-12-12-20:08
 */
@Service("DwdEffectImPersonimService")
public class DwdEffectImPersonimServiceImpl implements DwdEffectImPersonimService{
    @Resource
    private DwdEffectImPersonimMapper dwdEffectImPersonimMapper;

    @Override
    public DwdEffectImPersonim queryByImChatMessageMessageid(String imChatMessageMessageid, String logday) {
        DwdEffectImPersonim dwdEffectImPersonim = dwdEffectImPersonimMapper.queryByImChatMessageMessageid(imChatMessageMessageid,logday);
        return dwdEffectImPersonim;
    }

    @Override
    public List<DwdEffectImPersonim> queryByCity(String city) {
        return dwdEffectImPersonimMapper.queryByCity(city);
    }

    @Override
    public List<DwdEffectImPersonim> queryPages(String startTime, String endTime, String city, String imChatMessageType, Integer pageNum, Integer pageSize) {
        Integer rows = 0;
        if(pageNum==0){
            rows=pageNum*pageSize;
        }else if(pageNum>=1){
            rows=(pageNum-1)*pageSize;
        }
        return dwdEffectImPersonimMapper.queryPage(startTime,endTime,city,imChatMessageType,rows,pageSize);
    }

    @Override
    public int queryPagesCount(String startTime, String endTime, String city, String imChatMessageType) {
        return dwdEffectImPersonimMapper.queryPageCount(startTime,endTime,city,imChatMessageType);
    }
}
