package com.junyufr.iservice;

import com.alibaba.fastjson.JSON;
import com.junyufr.iservice.pojo.BaseDO;
import com.junyufr.iservice.pojo.ResponseDO;
import com.junyufr.iservice.util.ClientUtil;
import com.junyufr.iservice.util.JyDigestUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

/**
 * @ClassName BaseCheck
 * @Description BaseCheck
 * @Author xiehai
 * @Date 2021/5/19 15:49
 * @Version 1.0
 */
@Slf4j
public class BaseCheck {
    /**
     * 发送接口请求
     * @param baseDO
     * @param params
     * @return
     * @throws Exception
     */
    public static ResponseDO post(BaseDO baseDO,String params) throws Exception {
        ResponseDO responseDO;
        String result = ClientUtil.post(baseDO.getUrl(), params,baseDO.getConnectTimeout(),baseDO.getReadTimeout());
        responseDO = JSON.parseObject(result,ResponseDO.class);
        return responseDO;
    }

    /**
     * 验签
     * @param responseDO
     */
    public static boolean checkSign(ResponseDO responseDO) {
        String sign = responseDO.getSign();
        String result = JyDigestUtils.encodeByMd5(JSON.toJSONString(responseDO.getJyResponse()));
        if(!sign.equals(result)){
            return false;
        }
        return true;
    }

    /**
     * 验证入参
     * @param baseDO
     */
    public static boolean checkParam(BaseDO baseDO) {
        if(StringUtils.isBlank(baseDO.getUrl())){
             return false;
        }
        if(StringUtils.isBlank(baseDO.getAppSecret())){
            return false;
        }
        if(null==baseDO.getConnectTimeout()){
            return false;
        }
        if(null==baseDO.getReadTimeout()){
            return false;
        }
        return true;
    }

}
