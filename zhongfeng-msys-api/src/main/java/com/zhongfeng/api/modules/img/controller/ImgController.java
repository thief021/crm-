package com.zhongfeng.api.modules.img.controller;

import com.zhongfeng.api.modules.img.service.Imgservice;
import com.zhongfeng.api.modules.utils.pojo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ClassUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.UUID;


/**
 * <p>描述:   图片和视频上传和查看。</p>
 * <p>文件名称: Controller.java</p>
 * <p>创建时间: 2022-07-08 </p>
 * @author 万笑佛
 * @since 2022-07-08
 */

@RestController
@Slf4j
@RequestMapping("/api/image")
public class ImgController {

    @Autowired
    Imgservice imgservice;

    /**
     * 图片上传。
     *
     * @param
     * @return JSONObject
     */
    @PostMapping(value = "/upload")
    public Result imageUpload(@RequestParam MultipartFile file, HttpServletRequest request){
        return imgservice.saveImg(file, request);
    }


    /**
     * 图片查看。
     *
     * @return String
     */
    @GetMapping("/look")
    public String imageLook(HttpServletResponse response) {

        File file = new File("D:\\test\\image\\1.png");
        byte[] bytes = new byte[1024];
        try (OutputStream os = response.getOutputStream();
             FileInputStream fis = new FileInputStream(file)) {
            while ((fis.read(bytes)) != -1) {
                os.write(bytes);
                os.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "success";
    }


}