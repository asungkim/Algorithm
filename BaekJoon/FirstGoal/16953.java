import java.io.IOException;
import java.util.*;

class Main {

    static int a, b;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        a = sc.nextInt();
        b = sc.nextInt();

        // dfs((long) a, 0);
        // System.out.println(min == Integer.MAX_VALUE ? -1 : min + 1);
        System.out.println(find(a, b));
    }

    //
    private static int find(int a, int b) {
        int cnt = 0;
        while (b != a) {
            if (b < a)
                return -1;

            if (b % 10 == 1) {
                b /= 10;
            } else if (b % 2 == 0) {
                b /= 2;
            } else {
                return -1;
            }

            cnt++;
        }

        return cnt + 1;
    }

    // private static void dfs(long start, int cnt) {
    // if (start > b)
    // return;
    // if (start == b) {
    // min = Math.min(cnt, min);
    // return;
    // }

    // dfs(start * 2, cnt + 1);
    // dfs((start * 10) + 1, cnt + 1);
    // }
}