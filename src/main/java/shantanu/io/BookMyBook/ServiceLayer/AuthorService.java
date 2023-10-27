package shantanu.io.BookMyBook.ServiceLayer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shantanu.io.BookMyBook.Repositories.AuthorRepository;
import shantanu.io.BookMyBook.Repositories.BookRepository;
import shantanu.io.BookMyBook.RequestDTO.UpdateNameAndPenNameRequest;
import shantanu.io.BookMyBook.models.Author;
import shantanu.io.BookMyBook.models.Book;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AuthorService {
    @Autowired
    AuthorRepository authorRepository;

    @Autowired
    BookRepository bookRepository;

    public String addAuthor(Author author) throws Exception {
        // we've to put validations here
        if (authorRepository.existsById(author.getAuthorId())) {
            throw new Exception("author id should not be send as a parameter");
        }

        authorRepository.save(author);
        return "author added successfully";
    }

    public String updateAuthorNameAndPenName(UpdateNameAndPenNameRequest request) throws Exception {
        // now check validations here
        Optional<Author> authorOptional = authorRepository.findById(request.getAuthorId());
        if (!authorOptional.isPresent()) {
            throw new Exception("AuthorId is Invalid");
        }

        // here get a author obj and then we set reqd parameters to update info then save in repo.
        Author author = authorOptional.get();
        author.setName(request.getNewName());
        author.setPenName(request.getNewPenName());

        authorRepository.save(author);
        return "Author Name and PenName has been updated";
    }

    public Author getAuthorById(int authorId){
        Author author = authorRepository.findById(authorId).get();
        return author;
    }


    public boolean deleteAuthorById(int authorId){
        Optional<Author> authorOptional = authorRepository.findById(authorId);

        if(authorOptional.isPresent()){
            authorRepository.deleteById(authorId);
            return true;
        }
        else return false;
    }

    public List<Book> getBookListUsingAuthorId(int authorId){
        List<Book> bookList = authorRepository.findById(authorId).get().getBookList();
        return bookList;

//        List<Book> books = bookRepository.findAll();
//        List<Book> list = new ArrayList<>();
//        for(Book book : bookList){
//            if(book.getAuthor().getAuthorId() == authorId){
//                list.add(book);
//            }
//        }
//        return bookList;
    }
}