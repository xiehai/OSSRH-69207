package com.junyufr.iservice.pojo.vo.video;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

/**
 * @ClassName VideoV1VO
 * @Description 视频V1
 * @Author xiehai
 * @Date 2021/5/19 21:39
 * @Version 1.0
 */
@Data
public class Video1VO {
    /**
     * 视频Base64
     */
    @JSONField(name = "base_video")
    private String baseVideo;

    /**
     * 身份证翻拍照
     */
    @JSONField(name = "id_photo")
    private String idPhoto;

    /**
     * 姓名
     */
    @JSONField(serialize = false)
    private String name;

    /**
     * 身份证号码
     */
    @JSONField(serialize = false)
    private String idCard;

}
