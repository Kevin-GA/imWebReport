package com.fang.bigdata.metadata.controller;

import com.fang.bigdata.metadata.entity.passport.BaseInfo;
import com.fang.bigdata.metadata.entity.passport.PassportBody;
import com.fang.bigdata.metadata.service.passport.PassportInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @project:imWebReport
 * @packname:com.fang.bigdata.metadata.controller
 * @name: PassportController
 * @describe:
 * @author: niujiaxin
 * @create: 2019-01-09-16:46
 */
@RequestMapping("/passport")
@Controller
public class PassportController {
    @Autowired
    private PassportInfoService passportInfoService;

    @RequestMapping("/main")
    @ResponseBody
    PassportBody getMain(String passportid, Integer limitnum){
        PassportBody passportBody = new PassportBody();
        List<BaseInfo> baseInfos = passportInfoService.queryBypassortid(passportid, limitnum);
        if(baseInfos.size()>0&&baseInfos!=null){
            passportBody.setBaseInfoList(baseInfos);
            passportBody.setStatus("1");
            passportBody.setMessage("查询成功");
        }else{
            passportBody.setStatus("0");
            passportBody.setMessage("查询错误");
        }
        return passportBody;
    }

}
