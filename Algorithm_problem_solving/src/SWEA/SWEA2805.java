package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SWEA2805 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine().trim());
		
		for (int test_case=1;test_case<=T;test_case++) {
			int n = Integer.parseInt(br.readLine().trim());
			String[] input;
			int[][] map = new int[n][n];
			int sum = 0;
			for (int i = 0; i<n;i++) {
				input = br.readLine().trim().split("");
				for (int j = 0; j<n; j++) {
					map[i][j] = Integer.parseInt(input[j]);
				}
			}
			for(int i=0;i<n;i++) {
				for (int j=Math.abs(i-n/2);j<n-Math.abs(i-n/2);j++) {
					sum+=map[i][j];
				}
			}
			System.out.printf("#%d %d", test_case, sum);
		}
	}
}
