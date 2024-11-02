package bookStoreManagement;

import java.util.ArrayList;
import java.util.Objects;

public class BookService {
    public static Book[] filterBooksByAuthor(Author author, Book[] books) {
        int arrayCounts = 0;
        for (int i = 0; i < books.length; i++) {
            for (int j = 0; j < books[i].authors.length; j++) {
                if (books[i].authors[j].firstName == author.firstName && books[i].authors[j].lastName == author.lastName) {
                    ++arrayCounts;
                }
            }
        }
        Book[] returnBooks = new Book[arrayCounts];
        int index = 0;
        for (int i = 0; i < books.length; i++) {
            for (int j = 0; j < books[i].authors.length; j++) {
                if (books[i].authors[j].firstName == author.firstName && books[i].authors[j].lastName == author.lastName) {
                    returnBooks[index] = books[i];
                    index++;
                }
            }
        }
        return returnBooks;
    }
}
