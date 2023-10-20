package shantanu.io.BookMyBook.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import shantanu.io.BookMyBook.models.LibraryCard;

public interface LibraryCardRepository extends JpaRepository<LibraryCard, Integer> {
}
