import java.io.IOException;
import java.util.*;

class Main {

    static int n, r, c;
    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        r = sc.nextInt();
        c = sc.nextInt();

        recur((int) Math.pow(2, n), r, c);

        System.out.println(cnt);
    }

    private static void recur(int size, int x, int y) {
        if (size == 1) {
            return;
        }

        if (x < size / 2 && y < size / 2) {
            recur(size / 2, x, y);
        } else if (x < size / 2 && y >= size / 2) {
            cnt += (size * size / 4);
            recur(size / 2, x, y - size / 2);
        } else if (x >= size / 2 && y < size / 2) {
            cnt += (size * size / 4) * 2;
            recur(size / 2, x - size / 2, y);
        } else {
            cnt += (size * size / 4) * 3;
            recur(size / 2, x - size / 2, y - size / 2);
        }
    }
}