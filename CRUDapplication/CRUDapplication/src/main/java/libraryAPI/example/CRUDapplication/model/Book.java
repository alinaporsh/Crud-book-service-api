package libraryAPI.example.CRUDapplication.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String isbn;
    private String name;
    private String genre;
    private String description;
    private String author;
    private boolean Taken;
    private LocalDateTime takenTime;
    private LocalDateTime returnTime;

    public Book() {
    }

    public Book(String isbn, String name, String genre, String description, String author) {
        this.isbn = isbn;
        this.name = name;
        this.genre = genre;
        this.description = description;
        this.author = author;
    }

    public Book(Long id, String isbn, String name, String genre, String description, String author) {
        this.id = id;
        this.isbn = isbn;
        this.name = name;
        this.genre = genre;
        this.description = description;
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", isbn='" + isbn + '\'' +
                ", name='" + name + '\'' +
                ", genre='" + genre + '\'' +
                ", description='" + description + '\'' +
                ", author='" + author + '\'' +
                '}';
    }

    //getters & setters which can be summarized using lombok


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public LocalDateTime getTakenTime() {
        return takenTime;
    }

    public void setTakenTime(LocalDateTime takenTime) {
        this.takenTime = takenTime;
    }

    public LocalDateTime getReturnTime() {
        return returnTime;
    }

    public void setReturnTime(LocalDateTime returnTime) {
        this.returnTime = returnTime;
    }

    public boolean Taken() {
        return Taken;
    }

    public void setTaken(boolean taken) {
        Taken = taken;
    }
}
