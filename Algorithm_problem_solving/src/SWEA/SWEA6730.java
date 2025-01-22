package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SWEA6730 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine().trim());
		
		for (int test_case=1;test_case<=T;test_case++) {
			int n = Integer.parseInt(br.readLine().trim());
			String[] input = br.readLine().trim().split(" ");
			int[] height = new int[n];
			for (int i=0;i<n;i++) height[i]=Integer.parseInt(input[i]);
			int maxUp=0;
			int maxDown=0;
			
			for (int i=0;i<n-1;i++) {
				int delta = height[i]-height[i+1];
				if (delta>0) {
					if (maxDown<delta) maxDown=delta;
				}
				else if (maxUp<-delta) maxUp=-delta;
			}
			System.out.printf("#%d %d %d\n",test_case, maxUp, maxDown);
		}
	}
}
