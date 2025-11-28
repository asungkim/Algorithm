import java.io.IOException;
import java.util.*;

class Main {

    static int L, C;
    static String[] arr;
    static String mo = "aeiou";
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        // L개 alp 소문자
        // 알파뱃 증가순서
        L = sc.nextInt();
        C = sc.nextInt();
        arr = new String[C];
        for (int i = 0; i < C; i++) {
            arr[i] = sc.next();
        }

        Arrays.sort(arr);

        dfs(0, 0, "");
    }

    private static boolean isOkay(String s) {
        int cnt1 = 0, cnt2 = 0;

        for (char c : s.toCharArray()) {
            if (mo.contains(String.valueOf(c)))
                cnt1++;
            else
                cnt2++;
        }

        return cnt1 >= 1 && cnt2 >= 2;
    }

    private static void dfs(int depth, int idx, String s) {
        if (depth == L) {
            if (isOkay(s)) {
                System.out.println(s);
            }
            return;
        }

        for (int i = idx; i < C; i++) {
            dfs(depth + 1, i + 1, s + arr[i]);
        }
    }
}