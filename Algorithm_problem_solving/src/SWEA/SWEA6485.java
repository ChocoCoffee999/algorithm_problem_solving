package SWEA;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SWEA6485 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine().trim());
		for (int test_case=1;test_case<=T;test_case++) {
			int n = Integer.parseInt(br.readLine().trim());
			
			int[][] bus  = new int [n][2];
			
			for (int i=0; i<n;i++) {
				String[] input = br.readLine().trim().split(" ");
				bus[i][0] = Integer.parseInt(input[0]);
				bus[i][1] = Integer.parseInt(input[1]);
			}
			int pNum = Integer.parseInt(br.readLine().trim());
			int[][] p = new int[pNum][2];
			for (int i=0;i<pNum;i++) p[i][0]=Integer.parseInt(br.readLine().trim());
			for (int i=0;i<n;i++) {
				for (int j=bus[i][0];j<=bus[i][1];j++) {
					for (int k=0;k<pNum;k++) {
						if (p[k][0]==j) p[k][1]++;
					}
				}
			}
			System.out.printf("#%d",test_case);
			for (int i=0;i<pNum;i++) {
				System.out.printf(" %d", p[i][1]);
			}
			System.out.println();
		}
	}
}
