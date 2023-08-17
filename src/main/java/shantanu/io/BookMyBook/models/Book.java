package shantanu.io.BookMyBook.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import shantanu.io.BookMyBook.ENUMS.booksGenre;

@Entity
@Table(name = "book")

@Getter
@Setter
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private int pages;

    @Enumerated(value = EnumType.STRING)
    private booksGenre booksGenre;

    private boolean issued;

//    mapping author as [parent] - book[as child]
    @ManyToOne // many books one author here
    @JoinColumn
    private Author author;

//    mapping book[as child] - card [as parent]
    @ManyToOne
    @JoinColumn
    private Card card;

//   create constructor

    public Book(int id, String name, int pages, shantanu.io.BookMyBook.ENUMS.booksGenre booksGenre, boolean issued, Author author, Card card) {
        this.id = id;
        this.name = name;
        this.pages = pages;
        this.booksGenre = booksGenre;
        this.issued = issued;
        this.author = author;
        this.card = card;
    }
}
