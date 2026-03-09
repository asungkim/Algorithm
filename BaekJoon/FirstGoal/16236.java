import java.io.IOException;
import java.util.*;

class Main {

    static int n;
    static int[][] map;
    static int time = 0;
    static Fish shark;

    static int[][] dir = { { -1, 0 }, { 0, -1 }, { 1, 0 }, { 0, 1 } };

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        // 자신보다 큰 곳 못지나감
        // 자신보다 작은 물고기만 먹을수있음 같으면 지나갈수만있음
        // 가까운 물고기 -> 위 -> 왼쪽

        n = sc.nextInt();
        map = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = sc.nextInt();
                if (map[i][j] == 9) {
                    shark = new Fish(new Point(i, j), 2, 0, 0);
                    map[i][j] = 0;
                }
            }
        }

        while (true) {
            int cnt = canEatFishCnt();
            if (cnt == 0) {
                break;
            } else if (cnt >= 1) {
                int dist = bfs(shark);
                if (dist == -1) {
                    break;
                } else
                    time += dist;
            }

        }

        System.out.println(time);
    }

    private static int bfs(Fish f) {
        Queue<Fish> q = new LinkedList<>();
        boolean[][] visited = new boolean[n][n];

        q.add(f);
        visited[f.p.x][f.p.y] = true;

        int min = Integer.MAX_VALUE;
        int tx = -1, ty = -1;

        while (!q.isEmpty()) {
            Fish cur = q.poll();

            if (cur.dist > min)
                break;

            // 물고기가 있는 자리
            if (map[cur.p.x][cur.p.y] >= 1 && map[cur.p.x][cur.p.y] <= 6) {
                // 먹을 수 있는 물고기
                if (cur.size > map[cur.p.x][cur.p.y]) {
                    // 현재 거리보다 최소가 있으면 갱신
                    if (cur.dist < min) {
                        min = cur.dist;
                        tx = cur.p.x;
                        ty = cur.p.y;
                    }
                    // 같으면
                    else if (cur.dist == min) {
                        // 위->왼 방침 준수
                        if (cur.p.x < tx || (cur.p.x == tx && cur.p.y < ty)) {
                            tx = cur.p.x;
                            ty = cur.p.y;
                        }
                    }
                }
            }

            for (int i = 0; i < 4; i++) {
                int nx = cur.p.x + dir[i][0];
                int ny = cur.p.y + dir[i][1];

                if (nx >= 0 && ny >= 0 && nx < n && ny < n) {
                    if (!visited[nx][ny] && cur.size >= map[nx][ny]) {
                        visited[nx][ny] = true;
                        q.add(new Fish(new Point(nx, ny), cur.size, cur.cnt, cur.dist + 1));
                    }
                }
            }
        }

        if (tx == -1)
            return -1;

        shark.p.x = tx;
        shark.p.y = ty;
        shark.cnt++;
        if (shark.cnt == shark.size) {
            shark.size++;
            shark.cnt = 0;
        }
        map[tx][ty] = 0;

        return min;

    }

    private static int canEatFishCnt() {
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] >= 1 && map[i][j] <= 6) {
                    if (shark.size > map[i][j]) {
                        cnt++;
                    }
                }
            }
        }
        return cnt;
    }

    static class Fish {
        Point p;
        int size;
        int cnt;
        int dist;

        public Fish(Point p, int size, int cnt, int dist) {
            this.p = p;
            this.size = size;
            this.cnt = cnt;
            this.dist = dist;
        }
    }

    static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static void print() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }
}