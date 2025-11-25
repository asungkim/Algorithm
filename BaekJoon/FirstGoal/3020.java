import java.io.IOException;
import java.util.*;

class Main {

    static int n, h;
    static int[] down1;
    static int[] up1;

    static int[] down2;
    static int[] up2;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        h = sc.nextInt();
        down1 = new int[n / 2];
        up1 = new int[n / 2];
        down2 = new int[h + 2];
        up2 = new int[h + 2];

        for (int i = 0; i < n / 2; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            down2[a]++;
            up2[h - b + 1]++;
        }

        for (int i = 1; i <= h; i++) {
            down2[i] += down2[i - 1];
        }

        for (int i = h; i >= 1; i--) {
            up2[i] += up2[i + 1];
        }

        // for (int i = 0; i < n / 2; i++) {
        // down1[i] = sc.nextInt();
        // up1[i] = sc.nextInt();
        // }

        // Arrays.sort(down1);
        // Arrays.sort(up1);

        int min = Integer.MAX_VALUE;
        int cnt = 1;

        for (int i = 1; i <= h; i++) {
            int diff = (down2[h] - down2[i - 1]) + (up2[1] - up2[i + 1]);

            if (diff < min) {
                min = diff;
                cnt = 1;
            } else if (diff == min)
                cnt++;
        }

        // for (int i = 1; i <= h; i++) {
        // int downCrush = binarySearch(i, down1);
        // int upCrush = binarySearch(h - i + 1, up1);

        // if (min > downCrush + upCrush) {
        // min = downCrush + upCrush;
        // cnt = 1;
        // } else if (min == downCrush + upCrush) {
        // cnt++;
        // }
        // }

        System.out.println(min + " " + cnt);

    }

    // minN -> 길이가 h이상인 장애물들의 최초 idx
    // (n/2)-minN = 충돌하는 장애물의 개수
    private static int binarySearch(int h, int[] tmp) {
        int left = 0, right = n / 2 - 1;
        int minN = Integer.MAX_VALUE;
        while (left <= right) {
            int mid = (left + right) / 2;

            if (tmp[mid] >= h) {
                minN = Math.min(minN, mid);
                right = mid - 1;
            } else
                left = mid + 1;
        }

        return minN == Integer.MAX_VALUE ? 0 : (n / 2) - minN;
    }
}