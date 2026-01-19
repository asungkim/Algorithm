import java.io.IOException;
import java.util.*;

class Main {

    static int n;
    static int m, h;
    static int[] arr;
    static int min = 0, max = 0;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        arr = new int[n];

        for (int i = 0; i < n; i++) {
            h = sc.nextInt();
            arr[i] = h;
            max = Math.max(max, h);
        }

        System.out.println(binary());
    }

    private static long hSum(int h) {
        long sum = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] > h) {
                sum += (Math.abs(arr[i] - h));
            }
        }

        return sum;
    }

    private static int binary() {
        while (min < max) {
            int mid = (min + max) / 2;

            long sum = hSum(mid);
            if (sum >= m) {
                min = mid + 1;
            } else {
                max = mid;
            }
        }

        return min - 1;
    }
}