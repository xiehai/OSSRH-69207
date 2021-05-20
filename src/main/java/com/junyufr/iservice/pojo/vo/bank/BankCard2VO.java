package com.junyufr.iservice.pojo.vo.bank;

import lombok.Data;

/**
 * @ClassName BankCardCheckV3VO
 * @Description BankCardCheckV3VO
 * @Author xiehai
 * @Date 2021/5/19 13:22
 * @Version 1.0
 */
@Data
public class BankCard2VO extends BaseBankVO{
    /**
     * 类型， 01：银行卡+姓名， 02：银行卡+证件号
     */
    private String type;
}
