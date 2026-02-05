import java.util.Scanner;

public class TrafficController {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Enter number of traffic signals: ");
            int n = sc.nextInt();

            if (n <= 0) {
                throw new IllegalArgumentException("Number of signals must be positive.");
            }

            CircularQueue queue = new CircularQueue(n);

            for (int i = 1; i <= n; i++) {
                System.out.print("Enter green light duration (ms) for Signal " + i + ": ");
                int time = sc.nextInt();

                if (time <= 0) {
                    throw new IllegalArgumentException("Time must be positive.");
                }

                queue.enqueue(new TrafficLight("Signal " + i, time));
            }

            System.out.println("\nTraffic Light Simulation Started...\n");

            while (true) {
                TrafficLight currentLight = queue.dequeue();
                Thread t = new Thread(currentLight);
                t.start();
                t.join();
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            sc.close();
        }
    }
}
