package com.junyufr.iservice.pojo.vo.compare;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

/**
 * @ClassName Compare1VO
 * @Description Compare1VO
 * @Author xiehai
 * @Date 2021/5/19 20:50
 * @Version 1.0
 */
@Data
public class Compare1VO {
    /**
     * 是否进行防假体模型验证；需要验证请传“1”,默认不进行验证
     */
    @JSONField(name = "anti_hacker")
    private String antiHacker;

    /**
     * BASE64身份证人像面翻拍照
     */
    @JSONField(name = "id_photo")
    private String idPhoto;

    /**
     * 数据包BASE64字符串，Data数据包中包含环境现场照、活体抓拍照等一系列数据
     */
    @JSONField(name = "data_photo")
    private String dataPhoto;
}
