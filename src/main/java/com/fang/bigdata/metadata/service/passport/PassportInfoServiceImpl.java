package com.fang.bigdata.metadata.service.passport;

import com.fang.bigdata.metadata.daoimpala.PassportInfoMapper;
import com.fang.bigdata.metadata.entity.passport.BaseInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @project:imWebReport
 * @packname:com.fang.bigdata.metadata.service.passport
 * @name: PassportInfoServiceImpl
 * @describe:
 * @author: niujiaxin
 * @create: 2019-01-09-16:42
 */
@Service("PassportInfoService")
public class PassportInfoServiceImpl implements PassportInfoService{
    @Autowired
    private PassportInfoMapper passportInfoMapper;


    @Override
    public List<BaseInfo> queryBypassortid(String passportid, Integer limitnum) {
        return passportInfoMapper.queryBypassortid(passportid, limitnum);
    }
}
