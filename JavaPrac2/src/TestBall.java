public class TestBall {
    public static void main(String[] args) {
        Ball ball = new Ball(100, 100);
        System.out.println(ball);
        System.out.println(ball.getX()+", "+ ball.getY());
        ball.move(30, 15);
        System.out.println(ball);
        ball.setXY(50,70);
        System.out.println(ball);
    }
}
