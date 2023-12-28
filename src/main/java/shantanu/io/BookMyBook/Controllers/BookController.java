package shantanu.io.BookMyBook.Controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import shantanu.io.BookMyBook.ENUMS.Genre;
import shantanu.io.BookMyBook.RequestDTO.AddBookRequestDto;
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
    public ResponseEntity<String> addBook(@RequestBody AddBookRequestDto addBookRequestDto){
        try{
            String result = bookService.addBook(addBookRequestDto);
            return new ResponseEntity<>(result, HttpStatus.OK);

        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/getByGenre")
    public ResponseEntity<String> getBookListByGenre(@RequestParam("genre") Genre genre){
        try{
            List<BookResponseDto> responseDtoList = bookService.getBookListByGenre(genre);
            return new ResponseEntity(responseDtoList, HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }


}
