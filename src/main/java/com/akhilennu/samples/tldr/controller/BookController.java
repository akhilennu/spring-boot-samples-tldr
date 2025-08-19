package com.akhilennu.samples.tldr.controller;

import com.akhilennu.samples.tldr.exception.BookNotFoundException;
import com.akhilennu.samples.tldr.model.Book;
import com.akhilennu.samples.tldr.service.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getBook(@PathVariable Long id) {
        return bookService.findById(id)
                .map(ResponseEntity::ok)
                .orElseThrow(() -> new BookNotFoundException("Book not found with id: " + id));
    }

    @PostMapping
    public ResponseEntity<Book> createBook(@RequestBody Book book) {
        return ResponseEntity.ok(bookService.save(book));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable Long id, @RequestBody Book updated) {
        return bookService.findById(id)
                .map(book -> {
                    book.title = updated.title;
                    book.author = updated.author;
                    return ResponseEntity.ok(bookService.save(book));
                })
                .orElseThrow(() -> new BookNotFoundException("Book not found with id: " + id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
        bookService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

