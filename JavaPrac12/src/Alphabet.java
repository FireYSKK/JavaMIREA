import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Alphabet {
    FileReader reader;

    private String getLine() {
        Scanner scanner = new Scanner(reader);

        // Считывание данных из первой строки
        StringBuilder str = new StringBuilder(String.valueOf(scanner.nextLine()));
        System.out.println(str);
        // Разбиение текста на отдельные слова
        StringTokenizer stringTokenizer = new StringTokenizer(str.toString(), " :,.", false);

        // Массив со словами из текста
        ArrayList<String> arrayList = new ArrayList<>();
        int temp = stringTokenizer.countTokens();
        for (int i = 0; i < temp; i++) {
            arrayList.add(stringTokenizer.nextToken());
        }

        int maxSteps = arrayList.size();
        int steps = 0;
        str = new StringBuilder();
        String last = "";
        // Добавление первого элемента в итоговую строку
        if (arrayList.size() > 0) {
            str.append(arrayList.get(0));
            last = arrayList.get(0);
            arrayList.remove(0);
        }

        //  Добавление последующих элементов в строку
        while (steps != maxSteps && arrayList.size() != 0) {
            for (int i = 0; i < arrayList.size(); i++) {
                if (last.toLowerCase().charAt(last.length() - 1) == arrayList.get(i).toLowerCase().charAt(0)) {
                    str.append(" ").append(arrayList.get(i));
                    last = arrayList.get(i);
                    arrayList.remove(i);
                    break;
                }
            }
            steps += 1;
        }
        return str.toString();
    }

    public void test() throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);
        String filename = scanner.nextLine();
        this.reader = new FileReader(filename);
        System.out.println(getLine());
    }
}