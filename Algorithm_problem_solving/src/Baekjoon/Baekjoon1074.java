package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon1074 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		
		System.out.println(dc((int) Math.pow(2, N),r,c));
	}
	
	public static int dc(int N, int r, int c) {
		if (N==2) {
			if (r==0) {
				if (c==0) return 0;
				else return 1;
			}
			else {
				if (c==0) return 2;
				else return 3;
			}
		}
		int n = N/2;
		if (r<n) {
			if (c<n) {
				return dc(n, r, c);
			}
			else {
				return (int) Math.pow(n, 2)+ dc(n, r, c-n);
			}
		}
		else {
			if (c<n) {
				return (int) Math.pow(n, 2) * 2 + dc(n, r-n, c);
			}
			else {
				return (int) Math.pow(n, 2) * 3 + dc(n, r-n, c-n);
			}
		}
		
	}
}
