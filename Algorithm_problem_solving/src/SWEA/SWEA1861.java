package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA1861 {
	static int[][] map;
	static int ans;
	static int N;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(st.nextToken());
		
		for (int test_case=1;test_case<=T;test_case++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			map = new int[N][N];
			
			for (int i=0;i<N;i++) {
				st = new StringTokenizer(br.readLine());
				for (int j=0;j<N;j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int max = 0;
			int roomN = 0;
			for (int i=0;i<N;i++) {
				for (int j=0;j<N;j++) {
					ans = 0;
					bfs(i,j);
					if (max<ans) {
						max = ans;
						roomN = map[i][j];
					}
					else if (max==ans&&roomN>map[i][j]) roomN=map[i][j];
				}
			}
			sb.append("#"+test_case+" "+roomN+" "+max+"\n");
		}
		
		System.out.print(sb);
		
		
		
	}
	
	static int[] dr = {0,0,1,-1};
	static int[] dc = {1,-1,0,0};
	public static void bfs(int r, int c) {
		Queue<Pos> q = new ArrayDeque<>();
		q.offer(new Pos(r,c));
		ans++;
		while (q.size()>0) {
			Pos pos = q.poll();
			for (int d=0;d<4;d++) {
				int nr = pos.r+dr[d];
				int nc = pos.c+dc[d];
				if (nr>=0&&nr<N&&nc>=0&&nc<N&&map[pos.r][pos.c]+1==map[nr][nc]) {
					ans++;
					q.add(new Pos(nr, nc));
					break;
				}
			}
		}
	}
	
	static class Pos {
		int r;
		int c;
		
		Pos(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
}
