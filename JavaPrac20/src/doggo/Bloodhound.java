package doggo;

public class Bloodhound extends Dog{
    public Bloodhound(String name, int age) {
        super(name, age, "Neutral");
    }

    @Override
    public void bark() {
        System.out.println("The Bloodhound goes *Wooo*");
    }

    @Override
    public void goodBoy() {
        System.out.println(super.getName()+" is a good boy!");
    }
}
