package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SWEA1940 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine().trim());
		
		for (int test_case=1; test_case<=T; test_case++) {
			int n = Integer.parseInt(br.readLine().trim());
			String[] input;
			int command;
			int velocity=0;
			int acceleration=0;
			int distance=0;
			for (int i=0; i<n; i++) {
				input = br.readLine().trim().split(" ");
				command = Integer.parseInt(input[0]);
				if (command!=0) acceleration=Integer.parseInt(input[1]);
				if (command!=0) velocity= (velocity+acceleration * (command == 1 ? 1 : -1) < 0 ? 0 : velocity+acceleration * (command == 1 ? 1 : -1));
				distance+=velocity<0 ? 0:velocity;
			}
			System.out.printf("#%d %d\n",test_case,distance);
		}
	}

}
