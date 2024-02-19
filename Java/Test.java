package Java;
import java.util.Date; 


public class Test {
    public static void main(String[] args) {
        // Create an author
        AuthorClass author = new AuthorClass("God", new Date(), null);

        // Create a book
        BookClass book = new BookClass("The Bible", author, "1234567890", "Sample Publisher", 50);
        author.addBook(book);

        // Test AuthorClass
        System.out.println(author.getName());
        System.out.println(author.getDateOfBirthAsString());
        System.out.println(author.getName());
        System.err.println(author.getBooksWrittenAsString());

        System.err.println("-----------------");

        // Test BookClass
        System.out.println(book.getTitle());
        System.out.println(book.getISBN());
        System.out.println(book.getPublisher());
        System.out.println(book.getNumberOfCopies());

    }
}
