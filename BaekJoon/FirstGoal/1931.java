import java.io.IOException;
import java.util.*;

class Main {

    static int n;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        arr = new int[n][2];

        for (int i = 0; i < n; i++) {
            int s = sc.nextInt();
            int e = sc.nextInt();

            arr[i][0] = s;
            arr[i][1] = e;
        }

        if (n == 1) {
            System.out.println(1);
            return;
        }

        Arrays.sort(arr, (a, b) -> {
            if (a[1] == b[1]) {
                return a[0] - b[0];
            } else
                return a[1] - b[1];
        });

        int end = arr[0][1]; // 4
        int cnt = 1;
        for (int i = 1; i < n; i++) {
            int curS = arr[i][0];
            if (curS >= end) {
                cnt++;
                end = arr[i][1];
            }
        }

        System.out.println(cnt);
    }
}