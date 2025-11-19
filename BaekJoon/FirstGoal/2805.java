import java.io.IOException;
import java.util.*;

class Main {

    static int n;
    static long m;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        // 총 m미터 -> 높이 최대값
        n = sc.nextInt();
        m = sc.nextInt();
        arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(binary());
    }

    // h 높이로 잘랐을때 나오는 나무의 양
    private static long sum(int h) {
        long cnt = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] > h) {
                cnt += (arr[i] - h);
            }
        }
        return cnt;
    }

    private static int binary() {
        int left = 0;
        int right = 1000000000;

        while (left < right) {
            int midH = (left + right) / 2;

            // 목표 m보다 나무가 많으면 덜잘라야함 -> 높이를 높여
            long cnt = sum(midH);
            if (cnt >= m) {
                left = midH + 1;
            } else
                right = midH;
        }

        return left - 1;
    }
}