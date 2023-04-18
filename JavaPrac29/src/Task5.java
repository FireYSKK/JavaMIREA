import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task5 {
    public void test() {
        System.out.println("Date checker");
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();
        String regEx = "^(([0-2]\\d)|(3[0-1])|([1-9]))/((1[0-2])|(0*[1-9]))/((19\\d{2})|([2-9]\\d{3}))";

        Pattern pattern = Pattern.compile(regEx);
        Matcher matcher = pattern.matcher(string);
        if (matcher.find()) {
            int[] date = new int[3];

            // Разбиение строки
            for (int i = 0; i < 3; i++)
                date[i] = Integer.parseInt(string.split("/")[i]);

            // Проверка на корректность даты
            if (isDate(date[0], date[1], date[2])) {
                System.out.println("Correct");
            }
            else System.out.println("Incorrect");
        }
        else System.out.println("Incorrect");
    }

    private boolean isDate(int d, int m, int y) {
        int[] days = new int[]{31, 0, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        boolean leap = (y % 4 == 0 && y % 100 != 0 || y % 400 == 0);
        if (leap && m == 2 && d > 29) {return false;}
        if (!leap && m == 2 && d > 28) {return false;}
        return days[m - 1] >= d || m == 2;
    }
}