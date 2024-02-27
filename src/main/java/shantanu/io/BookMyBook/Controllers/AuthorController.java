package shantanu.io.BookMyBook.Controllers;

import lombok.extern.slf4j.Slf4j;
import org.apache.coyote.Response;
import org.hibernate.id.IntegralDataTypeHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import shantanu.io.BookMyBook.RequestDTO.UpdateEmailAndAuthorDto;
import shantanu.io.BookMyBook.RequestDTO.UpdateNameAndPenNameRequest;
import shantanu.io.BookMyBook.ResponceDTO.AuthorResponseDto;
import shantanu.io.BookMyBook.ServiceLayer.AuthorService;
import shantanu.io.BookMyBook.models.Author;
import shantanu.io.BookMyBook.models.Book;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("author")
@Slf4j

public class AuthorController {
    @Autowired
    private AuthorService authorService;

    @PostMapping("/add")
    public ResponseEntity<String> addAuthor(@RequestBody Author author){
        try{
            String res = authorService.addAuthor(author);
            return new ResponseEntity<>(res, HttpStatus.OK);
        }
        catch (Exception e){
            log.error("error Occurred, can't add author in DB. {}", e.getMessage());
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/updateNameAndPenName")
    public String updateAuthorNameAndPenName(@RequestBody UpdateNameAndPenNameRequest update){
        // we used Request DTO to solve the long endpoints problems
        // and avoid the exposing information in query params in URL
        try{
            return authorService.updateAuthorNameAndPenName(update);
        }
        catch (Exception e){
            return e.getMessage();
        }
    }

    @GetMapping("/getAuthor")
    public Author getAuthor(@RequestParam("authorId") int authorId){
        return authorService.getAuthorById(authorId);
    }

    @GetMapping("/getAuthorWithCustomParams/{id}")
    public ResponseEntity<?> getAuthorCustomResponse (@PathVariable("id") int authorId){
        try{
            AuthorResponseDto author = authorService.getAuthor(authorId);
            return new ResponseEntity<>(author, HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/deleteAuthor/{id}")
    public ResponseEntity<String> deleteAuthor(@PathVariable("id") int authorId){

        boolean isDeleted = authorService.deleteAuthorById(authorId);
        if(isDeleted)
            return new ResponseEntity<>("Author deleted successfully", HttpStatus.OK);

        else return new ResponseEntity<>("Author not found", HttpStatus.NOT_FOUND);
    }


    @GetMapping("/getBookListUsingAuthorId")
    public ResponseEntity<String> getBookListUsingAuthorId(@RequestParam("id") int authorId){
        try{
            List<Book> list = authorService.getBookListUsingAuthorId(authorId);
            return new ResponseEntity(list, HttpStatus.OK);
        }
        catch (Exception e){
            log.error("Author ID is not registered" + e.getMessage());
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
