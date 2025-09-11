package Greedy;

import java.util.Scanner;

public class BOJ_1343_First {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        char[] arr = sc.nextLine().toCharArray();
        StringBuilder sb = new StringBuilder();


        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 'X') {
                if (i + 3 < arr.length) {
                    if (arr[i + 1] == 'X' && arr[i + 2] == 'X' && arr[i + 3] == 'X') {
                        sb.append("AAAA");
                        i += 3;
                        continue;
                    }
                }

                if (i + 1 < arr.length) {
                    if (arr[i + 1] == 'X') {
                        sb.append("BB");
                        i += 1;
                        continue;
                    }
                }

                sb.append("X");
            } else {
                sb.append(".");
            }
        }

        System.out.println(sb.toString().contains("X") ? -1 : sb.toString());
    }
}
