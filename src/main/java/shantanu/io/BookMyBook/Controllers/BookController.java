package shantanu.io.BookMyBook.Controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import shantanu.io.BookMyBook.ENUMS.Genre;
import shantanu.io.BookMyBook.RequestDTO.AddBookRequestDto;
import shantanu.io.BookMyBook.ResponceDTO.AddBookResponseDTO;
import shantanu.io.BookMyBook.ResponceDTO.BookResponseDto;
import shantanu.io.BookMyBook.ServiceLayer.BookService;

import java.util.List;

@RestController
@RequestMapping("/book")
@Slf4j
public class BookController {

    @Autowired
    BookService bookService;

    @PostMapping("/add")
    // when i'll adding the book so i've to  associate the author directly with that book
    public ResponseEntity<String> addBook(AddBookRequestDto request){

        try{
            String result = bookService.addBook(request);
            return new ResponseEntity<>(result, HttpStatus.CREATED);
        }
        catch (Exception e){
            log.error("error occurred, can't able to Add your book{}", e.getMessage());
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/getByGenre")
    public ResponseEntity<String> getBookListByGenre(@RequestParam("genre") Genre genre){
        List<BookResponseDto> responseDtoList = bookService.getBookListByGenre(genre);
        return new ResponseEntity(responseDtoList, HttpStatus.OK);
    }
}
