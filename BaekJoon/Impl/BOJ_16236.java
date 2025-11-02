package Impl;

import java.util.*;

public class BOJ_16236 {

    static int n;
    static int[][] map;
    static int totalTime = 0;
    static int sharkX = 0, sharkY = 0;
    static int sharkSize = 2, eatCount = 0;

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        map = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = sc.nextInt();

                if (map[i][j] == 9) {
                    sharkX = i;
                    sharkY = j;
                    map[i][j] = 0;
                }
            }
        }


        while (true) {
            int time = findShortTime();

            if (time == -1) break; // 먹을 물고기 없으면 반환

            totalTime += time;
            eatCount++;

            if (sharkSize == eatCount) {
                sharkSize++;
                eatCount = 0;
            }
        }

        System.out.println(totalTime);

    }

    private static int findShortTime() {
        PriorityQueue<Node> q = new PriorityQueue<>((a, b) -> {
            if (a.dist != b.dist) {
                return a.dist - b.dist;
            } else {
                if (a.x != b.x) {
                    return a.x - b.x;
                } else return a.y - b.y;
            }
        });

        boolean[][] visited = new boolean[n][n];

        q.add(new Node(sharkX, sharkY, 0));
        visited[sharkX][sharkY] = true;


        while (!q.isEmpty()) {
            Node cur = q.poll();

            // 물고기가 있고, 상어가 더 크다면,
            // 빈칸처리, 상어이동, 거리반환
            if (map[cur.x][cur.y] > 0 && map[cur.x][cur.y] < sharkSize) {
                map[cur.x][cur.y] = 0;
                sharkX = cur.x;
                sharkY = cur.y;

                return cur.dist;
            }

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < n && ny < n) {
                    // 지나갈 수 있다면 추가해
                    if (!visited[nx][ny] && map[nx][ny] <= sharkSize) {
                        visited[nx][ny] = true;
                        q.add(new Node(nx, ny, cur.dist + 1));
                    }
                }
            }
        }

        return -1;
    }

    private static class Node {
        int x, y, dist;

        public Node(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }
}
