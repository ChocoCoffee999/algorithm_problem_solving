package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA1970 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine().trim());
		int[] money = {50000,10000,5000,1000,500,100,50,10};
		
		for (int test_case=1;test_case<=T;test_case++) {
			int n = Integer.parseInt(br.readLine().trim());
			int[] num = new int[8];
			for (int i=0;i<8;i++) {
				while (n>=money[i]) {
					n-=money[i];
					num[i]++;
				}
			}
			System.out.printf("#%d\n", test_case);
			for (int i=0;i<8;i++) {
				System.out.printf("%d", num[i]);
				if (i==7) break;
				System.out.print(" ");
			}
			System.out.println();
		}
	}
}
