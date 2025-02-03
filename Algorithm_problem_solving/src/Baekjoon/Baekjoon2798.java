package Baekjoon;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Baekjoon2798 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().trim().split(" ");
		int cardNum = Integer.parseInt(input[0]);
		int maxNum = Integer.parseInt(input[1]);
		input = br.readLine().trim().split(" ");
		int[] card = new int[cardNum];
		for (int i =0; i<cardNum;i++) {
			card[i] = Integer.parseInt(input[i]);
		}
		int sol=0;
		for (int i = 0; i<cardNum-2;i++) {
			for (int j = i+1; j<cardNum-1;j++) {
				for (int k = j+1;k<cardNum;k++) {
					int sum = card[i]+card[j]+card[k];
					if (sum>maxNum) continue;
					if (sum>sol) sol = sum; 
				}
			}
		}
		System.out.println(sol);
	}

}
