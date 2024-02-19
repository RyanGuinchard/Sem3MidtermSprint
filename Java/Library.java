package Java;

import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<BookClass> books;
    private List<AuthorClass> authors;
    private List<Patron> patrons;

    // Constructor
    public Library() {
        books = new ArrayList<>();
        authors = new ArrayList<>();
        patrons = new ArrayList<>();
    }

    // Methods to search books by title, author and ISBN
    public List<BookClass> searchBooksByTitle(String title) {
        List<BookClass> result = new ArrayList<>();
        for (BookClass book : books) {
            if (book.getTitle().toLowerCase().contains(title.toLowerCase())) {
                result.add(book);
            }
        }
        return result;
    }

    public List<BookClass> searchBooksByAuthor(String author) {
        List<BookClass> result = new ArrayList<>();
        for (BookClass book : books) {
            if (book.getAuthor().getName().toLowerCase().contains(author.toLowerCase())) {
                result.add(book);
            }
        }
        return result;
    }

    public BookClass searchBooksByISBN(String ISBN) {
        for (BookClass book : books) {
            if (book.getISBN().equals(ISBN)) {
                return book;
            }
        }
        return null;
    }

    // Method to borrow book
    public void borrowBook(BookClass book, Patron patron) {
        if (book.getStatus() == Status.AVAILABLE) {
            book.setStatus(Status.CHECKED_OUT);
            patron.borrowBook(book);
            System.out.println("Book '" + book.getTitle() + "' checked out successfully by " + patron.getName());
        } else {
            System.out.println("Book '" + book.getTitle() + "' is not available for borrowing.");
        }
    }

    // Method to return book
    public void returnBook(BookClass book, Patron patron) {
        if (book.getStatus() == Status.CHECKED_OUT) {
            book.setStatus(Status.AVAILABLE);
            patron.returnBook(book);
            System.out.println("Book '" + book.getTitle() + "' returned successfully by " + patron.getName());
        } else {
            System.out.println("Book '" + book.getTitle() + "' is not checked out.");
        }
    }


    //Method to add a book
    public void addBook(BookClass book) {
        books.add(book);
    }

    // Method to add an author
    public void addAuthor(AuthorClass author) {
        authors.add(author);
    }

    // Method to add a patron
    public void addPatron(Patron patron) {
        patrons.add(patron);
    }

}
