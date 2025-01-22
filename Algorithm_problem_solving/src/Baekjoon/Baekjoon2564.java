package Baekjoon;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Baekjoon2564 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] input = br.readLine().trim().split(" ");
		int n = Integer.parseInt(input[0]);
		int m = Integer.parseInt(input[1]);
		
		int storeNum = Integer.parseInt(br.readLine().trim());
		
		int[][] store = new int[storeNum][2];
		
		for (int i =0; i<storeNum;i++) {
			input = br.readLine().trim().split(" ");
			store[i][0] = Integer.parseInt(input[0]);
			store[i][1] = Integer.parseInt(input[1]);
		}
		input = br.readLine().trim().split(" ");
		int x = Integer.parseInt(input[0]);
		int y = Integer.parseInt(input[1]);
		
		int sol = 0;
		for (int i = 0; i<storeNum;i++) {
			sol+=search(store[i][0],store[i][1], x, y, n, m);
		}
		
		System.out.println(sol);
	}
	
	public static int search(int x1, int y1, int x2, int y2, int n, int m) {
		int maxX;
		int maxY;
		int minX;
		int minY;
		
		if (x1>x2) {
			maxX = x1;
			minX = x2;
			maxY = y1;
			minY = y2;
		}
		else {
			maxX = x2;
			minX = x1;
			maxY = y2;
			minY = y1;
		}
		int type = Math.abs(maxX-minX);
		
		if (type==0) {
			return Math.abs(maxY-minY);
		}
		else if (type==1) {
			if (minX==1) {
				int route1 = m+maxY+minY;
				int route2 = m+(n-maxY)+(n-minY);
				return Math.min(route1, route2);
			}
			if (minX==3) {
				int route1 = n+maxY+minY;
				int route2 = n+(m-maxY)+(m-minY);
				return Math.min(route1, route2);
			}
		}
		int horizontalMove;
		int verticalMove;
		if (maxX==3) horizontalMove = minY;
		else horizontalMove = n-minY;
		if (minX==1) verticalMove = maxY;
		else verticalMove = m-maxY;
		
		return horizontalMove+verticalMove;
	}

}
