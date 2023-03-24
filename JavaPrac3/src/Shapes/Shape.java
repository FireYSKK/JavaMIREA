package Shapes;

public abstract class Shape {
    protected String color;
    protected boolean isFilled;

    public Shape() {}
    public Shape(String color, boolean isFilled){
        this.setColor(color);
        this.setFilled(isFilled);
    }

    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public boolean isFilled() {
        return isFilled;
    }
    public void setFilled(boolean filled) {
        isFilled = filled;
    }

    public abstract double getArea();
    public abstract double getPerimeter();

    @Override
    public abstract String toString();
}
