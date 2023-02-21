package com.zhongfeng.api.modules.img.mapper;

import com.zhongfeng.api.modules.img.vo.Img;

/**
 * 图片mapper
 */
public interface ImgMapper {

    /**
     * 保存图片
     *
     */
    int saveImg(String imgName);

    /**
     * 查询图片
     */
    Integer queryImg(String imgName);

    /**
     * 查询自增长id
     */
    Integer queryId();
}
