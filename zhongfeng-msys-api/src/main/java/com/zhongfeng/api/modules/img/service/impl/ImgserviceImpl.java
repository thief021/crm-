package com.zhongfeng.api.modules.img.service.impl;

import com.zhongfeng.api.modules.img.mapper.ImgMapper;
import com.zhongfeng.api.modules.img.service.Imgservice;
import com.zhongfeng.api.modules.utils.pojo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ClassUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

@Service
@Slf4j
public class ImgserviceImpl implements Imgservice {
    
    @Autowired
    ImgMapper imgMapper;

    @Override
    public Result saveImg(MultipartFile file, HttpServletRequest request) {
        //获取项目classes/static的地址
        File imgFile = new File("zhongfeng-msys-api/src/main/resources/static/img/license");
        //静态target目录
        String staticPath = ClassUtils.getDefaultClassLoader().getResource("static").getPath();
        //得到
        staticPath=staticPath+"/img/license";
        log.info(staticPath);
        String path=imgFile.getAbsolutePath();
        log.info(path);
        //获取文件名
        String fileName = file.getOriginalFilename();
        //分割文件名
        String[] split = fileName.split("\\.");
        // 为了防止文件同名给文件名做唯一处理
        Integer imgId = imgMapper.queryId();
        fileName = imgId + "." + split[1];
        // 图片存储目录及图片名称
        String urlPath =  File.separator + fileName;
        String urlPathTarget=File.separator +fileName;
        //图片保存路径
        String savePath = path + File.separator + urlPath;
        String savePathTarget = staticPath + File.separator + urlPathTarget;
        // 访问路径=静态资源路径+文件目录路径
        String visitPath = urlPath;
        File saveFile = new File(savePath);
        File saveFileTarget=new File(savePathTarget);
        if (!saveFileTarget.exists()||!saveFile.exists()) {
            saveFileTarget.mkdirs();
            saveFile.mkdirs();
        }
        try {
            //得到输入流
            file.transferTo(saveFile);
            Files.copy(new File(savePath).toPath(),new File(savePathTarget).toPath(), StandardCopyOption.REPLACE_EXISTING);

        } catch (IOException e) {
            e.printStackTrace();
        }
        imgMapper.saveImg(fileName);
        request.getSession().setAttribute("imgUrl", fileName);
        return Result.setSuccess();
    }
}
