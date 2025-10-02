package DFS;

import java.util.Scanner;

public class BOJ_10552 {

    static boolean[] visited;
    static int cnt = 0;
    static int[] hateToLike;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        // 모두가 싫어하지 않는 채널이 되면 -> 채널이 바뀐 횟수 출력
        // 무한이면 -1


        int n = sc.nextInt(); // 사람 수
        int m = sc.nextInt(); // 채널 수
        int p = sc.nextInt(); // 최초 채널

        visited = new boolean[m + 1];
        hateToLike = new int[m + 1];


        for (int i = 0; i < n; i++) {
            int a = sc.nextInt(); // 좋
            int b = sc.nextInt(); // 싫

            if (hateToLike[b] == 0) hateToLike[b] = a;
        }

        dfs(p);

        System.out.println(cnt);

    }

    static void dfs(int start) {
        if (visited[start]) {
            cnt = -1;
        } else if (hateToLike[start] != 0) {
            cnt++;
            visited[start] = true;
            dfs(hateToLike[start]);
        }
    }
}
