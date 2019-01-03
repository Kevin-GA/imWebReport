package com.fang.bigdata.metadata.service;

import com.fang.bigdata.metadata.daoimpala.DwdEffectImMessageMapper;
import com.fang.bigdata.metadata.entity.DwdEffectImMessage;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @project:metadata
 * @packname:com.fang.bigdata.metadata.service
 * @name: DwdEffectImMessageServiceImpl
 * @describe:
 * @author: niujiaxin
 * @create: 2018-12-14-19:27
 */
@Service("DwdEffectImMessageService")
public class DwdEffectImMessageServiceImpl implements DwdEffectImMessageService{
    @Resource
    private DwdEffectImMessageMapper dwdEffectImMessageMapper;

    /**
     *
     * @param imChatMessageMessageid
     * @param logday
     * @return
     */
    @Override
    public DwdEffectImMessage queryByImChatMessageMessageid(String imChatMessageMessageid, String logday) {
        DwdEffectImMessage dwdEffectImMessage = dwdEffectImMessageMapper.queryByImChatMessageMessageid(imChatMessageMessageid, logday);
        return hideUserInfo(dwdEffectImMessage);
    }

    /**
     *DwdEffectImMessage分页查询
     * @param startTime
     * @param endTime
     * @param city
     * @param imChatMessageType
     * @param pageNum
     * @param pageSize
     * @param imChatMessageShopid
     * @return
     */
    @Override
    public List<DwdEffectImMessage> queryPages(String startTime, String endTime, String city,String qx,String sq,String passportid, String imChatMessageType, Integer pageNum, Integer pageSize,String imChatMessageShopid) {
        Integer rows = 0;
        if(pageNum==0){
            rows=pageNum*pageSize;
        }else if(pageNum>=1){
            rows=(pageNum-1)*pageSize;
        }
        List<DwdEffectImMessage> pageList = dwdEffectImMessageMapper.queryPage(startTime, endTime, city, qx, sq,passportid, imChatMessageType, rows, pageSize, imChatMessageShopid);
        List<DwdEffectImMessage> afterReplacePageList = new ArrayList<>();
        for (DwdEffectImMessage dwdEffectImMessage:
        pageList)
        {
            afterReplacePageList.add(hideUserInfo(dwdEffectImMessage));
        }
        return afterReplacePageList;
    }

    /**
     * 姓名名替换成***
     * @param dwdEffectImMessage
     * @return
     */
    DwdEffectImMessage hideUserInfo(DwdEffectImMessage dwdEffectImMessage){
        String formFromuser = dwdEffectImMessage.getFormFromuser();
        formFromuser = hideStrInfo(formFromuser);
        if(formFromuser!=null){
            dwdEffectImMessage.setFormFromuser(formFromuser);
        }


        String sendtoSendtouser = dwdEffectImMessage.getSendtoSendtouser();
        sendtoSendtouser = hideStrInfo(sendtoSendtouser);
        if(sendtoSendtouser!=null){
            dwdEffectImMessage.setSendtoSendtouser(sendtoSendtouser);
        }


        String oatoOaLastname = dwdEffectImMessage.getOatoOaLastname();
        oatoOaLastname = hideStrInfo(oatoOaLastname);
        if(oatoOaLastname!=null){
            dwdEffectImMessage.setOatoOaLastname(oatoOaLastname);
        }


        String oafromOaLastname = dwdEffectImMessage.getOafromOaLastname();
        oafromOaLastname =hideStrInfo(oafromOaLastname);
        if(oafromOaLastname!=null){
            dwdEffectImMessage.setOafromOaLastname(oafromOaLastname);
        }


        String oafromOaManager = dwdEffectImMessage.getOafromOaManager();
        oafromOaManager = hideStrInfo(oafromOaLastname);
        if(oafromOaManager!=null){
            dwdEffectImMessage.setOafromOaManager(oafromOaManager);
        }


        String oatoOaManager = dwdEffectImMessage.getOatoOaManager();
        oatoOaManager = hideStrInfo(oatoOaManager);
        if(oatoOaManager!=null){
            dwdEffectImMessage.setOatoOaManager(oatoOaManager);
        }

        return dwdEffectImMessage;
    }
    /**
     * 字符隐藏替换为***，保护信息
     * @param repalceStr
     * @return
     */
    String hideStrInfo(String repalceStr) {
        if(repalceStr==null){
            return null;
        }
        else if (repalceStr.length() == 2)
        {
            return repalceStr.substring(0, 1) + "*";
        } else if (repalceStr.length() == 3)
        {
            return repalceStr.substring(0, 1) + "*" + repalceStr.substring(2, 3);
        } else if (repalceStr.length() > 3)
        {
            return repalceStr.substring(0, 1) + "***" + repalceStr.substring(repalceStr.length() - 1, repalceStr.length());
        } else
            return repalceStr;
    }

    @Override
    public int queryPagesCount(String startTime, String endTime, String city,String qx,String sq,String passportid, String imChatMessageType,String imChatMessageShopid) {
        return dwdEffectImMessageMapper.queryCounts(startTime, endTime, city, qx, sq,passportid, imChatMessageType, imChatMessageShopid);
    }

    @Override
    public List<String> uvInBestHour(String actionday, String city) {
        String[] actiondays = actionday.split(",", -1);
        return dwdEffectImMessageMapper.uvInBestHour(actiondays[0], actiondays[1], city);
    }

    @Override
    public List<String> uvInBestWeek(String actionday, String city) {
        String[] actiondays = actionday.split(",", -1);
        return dwdEffectImMessageMapper.uvInBestWeek(actiondays[0], actiondays[1], city);
    }
}
