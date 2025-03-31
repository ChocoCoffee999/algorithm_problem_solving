package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA1225 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int[] map;
		for (int test_case=1;test_case<=10;test_case++) {
			br.readLine();
			st = new StringTokenizer(br.readLine());
			map=new int[8];
			for (int i=0;i<8;i++) {
				map[i] = Integer.parseInt(st.nextToken());
			}
			int point = 0;
			int sub = 1;
			while(true) {
				map[point]-=sub;
				if (map[point]<=0) {
					map[point]=0;
					point=(point+1)%8;
					break;
				}
				sub=sub+1>5?1:sub+1;
				point=(point+1)%8;
			}
			
			System.out.printf("#%d", test_case);
			for (int i=0;i<8;i++) {
				System.out.printf(" %d", map[point]);
				point=(point+1)%8;
			}
			System.out.println();
		}
	}
}
