package com.pedzich.aleksandra.library.controllers;

import com.pedzich.aleksandra.library.dto.BookDTO;
import com.pedzich.aleksandra.library.models.Book;
import com.pedzich.aleksandra.library.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping
    ResponseEntity<List<Book>> findAll() {
        return ResponseEntity.ok().body(bookService.findAll());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Book> findById(@PathVariable Integer id) {
        return ResponseEntity.ok().body(bookService.findById(id));
    }

    @PostMapping
    ResponseEntity<Book> save(@RequestBody BookDTO bookDTO) {
        Book book = bookService.save(bookDTO);
        return ResponseEntity.status(201).body(book);
    }

    @PatchMapping(path = "/{id}")
    ResponseEntity<Void> update(@PathVariable Integer id, @RequestBody BookDTO bookDTO) {
        bookDTO.setId(id);
        bookService.update(bookDTO);
        return ResponseEntity.status(202).build();
    }

    @DeleteMapping(path = "/{id}")
    ResponseEntity<Void> delete(@PathVariable Integer id) {
        bookService.delete(id);
        return ResponseEntity.status(204).build();
    }
}
