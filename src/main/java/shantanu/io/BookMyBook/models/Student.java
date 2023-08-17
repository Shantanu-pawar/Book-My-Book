package shantanu.io.BookMyBook.models;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "student")

@Getter
@Setter
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @Column(unique = true)
    private String email;

    private int age;
    private String mobileNo;
    private String city;

  // student-card
    @OneToOne(mappedBy = "student", cascade = CascadeType.ALL)
    private Card card;


    public Student(){}

    public Student(int id, String name, String email, int age, String mobileNo, String city, Card card) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.age = age;
        this.mobileNo = mobileNo;
        this.city = city;
        this.card = card;
    }
}
