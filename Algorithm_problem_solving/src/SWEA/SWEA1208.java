package SWEA;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SWEA1208 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int test_case=1;test_case<=10;test_case++) {
		
			int n = Integer.parseInt(br.readLine().trim());
		
			int[] boxs = new int[100];
			
			String[] input = br.readLine().split(" ");
			
			for (int i = 0; i<100;i++) {
				boxs[i] = Integer.parseInt(input[i]);
			}
			
			Arrays.sort(boxs);
			
			for (int i = 0; i<n;i++) {
				boxs[0]++;
				boxs[99]--;
				Arrays.sort(boxs);
			}
			
			System.out.printf("#%d %d\n", test_case, boxs[99]-boxs[0]);
		}
	}

}
