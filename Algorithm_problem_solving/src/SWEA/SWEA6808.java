package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class SWEA6808 {
	static int winCount = 0;
	static int count = 0;
	static final int TOTAL_GAMES = games(9);
	static final int TOTAL_SCORE = score(18);
	static int[] gCards;
	static BufferedReader br;
	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine().trim());
		
		for (int test_case=1; test_case<=T; test_case++) {
			winCount=0;
			gCards = Arrays.stream(br.readLine().trim().split(" "))
					.map(s -> Integer.parseInt(s))
					.mapToInt(Integer::intValue)
					.toArray();
			Set<Integer> set = Arrays.stream(gCards).boxed().collect(Collectors.toSet());
			int[] cardpull = new int[18];
			for (int i=1;i<=18;i++) {
				cardpull[i-1]=i;
			}
			
			int[] iCards = Arrays.stream(cardpull).filter(num->!set.contains(num)).toArray();
			set(iCards, 0, 0, 0);
			
			System.out.printf("#%d %d %d\n", test_case, winCount, TOTAL_GAMES - winCount);
		}
	}
	
	public static void set(int[] arr, int sum, int bitmask, int depth) throws Exception {
		if (bitmask==((1<<9)-1)) {
			if (sum>TOTAL_SCORE/2) winCount++;
			return;
		}
		
		for (int i=0;i<9;i++) {
			if ((bitmask&1<<i)==0) {
				bitmask|=(1<<i);
				if (gCards[depth] > arr[i]) set(arr, sum+(gCards[depth]+arr[i]), bitmask, depth+1);
				else set(arr, sum, bitmask, depth+1);
				bitmask^=(1<<i);
			}
		}
	}
	
	public static int games(int n) {
		if (n==1) return 1;
		return n*games(n-1);
	}
	
	public static int score(int n) {
		if (n==1) return 1;
		return n+score(n-1);
	}
}
