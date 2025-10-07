package BackTracking;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BOJ_15686 {

    static int n, m;
    static int[][] map;
    static int answer = Integer.MAX_VALUE;
    static List<Point> pointList = new ArrayList<>();
    static List<Point> chickenList = new ArrayList<>();
    static boolean[] isOpen;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 치킨거리의 합 최소
        n = sc.nextInt();
        m = sc.nextInt();
        map = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = sc.nextInt();
                if (map[i][j] == 2) {
                    chickenList.add(new Point(i, j));
                }
                if (map[i][j] == 1) {
                    pointList.add(new Point(i, j));
                }
            }
        }

        isOpen = new boolean[chickenList.size()];

        dfs(0, 0);

        System.out.println(answer);
    }

    static void dfs(int depth, int idx) {
        if (depth == m) {
            answer = Math.min(answer, findMin());
            return;
        }

        for (int i = idx; i < chickenList.size(); i++) {
            if (!isOpen[i]) {
                isOpen[i] = true;
                dfs(depth + 1, i + 1);
                isOpen[i] = false;
            }
        }
    }

    static int findMin() {
        int sum = 0;
        for (int i = 0; i < pointList.size(); i++) {
            int min = 10000;
            for (int j = 0; j < chickenList.size(); j++) {
                if (isOpen[j]) {
                    min = Math.min(min, findDist(pointList.get(i), chickenList.get(j)));
                }
            }
            sum += min;
        }

        return sum;
    }

    static int findDist(Point a, Point b) {
        return Math.abs(a.x - b.x) + Math.abs(a.y - b.y);
    }

    static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
