package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon11726 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int[] map = new int[n + 1];

		if (n == 1)
			System.out.println(1);
		else if (n == 2)
			System.out.println(2);
		else {
			map[1] = 1;
			map[2] = 2;
			for (int i = 3; i <= n; i++) {
				map[i] = map[i - 1] + map[i - 2];
			}
			System.out.println(map[n] % 10007);
		}
	}
}
