package com.example.Database.dao.impl;

import com.example.Database.dao.AuthorDao;
import com.example.Database.domain.Author;
import com.example.Database.domain.Book;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.Optional;

import static com.example.Database.TestDataUtil.*;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class BookDaoImplIntegrationTests {

    private final AuthorDao authorDao;
    private final BookDaoImpl underTest;

    @Autowired
    public BookDaoImplIntegrationTests(final BookDaoImpl underTest, final AuthorDao authorDao){
        this.underTest = underTest;
        this.authorDao = authorDao;
    }

    @Test
    public void testTheBookCanBeCreatedAndRecalled(){
        Author author = CreateTestAuthor();
        authorDao.create(author);
        Book book = CreateTestBook();
        underTest.create(book);
        Optional<Book> result = underTest.findOne(book.getIsbn());
        assertThat(result.isPresent());
        assertThat(result.get()).isEqualTo(book);
    }

    @Test
    public void TestThatMultipleBooksCanBeCreatedAndRecalled(){
        Author A = CreateTestAuthor();
        Author B = CreateTestAuthorA();
        Author C = CreateTestAuthorB();
        Author D = CreateTestAuthorC();
        authorDao.create(A);
        authorDao.create(B);
        authorDao.create(C);
        authorDao.create(D);

        Book a = CreateTestBook();
        Book b = CreateTestBookA();
        Book c = CreateTestBookB();
        Book d = CreateTestBookC();

        underTest.create(a);
        underTest.create(b);
        underTest.create(c);
        underTest.create(d);
        List<Book> results = underTest.find();

        assertThat(results)
                .hasSize(4)
                .containsExactly(a,b,c,d);

    }

    public void TestThatBookCanBeUpdated(){
        Author a = CreateTestAuthor();
        Author b = CreateTestAuthorA();
        authorDao.create(a);
        authorDao.create(b);

        Book A = CreateTestBook();
        Book B = CreateTestBookA();
        underTest.create(A);

        underTest.update("123", B);

        Optional<Book> result = underTest.findOne("122");

        assertThat(result.isPresent());
        assertThat(result).isEqualTo(B);

    }

    @Test
    public void TestThatBookCanBeDeleted(){
        Author author = CreateTestAuthor();
        authorDao.create(author);
        Book book = CreateTestBook();
        underTest.create(book);
        underTest.delete(book.getIsbn());

        Optional<Book> result = underTest.findOne(book.getIsbn());

        assertThat(result).isEmpty();
    }



}
