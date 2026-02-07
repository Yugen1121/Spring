package com.example.Database.respositories;

import com.example.Database.domain.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRespository extends CrudRepository<Book, String> {
}
