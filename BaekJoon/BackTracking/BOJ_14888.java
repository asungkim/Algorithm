package BackTracking;


import java.util.Scanner;

public class BOJ_14888 {

    static int n;
    static int[] arr;
    static int[] cal = new int[4];
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        for (int i = 0; i < 4; i++) {
            cal[i] = sc.nextInt();
        }

        dfs(1, arr[0]);

        System.out.println(max);
        System.out.println(min);

    }

    static void dfs(int depth, int curSum) {
        if (depth == n) {
            min = Math.min(min, curSum);
            max = Math.max(max, curSum);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (cal[i] > 0) {
                cal[i]--;

                switch (i) {
                    case 0:
                        dfs(depth + 1, curSum + arr[depth]);
                        break;
                    case 1:
                        dfs(depth + 1, curSum - arr[depth]);
                        break;
                    case 2:
                        dfs(depth + 1, curSum * arr[depth]);
                        break;
                    case 3:
                        dfs(depth + 1, curSum / arr[depth]);
                        break;
                }

                cal[i]++;
            }
        }
    }

}
