package shantanu.io.BookMyBook.RequestDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import shantanu.io.BookMyBook.ENUMS.CardStatus;
import shantanu.io.BookMyBook.models.Student;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddCardRequest {
    private int cardNo;
    private int noOfBooksIssued;
    private CardStatus cardStatus;
    private int studentRollNo;
}
