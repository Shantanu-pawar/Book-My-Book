package shantanu.io.BookMyBook.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import shantanu.io.BookMyBook.ENUMS.Genre;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "book")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bookId;

    @Column(unique = true)
    private String title;

//    checking is available or not
    private String isAvailable;

    @Enumerated(value = EnumType.STRING)
    private Genre genre;

    private Date publicationDate;

    private int price;

    public Book(String title, String isAvailable, Genre genre, Date publicationDate, int price) {
        this.title = title;
        this.isAvailable = isAvailable;
        this.genre = genre;
        this.publicationDate = publicationDate;
        this.price = price;
    }

    // author as parent - book as child
    @ManyToOne
    @JoinColumn @JsonIgnore
    private Author author;

    // mapped by - book as parent - transaction as a child
    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL)
    private List<Transactions> transactionsList = new ArrayList<>();

    public String getIsAvailable() {
        return isAvailable;
    }

    public void setIsAvailable(String isAvailable) {
        this.isAvailable = isAvailable;
    }
}
