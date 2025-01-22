package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SWEA5432 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine().trim());
		
		for (int test_case=1;test_case<=T;test_case++) {
			String[] input = br.readLine().trim().split("");
			int n = 0;
			int count = 0;
			for (int i = 0; i<input.length;i++) {
				if (input[i].equals("(")) {
					count ++;
				}
				if (input[i].equals(")")) {
					if (input[i-1].equals("(")) {
						count--;
						n+=count;
					}
					else {
						count--;
						n++;
					}
				}
			}
			System.out.printf("#%d %d\n", test_case,n);
		}
	}

}
