package shantanu.io.BookMyBook.models;


import shantanu.io.BookMyBook.ENUMS.CardStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import shantanu.io.BookMyBook.ENUMS.CardStatus;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "card")

@Getter
@Setter
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cardNo;

    @CreationTimestamp
    private Date CreatedOn;

    @UpdateTimestamp
    private Date UpdatedOn;

    @Enumerated(value = EnumType.STRING)
    private CardStatus cardStatus;

//    mapped for student[as parent]-card[as child]
    @OneToOne
    @JoinColumn
    private Student student;

// mapped for card - book
    @OneToMany(mappedBy = "card", cascade = CascadeType.ALL)
    // creating list - because we've to store book's used for 1 card
     List<Book> bookIssued = new ArrayList<>();

    public Card(){}

    public Card(int cardNo, Date createdOn, Date updatedOn, CardStatus cardStatus, Student student, List<Book> bookIssued) {
        this.cardNo = cardNo;
        CreatedOn = createdOn;
        UpdatedOn = updatedOn;
        this.cardStatus = cardStatus;
        this.student = student;
        this.bookIssued = bookIssued;
    }
}
