package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon11722_lds {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(st.nextToken());

		int[] lds = new int[N];

		st = new StringTokenizer(br.readLine());
		int end = 1, s, e, mid, n;
		lds[0] = Integer.parseInt(st.nextToken());
		for (int i = 1; i < N; i++) {
			n = Integer.parseInt(st.nextToken());
			s = 0;
			e = end;
			while (true) {
				mid = (s + e) / 2;

				if (lds[mid] == n)
					break;
				else if (lds[mid] < n)
					e = mid;
				else
					s = mid + 1;

				if (s == e) {
					if (s == end) {
						end++;
					}
					lds[s] = n;
					break;
				}
			}
		}
		System.out.println(end);
	}
}
