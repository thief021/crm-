package com.zhongfeng.api.modules.img.service;

import com.zhongfeng.api.modules.utils.pojo.Result;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

public interface Imgservice {
    /**
     * 图片上传
     * @param file
     * @param request
     * @return
     */
    Result saveImg(MultipartFile file, HttpServletRequest request) ;
}
