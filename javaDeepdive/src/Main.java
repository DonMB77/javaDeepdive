import bookStoreManagement.*;
import moneyTransfer.Account;

import java.math.BigDecimal;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // first author test set for testing of BookService.filterBooksByAuthor()
        Author author1 = new Author(1, "Mickey", "Glassow");
        Author author2 = new Author(2, "Thomas", "Duwell");
        Author[] authorTestSet = {author1,author2};

        // second author test set for testing of BookService.filterBooksByAuthor()
        Author author3 = new Author(1, "Author3", "Lastname3");
        Author author4 = new Author(2, "Author4", "Lastname4");
        Author[] authorTestSet2 = {author3,author4};

        // publisher used for instantiating multiple book objects
        Publisher publisher1 = new Publisher(1, "Publisher One");
        Publisher publisher2 = new Publisher(2, "Publisher Two");

        // book array for testing of BookService.filterBooksByAuthor()
        Book book1 = new Book(1, "book1", authorTestSet, publisher1, 1999, 60, BigDecimal.valueOf(20.00), CoverType.HARDCOVER);
        Book book2 = new Book(1, "book1", authorTestSet2, publisher1, 1999, 60, BigDecimal.valueOf(20.00), CoverType.HARDCOVER);
        Book book3 = new Book(1, "book1", authorTestSet, publisher2, 1999, 60, BigDecimal.valueOf(20.00), CoverType.HARDCOVER);
        Book[] testBooksArray = {book1, book2, book3};

        Book[] bookFilteredByAuthor = BookService.filterBooksByAuthor(author1, testBooksArray);
        System.out.println("Books filtered by author:");
        for (Book book : bookFilteredByAuthor) {
            System.out.println(book.toString());
        }

        System.out.println("\n");

        Book[] bookFilteredByPublisher = BookService.filterBooksByPublisher(publisher1, testBooksArray);
        System.out.println("Books filtered by publisher:");
        for (Book book : bookFilteredByPublisher) {
            System.out.println(book.toString());
        }
    }
}