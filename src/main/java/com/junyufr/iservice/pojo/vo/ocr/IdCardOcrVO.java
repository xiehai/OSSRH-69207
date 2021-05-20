package com.junyufr.iservice.pojo.vo.ocr;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

/**
 * @ClassName IdCardOcrVO
 * @Description 身份证ocr
 * @Author xiehai
 * @Date 2021/5/19 21:29
 * @Version 1.0
 */
@Data
public class IdCardOcrVO {
    /**
     * 身份证照片Base64
     */
    private String photo;

    /**
     * 照片类型 0人像面 1国徽面
     */
    @JSONField(name = "card_type")
    private String cardType;

    /**
     * 是否返回头像 0否 1是
     */
    @JSONField(name = "head_option")
    private String headOption;
}
