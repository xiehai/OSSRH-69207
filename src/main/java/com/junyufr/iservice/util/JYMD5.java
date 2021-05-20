package com.junyufr.iservice.util;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;

import java.security.MessageDigest;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author liujinlei
 * @version 2.0
 * @description MD5工具类
 * @date 2019/9/3 10:08
 */
public class JYMD5 {

    public static void main(String[] args) {
        System.out.println(MD5Encoder("龚浩"));
        System.out.println(MD5Encoder("652901199211176217"));
    }

    /**
     * base64字符替换
     */
    private static final String BASE64_CHAR_ADD = "+";
    private static final String BASE64_CHAR_REDUCE = "-";
    private static final String BASE64_CHAR_DIVIDE = "/";
    private static final String BASE64_CHAR_UNDERLINE = "_";

    /**
     * md5
     * s:需要md5的字符串
     * charset:编码格式
     */
    public final static String MD5Encoder(String s, String charset) {
        try {
            byte[] btInput = s.getBytes(charset);
            MessageDigest mdInst = MessageDigest.getInstance("MD5");
            mdInst.update(btInput);
            byte[] md = mdInst.digest();
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < md.length; i++) {
                int val = ((int) md[i]) & 0xff;
                if (val < 16) {
                    sb.append("0");
                }
                sb.append(Integer.toHexString(val));
            }
            return sb.toString();
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * md5
     * s:需要md5的字符串
     * 默认编码格式：UTF-8
     */
    public static String MD5Encoder(String s) {
        return MD5Encoder(s, "utf-8");
    }

    /**
     * JDK 1.8 排序方法
     * 参数排序后拼接为字符串
     * obj:需要排序拼接的对象
     */
    public static String getSortJsonStr(JSONObject obj) {
        //1. 判断obj Json对象是否不为null并且是否包含 cutFlag
        if (obj != null && obj.containsKey("cutFlag")) {
            //2. 如果obj Json对象不为null并且包含了 cutFlag ，则清楚key=cutFlag
            obj.remove("cutFlag");
        }
        //3. 取出key的名称，并按字母升序排列
        List<String> keys = obj.keySet().stream().sorted().collect(Collectors.toList());

        //4. value为空不参与加密，将排序好的 obj Json对象转换成A=1,B=2的形式（key1=value1,key2=value2）
        Optional<String> reduce = keys.stream().filter(s -> StringUtils.isNotEmpty(obj.getString(s)))
                //拼接Key = value 字符串
                .map(s -> s + "=" + obj.getString(s))
                //逗号连接  连接多个key = value
                .reduce((str, f) -> str + "," + f);
        //5. 判断optonal是否为空，防止NoSuchElementException异常
        if (reduce != null && reduce.isPresent()) {
            return reduce.get();
        }
        return "";
    }

    /*
     * 获取签名sign方法
     */

    public static String createSignature(JSONObject jsb, String appSecret) {
        //1. 判断传入的json对象是否为null或者是否为空，如果为空返回null
        if (jsb == null || jsb.isEmpty()) return null;

        //2. 先移除key=sign
        jsb.remove("sign");
        //3. 申明 bizContentStr 空字符串
        String bizContentStr = "";

        //4. 判断 jsb Json对象中 biz_content 的 value 是否为空
        if (StringUtils.isNotEmpty(jsb.getString("biz_content"))) {
            //5. 如果不为空，将 biz_content 的 json 对象传入 JYMD5.getSortJsonStr 方法 生成 A=1,B=2的形式
            bizContentStr = JYMD5.getSortJsonStr(jsb.getJSONObject("biz_content"));
        }

        //6. 移除移除key=biz_content
        jsb.remove("biz_content");

        //7. 生成dtoStr，将 jsb Json对象传入 getSortJsonStr 生成A=1,B=2的形式，生成后拼接半角逗号与 bizContentStr
        String dtoStr = JYMD5.getSortJsonStr(jsb) + "," + bizContentStr;

        //8. 将 dtoStr+appSecret以utf-8的编码生成MD5字符串
        String result = JYMD5.MD5Encoder(dtoStr + appSecret, "UTF-8");

        return result;
    }

    /*
     * 获取签名sign方法
     */

    public static String createSignature2(JSONObject jsb, String appSecret) {
        if (jsb == null || jsb.isEmpty()) return null;

        jsb.remove("sign");
        String bizContentStr = "";

        if (StringUtils.isNotEmpty(jsb.getString("biz_content"))) {
            bizContentStr = JYMD5.getSortJsonStr(jsb.getJSONObject("biz_content"));
        }
        jsb.remove("biz_content");
        String dtoStr = JYMD5.getSortJsonStr(jsb) + "," + bizContentStr;
//        System.out.println("1.7dtoStr"+dtoStr);
        String result = JYMD5.MD5Encoder(dtoStr + appSecret, "UTF-8");
//        System.out.printf("加密串--->{2}", result);

        return result;
    }

    /**
     * JDK1.7 sign排序方法
     *
     * @param obj
     * @return
     */
    public static String getSortJsonStr7(JSONObject obj) {
        if (obj != null && obj.containsKey("cutFlag")) {
            obj.remove("cutFlag");
        }
        List<String> keys = new ArrayList<>(obj.keySet());
        Collections.sort(keys, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return s1.compareTo(s2);
            }
        });
        StringBuffer sb = new StringBuffer();
        Iterator<String> iteator = keys.iterator();
        while (iteator.hasNext()) {
            String key = iteator.next();
            sb.append(key + "=" + obj.get(key));
            if (iteator.hasNext()) {
                sb.append(",");
            }
        }
        return sb.toString();
    }

    /**
     * 视频、照片base64中的+替换为-， /替换为_
     *
     * @param base64
     * @return
     */
    public static String encrypt(String base64) {
        if (StringUtils.isEmpty(base64)) {
            return null;
        }
        return base64.replace(BASE64_CHAR_ADD, BASE64_CHAR_REDUCE).replace(BASE64_CHAR_DIVIDE, BASE64_CHAR_UNDERLINE);
    }

    /**
     * 视频、照片base64中的 - 替换为 +， _ 替换为 /
     *
     * @param base64
     * @return
     */
    public static String decrypt(String base64) {
        if (StringUtils.isEmpty(base64)) {
            return null;
        }
        return base64.replace(BASE64_CHAR_REDUCE, BASE64_CHAR_ADD).replace(BASE64_CHAR_UNDERLINE, BASE64_CHAR_DIVIDE);
    }


}
