package com.junyufr.iservice;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.junyufr.iservice.enums.CodeEnum;
import com.junyufr.iservice.pojo.BaseDO;
import com.junyufr.iservice.pojo.ResponseDO;
import com.junyufr.iservice.pojo.vo.compare.Compare1VO;
import com.junyufr.iservice.pojo.vo.compare.Compare2VO;
import com.junyufr.iservice.pojo.vo.compare.Compare3VO;
import com.junyufr.iservice.pojo.vo.compare.CompareVO;
import com.junyufr.iservice.util.AesUtil;
import com.junyufr.iservice.util.Base64ImgUtil;
import com.junyufr.iservice.util.DateUtil;
import com.junyufr.iservice.util.JYMD5;
import lombok.extern.slf4j.Slf4j;

/**
 * @ClassName CompareCheck
 * @Description CompareCheck
 * @Author xiehai
 * @Date 2021/5/19 20:47
 * @Version 1.0
 */
@Slf4j
public class CompareCheck extends BaseCheck {

    /**
     * @Description:  compareAi 封装
     * @Param: [BaseDO<CompareVO>]
     * @return: com.junyufr.iservice.pojo.ResponseDO
     * @Author: xiehai
     * @Date: 2021/5/19
     */
    public static ResponseDO compareAi(BaseDO<CompareVO> baseDO){
        ResponseDO responseDO = new ResponseDO();
        try{
           if(checkParam(baseDO)){
                //设置协议授权签名
                baseDO.setPactSign(JYMD5.MD5Encoder("123"));
                //加密铭文
                baseDO.getBizContent().setPhoto(JYMD5.encrypt(baseDO.getBizContent().getPhoto()));
                baseDO.getBizContent().setPhoto2(JYMD5.encrypt(baseDO.getBizContent().getPhoto2()));
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
     * @Description:  compareAiV1 封装
     * @Param: [BaseDO<Compare1VO>]
     * @return: com.junyufr.iservice.pojo.ResponseDO
     * @Author: xiehai
     * @Date: 2021/5/19
     */
    public static ResponseDO compareAiV1(BaseDO<Compare1VO> baseDO){
        ResponseDO responseDO = new ResponseDO();
        try{
            if(checkParam(baseDO)){
                //设置协议授权签名
                baseDO.setPactSign(JYMD5.MD5Encoder("123"));
                //加密铭文
                baseDO.getBizContent().setIdPhoto(JYMD5.encrypt(baseDO.getBizContent().getIdPhoto()));
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
     * @Description:  compareAiV2 封装
     * @Param: [BaseDO<Compare2VO>]
     * @return: com.junyufr.iservice.pojo.ResponseDO
     * @Author: xiehai
     * @Date: 2021/5/19
     */
    public static ResponseDO compareAiV2(BaseDO<Compare2VO> baseDO){
        ResponseDO responseDO = new ResponseDO();
        try{
            if(checkParam(baseDO)){
                //设置协议授权签名
                baseDO.setPactSign(JYMD5.MD5Encoder(baseDO.getBizContent().getName() + baseDO.getBizContent().getIdCard()));
                //加密铭文
//                baseDO.getBizContent().setDataPhoto(JYMD5.encrypt(baseDO.getBizContent().getDataPhoto()));
                baseDO.getBizContent().setIdCard(AesUtil.encrypt(baseDO.getBizContent().getIdCard(), baseDO.getAppSecret()));
                baseDO.getBizContent().setName(AesUtil.encrypt(baseDO.getBizContent().getName(), baseDO.getAppSecret()));
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
     * @Description:  compareAiV3 封装
     * @Param: [BaseDO<Compare3VO>]
     * @return: com.junyufr.iservice.pojo.ResponseDO
     * @Author: xiehai
     * @Date: 2021/5/19
     */
    public static ResponseDO compareAiV3(BaseDO<Compare3VO> baseDO){
        ResponseDO responseDO = new ResponseDO();
        try{
            if(checkParam(baseDO)){
                //设置协议授权签名
                baseDO.setPactSign(JYMD5.MD5Encoder(baseDO.getBizContent().getName() + baseDO.getBizContent().getIdCard()));
                //加密铭文
                baseDO.getBizContent().setIdCard(AesUtil.encrypt(baseDO.getBizContent().getIdCard(), baseDO.getAppSecret()));
                baseDO.getBizContent().setName(AesUtil.encrypt(baseDO.getBizContent().getName(), baseDO.getAppSecret()));
                baseDO.getBizContent().setIdPhoto(JYMD5.encrypt(baseDO.getBizContent().getIdPhoto()));
                //信息防篡改签名
                baseDO.setSign(JYMD5.createSignature((JSONObject) JSON.toJSON(baseDO), baseDO.getAppSecret()));
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

    public static void main(String[] args) {
        //业务信息实体
        Compare2VO compare2VO = new Compare2VO();
        compare2VO.setAntiHacker("1");
        compare2VO.setName("谢海");
        compare2VO.setIdCard("340123199506125476");
        compare2VO.setDataPhoto(Base64ImgUtil.GetImageStr("D:\\jy\\photo\\photo.jpg"));
        //基础信息实体
        BaseDO<Compare2VO> baseDO = new BaseDO<>();
        baseDO.setUrl("https://47.102.255.5:8443/dat/compareAll_v2/cer");
        baseDO.setSceneCode("02");
        baseDO.setPactNo("B_00001");
        baseDO.setLicenseCode("E00CE39E6ACD45809FEEC2A64DA7D8B5");
        baseDO.setAppSecret("26146B7BBA4B4E2CACD56BA435F0F8EF");
        baseDO.setTimestamp(DateUtil.getCurrentTime());
        baseDO.setSysReqSn("CompareAll_V2");
        baseDO.setPactTradeNo("**协议授权流水号**");
        baseDO.setConnectTimeout(60000);
        baseDO.setReadTimeout(60000);
        baseDO.setBizContent(compare2VO);
        ResponseDO responseDO = CompareCheck.compareAiV2(baseDO);
        log.info("<------------分割线------------>");
        log.info(responseDO.toString());
        log.info("msg"+responseDO.getJyResponse().getMsg());
    }
    //服务不可用
    public void testCompare(){
        //业务信息实体
        CompareVO compareVO = new CompareVO();
        compareVO.setPhoto(Base64ImgUtil.GetImageStr("D:\\jy\\photo\\1.jpeg"));
        compareVO.setPhoto2(Base64ImgUtil.GetImageStr("D:\\jy\\photo\\2.jpeg"));
        //基础信息实体
        BaseDO<CompareVO> baseDO = new BaseDO<>();
        baseDO.setUrl("https://47.102.255.5:8443/compare/comparePhoto/ai");
        baseDO.setSceneCode("02");
        baseDO.setPactNo("B_00001");
        baseDO.setLicenseCode("9AA0668EEFCA61283EE2FB2FC4C20AC5");
        baseDO.setAppSecret("9fed115e3b6d6971bc93011b861e1095");
        baseDO.setTimestamp(DateUtil.getCurrentTime());
        baseDO.setSysReqSn("compare2photos");
        baseDO.setPactTradeNo("**协议授权流水号**");
        baseDO.setConnectTimeout(60000);
        baseDO.setReadTimeout(60000);
        baseDO.setBizContent(compareVO);
        ResponseDO responseDO = CompareCheck.compareAi(baseDO);
        log.info("<------------分割线------------>");
        log.info(responseDO.toString());
        log.info("msg"+responseDO.getJyResponse().getMsg());
    }
    //服务不可用
    public void testCompare1(){
        //业务信息实体
        Compare1VO compare1VO = new Compare1VO();
        compare1VO.setIdPhoto(Base64ImgUtil.GetImageStr("D:\\jy\\photo\\2.jpeg"));
        compare1VO.setDataPhoto(Base64ImgUtil.GetImageStr("D:\\jy\\photo\\photo.jpg"));
        //基础信息实体
        BaseDO<Compare1VO> baseDO = new BaseDO<>();
        baseDO.setUrl("https://47.102.255.5:8443/dat/compareAll_v1/ai");
        baseDO.setSceneCode("01");
        baseDO.setPactNo("B_00001");
        baseDO.setLicenseCode("7A7ADE28688E4045B09F6F58C2C5CBBD");
        baseDO.setAppSecret("37CB62037D5A43B0B2C5CF73CD5D74BD");
        baseDO.setTimestamp(DateUtil.getCurrentTime());
        baseDO.setSysReqSn("CompareAll_V1");
        baseDO.setPactTradeNo("**协议授权流水号**");
        baseDO.setConnectTimeout(60000);
        baseDO.setReadTimeout(60000);
        baseDO.setBizContent(compare1VO);
        ResponseDO responseDO = CompareCheck.compareAiV1(baseDO);
        log.info("<------------分割线------------>");
        log.info(responseDO.toString());
        log.info("msg"+responseDO.getJyResponse().getMsg());
    }
    //服务不可用
    public void testCompare2(){
        //业务信息实体
        Compare2VO compare2VO = new Compare2VO();
        compare2VO.setAntiHacker("1");
        compare2VO.setName("谢海");
        compare2VO.setIdCard("340123199506125476");
        compare2VO.setDataPhoto(Base64ImgUtil.GetImageStr("D:\\jy\\photo\\photo.jpg"));
        //基础信息实体
        BaseDO<Compare2VO> baseDO = new BaseDO<>();
        baseDO.setUrl("https://47.102.255.5:8443/dat/compareAll_v2/cer");
        baseDO.setSceneCode("02");
        baseDO.setPactNo("B_00001");
        baseDO.setLicenseCode("E00CE39E6ACD45809FEEC2A64DA7D8B5");
        baseDO.setAppSecret("26146B7BBA4B4E2CACD56BA435F0F8EF");
        baseDO.setTimestamp(DateUtil.getCurrentTime());
        baseDO.setSysReqSn("CompareAll_V2");
        baseDO.setPactTradeNo("**协议授权流水号**");
        baseDO.setConnectTimeout(60000);
        baseDO.setReadTimeout(60000);
        baseDO.setBizContent(compare2VO);
        ResponseDO responseDO = CompareCheck.compareAiV2(baseDO);
        log.info("<------------分割线------------>");
        log.info(responseDO.toString());
        log.info("msg"+responseDO.getJyResponse().getMsg());
    }
    //服务不可用
    public void testCompare3(){
        //业务信息实体
        Compare3VO compare3VO = new Compare3VO();
        compare3VO.setAntiHacker("1");
        compare3VO.setName("谢海");
        compare3VO.setIdCard("340123199506125476");
        compare3VO.setDataPhoto(Base64ImgUtil.GetImageStr("D:\\jy\\photo\\photo.jpg"));
        compare3VO.setIdPhoto(Base64ImgUtil.GetImageStr("D:\\jy\\photo\\1.jpeg"));
        //基础信息实体
        BaseDO<Compare3VO> baseDO = new BaseDO<>();
        baseDO.setUrl("https://47.102.255.5:8443/dat/compareAll_v3/cer");
        baseDO.setSceneCode("02");
        baseDO.setPactNo("B_00001");
        baseDO.setLicenseCode("74CD6157A15447D399458F6712A6F27A");
        baseDO.setAppSecret("0CAD7D36D9D24E4D886A4A651E3CA0F0");
        baseDO.setTimestamp(DateUtil.getCurrentTime());
        baseDO.setSysReqSn("CompareAll_V3");
        baseDO.setPactTradeNo("195217014761979904");
        baseDO.setConnectTimeout(60000);
        baseDO.setReadTimeout(60000);
        baseDO.setBizContent(compare3VO);
        ResponseDO responseDO = CompareCheck.compareAiV3(baseDO);
        log.info("<------------分割线------------>");
        log.info(responseDO.toString());
        log.info("msg"+responseDO.getJyResponse().getMsg());
    }


}
