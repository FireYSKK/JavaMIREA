import java.util.Arrays;

public class Book {
    private String title, author;
    private int year;
    private String[] genres;

    public Book(String title, String author, int year, String[] genres) {
        this.title = title;
        this.author = author;
        this.year = year;
        this.genres = genres;
    }
    public Book(String title, String author, int year) {
        this.title = title;
        this.author = author;
        this.year = year;
    }
    public Book(String title) {
        this.title = title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public void setYear(int year) {
        this.year = year;
    }
    public void setGenres(String[] genres) {
        this.genres = genres;
    }

    public String getTitle() {
        return title;
    }
    public String getAuthor() {
        return author;
    }
    public int getYear() {
        return year;
    }
    public String[] getGenres() {
        return genres;
    }

    @Override
    public String toString() {
        return title + " (" + year + "), " + author + ", genres: " + Arrays.toString(genres);
    }
}
