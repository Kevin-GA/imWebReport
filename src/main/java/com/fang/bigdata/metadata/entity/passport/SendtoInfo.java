package com.fang.bigdata.metadata.entity.passport;

import lombok.*;

/**
 * @project:imWebReport
 * @packname:com.fang.bigdata.metadata.entity.passport
 * @name: SendtoInfo
 * @describe:
 * @author: niujiaxin
 * @create: 2019-01-09-10:26
 */
@Getter
@Setter
@ToString
public class SendtoInfo {
    //接收方用户名
    private String sendtoSendtouser;
    //接收方用户类型
    private String sendtoPre;
    //接收方在C端是否电话认证
    private String sendtouserPassportidTelauthentication;
    //接收方是否是B端用户
    private String sendtouserBid;
    //接收方在B端注册时间
    private String sendtouserBidRegistertime;
    //接收方在B端所属公司
    private String sendtouserBidCompanyname;
    //接收方在B端是否认证
    private String sendtouserBidAuthentication;
    //接收方在B端所属集团
    private String sendtouserBidGroup;

    //oa
    //是否绑定销售
    private String oatoResourceid;
    //销售名称
    private String oatoOaLastname;
    //销售直接上级名称
    private String oatoOaManager;
    //销售集团名称
    private String oatoOaSupsubcompany;
    //销售公司名称
    private String oatoOaSubcompany;
    //销售部门名称
    private String oatoOaDepartment;
    //城市
    private String sendtouserBidCity;
}
