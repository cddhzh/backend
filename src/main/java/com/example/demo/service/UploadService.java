package com.example.demo.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

public class UploadService {
    public String uploadImg(MultipartFile multipartFile, String dir){
        File targetFile = new File(""+dir);
        try {
            if(!targetFile.exists()) targetFile.mkdirs();
            multipartFile.transferTo(targetFile);
            return "ok";
        } catch (IOException e) {
            e.printStackTrace();
            return "fail";
        }
    }
}
