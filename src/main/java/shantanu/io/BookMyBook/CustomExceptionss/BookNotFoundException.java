package shantanu.io.BookMyBook.CustomExceptionss;

public class BookNotFoundException extends Exception{
    public BookNotFoundException(String msg) {
        super(msg);
    }
}
