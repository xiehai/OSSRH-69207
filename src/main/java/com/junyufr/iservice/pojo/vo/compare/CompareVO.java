package com.junyufr.iservice.pojo.vo.compare;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

/**
 * @ClassName CompareVO
 * @Description CompareVO
 * @Author xiehai
 * @Date 2021/5/19 20:50
 * @Version 1.0
 */
@Data
public class CompareVO {
    /**
     * 图片1Base64
     */
    @JSONField(name = "left_photo")
    private String photo;

    /**
     * 图片2Base64
     */
    @JSONField(name = "right_photo")
    private String photo2;
}
