package shantanu.io.BookMyBook.RequestDTO;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import shantanu.io.BookMyBook.ENUMS.CardStatus;
import shantanu.io.BookMyBook.ENUMS.Department;
import shantanu.io.BookMyBook.ENUMS.Gender;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddStudentWithCardRequest {

    @Id // used for saying it's a primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int rollNo;

    private String name;

    private int age;

    private Gender gender;

    private Department department;

    private String email;

    // now adding card with student
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cardNo;

    @Enumerated(value = EnumType.STRING)
    private CardStatus cardStatus;

    private int StudentRollNo;
}
