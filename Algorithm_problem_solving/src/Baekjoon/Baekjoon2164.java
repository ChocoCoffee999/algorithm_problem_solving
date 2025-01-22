package Baekjoon;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Baekjoon2164 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine().trim());
		int c=0;
		for (int i = 0; i<=n;i++) {
			if (Math.pow(2, i) >= n) {
				c = i;
				break;
			}
		}
		int sol = 0;
		if (n-Math.pow(2, c)==0) {
			sol = (int) Math.pow(2, c);
		}
		else {
			sol = 2* (int) (n-Math.pow(2, c-1));
		}
		System.out.println(sol);
	}
}
