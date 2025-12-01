import java.io.IOException;
import java.util.*;

class Main {

    static int n;
    static int[] arr = new int[26];

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        // 맨앞에 나오고, 많이 나온거일수록 가중치가 높음
        for (int i = 0; i < n; i++) {
            String word = sc.next();
            for (int j = 0; j < word.length(); j++) {
                char alp = word.charAt(j);
                arr[alp - 'A'] += (int) Math.pow(10, word.length() - 1 - j);
            }
        }

        Arrays.sort(arr);

        int sum = 0;
        int num = 9;
        for (int i = arr.length - 1; i >= 0 && arr[i] != 0; i--, num--) {
            arr[i] *= num;
            sum += arr[i];
        }

        System.out.println(sum);
    }
}