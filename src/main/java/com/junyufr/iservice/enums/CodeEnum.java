package com.junyufr.iservice.enums;


import org.springframework.util.StringUtils;

/**
 * @ClassName CodeEnum
 * @Description 一级code枚举
 * @Author luzhiyu
 * @Date 2019/6/12 15:04
 * @Version 1.0
 */
public enum CodeEnum {

    /**
     * 一级返回码
     */
    SUCCESS("0", "成功"),
    BUSINESS_FAIL("-100", "业务处理失败"),
    SERVICE_UNAVAILABLE("-500", "服务不可用"),
    AUTH_FAIL("-400", "授权权限不足"),
    PARAM_NULL("-200", "缺少必选参数"),
    PARAM_FORMAT("-300", "非法的参数"),
    NOT_EQUALS_SIGN("-600", "返回签名不一致");

    /**
     * 一级返回码
     */
    private String code;

    /**
     * 一级返回码描述
     */
    private String msg;

    CodeEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    /**
     * 返回码查枚举
     *
     * @param code
     * @return
     */
    public static CodeEnum findByCode(String code) {
        CodeEnum result = null;
        if (!StringUtils.isEmpty(code)) {
            for (CodeEnum codeEnum : CodeEnum.values()) {
                if (code.equals(codeEnum.getCode())) {
                    result = codeEnum;
                }
            }
        }
        return result;
    }

}
