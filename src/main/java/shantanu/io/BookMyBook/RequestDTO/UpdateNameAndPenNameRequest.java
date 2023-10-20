package shantanu.io.BookMyBook.RequestDTO;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Data
public class UpdateNameAndPenNameRequest {

    private int authorId;
    private String newName;
    private String newPenName;

}
