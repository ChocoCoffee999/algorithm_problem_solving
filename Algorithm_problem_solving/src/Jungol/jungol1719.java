package Jungol;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class jungol1719 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().trim().split(" ");

        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        if (n%2==0||n<1||n>99) System.out.println("INPUT ERROR!");
        else if (m<1||m>4) System.out.println("INPUT ERROR!");
        else {
            if (m==1) {
                for (int i=0;i<n;i++) {
                    if (i<=n/2) System.out.println("*".repeat(i+1));
                    else System.out.println("*".repeat(n-i));
                }
            }
            else if (m==2) {
                for (int i=0;i<n;i++) {
                	if (i<=n/2) System.out.println(" ".repeat(n/2-i) + "*".repeat(i+1));
                    else System.out.println(" ".repeat(i-n/2)+"*".repeat(n-i));
                }
            }
            else if (m==3) {
            	for (int i=0;i<n;i++) {
            		if (i<n/2) System.out.println(" ".repeat(i)+"*".repeat(n-2*i));
            		else System.out.println(" ".repeat(n-1-i)+"*".repeat((i-n/2)*2+1));
            	}
            }
            else if (m==4) {
                for (int i=0;i<n;i++) {
                    if (i<n/2) System.out.println(" ".repeat(i) + "*".repeat((n/2+1)-i));
                    else System.out.println(" ".repeat(n/2)+"*".repeat(i-n/2+1));
                }
            }
        }
    }
}