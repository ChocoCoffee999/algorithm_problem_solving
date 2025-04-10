package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

public class SWEA5650 {

	static class Ball {
		int r, c, d, s;

		Ball(int r, int c, int d) {
			this.r = r;
			this.c = c;
			this.d = d;
			this.s = 0;
		}

		public void move() {
			int nr = r + dr[d];
			int nc = c + dc[d];

			if (nr >= 0 && nr < N && nc >= 0 && nc < N) {
				if (map[nr][nc] <= 0) {
					r = nr;
					c = nc;
				} else if (map[nr][nc] > 5) {
					for (int[] hole : holes.get(map[nr][nc])) {
						if (hole[0] != nr || hole[1] != nc) {
							r = hole[0];
							c = hole[1];
							break;
						}
					}
				} else {
					d = turn[map[nr][nc]][d];
					s++;
					r = nr;
					c = nc;
					this.move();
				}
			} else {
				s++;
				d = (d + 2) % 4;
				if (map[r][c] != 0) {
					if (map[r][c] > 5) {
						for (int[] hole : holes.get(map[r][c])) {
							if (hole[0] != r || hole[1] != c) {
								r = hole[0];
								c = hole[1];
								break;
							}
						}
					} else {
						s++;
						d = turn[map[r][c]][d];
						this.move();
					}
				}
			}
		}
	}

	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	static int[][] map;
	static HashMap<Integer, List<int[]>> holes;

	static int N, ans;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(st.nextToken());

		for (int test_case = 1; test_case <= T; test_case++) {
			sb.append("#" + test_case + " ");
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			ans = 0;
			map = new int[N][N];
			holes = new HashMap<>();
			for (int r = 0; r < N; r++) {
				st = new StringTokenizer(br.readLine());
				for (int c = 0; c < N; c++) {
					map[r][c] = Integer.parseInt(st.nextToken());
					if (map[r][c] > 5) {
						if (holes.containsKey(map[r][c])) {
							holes.get(map[r][c]).add(new int[] { r, c });
						} else {
							List<int[]> list = new ArrayList<>();
							list.add(new int[] { r, c });
							holes.put(map[r][c], list);
						}
					}
				}
			}
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					if (map[r][c] == 0) {
						bfs(r, c);
					}
				}
			}
			sb.append(ans + "\n");
		}
		System.out.println(sb.toString());
	}

	private static void bfs(int r, int c) {
		Ball cur;
		for (int i = 0; i < 4; i++) {
			cur = new Ball(r, c, i);
			do {
				cur.move();
				if (map[cur.r][cur.c] == -1)
					break;
			} while (cur.r != r || cur.c != c);

			ans = Math.max(ans, cur.s);
		}
	}

	static int[][] turn = { {}, { 2, 3, 1, 0 }, { 1, 3, 0, 2 }, { 3, 2, 0, 1 }, { 2, 0, 3, 1 }, { 2, 3, 0, 1 } };
}
