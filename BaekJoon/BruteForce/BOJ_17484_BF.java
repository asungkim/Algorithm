package BruteForce;

import java.util.Scanner;

public class BOJ_17484_BF {

    static int N, M;
    static int[][] arr;
    static int[] dy = {-1, 0, 1};
    static int min = Integer.MAX_VALUE;
    static int[] visited;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        arr = new int[n][m];
        N = n;
        M = m;


        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < m; i++) {
            visited = new int[N];
            visited[0] = i;
            dfs(0, i, -1);
        }

        System.out.println(min);
    }

    static void dfs(int depth, int x, int dir) {
        if (depth == N) {
            int sum = 0;
            for (int i = 0; i < N; i++) {
                sum += arr[i][visited[i]];
            }
            min = Math.min(min, sum);
            return;
        }

        for (int i = 0; i < 3; i++) {
            int nx = x + dy[i];
            if (nx >= 0 && nx < M && dir != i) {
                visited[depth] = nx;
                dfs(depth + 1, nx, i);
            }
        }
    }
}
