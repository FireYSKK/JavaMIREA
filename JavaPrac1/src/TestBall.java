public class TestBall {
    public static void main(String[] args) {
        Ball d1 = new Ball("Soccer ball", 22);
        Ball d2 = new Ball("Ping-pong ball", 4.5);
        Ball d3 = new Ball("Volleyball");
        d3.setSize(18);
        System.out.println(d1);
        d1.throwBall();
        d2.throwBall();
        d3.kickBall();
    }
}

