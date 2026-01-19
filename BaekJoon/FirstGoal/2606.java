import java.io.IOException;
import java.util.*;

class Main {

    static int n, m;
    static List<Integer>[] map;
    static boolean[] visited;
    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        map = new ArrayList[n + 1];
        visited = new boolean[n + 1];

        for (int i = 1; i <= n; i++) {
            map[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            map[a].add(b);
            map[b].add(a);
        }

        // dfs(1);

        // System.out.println(cnt - 1);
        System.out.println(bfs(1));
    }

    private static void dfs(int start) {
        visited[start] = true;
        cnt++;

        for (int next : map[start]) {
            if (!visited[next]) {
                dfs(next);
            }
        }
    }

    private static int bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visited[start] = true;
        int cnt = 0;

        while (!q.isEmpty()) {
            int cur = q.poll();

            for (int next : map[cur]) {
                if (!visited[next]) {
                    visited[next] = true;
                    q.add(next);
                    cnt++;
                }
            }
        }

        return cnt;
    }
}