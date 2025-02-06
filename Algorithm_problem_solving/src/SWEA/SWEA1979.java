package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA1979 {
	static boolean[][] map;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine().trim());
		
		for (int test_case=1;test_case<=T;test_case++) {
			String[] input = br.readLine().trim().split(" ");
			int N = Integer.parseInt(input[0]);
			int K = Integer.parseInt(input[1]);
			
			map = new boolean[N][N];
			
			for (int i=0; i<N; i++) {
				input = br.readLine().trim().split(" ");
				for (int j=0; j<N; j++) {
					map[i][j] = input[j].equals("0");
				}
			}
			
			System.out.printf("#%d %d\n", test_case, searchVertical(new boolean[N][N], K)+searchHorizontal(new boolean[N][N], K));
		}
	}
	
	public static int searchVertical(boolean[][] v, int K) {
		int count=0;
		
		for (int i=0;i<map.length;i++) {
			for (int j=0;j<map.length;j++) {
				if (map[i][j]) continue;
				if (v[i][j]) continue;
				int wordLength=1;
				v[i][j]=true;
				for (int k=i+1;k<map.length;k++) {
					if (map[k][j]) break;
					wordLength++;
					v[k][j]=true;
				}
				if (wordLength == K) count++;
			}
		}
		
		return count;
	}
	
	public static int searchHorizontal(boolean[][] v, int K) {
		int count=0;
		
		for (int i=0;i<map.length;i++) {
			for (int j=0;j<map.length;j++) {
				if (map[i][j]) continue;
				if (v[i][j]) continue;
				int wordLength=1;
				v[i][j]=true;
				for (int k=j+1;k<map.length;k++) {
					if (map[i][k]) break;
					wordLength++;
					v[i][k]=true;
				}
				if (wordLength == K) count++;
			}
		}
		return count;
	}
}
