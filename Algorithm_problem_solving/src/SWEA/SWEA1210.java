package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA1210 {
	static int[] dr = {0,0};
	static int[] dc = {-1,1};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int[][] map;
		for (int test_case=1;test_case<=10;test_case++) {
			int N = Integer.parseInt(br.readLine().trim());
			map = new int [100][100];
			for (int i=0;i<100;i++) {
				st = new StringTokenizer(br.readLine());
				for (int j=0;j<100;j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			int r=99;
			int c=0;
			for (int i=0;i<100;i++) {
				if(map[r][i] == 2) {
					c=i;
				}
			}
			
			while (r>0) {
				for (int i=0;i<2;i++) {
					int nc = c + dc[i];
					if (nc>=0&&nc<100) {
						if (map[r][nc]==1) {
							while (nc>=0&&nc<100&&map[r][nc]!=0) nc+=dc[i];
							c = nc-dc[i];
							break;
						}
					}
				}
				
				r--;
			}
			System.out.printf("#%d %d\n", N, c);
		}
	}
}
