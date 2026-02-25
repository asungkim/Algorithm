import java.io.IOException;
import java.util.*;

class Main {

    static int k, n;
    static int[] arr;
    static int max = -1;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        k = sc.nextInt();
        n = sc.nextInt();

        arr = new int[k];
        for (int i = 0; i < k; i++) {
            arr[i] = sc.nextInt();
            max = Math.max(max, arr[i]);
        }

        System.out.println(binarySearch());
    }

    private static long binarySearch() {
        long l = 1;
        long r = arr[k - 1];
        long answer = -1;

        // 401 -> 1 1 1 2
        // 200 -> 4 3 2 2

        while (l <= r) {
            long mid = (l + r) / 2;

            if (count(mid) >= n) {
                answer = Math.max(answer, mid);
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return answer;
    }

    private static long count(long cm) {
        long cnt = 0;
        for (int i = 0; i < k; i++) {
            cnt += (arr[i] / cm);
        }

        return cnt;
    }
}