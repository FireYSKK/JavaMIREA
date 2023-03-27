package doggo;

public abstract class Dog {
    private String name;
    private int age;
    private String temperament;

    public Dog(String name, int age, String temperament){
        this.setName(name);
        this.setAge(age);
        this.setTemperament(temperament);
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public String getTemperament() {
        return temperament;
    }
    public void setTemperament(String temperament) {
        this.temperament = temperament;
    }

    public abstract void bark();
    public abstract void goodBoy();
}
