package SWEA;

import java.util.StringTokenizer;
import java.io.*;

public class SWEA7733_fail {
	static int[][] map;
	static int count;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine().trim());
		
		for (int test_case=1;test_case<=T;test_case++) {
			int n = Integer.parseInt(br.readLine());
			map = new int[n][n];
			int maxTaste = 0;
			int dollop = 1;
			for (int i=0;i<n;i++) {
//				String[] input = br.readLine().trim().split(" ");
//				for (int j=0;j<n;j++) {
//					map[i][j] = Integer.parseInt(input[j]);
//					maxTaste = Math.max(maxTaste, map[i][j]);
//				}
//				
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j=0;j<n;j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					maxTaste = Math.max(maxTaste, map[i][j]);
				}
			}
			
			for (int day=1; day<maxTaste;day++) {
//				System.out.printf("Day : %d\n", day);
				for (int i=0;i<n;i++) {
					for (int j=0;j<n;j++) {
						if (map[i][j]==day) map[i][j] = -1;
					}
				}
				dollop = Math.max(dollop, calculator(n));
			}
			System.out.printf("#%d %d\n", test_case, dollop);
		}
	}

	public static int calculator(int n) {
		boolean[][] v = new boolean[n][n];
		int piece = 0;
		for (int i=0;i<n;i++) {
			for (int j=0;j<n;j++) {
				if(v[i][j]) continue;
				if (map[i][j]!=-1) {
//					System.out.printf("I : %d, J : %d\n", i, j);
					dfs(v, i, j);
					piece++;
				}
			}
		}
		return piece;
	}
	public static void dfs(boolean[][] v, int x, int y) {
		System.out.printf("x : %d, y : %d\n", x, y);
		v[x][y]= true;
		
		if (x-1>=0 && map[x-1][y]!=-1 && !v[x-1][y]) {
			dfs(v, x-1, y);
		}
		if (x+1<map.length && map[x+1][y]!=-1 && !v[x+1][y]) {
			dfs(v, x+1, y);
		}
		if (y-1>=0 && map[x][y-1]!=-1 && !v[x][y-1]) {
			dfs(v, x, y-1);
		}
		if (y+1<map.length && map[x][y+1]!=-1 && !v[x][y+1]) {
			dfs(v, x, y+1);
		}
		
		return;
	}
}