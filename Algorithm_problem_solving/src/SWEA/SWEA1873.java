package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SWEA1873 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine().trim());
		for (int test_case = 1; test_case<=T;test_case++) {
			String[] input = br.readLine().trim().split(" ");
			int n = Integer.parseInt(input[0]);
			int m = Integer.parseInt(input[1]);
			int x = -1;
			int y = -1;
			int d = -1;
			
			int[][] map = new int[n][m];
			for (int i = 0; i<n;i++) {
				input = br.readLine().trim().split("");
				for (int j=0;j<m;j++) {
					if (input[j].equals(".")) map[i][j]=0;
					else if (input[j].equals("*")) map[i][j]=1;
					else if (input[j].equals("#")) map[i][j]=2;
					else if (input[j].equals("-")) map[i][j]=3;
					else if (input[j].equals("^")) {
						x = i;
						y = j;
						d = 1;
						map[i][j]=0;
					}
					else if (input[j].equals(">")) {
						x = i;
						y = j;
						d = 2;
						map[i][j]=0;
					}
					else if (input[j].equals("v")) {
						x = i;
						y = j;
						d = 3;
						map[i][j]=0;
					}
					else if (input[j].equals("<")) {
						x = i;
						y = j;
						d = 4;
						map[i][j]=0;
					}
				}
			}
			int cNum = Integer.parseInt(br.readLine().trim());
			input = br.readLine().trim().split("");
			for (int i = 0; i<cNum;i++) {
				if (input[i].equals("U")) {
					if (x-1>=0&&map[x-1][y]==0) {
						x = x-1;
					}
					d = 1;
				}
				else if (input[i].equals("D")) {
					if (x+1<n&&map[x+1][y]==0) {
						x = x+1;
					}
					d = 3;
				}
				else if (input[i].equals("L")) {
					if (y-1>=0&&map[x][y-1]==0) {
						y = y-1;
					}
					d = 4;
				}
				else if (input[i].equals("R")) {
					if (y+1<m&&map[x][y+1]==0) {
						y = y+1;
					}
					d = 2;
				}
				else if (input[i].equals("S")) {
					if (d==1) {
						int count = 1;
						while (x-count>=0) {
							if (map[x-count][y] == 1) {
								map[x-count][y] = 0;
								break;
							}
							else if (map[x-count][y] == 2) break;
							count++;
						}
					}
					else if (d==2) {
						int count = 1;
						while (y+count<m) {
							if (map[x][y+count] == 1) {
								map[x][y+count] = 0;
								break;
							}
							else if (map[x][y+count] == 2) break;
							count++;
						}
					}
					else if (d==3) {
						int count = 1;
						while (x+count<n) {
							if (map[x+count][y] == 1) {
								map[x+count][y] = 0;
								break;
							}
							else if (map[x+count][y] == 2) break;
							count++;
						}
					}
					else if (d==4) {
						int count = 1;
						while (y-count>=0) {
							if (map[x][y-count] == 1) {
								map[x][y-count] = 0;
								break;
							}
							else if (map[x][y-count] == 2) break;
							count++;
						}
					}
						
				}
			}
			System.out.printf("#%d ", test_case);
			map[x][y]=4;
			for (int i=0;i<n;i++) {
				for (int j=0;j<m;j++) {
					if (map[i][j]==0) System.out.print(".");
					else if (map[i][j]==1) System.out.print("*");
					else if (map[i][j]==2) System.out.print("#");
					else if (map[i][j]==3) System.out.print("-");
					else if (map[i][j]==4) {
						if (d==1) System.out.print("^");
						else if (d==2) System.out.print(">");
						else if (d==3) System.out.print("v");
						else if (d==4) System.out.print("<");
					}
				}
				System.out.println();
			}
		}
	}
}
