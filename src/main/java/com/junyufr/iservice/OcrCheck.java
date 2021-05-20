package com.junyufr.iservice;

import com.alibaba.fastjson.JSONObject;
import com.junyufr.iservice.enums.CodeEnum;
import com.junyufr.iservice.pojo.BaseDO;
import com.junyufr.iservice.pojo.ResponseDO;
import com.junyufr.iservice.pojo.vo.ocr.*;
import com.junyufr.iservice.util.Base64ImgUtil;
import com.junyufr.iservice.util.DateUtil;
import com.junyufr.iservice.util.JYMD5;
import lombok.extern.slf4j.Slf4j;

/**
 * @ClassName OcrCheck
 * @Description OcrCheck
 * @Author xiehai
 * @Date 2021/5/19 21:17
 * @Version 1.0
 */
@Slf4j
public class OcrCheck extends BaseCheck {
    /**
     * @Description:  checkBusinessOcr 营业执照ocr封装
     * @Param: [BankCardOcr]
     * @return: com.junyufr.iservice.pojo.ResponseDO
     * @Author: xiehai
     * @Date: 2021/5/19
     */
    public static ResponseDO checkBusinessOcr(BaseDO<BusinessOcrVO> baseDO){
        ResponseDO responseDO = new ResponseDO();
        try{
            if(checkParam(baseDO)){
                //设置协议授权签名
                baseDO.setPactSign(JYMD5.MD5Encoder("123"));
                //加密铭文
                baseDO.getBizContent().setPhoto(JYMD5.encrypt(baseDO.getBizContent().getPhoto()));
                //信息防篡改签名
                baseDO.setSign(JYMD5.createSignature((JSONObject)JSONObject.toJSON(baseDO), baseDO.getAppSecret()));
                responseDO = post(baseDO,JSONObject.toJSONString(baseDO));
                if(!checkSign(responseDO)){
                    responseDO = new ResponseDO();
                    responseDO.getJyResponse().setCodeAndMsg(CodeEnum.NOT_EQUALS_SIGN);
                }
            }else{
                responseDO.getJyResponse().setCodeAndMsg(CodeEnum.PARAM_NULL);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("<------------分割线------------>");
            return responseDO;
        }
        return responseDO;
    }

    /**
     * @Description:  checkDriveOcr 驾驶证ocr封装
     * @Param: [BankCardOcr]
     * @return: com.junyufr.iservice.pojo.ResponseDO
     * @Author: xiehai
     * @Date: 2021/5/19
     */
    public static ResponseDO checkDriveOcr(BaseDO<DriveOcrVO> baseDO){
        ResponseDO responseDO = new ResponseDO();
        try{
            if(checkParam(baseDO)){
                //设置协议授权签名
                baseDO.setPactSign(JYMD5.MD5Encoder("123"));
                //加密铭文
                baseDO.getBizContent().setPhoto(JYMD5.encrypt(baseDO.getBizContent().getPhoto()));
                //信息防篡改签名
                baseDO.setSign(JYMD5.createSignature((JSONObject)JSONObject.toJSON(baseDO), baseDO.getAppSecret()));
                responseDO = post(baseDO,JSONObject.toJSONString(baseDO));
                if(!checkSign(responseDO)){
                    responseDO = new ResponseDO();
                    responseDO.getJyResponse().setCodeAndMsg(CodeEnum.NOT_EQUALS_SIGN);
                }
            }else{
                responseDO.getJyResponse().setCodeAndMsg(CodeEnum.PARAM_NULL);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("<------------分割线------------>");
            return responseDO;
        }
        return responseDO;
    }

    /**
     * @Description:  checkIdCardOcr 身份证orc封装
     * @Param: [BankCardOcr]
     * @return: com.junyufr.iservice.pojo.ResponseDO
     * @Author: xiehai
     * @Date: 2021/5/19
     */
    public static ResponseDO checkIdCardOcr(BaseDO<IdCardOcrVO> baseDO){
        ResponseDO responseDO = new ResponseDO();
        try{
            if(checkParam(baseDO)){
                //设置协议授权签名
                baseDO.setPactSign(JYMD5.MD5Encoder("123"));
                //加密铭文
                baseDO.getBizContent().setPhoto(JYMD5.encrypt(baseDO.getBizContent().getPhoto()));
                //信息防篡改签名
                baseDO.setSign(JYMD5.createSignature((JSONObject)JSONObject.toJSON(baseDO), baseDO.getAppSecret()));
                responseDO = post(baseDO,JSONObject.toJSONString(baseDO));
                if(!checkSign(responseDO)){
                    responseDO = new ResponseDO();
                    responseDO.getJyResponse().setCodeAndMsg(CodeEnum.NOT_EQUALS_SIGN);
                }
            }else{
                responseDO.getJyResponse().setCodeAndMsg(CodeEnum.PARAM_NULL);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("<------------分割线------------>");
            return responseDO;
        }
        return responseDO;
    }

    /**
     * @Description:  checkInvoiceOcr 增值税发票ocr封装
     * @Param: [BankCardOcr]
     * @return: com.junyufr.iservice.pojo.ResponseDO
     * @Author: xiehai
     * @Date: 2021/5/19
     */
    public static ResponseDO checkInvoiceOcr(BaseDO<InvoiceOcrVO> baseDO){
        ResponseDO responseDO = new ResponseDO();
        try{
            if(checkParam(baseDO)){
                //设置协议授权签名
                baseDO.setPactSign(JYMD5.MD5Encoder("123"));
                //加密铭文
                baseDO.getBizContent().setPhoto(JYMD5.encrypt(baseDO.getBizContent().getPhoto()));
                //信息防篡改签名
                baseDO.setSign(JYMD5.createSignature((JSONObject)JSONObject.toJSON(baseDO), baseDO.getAppSecret()));
                responseDO = post(baseDO,JSONObject.toJSONString(baseDO));
                if(!checkSign(responseDO)){
                    responseDO = new ResponseDO();
                    responseDO.getJyResponse().setCodeAndMsg(CodeEnum.NOT_EQUALS_SIGN);
                }
            }else{
                responseDO.getJyResponse().setCodeAndMsg(CodeEnum.PARAM_NULL);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("<------------分割线------------>");
            return responseDO;
        }
        return responseDO;
    }

    /**
     * @Description:  checkVehicleOcr 行驶证ocr封装
     * @Param: [BankCardOcr]
     * @return: com.junyufr.iservice.pojo.ResponseDO
     * @Author: xiehai
     * @Date: 2021/5/19
     */
    public static ResponseDO checkVehicleOcr(BaseDO<VehicleOcrVO> baseDO){
        ResponseDO responseDO = new ResponseDO();
        try{
            if(checkParam(baseDO)){
                //设置协议授权签名
                baseDO.setPactSign(JYMD5.MD5Encoder("123"));
                //加密铭文
                baseDO.getBizContent().setPhoto(JYMD5.encrypt(baseDO.getBizContent().getPhoto()));
                //信息防篡改签名
                baseDO.setSign(JYMD5.createSignature((JSONObject)JSONObject.toJSON(baseDO), baseDO.getAppSecret()));
                responseDO = post(baseDO,JSONObject.toJSONString(baseDO));
                if(!checkSign(responseDO)){
                    responseDO = new ResponseDO();
                    responseDO.getJyResponse().setCodeAndMsg(CodeEnum.NOT_EQUALS_SIGN);
                }
            }else{
                responseDO.getJyResponse().setCodeAndMsg(CodeEnum.PARAM_NULL);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("<------------分割线------------>");
            return responseDO;
        }
        return responseDO;
    }
}
