package Moving;

public class TestMovable {
    public static void main(String[] args) {
        MovableCircle movableCircle = new MovableCircle(2,3,1,-1,2);
        System.out.println(movableCircle);
        movableCircle.moveUp();
        movableCircle.moveUp();
        movableCircle.moveRight();
        System.out.println(movableCircle);

        System.out.println();

        MovableRectangle movableRectangle = new MovableRectangle(1,7,5,2,1,1);
        System.out.println(movableRectangle);
        movableRectangle.moveDown();
        movableRectangle.moveRight();
        System.out.println(movableRectangle);
    }
}
