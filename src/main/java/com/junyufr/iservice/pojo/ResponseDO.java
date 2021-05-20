package com.junyufr.iservice.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @ClassName ResponseDO
 * @Description ResponseDO
 * @Author xiehai
 * @Date 2021/5/19 13:52
 * @Version 1.0
 */
@Data
public class ResponseDO {
    /**
     * 返回相应码和相应内容
     */
    @JsonProperty(value = "jy_response")
    private JyResponse jyResponse = new JyResponse();
    /**
     * 签名
     */
    private  String sign;
}
