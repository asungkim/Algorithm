import java.io.IOException;
import java.util.*;

class Main {

    static int n, m;
    static int[][] arr;
    static int[][] sum;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        arr = new int[n + 1][n + 1];
        sum = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                sum[i][j] = sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1] + arr[i][j];
            }
        }

        // for (int i = 1; i <= n; i++) {
        // for (int j = 1; j <= n; j++) {
        // System.out.print(sum[i][j] + " ");
        // }
        // System.out.println();
        // }

        for (int i = 0; i < m; i++) {
            int x1 = sc.nextInt();
            int y1 = sc.nextInt();
            int x2 = sc.nextInt();
            int y2 = sc.nextInt();

            // (x1,y1) ~ (x2,y2)
            // (2,2) ~ (3,4)
            // sum[3][4]-sum[1][4]-sum[3][1]+sum[1][1]
            System.out.println(sum[x2][y2] - sum[x1 - 1][y2] - sum[x2][y1 - 1] + sum[x1 - 1][y1 - 1]);
        }

        // sum[2][2]=sum[1][2]+sum[2][1]-sum[1][1]+arr[2][2]
        // sum[2][3]=sum[2][2]+sum[1][3]-sum[1][2]+arr[2][3]

    }
}