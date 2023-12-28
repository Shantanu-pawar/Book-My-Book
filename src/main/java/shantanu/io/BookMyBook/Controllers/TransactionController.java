package shantanu.io.BookMyBook.Controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import shantanu.io.BookMyBook.RequestDTO.TransactionRequest;
import shantanu.io.BookMyBook.ServiceLayer.TransactionService;
import shantanu.io.BookMyBook.models.Transactions;

@RestController
@RequestMapping("/transactions")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @PostMapping("/issueBook")
    public ResponseEntity<String> issueBook(@RequestBody TransactionRequest transactions){
        try{
            String result = transactionService.issueBook(transactions);
            return new ResponseEntity<>(result, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

}
