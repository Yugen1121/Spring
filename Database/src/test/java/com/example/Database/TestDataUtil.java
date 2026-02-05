package com.example.Database;

import com.example.Database.domain.Author;
import com.example.Database.domain.Book;

public final class TestDataUtil {

    private TestDataUtil() {
    }

    public static Author CreateTestAuthorA() {
        return Author.builder()
                .id(2L)
                .name("Dhee")
                .age(40)
                .build();
    }

    public static Author CreateTestAuthorB() {
        return Author.builder()
                .id(3L)
                .name("Shivesh")
                .age(30)
                .build();
    }


    public static Author CreateTestAuthorC() {
        return Author.builder()
                .id(4L)
                .name("Abhinav")
                .age(30)
                .build();
    }

    public static Author CreateTestAuthor() {
        return Author.builder()
                .id(1L)
                .name("Yugen")
                .age(30)
                .build();
    }


    public static Book CreateTestBook() {
        Book book = Book.builder()
                .isbn("123")
                .title("Hello world!")
                .authorId(1L)
                .build();
        return book;
    }

    public static Book CreateTestBookA() {
        Book book = Book.builder()
                .isbn("122")
                .title("Iam me!")
                .authorId(2L)
                .build();
        return book;
    }

    public static Book CreateTestBookB() {
        Book book = Book.builder()
                .isbn("121")
                .title("Hello world!")
                .authorId(1L)
                .build();
        return book;
    }

    public static Book CreateTestBookC() {
        Book book = Book.builder()
                .isbn("120")
                .title("Hello world!")
                .authorId(1L)
                .build();
        return book;
    }
}
