package libraryAPI.example.CRUDapplication.repository;

import jakarta.persistence.SequenceGenerator;
import libraryAPI.example.CRUDapplication.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

//Layer responsible for data access hence we name it repository
//we want to use repo interface inside service layer, using dependency injection
@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    //SELECT * FROM book where isbn = ?
    //we can also use query
    //we can annotate @QUERY
   // @Query("SELECT b FROM Book b where b.isbn = ?1")
    Optional<Book> findBookByIsbn(String isbn);


}
