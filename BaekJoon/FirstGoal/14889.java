import java.io.IOException;
import java.util.*;

class Main {

    static int n;
    static int[][] arr;
    static int min = Integer.MAX_VALUE;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        arr = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        visited = new boolean[n + 1];

        divide(0, 1, new ArrayList<>());
        System.out.println(min);

        // 팀나누기 -> 나눈팀에 대해서 합 구하기 -> 최솟값인지 체크
    }

    private static int findGap() {
        int sum1 = 0, sum2 = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = i + 1; j <= n; j++) {
                if (visited[i] && visited[j]) {
                    sum1 += (arr[i][j] + arr[j][i]);
                } else if (!visited[i] && !visited[j]) {
                    sum2 += (arr[i][j] + arr[j][i]);
                }
            }
        }

        return Math.abs(sum1 - sum2);
    }

    private static void divide(int depth, int start, List<Integer> list) {
        if (depth == n / 2) {
            min = Math.min(min, findGap());

            return;
        }

        for (int i = start; i <= n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                divide(depth + 1, i + 1, list);
                visited[i] = false;
            }
        }
    }
}