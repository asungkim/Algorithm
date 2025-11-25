import java.io.IOException;
import java.util.*;

class Main {

    static int n;
    static PriorityQueue<Long> pq;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            pq.add(sc.nextLong());
        }

        long sum = 0;
        while (true) {
            if (pq.size() == 1) {
                break;
            }

            long a = pq.poll();
            long b = pq.poll();

            sum += (a + b);
            pq.add(a + b);
        }

        System.out.println(sum);
    }
}