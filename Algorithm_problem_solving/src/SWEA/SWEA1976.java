package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA1976 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine().trim());
		
		for (int test_case=1;test_case<=T;test_case++) {
			String[] input = br.readLine().trim().split(" ");
			
			int hour = Integer.parseInt(input[0]) + Integer.parseInt(input[2]);
			int minute = Integer.parseInt(input[1]) + Integer.parseInt(input[3]);
			if (minute>=60) {
				minute-=60;
				hour+=1;
			}
			hour=hour>12 ? hour-12:hour;
			
			System.out.printf("#%d %d %d\n", test_case, hour, minute);
		}
	}

}
