import java.io.IOException;
import java.util.*;

class Main {

    static long n;
    static long MOD = 1000000007;
    static long[][] origin = { { 1, 1 }, { 1, 0 } };

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        n = sc.nextLong();
        long[][] A = { { 1, 1 }, { 1, 0 } };

        System.out.println(pow(A, n - 1)[0][0]);
    }

    private static long[][] pow(long[][] tmp, long exp) {
        if (exp == 1 || exp == 0) {
            return tmp;
        }

        long[][] half = pow(tmp, exp / 2);
        half = multiply(half, half);

        if (exp % 2 == 1L) {
            half = multiply(half, origin);
        }

        return half;
    }

    private static long[][] multiply(long[][] o1, long[][] o2) {
        long[][] tmp = new long[2][2];

        tmp[0][0] = ((o1[0][0] * o2[0][0]) + (o1[0][1] * o2[1][0])) % MOD;
        tmp[0][1] = ((o1[0][0] * o2[0][1]) + (o1[0][1] * o2[1][1])) % MOD;
        tmp[1][0] = ((o1[1][0] * o2[0][0]) + (o1[1][1] * o2[1][0])) % MOD;
        tmp[1][1] = ((o1[1][0] * o2[0][1]) + (o1[1][1] * o2[1][1])) % MOD;

        return tmp;
    }
}