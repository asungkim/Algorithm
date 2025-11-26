import java.io.IOException;
import java.util.*;

class Main {

    static int n;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        // 둘다 낮은 경우가 있으면 선발 x
        // 본인 기준으로 하나라도 둘다 우월한 사람이 있으면 탈락
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            n = sc.nextInt();
            arr = new int[n][2];

            for (int j = 0; j < n; j++) {
                int a = sc.nextInt();
                int b = sc.nextInt();
                arr[j][0] = a;
                arr[j][1] = b;
            }

            Arrays.sort(arr, (a, b) -> a[0] - b[0]);

            int cnt = 1;
            int best = arr[0][1];
            for (int j = 1; j < n; j++) {
                if (best > arr[j][1]) {
                    best = arr[j][1];
                    cnt++;
                }
            }

            System.out.println(cnt);
        }

        // (3,2) (1,4) (4,1) (2,3) (5,5)
        // (1,4) (2,3) (3,2) (4,1) (5,5)

        // (3,6) (7,3) (4,2) (1,4) (5,7) (2,5) (6,1)
        // (1,4) (2,5) (3,6) (4,2) (5,7) (6,1) (7,3)

    }
}