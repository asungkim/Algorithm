import java.io.IOException;
import java.util.*;

class Main {

    static int n, m;
    static int[][] map;
    static List<int[]> zeroList;
    static List<int[]> virusList;
    static int max = Integer.MIN_VALUE;
    static boolean[] checked;

    static int[] dx = { -1, 0, 1, 0 };
    static int[] dy = { 0, -1, 0, 1 };

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        map = new int[n][m];
        zeroList = new ArrayList<>();
        virusList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = sc.nextInt();
                if (map[i][j] == 0) {
                    zeroList.add(new int[] { i, j });
                }
                if (map[i][j] == 2) {
                    virusList.add(new int[] { i, j });
                }
            }
        }

        checked = new boolean[zeroList.size()];

        dfs(0, 0);

        System.out.println(max);
    }

    private static int[][] copy(int[][] arr) {
        int[][] tmp = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                tmp[i][j] = arr[i][j];
            }
        }

        return tmp;
    }

    private static void print() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

    //
    private static void dfs(int depth, int idx) {
        if (depth == 3) {
            int[][] copyArr = copy(map);
            max = Math.max(max, bfs(copyArr));
            return;
        }

        for (int i = idx; i < zeroList.size(); i++) {
            int[] p = zeroList.get(i);
            if (!checked[i] && map[p[0]][p[1]] == 0) {
                checked[i] = true;
                map[p[0]][p[1]] = 1;
                dfs(depth + 1, i);
                map[p[0]][p[1]] = 0;
                checked[i] = false;
            }
        }
    }

    private static int bfs(int[][] tmp) {
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[n][m];
        for (int[] p : virusList) {
            q.add(new int[] { p[0], p[1] });
        }

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

                if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
                    if (!visited[nx][ny] && tmp[nx][ny] == 0) {
                        visited[nx][ny] = true;
                        tmp[nx][ny] = 2;
                        q.add(new int[] { nx, ny });
                    }
                }
            }
        }

        // 이시점의 0의 개수
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (tmp[i][j] == 0) {
                    cnt++;
                }
            }
        }

        return cnt;
    }
}