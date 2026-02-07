package com.example.Database.respositories;

import com.example.Database.domain.Book;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRespository extends CrudRepository<Book, String> {

    @Query("SELECT b FROM Book b WHERE b.author.id = ?1")
    Iterable<Book> BookByAuthor(Long id);
}
