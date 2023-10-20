package shantanu.io.BookMyBook.models;


import lombok.Data;
import shantanu.io.BookMyBook.ENUMS.CardStatus;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "card")
@Data
public class LibraryCard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cardNo;

    @Enumerated(value = EnumType.STRING)
    private CardStatus cardStatus;

    private int noOfBooksIssued;

    // we've to mapped this card with student
    @OneToOne
    @JoinColumn
    private Student student;

    // library card as parent - transcastion as child [ cause we can do multiple transac on one card]
    @OneToMany(mappedBy = "libraryCard" ,cascade = CascadeType.ALL)
    private List<Transactions> transactionsList = new ArrayList<>();
}
