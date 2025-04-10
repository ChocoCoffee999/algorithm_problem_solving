package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class SWEA1767 {
	static int N;
	static int[][] map;
	static List<Pos> list;
	static int maxCore;
	static int minLine;

	static class Pos {
		int r, c;

		Pos(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(st.nextToken());
		for (int test_case = 1; test_case <= T; test_case++) {
			maxCore = Integer.MIN_VALUE;
			minLine = Integer.MAX_VALUE;
			sb.append("#" + test_case + " ");
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			map = new int[N][N];
			list = new ArrayList<>();

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if (map[i][j] == 1) {
						if (i != 0 && i != N - 1 && j != 0 && j != N - 1) {
							list.add(new Pos(i, j));
						}
					}
				}
			}

			dfs(0, new boolean[N][N]);
			sb.append(minLine).append("\n");
		}
		System.out.print(sb.toString());
	}

	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };

	private static void dfs(int idx, boolean[][] v) {
		if (idx == list.size()) {
			int countL = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (v[i][j])
						countL++;
				}
			}

			int countC = 0;
			for (Pos cur : list) {
				if (v[cur.r][cur.c])
					countC++;
			}

			if (maxCore < countC) {
				maxCore = countC;
				minLine = countL;
			} else if (maxCore == countC)
				minLine = Math.min(countL, minLine);
			return;
		}
		Pos cur = list.get(idx);
		for (int d = 0; d < 4; d++) {
			int nr = cur.r + dr[d];
			int nc = cur.c + dc[d];
			boolean f = true;
			while (nr >= 0 && nr < N && nc >= 0 && nc < N) {
				if (map[nr][nc] == 0) {
					if (!v[nr][nc]) {
						if (nr == 0 || nr == N - 1 || nc == 0 || nc == N - 1) {
							break;
						}
					} else {
						f = false;
						break;
					}
					nr += dr[d];
					nc += dc[d];
				} else {
					f = false;
					break;
				}
			}

			if (f) {
				if (cur.r != nr) {
					for (int i = cur.r; i != nr; i += dr[d]) {
						v[i][cur.c] = true;
					}
					dfs(idx + 1, v);
					for (int i = cur.r; i != nr; i += dr[d]) {
						v[i][cur.c] = false;
					}
				} else {
					for (int i = cur.c; i != nc; i += dc[d]) {
						v[cur.r][i] = true;
					}
					dfs(idx + 1, v);
					for (int i = cur.c; i != nc; i += dc[d]) {
						v[cur.r][i] = false;
					}
				}
			}
		}
		dfs(idx + 1, v);
	}
}