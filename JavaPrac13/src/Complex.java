public class Complex {
    private int real;
    private int image;

    public Complex() {
    }

    public Complex(int real, int image) {
        this.real = real;
        this.image = image;
    }

    // Для тестирования

    public String toString() {
        return real + String.format("%1$+1.0f", (float) image).toString() + "i";
    }
}