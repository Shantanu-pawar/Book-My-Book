package shantanu.io.BookMyBook.RequestDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateEmailAndAuthorDto {

    private int authorId;
    private String name;
    private String emailId;
    private int age;
    private String penName;
}
