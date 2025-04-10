package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon1932 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());

		int[] dp = new int[N];
		int n;

		st = new StringTokenizer(br.readLine());

		dp[0] = Integer.parseInt(st.nextToken());

		for (int i = 1; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			dp[i] = n + dp[i - 1];
			for (int j = i - 1; j > 0; j--) {
				n = Integer.parseInt(st.nextToken());
				dp[j] = Math.max(dp[j - 1], dp[j]) + n;
			}
			n = Integer.parseInt(st.nextToken());
			dp[0] = n + dp[0];
		}

		int max = 0;

		for (int i = 0; i < N; i++) {
			max = Math.max(max, dp[i]);
		}
		System.out.println(max);
	}
}
