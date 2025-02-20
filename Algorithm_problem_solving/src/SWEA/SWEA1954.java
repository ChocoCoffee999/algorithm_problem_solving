package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SWEA1954 {
	static int[] dr = {0,1,0,-1};
	static int[] dc = {1,0,-1,0};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int test_case=1;test_case<=T;test_case++) {
			int count = 1;
			int N = Integer.parseInt(br.readLine());
			int max = (int) Math.pow(N, 2);
			int d=0;
			int r=0;
			int c=0;
			int[][] map =new int[N][N];
			while (count<=max) {
				map[r][c] = count++;
				int nr = r+dr[d];
				int nc = c+dc[d];
				System.out.printf("%d %d\n", r, c);
				if (nr>=0&&nr<N&&nc>=0&&nc<N&&map[nr][nc]!=0) {
					d=(d+1)%4;
					System.out.println(d);
				}
				else if (nr==N) {
					d=(d+1)%4;
					System.out.println(d);
				}
				else if (nr<0) {
					d=(d+1)%4;
					System.out.println(d);
				}
				else if (nc==N) {
					d=(d+1)%4;
					System.out.println(d);
				}
				else if (nc<0) {
					d=(d+1)%4;
					System.out.println(d);
				}
				r+=dr[d];
				c+=dc[d];
			}
			System.out.printf("#%d\n", test_case);
			for (int i=0;i<N;i++) {
				for (int j=0;j<N;j++) {
					System.out.printf("%d ", map[i][j]);
				}
				System.out.println();
			}
			
		}
	}
}
