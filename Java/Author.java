package Java;
import java.text.SimpleDateFormat;
import java.util.Date; 

public class Author {
    private String name;
    private Date dateOfBirth;
    private Book[] booksWritten;

    public Author(String name, Date dateOfBirth, Book[] booksWritten) {
      this.name = name;
      this.dateOfBirth = dateOfBirth;  
      this.booksWritten = booksWritten;
    };

    // Getter method for name:
    public String getName() {
        return name;
    };

    // Getter method for dateOfBirth:
    public Date getDateOfBirth() {
        return dateOfBirth;
    };
    
    // Getter method for booksWritten:
    public Book[] getBooksWritten() {
        return booksWritten;
    };

    public String toString() {
        return this.name + " | " + this.getDateOfBirthAsString();
    }

    // Getter method for dateOfBirth as a String:
    public String getDateOfBirthAsString() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return dateFormat.format(dateOfBirth);
    };

    // Getter method for booksWritten as a String:
    public String getBooksWrittenAsString() {
        if (booksWritten == null || booksWritten.length == 0) {
            return "No books written.";
        }
        StringBuilder booksString = new StringBuilder();
        for (Book book : booksWritten) {
            booksString.append(book.getTitle()).append(", ");
        }
        return booksString.substring(0, booksString.length() - 2);
    };

    // Setter method for changing name:
    public void setName(String name) {
        this.name = name;
    };

    // Setter method for changing dateOfBirth:
    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    };

    // adds a book to the booksWritten array:
    public void addBook(Book book) {
        // Check if booksWritten is null:
        if (booksWritten == null) {
            booksWritten = new Book[]{book};
        } else {
            // If not null adds book to array.
            Book[] newBooksArray = new Book[booksWritten.length + 1];
            System.arraycopy(booksWritten, 0, newBooksArray, 0, booksWritten.length);
            newBooksArray[booksWritten.length] = book;
            booksWritten = newBooksArray;
        };
    };
    
}
