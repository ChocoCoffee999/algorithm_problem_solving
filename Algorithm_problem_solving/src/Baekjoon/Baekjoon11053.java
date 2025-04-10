package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon11053 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());

		int[] sequence = new int[N + 1];
		int[] dp = new int[N + 1];
		int max = 0, maxIdx = 0;
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			sequence[i] = Integer.parseInt(st.nextToken());
			for (int j = 1; j <= i; j++) {
				if (sequence[i] > sequence[j] && dp[i] <= dp[j])
					dp[i] = dp[j] + 1;
			}

			if (dp[i] > max) {
				maxIdx = i;
				max = dp[i];
			}
		}

		System.out.println(dp[maxIdx] + 1);
	}
}
