import java.io.IOException;
import java.util.*;

class Main {

    static int n, m;
    static int[][] map;
    static boolean[][][] visited;
    static int min = Integer.MAX_VALUE;
    static int[] dx = { -1, 0, 1, 0 };
    static int[] dy = { 0, -1, 0, 1 };

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        map = new int[n + 1][m + 1];
        visited = new boolean[n + 1][m + 1][2];
        // 0 안부시고 방문 , 1 부시고 방문

        for (int i = 1; i <= n; i++) {
            char[] arr = sc.next().toCharArray();
            for (int j = 1; j <= m; j++) {
                map[i][j] = arr[j - 1] - '0';
            }
        }

        bfs();
        System.out.println(min == Integer.MAX_VALUE ? -1 : min);
    }

    private static void bfs() {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(1, 1, 1, 0));
        visited[1][1][0] = true;

        while (!q.isEmpty()) {
            Node cur = q.poll();

            if (cur.x == n && cur.y == m) {
                min = Math.min(min, cur.dist);
            }

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (nx >= 1 && ny >= 1 && nx <= n && ny <= m) {
                    // 벽이야
                    if (map[nx][ny] == 1) {
                        // 부실수 있으면 부시고 방문
                        if (cur.cnt == 0) {
                            visited[nx][ny][1] = true;
                            q.add(new Node(nx, ny, cur.dist + 1, cur.cnt + 1));
                        }
                    }
                    // 벽이아니면
                    else {
                        if (!visited[nx][ny][cur.cnt]) {
                            visited[nx][ny][cur.cnt] = true;
                            q.add(new Node(nx, ny, cur.dist + 1, cur.cnt));
                        }
                    }
                }
            }
        }
    }

    static class Node {
        int x, y, dist, cnt;

        public Node(int x, int y, int dist, int cnt) {
            this.x = x;
            this.y = y;
            this.dist = dist;
            this.cnt = cnt;
        }
    }
}