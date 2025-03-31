package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class SWEA1218 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		L:for (int test_case=1;test_case<=10;test_case++) {
			int N = Integer.parseInt(br.readLine().trim());
			String[] input = br.readLine().trim().split("");
			Stack<String> stack = new Stack<>();
			for (int i=0; i<N; i++) {
				switch (input[i]) {
				case ("(") : {
					stack.push("(");
					break;
				}
				case ("{") : {
					stack.push("{");
					break;
				}
				case ("[") : {
					stack.push("[");
					break;
				}
				case ("<") : {
					stack.push("<");
					break;
				}
				case (")") : {
					if (stack.pop().equals("(")) break;
					else {
						System.out.printf("#%d %d\n", test_case, 0);
						continue L;
					}
				}
				case ("}") : {
					if (stack.pop().equals("{")) break;
					else {
						System.out.printf("#%d %d\n", test_case, 0);
						continue L;
					}
				}
				case ("]") : {
					if (stack.pop().equals("[")) break;
					else {
						System.out.printf("#%d %d\n", test_case, 0);
						continue L;
					}
				}
				case (">") : {
					if (stack.pop().equals("<")) break;
					else {
						System.out.printf("#%d %d\n", test_case, 0);
						continue L;
					}
				}
				}
			}
			System.out.printf("#%d %d\n", test_case, 1);
		}
	}
}
