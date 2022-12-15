package com.example.hotdogsru_maven.Controllers;

import com.example.hotdogsru_maven.Service.NeiroModel;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.view.RedirectView;
import org.tensorflow.SavedModelBundle;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

@Controller
@RequestMapping("/")
public class GeneralController {
    NeiroModel neiroModel = new NeiroModel();
    SavedModelBundle model = neiroModel.init();
    String path = "/tmp/server/HotDogs/loaded.jpg";
    public GeneralController() throws IOException {
//        File theDir = new File("/src/main/resources/images");
//        if (!theDir.exists()){
//            theDir.mkdirs();
//        }
        new File("/tmp/server/HotDogs").mkdirs();
        System.out.println("Default picture path: " + path);
        System.out.println("Testing model...");
        String str = neiroModel.getAnswer("src/main/resources/images/1.jpg", model);
        if(str == "Beagle"){
            System.out.println("Test Done!");
        }
        else{
            System.out.println("Test Fail!");
        }
    }

//    @GetMapping(produces = MediaType.TEXT_HTML_VALUE)
    @GetMapping("/")
    public String sendIndexPage() {
        System.out.println("send index.html");
        return "index.html";
    }

    @GetMapping(value = "/result", produces = MediaType.TEXT_HTML_VALUE)
    public String sendResultPage(){
        return "result.html";
    }

//    @RequestMapping(value = "/", produces = MediaType.TEXT_HTML_VALUE)
//    public String index2(){
//        System.out.println("send index.html");
//        return "index.html";
//    }

    @GetMapping(value = "/ErrorFile", produces = MediaType.TEXT_HTML_VALUE)
    public String sendErrorFilePage(){
        return "errorDownloadFile.html";
    }

//    @GetMapping(value = "/index.html", produces = MediaType.TEXT_HTML_VALUE)
//    public String index(){
//        System.out.println("send index.html");
//        return "index.html";
//    }

    @GetMapping(value = "/ErrorNoFile", produces = MediaType.TEXT_HTML_VALUE)
    public String sendErrorNoFilePage(){
        return "errorNoFile.html";
    }

    @GetMapping(value = "/error", produces = MediaType.TEXT_HTML_VALUE)
    public String sendErrorPage(){
        return "errorDownloadFile.html";
    }

    @RequestMapping(value = "/uploading", method = RequestMethod.POST)
    public RedirectView provideInfo(@RequestParam("file") MultipartFile file) throws FileNotFoundException {
        if(!file.isEmpty()){
            try {
                file.transferTo(new File(path));
                System.out.println("File loaded "+file.getOriginalFilename());

                String str = neiroModel.getAnswer(path, model);
                System.out.println("Prediction: picture is " + str);
                System.out.println("Redirect to result.html and add arg="+str);
                return new RedirectView("/result?arg="+str);
            } catch (Exception e){
                System.out.println(e);
                System.out.println("Redirect to ErrorFile.html");
                return new RedirectView("/ErrorFile");
            }
        } else {
            System.out.println("Redirect to ErrorNoFile.html");
            return new RedirectView("/ErrorNoFile");
        }
    }
}