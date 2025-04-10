package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Baekjoon2156 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine().trim());

		if (N == 1)
			System.out.println(Integer.parseInt(br.readLine()));
		else if (N == 2) {
			System.out.println(Integer.parseInt(br.readLine()) + Integer.parseInt(br.readLine()));
		} else {
			int[] dp = new int[N + 1];
			int[] sequence = new int[N + 1];
			sequence[1] = Integer.parseInt(br.readLine());
			dp[1] = sequence[1];
			sequence[2] = Integer.parseInt(br.readLine());
			dp[2] = dp[1] + sequence[2];
			sequence[3] = Integer.parseInt(br.readLine());
			dp[3] = Math.max(dp[2], Math.max(sequence[1] + sequence[3], sequence[2] + sequence[3]));

			for (int i = 4; i <= N; i++) {
				sequence[i] = Integer.parseInt(br.readLine().trim());
				dp[i] = Math.max(dp[i - 1],
						Math.max(dp[i - 2] + sequence[i], dp[i - 3] + sequence[i - 1] + sequence[i]));
			}
			System.out.println(dp[N]);
		}
	}
}
