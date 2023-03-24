package Shapes;

public class Square extends Rectangle{
    public Square() {}

    public Square(double side){
        super(side, side);
    }

    public Square(double side, String color, boolean isFilled){
        super(side, side, color, isFilled);
    }

    public double getSide() {
        return width;
    }
    public void setSide(double side){
        if (side >= 0) {
            this.width = side;
            this.length = side;
        }
        else {
            System.out.println("Cannot be negative");
        }
    }
    public void setWidth(double side) {
        this.setSide(side);
    }
    public void setLength(double side) {
        this.setSide(side);
    }

    @Override
    public String toString() {
        if (isFilled){
            return "Filled "+super.getColor()+" square with side "+this.width;
        }
        else {
            return "Shapes.Square with "+super.getColor()+" square with side "+this.width;
        }
    }
}
