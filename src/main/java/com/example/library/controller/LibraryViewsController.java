package com.example.library.controller;

import com.example.library.model.Book;
import com.example.library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/api/books/views")
public class LibraryViewsController {
    private final BookService service;

    @Autowired
    LibraryViewsController(BookService service){
        this.service = service;
    }


    @GetMapping
    List<Book> getAllBooks(){
        return service.getAllBooks();
    }

    @GetMapping("/old-way")
    public String oldWay() {
        return "books/list";  // Returns view name for HTML template
    }


}
