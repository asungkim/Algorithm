package BackTracking;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_1759 {

    static String[] arr;
    static int l, c;
    static boolean[] visited;
    static String mo = "aeiou";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        l = sc.nextInt();
        c = sc.nextInt();
        arr = new String[c];
        visited = new boolean[c];


        for (int i = 0; i < c; i++) {
            arr[i] = sc.next();
        }

        Arrays.sort(arr);
        dfs(0, 0);


    }

    static void dfs(int depth, int idx) {
        if (depth == l) {
            String str = makeStr();
            if (isOkay(str)) {
                System.out.println(str);
            }
            return;
        }

        for (int i = idx; i < c; i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(depth + 1, i + 1);
                visited[i] = false;
            }
        }
    }

    static String makeStr() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            if (visited[i]) {
                sb.append(arr[i]);
            }
        }

        return sb.toString();
    }

    static boolean isOkay(String s) {
        int cnt1 = 0, cnt2 = 0;
        for (char c : s.toCharArray()) {
            if (mo.contains(String.valueOf(c))) {
                cnt1++;
            } else cnt2++;
        }

        return cnt1 >= 1 && cnt2 >= 2;
    }


}
