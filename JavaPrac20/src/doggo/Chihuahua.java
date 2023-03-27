package doggo;

public class Chihuahua extends Dog{
    public Chihuahua(String name, int age) {
        super(name, age, "Aggressive");
    }

    @Override
    public void bark() {
        System.out.println("The Chihuahua goes *Waaf Waaf*");
    }

    @Override
    public void goodBoy() {
        System.out.println(super.getName()+" is barking violently. That's adorable! <3");
    }
}
