package shantanu.io.BookMyBook.ServiceLayer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shantanu.io.BookMyBook.Repositories.BookRepository;
import shantanu.io.BookMyBook.models.Book;

@Service
public class BookService {
    @Autowired
    BookRepository bookRepository;

    public String addBook(Book book){

        return "book added successfully";
    }
}
