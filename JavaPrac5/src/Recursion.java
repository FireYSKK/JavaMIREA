import java.util.Scanner;

public class Recursion {
    Scanner scanner = new Scanner(System.in);

    public int recur11(){
        int n = scanner.nextInt();
        if (n == 0) {
            if (scanner.hasNextInt()){
                n = scanner.nextInt();
                if (n == 0) return 0;
                else if (n == 1) return recur11()+1;
                return recur11();
            }
        }
        else if (n == 1) {
            return recur11()+1;
        }
        return recur11();
    }

    public void recur12() {
        int n = scanner.nextInt();
        if (n == 0){
            return;
        }
        if (n % 2 == 1){
            System.out.print(n+" ");
        }
        recur12();
    }

    public void recur13(){
        int n = scanner.nextInt();
        if (n == 0){
            return;
        }
        System.out.print(n+" ");
        if (scanner.hasNextInt()) {
            n = scanner.nextInt();
            if (n == 0) return;
        }
        recur13();
    }

    public void recur14(int n) {
        if (n < 10)
            System.out.print(n+" ");
        else {
            recur14(n / 10);
            System.out.print((n%10)+" ");
        }
    }

    public void recur15(int n) {
        if (n < 10)
            System.out.print(n+" ");
        else {
            System.out.print((n%10)+" ");
            recur15(n / 10);
        }
    }
}
