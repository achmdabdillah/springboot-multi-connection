package com.template.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class HomeController {
    @GetMapping
    public String homeController() throws Exception {
        String response;
        try {
            response = "Index Page";
        } catch (Exception e) {
            response = "Koneksi gagal";
            e.printStackTrace();
        }
        return response;
    }
}
