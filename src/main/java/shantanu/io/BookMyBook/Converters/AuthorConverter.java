package shantanu.io.BookMyBook.Converters;

import lombok.Data;
import shantanu.io.BookMyBook.RequestDTO.UpdateEmailAndAuthorDto;
import shantanu.io.BookMyBook.ResponceDTO.AuthorResponseDto;
import shantanu.io.BookMyBook.models.Author;

@Data
public class AuthorConverter {

    public static Author convertAuthorDtoToEntity(UpdateEmailAndAuthorDto updateEmailAndAuthorDto){

        Author author = Author.builder()
                .authorId(updateEmailAndAuthorDto.getAuthorId())
                .name(updateEmailAndAuthorDto.getName())
                .emailId(updateEmailAndAuthorDto.getEmailId())
                .age(updateEmailAndAuthorDto.getAge())
                .penName(updateEmailAndAuthorDto.getPenName())
                .build();

        return author;
    }
}
