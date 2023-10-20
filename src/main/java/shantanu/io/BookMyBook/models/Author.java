package shantanu.io.BookMyBook.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "author")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int authorId;

    private String name;
    private String emailId;
    private int age;
    private String penName;

    // author as parent - book as child
    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL)
    @JsonIgnore
    // creating list - because we've to store book's that written by one author which stored in this list
    private List<Book> bookList = new ArrayList<>();


    /*Note about :: @JsonIgnore
     this annotation is basically ignores a specific method during serialisation and de-serialisation

     serialisation : is the process of converting obj data from one format to another that can be easily
     stored, reconstructed and transmitted. [ in this contest spring convert java obj into JSON format ]

     de-serialisation : is the reverse process of serialisation */

}
