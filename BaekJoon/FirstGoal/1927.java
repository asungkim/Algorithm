import java.io.IOException;
import java.util.*;

class Main {

    static int n;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        // 최소를 유지시켜주는 즉 최솟값이 앞으로?
        n = sc.nextInt();

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            if (x == 0) {
                if (!pq.isEmpty()) {
                    System.out.println(pq.poll());
                } else
                    System.out.println(0);
            } else {
                pq.add(x);
            }
        }
    }
}