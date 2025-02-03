package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

public class SWEA4193 {
	public static int[][] map;
	public static int[] dx = {0,0,-1,1};
	public static int[] dy = {-1,1,0,0};
	public static int[] swirl = {3, 2, 1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine().trim());
		
		for (int test_case=1;test_case<=T;test_case++) {
			int n = Integer.parseInt(br.readLine().trim());
			map = new int[n][n];
			for (int i =0;i<n;i++) {
				String[] input = br.readLine().trim().split(" ");
				for (int j=0;j<n;j++) {
					map[i][j] = Integer.parseInt(input[j]);
				}
			}
			String[] input = br.readLine().trim().split(" ");
			Pos start = new Pos(Integer.parseInt(input[0]), Integer.parseInt(input[1]), 0);
			input = br.readLine().trim().split(" ");
			Pos destination = new Pos(Integer.parseInt(input[0]), Integer.parseInt(input[1]), 0); 
			System.out.println(bfs(start, destination,new boolean[n][n]));
		}
	}
	
	public static int bfs(Pos s, Pos d, boolean[][] v) {
		Queue<Pos> que = new LinkedList<>();
		que.offer(s);
		v[s.x][s.y] = true;
		
		while (que.size()>0) {
			Pos cur = que.poll();
			if (cur.equals(d)) return cur.t;
			for (int i=0;i<4;i++) {
				if (cur.x+dx[i]>=0&& cur.x+dx[i]<map.length&&cur.y+dy[i]>=0&&cur.y+dy[i]<map[0].length) {
					if (v[cur.x+dx[i]][cur.y+dy[i]]) continue;
					if (map[cur.x+dx[i]][cur.y+dy[i]]==0) {
						que.offer(new Pos(cur.x+dx[i],cur.y+dy[i],cur.t+1));
						v[cur.x+dx[i]][cur.y+dy[i]]=true;
					}
					if (map[cur.x+dx[i]][cur.y+dy[i]]==1) continue;
					if (map[cur.x+dx[i]][cur.y+dy[i]]==2) {
						if (cur.t%3==2) {
							que.offer(new Pos(cur.x+dx[i],cur.y+dy[i],cur.t+1));
							v[cur.x+dx[i]][cur.y+dy[i]]=true;
						}
						else que.offer(new Pos(cur.x,cur.y,cur.t+1));
					}
				}
			}
		}
		return -1;
	}
}

class Pos {
	public int x;
	public int y;
	public int t;
	
	Pos(int x, int y, int t) {
		this.x=x;this.y=y;this.t=t;
	}

	@Override
	public int hashCode() {
		return Objects.hash(t, x, y);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pos other = (Pos) obj;
		return x == other.x && y == other.y;
	}
}

// 소용돌이를 이동하려고 하면 %3을 했을 때 현재 0이면 2초 1이면 1초 2이면 3초 기다려야한다.