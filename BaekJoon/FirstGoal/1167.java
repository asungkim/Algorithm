import java.io.IOException;
import java.util.*;

class Main {

    static int v;
    static List<Edge>[] list;
    static boolean[] visited;
    static int max = Integer.MIN_VALUE;
    static int p = 0;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        v = sc.nextInt();
        list = new ArrayList[v + 1];
        visited = new boolean[v + 1];

        for (int i = 1; i <= v; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < v; i++) {
            int from = sc.nextInt();
            while (true) {
                int to = sc.nextInt();
                if (to == -1) {
                    break;
                }
                int w = sc.nextInt();
                list[from].add(new Edge(to, w));
            }
        }

        dfs(1, 0);

        visited = new boolean[v + 1];
        dfs(p, 0);

        System.out.println(max);
    }

    private static void dfs(int start, int len) {
        if (len > max) {
            max = len;
            p = start;
        }

        visited[start] = true;
        for (Edge next : list[start]) {
            if (!visited[next.to]) {
                dfs(next.to, len + next.w);
            }
        }
    }

    static class Edge {
        int to, w;

        public Edge(int to, int w) {
            this.to = to;
            this.w = w;
        }
    }
}