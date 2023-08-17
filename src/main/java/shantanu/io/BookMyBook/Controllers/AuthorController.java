package shantanu.io.BookMyBook.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import shantanu.io.BookMyBook.ServiceLayer.AuthorService;
import shantanu.io.BookMyBook.models.Author;

@RestController
public class AuthorController {

    @Autowired
    AuthorService authorService;

    @PostMapping("/add")
    public String addAuthor(Author author){
        return authorService.addAuthor(author);
    }
}
