package DFS;

import java.util.Scanner;

public class BOJ_1138_DFS {

    static int n;
    static int[] leftCnt;
    static int[] people;
    static boolean[] visited;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        leftCnt = new int[n];
        people = new int[n];
        visited = new boolean[n + 1];

        for (int i = 0; i < n; i++) {
            leftCnt[i] = sc.nextInt();
        }

        dfs(0);

    }

    static void dfs(int depth) {
        if (depth == n) {
            if (isOkay(people)) {
                for (int i = 0; i < people.length; i++) {
                    System.out.print(people[i] + " ");
                }
            }
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                people[depth] = i;
                dfs(depth + 1);
                visited[i] = false;
            }
        }
    }

    // 2 3 1 4 arr
    static boolean isOkay(int[] arr) {
        // arr 키 순서
        // lefCnt 조건을 만족하는지
        for (int i = 0; i < arr.length; i++) {
            int cnt = 0;
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[i]) cnt++;
            }

            if (cnt != leftCnt[arr[i] - 1]) {
                return false;
            }
        }

        return true;
    }
}
