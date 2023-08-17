package shantanu.io.BookMyBook.ServiceLayer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shantanu.io.BookMyBook.Repositories.AuthorRepository;
import shantanu.io.BookMyBook.models.Author;

@Service
public class AuthorService {
    @Autowired
    AuthorRepository authorRepository;

    public String addAuthor(Author author){

        return "author added successfully";
    }
}
