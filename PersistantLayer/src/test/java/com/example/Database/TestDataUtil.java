package com.example.Database;

import com.example.Database.domain.Author;
import com.example.Database.domain.Book;

public final class TestDataUtil {

    private TestDataUtil() {
    }

    public static Author CreateTestAuthorA() {
        return Author.builder()
                .name("Dhee")
                .age(40)
                .build();
    }

    public static Author CreateTestAuthorB() {
        return Author.builder()
                .name("Shivesh")
                .age(30)
                .build();
    }


    public static Author CreateTestAuthorC() {
        return Author.builder()
                .name("Abhinav")
                .age(30)
                .build();
    }

    public static Author CreateTestAuthor() {
        return Author.builder()
                .name("Yugen")
                .age(60)
                .build();
    }


    public static Book CreateTestBook(final Author author) {
        Book book = Book.builder()
                .isbn("123")
                .title("Hello world!")
                .author(author)
                .build();
        return book;
    }

    public static Book CreateTestBookA(final Author author) {
        Book book = Book.builder()
                .isbn("122")
                .title("Iam me!")
                .author(author)
                .build();
        return book;
    }

    public static Book CreateTestBookB(final Author author) {
        Book book = Book.builder()
                .isbn("121")
                .title("Hello world!")
                .author(author)
                .build();
        return book;
    }

    public static Book CreateTestBookC(final Author author) {
        Book book = Book.builder()
                .isbn("120")
                .title("Hello world!")
                .author(author)
                .build();
        return book;
    }

}


