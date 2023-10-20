package shantanu.io.BookMyBook.CustomExceptionss;

public class BookNotAvailableException extends Exception{

    public BookNotAvailableException(String msg) {
        super(msg);
    }
}
