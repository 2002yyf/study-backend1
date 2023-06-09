package com.example.study.controller;


import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
@RestController
@RequestMapping("/file")
public class FileUploadController{

    private static final String UPLOAD_DIR = "file";

    @PostMapping("/upload")
    public String uploadFile(@RequestParam("file") MultipartFile file) {
        if (!file.isEmpty()) {
            try {
                String fileName = StringUtils.cleanPath(file.getOriginalFilename());
                Path uploadPath = Paths.get(UPLOAD_DIR).toAbsolutePath().normalize();

                // 确保文件夹存在，如果不存在则创建
                Files.createDirectories(uploadPath);

                // 将文件保存到指定的文件夹
                Path targetPath = uploadPath.resolve(fileName);
                Files.copy(file.getInputStream(), targetPath, StandardCopyOption.REPLACE_EXISTING);

                return "文件上传成功";
            } catch (Exception e) {
                return "文件上传失败: " + e.getMessage();
            }
        } else {
            return "文件为空";
        }
    }

    @GetMapping("/files/{filename}")
        public ResponseEntity<Resource> getFile(@PathVariable String filename) {
            try {
                Path filePath = Paths.get(UPLOAD_DIR).toAbsolutePath().normalize().resolve(filename);
                File file = filePath.toFile();

                if (file.exists()) {
                    Resource resource = new FileSystemResource(file);

                    HttpHeaders headers = new HttpHeaders();
                    headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + filename);
                    headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);

                    return ResponseEntity.ok()
                            .headers(headers)
                            .body(resource);
                } else {
                    return ResponseEntity.notFound().build();
                }
            } catch (Exception e) {
                return ResponseEntity.badRequest().build();
            }
        }
    @GetMapping("/download")
    public void download(String name, HttpServletResponse response){

        try {
            //输入流，通过输入流读取文件内容
            FileInputStream fileInputStream = new FileInputStream(new File(name));

            //输出流，通过输出流将文件写会浏览器，在浏览器展示图片了
            ServletOutputStream outputStream = response.getOutputStream();

            response.setContentType("image/jpeg");

            int len=0;
            byte[] bytes = new byte[1024];
            while ((len=fileInputStream.read(bytes))!=-1){
                outputStream.write(bytes,0,len);
                outputStream.flush();
            }
            //关闭资源
            outputStream.close();
            fileInputStream.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
