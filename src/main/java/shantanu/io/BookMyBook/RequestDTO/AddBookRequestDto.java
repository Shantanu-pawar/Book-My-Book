package shantanu.io.BookMyBook.RequestDTO;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import shantanu.io.BookMyBook.ENUMS.Genre;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddBookRequestDto {

    private String title;
    private boolean isAvailable;
    private Genre genre;
    private Date publicationDate;
    private int price;

    // we can also send author id as DTO
    private int authorId;
}
