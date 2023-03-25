public class BookTest {
    public static void main(String[] args) {
        Book book = new Book("No Longer Human", "Dazai Osamu", 1948, new String[] {"Novel", "Autobiography"});
        System.out.println(book);
        book.setTitle("Hard-Boiled Wonderland and the End of the World");
        book.setAuthor("Haruki Murakami");
        book.setYear(1985);
        book.setGenres(new String[] {"Novel", "Cyberpunk", "Sci-fi", "Surreal", "Virtual fantasy"});
        System.out.println(book);
    }
}
