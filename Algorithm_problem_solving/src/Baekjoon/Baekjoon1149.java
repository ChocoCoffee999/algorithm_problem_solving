package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon1149 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int[][] costs = new int[N + 1][3];
		int[][] dp = new int[N + 1][3];
		for (int i = 1; i <= N; i++) {
			Arrays.fill(dp[i], Integer.MAX_VALUE);
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				costs[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < 3; i++) {
			dp[1][i] = costs[1][i];
		}

		for (int step = 2; step <= N; step++) {
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					if (i == j)
						continue;
					dp[step][i] = Math.min(dp[step - 1][j] + costs[step][i], dp[step][i]);
				}
			}
		}
		int ans = Integer.MAX_VALUE;

		for (int n : dp[N])
			ans = Math.min(ans, n);
		System.out.println(ans);
	}
}
