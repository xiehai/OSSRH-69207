package com.junyufr.iservice.pojo;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

/**
 * @ClassName BaseDO
 * @Description BaseDO
 * @Author xiehai
 * @Date 2021/5/19 13:17
 * @Version 1.0
 */
@Data
public class BaseDO<T> {
    /**
     * 云平台分配的应用授权码信息 length：32
     */
    @JSONField(name="license_code")
    private String licenseCode;
    /**
     * 请求参数的签名串 length：32
     */
    private String sign;
    /**
     * 发送请求的时间，格式"yyyy-MM-dd HH:mm:ss"	length:19
     */
    private String timestamp;
    /**
     * 业务流水号 length：40
     */
    @JSONField(name="sys_req_sn")
    private String sysReqSn;
    /**
     * 应用场景
     * 字典编号	场景说明
     * 01	注册
     * 02	交易
     * 03	签约
     * 04	其他
     */
    @JSONField(name="scene_code")
    private String sceneCode;
    /**
     * 存证MD5  此字段加入校验和存证取决于管理端接口配置
     * length：32
     */
    @JSONField(name="save_cer")
    private String saveCer;
    /**
     * 协议授权版本号
     */
    @JSONField(name="pact_no")
    private String pactNo;
    /**
     * 协议授权签名
     */
    @JSONField(name="pact_sign")
    private String pactSign;
    /**
     * 协议授权流水号
     */
    @JSONField(name="pact_trade_no")
    private String pactTradeNo;

    @JSONField(name="biz_content")
    private T bizContent;

    /**
     *请求地址
     */
    @JSONField(serialize = false)
    private String url;
    /**
     *应用密码
     */
    @JSONField(serialize = false)
    private String appSecret;
    /**
     *超时时间
     */
    @JSONField(serialize = false)
    private Integer connectTimeout;
    /**
     *读取时间
     */
    @JSONField(serialize = false)
    private Integer readTimeout;

}
