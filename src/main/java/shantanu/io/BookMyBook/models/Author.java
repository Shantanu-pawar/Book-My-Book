package shantanu.io.BookMyBook.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "author")

@Getter
@Setter
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private int age;
    private String city;
    private String rating;

//    mapping author as [parent] - book[as child]
    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL)
//    since we've to store the author who write all the books name that's why we're using list

    private List<Book> booksWritten = new ArrayList<>();  // if it's one to one then we'll choose to write [private Book book;]

    
    public Author(int id, String name, int age, String city, String rating, List<Book> booksWritten) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.city = city;
        this.rating = rating;
        this.booksWritten = booksWritten;
    }
}
