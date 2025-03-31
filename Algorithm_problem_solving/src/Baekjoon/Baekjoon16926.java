package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon16926 {
	static int[][] map;
	static int[][] ans;
	static int N;
	static int M;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		ans = new int[N][M];
		
		for (int i=0;i<N;i++) {
			map[i] = Arrays.stream(br.readLine().trim().split(" ")).mapToInt(s ->Integer.parseInt(s)).toArray();
		}
		for (int i=0;i<N;i++) {
			for (int j=0;j<M;j++) {
				int z = Math.min(Math.min(i, j), Math.min(N-1-j, M-1-j));
				spin(i, j, z, S);
			}
		}
//		for (int s=0;s<S;s++) {
//			for (int z=0; z<Z;z++) {
//				int tmp = map[z][z];
//				int endR = map.length-1;
//				int endC = map[0].length-1;
//				for(int i=z;i<map[0].length-z-1;i++) {
//					map[z][i] = map[z][i+1];
//				}
//				for (int i=z;i<map.length-z-1;i++) {
//					map[i][endC-z] = map[i+1][endC-z];
//				}
//				for (int i=endC-z;i>z;i--) {
//					map[endR-z][i] = map[endR-z][i-1]; 
//				}
//				for (int i=endR-z;i>z;i--) {
//					map[i][z] = map[i-1][z];
//				}
//				map[z+1][z]= tmp;
//			}
//		}
		for (int i=0;i<N;i++) {
			for (int j=0;j<M;j++) {
				sb.append(map[i][j]).append(" ");
			}
			sb.append("\n");
		}
		System.out.print(sb.toString());
	}
	public static void spin(int r, int c, int z, int s) {
		int tmp = map[r][c];
		while (s>0) {
			if (r==z&&c>z) {
//				if (s>=c-z) {
//					s-=(c-z);
//					c=z;
//				}
//				else {
//					s=0;
//					c=c-s;
//				}
				c--;
				s--;
			}
			else if(c==z&&r<N-1-z) {
				r++;
				s--;
			}
			else if(r==N-1-z&&c<M-1-z) {
				c++;
				s--;
			}
			else if(c==M-1-z&&r>z) {
				r--;
				s--;
			}
		}
		ans[r][c] = tmp;
		
	}
}
