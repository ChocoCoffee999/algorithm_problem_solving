package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Baekjoon16235 {
	static int N, M, K, i, j, d;
	static int[][] map;
	static int[][] A;
	static List<Integer>[][] list;
	static List<Integer>[][] newTree;
	static List<Integer>[][] tmp;
	static int nr;
	static int nc;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		map = new int[N][N];
		A = new int[N][N];
		list = new List[N][N];
		newTree = new List[N][N];
		tmp = new List[N][N];

		for (i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (j = 0; j < N; j++) {
				list[i][j] = new LinkedList<>();
				newTree[i][j] = new LinkedList<>();
				map[i][j] = 5;
				A[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int r, c;
		for (i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			r = Integer.parseInt(st.nextToken()) - 1;
			c = Integer.parseInt(st.nextToken()) - 1;
			list[r][c].add(Integer.parseInt(st.nextToken()));
		}

		for (i = 0; i < N; i++) {
			for (j = 0; j < N; j++) {
				Collections.sort(list[i][j]);
			}
		}
		for (int i = 0; i < K; i++) {
			year();
		}
		int size = 0;
		for (i = 0; i < N; i++) {
			for (j = 0; j < N; j++) {
				size += list[i][j].size();
			}
		}
		System.out.println(size);

	}

	static int[] dr = { 0, 0, 1, 1, 1, -1, -1, -1 };
	static int[] dc = { 1, -1, 0, 1, -1, 0, 1, -1 };

	private static void year() {
		for (i = 0; i < N; i++) {
			for (j = 0; j < N; j++) {
				int sum = 0;
				for (int cur : list[i][j]) {
					if (map[i][j] >= cur) {
						map[i][j] -= cur;
						cur++;
					} else {
						sum += cur / 2;
						continue;
					}
					if (cur % 5 == 0) {
						for (d = 0; d < 8; d++) {
							nr = i + dr[d];
							nc = j + dc[d];
							if (nr >= 0 && nr < N && nc >= 0 && nc < N) {
								newTree[nr][nc].add(0, 1);
							}
						}
					}
					newTree[i][j].add(cur);
				}
				map[i][j] += sum + A[i][j];
			}
		}

		for (i = 0; i < N; i++) {
			for (j = 0; j < N; j++) {
				tmp[i][j] = list[i][j];
				list[i][j] = newTree[i][j];
				newTree[i][j] = tmp[i][j];
				newTree[i][j].clear();
			}
		}
	}
}
