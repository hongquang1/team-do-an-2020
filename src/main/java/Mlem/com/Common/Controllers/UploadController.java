package Mlem.com.Common.Controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import Mlem.com.Common.Services.CloudinaryService;

@Controller
public class UploadController {

    @Autowired
    private CloudinaryService cloudinaryService;
    
//    public String home() {
//    	
//    }

    @RequestMapping(value = "/upload",method = RequestMethod.POST)
    @ResponseBody
    public String uploadFile(@RequestParam("file") MultipartFile file) {
        String url = cloudinaryService.uploadFile(file);
        return url;
    }
    
//    @RequestMapping(value = "/upload",method = RequestMethod.POST)
//    @ResponseBody
//    public String uploadFile(String filePath) {
//       return filePath;
//    }
    
    @RequestMapping("/choise")
    public String choiseFile() {
    	return "upload";
    }
}
