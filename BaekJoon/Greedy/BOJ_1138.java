package Greedy;

import java.util.Scanner;

public class BOJ_1138 {

    static int n;
    static int[] leftCnt;
    static int[] answer;


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        leftCnt = new int[n];
        answer = new int[n];

        for (int i = 0; i < n; i++) {
            leftCnt[i] = sc.nextInt();
        }

        for (int i = 1; i <= n; i++) {
            int cnt = leftCnt[i - 1];
            for (int j = 0; j < n; j++) {
                if (answer[j] == 0) {
                    if (cnt == 0) {
                        answer[j] = i;
                        break;
                    }
                    cnt--;
                }
            }
        }

        for (int i = 0; i < answer.length; i++) {
            System.out.print(answer[i] + " ");
        }
    }
}



