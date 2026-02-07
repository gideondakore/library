package com.example.library.controller;

import com.example.library.model.Book;
import com.example.library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController  // Combines @Controller + @ResponseBody for REST APIs
@RequestMapping("/api/books")  // Base URL for all endpoints in this controller
public class LibraryController {

    private final BookService bookService;

    // Constructor Injection
    @Autowired
    public LibraryController(BookService bookService) {
        this.bookService = bookService;
        System.out.println("LibraryController created with BookService!");
    }

    // GET /api/books
    @GetMapping
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    // GET /api/books/{id}
    @GetMapping("/{id}")
    public Book getBook(@PathVariable String id) {
        return bookService.getBookById(id);
    }

    // POST /api/books
    @PostMapping
    public Book addBook(@RequestBody Book book) {
        return bookService.addBook(book);
    }

    // PUT /api/books/{id}/borrow
    @PutMapping("/{id}/borrow")
    public String borrowBook(@PathVariable String id) {
        boolean success = bookService.borrowBook(id);
        return success ? "Book borrowed successfully" : "Book is not available";
    }

    // PUT /api/books/{id}/return
    @PutMapping("/{id}/return")
    public String returnBook(@PathVariable String id) {
        boolean success = bookService.returnBook(id);
        return success ? "Book returned successfully" : "Book was already available";
    }

    // GET /api/books/search
    @GetMapping("/search")
    public List<Book> searchByAuthor(@RequestParam String author) {
        return bookService.searchByAuthor(author);
    }
}