import java.io.IOException;
import java.util.*;

class Main {

    static int n;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx={-1,0,1,0};
    static int[] dy={0,-1,0,1};


    public static void main(String[] args) throws IOException {
        Scanner sc=new Scanner(System.in);

        n=sc.nextInt();
        map=new int[n][n];
        visited=new boolean[n][n];
        
        for (int i=0;i<n;i++) {
            char[] tmp=sc.next().toCharArray();
            for (int j=0;j<n;j++) {
                map[i][j]=tmp[j]-'0';
            }
        }

        PriorityQueue<Integer> pq=new PriorityQueue<>();
        for (int i=0;i<n;i++) {
            for (int j=0;j<n;j++) {
                if (!visited[i][j] && map[i][j]==1) {
                    pq.add(bfs(i,j));
                }
            }
        }

        System.out.println(pq.size());
        while (!pq.isEmpty()) {
            System.out.println(pq.poll());
        }


        // for (int i=0;i<n;i++) {
        //     for (int j=0;j<n;j++) {
        //         System.out.print(map[i][j]+" ");
        //     }
        //     System.out.println()
        // }
    }

    private static int bfs(int x,int y) {
        Queue<int[]> q=new LinkedList<>();
        q.add(new int[]{x,y});
        visited[x][y]=true;
        int cnt=1;

        while (!q.isEmpty()) {
            int[] cur=q.poll();

            for (int i=0;i<4;i++) {
                int nx=cur[0]+dx[i];
                int ny=cur[1]+dy[i];

                if (nx>=0 && ny>=0 && nx<n && ny<n) {
                    if (!visited[nx][ny] && map[nx][ny]==1) {
                        visited[nx][ny]=true;
                        q.add(new int[]{nx,ny});
                        cnt++;
                    }
                }
            }
        }

        return cnt;
    }
}