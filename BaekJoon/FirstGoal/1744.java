import java.io.IOException;
import java.util.*;

class Main {

    static int n;
    static int[] arr;
    static long sum = 0;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);

        // -1 1 2 3
        // 0 + (2x3)

        // 0 1 2 3 4 5
        // 1+(2x3)+(4x5)

        for (int i=0;i<n;i+=2) {
            if (i+1<n) {
                int max=Math.max()
            }           
            else {

            } 
        }

    }
}