package Greedy;

import java.util.Scanner;

public class BOJ_21314 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        char[] arr = str.toCharArray();

        StringBuilder max = new StringBuilder();
        StringBuilder min = new StringBuilder();

        // max -> K 나오면 5붙히고, 0 cntM만큼
        // min -> K 나오면 1붙이고, 0 cntM만큼 + 5



        int cntM = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 'M') {
                cntM++;
            } else {
                if (cntM >= 1) {
                    max.append(5);
                    max.append("0".repeat(cntM));

                    min.append(1);
                    min.append("0".repeat(cntM - 1));
                    min.append(5);

                    cntM = 0;
                }
                else {
                    max.append(5);
                    min.append(5);
                }
            }
        }

        // MMM -> 111 , 100
        // MKM

        if (cntM >= 1) {
            max.append("1".repeat(cntM));

            min.append("1");
            min.append("0".repeat(cntM - 1));
        }

        System.out.println(max);
        System.out.println(min);
    }
}
