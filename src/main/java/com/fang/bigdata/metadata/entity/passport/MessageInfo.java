package com.fang.bigdata.metadata.entity.passport;

import lombok.*;

/**
 * @project:imWebReport
 * @packname:com.fang.bigdata.metadata.entity.passport
 * @name: MessageInfo
 * @describe:
 * @author: niujiaxin
 * @create: 2019-01-09-10:37
 */
@Getter
@Setter
@ToString
public class MessageInfo {
    //消息内容
    private String imChatMessageMessage;
    //消息发送时间
    private String imChatMessageMessagetime;
    //城市
    private String imChatMessageCity;
    //涉及到的新房楼盘id
    private String imChatMessageShopid;
    //涉及到的二手房源id
    private String imChatMessageHouseid;
}
