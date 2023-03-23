import java.util.Random;

public class Ball {
    private String type;
    private double size;
    public Ball(String type, double size){
        this.type = type;
        if (size > 0) {
            this.size = size;
        }
        else {
            System.out.println("Diameter can't be negative. Value not assigned");
        }
    }
    public Ball(String n){
        type = n;
        size = 20;
    }
    public Ball(){
        type = "Common";
        size = 20;
    }
    public void setSize(int size) {
        if (size > 0) {
            this.size = size;
        }
        else {
            System.out.println("Diameter can't be negative. Value not assigned");
        }
    }
    public void setType(String type) {
        this.type = type;
    }
    public String getType(){
        return this.type;
    }
    public double getSize() {
        return this.size;
    }
    public String toString(){
        return this.type+", diameter "+this.size+" cm";
    }
    public void throwBall() {
        Random random = new Random();
        System.out.println(this.type+" flew "+String.format("%.2f", Math.max(0,(100-size)/3))+" meters");
    }
    public void kickBall() {
        if (type.equals("Volleyball")) {
            System.out.println("Coach yelled at you for kicking volleyball");
        }
        else {
            System.out.println(this.type+" flew "+String.format("%.2f", Math.max(0,(120-size)/3))+" meters");
        }
    }
}