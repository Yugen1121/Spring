package com.example.Database.dao.impl;

import com.example.Database.TestDataUtil;
import com.example.Database.domain.Book;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.jdbc.core.JdbcTemplate;

import static com.example.Database.TestDataUtil.*;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;


@ExtendWith(MockitoExtension.class)
public class BookDaoImplTest {

    @Mock
    private JdbcTemplate jdbcTemplate;

    @InjectMocks
    private BookDaoImpl underTest;

    @Test
    public void TestTheBookGeneratesCorrectSql(){

        Book book = CreateTestBook();

        underTest.create(book);
        verify(jdbcTemplate).update(
                eq("INSERT INTO Books(isbn, title, authorId) VALUES(?, ?, ?)"),
                eq("123"),
                eq("Hello world!"),
                eq(1L)
        );
    }

    @Test
    public void TestTheFirstOneGeneratesCorrectSql(){
        underTest.findOne("123");
        verify(jdbcTemplate).query(
                eq("SELECT isbn, title, authorId FROM books WHERE isbn = ? LIMIT 1"),
                ArgumentMatchers.<BookDaoImpl.BookRowMapper>any(),
                eq("123")
        );
    }

    @Test
    public void TestTheManyGeneratesCorrectSql(){
        underTest.find();
        verify(jdbcTemplate).query(
                eq("SELECT isbn, title, author_id FROM books"),
                ArgumentMatchers.<BookDaoImpl.BookRowMapper>any()
        );
    }

    @Test
    public void TestThatUpdateGeneratedCorrectSql(){
        Book a = CreateTestBook();
        Book b = CreateTestBookA();

        underTest.create(a);

        underTest.update("123", b);


        verify(jdbcTemplate).update(
                eq("UPDATE books SET isbn = ?, title = ?, author_id = ? WHERE isbn = ?"),
                eq(b.getIsbn()),
                eq(b.getTitle()),
                eq(b.getAuthorId()),
                eq(a.getIsbn())
        );

    }

    @Test
    public void TestThatDeleteGeneratesCorrectSql(){
        Book book = CreateTestBook();

        underTest.create(book);

        underTest.delete(book.getIsbn());

        verify(jdbcTemplate).update(
                eq("DELETE FROM books WHERE isbn = ?"),
                eq("123")
        );
    }

}
