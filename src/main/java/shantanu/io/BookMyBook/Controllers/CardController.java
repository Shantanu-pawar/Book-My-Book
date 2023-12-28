package shantanu.io.BookMyBook.Controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import shantanu.io.BookMyBook.RequestDTO.AddCardRequest;
import shantanu.io.BookMyBook.ServiceLayer.LibraryCardService;
import shantanu.io.BookMyBook.models.LibraryCard;

@RestController
@RequestMapping("/card")
@Slf4j
public class CardController {

    @Autowired
    private LibraryCardService libraryCardService;


    @PutMapping("/issueToStudent")
    public ResponseEntity<String> issueToStudent(@RequestBody AddCardRequest card) {

        try {
            String result = libraryCardService.associateToStudent(card);
            return new ResponseEntity<>(result, HttpStatus.OK);
        }
        catch (Exception e) {
            log.error("Error in associating card to student{}", e.getMessage());
            return new ResponseEntity<>(e.getMessage(), HttpStatus.EXPECTATION_FAILED);
        }
    }

}
