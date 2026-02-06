import java.io.IOException;
import java.util.*;

class Main {

    static int n, k;
    static int max = 100001;
    static int INF = 987654321;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        k = sc.nextInt();

        // n->k
        // bfs형태인데 가중치가 1말고 0도 가능하다
        // -> 0-1 BFS(Deque) , 다익스트라
        // System.out.println(dijkstra(n));
        System.out.println(bfs(n));
    }

    private static int bfs(int start) {
        Deque<int[]> dq = new ArrayDeque<>();
        int[] dist = new int[max + 1];

        Arrays.fill(dist, INF);
        dist[start] = 0;
        dq.add(new int[] { start, 0 });

        while (!dq.isEmpty()) {
            int[] cur = dq.poll();
            int curP = cur[0];
            int curT = cur[1];

            if (curT > dist[curP])
                continue;

            if (curP == k) {
                return curT;
            }

            int[] nextP = { curP + 1, curP - 1, curP * 2 };
            int[] addTime = { 1, 1, 0 };

            for (int i = 0; i < 3; i++) {
                int target = nextP[i];
                int nextTime = curT + addTime[i];

                if (target >= 0 && target <= max) {
                    if (dist[target] > nextTime) {
                        dist[target] = nextTime;
                        if (i == 2) {
                            dq.addFirst(new int[] { target, nextTime });
                        } else {
                            dq.addLast(new int[] { target, nextTime });
                        }
                    }

                }
            }

        }

        return -1;
    }

    private static int dijkstra(int start) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            return a[1] - b[1];
        });
        boolean[] visited = new boolean[max + 1];
        int[] time = new int[max + 1];

        Arrays.fill(time, INF);
        time[start] = 0;

        pq.add(new int[] { start, 0 });

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int curP = cur[0];
            int curT = cur[1];

            if (curT > time[curP])
                continue;

            if (visited[curP])
                continue;
            visited[curP] = true;

            if (curP == k) {
                return curT;
            }

            int[] nextP = { curP + 1, curP - 1, curP * 2 };
            int[] addTime = { 1, 1, 0 };

            for (int i = 0; i < 3; i++) {
                int targetP = nextP[i];
                int nextTime = curT + addTime[i];

                if (targetP >= 0 && targetP <= max) {
                    if (time[targetP] > nextTime) {
                        time[targetP] = nextTime;
                        pq.add(new int[] { targetP, nextTime });
                    }
                }
            }
        }

        return -1;
    }

}