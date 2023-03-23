public class Author {
    private final String name;
    private String email;
    private final char gender;

    public Author(String name, String email, char gender) {
       this.name = name;
       this.email = email;
       this.gender = gender;
   }

    public String getName() {
       return this.name;
   }
    public String getEmail() {
       return this.email;
   }
    public void setEmail(String email) {
        this.email = email;
    }
    public char getGender() {
        return gender;
    }

    @Override
    public String toString() {
        return name + "(" + gender + ") at " + email;
    }
}
