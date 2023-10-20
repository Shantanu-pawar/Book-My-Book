package shantanu.io.BookMyBook.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import shantanu.io.BookMyBook.ENUMS.TransactionStatus;
import shantanu.io.BookMyBook.ENUMS.TransactionType;

import java.util.Date;
import java.util.UUID;

@Data
@Entity
@Table(name="transactions")
@AllArgsConstructor
@NoArgsConstructor

public class Transactions {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int transactionId;

    @CreationTimestamp
    private Date createdAt;

    @UpdateTimestamp
    private Date updateAt;

    @Enumerated(value = EnumType.STRING)
    private TransactionStatus transactionStatus;

    @Enumerated(value = EnumType.STRING)
    private TransactionType transactionType;

    private int fineAmount;

    // mapped by - book as parent - transaction as a child
    @ManyToOne
    @JsonIgnore
    @JoinColumn private Book book;

    // library card as parent - transaction as child [ cause we can do multiple transac on one card]
    @ManyToOne @JoinColumn
    @JsonIgnore
    private LibraryCard libraryCard;
}
