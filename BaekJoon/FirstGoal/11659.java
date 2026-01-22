import java.io.IOException;
import java.util.*;

class Main {

    static int n, m;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        for (int i = 1; i < n; i++) {
            arr[i] += arr[i - 1];
        }

        for (int i = 0; i < m; i++) {
            int s = sc.nextInt() - 1;
            int e = sc.nextInt() - 1;

            if (s >= 1) {
                System.out.println(arr[e] - arr[s - 1]);
            } else
                System.out.println(arr[e]);

        }
    }
}