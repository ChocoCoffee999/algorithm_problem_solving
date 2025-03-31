package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA2001 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int T = Integer.parseInt(st.nextToken());
		
		for (int test_case=1;test_case<=T;test_case++) {
			st = new StringTokenizer(br.readLine());
			int N=Integer.parseInt(st.nextToken());
			int M=Integer.parseInt(st.nextToken());
			
			int[][] map = new int[N][N];
			for (int i=0;i<N;i++) {
				st = new StringTokenizer(br.readLine());
				int sum = 0;
				for (int j=0;j<N;j++) {
					sum+=Integer.parseInt(st.nextToken());
					map[i][j]=sum;
				}
			}
			for (int i=0;i<N;i++) {
				int sum=0;
				for (int j=0;j<N;j++) {
					sum += map[j][i];
					map[j][i] = sum;
				}
			}
			int max = 0;
			for (int i=M-1;i<N;i++) {
				for (int j=M-1;j<N;j++) {
					int fly = map[i][j];
					if (i>=M) {
						fly -= map[i-M][j];
					}
					if (j>=M) {
						fly -= map[i][j-M];
					}
					if (i>=M&&j>=M) {
						fly +=map[i-M][j-M];
					}
					max = Math.max(max, fly);
				}
			}
			System.out.printf("#%d %d\n", test_case, max);
		}
	}
}
