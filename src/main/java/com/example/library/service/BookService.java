package com.example.library.service;

import com.example.library.model.Book;
import com.example.library.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service  // Marks this as a Business Logic Layer component
public class BookService {

    private final BookRepository bookRepository;

    // Constructor Injection (RECOMMENDED)
    // @Autowired is optional in newer Spring versions for single constructors
    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
        System.out.println("BookService created with BookRepository!");
    }

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Book getBookById(String id) {
        return bookRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Book not found with id: " + id));
    }

    public Book addBook(Book book) {
        // Business logic: validate book
        if (book.getTitle() == null || book.getTitle().trim().isEmpty()) {
            throw new RuntimeException("Book title cannot be empty");
        }


        return bookRepository.save(book);
    }

    public boolean borrowBook(String id) {
        Book book = getBookById(id);
        if (book.isAvailable()) {
            book.setAvailable(false);
            return true;
        }
        return false;
    }

    public boolean returnBook(String id) {
        Book book = getBookById(id);
        if (!book.isAvailable()) {
            book.setAvailable(true);
            return true;
        }
        return false;
    }

    public List<Book> searchByAuthor(String author) {
        return bookRepository.findByAuthor(author);
    }

    public String getLastId(){
        return String.valueOf(bookRepository.findAll().size() + 1);
    }
}