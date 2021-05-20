package com.junyufr.iservice.pojo.vo.idcard;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

/**
 * @ClassName IdCard2BO
 * @Description II类C型
 * @Author luzhiyu
 * @Date 2019/6/12 13:59
 * @Version 1.0
 */
@Data
public class IdCard2VO{

    /**
     * 姓名
     */
    private String name;

    /**
     * 身份证号码
     */
    @JSONField(name = "id_card")
    private String idCard;
}
