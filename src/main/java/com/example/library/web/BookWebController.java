package com.example.library.web;

import com.example.library.model.Book;
import com.example.library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/books")
public class BookWebController {

    private final BookService bookService;

    @Autowired
    public BookWebController(BookService service){
        this.bookService = service;
    }

    @GetMapping
    public String getAllBooks(Model model){
        List<Book> books = bookService.getAllBooks();
        model.addAttribute("books", books);
        return "books";
    }

    @GetMapping("/{id}")
    public String getBookPage(@PathVariable("id") String id,  Model model){
        Book book = bookService.getBookById(id);
        model.addAttribute("book", book);
        return "book-detail";
    }


    @GetMapping("/add")
    public String addBook(Model model){
        model.addAttribute("add-book");
        return "add-book";
    }
}
