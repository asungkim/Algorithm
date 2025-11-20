import java.io.IOException;
import java.util.*;

class Main {

    static int n, s;
    static int[] arr;
    static int sum = 0;
    static int min = 100001;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        s = sc.nextInt();
        arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int i = 0, j = 0;
        // 5 1 3 5 10 7 4 9 2 8
        //

        while (true) {
            // 종료 조건
            if (i > j) {
                break;
            }

            if (sum < s) {
                if (j == n)
                    break;
                sum += arr[j++];
            } else {
                min = Math.min(min, j - i);
                sum -= arr[i++];
            }
        }

        System.out.println(min == 100001 ? 0 : min);
    }
}