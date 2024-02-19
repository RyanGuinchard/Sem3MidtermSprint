package Java;

import java.util.ArrayList;
import java.util.List;

public class Patron {
    private String name;
    private String address;
    private String phoneNumber;
    private List<Book> borrowedBooks;

    // Constructor
    public Patron(String name, String address, String phoneNumber) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.borrowedBooks = new ArrayList<>();
    }

    // Getter Methods
    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;

    }

    public List<Book> getBorrowedBooks() {
        return borrowedBooks;
    }

    // Setter methods
    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setBorrowedBooks(List<Book> borrowedBooks) {
        this.borrowedBooks = borrowedBooks;
    }

    //Method to add a borrowed book
    public void borrowBook(Book book) {
        borrowedBooks.add(book);
    }

    //Method to return a borrowed book
    public void returnBook(Book book) {
        borrowedBooks.remove(book);
    }

}
