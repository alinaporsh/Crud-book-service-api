package libraryAPI.example.CRUDapplication.controller;
//this layer will have all resources for api

import libraryAPI.example.CRUDapplication.model.Book;
import libraryAPI.example.CRUDapplication.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

//this is the api layer aka the controller for books
//api layer should take to service layer to get some data and service layer should talk to
// data access layer
@RestController
//localhost:8080/api/books
@RequestMapping(path = "api/books")
public class BookController {
    private final BookService bookService;

    //we add autowried because bookservice is an instance of  the controller layer and to avoid adding
    //new BookService() we autowire it
   @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    //here we put the getmapping to recieve list of all booka
    @GetMapping
    public ResponseEntity<List<Book>> getBooks() {
        List<Book> books = bookService.getBooks();

        // Return a response entity with the list of books
        return ResponseEntity.ok(books);
    }


    @GetMapping("/isbn/{isbn}")
    public ResponseEntity<Book> getBookByIsbn(@PathVariable String isbn) {
        Optional<Book> book = bookService.getBookByIsbn(isbn);
        return book.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }


    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable Long id) {
        return bookService.getBookById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
    @PostMapping
    public ResponseEntity<String> addNewBook(@RequestBody Book book) {
        try {
            bookService.addNewBook(book);
            return ResponseEntity.status(HttpStatus.CREATED).body("Book added successfully");
        } catch (IllegalStateException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
        // Call the service method to delete the book
        boolean deleted = bookService.deleteBook(id);

        if (deleted) {
            // Return a response entity with a status code of 204 (No Content) for a successful deletion
            return ResponseEntity.noContent().build();
        } else {
            // Return a response entity with a status code of 404 (Not Found) if the book is not found
            return ResponseEntity.notFound().build();
        }
    }
}

