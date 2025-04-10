package SWEA;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA1263 {
	static int N;
	static int[][] adjMat;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream(
				"C:\\Users\\SSAFY\\git\\algorithm_problem_solving\\Algorithm_problem_solving\\src\\SWEA\\input\\SWEA1210_sample_input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(st.nextToken());

		for (int test_case = 1; test_case <= T; test_case++) {
			sb.append("#" + test_case + " ");
			st = new StringTokenizer(br.readLine());

			N = Integer.parseInt(st.nextToken());

			adjMat = new int[N + 1][N + 1];

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					adjMat[i][j] = Integer.parseInt(st.nextToken());
					if (i != j && adjMat[i][j] == 0)
						adjMat[i][j] = N;
				}
			}

			for (int i = 0; i < N; i++) {
				for (int s = 0; s < N; s++) {
					for (int e = 0; e < N; e++) {
						adjMat[s][e] = Math.min(adjMat[s][e], adjMat[s][i] + adjMat[i][e]);
					}
				}
			}

			int ans = Integer.MAX_VALUE;
			int sum;
			for (int i = 0; i < N; i++) {
				sum = 0;
				for (int j = 0; j < N; j++) {
					sum += adjMat[i][j];
				}
				ans = Math.min(ans, sum);
			}
			sb.append(ans + "\n");
		}
		System.out.println(sb.toString());
	}
}