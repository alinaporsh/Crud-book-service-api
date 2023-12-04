package libraryAPI.example.CRUDapplication.controller;

import libraryAPI.example.CRUDapplication.model.Book;
import libraryAPI.example.CRUDapplication.repository.BookRepository;
import libraryAPI.example.CRUDapplication.service.BookService;
import libraryAPI.example.CRUDapplication.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/books/library")
public class LibraryController {

    private final LibraryService libraryService;

    @Autowired
    public LibraryController(LibraryService libraryService) {
        this.libraryService = libraryService;
    }


    @PostMapping("/{id}/take")
    public ResponseEntity<Book> takeBook(@PathVariable Long id) {
        try {
            Book borrowedBook = libraryService.borrowBook(id);
            return ResponseEntity.ok(borrowedBook);
        } catch (IllegalStateException e) {
            return ResponseEntity.badRequest().body(null); // Handle the case where the book cannot be borrowed
        }
    }

    @PostMapping("/{id}/return")
    public ResponseEntity<Book> returnBook(@PathVariable Long id) {
        try {
            Book returnedBook = libraryService.returnBook(id);
            return ResponseEntity.ok(returnedBook);
        } catch (IllegalStateException e) {
            return ResponseEntity.badRequest().body(null); // Handle the case where the book cannot be returned
        }
    }


}
