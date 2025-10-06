package BackTracking;

import java.util.Scanner;

public class BOJ_14889 {

    static int n;
    static int[][] arr;
    static int answer = Integer.MAX_VALUE;
    static boolean[] visited;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        arr = new int[n][n];
        visited = new boolean[n];


        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        dfs(0, 0);

        System.out.println(answer);
    }

    static void dfs(int depth, int idx) {
        if (depth == n / 2) {
            answer = Math.min(answer, findGap());
            return;
        }

        for (int i = idx; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(depth + 1, i + 1);
                visited[i] = false;
            }
        }
    }

    static int findGap() {
        int s = 0, l = 0;

        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (visited[i] && visited[j]) {
                    s += (arr[i][j] + arr[j][i]);
                } else if (!visited[i] && !visited[j]) {
                    l += (arr[i][j] + arr[j][i]);
                }
            }
        }

        return Math.abs(s - l);
    }
}
