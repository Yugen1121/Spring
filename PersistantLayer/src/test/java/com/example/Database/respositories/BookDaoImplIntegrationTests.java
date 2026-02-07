
package com.example.Database.respositories;

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

    private final AuthorRepository authorRepo;
    private final BookRespository underTest;

    @Autowired
    public BookDaoImplIntegrationTests(final BookRespository underTest, final AuthorRepository authorDao) {
        this.underTest = underTest;
        this.authorRepo = authorDao;
    }

    @Test
    public void testTheBookCanBeCreatedAndRecalled() {
        Author author = CreateTestAuthor();
        authorRepo.save(author);
        Book book = CreateTestBook(author);
        underTest.save(book);
        Optional<Book> result = underTest.findById(book.getIsbn());
        assertThat(result.isPresent());
        assertThat(result.get()).isEqualTo(book);
    }

    @Test
    public void TestThatMultipleBooksCanBeCreatedAndRecalled() {
        Author A = CreateTestAuthor();
        Author B = CreateTestAuthorA();
        Author C = CreateTestAuthorB();
        Author D = CreateTestAuthorC();
        authorRepo.save(A);
        authorRepo.save(B);
        authorRepo.save(C);
        authorRepo.save(D);

        Book a = CreateTestBook(A);
        Book b = CreateTestBookA(B);
        Book c = CreateTestBookB(C);
        Book d = CreateTestBookC(D);

        underTest.save(a);
        underTest.save(b);
        underTest.save(c);
        underTest.save(d);
        Iterable<Book> results = underTest.findAll();

        assertThat(results)
                .hasSize(4)
                .containsExactly(a, b, c, d);

    }

    @Test
    public void TestThatBookCanBeUpdated() {
        Author a = CreateTestAuthor();
        Author b = CreateTestAuthorA();
        authorRepo.save(a);
        authorRepo.save(b);

        Book A = CreateTestBook(a);

        underTest.save(A);
        A.setAuthor(b);

        underTest.save(A);
        Optional<Book> result = underTest.findById(A.getIsbn());

        assertThat(result.isPresent());
        assertThat(result.get()).isEqualTo(A);
    }


    @Test
    public void TestThatBookCanBeDeleted() {
        Author author = CreateTestAuthor();
        authorRepo.save(author);
        Book book = CreateTestBook(author);
        underTest.save(book);
        underTest.deleteById(book.getIsbn());

        Optional<Book> result = underTest.findById(book.getIsbn());

        assertThat(result).isEmpty();
    }

    @Test
    public void TestThatBookByAuthor(){
        Author a = CreateTestAuthor();
        Author b = CreateTestAuthorA();
        authorRepo.save(a);
        authorRepo.save(b);

        Book A = CreateTestBook(a);
        Book B = CreateTestBookA(a);
        Book C = CreateTestBookB(a);
        Book D = CreateTestBookC(b);

        underTest.save(A);
        underTest.save(B);
        underTest.save(C);
        underTest.save(D);

        Iterable<Book> result = underTest.BookByAuthor(a.getId());

        assertThat(result).containsExactly(A,B,C);

    }
}



