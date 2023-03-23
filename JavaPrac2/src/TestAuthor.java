public class TestAuthor {
    public static void main(String[] args) {
        Author author1 = new Author("Nisio Isin", "NisiOisiN@Kodansha.co.jp", 'U');
        Author author2 = new Author("Aneko Yusagi", "YusagiAneko@MediaFactory.org", 'F');

        System.out.println(author1);
        System.out.println(author1.getName() + ", " + author1.getEmail() + ", " + author1.getGender());
        System.out.println(author2);
        author2.setEmail("Yuneko@gmail.com");
        System.out.println("Changed email for author #2");
        System.out.println(author2);
    }
}
