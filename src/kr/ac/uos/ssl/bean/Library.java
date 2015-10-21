package kr.ac.uos.ssl.bean;

import java.sql.Time;
import java.util.ArrayList;

/**
 * @author Chan Yeon, Cho
 * @version 0.0.1 - SnapShot
 *          on 2015-10-21
 */

public class Library {

    /*
     *  Time Class is deprecated!
     */
    public static Time openingHour = new Time(9, 0, 0);
    public static Time closingHour = new Time(17, 0, 0);
    private ArrayList<Book> bookList;
    private String address;

    public Library(String libAddr) {
        this.address = libAddr;
        init();
    }

    private void init() {
        bookList = new ArrayList<>();
    }

    public ArrayList<Book> getBookList() {
        return bookList;
    }

    public void setBookList(ArrayList<Book> bookList) {
        this.bookList = bookList;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void addBook(Book book) {
        bookList.add(book);
    }

    public void printAddress() {
        System.out.println(this.address);
    }

    public void borrowBook(String bookTitle) {
        boolean catalogCheck = false;
        for (Book tempBook : bookList) {
            boolean bookTitleFlag = bookTitle.equals(tempBook.getTitle());
            if (!bookTitleFlag) {
                continue;
            } else {
                if (!tempBook.isBorrowed()) {
                    System.out.println("You successfully borrowed " + tempBook.getTitle() + ".");
                    tempBook.borrowed();
                    catalogCheck = true;
                } else {
                    System.out.println("Sorry, this book is already borrowed.");
                    catalogCheck = true;
                }
            }
        }
        if (!catalogCheck) {
            System.out.println("Sorry, this book is not in our catalog.");
        }
    }

    public void printAvailableBooks() {
        int availableBooks = 0;
        for (Book tempBook : this.bookList) {
                if (!tempBook.isBorrowed()) {
                    System.out.println(tempBook.getTitle() + ".");
                    availableBooks++;
                }
            }
        if(availableBooks==0){
            System.out.println("There is no book available");
        }
    }

    public void returnBook(String bookTitle) {
        boolean catalogCheck = false;
        for (Book tempBook : this.bookList) {
            boolean bookTitleFlag = bookTitle.equals(tempBook.getTitle());
            if (!bookTitleFlag) {
                continue;
            } else {
                if (!tempBook.isBorrowed()) {
                    System.out.println("This book is already returned. You may forget something");
                    catalogCheck = true;
                } else {
                    System.out.println("You successfully returned " + bookTitle + ".");
                    tempBook.returned();
                    catalogCheck = true;
                }
            }
        }
        if (!catalogCheck) {
            System.out.println("Sorry, this book is not in our catalog. You may confuse something");
        }
    }
}