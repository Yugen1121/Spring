package com.example.Database.dao.impl;

import com.example.Database.TestDataUtil;
import com.example.Database.domain.Author;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.jdbc.core.JdbcTemplate;

import static com.example.Database.TestDataUtil.CreateTestAuthor;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class AuthorDaoImplTests{

    @Mock
    private JdbcTemplate jdbcTemplate;

    @InjectMocks
    private AuthorDaoImpl underTest;

    @Test
    public void TestTheAuthorGeneratesCorrectSql(){
        Author author = CreateTestAuthor();
        underTest.create(author);
        verify(jdbcTemplate).update(
                eq("INSERT INTO author (id, name, age) VALUES(?, ?, ?)"),
                eq(1L), eq("Yugen"), eq(30)
        );
    }

    @Test
    public void TestTheFindOneGeneratesCorrectSql(){

        underTest.findOne(1L);
        verify(jdbcTemplate).query(
                eq("SELECT id, name, age FROM author WHERE id = ? LIMIT 1"),
                ArgumentMatchers.<AuthorDaoImpl.AuthorRowMapper>any(),
                eq(1L)
                );
    }


    @Test
    public void TestThatFindManyGeneratesCorrectSql(){
        underTest.find();
        verify(jdbcTemplate).query(eq("SELECT id, name, age FROM author"),
                ArgumentMatchers.<AuthorDaoImpl.AuthorRowMapper>any()
                );
    }

    @Test
    public void TestThatUpdateGeneratesCorrectSql(){
        Author author = CreateTestAuthor();
        underTest.update(4L, author);
        verify(jdbcTemplate).update(
                eq("UPDATE author SET id = ?, name = ?, age = ? WHERE id = ?"),
                eq(1L), eq("Yugen"), eq(30), eq(4L)

        );
    }

    @Test
    public void TestThatDeleteGeneratesCorrectSql(){
        Author author = CreateTestAuthor();
        underTest.delete(1L);

        verify(jdbcTemplate).update(
                eq("DELETE FROM author WHERE id = ?"),
                eq(1L)
        );
    }

}
