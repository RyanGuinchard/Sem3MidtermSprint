package Java;

import java.util.List;

public class Patron {
    private String name;
    private String address;
    private String phoneNumber;
    private List<BookClass> borrowedBooks;

    // Constructor
    public Patron(String name, String address, String phoneNumber) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
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

    public List<BookClass> getBorrowedBooks() {
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

    public void setBorrowedBooks(List<BookClass> borrowedBooks) {
        this.borrowedBooks = borrowedBooks;
    }

    //Method to add a borrowed book
    public void borrowBook(BookClass book) {
        borrowedBooks.add(book);
    }

    //Method to return a borrowed book
    public void returnBook(BookClass book) {
        borrowedBooks.remove(book);
    }

}
