package com.example.library;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication  // Enables Spring Boot auto-configuration
public class LibraryApplication {

    public static void main(String[] args) {
        // This starts the Spring application
        ApplicationContext context = SpringApplication.run(LibraryApplication.class, args);

        // Demonstrate bean retrieval
        System.out.println("\n=== Spring Beans Created ===");
        System.out.println("BookRepository bean: " + context.getBean("bookRepository"));
        System.out.println("BookService bean: " + context.getBean("bookService"));
        System.out.println("LibraryController bean: " + context.getBean("libraryController"));
        System.out.println("Library Info: " + context.getBean("libraryInfo"));
        System.out.println("Welcome Message: " + context.getBean("welcomeMessage"));

        System.out.println("\n=== Library System Started ===");
        System.out.println("Access the API at: http://localhost:8080/api/books");
    }
}