public class TestPlanet {
    public static void main(String[] args) {
        Nameable planet1 = new Planet("Mercury");
        Nameable planet2 = new Planet("Earth");
        Nameable planet3 = new Planet("Neptune");

        System.out.println(planet1.getName());
        System.out.println(planet2.getName());
        System.out.println(planet3.getName());
    }
}
