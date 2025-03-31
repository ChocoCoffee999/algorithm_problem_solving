package CodeTree;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class magicalForest {
	static int R;
	static int C;
	static int[][] map;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	static int count = 1;
	static int Ans = 0;

	static class Golem {
		int r, c, d;

		public Golem(int r, int c, int d) {
			this.r = r;
			this.c = c;
			this.d = d;
		}

		public boolean move() {
			if (checkD()) {
				r += 1;
				if (r == R + 1)
					return false;
				else
					return true;
			} else if (checkL()) {
				c -= 1;
				d -= 1;
				if (d < 0)
					d = 3;
				if (r == R + 1)
					return false;
				else
					return true;
			} else if (checkR()) {
				c += 1;
				d += 1;
				if (d == 4)
					d = 0;
				if (r == R + 1)
					return false;
				else
					return true;
			}
			return false;
		}

		public boolean checkD() {
			if (r + 2 < R + 3 && map[r + 2][c] == 0 && map[r + 1][c - 1] == 0 && map[r + 1][c + 1] == 0) {
				return true;
			}
			return false;
		}

		public boolean checkD(int r, int c) {
			if (r + 2 < R + 3 && map[r + 2][c] == 0 && map[r + 1][c - 1] == 0 && map[r + 1][c + 1] == 0) {
				return true;
			}
			return false;
		}

		public boolean checkL() {
			if (c - 2 >= 0 && map[r][c - 2] == 0 && map[r - 1][c - 1] == 0 && map[r + 1][c - 1] == 0) {
				return checkD(r, c - 1) && true;
			}
			return false;
		}

		public boolean checkR() {
			if (c + 2 < C && map[r][c + 2] == 0 && map[r - 1][c + 1] == 0 && map[r + 1][c + 1] == 0) {
				return checkD(r, c + 1) && true;
			}
			return false;
		}

		public void draw() {
			map[r][c] = count;
			for (int i = 0; i < 4; i++) {
				map[r + dr[i]][c + dc[i]] = count;
			}
			map[r + dr[d]][c + dc[d]] = -count;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new int[R + 3][C];
		int K = Integer.parseInt(st.nextToken());
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			Golem g = new Golem(1, Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()));
			while (g.move())
				;
			if (g.r <= 3) {
				for (int j = 0; j < map.length; j++) {
					Arrays.fill(map[j], 0);
				}
			} else {
				g.draw();
				bfs(g.r, g.c);
			}
			count++;
		}
		System.out.println(Ans);
	}

	static class Pos {
		int r, c, type;

		Pos(int r, int c, int type) {
			this.r = r;
			this.c = c;
			this.type = type;
		}
	}

	public static void bfs(int r, int c) {
		Queue<Pos> que = new ArrayDeque<>();
		boolean[][] v = new boolean[R + 2][C];

		que.add(new Pos(r, c, map[r][c]));
		v[r][c] = true;

		int max = 0;
		while (!que.isEmpty()) {
			Pos cur = que.poll();
			if (cur.r > max)
				max = cur.r;
			for (int d = 0; d < 4; d++) {
				int nr = cur.r + dr[d];
				int nc = cur.c + dc[d];
				if (nr >= 0 && nr <= R + 2 && nc >= 0 && nc < C && !v[nr][nc]) {
					if (cur.type < 0 && map[nr][nc] != 0) {
						que.add(new Pos(nr, nc, map[nr][nc]));
						v[nr][nc] = true;
					} else if (map[nr][nc] == -cur.type) {
						que.add(new Pos(nr, nc, -cur.type));
						v[nr][nc] = true;
					} else if (map[nr][nc] == cur.type) {
						que.add(new Pos(nr, nc, cur.type));
						v[nr][nc] = true;
					}
				}
			}
		}
		Ans += max - 2;
	}
}
