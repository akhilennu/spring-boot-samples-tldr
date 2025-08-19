package com.akhilennu.samples.tldr.service;

import com.akhilennu.samples.tldr.model.Book;
import java.util.Optional;

public interface BookService {
    Optional<Book> findById(Long id);
    Book save(Book book);
    void deleteById(Long id);
}
