import java.io.IOException;
import java.util.*;

class Main {

    static int n, m;
    static int[][] arr;
    static int INF = 987654321;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        arr = new int[n + 1][n + 1];

        // 초기값 설정
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == j) {
                    arr[i][j] = 0;
                } else
                    arr[i][j] = INF;
            }
        }

        // 입력값 중복 시 작은값 선택
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();

            if (arr[a][b] == INF) {
                arr[a][b] = c;
            } else {
                arr[a][b] = Math.min(arr[a][b], c);
            }

        }

        // 플로이드 워셜 로직 (i->j 보다 i->k->j 가 작으면 갱신)
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (arr[i][j] > arr[i][k] + arr[k][j]) {
                        arr[i][j] = arr[i][k] + arr[k][j];
                    }
                }
            }
        }

        print();
    }

    private static void print() {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (arr[i][j] == INF) {
                    arr[i][j] = 0;
                }
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}