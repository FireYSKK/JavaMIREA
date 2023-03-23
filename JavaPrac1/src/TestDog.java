import java.lang.*;
public class TestDog {
    public static void main(String[] args) {
        Dog d1 = new Dog("Bobik", 2);
        Dog d2 = new Dog("Sharik", 7);
        Dog d3 = new Dog("Rex");
        d3.setAge(1);
        System.out.println(d1);
        System.out.println(d1.getName()+" "+d1.getAge());
        d1.intoHumanAge();
        d2.intoHumanAge();
        d3.jump();
    }
}

