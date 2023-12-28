package shantanu.io.BookMyBook.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import shantanu.io.BookMyBook.models.Author;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Integer> {

}
