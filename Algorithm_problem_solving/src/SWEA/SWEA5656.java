package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA5656 {
	static int N, W, H, ans;
	static int[][] map;
	static int[] arr;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(st.nextToken());

		for (int test_case = 1; test_case <= T; test_case++) {
			sb.append("#").append(test_case).append(" ");
			st = new StringTokenizer(br.readLine());

			N = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			ans = Integer.MAX_VALUE;

			map = new int[H][W];
			arr = new int[N];

			for (int i = 0; i < H; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < W; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			permutation(map, 0);
			sb.append(ans).append("\n");
		}
		System.out.print(sb.toString());
	}

	private static boolean permutation(int[][] tmp, int idx) throws Exception {
		if (idx == N) {
			int count = 0;
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					if (tmp[i][j] > 0)
						count++;
				}
			}
			ans = Math.min(count, ans);
			if (ans == 0)
				return true;
			return false;
		}

		int[][] ntmp = new int[H][];

		L: for (int i = 0; i < W; i++) {
			for (int j = 0; j < H; j++) {
				ntmp[j] = Arrays.copyOf(tmp[j], tmp[j].length);
			}
			for (int j = 0; j < H; j++) {
				if (ntmp[j][i] != 0) {
					boom(ntmp, j, i);
					set(ntmp);
					break;
				}
				if (j == H - 1) {
					int cnt = 0;
					for (int k = 0; k < H; k++) {
						for (int l = 0; l < W; l++) {
							if (tmp[k][l] > 0)
								cnt++;
						}
					}
					ans = Math.min(cnt, ans);
					if (ans == 0)
						return true;
					continue L;
				}
			}
			if (permutation(ntmp, idx + 1))
				return true;
		}
		return false;
	}

	private static void set(int[][] tmp) {
		int count;
		for (int i = 0; i < W; i++) {
			count = 0;
			for (int j = H - 1; j >= 0; j--) {
				if (tmp[j][i] > 0) {
					tmp[H - 1 - count][i] = tmp[j][i];
					if (H - 1 - count != j)
						tmp[j][i] = 0;
					count++;
				}
			}
		}
	}

	static int[] dr = { 0, 0, 1, -1 };
	static int[] dc = { 1, -1, 0, 0 };

	private static void boom(int[][] tmp, int r, int c) {
		if (tmp[r][c] == 1) {
			tmp[r][c] = 0;
			return;
		}
		Queue<Pos> que = new ArrayDeque<>();
		boolean[][] v = new boolean[H][W];
		v[r][c] = true;
		que.add(new Pos(r, c));
		while (!que.isEmpty()) {
			Pos cur = que.poll();
			for (int d = 0; d < 4; d++) {
				for (int i = 1; i < tmp[cur.r][cur.c]; i++) {
					int nr = cur.r + dr[d] * i;
					int nc = cur.c + dc[d] * i;
					if (nr >= 0 && nr < H && nc >= 0 && nc < W) {
						if (tmp[nr][nc] == 0)
							continue;
						if (tmp[nr][nc] == 1) {
							tmp[nr][nc] = 0;
						} else if (!v[nr][nc]) {
							que.add(new Pos(nr, nc));
							v[nr][nc] = true;
						}
					} else
						break;
				}
			}

			tmp[cur.r][cur.c] = 0;
		}
	}

	static class Pos {
		int r, c;

		Pos(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
}
