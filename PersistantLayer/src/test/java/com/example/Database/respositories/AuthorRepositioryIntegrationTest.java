
package com.example.Database.respositories;

import com.example.Database.domain.Author;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import static com.example.Database.TestDataUtil.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.result.StatusResultMatchersExtensionsKt.isEqualTo;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class AuthorRepositioryIntegrationTest {

    private AuthorRepository underTest;


    @Autowired
    public AuthorRepositioryIntegrationTest(AuthorRepository underTest) {
        this.underTest = underTest;
    }


    @Test
    public void TestThatAuthorCanBeCreatedAndRetrieved() {
        Author author = CreateTestAuthor();
        underTest.save(author);
        Optional<Author> result = underTest.findById(author.getId());
        assertThat(result.isPresent());
        assertThat(result.get()).isEqualTo(author);
    }


    @Test
    public void TestThatMultipleAuthorsCanBeCreatedAndRecalled() {
        Author a = CreateTestAuthor();
        Author b = CreateTestAuthorA();
        Author c = CreateTestAuthorB();
        Author d = CreateTestAuthorC();
        underTest.save(a);
        underTest.save(b);
        underTest.save(c);
        underTest.save(d);
        Iterable<Author> results = underTest.findAll();
        assertThat(results)
                .hasSize(4)
                .containsExactly(a, b, c, d);

    }

    @Test
    public void TestThatAuthorCanBeUpdated() {
        Author a = CreateTestAuthor();

        underTest.save(a);

        a.setName("Hello");
        underTest.save(a);

        Optional<Author> result = underTest.findById(a.getId());

        assertThat(result.isPresent());
        assertThat(result.get()).isEqualTo(a);
    }

    @Test
    public void TestThatAuthorCanBeDeleted(){
        Author author = CreateTestAuthor();

        underTest.save(author);

        underTest.deleteById(author.getId());

        Optional<Author> result = underTest.findById(author.getId());

        assertThat(result).isEmpty();
    }
}




