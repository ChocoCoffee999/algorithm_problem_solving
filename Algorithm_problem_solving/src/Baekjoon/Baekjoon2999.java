package Baekjoon;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Baekjoon2999 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] input = br.readLine().trim().split("");
		
		int n = input.length;
		
		int minMax = 0;
		for (int i = 1; i<=n/2;i++) if (n%i==0) {
			int r=i;
			int c = n/r;
			minMax = Math.max(Math.min(r, c), minMax);
		}
		int c = n/minMax;
		
		String[][] str = new String[minMax][c];
		
		int count = 0;
		for (int i = 0; i<c;i++) {
			for (int j = 0;j<minMax;j++) {
				str[j][i]=input[count++];
			}
		}
		
		for (int i=0;i<minMax;i++) {
			for (int j =0;j<c;j++) System.out.print(str[i][j]);
		}
		System.out.println();
		
	}

}