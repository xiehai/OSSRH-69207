package com.junyufr.iservice.pojo.vo.ocr;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

/**
 * @ClassName IdCardOcr2VO
 * @Description 身份证ocr双面
 * @Author xiehai
 * @Date 2021/5/19 21:25
 * @Version 1.0
 */
@Data
public class IdCardOcr2VO {
    /**
     * 身份证照片Base64 正面
     */
    @JSONField(name = "front_photo")
    private String frontPhoto;

    /**
     * 身份证照片Base64 反面
     */
    @JSONField(name = "back_photo")
    private String backPhoto;

    /**
     * 是否返回头像 0否 1是
     */
    @JSONField(name = "head_option")
    private String headOption;
}
