package DFS;

import java.util.Scanner;

public class BOJ_11403 {

    static boolean[] visited;
    static int[][] map;
    static int n;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        map = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < n; i++) {
            visited = new boolean[n];
            dfs(i);
            for (int j = 0; j < n; j++) {
                if (visited[j]) System.out.print(1 + " ");
                else System.out.print(0 + " ");
            }
            System.out.println();
        }

        // 0->3
        // 3->4 , 3->5
    }

    static void dfs(int start) {
        visited[start] = true;
        for (int i = 0; i < n; i++) {
            if (!visited[i] && map[start][i] == 1) {
                dfs(i);
            }
        }
    }
}
