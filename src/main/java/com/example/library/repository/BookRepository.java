package com.example.library.repository;

import com.example.library.model.Book;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository  // Marks this as a Data Access Layer component
public class BookRepository {

    private List<Book> books = new ArrayList<>();

    public BookRepository() {
        // Initialize with some sample data
        books.add(new Book("1", "The Great Gatsby", "F. Scott Fitzgerald"));
        books.add(new Book("2", "1984", "George Orwell"));
        books.add(new Book("3", "To Kill a Mockingbird", "Harper Lee"));
    }

    public List<Book> findAll() {
        return new ArrayList<>(books);  // Return copy
    }

    public Optional<Book> findById(String id) {
        return books.stream()
                .filter(book -> book.getId().equals(id))
                .findFirst();
    }

    public Book save(Book book) {
        books.add(book);
        return book;
    }

    public boolean delete(String id) {
        return books.removeIf(book -> book.getId().equals(id));
    }

    public List<Book> findByAuthor(String author) {
        return books.stream()
                .filter(book -> book.getAuthor().equalsIgnoreCase(author))
                .toList();
    }
}