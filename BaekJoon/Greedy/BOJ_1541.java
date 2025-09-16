package Greedy;

import java.util.Scanner;

public class BOJ_1541 {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();
        String[] arr = str.split("-");

        int sum = 0;
        for (String tmp : arr[0].split("\\+")) {
            sum += Integer.parseInt(tmp);
        }

        for (int i = 1; i < arr.length; i++) {
            int tmp = 0;
            for (String s : arr[i].split("\\+")) {
                tmp += Integer.parseInt(s);
            }
            sum -= tmp;
        }

        System.out.println(sum);
    }
}
