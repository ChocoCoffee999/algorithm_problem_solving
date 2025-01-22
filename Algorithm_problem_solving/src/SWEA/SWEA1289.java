package SWEA;
import java.io.BufferedReader;
import java.io.InputStreamReader;


public class SWEA1289 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine().trim());
		
		for (int test_case=1;test_case<=T;test_case++) {
			String[] input = br.readLine().trim().split("");
			int count = 0;
			int type = 0;
			for (int i=0;i<input.length;i++) {
				int n = Integer.parseInt(input[i]);
				if (type != n) {
					type = n;
					count++;
				}
				
			}
			System.out.printf("#%d %d\n",test_case, count);
		}

	}

}
