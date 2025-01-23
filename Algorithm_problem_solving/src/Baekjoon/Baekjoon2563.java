package Baekjoon;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Baekjoon2563 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine().trim());
		int[][] map = new int[100][100];
		for (int i=0;i<n;i++) {
			String[] input = br.readLine().trim().split(" ");
			int x = Integer.parseInt(input[0]);
			int y = Integer.parseInt(input[1]);
			for (int j=x;j<x+10;j++) {
				for (int k=y;k<y+10;k++) {
					map[j][k]=1;
				}
			}
		}
		int sum = 0;
		for (int i=0;i<100;i++) for (int j=0;j<100;j++) if (map[i][j]==1) sum++;
		
		System.out.println(sum);
	}

}
