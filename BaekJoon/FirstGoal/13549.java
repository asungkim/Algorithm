import java.io.IOException;
import java.util.*;

class Main {

    static int n, k;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        k = sc.nextInt();

        System.out.println(bfs());
    }

    private static int bfs() {
        Deque<int[]> dq = new ArrayDeque<>();
        boolean[] visited = new boolean[100001];

        dq.add(new int[] { n, 0 });
        visited[n] = true;

        while (!dq.isEmpty()) {
            int[] cur = dq.poll();
            int x = cur[0];
            int t = cur[1];

            if (x == k)
                return t;

            int nx = x * 2;
            if (nx <= 100000 && !visited[nx]) {
                visited[nx] = true;
                dq.addFirst(new int[] { nx, t });
            }

            nx = x + 1;
            if (nx <= 100000 && !visited[nx]) {
                visited[nx] = true;
                dq.addLast(new int[] { nx, t + 1 });
            }

            nx = x - 1;
            if (nx >= 0 && !visited[nx]) {
                visited[nx] = true;
                dq.addLast(new int[] { nx, t + 1 });
            }
        }

        return -1;
    }
}