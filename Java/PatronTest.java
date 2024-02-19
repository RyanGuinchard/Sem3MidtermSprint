package Java;

import java.util.List;

public class PatronTest {
    public static void main(String[] args) {
        // Create a few BookClass objects
        BookClass book1 = new BookClass("Book 1", null, "1234567890", "Publisher A", 5);
        BookClass book2 = new BookClass("Book 2", null, "0987654321", "Publisher B", 3);

        // Create a Patron object
        Patron patron = new Patron("John Doe", "123 Main St", "555-1234");

        // Borrow books
        patron.borrowBook(book1);
        patron.borrowBook(book2);

        // Display patron information
        System.out.println("Patron Name: " + patron.getName());
        System.out.println("Patron Address: " + patron.getAddress());
        System.out.println("Patron Phone Number: " + patron.getPhoneNumber());
        System.out.println("Books Borrowed:");

        List<BookClass> borrowedBooks = patron.getBorrowedBooks();
        for (BookClass book : borrowedBooks) {
            System.out.println("- " + book.getTitle());
        }

        // Return a book
        patron.returnBook(book1);

        // Display updated list of borrowed books
        System.out.println("\nAfter returning a book, Books Borrowed:");
        borrowedBooks = patron.getBorrowedBooks();
        for (BookClass book : borrowedBooks) {
            System.out.println("- " + book.getTitle());
        }
    }
}
