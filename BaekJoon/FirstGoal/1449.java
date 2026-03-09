import java.io.IOException;
import java.util.*;

class Main {

    static int n, l;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        l = sc.nextInt();
        arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);

        // 1 2 3 4
        // 시작 -> 1-0.5
        // 끝 -> 4+0.5
        int answer = 1;

        double start = arr[0] - 0.5;
        double max = start + l;

        for (int i = 1; i < n; i++) {
            if (arr[i] > max) {
                answer++;
                start = arr[i] - 0.5;
                max = start + l;
            }
        }

        System.out.println(answer);

    }
}