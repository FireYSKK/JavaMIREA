import java.util.Scanner;

public class TestCircle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double x = scanner.nextDouble(), y = scanner.nextDouble(), radius = scanner.nextDouble();
        Circle circle = new Circle(x, y, radius);
        System.out.println(circle);
        System.out.println(circle.getxPos()+", "+ circle.getyPos()+", "+ circle.getRadius());
        radius = scanner.nextDouble();
        circle.setRadius(radius);
        System.out.println(circle);
    }
}
