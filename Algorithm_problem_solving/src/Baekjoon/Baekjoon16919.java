package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class Baekjoon16919 {
	static int[] dr = {0,0,1,-1};
	static int[] dc = {1,-1,0,0};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().trim().split(" ");
		
		int R = Integer.parseInt(input[0]);
		int C = Integer.parseInt(input[1]);
		int N = Integer.parseInt(input[2]);
		
		int[][] map = new int[R][C];
		int[][] boomMap1 = new int[R][C];
		int[][] boomMap2 = new int[R][C];
		
		Queue<Pos> booms = new ArrayDeque<>();
		for (int i=0;i<R;i++) {
			input = br.readLine().trim().split("");
			for (int j=0;j<C;j++) {
				if (input[j].equals(".")) {
					map[i][j] = 0;
					boomMap1[i][j] = 0;
				}
				else {
					map[i][j] = 3;
					boomMap1[i][j] = 3;
				}
			}
		}
		
		int count = 0;
		while (count < 5) {
			count++;
			System.out.printf("#%d\n", count);
			for (int i=0;i<R;i++) {
				for (int j=0;j<C;j++) {
					System.out.print(boomMap1[i][j]);
				}
				System.out.println();
			}
			System.out.println();
			for (int i=0;i<R;i++) {
				for (int j=0;j<C;j++) {
					if (boomMap1[i][j]>0) {
						boomMap1[i][j]--;
						if (boomMap1[i][j]==0) {
							booms.offer(new Pos(i,j));
						}
					}
				}
			}
			
			if (count%2 == 0) {
				for (int i=0;i<R;i++) {
					for (int j=0;j<C;j++) {
						if (boomMap1[i][j]==0) boomMap1[i][j] = 3;
					}
				}
			}
			
			while (booms.size()>0) {
				Pos curPos = booms.poll();
				for (int i=0;i<4;i++) {
					if (curPos.r+dr[i]>=0&&curPos.r+dr[i]<R&&curPos.c+dc[i]>=0&&curPos.c+dc[i]<C) {
						boomMap1[curPos.r+dr[i]][curPos.c+dc[i]]=0;
					}
				}
			}
			
			if (count==3) {
				for (int i=0;i<R;i++) {
					for (int j=0;j<C;j++) {
						boomMap2[i][j] = boomMap1[i][j];
					}
				}
			}
			
			if (count==5) {
				for (int i=0;i<R;i++) {
					for (int j=0;j<C;j++) {
						int tmp = boomMap2[i][j];
						boomMap2[i][j] = boomMap1[i][j];
						boomMap1[i][j] = tmp;
					}
				}
			}
		}
		if (N<2) {
			for (int i=0;i<R;i++) {
				for (int j=0;j<C;j++) {
					if (map[i][j]==0) System.out.print(".");
					else System.out.print("O");
				}
				System.out.println();
			}
		}
		else if (N>4&&N%4==1) {
			for (int i=0;i<R;i++) {
				for (int j=0;j<C;j++) {
					if (boomMap2[i][j]==0) System.out.print(".");
					else System.out.print("O");
				}
				System.out.println();
			}
		}
		else if (N%2==0) {
			for (int i=0;i<R;i++) {
				for (int j=0;j<C;j++) {
					System.out.print("O");
				}
				System.out.println();
			}
		}
		else if (N%4==3) {
			for (int i=0;i<R;i++) {
				for (int j=0;j<C;j++) {
					if (boomMap1[i][j]==0) System.out.print(".");
					else System.out.print("O");
				}
				System.out.println();
			}
		}
	}
	static class Pos {
		int r;
		int c;
		
		public Pos(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
}