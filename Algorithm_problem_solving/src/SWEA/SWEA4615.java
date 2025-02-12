package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA4615 {
	static int[][] map;
	static int[] dr = {0,0,1,1,1,-1,-1,-1};
	static int[] dc = {1,-1,0,1,-1,0,1,-1};
	static int N;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		
		for (int test_case=1;test_case<=T;test_case++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int r;
			int c;
			int type;
			map = new int[N+1][N+1];
			
			map[N/2][N/2] = 2;
			map[N/2+1][N/2] = 1;
			map[N/2][N/2+1] = 1;
			map[N/2+1][N/2+1] = 2;
			
			for (int i=0;i<M;i++) {
				st = new StringTokenizer(br.readLine());
				c = Integer.parseInt(st.nextToken());
				r = Integer.parseInt(st.nextToken());
				type = Integer.parseInt(st.nextToken());
				
				bfs(r, c, type);

			}
			
			int type1 = 0;
			int type2 = 0;
			for (int i=1;i<=N;i++) {
				for (int j=1;j<=N;j++) {
					if (map[i][j]==1) type1++;
					else if (map[i][j]==2) type2++;
				}
			}
			
			System.out.printf("#%d %d %d\n", test_case, type1, type2);
		}

	}
	
	public static void bfs(int r, int c, int type) {
		map[r][c]=type;
		Queue<Pos4615> que = new ArrayDeque<>();
		for (int i=0;i<8;i++) {
			Pos4615 start = new Pos4615(r, c, dr[i], dc[i]);
			que.offer(start);
		}
		
		while (que.size()>0) {
			Pos4615 curPos = que.poll();
			if (curPos.check()) {
				curPos.move();
				if (map[curPos.r][curPos.c]==0) continue;
				if (map[curPos.r][curPos.c]!=type) que.offer(curPos);
				else {
					curPos.flip(r, c, type);
				}
			}
		}
	}
	
	static class Pos4615 {
		public int r;
		public int c;
		public int dr;
		public int dc;
		
		Pos4615(int r, int c, int dr, int dc) {
			this.r = r;
			this.c = c;
			this.dr = dr;
			this.dc = dc;
		}
		
		public void move() {
			r+=dr;
			c+=dc;
		}
		
		public void flip(int r, int c, int type) {
			int n = Math.max(Math.abs(this.r-r), Math.abs(this.c-c));
			for (int i=1;i<n;i++) {
				map[r+dr*i][c+dc*i] = type;
			}
		}
		
		public boolean check() {
			return (r+dr>=1&&r+dr<=N&&c+dc>=1&&c+dc<=N);
		}
	}
}