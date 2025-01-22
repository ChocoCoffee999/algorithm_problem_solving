package Baekjoon;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Baekjoon2615 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[][] map = new int[19][19];
		
		for (int i = 0; i<19;i++) {
			String[] input = br.readLine().trim().split(" ");
			for (int j = 0; j <19;j++) {
				map[i][j] = Integer.parseInt(input[j]);
			}
		}
		int[] dr = {0,1,1,1};
		int[] dc = {1,1,-1,0};
		boolean f = false;
		int x=0, y=0, win=-1;
		for (int i=0; i<19; i++) {
			for (int j=0; j<19; j++) {
				if (map[i][j]!=0) {
					int type = map[i][j];
					for (int k = 0; k<4; k++) {
						int count = 0;
						x = i;
						y = j;
						for (int l=1; l<5; l++) {
							if (i+dr[k]*l>=0&&i+dr[k]*l<19&&j+dc[k]*l>=0&&j+dc[k]*l<19) {
								if (map[i+dr[k]*l][j+dc[k]*l]==type) {
									if (y>j+dc[k]*l) {
										x = i+dr[k]*l;
										y = j+dc[k]*l;
									}
									else if (y==j+dc[k]*l) if (x>i+dr[k]*l) {
										x = i+dr[k]*l;
										y = j+dc[k]*l;
									}
									count++;
									continue;
								}
								else break;
							}
						}
						if (count == 4) {
							if (i+dr[k]*-1>=0&&i+dr[k]*-1<19&&j+dc[k]*-1>=0&&j+dc[k]*-1<19) {
								if (map[i+dr[k]*-1][j+dc[k]*-1]==type) {
									count = 0;
									x = i;
									y = j;
									break;
								}
							}
							if (i+dr[k]*5>=0&&i+dr[k]*5<19&&j+dc[k]*5>=0&&j+dc[k]*5<19) {
								if (map[i+dr[k]*5][j+dc[k]*5]==type) {
									count = 0;
									x = i;
									y = j;
									break;
								}
							}
							f = true;
							win = type;
							break;
						}
					}
				}
				if (f) break;
			}
			if (f) break;
		}
		
		if (f) System.out.printf("%d\n%d %d\n", win,x+1, y+1);
		else System.out.println(0);
	}
}
