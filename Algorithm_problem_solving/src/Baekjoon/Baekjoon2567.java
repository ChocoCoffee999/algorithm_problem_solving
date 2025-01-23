package Baekjoon;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Baekjoon2567 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine().trim());
		int[][] map =new int[100][100];
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
		int count = 0;
		int typeX = 0;
		int typeY = 0;
		for (int i=0;i<100;i++) {
			for (int j=0;j<100;j++) {
				if (j==0) {
					if (map[i][j]==1) count++;
					if (map[j][i]==1) count++;
					typeX = map[j][i];
					typeY = map[i][j];
					continue;
				}
				if (map[i][j]!=typeY) {
					count++;
					typeY = map[i][j];
				}
				if (map[j][i]!=typeX) {
					count++;
					typeX = map[j][i];
				}
				if (j==99) {
					if (map[i][j]==1) count++;
					if (map[j][i]==1) count++;
				}
				
			}
		}
		System.out.println(count);
	}
}
