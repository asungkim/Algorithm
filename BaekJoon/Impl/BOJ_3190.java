package Impl;

import java.util.*;

public class BOJ_3190 {

    static int curDir = 0;
    static int n, k, l;
    static int[][] map;
    static Queue<Info> infoQ = new LinkedList<>();
    static Deque<int[]> snake = new ArrayDeque<>();
    static int[][] dir = {{0, 1}, {-1, 0}, {0, -1}, {1, 0}}; // 동북서남

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        map = new int[n + 1][n + 1];
        k = sc.nextInt();

        for (int i = 1; i <= k; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            map[x][y] = 1;
        }

        l = sc.nextInt();
        for (int i = 0; i < l; i++) {
            int time = sc.nextInt();
            String s = sc.next();
            infoQ.add(new Info(time, s));
        }


        int curTime = 0;
        snake.add(new int[]{1, 1});
        while (true) {
            curTime++;

            // 1. 먼저 머리를 다음칸에 이동
            move();
            // 2. 머리가 벽이나 몸과 부딪히면 끝
            if (isOver()) break;

            int[] head = snake.peekLast();
            // 3. 괜찮은데 사과가 있으면
            if (map[head[0]][head[1]] == 1) {
                map[head[0]][head[1]] = 0;
            } else {
                snake.removeFirst();
            }

            if (!infoQ.isEmpty() && infoQ.peek().time == curTime) {
                Info cur = infoQ.poll();
                turn(cur.dir);
            }
        }

        System.out.println(curTime);
    }

    private static void turn(String dir) {
        if (dir.equals("L")) {
            curDir = (curDir + 1) % 4;
        } else curDir = (curDir + 3) % 4;
    }

    private static void move() {
        int[] head = snake.peekLast();
        int[] next = new int[]{head[0] + dir[curDir][0], head[1] + dir[curDir][1]};
        snake.addLast(next);
    }

    private static boolean isOver() {
        int[] head = snake.peekLast();
        if (head[0] < 1 || head[1] < 1 || head[0] > n || head[1] > n) return true;
        int cnt = 0;
        for (int[] xy : snake) {
            if (xy[0] == head[0] && xy[1] == head[1]) cnt++;
        }

        return cnt >= 2;
    }


    private static class Info {
        int time;
        String dir;

        public Info(int time, String dir) {
            this.time = time;
            this.dir = dir;
        }
    }
}
