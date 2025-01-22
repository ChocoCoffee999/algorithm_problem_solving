package SWEA;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SWEA1859 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine().trim());
		
		for (int test_case=1;test_case<=T;test_case++) {
			String[] input = br.readLine().trim().split(" ");
			int[] price = new int[input.length];
			
			for (int i=0; i<input.length; i++) {
				price[i] = Integer.parseInt(input[i]);
			}
			int benefit = 0;
			while(price.length>0) {
				int maxPrice =-1;
				int maxIdx=-1;
				for (int j=0; j<price.length; j++) {
					if (price[j]>maxPrice) {
						maxPrice = price[j];
						maxIdx=j;
					}
				}

				for (int j=0; j<=maxIdx; j++) {
					benefit+=maxPrice-price[j];
				}
				if (maxIdx+1==price.length) break;
				else price=Arrays.copyOfRange(price, maxIdx+1, price.length);
			}
			System.out.printf("#%d %d\n", test_case, benefit);
		}
	}
}
