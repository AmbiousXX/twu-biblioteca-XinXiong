package com.twu.biblioteca;

import com.twu.biblioteca.bookitem.Book;
import com.twu.biblioteca.bookitem.BookManagement;
import com.twu.biblioteca.movieitem.Movie;
import com.twu.biblioteca.movieitem.MovieManagement;
import com.twu.biblioteca.useritem.MyState;
import com.twu.biblioteca.useritem.User;
import com.twu.biblioteca.useritem.UserManagement;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Hashtable;
import java.util.List;

import static org.junit.Assert.*;

public class OptionTest {
    private MovieManagement movieManagement;
    private BookManagement bookManagement;
    private UserManagement userManagement;
    private MyState myState;

    private List<Movie> movies;
    private List<Book> books;
    private Hashtable<String, User> users;

    @Before
    public void setUp() {
        this.movieManagement = MovieManagement.getMovieManagement();
        this.bookManagement = BookManagement.getBookManagement();
        this.userManagement = UserManagement.getUserManagement();
        this.myState = new MyState();

        this.movies = movieManagement.initializeMovieList();
        this.books = bookManagement.initializeBookList();
        this.users = userManagement.initializeUserList();
    }

    @Test
    public void testOptionCheckoutMovie() {
        String checkoutMovieSuccessfully = "Thank you! Enjoy the movie";
        assertEquals(false, movies.get(1).getIsChecked());

        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        PrintStream output = new PrintStream(buffer);
        System.setOut(output);

        String inputOption = "check out movie";
        switch (inputOption) {
            case "check out movie":
                String inputMovieNumber = "2";
                movieManagement.checkoutMovie(movies, Integer.parseInt(inputMovieNumber));
                break;
            default:
                break;
        }

        assertEquals(true, movies.get(1).getIsChecked());
        assertEquals(checkoutMovieSuccessfully + "\r" + "\n", buffer.toString());
    }

    @Test
    public void testOptionLogIn() {
        assertEquals(false, myState.getIsUser());

        String inputOptionLogIn = "log in";
        switch (inputOptionLogIn) {
            case "log in":
                String inputAccountNumberAndPassword = "nny-8855 67yd7tDJK0";
                String[] inputAccountInfo = inputAccountNumberAndPassword.split(" ");
                userManagement.logIn(users, myState,inputAccountInfo[0], inputAccountInfo[1]);
            default:
                break;
        }

        assertEquals(true, myState.getIsUser());
    }

    @Test
    public void testOptionCheckoutBook() {
        userManagement.logIn(users, myState,"nny-8855", "67yd7tDJK0");
        assertEquals(false, books.get(1).getIsChecked());
        assertEquals(false, myState.getUserAccount().getUserCheckoutBookList().containsKey(2));

        String inputOption = "check out book";
        switch (inputOption) {
            case "check out book":
                String inputBookNumber = "2";
                boolean ok = bookManagement.checkoutBook(books, Integer.parseInt(inputBookNumber));
                if(ok) {
                    userManagement.userRegisterCheckoutBook(myState, books, Integer.parseInt(inputBookNumber));
                }
                break;
            default:
                break;
        }

        assertEquals(true, books.get(1).getIsChecked());
        assertEquals(true, myState.getUserAccount().getUserCheckoutBookList().containsKey(2));
    }

    @Test
    public void testOptionReturnBook() {
        userManagement.logIn(users, myState,"nny-8855", "67yd7tDJK0");
        String inputBookNumber = "2";
        boolean ok = bookManagement.checkoutBook(books, Integer.parseInt(inputBookNumber));
        if(ok) {
            userManagement.userRegisterCheckoutBook(myState, books, Integer.parseInt(inputBookNumber));
        }
        assertEquals(true, books.get(1).getIsChecked());
        assertEquals(true, myState.getUserAccount().getUserCheckoutBookList().containsKey(2));

        userManagement.userRegisterReturnBook(myState, Integer.parseInt(inputBookNumber));
        bookManagement.returnBook(books, Integer.parseInt(inputBookNumber));

        assertEquals(false, books.get(1).getIsChecked());
        assertEquals(false, myState.getUserAccount().getUserCheckoutBookList().containsKey(2));
    }

    @Test
    public void testOptionLogOut() {
        assertEquals(false, myState.getIsUser());
        userManagement.logIn(users, myState,"nny-8855", "67yd7tDJK0");
        assertEquals(true, myState.getIsUser());
        userManagement.logOut(myState);
        assertEquals(false, myState.getIsUser());
    }
}