package com.junyufr.iservice.pojo.vo.bank;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

/**
 * @ClassName BaseBankVO
 * @Description BaseBankVO
 * @Author xiehai
 * @Date 2021/5/19 15:14
 * @Version 1.0
 */
@Data
public class BaseBankVO{
    /**
     * 姓名
     */
    private String name;

    /**
     * 证件号码
     */
    @JSONField(name = "id_card")
    private String idCard;

    /**
     * 卡号
     */
    @JSONField(name = "bank_card")
    private String bankCard;


    /**
     * 证件类型，只支持0-身份证
     */
    @JSONField(name = "identity_type")
    private String identityType;
}
