package com.example.hotdogsru_maven;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.view.RedirectView;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
@SpringBootApplication
public class HotDogsRuMavenApplication {

    public static void main(String[] args) {
        SpringApplication.run(HotDogsRuMavenApplication.class, args);
    }

}
