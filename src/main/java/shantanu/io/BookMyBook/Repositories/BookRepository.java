package shantanu.io.BookMyBook.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import shantanu.io.BookMyBook.ENUMS.Genre;
import shantanu.io.BookMyBook.models.Book;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository <Book ,Integer> {
    List<Book> findBookByGenre(Genre genre);

    List<Book> findBooksByIsAvailableFalse();

}
