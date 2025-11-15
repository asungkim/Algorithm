import java.io.IOException;
import java.util.*;

class Main {

    static int n, k;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        k = sc.nextInt();

        Queue<int[]> q = new LinkedList<>();
        boolean[] visited = new boolean[100001];

        q.add(new int[] { n, 0 });
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int curX = cur[0];

            if (cur[0] == k) {
                System.out.println(cur[1]);
                return;
            }

            int[] next = { curX - 1, curX + 1, curX * 2 };
            for (int i = 0; i < 3; i++) {
                int nx = next[i];
                if (nx >= 0 && nx <= 100000 && !visited[nx]) {
                    visited[nx] = true;
                    q.add(new int[] { nx, cur[1] + 1 });
                }
            }
        }
    }

}