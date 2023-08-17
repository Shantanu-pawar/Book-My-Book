package shantanu.io.BookMyBook.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import shantanu.io.BookMyBook.models.Card;

@Repository
public interface CardRepository extends JpaRepository<Card, Integer> {
}
