import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Prac18 {
    public static void main(String[] args) {
        System.out.println("Task1:");
        task1();
        System.out.println("\nTask2:");
        task2(args);
        System.out.println("\nTask3:");
        task3();
        System.out.println("\nTask4:");
        task4();
        System.out.println("\nTask5:");
        task5();
    }

    public static void task1() {
        int[] array = new int[10];
        Random random = new Random();
        for (int i=0; i<10; i++){
            array[i] = random.nextInt(100);
        }
        System.out.println("Generated array: " + Arrays.toString(array));

        int s = 0;
        for (int num: array) {
            s+=num;
        }
        System.out.println("Sum using \"for\": " + s);

        s = 0;
        int i = 0;
        while (i < array.length) {
            s+=array[i];
            i++;
        }
        System.out.println("Sum using \"while\": " + s);

        s = 0;
        i = 0;
        do {
            s+=array[i];
            i++;
        } while (i < array.length);
        System.out.println("Sum using \"do while\": " + s);
    }
    public static void task2(String[] args) {
        System.out.print("Command line arguments: [");
        for (String arg: args) {
            System.out.print(arg+" ");
        }
        System.out.println("]");
    }
    public static void task3() {
        System.out.println("Harmonic series: ");
        for (int i=1; i<=10; i++){
            System.out.print(String.format("%.3f", 1.0/i) + " ");
        }
        System.out.println();
    }
    public static void task4() {
        int[] array = new int[10];
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            array[i] = random.nextInt(100);
        }
        System.out.println("Generated array: " + Arrays.toString(array));

        Arrays.sort(array);

        System.out.println("Sorted array: " + Arrays.toString(array));
    }
    public static void task5() {
        Scanner scanner = new Scanner(System.in);
        int num;
        System.out.print("Enter an integer (up to 20): ");
        if (scanner.hasNextInt()) {
            num = scanner.nextInt();
        }
        else {
            System.out.println("NaN");
            return;
        }
        if (num > 20 || num < 0) {
            System.out.println("Number is not appropriate");
            return;
        }
        long factorial = 1;
        while (num > 1) {
            factorial *= num;
            num--;
        }
        System.out.println("Factorial for your number is " + factorial);
    }
}
