package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon14502 {
	static int[][] map;
	static int[][] tmp;
	static int N;
	static int M;
	static int Ans = 0;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		tmp = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < N * M - 2; i++) {
			for (int j = i + 1; j < N * M - 1; j++) {
				for (int k = j + 1; k < N * M; k++) {
					int r1 = i / M;
					int c1 = i % M;
					int r2 = j / M;
					int c2 = j % M;
					int r3 = k / M;
					int c3 = k % M;
					if (map[r1][c1] == 0 && map[r2][c2] == 0 && map[r3][c3] == 0) {
						bfs(r1, c1, r2, c2, r3, c3);
					}
				}
			}
		}
		System.out.println(Ans);
	}

	static int[] dr = { 0, 0, 1, -1 };
	static int[] dc = { 1, -1, 0, 0 };

	public static void bfs(int r1, int c1, int r2, int c2, int r3, int c3) {
		Queue<Pos> que = new ArrayDeque<>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				tmp[i][j] = map[i][j];
				if (map[i][j] == 2)
					que.add(new Pos(i, j));
			}
		}
		tmp[r1][c1] = 1;
		tmp[r2][c2] = 1;
		tmp[r3][c3] = 1;
		while (!que.isEmpty()) {
			Pos cur = que.poll();
			for (int d = 0; d < 4; d++) {
				int nr = cur.r + dr[d];
				int nc = cur.c + dc[d];
				if (nr >= 0 && nr < N && nc >= 0 && nc < M && tmp[nr][nc] == 0) {
					tmp[nr][nc] = 2;
					que.offer(new Pos(nr, nc));
				}
			}
		}

		int sum = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (tmp[i][j] == 0)
					sum++;
			}
		}
		Ans = Math.max(sum, Ans);
	}

	static class Pos {
		int r, c;

		Pos(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
}
