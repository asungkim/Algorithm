import java.io.IOException;
import java.util.*;

class Main {

    static int n;
    static long[] arr;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        arr = new long[101];
        arr[1] = 1;
        arr[2] = 1;
        arr[3] = 1;
        arr[4] = 2;
        arr[5] = 2;
        for (int i = 6; i <= 100; i++) {
            arr[i] = arr[i - 1] + arr[i - 5];
        }

        int t = sc.nextInt();

        for (int k = 0; k < t; k++) {
            n = sc.nextInt();
            System.out.println(arr[n]);
        }
    }
}