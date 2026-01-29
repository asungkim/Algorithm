import java.io.IOException;
import java.util.*;

class Main {

    static String s;
    static Stack<Character> st = new Stack<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        s = sc.next();

        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);

            if (cur >= 'A' && cur <= 'Z') {
                sb.append(cur);
            } else if (cur == '(') {
                st.push(cur);
            } else if (cur == ')') {
                while (st.peek() != '(') {
                    sb.append(st.pop());
                }
                st.pop();
            } else {
                while (!st.isEmpty() && prior(st.peek()) >= prior(cur)) {
                    sb.append(st.pop());
                }
                st.add(cur);
            }
        }

        while (!st.isEmpty()) {
            sb.append(st.pop());
        }

        System.out.println(sb.toString());
    }

    private static int prior(char c) {
        if (c == '*' || c == '/') {
            return 2;
        } else if (c == '+' || c == '-') {
            return 1;
        } else
            return 0;
    }
}