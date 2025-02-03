package Baekjoon;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Baekjoon8320 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine().trim());
		
		int count = 0;
		
		for (int i=1;i<=n;i++) {
			for (int j=i;j<=n;j++) {
				if (i*j <= n) {
					count++;
				}
				else break;
			}
		}
		System.out.println(count);
	}

}
