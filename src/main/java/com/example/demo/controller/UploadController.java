package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

@RestController
@RequestMapping("/upload")
public class UploadController {

    @Value(("${file.uploadFolder}"))
    private String uploadFolder;
    @Value(("${file.staticPath}"))
    private String staticPath;

    @PostMapping("/file/{dir}")
    @ResponseBody
    public String uploadImg(@RequestParam("file") MultipartFile multipartFile, @PathVariable("dir") String dir){
        if(multipartFile.isEmpty()){
            return "文件有误";
        }
        try {
            //获得上传的文件名
            String realFileName = multipartFile.getOriginalFilename();
            //拿到文件名后缀，如.jpg
            String imgSuffix = realFileName.substring(realFileName.lastIndexOf("."));
            //将文件名改写
            String newFileName = UUID.randomUUID().toString()+imgSuffix;
            //设置日期目录
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
            String dataPath = dateFormat.format(new Date());
            //指定文件上传的目录，加了日期目录，并生成文件夹
            String serverPath = uploadFolder;
            File targetFile = new File(serverPath+dir, dataPath);
            if(!targetFile.exists()) targetFile.mkdirs();
            //指定上传以后的服务器的完整文件名
            File targetFileName = new File(targetFile, newFileName);
            //文件上传到指定目录
            multipartFile.transferTo(targetFileName);
            String filename = dir+'/'+dataPath+'/'+newFileName;
            return staticPath+"/uploading/"+filename;
        } catch (IOException e) {
            e.printStackTrace();
            return "fail";
        }
    }
}
