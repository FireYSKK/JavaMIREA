import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class WithDeque {
    private void game(Deque<Integer> player1, Deque<Integer> player2){
        int iteration = 0;
        boolean finish = false;

        for (int i = 0; i < 106; i++) {
            iteration++;
            int card1 = player1.pop();
            int card2 = player2.pop();

            // Кто забирает карты
            if ((card1 > card2 && !(card2 == 0 && card1 == 9)) || (card1 == 0 && card2 == 9)) {
                player1.addLast(card1);
                player1.addLast(card2);
            }
            else if ((card2 > card1) || (card2 == 0 && card1 == 9)) {
                player2.addLast(card1);
                player2.addLast(card2);
            }

            // Проверка конца игры
            if (player1.size() == 0) {
                System.out.println("second " + iteration);
                finish = true;
                break;
            }
            if (player2.size() == 0) {
                System.out.println("first " + iteration);
                finish = true;
                break;
            }
        }
        if (!finish) System.out.println("botva");
    }

    public void test() {
        Deque<Integer> deque1 = new LinkedList<Integer>();
        Deque<Integer> deque2 = new LinkedList<Integer>();
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < 5; i++) {
            deque1.addLast(scanner.nextInt());
        }

        for (int i = 0; i < 5; i++) {
            deque2.addLast(scanner.nextInt());
        }

        game(deque1, deque2);
    }
}
