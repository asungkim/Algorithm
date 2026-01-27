import java.io.IOException;
import java.util.*;

class Main {

    static long a, b, c;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        a = sc.nextLong();
        b = sc.nextLong();
        c = sc.nextLong();

        // (a^b)%c
        // = (a*a*a...*a)%c
        // = ((a%c)*(a%c)...*(a%c))%c

        System.out.println(pow(a, b));
    }

    private static long pow(long x, long y) {
        if (y == 1) {
            return x % c;
        }

        long tmp = pow(x, y / 2);

        if (y % 2 == 1) {
            return (tmp * tmp % c) * x % c;
        }
        return tmp * tmp % c;
    }

}