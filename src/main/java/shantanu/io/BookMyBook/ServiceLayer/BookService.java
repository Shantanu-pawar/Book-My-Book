package shantanu.io.BookMyBook.ServiceLayer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shantanu.io.BookMyBook.ENUMS.Genre;
import shantanu.io.BookMyBook.Repositories.BookRepository;
import shantanu.io.BookMyBook.RequestDTO.AddBookRequestDto;
import shantanu.io.BookMyBook.Repositories.AuthorRepository;
import shantanu.io.BookMyBook.ResponceDTO.BookResponseDto;
import shantanu.io.BookMyBook.models.Author;
import shantanu.io.BookMyBook.models.Book;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    @Autowired
    AuthorRepository authorRepository; // cause we wanna set this data to author

    @Autowired
    BookRepository bookRepository;

    public String addBook(AddBookRequestDto request) throws Exception{

        // Validation : check for authorId
        Optional<Author> optionalAuthor = authorRepository.findById(request.getAuthorId());
        if(!optionalAuthor.isPresent()){
            throw new Exception("Author id is not present in Database.");
        }

        //set attributes in book obj
        Book book = new Book(request.getTitle(), request.getIsAvailable(), request.getGenre(),
                request.getPublicationDate(), request.getPrice());

        // now i've got book obj and just 've to set foreign key variables
        // and since its 'bi directional' mapping so need to set both parent and child
        Author author = optionalAuthor.get();
        book.setAuthor(author); // setting in child

        // setting in parent : 3-step process : 1.getting list of books || 2. add it || 3. set it back

        // author.getBookList().add(book); // shortcut method.

        List<Book> list = author.getBookList();
        list.add(book);
        author.setBookList(list);

        // lastly we've to just save our parent child will automatically saved in our DB
        authorRepository.save(author);
        bookRepository.save(book);
        return "book has been successfully added";
    }


    public List<BookResponseDto> getBookListByGenre(Genre genre){

        List<Book> bookList = bookRepository.findBookByGenre(genre);
        List<BookResponseDto> responseList = new ArrayList<>();

        for(Book book : bookList){

            BookResponseDto bookResponseDto = new BookResponseDto(book.getTitle(),
                    book.getIsAvailable(), book.getGenre(),book.getPublicationDate(),
                    book.getPrice(), book.getAuthor().getAuthorId(),book.getAuthor().getName());

            responseList.add(bookResponseDto);
        }
        return responseList;
    }
}

