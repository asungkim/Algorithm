import java.io.IOException;
import java.util.*;

class Main {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        String[] arr1 = sc.next().split("-");

        int sum = Integer.MAX_VALUE;

        for (int i = 0; i < arr1.length; i++) {
            int tmp = 0;
            String[] arr2 = arr1[i].split("\\+");

            for (int j = 0; j < arr2.length; j++) {
                tmp += Integer.valueOf(arr2[j]);
            }

            if (sum == Integer.MAX_VALUE) {
                sum = tmp;
            } else {
                sum -= tmp;
            }
        }

        System.out.println(sum);

    }
}