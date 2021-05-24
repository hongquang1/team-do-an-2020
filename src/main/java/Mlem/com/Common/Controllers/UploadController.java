package Mlem.com.Common.Controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import Mlem.com.Common.Services.CloudinaryService;

@RestController
public class UploadController {

    @Autowired
    private CloudinaryService cloudinaryService;
    
//    public String home() {
//    	
//    }

    @PostMapping("/upload")
    public String uploadFile(@RequestParam("file") MultipartFile file) {
        String url = cloudinaryService.uploadFile(file);
        return "File uploaded successfully: File path :  " + url;
    }
}
