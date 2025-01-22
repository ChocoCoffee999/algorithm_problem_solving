package Baekjoon;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Baekjoon16206 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] input = br.readLine().trim().split(" ");
		int n = Integer.parseInt(input[0]);
		int m = Integer.parseInt(input[1]);
		int[] a = new int[n];
		input = br.readLine().trim().split(" ");
		for(int i =0; i<n;i++) a[i] = Integer.parseInt(input[i]);
		Arrays.sort(a);
		int cakeNum = 0;
	
		int[] b = new int[n];
		
		for (int i = 0;i<n;i++) {
			if (a[i]>0&&a[i]%10 == 0) {
				b[i] = a[i]/10;
				a[i]=0;
			}
		}
		Arrays.sort(b);
		
		for (int i = 0; i<b.length;i++) {
			if (m>0&&b[i]!=0) {
				if (b[i]-1>m) {
					cakeNum+=m;
					m=0;
				}
				else if (b[i]-1<=m) {
					cakeNum+=b[i];
					m-=b[i]-1;
				}
			}
			
		}
		
		for (int i = 0; i<n;i++) {
			if (m>0) {
				if (a[i]/10>m) {
					cakeNum+=m;
					m=0;
				}
				if (a[i]/10<=m) {
					cakeNum+=a[i]/10;
					m-=a[i]/10;
				}
			}
		}
		
		System.out.println(cakeNum);
	}
}
