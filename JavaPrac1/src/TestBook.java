public class TestBook {
    public static void main(String[] args) {
        Book d1 = new Book("War and Peace", 1400);
        Book d2 = new Book("Evgenij Onegin", 110, new String[]{"Novel", "Romance"});
        Book d3 = new Book(320);
        d3.setTitle("1984");
        d3.setGenres(new String[]{"Sci-fi", "Dystopia"});
        System.out.println(d1);
        System.out.println(d3);
        d1.estimateReadingTime();
        d2.estimateReadingTime();
        d3.estimateReadingTime();
    }
}

