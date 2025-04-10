package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Baekjoon10844 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		int[] dp = new int[10];
		int[] bdp = new int[10];
		int[] tmp;

		for (int i = 1; i < 10; i++) {
			dp[i] = 1;
		}
		for (int i = 1; i < n; i++) {
			tmp = dp;
			dp = bdp;
			bdp = tmp;
			dp[0] = bdp[1];
			for (int j = 1; j < 9; j++) {
				dp[j] = (bdp[j - 1] + bdp[j + 1]) % 1000000000;
			}
			dp[9] = bdp[8];
		}

		int sum = 0;
		for (int i = 0; i < 10; i++) {
			sum = (sum + dp[i]) % 1000000000;
		}

		System.out.println(sum);
	}
}
