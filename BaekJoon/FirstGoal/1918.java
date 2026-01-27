import java.io.IOException;
import java.util.*;

class Main {

    static String s;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        // A+B*C-D/E
        // A+(B*C)-(D/E)
        // (A+(B*C))-(D/E)
        // ABC*+DE/-

        // 1. 연산 순위에 따라서 괄호를 다 만들어줌
        // 2. () 사이에 +,- 있는 경우 split
        // 3. split 된 단위마다 해체작업

        s = sc.next();

    }

    private static void make() {
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '*' || c == '/') {
                // 앞뒤로 숫자
                char f = s.charAt(i - 1);
                char b = s.charAt(i + 1);
            } else {
                sb.append(c);
            }
        }
    }
}