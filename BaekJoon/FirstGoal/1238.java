import java.io.IOException;
import java.util.*;

class Main {

    static int n, m, x;
    static List<Edge>[] list;
    static List<Edge>[] revList;
    static final int INF = 987654321;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        x = sc.nextInt();

        list = new ArrayList[n + 1];
        revList = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
            revList[i] = new ArrayList<>();
        }

        int[][] map = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == j) {
                    map[i][j] = 0;
                } else
                    map[i][j] = INF;
            }
        }

        for (int i = 0; i < m; i++) {
            int s = sc.nextInt();
            int e = sc.nextInt();
            int t = sc.nextInt();

            list[s].add(new Edge(e, t));
            revList[e].add(new Edge(s, t));

            map[s][e] = t;
        }

        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    map[i][j] = Math.min(map[i][j], map[i][k] + map[k][j]);
                }
            }
        }

        // 1~n -> x
        // x -> 1~n
        // int[] a = dijkstra(list, x);
        // int[] b = dijkstra(revList, x);
        int max = Integer.MIN_VALUE;
        // for (int i = 1; i <= n; i++) {
        // max = Math.max(max, a[i] + b[i]);
        // }

        for (int i = 1; i <= n; i++) {
            max = Math.max(max, map[i][x] + map[x][i]);
        }

        System.out.println(max);
    }

    private static int[] dijkstra(List<Edge>[] tmp, int start) {
        PriorityQueue<Edge> pq = new PriorityQueue<>((a, b) -> {
            return a.t - b.t;
        });
        boolean[] visited = new boolean[n + 1];
        int[] dist = new int[n + 1];

        Arrays.fill(dist, INF);
        pq.add(new Edge(start, 0));
        dist[start] = 0;

        while (!pq.isEmpty()) {
            Edge cur = pq.poll();

            if (visited[cur.to])
                continue;
            visited[cur.to] = true;

            for (Edge next : tmp[cur.to]) {
                if (!visited[next.to] && dist[next.to] > dist[cur.to] + next.t) {
                    dist[next.to] = dist[cur.to] + next.t;
                    pq.add(new Edge(next.to, dist[next.to]));
                }
            }
        }

        return dist;
    }

    static class Edge {
        int to, t;

        public Edge(int to, int t) {
            this.to = to;
            this.t = t;
        }
    }
}
