package shantanu.io.BookMyBook.Controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import shantanu.io.BookMyBook.ServiceLayer.LibraryCardService;
import shantanu.io.BookMyBook.models.LibraryCard;

@RestController
@RequestMapping("/card")
@Slf4j
public class CardController {

    @Autowired private LibraryCardService libraryCardService;

    @PostMapping("/add")
    public String addCard(@RequestBody LibraryCard libraryCard){
        return libraryCardService.addCard(libraryCard);
    }

    @PutMapping("issueToStudent")
    public ResponseEntity issueToStudent(@RequestParam("cardId")int cardId,@RequestParam("rollNO") int rollNo){

        try{
            String result = libraryCardService.associateToStudent(cardId, rollNo);
            return new ResponseEntity(result, HttpStatus.OK);
        }
        catch (Exception e ){
            log.error("Error is associating with card and student.{}", e.getMessage());
            return new ResponseEntity(e.getMessage(), HttpStatus.EXPECTATION_FAILED);
        }
    }
}
