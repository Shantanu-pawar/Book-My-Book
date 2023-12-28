package shantanu.io.BookMyBook.RequestDTO;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import shantanu.io.BookMyBook.ENUMS.TransactionStatus;
import shantanu.io.BookMyBook.ENUMS.TransactionType;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransactionRequest {

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

    private int bookId;
    private int cardId;
}
