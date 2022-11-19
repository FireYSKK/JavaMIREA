import java.util.Random;

public class FunctionalChair implements Chair{
    public int sum(int a, int b) {
        Random random = new Random();
        return random.nextInt(100);
    }
}