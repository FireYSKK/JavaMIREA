import java.util.Arrays;

public class Book {
    private String title;
    private String[] genres;
    private int pages;
    public Book(String title, int pages, String[] genres){
        this.title = title;
        if (pages > 0) {
            this.pages = pages;
        }
        else {
            System.out.println("Pages can't be negative. Value not assigned");
            this.pages = 0;
        }
        this.genres = genres;
    }
    public Book(String title, int pages){
        this.title = title;
        if (pages > 0) {
            this.pages = pages;
        }
        else {
            System.out.println("Pages can't be negative. Value not assigned");
            this.pages = 0;
        }
    }
    public Book(int pages){
        this.title = "Untitled";
        if (pages > 0) {
            this.pages = pages;
        }
        else {
            System.out.println("Pages can't be negative. Value not assigned");
            this.pages = 0;
        }
    }
    public void setPages(int pages) {
        this.title = "Untitled";
        if (pages > 0) {
            this.pages = pages;
        }
        else {
            System.out.println("Pages can't be negative. Value not assigned");
        }
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public void setGenres(String[] genres) {
        this.genres = genres;
    }
    public String getTitle(){
        return this.title;
    }
    public int getPages() {
        return this.pages;
    }
    public String[] getGenres() {
        return this.genres;
    }

    public String toString() {
        String genresString;
        if (genres != null) {
            genresString = Arrays.toString(genres);
        }
        else {
            genresString = "Unknown";
        }
        return this.title + ", pages " + this.pages + " genres: " + genresString;
    }
    public void estimateReadingTime() {
        System.out.println(this.title+" will take "+(pages*1.5/60)+" hours to read");
    }
}

