package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA3289 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb;
		int T = Integer.parseInt(st.nextToken());
		for (int test_case = 1; test_case <= T; test_case++) {
			sb = new StringBuilder();
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int[] arr = new int[N + 1];
			for (int i = 1; i <= N; i++) {
				arr[i] = i;
			}
			sb.append("#" + test_case + " ");
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int command = Integer.parseInt(st.nextToken());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				switch (command) {
				case 0: {
					int tmp1 = a;
					int tmp2 = b;
					int count1 = 0;
					int count2 = 0;
					while (tmp1 != arr[tmp1]) {
						tmp1 = arr[tmp1];
						count1++;
					}
					while (tmp2 != arr[tmp2]) {
						tmp2 = arr[tmp2];
						count2++;
					}

					if (count1 < count2)
						arr[tmp1] = tmp2;
					else
						arr[tmp2] = tmp1;
					break;
				}
				case 1: {
					int tmp1 = a;
					int tmp2 = b;
					while (tmp1 != arr[tmp1]) {
						tmp1 = arr[tmp1];
					}
					while (tmp2 != arr[tmp2]) {
						tmp2 = arr[tmp2];
					}
					if (tmp1 == tmp2)
						sb.append(1);
					else
						sb.append(0);
					break;
				}
				}
			}
			System.out.println(sb.toString());
		}
	}
}
