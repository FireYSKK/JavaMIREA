import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Recursion rec = new Recursion();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Подсчёт количества 1 в последовательности: (Признак окончания 0 0)");
        System.out.println(rec.recur11());
        System.out.println("Вывод всех нечетных чисел в введенной последовательности: (Признак окончания 0)");
        rec.recur12();
        System.out.println();
        System.out.println("Вывод чисел на нечетных позиция последовательности: (Признак окончания 0)");
        rec.recur13();
        System.out.println();
        System.out.println("Разбиение числа на цифры:");
        rec.recur14(scanner.nextInt());
        System.out.println();
        System.out.println("Разбиение числа на цифры в обратном порядке:");
        rec.recur15(scanner.nextInt());
    }
}
