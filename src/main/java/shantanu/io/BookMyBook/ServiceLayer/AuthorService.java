package shantanu.io.BookMyBook.ServiceLayer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shantanu.io.BookMyBook.Converters.AuthorConverter;
import shantanu.io.BookMyBook.Repositories.AuthorRepository;
import shantanu.io.BookMyBook.Repositories.BookRepository;
import shantanu.io.BookMyBook.RequestDTO.UpdateEmailAndAuthorDto;
import shantanu.io.BookMyBook.RequestDTO.UpdateNameAndPenNameRequest;
import shantanu.io.BookMyBook.ResponceDTO.AuthorResponseDto;
import shantanu.io.BookMyBook.models.Author;
import shantanu.io.BookMyBook.models.Book;

import javax.swing.text.html.Option;
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
            throw new Exception("author id already Exists");
        }

        authorRepository.save(author);
        return "author added successfully";
    }

    public String updateAuthorNameAndPenName(UpdateNameAndPenNameRequest request) throws Exception {
        // now check validations here
        Optional<Author> authorOptional = authorRepository.findById(request.getAuthorId());
        if (!authorOptional.isPresent()) {
            throw new Exception("INVALID : author id");
        }

        // here getting an author obj from optionals.then set required parameters to update info then save in repo.
        Author author = authorOptional.get();
        author.setName(request.getNewName());
        author.setPenName(request.getNewPenName());

        authorRepository.save(author);
        return "Author Name and PenName has been updated";
    }

//    shortcut of using converter function
//    Author author = AuthorConverter.convertAuthorDtoToEntity(update);

    public Author getAuthorById(int authorId){
        return authorRepository.findById(authorId).get();
    }

    // if we want the custom responses of author : as just want age and authId.
    public AuthorResponseDto getAuthor(int authorId){
        Author author = authorRepository.findById(authorId).get();

        AuthorResponseDto authorResponseDto = new AuthorResponseDto();
        authorResponseDto.setAuthorId(author.getAuthorId());
        authorResponseDto.setAge(author.getAge());

        return authorResponseDto;
    }

    public boolean deleteAuthorById(int authorId){
        Optional<Author> authorOptional = authorRepository.findById(authorId);

        if(authorOptional.isPresent()){
            authorRepository.deleteById(authorId);
            return true;
        }
        else return false;
    }

    public List<Book> getBookListUsingAuthorId(int authorId) throws Exception{

        // validation check for author id
        Optional<Author> optionalAuthor = authorRepository.findById(authorId);
        if(!optionalAuthor.isPresent()){
            throw new Exception("Author ID is not present in DB ");
        }

        List<Book> bookList = authorRepository.findById(authorId).get().getBookList();
        return bookList;
    }
}