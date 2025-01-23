package SWEA;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SWEA5215 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine().trim());
		
		for (int test_case=1;test_case<=T;test_case++) {
			String[] input = br.readLine().trim().split(" ");
			int n = Integer.parseInt(input[0]);
			int l = Integer.parseInt(input[1]);
			int[][] source = new int[n][2];
			for (int i=0;i<n;i++) {
				input = br.readLine().trim().split(" ");
				source[i][1] = Integer.parseInt(input[0]);
				source[i][0] = Integer.parseInt(input[1]);
			}
			System.out.printf("#%d %d\n",test_case, recursive(source, 0,0,l,0));
			
			
		}

	}
	
	public static int recursive(int[][] arr, int idx, int calorieSum, int calorieLimit, int maxHappy) {
		if (calorieSum>calorieLimit) {
			return maxHappy-arr[idx-1][1];
		}
		if (calorieSum==calorieLimit) {
			return maxHappy;
		}
		if (idx==arr.length) {
			return maxHappy;
		}
		int happy1=0;
		int happy2=0;
		happy1 = recursive(arr,idx+1,calorieSum+arr[idx][0], calorieLimit, maxHappy+arr[idx][1]);
		happy2 = recursive(arr,idx+1,calorieSum, calorieLimit, maxHappy);
		if (maxHappy<happy1) maxHappy=happy1;
		if (maxHappy<happy2) maxHappy=happy2;
		return maxHappy;
	}

}
