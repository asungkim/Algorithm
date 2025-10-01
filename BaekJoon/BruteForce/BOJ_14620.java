package BruteForce;


import java.util.Scanner;

public class BOJ_14620 {

    static int N;
    static int[][] map;
    static int answer = Integer.MAX_VALUE;
    static boolean[][] visited;

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        map = new int[n][n];
        N = n;
        visited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        dfs(0, 0);

        System.out.println(answer);
    }

    static void dfs(int depth, int cost) {
        if (depth == 3) {
            answer = Math.min(answer, cost);
            return;
        }

        for (int i = 1; i < N - 1; i++) {
            for (int j = 1; j < N - 1; j++) {
                if (canPlant(i, j)) {
                    int s = plant(i, j);
                    dfs(depth + 1, cost + s);
                    clear(i, j);
                }
            }
        }
    }

    static void clear(int x, int y) {
        visited[x][y] = false;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            visited[nx][ny] = false;
        }
    }

    static int plant(int x, int y) {
        visited[x][y] = true;

        int sum = map[x][y];
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            visited[nx][ny] = true;
            sum += map[nx][ny];
        }

        return sum;
    }

    static boolean canPlant(int x, int y) {
        if (visited[x][y]) return false;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (visited[nx][ny]) return false;
        }

        return true;
    }
}
