package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class SWEA2117 {
	static int[][] map;
	static List<Pos> homes;
	static int N, M;
	static int[][][] search;
	static int[] costs;
	static int ans;

	static class Pos {
		int r, c;

		public Pos(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(st.nextToken());
		cost();
		for (int test_case = 1; test_case <= T; test_case++) {
			sb.append("#" + test_case + " ");
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			homes = new ArrayList<>();
			map = new int[N][N];
			search = new int[N][N][N + 1];
			ans = 0;
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if (map[i][j] == 1) {
						homes.add(new Pos(i, j));
					}
				}
			}
			int sum;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					for (Pos cur : homes) {
						sum = Math.abs(cur.r - i) + Math.abs(cur.c - j);
						if (sum >= N + 1)
							continue;
						search[i][j][sum]++;
					}
				}
			}

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					int count = 0;
					for (int k = 0; k < N + 1; k++) {
						count += search[i][j][k];
						if (count * M >= costs[k]) {
							ans = Math.max(ans, count);
						}
					}
				}
			}
			sb.append(ans + "\n");
		}
		System.out.println(sb.toString());
	}

	public static void cost() {
		costs = new int[21];
		for (int i = 1; i <= 21; i++) {
			costs[i - 1] = i * i + (i - 1) * (i - 1);
		}
	}
}
