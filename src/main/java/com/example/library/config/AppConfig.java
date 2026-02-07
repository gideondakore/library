package com.example.library.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.beans.factory.annotation.Value;

@Configuration  // Marks this as a configuration class
@PropertySource("classpath:library.properties")  // Load properties file
public class AppConfig {

    @Value("${library.name}")  // Inject value from properties file
    private String libraryName;

    @Value("${library.max.books:100}")  // Default value if property not found
    private int maxBooks;

    @Bean  // Define a bean manually (alternative to @Component)
    public String libraryInfo() {
        return String.format("Library: %s, Max Books: %d", libraryName, maxBooks);
    }

    @Bean
    public String welcomeMessage() {
        return "Welcome to the Spring Library System!";
    }

    // You could define additional beans here if needed
    // @Bean
    // public SomeService someService() {
    //     return new SomeService();
    // }
}