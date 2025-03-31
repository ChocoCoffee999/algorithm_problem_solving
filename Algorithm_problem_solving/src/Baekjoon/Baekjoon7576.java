package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Baekjoon7576 {
	static int[][] map;
	static int[] dr = {0,0,1,-1};
	static int[] dc = {1,-1,0,0};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().trim().split(" ");
		int m = Integer.parseInt(input[0]);
		int n = Integer.parseInt(input[1]);
		
		map = new int[n][m];
		for (int i = 0;i<n;i++) {
			input = br.readLine().trim().split(" ");
			for (int j=0;j<m;j++) {
				map[i][j] = Integer.parseInt(input[j]);
			}
		}	
		System.out.println(bfs());
	}
	
	public static int bfs() {
		Queue<Pos> que = new LinkedList<>();
		int maxDate = 0;
		for (int i=0;i<map.length;i++) {
			for (int j=0;j<map[0].length;j++) {
				if (map[i][j]==1) {
					Pos tomato = new Pos(i,j,0);
					que.offer(tomato);
				}
			}
		}
		
		while (que.size()>0) {
			Pos tomato = que.poll();
			for (int i=0;i<4;i++) {
				if (tomato.getR()+dr[i]>=0&&tomato.getR()+dr[i]<map.length&&tomato.getC()+dc[i]>=0&&tomato.getC()+dc[i]<map[0].length) {
					if (map[tomato.getR()+dr[i]][tomato.getC()+dc[i]] == 1) continue;
					if (map[tomato.getR()+dr[i]][tomato.getC()+dc[i]]==0) {
						map[tomato.getR()+dr[i]][tomato.getC()+dc[i]] =1;
						Pos NextTomato = new Pos(tomato.getR()+dr[i], tomato.getC()+dc[i], tomato.getDay()+1);
						maxDate = Math.max(maxDate, tomato.getDay()+1);
						que.offer(NextTomato);
					}
				}
			}
		}
		
		for (int k=0;k<map.length;k++) {
			for (int l=0;l<map[0].length;l++) {
				if (map[k][l]==0) return -1;
			}
		}
		return maxDate;
	}
	
	static class Pos {
		private int r = 0;
		private int c = 0;
		private int day = 0;
		Pos(int r, int c, int day) {
			this.r = r;
			this.c = c;
			this.day = day;
		}
		
		public int getR() {
			return this.r;
		}
		
		public int getC() {
			return this.c;
		}
		
		public int getDay() {
			return this.day;
		}
	}
}