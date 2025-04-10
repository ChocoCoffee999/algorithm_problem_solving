package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon5656 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int n1, n2, count = 1;
		String o;
		boolean res = false;
		while (true) {
			st = new StringTokenizer(br.readLine());

			n1 = Integer.parseInt(st.nextToken());
			o = st.nextToken();
			if (o.equals("E"))
				break;
			n2 = Integer.parseInt(st.nextToken());

			switch (o) {
			case ">": {
				res = n1 > n2;
				break;
			}
			case ">=": {
				res = n1 >= n2;
				break;
			}
			case "<": {
				res = n1 < n2;
				break;
			}
			case "<=": {
				res = n1 <= n2;
				break;
			}
			case "==": {
				res = n1 == n2;
				break;
			}
			case "!=": {
				res = n1 != n2;
				break;
			}
			}
			sb.append("Case ").append(count++).append(": ").append(res).append("\n");
		}
		System.out.print(sb.toString());
	}
}
