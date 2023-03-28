import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class WithQueue {
    private void game(Queue<Integer> player1, Queue<Integer> player2){
        int iteration = 0;
        boolean finish = false;

        for (int i = 0; i < 106; i++) {
            iteration++;
            int card1 = player1.poll();
            int card2 = player2.poll();

            // Кто забирает карты
            if ((card1 > card2 && !(card2 == 0 && card1 == 9)) || (card1 == 0 && card2 == 9)) {
                player1.offer(card1);
                player1.offer(card2);
            }
            else if ((card2 > card1) || (card2 == 0 && card1 == 9)) {
                player2.offer(card1);
                player2.offer(card2);
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
        Queue<Integer> queue1 = new LinkedList<Integer>();
        Queue<Integer> queue2 = new LinkedList<Integer>();
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < 5; i++) {
            queue1.offer(scanner.nextInt());
        }

        for (int i = 0; i < 5; i++) {
            queue2.offer(scanner.nextInt());
        }

        game(queue1, queue2);
    }
}
