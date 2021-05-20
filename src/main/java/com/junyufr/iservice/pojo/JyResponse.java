package com.junyufr.iservice.pojo;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.junyufr.iservice.enums.CodeEnum;
import com.junyufr.iservice.enums.SubCodeEnum;
import lombok.Data;

import java.util.Map;

/**
 * @ClassName JyResponse
 * @Description 响应对象
 * @Author luzhiyu
 * @Date 2019/6/12 14:25
 * @Version 1.0
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class JyResponse {

    /**
     * 一级响应码
     */
    private String code;

    /**
     * 一级响应信息
     */
    private String msg;

    /**
     * 响应时间
     */
    private String timestamp;

    /**
     * 二级响应码
     */
    @JsonProperty(value = "sub_code")
    @JSONField(name = "sub_code")
    private String subCode;

    /**
     * 二级响应信息
     */
    @JsonProperty(value = "sub_msg")
    @JSONField(name = "sub_msg")
    private String subMsg;

    /**
     * 流水号
     */
    @JsonProperty(value = "sys_req_sn")
    @JSONField(name = "sys_req_sn")
    private String sysReqSn;

    /**
     * 交易号
     */
    @JsonProperty(value = "jy_trade_no")
    @JSONField(name = "jy_trade_no")
    private String jyTradeNo;

    /**
     * 响应数据
     */
    private Map<String, Object> data;

    /**
     * 证书base64
     */
    private String certificateBase64;

    public void setCodeAndMsg(CodeEnum codeEnum) {
        this.code = codeEnum.getCode();
        this.msg = codeEnum.getMsg();
    }

    public void setCodeAndMsg(CodeEnum codeEnum, SubCodeEnum subCodeEnum) {
        this.code = codeEnum.getCode();
        this.msg = codeEnum.getMsg();
        this.subCode = subCodeEnum.getCode();
        this.subMsg = subCodeEnum.getMsg();
    }

    public JyResponse() {
        this.setCodeAndMsg(CodeEnum.SUCCESS);
    }


    public static JyResponse innerError() {
        JyResponse jyResponse = new JyResponse();
        jyResponse.setCodeAndMsg(CodeEnum.SERVICE_UNAVAILABLE, SubCodeEnum.ERROR_5000);
        return jyResponse;
    }
}
