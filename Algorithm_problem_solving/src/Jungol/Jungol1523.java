package Jungol;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Jungol1523 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] input = br.readLine().trim().split(" ");

        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        
        if (n<1 || 100<n) {
            System.out.println("INPUT ERROR!");
        }
        else if (m<1 || 3<m) {
            System.out.println("INPUT ERROR!");
        }
        else {
            if (m == 1) {
                for (int i = 1;i<=n;i++) {
                    System.out.println("*".repeat(i));
                }
            }
            else if (m == 2) {
                for (int i = n;i>=1;i--) {
                    System.out.println("*".repeat(i));
                }
            }
            else if (m == 3) {
                for (int i = 1;i<=n;i++) {
                    System.out.println(" ".repeat(n-i)+"*".repeat((i-1)*2+1));
                }
            }
        }
        System.out.println("*".repeat(0));
	}

}
