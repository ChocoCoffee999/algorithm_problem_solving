package SWEA;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SWEA1974 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		int[][] map = new int[9][9];
		for (int test_case=1;test_case<=T;test_case++) {
			String[] input;
			for (int i = 0; i<9; i++) {
				input = br.readLine().trim().split(" ");
				for (int j = 0; j<9; j++) {
					map[i][j] = Integer.parseInt(input[j]);
				}
			}
			
			for (int i = 0; i<9;i++) {
				int[] verifyC = new int [9];
				int[] verifyR = new int [9];
				int[] verify = null;
				for (int j = 0; j<9;j++) {
					verifyC[map[i][j]-1]++;
					verifyR[map[j][i]-1]++;
					if (i%3==0&&j%3==0) {
						verify = new int[9];
						for (int k=0;k<3;k++) {
							for (int l=0;l<3;l++) {
								verify[map[i+k][j+l]-1]++;
							}
						}
					}
				}
				
				if (! Arrays.toString(verifyR).equals("[1, 1, 1, 1, 1, 1, 1, 1, 1]")) {
					System.out.printf("#%d %d\n", test_case, 0);
					break;
				}
				if (! Arrays.toString(verifyC).equals("[1, 1, 1, 1, 1, 1, 1, 1, 1]")) {
					System.out.printf("#%d %d\n", test_case, 0);
					break;
				}
				if (verify!=null) {
					if (! Arrays.toString(verify).equals("[1, 1, 1, 1, 1, 1, 1, 1, 1]")) {
						System.out.printf("#%d %d\n", test_case, 0);
						break;
					}
				}
				if (i==8) {
					System.out.printf("#%d %d\n", test_case, 1);
				}
			}
			
		}
	}
}
