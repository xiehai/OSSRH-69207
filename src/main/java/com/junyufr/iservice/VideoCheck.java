package com.junyufr.iservice;

import com.alibaba.fastjson.JSONObject;
import com.junyufr.iservice.enums.CodeEnum;
import com.junyufr.iservice.pojo.BaseDO;
import com.junyufr.iservice.pojo.ResponseDO;
import com.junyufr.iservice.pojo.vo.video.Video1VO;
import com.junyufr.iservice.pojo.vo.video.Video2VO;
import com.junyufr.iservice.pojo.vo.video.Video3VO;
import com.junyufr.iservice.util.AesUtil;
import com.junyufr.iservice.util.Base64ImgUtil;
import com.junyufr.iservice.util.DateUtil;
import com.junyufr.iservice.util.JYMD5;
import lombok.extern.slf4j.Slf4j;

/**
 * @ClassName videoCheck
 * @Description videoCheck
 * @Author xiehai
 * @Date 2021/5/19 21:42
 * @Version 1.0
 */
@Slf4j
public class VideoCheck extends BaseCheck {
    /**
     * @Description:  checkVideo1 视频活体v1封装
     * @Param: [BankCardOcr]
     * @return: com.junyufr.iservice.pojo.ResponseDO
     * @Author: xiehai
     * @Date: 2021/5/19
     */
    public static ResponseDO checkVideo1(BaseDO<Video1VO> baseDO){
        ResponseDO responseDO = new ResponseDO();
        try{
            if(checkParam(baseDO)){
                //设置协议授权签名
                baseDO.setPactSign(JYMD5.MD5Encoder(baseDO.getBizContent().getName() + baseDO.getBizContent().getIdCard()));
                //加密铭文
                baseDO.getBizContent().setBaseVideo(JYMD5.encrypt(baseDO.getBizContent().getBaseVideo()));
                baseDO.getBizContent().setIdPhoto(JYMD5.encrypt(baseDO.getBizContent().getIdPhoto()));
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
     * @Description:  checkVideo2 视频活体v2封装
     * @Param: [BankCardOcr]
     * @return: com.junyufr.iservice.pojo.ResponseDO
     * @Author: xiehai
     * @Date: 2021/5/19
     */
    public static ResponseDO checkVideo2(BaseDO<Video2VO> baseDO){
        ResponseDO responseDO = new ResponseDO();
        try{
            if(checkParam(baseDO)){
                //设置协议授权签名
                baseDO.setPactSign(JYMD5.MD5Encoder(baseDO.getBizContent().getName() + baseDO.getBizContent().getIdCard()));
                //加密铭文
                baseDO.getBizContent().setBaseVideo(JYMD5.encrypt(baseDO.getBizContent().getBaseVideo()));
                baseDO.getBizContent().setIdCard(AesUtil.encrypt(baseDO.getBizContent().getIdCard(), baseDO.getAppSecret()));
                baseDO.getBizContent().setName(AesUtil.encrypt(baseDO.getBizContent().getName(), baseDO.getAppSecret()));
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
     * @Description:  checkVideo3 视频活体v3封装
     * @Param: [BankCardOcr]
     * @return: com.junyufr.iservice.pojo.ResponseDO
     * @Author: xiehai
     * @Date: 2021/5/19
     */
    public static ResponseDO checkVideo3(BaseDO<Video3VO> baseDO){
        ResponseDO responseDO = new ResponseDO();
        try{
            if(checkParam(baseDO)){
                //设置协议授权签名
                baseDO.setPactSign(JYMD5.MD5Encoder(baseDO.getBizContent().getName() + baseDO.getBizContent().getIdCard()));
                //加密铭文
                baseDO.getBizContent().setIdCard(AesUtil.encrypt(baseDO.getBizContent().getIdCard(), baseDO.getAppSecret()));
                baseDO.getBizContent().setName(AesUtil.encrypt(baseDO.getBizContent().getName(), baseDO.getAppSecret()));
                baseDO.getBizContent().setBaseVideo(JYMD5.encrypt(baseDO.getBizContent().getBaseVideo()));
                baseDO.getBizContent().setIdPhoto(JYMD5.encrypt(baseDO.getBizContent().getIdPhoto()));
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
