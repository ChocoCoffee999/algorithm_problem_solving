package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon2839 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int[] dp = new int[n + 1];
		dp[1] = -1;
		dp[2] = -1;
		dp[3] = 1;
		if (n == 4) {
			dp[4] = -1;
		} else if (n > 4) {
			dp[4] = -1;
			dp[5] = 1;
			for (int i = 6; i <= n; i++) {
				if (dp[i - 3] != -1) {
					if (dp[i - 5] != -1) {
						dp[i] = Math.min(dp[i - 3] + 1, dp[i - 5] + 1);
					} else {
						dp[i] = dp[i - 3] + 1;
					}
				} else {
					if (dp[i - 5] != -1) {
						dp[i] = dp[i - 5] + 1;
					} else {
						dp[i] = -1;
					}
				}
			}
		}
		System.out.println(dp[n]);
	}
}
