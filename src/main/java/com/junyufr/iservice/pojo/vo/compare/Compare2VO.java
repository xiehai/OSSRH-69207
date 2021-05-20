package com.junyufr.iservice.pojo.vo.compare;

import com.alibaba.fastjson.annotation.JSONField;
import com.junyufr.iservice.pojo.vo.idcard.IdCard2VO;
import lombok.Data;

/**
 * @ClassName Compare2VO
 * @Description Compare2VO
 * @Author xiehai
 * @Date 2021/5/19 21:02
 * @Version 1.0
 */
@Data
public class Compare2VO extends IdCard2VO {
    /**
     * 是否进行防假体模型验证；需要验证请传“1”,默认不进行验证
     */
    @JSONField(name = "anti_hacker")
    private String antiHacker;

    /**
     * 数据包BASE64字符串，Data数据包中包含环境现场照、活体抓拍照等一系列数据
     */
    @JSONField(name = "data_photo")
    private String dataPhoto;
}
