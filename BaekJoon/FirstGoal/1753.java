import java.io.IOException;
import java.util.*;

class Main {

    static int v, e, k;
    static List<Edge>[] list;
    static int maxInt = 987654321;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        v = sc.nextInt();
        e = sc.nextInt();
        k = sc.nextInt();

        list = new ArrayList[v + 1];
        for (int i = 1; i <= v; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < e; i++) {
            // u->v 가중치 w
            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();

            list[u].add(new Edge(v, w));
        }

        int[] answer = dijkstra();
        for (int i = 1; i <= v; i++) {
            if (answer[i] == maxInt) {
                System.out.println("INF");
            } else
                System.out.println(answer[i]);
        }
    }

    private static int[] dijkstra() {
        PriorityQueue<Edge> pq = new PriorityQueue<>((a, b) -> {
            return a.w - b.w;
        });
        boolean[] visited = new boolean[v + 1];
        int[] dist = new int[v + 1];

        pq.add(new Edge(k, 0));
        Arrays.fill(dist, maxInt);
        dist[k] = 0;

        while (!pq.isEmpty()) {
            Edge cur = pq.poll();

            if (visited[cur.to])
                continue;
            visited[cur.to] = true;

            for (Edge next : list[cur.to]) {
                if (!visited[next.to] && dist[next.to] > dist[cur.to] + next.w) {
                    dist[next.to] = dist[cur.to] + next.w;
                    pq.add(new Edge(next.to, dist[next.to]));
                }
            }
        }

        return dist;

    }

    static class Edge {
        int to, w;

        public Edge(int to, int w) {
            this.to = to;
            this.w = w;
        }
    }
}