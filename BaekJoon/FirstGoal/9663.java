import java.io.IOException;
import java.util.*;

class Main {

    static int n;
    static int answer = 0;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        arr = new int[n];

        // 서로 공격할 수 없게 = 상하좌우, 대각선 겹치는것 없게
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

    private static boolean isOkay(int col) {
        for (int i = 0; i < col; i++) {
            if (arr[i] == arr[col]) {
                return false;
            } else if (Math.abs(i - col) == Math.abs(arr[i] - arr[col])) {
                return false;
            }
        }

        return true;
    }
}