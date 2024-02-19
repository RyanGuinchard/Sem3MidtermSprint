package Java;
import java.util.Date;
import java.util.List; 


public class Test {
    public static void main(String[] args) {
        // Create an author
        Author author = new Author("God", new Date(), null);
        Author author2 = new Author("F. Scott Fitzgerald", new Date(1896, 9, 24), null);
        Author author3 = new Author("Christopher Cormier", new Date(2002, 11, 30), null);
        Author author4 = new Author("Suzanne Collins", new Date(1962, 8, 10), null);
        Author author5 = new Author("Ryan Gunichard", new Date(1999, 7, 21), null);

        // Create a book
        Book book = new Book("The Bible", author, "66743568", "Moses", 50);
        Book book2 = new Book("Harry Squatter", author, "34514343", "Micheal", 40);
        Book book3 = new Book("The Great Gatsby", author2, "9780333791035", "Charles Scribner's Sons", 1000000);
        Book book4 = new Book("The Chrisinomicon", author3, "1252429151571481", "Booth & Darke Co.", 700000000);
        Book book5 = new Book("This Side of Paradise", author2, "326324221413", "Charles Scribner's Sons", 123444444);
        Book book6 = new Book("This Saturday Evening Post", author2, "35267424623", "Charles Scribner's Sons", 1241444);
        Book book9 = new Book("The Hunger Games", author4, "1231452151", "Schoolastic", 92);
        Book book10 = new Book("Beginners guide to becoming a millionare", author5, "12451251421", "Chris", 999999999);

        // Create a patron
        Patron patron = new Patron("Jerimiah kumingbach", "146 Pussiwillow Drive", "420-6969");
        Patron patron2 = new Patron("Justin Walsh", "132 Charming Ave.", "1-800-666-5088");
        Patron patron3 = new Patron("Mason Brumsey", "42 Main St.", "709-649-5232");
        Patron patron4 = new Patron("Josh", "Mcdonalds", "709-649-42");
        Patron patron5 = new Patron("Jeremy Saunders", "42 Kuntucky ave", "1 (709) 721-4523");

        Library library = new Library();

        author.addBook(book);
        author.addBook(book2);
        author2.addBook(book3);
        author2.addBook(book5);
        author2.addBook(book6);
        author3.addBook(book4);
        author4.addBook(book9);
        author5.addBook(book10);

        patron.borrowBook(book);
        patron.borrowBook(book4);

        // Add books to the library
        library.addBook(book);
        library.addBook(book2);
        library.addBook(book3);
        library.addBook(book4);
        library.addBook(book5);
        library.addBook(book6);
        library.addBook(book9);
        library.addBook(book10);

        // Add authors to the library
        library.addAuthor(author);
        library.addAuthor(author2);
        library.addAuthor(author3);
        library.addAuthor(author4);
        library.addAuthor(author5);

        // Add patrons to the library
        library.addPatron(patron);
        library.addPatron(patron2);
        library.addPatron(patron3);
        library.addPatron(patron4);
        library.addPatron(patron5);

        // Test Book Class:
        System.out.println("Book class test: ");
        System.out.println("Title: " + book.getTitle());
        System.out.println("ISBN: " + book.getISBN());
        System.out.println("Publisher: " + book.getPublisher());
        System.out.println("Number of copies: " + book.getNumberOfCopies());
        
        System.out.println("-----------------");


        // Test Borrow and Return:
        System.out.println("Inital: " + book.getStatus());
        book.borrowBook();
        System.out.println("Borrowed: " + book.getStatus());
        book.returnBook();
        System.out.println("Returned: " + book.getStatus());
            
        System.out.println("-----------------");
        System.out.println("Author class test:");
        
        // Test Author Class:
        System.out.println("Name: " + author.getName());
        System.out.println("Date of birth:" + author.getDateOfBirthAsString());
        System.out.println("" + author.toString());
        System.out.println("" + author.getBooksWrittenAsString());

        System.out.println("-----------------");
        System.out.println("Patron class test:");

        // Display patron information
        System.out.println("Patron Name: " + patron.getName());
        System.out.println("Patron Address: " + patron.getAddress());
        System.out.println("Patron Phone Number: " + patron.getPhoneNumber());
        System.out.println("Books Borrowed:");

        List<Book> borrowedBooks = patron.getBorrowedBooks();
        for (Book tempbook : borrowedBooks) {
            System.out.println("- " + tempbook.toString());
        }

        // Return a book
        
        patron.returnBook(book4);

        // Display updated list of borrowed books
        System.out.println("\nAfter returning a book, Books Borrowed:");
        borrowedBooks = patron.getBorrowedBooks();
        for (Book tempbook : borrowedBooks) {
            System.out.println("- " + tempbook.toString());
        }

        // Testing library:
        System.out.println("-----------------");
        System.out.println("Library class test:");

        // Search books by title
        System.out.println("Search Books by Title 'Harry':");
        List<Book> searchResult = library.searchBooksByTitle("Harry");
        for (Book b : searchResult) {
            System.out.println("- " + b.getTitle());
        }

        // Search books by author
        System.out.println("Search Books by Author 'Fitzgerald':");
        searchResult = library.searchBooksByAuthor("Fitzgerald");
        for (Book b : searchResult) {
            System.out.println("- " + b.getTitle() + " by " + b.getAuthor().getName());
        }

        // Search books by ISBN
        System.out.println("Search Book by ISBN '1231452151':");
        Book foundBook = library.searchBooksByISBN("1231452151");
        if (foundBook != null) {
            System.out.println("- " + foundBook.getTitle());
        } else {
            System.out.println("Book not found.");
        }

        // Borrow a book from the library
        System.out.println("Borrow a book from the library:");
        library.borrowBook(book, patron2);

        // Return a book to the library
        System.out.println("Return a book to the library:");
        library.returnBook(book, patron2);

        // Display updated list of borrowed books for patron2
        System.out.println("Books Borrowed by " + patron2.getName() + " after returning a book:");
        List<Book> borrowedBooksPatron2 = patron2.getBorrowedBooks();
        for (Book b : borrowedBooksPatron2) {
            System.out.println("- " + b.getTitle());
        }
    }
}
