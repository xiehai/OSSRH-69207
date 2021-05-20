package com.junyufr.iservice.pojo.vo.video;

import com.alibaba.fastjson.annotation.JSONField;
import com.junyufr.iservice.pojo.vo.idcard.IdCard2VO;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @ClassName VideoV2BO
 * @Description Ⅰ类数字证书+视频V2
 * @Author zhanggongzheng
 * @Date 2020/10/14 13:54
 * @Version 1.0
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class Video2VO extends IdCard2VO {

    /**
     * 视频Base64
     */
    @JSONField(name = "base_video")
    private String baseVideo;

}
