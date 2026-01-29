import java.io.IOException;
import java.util.*;

class Main {

    static int n;
    static int[] arr;
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        arr = new int[n];

        // 같은 행,열,대각선 불가능

        dfs(0);
        System.out.println(answer);
    }

    private static void dfs(int depth) {
        if (depth == n) {
            answer++;
            return;
        }

        for (int i = 0; i < n; i++) {
            arr[depth] = i;
            if (isOkay(depth)) {
                dfs(depth + 1);
            }
        }
    }

    private static boolean isOkay(int c) {
        for (int i = 0; i < c; i++) {
            if (arr[i] == arr[c]) {
                return false;
            } else if (Math.abs(i - c) == Math.abs(arr[i] - arr[c])) {
                return false;
            }
        }

        return true;
    }

}