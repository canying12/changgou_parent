package com.changgou.file.controller;

import com.changgou.entity.Result;
import com.changgou.entity.StatusCode;
import com.changgou.file.pojo.FastDFSFile;
import com.changgou.file.util.FastDFSClient;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @author 残影
 * @date 2020/5/12 14:51
 */
@RestController
@CrossOrigin
public class FileController {
    @PostMapping("/upload")
    public Result upload(@RequestParam MultipartFile file){
        String path = "";
        try {
            path=saveFile(file);
            System.out.println(path);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new Result(true, StatusCode.OK,"文件长传成功",path);
    }

    public String saveFile(MultipartFile file) throws IOException {
        //1.获取文件的名字
        String filename = file.getOriginalFilename();
        //2.获取文件的内容
        byte[] content = file.getBytes();
        //3.获取文件的扩展名
        String ext = "";
        if (!StringUtils.isEmpty(filename)){
            ext = filename.substring(filename.lastIndexOf(".")+1);
        }
        //4.创建文件实体类对象
        FastDFSFile fastDFSFile = new FastDFSFile(filename, content, ext);
        //5.上传
        String[] uploadResults = FastDFSClient.upload(fastDFSFile);
        //6. 拼接上传后的文件的完整路径和名字, uploadResults[0]为组名, uploadResults[1]为文件名称和路径
        String path = FastDFSClient.getTrackerUrl()+uploadResults[0]+"/"+uploadResults[1];
        return path;
    }


}
