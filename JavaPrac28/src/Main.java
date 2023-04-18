import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void directoryReader(String path){
        File file = new File(path);
        String[] fileArray = null;

        if (file.exists() || file.isDirectory()) fileArray = file.list();
        else System.out.print("Directory is not available");

        ArrayList list = new ArrayList(Arrays.asList(fileArray));

        for (int i =0; i < list.size() && i < 5;i++)
            System.out.println(list.get(i));
    }

    public static void main(String[] args) {
        System.out.println("\nTask 1");
        directoryReader("C:\\Users\\Timur");

        System.out.println("\nTask 2");
        new Solution().test();
    }
}