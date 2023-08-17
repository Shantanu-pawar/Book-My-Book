package shantanu.io.BookMyBook.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import shantanu.io.BookMyBook.models.Student;

@Repository
public interface StudentRepository extends JpaRepository <Student, Integer> {

}
