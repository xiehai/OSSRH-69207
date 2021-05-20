package com.junyufr.iservice.pojo.vo.idcard;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @ClassName IdCard3BO
 * @Description I类
 * @Author luzhiyu
 * @Date 2019/6/12 13:59
 * @Version 1.0
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class IdCard3VO extends IdCard2VO {

    /**
     * 身份证图片
     */
    @JSONField(name = "id_photo")
    private String photo;
}
