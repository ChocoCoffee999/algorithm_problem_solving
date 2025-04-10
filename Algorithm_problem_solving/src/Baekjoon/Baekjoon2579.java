package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon2579 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int[] map = new int[n + 1];
		int[] max = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			map[i] = Integer.parseInt(st.nextToken());
		}

		if (n == 1) {
			System.out.println(map[1]);
		} else if (n == 2) {
			System.out.println(map[1] + map[2]);
		} else {
			max[1] = map[1];
			max[2] = map[1] + map[2];
			max[3] = Math.max(map[1], map[2]) + map[3];
			for (int i = 4; i <= n; i++) {
				max[i] = Math.max(max[i - 2], max[i - 3] + map[i - 1]) + map[i];
			}
			System.out.println(max[n]);
		}
	}
}
