package com.billion.boot.control;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.annotation.MultipartConfig;
import javax.sound.midi.Soundbank;
import java.io.File;
import java.io.IOException;

/**
 * @author Billion
 * @create 2021/03/24 19:13
 */
@Controller
public class FileUploadController {
    @ResponseBody
    @PostMapping("/reg")
    public String saveFiles(@RequestPart("imgHeader") MultipartFile imgHeader,
                            @RequestPart("photos") MultipartFile[] photos){
        int age = 10 / 0;
        if(!imgHeader.isEmpty()){
            System.out.println("imgHeader.size = " + imgHeader.getSize());
            String filename = imgHeader.getOriginalFilename();
            try {
                imgHeader.transferTo(new File("F://cache//imgHeader//" + filename));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if(photos.length > 0){
            for (MultipartFile photo: photos){
                if(!photo.isEmpty()){
                    System.out.println(photo.getSize());
                    String filename = photo.getOriginalFilename();
                    try {
                        photo.transferTo(new File("F://cache//photos//" + filename));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return "上传成功";
    }
}
