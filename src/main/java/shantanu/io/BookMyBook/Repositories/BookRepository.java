package shantanu.io.BookMyBook.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import shantanu.io.BookMyBook.models.Book;

@Repository
public interface BookRepository extends JpaRepository <Book ,Integer> {
}
