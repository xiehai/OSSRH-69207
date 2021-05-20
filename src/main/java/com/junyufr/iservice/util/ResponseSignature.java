package com.junyufr.iservice.util;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @ClassName ResponseSignature
 * @Description 对响应数据进签名
 * @Author luzhiyu
 * @Date 2019/6/13 12:39
 * @Version 1.0
 */

public class ResponseSignature {

    /**
     * 生成响应签名
     *
     * @param jyResponse
     * @return
     */
    public static String generateSign(JSONObject jyResponse) {
        try {
            JSONObject resultJson = new JSONObject(true);
            jsonSort(resultJson, jyResponse, null, null);
            String result = resultJson.toJSONString();
            result = result.replace("\\n", "");
            result = result.replace("\\t", "");
            return JYMD5.MD5Encoder(result, "utf-8");
        } catch (Exception e) {

        }
        return null;
    }

    /**
     * json排序
     *
     * @param resultJson 结果集
     * @param srcJson    原始json
     * @param subKey     子级key
     * @param subJson    子级value
     */
    public static void jsonSort(JSONObject resultJson, JSONObject srcJson, String subKey, JSONObject subJson) {
        if (null == resultJson || srcJson == null) {
            return;
        }
        List<String> keys = new ArrayList<>(srcJson.keySet());
        Collections.sort(keys);
        for (String key : keys) {
            Object obj = srcJson.get(key);
            if (obj instanceof JSONObject) {
                JSONObject jsonObject = new JSONObject(true);
                jsonSort(resultJson, (JSONObject) obj, key, jsonObject);
                obj = jsonObject;
            }
            if (StringUtils.isEmpty(subKey)) {
                resultJson.put(key, obj);
            } else {
                subJson.put(key, obj);
            }
        }
    }

}
