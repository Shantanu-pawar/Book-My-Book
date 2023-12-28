package shantanu.io.BookMyBook.ServiceLayer;

import jakarta.transaction.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shantanu.io.BookMyBook.ENUMS.CardStatus;
import shantanu.io.BookMyBook.ENUMS.TransactionStatus;
import shantanu.io.BookMyBook.ENUMS.TransactionType;
import shantanu.io.BookMyBook.Repositories.BookRepository;
import shantanu.io.BookMyBook.Repositories.LibraryCardRepository;
import shantanu.io.BookMyBook.Repositories.TransactionRepository;
import shantanu.io.BookMyBook.RequestDTO.AddCardRequest;
import shantanu.io.BookMyBook.RequestDTO.TransactionRequest;
import shantanu.io.BookMyBook.models.Book;
import shantanu.io.BookMyBook.models.LibraryCard;
import shantanu.io.BookMyBook.models.Transactions;

import java.util.Optional;


@Service
public class TransactionService {

    @Autowired private TransactionRepository transactionRepository;
    @Autowired private BookRepository bookRepository;
    @Autowired private LibraryCardRepository cardRepository;

    public String issueBook(TransactionRequest transaction){

        Book book = bookRepository.findById(transaction.getBookId()).get();
        LibraryCard card = cardRepository.findById(transaction.getCardId()).get();

        Transactions tran = new Transactions();

        tran.setCreatedAt(transaction.getCreatedAt());
        tran.setUpdateAt(transaction.getUpdateAt());
        tran.setTransactionStatus(transaction.getTransactionStatus());
        tran.setTransactionType(transaction.getTransactionType());
        tran.setFineAmount(transaction.getFineAmount());

        tran.setBook(book);
        tran.setLibraryCard(card);

        transactionRepository.save(tran);
        return "Transaction status updated";
    }

}