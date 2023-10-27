package shantanu.io.BookMyBook.RequestDTO;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import shantanu.io.BookMyBook.ENUMS.Genre;

import java.util.Date;

@Data
@NoArgsConstructor

public class AddBookRequestDto {

    private String title;

    // Boolean is an obj wrapper
    private String isAvailable;
    private Genre genre;
    private Date publicationDate;
    private Integer price;

    // we can also send author id as DTO
    private Integer authorId;

}
