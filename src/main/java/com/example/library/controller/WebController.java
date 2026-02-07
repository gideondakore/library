package com.example.library.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {

    @GetMapping("/static-books")
    public String booksPage(){
        return "books.html";
    }


}
