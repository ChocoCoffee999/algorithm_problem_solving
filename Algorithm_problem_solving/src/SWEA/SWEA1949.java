package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA1949 {
	static int[][] map;
	static int N;
	static int K;
	static int Ans=0;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(st.nextToken());
		
		for (int test_case=1; test_case<=T; test_case++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			Ans = 0;
			map = new int[N][N];
			int max = 0;
			for (int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j=0; j<N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					max = Math.max(max, map[i][j]);
				}
			}
			for (int i=0; i<N; i++) {
				for (int j=0; j<N; j++) {
					if (map[i][j]==max) bfs(i, j);
				}
			}
			
			sb.append("#"+test_case+" "+Ans+"\n");
		}
		System.out.println(sb);
	}
	static int[] dr = {0,0,1,-1};
	static int[] dc = {1,-1,0,0};
	public static void bfs(int r, int c) {
		Queue<Pos> que = new ArrayDeque<>();
		que.offer(new Pos(r, c,map[r][c], 1, false, 1L<<(N*r+c)));
		
		while (!que.isEmpty()) {
			Pos cur = que.poll();
			Ans = Math.max(Ans, cur.dist);
			for (int d=0; d<4; d++) {
				int nr = cur.r + dr[d];
				int nc = cur.c + dc[d];
				if (nr>=0&&nr<N&&nc>=0&&nc<N&&(cur.bitmask&1L<<(N*nr+nc))==0) {
					if (map[nr][nc]<cur.height) {
						que.offer(new Pos(nr, nc, map[nr][nc], cur.dist+1, cur.brake, cur.bitmask|1L<<(N*nr+nc)));
					}
					if (!cur.brake) {
						for (int i=1;i<=K;i++) {
							if (map[nr][nc]-i<cur.height) {
								que.offer(new Pos(nr, nc, map[nr][nc]-i, cur.dist+1, true,  cur.bitmask|1L<<(N*nr+nc)));
							}
						}
					}
				}
			}
		}
	}
	
	static class Pos {
		int r;
		int c;
		int height;
		int dist;
		boolean brake = false;
		long bitmask = 0L;
		
		Pos(int r, int c, int height, int dist, boolean brake, long bitmask) {
			this.r = r;
			this.c = c;
			this.height = height;
			this.dist = dist;
			this.brake = brake;
			this.bitmask = bitmask;
		}
	}
}
