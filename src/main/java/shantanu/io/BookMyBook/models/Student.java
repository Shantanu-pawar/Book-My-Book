package shantanu.io.BookMyBook.models;


import jakarta.persistence.*;
import lombok.*;
import shantanu.io.BookMyBook.ENUMS.Department;
import shantanu.io.BookMyBook.ENUMS.Gender;

@Entity
@Table(name = "student")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Student {

    @Id // used for saying it's a primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int rollNo;

    private String name;

    private int age;

    @Enumerated(value = EnumType.STRING)
    private Gender gender;

    @Enumerated(value = EnumType.STRING)
    private Department department;

    @Column(unique = true)
    private String email;

    @OneToOne(mappedBy = "student", cascade = CascadeType.ALL)
    private LibraryCard libraryCard;
}
