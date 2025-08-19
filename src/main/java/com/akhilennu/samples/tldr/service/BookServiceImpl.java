package com.akhilennu.samples.tldr.service;

import com.akhilennu.samples.tldr.model.Book;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class BookServiceImpl implements BookService {

    private final Map<Long, Book> bookStore = new ConcurrentHashMap<>();
    private final AtomicLong nextId = new AtomicLong(1L);

    @Override
    public Optional<Book> findById(Long id) {
        return Optional.ofNullable(bookStore.get(id));
    }

    @Override
    public Book save(Book book) {
        if (book.id == null) {
            book.id = nextId.getAndIncrement();
        }
        bookStore.put(book.id, book);
        return book;
    }

    @Override
    public void deleteById(Long id) {
        bookStore.remove(id);
    }
}
