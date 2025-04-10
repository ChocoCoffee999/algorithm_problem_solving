package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon11722 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(st.nextToken());

		int[] sequence = new int[N + 1];

		int max = 0, maxIdx = 0;
		int[] dp = new int[N + 1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			sequence[i] = Integer.parseInt(st.nextToken());

			for (int j = 1; j <= i; j++) {
				if (sequence[i] < sequence[j])
					dp[i] = Math.max(dp[i], dp[j] + 1);
			}
			if (dp[i] > max) {
				max = dp[i];
				maxIdx = i;
			}
		}
		System.out.println(dp[maxIdx] + 1);
	}
}
