package shantanu.io.BookMyBook.Repositories;

import org.hibernate.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import shantanu.io.BookMyBook.models.Transactions;

@Repository
public interface TransactionRepository extends JpaRepository<Transactions, Integer> {

}
