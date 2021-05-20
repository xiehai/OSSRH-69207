package com.junyufr.iservice.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.DigestUtils;
import org.springframework.util.StringUtils;

/**
 * @author liujinlei
 * @version 2.0
 * @description MD5工具类
 * @date 2019/9/3 10:08
 */
@Slf4j
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class JyDigestUtils {

    /**
     * base64字符替换
     */
    private static final String BASE64_CHAR_ADD = "+";
    public static final String BASE64_CHAR_REDUCE = "-";
    private static final String BASE64_CHAR_DIVIDE = "/";
    public static final String BASE64_CHAR_UNDERLINE = "_";

    /**
     * md5加密
     *
     * @param data
     * @return
     */
    public static String encodeByMd5(String data) {
        return DigestUtils.md5DigestAsHex(data.getBytes());
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
