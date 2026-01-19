import java.io.IOException;
import java.util.*;

class Main {

    static int n, p;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            p = sc.nextInt();
            arr[i] = p;
        }

        // 1 2 3 3 4

        Arrays.sort(arr);

        for (int i = 1; i < n; i++) {
            arr[i] += arr[i - 1];
        }

        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
        }

        System.out.println(sum);
    }
}