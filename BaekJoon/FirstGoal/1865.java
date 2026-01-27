import java.io.IOException;
import java.util.*;

class Main {

    static int n, m, w;
    static List<Edge>[] list;

    static int INF = 987654321;
    static int[] dist;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int tc = sc.nextInt();

        for (int i = 0; i < tc; i++) {
            n = sc.nextInt();
            m = sc.nextInt();
            w = sc.nextInt();

            dist = new int[n + 1];
            list = new ArrayList[n + 1];
            for (int j = 1; j <= n; j++) {
                list[j] = new ArrayList<>();
            }

            // 도로 정보
            for (int j = 0; j < m; j++) {
                int s = sc.nextInt();
                int e = sc.nextInt();
                int t = sc.nextInt();

                list[s].add(new Edge(e, t));
                list[e].add(new Edge(s, t));
            }

            // 웜홀 정보
            for (int j = 0; j < w; j++) {
                int s = sc.nextInt();
                int e = sc.nextInt();
                int t = sc.nextInt();

                list[s].add(new Edge(e, -t));
            }

            boolean hasCycle = canBackMinus();
            System.out.println(hasCycle ? "YES" : "NO");
        }
    }

    private static boolean canBackMinus() {
        Arrays.fill(dist, 0);

        for (int i = 1; i <= n; i++) {
            boolean isUpdate = false;

            for (int j = 1; j <= n; j++) {
                for (Edge e : list[j]) {
                    if (dist[e.end] > dist[j] + e.time) {
                        dist[e.end] = dist[j] + e.time;
                        isUpdate = true;

                        if (i == n) {
                            return true;
                        }
                    }
                }
            }
            if (!isUpdate)
                break;
        }

        return false;
    }

    static class Edge {
        int end, time;

        public Edge(int end, int time) {
            this.end = end;
            this.time = time;
        }
    }
}