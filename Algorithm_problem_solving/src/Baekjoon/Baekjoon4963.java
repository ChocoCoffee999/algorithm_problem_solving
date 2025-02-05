package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Baekjoon4963 {
	static int[] dr = {0,0,1,1,1,-1,-1,-1};
	static int[] dc = {1,-1,0,1,-1,0,1,-1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			String[] input = br.readLine().trim().split(" ");
			int w = Integer.parseInt(input[0]);
			int h = Integer.parseInt(input[1]);
			
			if (h==0||w==0) break;
			
			int[][] map = new int[h][w];
			boolean[][] v= new boolean[h][w];
			int count = 0;
			for (int i =0;i<h;i++) {
				input = br.readLine().trim().split(" ");
				for (int j=0;j<w;j++) {
					map[i][j] = Integer.parseInt(input[j]);
				}
			}
			
			for (int i=0;i<h;i++) {
				for (int j=0;j<w;j++) {
					if (v[i][j]) continue;
					if (map[i][j]==1) {
						bfs(map, v, i, j);
						count++;
					}
				}
			}
			System.out.println(count);
		}
	}
	
	public static void bfs(int[][] map, boolean[][] v, int x, int y) {
		Queue<PosP> que = new LinkedList<PosP>();
		PosP start = new PosP(x,y);
		que.offer(start);
		
		while (que.size()>0) {
			PosP curPos = que.poll();
			for (int i=0;i<8;i++) {
				if(curPos.x+dr[i]>=0&&curPos.x+dr[i]<map.length&&curPos.y+dc[i]>=0&&curPos.y+dc[i]<map[0].length) {
					if (v[curPos.x+dr[i]][curPos.y+dc[i]]) continue;
					if (map[curPos.x+dr[i]][curPos.y+dc[i]]==1) {
						PosP nextPos = new PosP(curPos.x+dr[i],curPos.y+dc[i]);
						que.offer(nextPos);
						v[curPos.x+dr[i]][curPos.y+dc[i]]=true;
					}
				}
			}
		}
	}
}

class PosP {
	public int x;
	public int y;
	
	PosP(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
