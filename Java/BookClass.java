package Java;

public class BookClass implements Borrowable {
    private String title;
    private AuthorClass author;
    private String ISBN;
    private String publisher;
    private Integer numberOfCopies;
    private Status status;

    public BookClass(String title, AuthorClass author, String ISBN, String publisher, Integer numberOfCopies) {
        this.title = title;
        this.author = author;
        this.ISBN = ISBN;
        this.publisher = publisher;
        this.numberOfCopies = numberOfCopies;
        this.status = Status.AVAILABLE;
    };

    // Getter method for title:
    public String getTitle() {
        return title;
    };

    // Getter method for author:
    public AuthorClass getAuthor() {
        return author;
    };

    // Getter method for ISBN:
    public String getISBN() {
        return ISBN;
    };

    // Getter method for publisher:
    public String getPublisher() {
        return publisher;
    };

    // Getter method for numberOfCopies:
    public Integer getNumberOfCopies() {
        return numberOfCopies;
    };

    // Getter method for status:
    public Status getStatus() {
        return status;
    }

    // Setter method for title:
    public void setTitle(String title) {
        this.title = title;
    }

    // Setter method for author:
    public void setAuthor(AuthorClass author) {
        this.author = author;
    }

    // Setter method for ISBN:
    public void setISBN(String iSBN) {
        ISBN = iSBN;
    }

    // Setter method for publisher:
    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    // Setter method for numberOfCopies:
    public void setNumberOfCopies(Integer numberOfCopies) {
        this.numberOfCopies = numberOfCopies;
    }

    // Setter method for status:
    public void setStatus(Status status) {
        this.status = status;
    };

    // borrow method:
    public void borrowBook() {
        if (status == Status.AVAILABLE) {
            status = Status.CHECKED_OUT;
            System.out.println("Book checked out successfully.");
        } else {
            System.out.println("Book is not available for borrowing.");
        }
    };
    
    // return method:
    public void returnBook() {
        if (status == Status.CHECKED_OUT) {
            status = Status.AVAILABLE;
            System.out.println("Book returned successfully.");
        } else {
            System.out.println("Cannot return a book that is not checked out.");
        }
    };
};