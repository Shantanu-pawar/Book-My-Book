package shantanu.io.BookMyBook.Controllers;

import lombok.extern.slf4j.Slf4j;
import org.hibernate.id.IntegralDataTypeHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import shantanu.io.BookMyBook.RequestDTO.UpdateNameAndPenNameRequest;
import shantanu.io.BookMyBook.ServiceLayer.AuthorService;
import shantanu.io.BookMyBook.models.Author;

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
    public String updateAuthorNameAndPenName(@RequestBody UpdateNameAndPenNameRequest updateNameAndPenNameRequest){
        // we used Request DTO's to solve the long endpoints problems
        // and avoid the exposing information in query params in URL
        try{
            String result = authorService.updateAuthorNameAndPenName(updateNameAndPenNameRequest);
            return result;
        }
        catch (Exception e){
            return "Author ID is invalid" + e.getMessage();
        }
    }

    @GetMapping("/getAuthor")
    public Author getAuthor(@RequestParam("authorId") int authorId){
        return authorService.getAuthorById(authorId);
    }

    @DeleteMapping("/id")
    public ResponseEntity<String> deleteAuthor(@PathVariable int authorId){

        boolean isDeleted = authorService.deleteAuthorById(authorId);
        if(isDeleted){
            return new ResponseEntity<>("Author deleted successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Author not found", HttpStatus.NOT_FOUND);
        }
    }
}
