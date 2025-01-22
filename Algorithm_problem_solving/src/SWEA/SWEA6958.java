package SWEA;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SWEA6958 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine().trim());
		
		for (int test_case=1;test_case<=T;test_case++) {
			String[] input = br.readLine().trim().split(" ");
			int n = Integer.parseInt(input[0]);
			int m = Integer.parseInt(input[1]);
			int[] people = new int[n];
			for (int i=0;i<n;i++) {
				input = br.readLine().trim().split(" ");
				int score=0;
				for (int j=0;j<m;j++) {
					score+=Integer.parseInt(input[j]);
				}
				people[i]=score;
			}
			int maxScore=0;
			int winnerNum=0;
			for (int i=0;i<n;i++) {
				if (people[i]>maxScore) {
					maxScore=people[i];
					winnerNum=1;
				}
				else if (people[i]==maxScore) winnerNum++;
			}
			System.out.printf("#%d %d %d\n", test_case, winnerNum, maxScore);
		}
	}
}