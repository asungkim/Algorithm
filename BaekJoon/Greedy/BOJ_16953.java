package Greedy;

import java.util.Scanner;

public class BOJ_16953 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        String b = sc.next();


        // 맨뒤가 1이면 1제거, 짝수면 2로 나누기, (3,5,7,9) -> x
        int cnt = 0;
        while (true) {
            int num = Integer.parseInt(b);

            if (a == num) {
                System.out.println(cnt + 1);
                return;
            }

            if (a > num) {
                System.out.println(-1);
                return;
            }

            int last = b.charAt(b.length() - 1) - '0';
            if (last == 1) {
                b = b.substring(0, b.length() - 1);
            } else if (last % 2 == 0) {
                num /= 2;
                b = String.valueOf(num);
            } else {
                System.out.println(-1);
                break;
            }

            cnt++;
        }

    }
}
