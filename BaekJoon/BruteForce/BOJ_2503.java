package BruteForce;

import java.util.Scanner;

public class BOJ_2503 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[][] arr = new int[n][3];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        int cnt = 0;


        for (int i = 123; i <= 987; i++) {
            // 숫자가 서로 다른 지
            if (isOkay(i)) {
                // i 와 arr 비교
                boolean flag = true;
                for (int j = 0; j < n; j++) {
                    if (!check(i, arr[j])) {
                        flag = false;
                        break;
                    }
                }

                if (flag) {
                    cnt++;
                }
            }
        }

        System.out.println(cnt);

    }

    static boolean check(int a, int[] b) {
        // a ~ b[0]의 st,ball 개수 같은지
        int[] aArr = give(a);
        int[] bArr = give(b[0]);

        int st = 0;
        // st 체크
        for (int i = 0; i < 3; i++) {
            if (aArr[i] == bArr[i]) {
                st++;
            }
        }

        int ball = 0;
        // aArr[0] -> bArr[1],[2] 에 있나?
        if (aArr[0] == bArr[1] || aArr[0] == bArr[2]) {
            ball++;
        }

        if (aArr[1] == bArr[0] || aArr[1] == bArr[2]) {
            ball++;
        }

        if (aArr[2] == bArr[1] || aArr[2] == bArr[0]) {
            ball++;
        }

        return (st == b[1] && ball == b[2]);
    }

    static int[] give(int num) {
        String str = String.valueOf(num);
        int[] arr = new int[3];
        for (int i = 0; i < 3; i++) {
            arr[i] = str.charAt(i) - '0';
        }
        return arr;
    }

    static boolean isOkay(int num) {
        int[] arr = give(num);
        if (arr[0] == 0 || arr[1] == 0 || arr[2] == 0) return false;
        return (arr[0] != arr[1] && arr[1] != arr[2] && arr[2] != arr[0]);
    }
}
