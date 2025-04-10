package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA3307 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(st.nextToken());

		for (int test_case = 1; test_case <= T; test_case++) {
			sb.append("#" + test_case + " ");
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());

			int[] sequence = new int[N + 1];

			int max = 0, maxIdx = 0;
			int[] dp = new int[N + 1];
			st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= N; i++) {
				sequence[i] = Integer.parseInt(st.nextToken());

				for (int j = 1; j <= i; j++) {
					if (sequence[i] > sequence[j])
						dp[i] = Math.max(dp[i], dp[j] + 1);
				}
				if (dp[i] > max) {
					max = dp[i];
					maxIdx = i;
				}
			}
			sb.append((dp[maxIdx] + 1) + "\n");
		}
		System.out.print(sb.toString());
	}
}
