package doggo;

public class GoldenRetriever extends Dog{

    public GoldenRetriever(String name, int age) {
        super(name, age, "Calm");
    }

    @Override
    public void bark() {
        System.out.println("The Retriever goes *Wuf Wuf*");
    }

    @Override
    public void goodBoy() {
        System.out.println(super.getName()+" is a good boy!");
    }

}
