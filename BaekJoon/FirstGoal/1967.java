import java.io.IOException;
import java.util.*;

class Main {

    static int n;
    static List<Edge>[] list;
    static int INF = 987654321;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        list = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < n - 1; i++) {
            int p = sc.nextInt();
            int c = sc.nextInt();
            int w = sc.nextInt();

            list[p].add(new Edge(c, w));
            list[c].add(new Edge(p, w));
        }

        int[] a = dijkstra(1);
        int maxW = a[1];
        int maxNum = 1;
        for (int i = 1; i <= n; i++) {
            if (a[i] > maxW) {
                maxW = a[i];
                maxNum = i;
            }
        }

        int[] b = dijkstra(maxNum);
        int answer = b[1];
        for (int i = 1; i <= n; i++) {
            if (b[i] != INF) {
                answer = Math.max(answer, b[i]);
            }
        }

        System.out.println(answer);
    }

    private static int[] dijkstra(int start) {
        PriorityQueue<Edge> pq = new PriorityQueue<>((a, b) -> {
            return a.w - b.w;
        });
        boolean[] visited = new boolean[n + 1];
        int[] dist = new int[n + 1];

        pq.add(new Edge(start, 0));
        Arrays.fill(dist, INF);
        dist[start] = 0;

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