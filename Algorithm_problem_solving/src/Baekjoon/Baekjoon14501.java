package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon14501 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		int period = Integer.parseInt(st.nextToken());

		int[] dp = new int[period + 1];
		int p, b;
		for (int i = 1; i <= period; i++) {
			st = new StringTokenizer(br.readLine());
			p = Integer.parseInt(st.nextToken()) - 1;
			dp[i] = Math.max(dp[i - 1], dp[i]);
			if (i + p <= period)
				dp[i + p] = Math.max(dp[i + p], dp[i - 1] + Integer.parseInt(st.nextToken()));
		}
		System.out.println(dp[period]);
	}
}
