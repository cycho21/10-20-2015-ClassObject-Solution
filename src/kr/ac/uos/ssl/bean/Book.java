package kr.ac.uos.ssl.bean;

/**
 * @author Chan Yeon, Cho
 * @version 0.0.1 - SnapShot
 *          on 2015-10-21
 */

public class Book {

    private boolean borrowed;
    private String title;

    /**
     * @param bookTitle
     */
    public Book(String bookTitle) {
        this.title = bookTitle;
        borrowed = false;
    }

    public void borrowed() {
        this.borrowed = true;
    }

    public void returned() {
        this.borrowed = false;
    }

    public boolean isBorrowed() {
        return borrowed;
    }

    public String getTitle() {
        return title;
    }

}
