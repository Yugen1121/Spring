package com.example.Database.dao;

import com.example.Database.domain.Author;

import java.util.List;
import java.util.Optional;

public interface AuthorDao {
    void create(Author author);

    Optional<Author> findOne(Long id);

    List<Author>  find();

    void update(Long id, Author authro);


    void delete(Long id);
}
