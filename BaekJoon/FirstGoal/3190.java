import java.io.IOException;
import java.util.*;

class Main {

    static int n, k, l;
    static int[][] map;

    // 동남서북
    static int x = 0, y = 0, d = 0;
    static Queue<int[]> snake;
    static int[][] dir = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
    static int time = 0;
    static Map<Integer, String> turnMap;
    static Queue<Integer> q;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        k = sc.nextInt();

        turnMap = new HashMap<>();
        q = new LinkedList<>();
        snake = new LinkedList<>();
        snake.add(new int[] { 0, 0 });

        map = new int[n][n];

        for (int i = 0; i < k; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            map[x - 1][y - 1] = 1;
        }

        l = sc.nextInt();
        for (int i = 0; i < l; i++) {
            int x = sc.nextInt();
            String c = sc.next();
            turnMap.put(x, c);
            q.add(x);
        }

        run();
        System.out.print(time + 1);
    }

    private static void run() {
        while (true) {

            int nx = x + dir[d][0];
            int ny = y + dir[d][1];

            if (!canMove(nx, ny)) {
                break;
            }

            snake.add(new int[] { nx, ny });
            if (map[nx][ny] == 1) {
                map[nx][ny] = 0;
            } else {
                snake.poll();
            }

            x = nx;
            y = ny;
            time++;

            if (!q.isEmpty() && time == q.peek()) {
                rotate(turnMap.get(q.poll()));
            }
        }
    }

    private static boolean canMove(int nx, int ny) {
        if (nx < 0 || ny < 0 || nx >= n || ny >= n)
            return false;

        for (int[] p : snake) {
            if (nx == p[0] && ny == p[1])
                return false;
        }
        return true;
    }

    private static void rotate(String s) {
        // 시계반대 동->북
        if (s.equals("L")) {
            d = (d + 3) % 4;
        } else
            d = (d + 1) % 4;
    }

    private static void print() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }
}