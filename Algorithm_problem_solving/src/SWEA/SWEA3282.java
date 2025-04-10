package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA3282 {
	static int N, K;
	static int[][] knapsack;
	static int[][] items;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(st.nextToken());

		for (int test_case = 1; test_case <= T; test_case++) {
			sb.append("#" + test_case + " ");
			st = new StringTokenizer(br.readLine());

			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());

			items = new int[N + 1][2];
			knapsack = new int[N + 1][K + 1];

			for (int i = 1; i <= N; i++) {
				st = new StringTokenizer(br.readLine());
				items[i][0] = Integer.parseInt(st.nextToken());
				items[i][1] = Integer.parseInt(st.nextToken());
			}

			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= K; j++) {
					if (j - items[i][0] >= 0)
						knapsack[i][j] = Math.max(knapsack[i - 1][j], knapsack[i - 1][j - items[i][0]] + items[i][1]);
					else
						knapsack[i][j] = knapsack[i - 1][j];
				}
			}

			sb.append(knapsack[N][K] + "\n");
		}
		System.out.print(sb.toString());
	}
}
