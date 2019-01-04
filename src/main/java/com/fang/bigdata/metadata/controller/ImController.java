package com.fang.bigdata.metadata.controller;

import com.fang.bigdata.metadata.entity.DwdEffectImMessage;
import com.fang.bigdata.metadata.entity.ImCity;
import com.fang.bigdata.metadata.entity.imstatics.ImAnalyse;
import com.fang.bigdata.metadata.service.*;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.util.SystemOutLogger;
import org.springframework.boot.SpringApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import sun.security.tools.keytool.Main;

import javax.annotation.Resource;
import java.util.*;

/**
 * @project:metadata
 * @packname:com.fang.bigdata.metadata.controller
 * @name: ImController
 * @describe:
 * @author: niujiaxin
 * @create: 2019-01-02-14:53
 */
@Controller
@Slf4j
public class ImController {
    @Resource
    private DwdEffectImPersonimService dwdEffectImPersonimService;
    @Resource
    private DwdEffectImMessageService dwdEffectImMessageService;


    @RequestMapping(value = "/im-more/{imid}/{logday}",method = RequestMethod.GET)
    String getByODSId(@PathVariable("imid") String imid,@PathVariable("logday") String logday,Model model){
        DwdEffectImMessage dwdEffectImMessage = dwdEffectImMessageService.queryByImChatMessageMessageid(imid, logday);
        //转义城市
        String city = getCityFromDwdEffectImPersonim(dwdEffectImMessage);
        //转义所属业务
        String business = getYWFromDwdEffectImPersonim(dwdEffectImMessage.getImChatMessageType().toLowerCase());
        //sendtoPre  or formPre 发送人所属业务/接收方用户类型 转义
        String sendtoPre = getSendtoPreOrFormPre(dwdEffectImMessage.getSendtoPre().toLowerCase());
        String formPre = getSendtoPreOrFormPre(dwdEffectImMessage.getFormPre().toLowerCase());
        //转义发送人客户端
        String clienttype = getClienttype(dwdEffectImMessage.getImChatMessageClienttype().toLowerCase());
        //fromuserBidGroup sendtouserBidGroup 处理所属集团
        if(dwdEffectImMessage.getFromuserBidGroup()!=null&&dwdEffectImMessage.getFromuserBidGroup().length()>0){
            dwdEffectImMessage.setFromuserBidGroup(getBidGroup(dwdEffectImMessage.getFromuserBidGroup().toUpperCase()));
        }
        if(dwdEffectImMessage.getSendtouserBidGroup()!=null&&dwdEffectImMessage.getSendtouserBidGroup().length()>0){
            dwdEffectImMessage.setSendtouserBidGroup(getBidGroup(dwdEffectImMessage.getSendtouserBidGroup().toUpperCase()));
        }


        model.addAttribute("imdetail",dwdEffectImMessage);
        model.addAttribute("city",city);
        model.addAttribute("business",business);
        model.addAttribute("sendtoPre",sendtoPre);
        model.addAttribute("formPre",formPre);
        model.addAttribute("clienttype",clienttype);
        return "dataItem/im-more";
    }

    //城市处理im_chat_message_City
    String getCityFromDwdEffectImPersonim(DwdEffectImMessage dwdEffectImPersonim) {
        if (dwdEffectImPersonim.getImChatMessageCity() != null && dwdEffectImPersonim.getImChatMessageCity().length() > 0)
        {
            return dwdEffectImPersonim.getImChatMessageCity();

        } else if (dwdEffectImPersonim.getFromuserBidCity() != null && dwdEffectImPersonim.getFromuserBidCity().length() > 0)
        {
            //发送人BID 所属城市 fromuser_BID_City
            return dwdEffectImPersonim.getFromuserBidCity();
        } else if (dwdEffectImPersonim.getSendtouserBidCity() != null && dwdEffectImPersonim.getSendtouserBidCity().length() > 0)
        {
            //接收人BID 所属城市 sendtouser_BID_City
            return  dwdEffectImPersonim.getSendtouserBidCity();
        }else{
            return "";
        }
    }
    //imChatMessageType 处理所属业务
    String getYWFromDwdEffectImPersonim(String imChatMessageType){
        switch (imChatMessageType){
            case "home": return "家居挂牌";
            case "agent": return "二手房挂牌";
            //case "commerce": return "三房挂牌";
            case "commerce": return "租房";
            case "consultant" :return "广告";
            case "clientlg" :return "C端";            // 平台
            default: return "";
        }
    }
    //sendtoPre  or formPre
    String getSendtoPreOrFormPre(String anyPre){
        switch (anyPre){
            case "h": return "家居";
            case "gw": return "新房";
            case "l": return "平台";
            case "" :return "二手房";
            default: return "";
        }
    }

    //转义发送人客户端
    String getClienttype(String imChatMessageClienttype){
        switch(imChatMessageClienttype){
            case "phone" : return "APP";
            case "pc" : return "PC页";
            case "wap" : return "WAP页";
            default: return "";
        }
    }
    //转义集团
    String getBidGroup(String bidGroup){
        switch(bidGroup){
            case "XF" : return "新房";
            case "ESF" : return "二手房";
            default:return "";
        }
    }

    @RequestMapping(value = "/im-more1/{imid}/{logday}",method = RequestMethod.GET)
    @ResponseBody
    DwdEffectImMessage getByODSId1(@PathVariable("imid") String imid,@PathVariable("logday") String logday){
        return dwdEffectImMessageService.queryByImChatMessageMessageid(imid,logday);
    }

    @RequestMapping(value = "/im-list",method = RequestMethod.GET)
    String dwdEffectImPersonimList(){
        return "dataItem/im-list";
    }

    @Resource
    private ImCityService imCityService;

    /**
     * 加载城市列表
     * @return
     */
    @RequestMapping(value="/getCitys",method = RequestMethod.GET)
    @ResponseBody
    List<ImCity> getCitys(){
        return imCityService.getCitys();
    }

    @RequestMapping(value="/getCitys1",method = RequestMethod.GET)
    @ResponseBody
    List<Map<String,Object>> getCity1(){
        return imCityService.selectCitys();
    }

    @RequestMapping(value="/getQX",method = RequestMethod.GET)
    @ResponseBody
    List<String> getQX(String city){
        ArrayList<String> qx = new ArrayList<>();
        System.out.println(city);
        if(city.equals("北京")){
            qx.add("海淀");
            qx.add("朝阳");
            qx.add("丰台");
            qx.add("通州");

        }else if(city.equals("上海")){
            qx.add("松江区");
            qx.add("闵行区");
            qx.add("陆家嘴");
        }
        return qx;
    }

    @RequestMapping(value="/getSQ",method = RequestMethod.GET)
    @ResponseBody
    List<String> getSQ(String city){
        ArrayList<String> sq = new ArrayList<>();
        if(city.equals("海淀")){
            sq.add("海淀商圈1");
            sq.add("海淀商圈2");
            sq.add("海淀商圈3");

        }else if(city.equals("朝阳")){
            sq.add("朝阳商圈1");
            sq.add("朝阳商圈2");
            sq.add("朝阳商圈3");
        }else if(city.equals("丰台")){
            sq.add("丰台商圈1");
            sq.add("丰台商圈2");
            sq.add("丰台商圈3");
        }else if(city.equals("通州")){
            sq.add("通州商圈1");
            sq.add("通州商圈2");
            sq.add("通州商圈3");
        }else if(city.equals("松江区")){
            sq.add("松江区商圈1");
            sq.add("松江区商圈2");
            sq.add("松江区商圈3");
        }else if(city.equals("闵行区")){
            sq.add("闵行区商圈1");
            sq.add("闵行区商圈2");
            sq.add("闵行区商圈3");
        }else if(city.equals("陆家嘴")){
            sq.add("陆家嘴商圈1");
            sq.add("陆家嘴商圈2");
            sq.add("陆家嘴商圈3");
        }
        return sq;
    }

    /**
     * im-list列表页 分页
     * @param startTime
     * @param endTime
     * @param city
     * @param imChatMessageType
     * @param pageNum
     * @param pageSize
     * @return
     */
    @RequestMapping(value="/getDwdEffectImPersonimPage",method = RequestMethod.GET)
    @ResponseBody
    List<DwdEffectImMessage> getByPage(String startTime, String endTime, String city,String qx,String sq,String passportid,String imChatMessageType, Integer pageNum, Integer pageSize, String imChatMessageShopid){
        List<DwdEffectImMessage> dwdEffectImMessages = dwdEffectImMessageService.queryPages(startTime.replaceAll("-", ""), endTime.replaceAll("-", ""), city,qx,sq,passportid, imChatMessageType, pageNum, pageSize,imChatMessageShopid);
        for (DwdEffectImMessage d: dwdEffectImMessages)
        {
            d.setImChatMessageClienttype(getClienttype(d.getImChatMessageClienttype()));
            String imChatMessageMessage = d.getImChatMessageMessage();
            if(imChatMessageMessage!=null&imChatMessageMessage.length()>100){
                String s = imChatMessageMessage.substring(0, 100) + "...";
                d.setImChatMessageMessage(s);
            }

        }
        return dwdEffectImMessages;
    }
    /**
     * im-list列表页计数
     * @param startTime
     * @param endTime
     * @param city
     * @param imChatMessageType
     * @return
     */
    @RequestMapping(value="/getDwdEffectImPersonimPageCount",method = RequestMethod.GET)
    @ResponseBody
    Integer getDwdEffectImPersonimPageCount(String startTime, String endTime, String city,String qx,String sq,String passportid, String imChatMessageType, String imChatMessageShopid){
        return dwdEffectImMessageService.queryPagesCount(startTime, endTime, city,qx,sq,passportid, imChatMessageType, imChatMessageShopid);
    }

    @RequestMapping(value="/getuvInBestHour",method = RequestMethod.GET)
    @ResponseBody
    List<String> uvInBestHour(String actionday,String city){
        List<String> hours = dwdEffectImMessageService.uvInBestHour(actionday, city);
        return hours;
    }

    @RequestMapping(value="/getuvInBestWeek",method = RequestMethod.GET)
    @ResponseBody
    List<String> uvInBestWeek(String actionday,String city){
        List<String> weeks = dwdEffectImMessageService.uvInBestWeek(actionday, city);
        ArrayList<String> weeks2 = new ArrayList<>();
        for (String w: weeks)
        {
            weeks2.add(getWeek(w));
        }
        return weeks2;
    }

    /**
     * impala dayofweek()转义 星期
     * @param weeknum
     * @return
     */
    String getWeek(String weeknum){
        if(weeknum!=null){
            switch (weeknum){
                case "1":   return "星期日";
                case "2":   return "星期一";
                case "3":   return "星期二";
                case "4":   return "星期三";
                case "5":   return "星期四";
                case "6":   return "星期五";
                case "7":   return "星期六";
                default : return "未知";
            }
        }
        return "未知";
    }


    @RequestMapping(value = "/dataItem/{page}",method = RequestMethod.GET)
    String dataItemPage(@PathVariable("page") String page){
        return "dataItem/"+page;
    }

    @Resource
    private ImAnalyseService imAnalyseService;

    @RequestMapping(value="/getImAnalysePages",method = RequestMethod.GET)
    @ResponseBody
    public List<ImAnalyse> getImAnalysePages(String startTime, String endTime, String city, String pagetype, String producttype, Integer pageNum, Integer pageSize){
        List<ImAnalyse> imAnalyses = imAnalyseService.queryPages(startTime.replaceAll("-", ""), endTime.replaceAll("-", ""), city, pagetype, producttype, pageNum, pageSize);
        for(ImAnalyse im:imAnalyses){
            String contents = im.getContents();
            if(contents!=null&contents.length()>100){
                String s = contents.substring(0,100)+" ...";
                im.setContents(s);
            }
        }
        return imAnalyses;
    }

    @RequestMapping(value="/getImAnalyseCount",method = RequestMethod.GET)
    @ResponseBody
    Integer getImAnalyseCount(String startTime, String endTime, String city, String pagetype, String producttype){
        return imAnalyseService.queryCount(startTime, endTime, city, pagetype, producttype);
    }

    @RequestMapping(value = "/im-analyse-more/{imid}/{logday}",method = RequestMethod.GET)
    String getImAnalyseCount(@PathVariable("imid") String imid,@PathVariable("logday") String logday,Model model){
        //处理回话内容
        ImAnalyse imAnalyse = imAnalyseService.selectByMessageidActionday(imid, logday);
        String contents = imAnalyse.getContents();
        String[] MessageInfos = contents.split("\\&\\&\\&");
        List<String[]> msgStrs = new ArrayList<>();
        for (String msgInfo: MessageInfos)
        {
            String[] s = new String[4];
            s[0]=msgInfo.startsWith("l")?"right":"left";
            //发送消息账号
            s[1]=msgInfo.split("\\^\\^")[0];
            //消息
            s[2]=msgInfo.split("\\^\\^")[1];
            //时间
            s[3]=msgInfo.split("\\^\\^")[2];
            msgStrs.add(s);
        }
        model.addAttribute("msgStrs",msgStrs);

        DwdEffectImMessage dwdEffectImMessage = dwdEffectImMessageService.queryByImChatMessageMessageid(imid, logday);
        //转义城市
        String city = getCityFromDwdEffectImPersonim(dwdEffectImMessage);
        //转义所属业务
        String business = getYWFromDwdEffectImPersonim(dwdEffectImMessage.getImChatMessageType().toLowerCase());
        //sendtoPre  or formPre 发送人所属业务/接收方用户类型 转义
        String sendtoPre = getSendtoPreOrFormPre(dwdEffectImMessage.getSendtoPre().toLowerCase());
        String formPre = getSendtoPreOrFormPre(dwdEffectImMessage.getFormPre().toLowerCase());
        //转义发送人客户端
        String clienttype = getClienttype(dwdEffectImMessage.getImChatMessageClienttype().toLowerCase());
        //fromuserBidGroup sendtouserBidGroup 处理所属集团
        if(dwdEffectImMessage.getFromuserBidGroup()!=null&&dwdEffectImMessage.getFromuserBidGroup().length()>0){
            dwdEffectImMessage.setFromuserBidGroup(getBidGroup(dwdEffectImMessage.getFromuserBidGroup().toUpperCase()));
        }
        if(dwdEffectImMessage.getSendtouserBidGroup()!=null&&dwdEffectImMessage.getSendtouserBidGroup().length()>0){
            dwdEffectImMessage.setSendtouserBidGroup(getBidGroup(dwdEffectImMessage.getSendtouserBidGroup().toUpperCase()));
        }


        model.addAttribute("imdetail",dwdEffectImMessage);
        model.addAttribute("city",city);
        model.addAttribute("business",business);
        model.addAttribute("sendtoPre",sendtoPre);
        model.addAttribute("formPre",formPre);
        model.addAttribute("clienttype",clienttype);
        return "dataItem/im-analyse-more";
    }


    public static void main(String[] args) {
        String test="bhyax1994^^有什么能帮到您的更好^^2018-12-01 00:00:01.423&&&l:fang4801776461^^比较喜欢御龙湾的^^2018-12-01 00:00:18.203&&&l:fang4801776461^^比较喜欢御龙湾的^^2018-12-01 00:00:18.203";
        String[] MessageInfos = test.split("\\&\\&\\&");
        System.out.println(MessageInfos.length);
        System.out.println(MessageInfos[0]);
        List<String[]> msgStrs = new ArrayList<>();
        for (String msgInfo: MessageInfos)
        {
            String[] s = new String[4];
            s[0]=msgInfo.startsWith("l")?"right":"left";
            String[] split = msgInfo.split("\\^\\^");
            //发送消息账号
            s[1]=msgInfo.split("^^")[0];
            //消息
            s[2]=msgInfo.split("^^")[1];
            //时间
            s[3]=msgInfo.split("^^")[2];
            msgStrs.add(s);
        }
    }
}
