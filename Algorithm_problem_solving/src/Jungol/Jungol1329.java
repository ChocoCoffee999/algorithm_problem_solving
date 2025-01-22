package Jungol;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Jungol1329 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine().trim());
		if (n%2==0||n<1||100<n) System.out.println("INPUT ERROR!");
		else {
			for (int i =0;i<n;i++) {
				if (i<n/2) System.out.println(" ".repeat(i)+"*".repeat(i*2+1));
				else System.out.println(" ".repeat(n-1-i)+"*".repeat((n-i)*2-1));
			}
		}
	}

}
