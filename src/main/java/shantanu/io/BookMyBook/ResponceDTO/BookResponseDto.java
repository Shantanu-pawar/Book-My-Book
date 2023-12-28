package shantanu.io.BookMyBook.ResponceDTO;


import lombok.*;
import shantanu.io.BookMyBook.ENUMS.Genre;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class BookResponseDto {

    private String title;

    private String isAvailable;

    private Genre genre;

    private Date publicationDate;

    private Integer price;

    private Integer authorId;

    private String authorName;

}
