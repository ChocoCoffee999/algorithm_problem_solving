package SWEA;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class SWEA1983 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine().trim());
		String[] input;
		String[] grade = {"A+","A0","A-","B+","B0","B-","C+","C0","C-","D"};
		for (int test_case=1;test_case<=T;test_case++) {
			input = br.readLine().trim().split(" ");
			int n = Integer.parseInt(input[0]);
			int k = Integer.parseInt(input[1]);
			
			Double[] scoreSum = new Double[n];
			double targetScore = 0;
			for (int i=0;i<n;i++) {
				input = br.readLine().trim().split(" ");
				double sum = 0;
				sum += 0.35*Double.parseDouble(input[0]);
				sum += 0.45*Double.parseDouble(input[1]);
				sum += 0.2*Double.parseDouble(input[2]);
						
				scoreSum[i] = sum;
				if (i+1==k) targetScore = sum;
			}
			
			Arrays.sort(scoreSum, Comparator.reverseOrder());
			
			for (int i=0;i<n;i++) {
				if (scoreSum[i] == targetScore) {
					int cut = n/10;
					int cutLine = i/cut; 
					System.out.printf("#%d %s\n", test_case,grade[cutLine]);
				}
			}
		}
	}
}