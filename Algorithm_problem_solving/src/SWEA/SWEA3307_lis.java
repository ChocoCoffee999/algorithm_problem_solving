package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA3307_lis {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(st.nextToken());

		for (int test_case = 1; test_case <= T; test_case++) {
			sb.append("#" + test_case + " ");
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());

			int[] lis = new int[N];

			int end = 1, s, e, mid, n;

			st = new StringTokenizer(br.readLine());
			lis[0] = Integer.parseInt(st.nextToken());

			for (int i = 1; i < N; i++) {
				n = Integer.parseInt(st.nextToken());
				s = 0;
				e = end;
				while (true) {
					mid = (s + e) / 2;
					if (lis[mid] == n)
						break;
					else if (lis[mid] > n) {
						e = mid;
					} else
						s = mid + 1;

					if (s == e) {
						if (s == end)
							end++;
						lis[s] = n;
						break;
					}
				}
			}
			sb.append((end) + "\n");
		}
		System.out.print(sb.toString());
	}
}
