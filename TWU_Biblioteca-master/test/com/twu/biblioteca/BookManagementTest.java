package com.twu.biblioteca;

import com.twu.biblioteca.bookitem.*;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

import java.util.List;

public class BookManagementTest {
    MessageInformation messageInformation = new MessageInformation();
    BookManagement bookManagement = new BookManagement(messageInformation);


    @Test
    public void testViewBookList() {
        List<Book> books = bookManagement.initializeBookList();

        Book book = books.get(4);

        assertEquals(book.getName(), "The Little Prince");
        assertEquals(book.getAuthor(), "Antoine de Saint-Exupéry");
        assertEquals(book.getPublicationYear(), 1942);
        assertEquals(book.getIsChecked(), false);
    }

    @Test
    public void testCheckoutBookSuccessfully() {
        List<Book> books = bookManagement.initializeBookList();

        bookManagement.checkoutBook(books, 3);
        Book checkedBook = books.get(2);

        assertEquals(checkedBook.getIsChecked(), true);
    }

    @Test
    public void testReturnBookSuccessfully() {
        List<Book> books = bookManagement.initializeBookList();

        bookManagement.checkoutBook(books, 3);
        bookManagement.returnBook(books, 3);
        Book returnedBook = books.get(2);

        assertEquals(returnedBook.getIsChecked(), false);
    }
}
