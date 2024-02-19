package Java;

import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> books;
    private List<Author> authors;
    private List<Patron> patrons;

    // Constructor
    public Library() {
        books = new ArrayList<>();
        authors = new ArrayList<>();
        patrons = new ArrayList<>();
    }

    // Methods to search books by title, author and ISBN
    public List<Book> searchBooksByTitle(String title) {
        List<Book> result = new ArrayList<>();
        for (Book book : books) {
            if (book.getTitle().toLowerCase().contains(title.toLowerCase())) {
                result.add(book);
            }
        }
        return result;
    }

    public List<Book> searchBooksByAuthor(String author) {
        List<Book> result = new ArrayList<>();
        for (Book book : books) {
            if (book.getAuthor().getName().toLowerCase().contains(author.toLowerCase())) {
                result.add(book);
            }
        }
        return result;
    }

    public Book searchBooksByISBN(String ISBN) {
        for (Book book : books) {
            if (book.getISBN().equals(ISBN)) {
                return book;
            }
        }
        return null;
    }

    // Method to borrow book
    public void borrowBook(Book book, Patron patron) {
        if (book.getStatus() == Status.AVAILABLE) {
            book.setStatus(Status.CHECKED_OUT);
            patron.borrowBook(book);
            System.out.println("Book '" + book.getTitle() + "' checked out successfully by " + patron.getName());
        } else {
            System.out.println("Book '" + book.getTitle() + "' is not available for borrowing.");
        }
    }

    // Method to return book
    public void returnBook(Book book, Patron patron) {
        if (book.getStatus() == Status.CHECKED_OUT) {
            book.setStatus(Status.AVAILABLE);
            patron.returnBook(book);
            System.out.println("Book '" + book.getTitle() + "' returned successfully by " + patron.getName());
        } else {
            System.out.println("Book '" + book.getTitle() + "' is not checked out.");
        }
    }


    //Method to add a book
    public void addBook(Book book) {
        books.add(book);
    }

    // Method to add an author
    public void addAuthor(Author author) {
        authors.add(author);
    }

    // Method to add a patron
    public void addPatron(Patron patron) {
        patrons.add(patron);
    }

}
