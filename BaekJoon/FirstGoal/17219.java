import java.io.IOException;
import java.util.*;

class Main {

    static int n, m;
    static Map<String, String> map;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String email = sc.next();
            String pwd = sc.next();
            map.put(email, pwd);
        }

        for (int i = 0; i < m; i++) {
            String s = sc.next();
            System.out.println(map.get(s));
        }
    }
}