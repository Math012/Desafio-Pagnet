package com.math012.projectpagNet.controller;

import com.math012.projectpagNet.service.CnabService;
import com.math012.projectpagNet.service.FormatedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping(value = "api/pagnet/v1")
public class Controller {
    @Autowired
    private CnabService cnabService;

    @Autowired
    private FormatedService formatedService;

    @GetMapping
    public String welcome(){
        return "BEM VINDO";
    }

    @PostMapping(value = "/upload")
    public String upload(@RequestParam("file")MultipartFile file) throws Exception {
        var filename = cnabService.uploadCnabDocument(file);
        return formatedService.formatingDocument(filename);
    }

}
