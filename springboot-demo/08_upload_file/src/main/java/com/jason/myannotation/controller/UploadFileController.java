package com.jason.myannotation.controller;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;

@Controller
public class UploadFileController {

    //Save the uploaded file to this folder
    @Value("${uploadFile.tmpPath}")
    private String UPLOADED_FOLDER;

    @Value("${spring.servlet.multipart.max-file-size}")
    private String testOfConfigVal;

    @GetMapping("/upload")
    public String toUploadPage(){
        System.out.println("testOfConfigVal: " + testOfConfigVal);
        return "upload";
    }

    @PostMapping("/upload")
    public String singleFileUpload(@RequestParam("upFile") MultipartFile file,
                                   RedirectAttributes redirectAttributes){
        if (file.isEmpty()) {
            redirectAttributes.addFlashAttribute("message", "Please select a file to upload");
            return "redirect:uploadStatus";
        }

        try {
            byte[] bytes = file.getBytes();
            String filePath = UPLOADED_FOLDER + new Date().getTime() + "_" + file.getOriginalFilename();
            Path path = Paths.get(filePath);
            System.out.println("Debug UPLOADED_FOLDER: " + UPLOADED_FOLDER);
            System.out.println("Debug filePath: " + filePath);
            System.out.println("Debug path: " + path);

            Files.write(path, bytes);
            redirectAttributes.addFlashAttribute("message",
                    "You successfully uploaded: " + path);
        }catch (IOException e){
            e.printStackTrace();
        }

        return "redirect:/uploadStatus";
    }

    @GetMapping("/uploadStatus")
    public String uploadStatus() {
        return "uploadStatus";
    }
}
