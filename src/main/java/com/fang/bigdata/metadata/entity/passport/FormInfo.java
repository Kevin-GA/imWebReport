package com.fang.bigdata.metadata.entity.passport;

import lombok.*;

/**
 * @project:imWebReport
 * @packname:com.fang.bigdata.metadata.entity.passport
 * @name: FormInfo
 * @describe:发送方
 * @author: niujiaxin
 * @create: 2019-01-09-10:22
 */
@Getter
@Setter
@ToString
public class FormInfo {
    //发送方所属业务
    private String formPre;
    //发送人用户名
    private String formFromuser;
    //发送人客户端
    private String imChatMessageClienttype;
    //发送方在C端是否电话认证
    private String fromuserPassportidTelauthentication;
    //发送方在B端注册时间
    private String fromuserBidRegistertime;
    //发送方在B端所属公司
    private String fromuserBidCompanyname;
    //发送方在B端是否认证
    private String fromuserBidAuthentication;
    //发送方在B端所属集团
    private String fromuserBidGroup;
    //发送方是否是B端用户
    private String fromuserBid;

    //oa

    //是否绑定销售
    private String oafromResourceid;
    //销售名称
    private String oafromOaLastname;
    //销售上级名称
    private String oafromOaManager;
    //销售集团名称
    private String oafromOaSupsubcompany;
    //销售公司名称
    private String oafromOaSubcompany;
    //销售部门名称
    private String oafromOaDepartment;
    //城市
    private String fromuserBidCity;
}
