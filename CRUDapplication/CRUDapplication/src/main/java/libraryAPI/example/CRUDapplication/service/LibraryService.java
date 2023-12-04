package libraryAPI.example.CRUDapplication.service;

import jakarta.persistence.EntityNotFoundException;
import libraryAPI.example.CRUDapplication.model.Book;
import libraryAPI.example.CRUDapplication.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class LibraryService {
    private final BookRepository bookRepository;

    @Autowired
    public LibraryService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Book borrowBook(Long bookId) {
        Book book = bookRepository.findById(bookId)
                .orElseThrow(() -> new EntityNotFoundException("Book not found"));

        if (book.Taken()) {
            throw new IllegalStateException("Book is already taken");
        }

        book.setTaken(true);
        book.setTakenTime(LocalDateTime.now());
        book.setReturnTime(null); // Reset return time when borrowed

        bookRepository.save(book);
        return book;
    }

    public Book returnBook(Long bookId) {
        Book book = bookRepository.findById(bookId)
                .orElseThrow(() -> new EntityNotFoundException("Book not found"));

        if (!book.Taken()) {
            throw new IllegalStateException("Book is not currently taken");
        }

        book.setTaken(false);
        book.setReturnTime(LocalDateTime.now());

        bookRepository.save(book);
        return book;
    }



}
