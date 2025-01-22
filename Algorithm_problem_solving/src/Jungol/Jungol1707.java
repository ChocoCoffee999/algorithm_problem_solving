package Jungol;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Jungol1707 {

	public static void main(String[] args) throws Exception{
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine().trim());
		
		int[][] map = new int[n][n];
		
		int x = 0;
		int y = -1;
		int count = 0;
		for (int i = 0; i<n;i++) {
			map[x][++y] = ++count;
		}
		for (int i = 1; i<n;i++) {
			for (int j = n-i; j>0;j--) {
				if (i%2==1) map[++x][y] = ++count;
				else map[--x][y] = ++count;
			}
			for (int j = n-i; j>0;j--) {
				if (i%2==0) map[x][++y] = ++count;
				else map[x][--y] = ++count;
			}
		}
		for (int i = 0; i < n;i++) {
			for (int j = 0; j < n;j++) {
				System.out.print(map[i][j]);
				if (j!=n-1) System.out.print(" ");
				else System.out.println();
			}
		}
	}
}
