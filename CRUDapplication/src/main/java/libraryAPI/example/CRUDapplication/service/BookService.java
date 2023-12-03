package libraryAPI.example.CRUDapplication.service;

import libraryAPI.example.CRUDapplication.model.Book;
import libraryAPI.example.CRUDapplication.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

//we need to instantiate Bookservice as a spring bean because we used it and autowired
// in the controller layer, hence we add annotation @component but since it is a service we instead
// use service annotation
@Service
public class BookService {

    private final BookRepository bookRepository;
    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> getBooks(){
       return bookRepository.findAll();
    }


    public Optional<Book> getBookByIsbn(String isbn) {
        return bookRepository.findBookByIsbn(isbn);
    }

    public Optional<Book> getBookById(Long id) {
        return bookRepository.findById(id);
    }

    public void addNewBook(Book book){
        Optional<Book> bookOptional = bookRepository
                .findBookByIsbn(book.getIsbn());
        if (bookOptional.isPresent()){
            throw new IllegalStateException("ISBN ALREADY EXISTS");
        }
        bookRepository.save(book);

    }

    public boolean deleteBook(Long id) {
        // Check if the book exists
        if (bookRepository.existsById(id)) {
            // Delete the book if it exists
            bookRepository.deleteById(id);
            return true; // Deletion successful
        } else {
            return false; // Book not found, deletion unsuccessful
        }
    }
}
