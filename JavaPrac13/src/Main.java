public class Main {

    public static void main(String[] args) {
        Complex complex;
        ConcreteFactory concreteFactory = new ConcreteFactory();

        complex = concreteFactory.createComplex(1, 2);
        System.out.println(complex.toString());

        complex = concreteFactory.createComplex();
        System.out.println(complex.toString());
    }
}