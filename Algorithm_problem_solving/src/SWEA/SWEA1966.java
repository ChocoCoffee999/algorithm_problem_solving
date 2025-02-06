package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SWEA1966 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine().trim());
		
		for (int test_case=1;test_case<=T;test_case++) {
			int N = Integer.parseInt(br.readLine().trim());
			int[] num = new int[N];
			String[] input = br.readLine().trim().split(" ");
			
			for (int i=0;i<N;i++) num[i]=Integer.parseInt(input[i]);
			Arrays.sort(num);
			
			String answer = Integer.toString(num[0]);
			for (int i=1;i<N;i++) {
				answer+=" "+num[i];
			}
			
			System.out.printf("#%d %s\n", test_case, answer);
		}
	}

}
