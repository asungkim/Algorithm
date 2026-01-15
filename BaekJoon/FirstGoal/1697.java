import java.io.IOException;
import java.util.*;

class Main {

    static int n, k;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        k = sc.nextInt();

        visited = new boolean[1000001];
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] { n, 0 });
        visited[n] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            if (cur[0] == k) {
                System.out.println(cur[1]);
                return;
            }

            int[] next = { cur[0] - 1, cur[0] + 1, cur[0] * 2 };

            for (int i = 0; i < 3; i++) {
                if (next[i] >= 0 && next[i] <= 100000) {
                    if (!visited[next[i]]) {
                        visited[next[i]] = true;
                        q.add(new int[] { next[i], cur[1] + 1 });
                    }
                }
            }
        }

    }
}