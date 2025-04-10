package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon2775 {
	static int k, n;
	static int[][] map;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int T = Integer.parseInt(st.nextToken());

		for (int test_case = 1; test_case <= T; test_case++) {
			st = new StringTokenizer(br.readLine());
			k = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			map = new int[k + 1][n + 1];

			for (int i = 1; i <= n; i++) {
				map[0][i] = i;
			}
			int sum;
			for (int i = 1; i <= k; i++) {
				sum = 0;
				for (int j = 1; j <= n; j++) {
					sum += map[i - 1][j];
					map[i][j] = sum;
				}
			}

			System.out.println(map[k][n]);
		}
	}
}
