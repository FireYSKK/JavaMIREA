

public class Person {
    private String name       = "";
    private String surname    = "";
    private String patronymic = "";

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public Person() {
    }

    public String getFIO() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(surname).append(" ");
        if (!name.isEmpty())       stringBuilder.append(name.charAt(0)). append(". ");
        if (!patronymic.isEmpty()) stringBuilder.append(patronymic.charAt(0)).append(".");
        return stringBuilder.toString().trim();
    }

    public void test() {
        this.setName("Timur");
        this.setPatronymic("Shukhratovich");
        this.setSurname("Muratov");
        System.out.println(this.getFIO());

        this.setPatronymic("");
        System.out.println(this.getFIO());

        this.setName("");
        System.out.println(this.getFIO());
    }
}