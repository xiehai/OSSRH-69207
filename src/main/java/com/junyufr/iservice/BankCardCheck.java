package com.junyufr.iservice;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.junyufr.iservice.enums.CodeEnum;
import com.junyufr.iservice.pojo.BaseDO;
import com.junyufr.iservice.pojo.ResponseDO;
import com.junyufr.iservice.pojo.vo.bank.BankCard2VO;
import com.junyufr.iservice.pojo.vo.bank.BankCard3VO;
import com.junyufr.iservice.pojo.vo.bank.BankCard4VO;
import com.junyufr.iservice.pojo.vo.bank.BankCardOcr;
import com.junyufr.iservice.util.*;
import lombok.extern.slf4j.Slf4j;


/**
 * @ClassName BankCardCheck_v3VO
 * @Description BankCardCheck_v3VO
 * @Author xiehai
 * @Date 2021/5/19 13:31
 * @Version 1.0
 */
@Slf4j
public class BankCardCheck extends BaseCheck{

    /**
     * @Description:  checkBackCardV2 封装
     * @Param: [bankCardCheckV3VO]
     * @return: com.junyufr.iservice.pojo.ResponseDO
     * @Author: xiehai
     * @Date: 2021/5/19
     */
    public static ResponseDO checkBackCardV2(BaseDO<BankCard2VO> baseDO){
        ResponseDO responseDO = new ResponseDO();
        try{
            if(checkParam(baseDO)){
                //设置协议授权签名
                baseDO.setPactSign(JYMD5.MD5Encoder("123"));
                //加密铭文
                baseDO.getBizContent().setIdCard(AesUtil.encrypt(baseDO.getBizContent().getIdCard(), baseDO.getAppSecret()));
                baseDO.getBizContent().setName(AesUtil.encrypt(baseDO.getBizContent().getName(), baseDO.getAppSecret()));
                baseDO.getBizContent().setBankCard(AesUtil.encrypt(baseDO.getBizContent().getBankCard(), baseDO.getAppSecret()));
                //信息防篡改签名
                baseDO.setSign(JYMD5.createSignature((JSONObject)JSON.toJSON(baseDO), baseDO.getAppSecret()));
                responseDO = post(baseDO,JSON.toJSONString(baseDO));
                if(!checkSign(responseDO)){
                    responseDO = new ResponseDO();
                    responseDO.getJyResponse().setCodeAndMsg(CodeEnum.NOT_EQUALS_SIGN);
                }
            }else{
                responseDO.getJyResponse().setCodeAndMsg(CodeEnum.PARAM_NULL);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return responseDO;
        }
        return responseDO;
    }
    /**
    * @Description:  BankCardCheck_v3 封装
    * @Param: [bankCardCheckV3VO]
    * @return: com.junyufr.iservice.pojo.ResponseDO
    * @Author: xiehai
    * @Date: 2021/5/19
    */
    public static ResponseDO checkBackCardV3(BaseDO<BankCard3VO> baseDO){
        ResponseDO responseDO = new ResponseDO();
        try{
            if(checkParam(baseDO)){
                //设置协议授权签名
                baseDO.setPactSign(JYMD5.MD5Encoder(baseDO.getBizContent().getName() + baseDO.getBizContent().getIdCard()));
                //加密铭文
                baseDO.getBizContent().setIdCard(AesUtil.encrypt(baseDO.getBizContent().getIdCard(), baseDO.getAppSecret()));
                baseDO.getBizContent().setName(AesUtil.encrypt(baseDO.getBizContent().getName(), baseDO.getAppSecret()));
                baseDO.getBizContent().setBankCard(AesUtil.encrypt(baseDO.getBizContent().getBankCard(), baseDO.getAppSecret()));
                //信息防篡改签名
                baseDO.setSign(JYMD5.createSignature((JSONObject)JSON.toJSON(baseDO), baseDO.getAppSecret()));
                responseDO = post(baseDO,JSON.toJSONString(baseDO));
                if(!checkSign(responseDO)){
                    responseDO = new ResponseDO();
                    responseDO.getJyResponse().setCodeAndMsg(CodeEnum.NOT_EQUALS_SIGN);
                }
            }else{
                responseDO.getJyResponse().setCodeAndMsg(CodeEnum.PARAM_NULL);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return responseDO;
        }
        return responseDO;
    }

    /**
     * @Description:  BankCardCheck_v4 封装
     * @Param: [bankCardCheckV3VO]
     * @return: com.junyufr.iservice.pojo.ResponseDO
     * @Author: xiehai
     * @Date: 2021/5/19
     */
    public static ResponseDO checkBackCardV4(BaseDO<BankCard4VO> baseDO){
        ResponseDO responseDO = new ResponseDO();
        try{
            if(checkParam(baseDO)){
                //设置协议授权签名
                baseDO.setPactSign(JYMD5.MD5Encoder(baseDO.getBizContent().getName() + baseDO.getBizContent().getIdCard()));
                //加密铭文
                baseDO.getBizContent().setIdCard(AesUtil.encrypt(baseDO.getBizContent().getIdCard(), baseDO.getAppSecret()));
                baseDO.getBizContent().setName(AesUtil.encrypt(baseDO.getBizContent().getName(), baseDO.getAppSecret()));
                baseDO.getBizContent().setBankCard(AesUtil.encrypt(baseDO.getBizContent().getBankCard(), baseDO.getAppSecret()));
                baseDO.getBizContent().setMobile(AesUtil.encrypt(baseDO.getBizContent().getMobile(), baseDO.getAppSecret()));
                //信息防篡改签名
                baseDO.setSign(JYMD5.createSignature((JSONObject)JSON.toJSON(baseDO), baseDO.getAppSecret()));
                responseDO = post(baseDO,JSON.toJSONString(baseDO));
                if(!checkSign(responseDO)){
                    responseDO = new ResponseDO();
                    responseDO.getJyResponse().setCodeAndMsg(CodeEnum.NOT_EQUALS_SIGN);
                }
            }else{
                responseDO.getJyResponse().setCodeAndMsg(CodeEnum.PARAM_NULL);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return responseDO;
        }
        return responseDO;
    }

    /**
     * @Description:  checkBackCardOcr 封装
     * @Param: [BankCardOcr]
     * @return: com.junyufr.iservice.pojo.ResponseDO
     * @Author: xiehai
     * @Date: 2021/5/19
     */
    public static ResponseDO checkBackCardOcr(BaseDO<BankCardOcr> baseDO){
        ResponseDO responseDO = new ResponseDO();
        try{
            if(checkParam(baseDO)){
                //设置协议授权签名
                baseDO.setPactSign(JYMD5.MD5Encoder("123"));
                //加密铭文
                baseDO.getBizContent().setPhoto(JYMD5.encrypt(baseDO.getBizContent().getPhoto()));
                //信息防篡改签名
                baseDO.setSign(JYMD5.createSignature((JSONObject)JSON.toJSON(baseDO), baseDO.getAppSecret()));
                responseDO = post(baseDO, JSON.toJSONString(baseDO));
                if(!checkSign(responseDO)){
                    responseDO = new ResponseDO();
                    responseDO.getJyResponse().setCodeAndMsg(CodeEnum.NOT_EQUALS_SIGN);
                }
            }else{
                responseDO.getJyResponse().setCodeAndMsg(CodeEnum.PARAM_NULL);
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.info("<------------分割线------------>");
            return responseDO;
        }
        return responseDO;
    }

    /**
     * @Description:  checkBackCardV5 封装
     * @Param: [BaseDO<BankCard4VO>]
     * @return: com.junyufr.iservice.pojo.ResponseDO
     * @Author: xiehai
     * @Date: 2021/5/19
     */
    public static ResponseDO checkBackCardV5(BaseDO<BankCard4VO> baseDO){
        ResponseDO responseDO = new ResponseDO();
        try{
            if(checkParam(baseDO)){
                //设置协议授权签名
                baseDO.setPactSign(JYMD5.MD5Encoder(baseDO.getBizContent().getName() + baseDO.getBizContent().getIdCard()));
                //加密铭文
                baseDO.getBizContent().setIdCard(AesUtil.encrypt(baseDO.getBizContent().getIdCard(), baseDO.getAppSecret()));
                baseDO.getBizContent().setName(AesUtil.encrypt(baseDO.getBizContent().getName(), baseDO.getAppSecret()));
                baseDO.getBizContent().setBankCard(AesUtil.encrypt(baseDO.getBizContent().getBankCard(), baseDO.getAppSecret()));
                baseDO.getBizContent().setMobile(AesUtil.encrypt(baseDO.getBizContent().getMobile(), baseDO.getAppSecret()));
                //信息防篡改签名
                baseDO.setSign(JYMD5.createSignature((JSONObject)JSON.toJSON(baseDO), baseDO.getAppSecret()));
                responseDO = post(baseDO,JSON.toJSONString(baseDO));
                if(!checkSign(responseDO)){
                    responseDO = new ResponseDO();
                    responseDO.getJyResponse().setCodeAndMsg(CodeEnum.NOT_EQUALS_SIGN);
                }
            }else{
                responseDO.getJyResponse().setCodeAndMsg(CodeEnum.PARAM_NULL);
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.info("<------------分割线------------>");
            return responseDO;
        }
        return responseDO;
    }
}
