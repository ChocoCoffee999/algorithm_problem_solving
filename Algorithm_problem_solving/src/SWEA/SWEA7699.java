package SWEA;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SWEA7699 {
	static char[][] map;
	static int[] dx = {0,0,-1,1};
	static int[] dy = {-1,1,0,0};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		
		int T = Integer.parseInt(br.readLine().trim());
		
		for (int test_case=1;test_case<=T;test_case++) {
			String[] input = br.readLine().trim().split(" ");
			int r = Integer.parseInt(input[0]);
			int c = Integer.parseInt(input[1]);
			map = new char[r][];
			for (int i=0;i<r;i++) {
				String str = br.readLine().trim();
				for (int j=0;j<c;j++) {
					map[i] = str.toCharArray();
				}
			}
			System.out.printf("#%d %d\n", test_case, dfs(new boolean[r][c], new boolean[26], 0,0,0));
			
		}
	}
	
	public static int dfs(boolean[][] v, boolean[] a, int x, int y, int count) {
//		System.out.printf("x : %d, y : %d, count : %d\n", x, y, count);
		v[x][y] = true;
		if (a[map[x][y]-'A']) return count;
		a[map[x][y]-'A'] = true;
		int maxCount = 0;
		for (int i=0; i<4; i++) {
			if (x+dx[i]>=0&&x+dx[i]<v.length&&y+dy[i]>=0&&y+dy[i]<v[0].length) {
				if (v[x+dx[i]][y+dy[i]]) continue;
				v[x+dx[i]][y+dy[i]] = true;
				maxCount = Math.max(maxCount , dfs(v, a, x+dx[i], y+dy[i],count+1));
				v[x+dx[i]][y+dy[i]] = false;
			}
		}
		a[map[x][y]-'A'] = false;
		return Math.max(maxCount, count+1);
	}
}
