import java.util.Scanner;
import java.util.Objects;

public class ThrowsDemo {
//  <-- Ex 5 -->
//    public void printMessage(String key) {
//        try {
//            String message = getDetails(key);
//            System.out.println( message );
//        } catch (NullPointerException e) {
//            System.out.println("null");
//        }
//    }
//
//    public String getDetails(String key) {
//        if(key == null) {
//             throw  new NullPointerException( "null key in getDetails" );
//        }
//        return "data for " + key;
//    }

//  <-- Ex 6 -->
    /*public void getKey() throws Exception {
        Scanner myScanner = new Scanner( System.in );
        String key = myScanner.nextLine();
        try {
            printDetails( key );
        }  catch (Exception e) {
            getKey();
        }
    }

    public void printDetails(String key) throws Exception {
        String message = getDetails(key);
        System.out.println( message );
    }

    private String getDetails(String key) throws Exception {
        if(key.equals("")) {
            throw new Exception( "Key set to empty string" );
        }
        return "data for " + key; }*/

    //  <-- Ex7 -->
    public void getKey() {
        Scanner myScanner = new Scanner( System.in );
        System.out.print("Enter Key ");
        String key = myScanner.nextLine();
        try {
            printDetails( key );
        }  catch (Exception e) {
            getKey();
        }
    }

    public void printDetails(String key) throws Exception {
        String message = getDetails(key);
        System.out.println( message );
    }

    private String getDetails(String key) throws Exception {
        if(key.equals("")) {
            throw new Exception( "Key set to empty string" );
        }
        return "data for " + key;
    }
}