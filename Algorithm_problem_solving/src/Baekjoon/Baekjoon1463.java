package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon1463 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int[] check = new int[N + 1];

		int min;
		for (int i = 2; i <= N; i++) {
			min = check[i - 1];
			if (i % 3 == 0) {
				min = Math.min(min, check[i / 3]);
			}
			if (i % 2 == 0) {
				min = Math.min(min, check[i / 2]);
			}
			check[i] = min + 1;
		}
		System.out.println(check[N]);
	}
}
