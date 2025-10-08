package BFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_2644 {

    static int[][] map;
    static boolean[] visited;
    static int answer = -1;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int a = sc.nextInt();
        int b = sc.nextInt();
        int m = sc.nextInt();

        // a,b 의 촌수
        map = new int[n + 1][n + 1];
        visited = new boolean[n + 1];

        for (int i = 0; i < m; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();

            map[x][y] = 1;
            map[y][x] = 1;
        }

        Queue<Node> q = new LinkedList<>();
        q.add(new Node(a, 0));
        visited[a] = true;

        while (!q.isEmpty()) {
            Node cur = q.poll();

            if (cur.num == b) {
                answer = cur.cnt;
                break;
            }

            for (int i = 0; i < map.length; i++) {
                if (map[cur.num][i] == 1 && !visited[i]) {
                    visited[i] = true;
                    q.add(new Node(i, cur.cnt + 1));
                }
            }

        }

        System.out.println(answer);

    }

    static class Node {
        int num, cnt;

        public Node(int num, int cnt) {
            this.num = num;
            this.cnt = cnt;
        }
    }
}
