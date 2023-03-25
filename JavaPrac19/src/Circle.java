public class Circle {
    private double xPos;
    private double yPos;
    private double radius;

    public Circle(double xPos, double yPos, double radius) {
        this.xPos = xPos;
        this.yPos = yPos;
        this.radius = radius;
    }

    public void setxPos(double newX) {
        this.xPos = newX;
    }
    public void setyPos(double newY) {
        this.yPos = newY;
    }
    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getxPos() {
        return xPos;
    }
    public double getyPos() {
        return yPos;
    }
    public double getRadius() {
        return radius;
    }

    @Override
    public String toString() {
        return "Circle at ("+xPos+", "+yPos+") with radius "+radius;
    }
}
