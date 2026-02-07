/*
package com.example.Database.respositories;

import com.example.Database.dao.AuthorDao;
import com.example.Database.domain.Author;
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
import static org.springframework.test.web.servlet.result.StatusResultMatchersExtensionsKt.isEqualTo;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class AuthorDaoImplIntegrationTests {

    private AuthorDaoImpl underTest;
    @Autowired
    private AuthorDao authorDao;

    @Autowired
    public AuthorDaoImplIntegrationTests(AuthorDaoImpl underTest){
        this.underTest = underTest;
    }



    @Test
    public void TestThatAuthorCanBeCreatedAndRetrieved(){
        Author author = CreateTestAuthor();
        underTest.create(author);
        Optional<Author> result = underTest.findOne(author.getId());
        assertThat(result.isPresent());
        assertThat(result.get()).isEqualTo(author);
    }

    @Test
    public void TestThatMultipleAuthorsCanBeCreatedAndRecalled(){
        Author a = CreateTestAuthor();
        Author b = CreateTestAuthorA();
        Author c = CreateTestAuthorB();
        Author d = CreateTestAuthorC();
        underTest.create(a);
        underTest.create(b);
        underTest.create(c);
        underTest.create(d);
        List<Author> results = underTest.find();
        assertThat(results)
                .hasSize(4)
                .containsExactly(a, b, c, d);
    }

    @Test
    public void TestThatAuthorCanBeUpdated(){
        Author a = CreateTestAuthor();
        Author b = CreateTestAuthorA();

        underTest.create(a);


        underTest.update(1L, b);

        Optional<Author> result = underTest.findOne(2L);

        assertThat(result.isPresent());
        assertThat(result.get()).isEqualTo(b);
    }

    @Test
    public void TestThatAuthorCanBeDeleted(){
        Author author = CreateTestAuthor();

        underTest.create(author);

        underTest.delete(author.getId());

        Optional<Author> result = underTest.findOne(author.getId());

        assertThat(result).isEmpty();
    }

}*/
