import java.io.IOException;
import java.util.*;

class Main {

    static int k, n;
    static int[] arr;
    static int maxLen = -1;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        // 제각각 k개 랜선 -> 같은길이 n개 랜선
        // 최대 랜선의 길이
        k = sc.nextInt();
        n = sc.nextInt();
        arr = new int[k];

        for (int i = 0; i < k; i++) {
            arr[i] = sc.nextInt();
            maxLen = Math.max(maxLen, arr[i]);
        }

        System.out.println(binarySearch());
    }

    private static long count(long cm) {
        long sum = 0;
        for (int i = 0; i < k; i++) {
            sum += (arr[i] / cm);
        }
        return sum;
    }

    private static long binarySearch() {
        long left = 1;
        long right = maxLen;
        long maxCm = -1;

        while (left <= right) {
            long mid = (left + right) / 2;
            long cnt = count(mid);

            if (cnt >= n) {
                maxCm = Math.max(maxCm, mid);
                left = mid + 1;
            } else {
                right = mid - 1;
            }

        }

        return maxCm;
    }
}