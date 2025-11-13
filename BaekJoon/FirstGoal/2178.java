import java.io.IOException;
import java.util.*;

class Main {

    static int n,m;
    static int[][] map;
    static int min=Integer.MAX_VALUE;
    static int[] dx={-1,0,1,0};
    static int[] dy={0,-1,0,1};

    public static void main(String[] args) throws IOException {
        Scanner sc=new Scanner(System.in);

        n=sc.nextInt();
        m=sc.nextInt();

        map=new int[n+1][m+1];

        for (int i=1;i<=n;i++) {
            char[] tmp=sc.next().toCharArray();
            for (int j=1;j<=m;j++) {
                map[i][j]=tmp[j-1]-'0';
            }
        }

        bfs();
        System.out.println(min);

        // for (int i=1;i<=n;i++) {
        //     for (int j=1;j<=m;j++) {
        //         System.out.print(map[i][j]+" ");
        //     }
        //     System.out.println();
        // }
    }

    private static void bfs() {
        Queue<int[]> q=new LinkedList<>();
        boolean[][] visited=new boolean[n+1][m+1];
        q.add(new int[]{1,1,1});

        while (!q.isEmpty()) {
            int[] cur=q.poll();

            if (cur[0]==n && cur[1]==m) {
                min=Math.min(min,cur[2]);
            }

            for (int i=0;i<4;i++) {
                int nx=cur[0]+dx[i];
                int ny=cur[1]+dy[i];

                if (nx>=1 && ny>=1 && nx<=n && ny<=m) {
                    if (!visited[nx][ny] && map[nx][ny]==1) {
                        visited[nx][ny]=true;
                        q.add(new int[]{nx,ny,cur[2]+1});
                    }
                }
            }
        }
    }
}