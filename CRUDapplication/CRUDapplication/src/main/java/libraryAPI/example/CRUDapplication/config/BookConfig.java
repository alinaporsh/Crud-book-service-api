package libraryAPI.example.CRUDapplication.config;

import libraryAPI.example.CRUDapplication.model.Book;
import libraryAPI.example.CRUDapplication.repository.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;


@Configuration
public class BookConfig {

    @Bean
    CommandLineRunner commandLineRunner(
            BookRepository repository) {
        return args -> {
            Book book1 = new Book(
                    "123-44",
                    "The adventures of Tom Sawyer",
                    "Science Fiction",
                    "Tom sawyer goes on an adventure",
                    "Mark Twain"
            );
            Book book2 = new Book(
                    "123-45",
                    "Robinson Crusoe",
                    "Adventure",
                    "Robinson is abandoned on the dessert",
                    "Daniel"
            );
            Book book3 = new Book(


                  "123-46",
                  "Donuts and More",
                  "Educational",
                  "Recipes about donuts",
                  "Mack Sorento"

            );


 //to save in repository the following data we need to use saveall
//we then decided to save book1 and book2 into our repository thats in the Repository Layer
          repository.saveAll(
                  List.of(book1,
                          book2,
                          book3)
          );

        };

    }

}
