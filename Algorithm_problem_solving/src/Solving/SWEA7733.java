import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SWEA7733 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine().trim());
		
		for (int test_case=1;test_case<=T;test_case++) {
			int n = Integer.parseInt(br.readLine().trim());
			int[][] map = new int[n][n];
			int maxTaste = 0;
			int dollop = 1;
			for (int i=0; i<n;i++) {
				String[] input = br.readLine().split(" ");
				for (int j=0; j<n;j++) {
					map[i][j] = Integer.parseInt(input[j]);
					maxTaste = Math.max(maxTaste, map[i][j]);
				}
			}
			System.out.println(maxTaste);
			
			for (int i=1; i<maxTaste; i++) {
				for (int j=0; j<n; j++) {
					for (int k=0; k<n; k++) {
						if (map[j][k] == i) map[j][k] = -1;
					}
				}
				dollop = Math.max(dollop, calculator(map, n));
			}
			
			System.out.printf("#%d %d\n", test_case, dollop);
		}
	}
	
	public static int calculator(int[][] map, int n) {
		boolean[][] v = new boolean[n][n];
		
		int piece = 0;
		for (int i=0;i<n;i++) {
			for (int j=0;j<n;j++) {
				if (map[i][j]!=-1 && !v[i][j]) {
					dfs(map, v, i, j);
					piece++;
				}
			}
		}
		return piece;
	}
	public static void dfs(int[][] map, boolean[][] v, int x, int y) {
		if (v[x][y]) return;
		v[x][y]= true;
		if (x-1>=0 && map[x-1][y]!=-1) {
			dfs(map, v, x-1, y);
		}
		if (x+1<map.length && map[x+1][y]!=-1) {
			dfs(map, v, x+1, y);
		}
		if (y-1>=0 && map[x][y-1]!=-1) {
			dfs(map, v, x, y-1);
		}
		if (y+1<map.length && map[x][y+1]!=-1) {
			dfs(map, v, x, y+1);
		}
		
		return;
	}
}

//-10 -8 -5 1 2 3 5 7 /
