package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon9095 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(st.nextToken());
		int[] check;
		check = new int[11];
		check[1] = 1;
		check[2] = 2;
		check[3] = 4;
		for (int i = 4; i <= 10; i++) {
			check[i] = check[i - 1] + check[i - 2] + check[i - 3];
		}
		for (int test_case = 0; test_case < T; test_case++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());

			System.out.println(check[n]);
		}
	}
}
