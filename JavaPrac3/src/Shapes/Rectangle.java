package Shapes;

public class Rectangle extends Shape{
    protected double width;
    protected double length;

    public Rectangle() {}

    public Rectangle(double width, double length){
        this.setWidth(width);
        this.setLength(length);
    }

    public Rectangle(double width, double length, String color, boolean isFilled){
        super(color, isFilled);
        this.setWidth(width);
        this.setLength(length);
    }

    public double getWidth() {
        return width;
    }
    public void setWidth(double width) {
        if (width >= 0) {
            this.width = width;
        }
        else {
            System.out.println("Cannot be negative");
        }
    }
    public double getLength() {
        return length;
    }
    public void setLength(double length) {
        if (length >= 0) {
            this.length = length;
        }
        else {
            System.out.println("Cannot be negative");
        }
    }

    @Override
    public double getArea() {
        return width*length;
    }

    @Override
    public double getPerimeter() {
        return 2*(width+length);
    }

    @Override
    public String toString() {
        if (isFilled){
            return "Filled "+super.getColor()+" rectangle with width "+this.width+" and length "+this.length;
        }
        else {
            return "Shapes.Rectangle with "+super.getColor()+" border with width "+this.width+" and length "+this.length;
        }
    }
}
