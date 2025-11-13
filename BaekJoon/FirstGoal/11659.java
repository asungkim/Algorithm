import java.io.IOException;
import java.util.*;

class Main {

    static int n, m;
    static int[] arr;
    static int[] sum;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        arr = new int[n + 1];
        sum = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = sc.nextInt();
        }

        for (int i = 1; i <= n; i++) {
            sum[i] = (sum[i - 1] + arr[i]);
        }

        for (int i = 0; i < m; i++) {
            int s = sc.nextInt();
            int e = sc.nextInt();
            System.out.println(sum[e] - sum[s - 1]);
        }
    }
}