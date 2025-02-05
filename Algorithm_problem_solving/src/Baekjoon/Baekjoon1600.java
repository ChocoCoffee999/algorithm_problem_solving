package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Baekjoon1600 {
	static int[][] map;
	static int[] dr = {0,0,1,-1};
	static int[] dc = {1,-1,0,0};
	static int[] drH = {2,2,1,1,-1,-1,-2,-2};
	static int[] dcH = {1,-1,2,-2,2,-2,1,-1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int k = Integer.parseInt(br.readLine().trim());
		
		String[] input = br.readLine().split(" ");
		
		int w = Integer.parseInt(input[0]);
		int h = Integer.parseInt(input[1]);
		
		map = new int[h][w];
		
		for (int i=0;i<h;i++) {
			input = br.readLine().trim().split(" ");
			for (int j=0;j<w;j++) {
				map[i][j] = Integer.parseInt(input[j]);
			}
		}
		
		bfs(new boolean[h][w][k+1], k);
	}

	
	public static void bfs(boolean[][][] v, int k) {
		Queue<Pos1600> que = new LinkedList<>();
		Pos1600 start = new Pos1600(0,0,0,0);
		
		que.offer(start);
		
		while(que.size()>0) {
			Pos1600 curPos = que.poll();
//			System.out.printf("%d %d %d %d\n", curPos.x, curPos.y, curPos.jump, curPos.move);
			if (curPos.x==map.length-1&&curPos.y==map[0].length-1) {
				System.out.println(curPos.move);
				return;
			}
			if (curPos.jump<k) {
				L:for (int i=0;i<8;i++) {
					if(curPos.x+drH[i]>=0&&curPos.x+drH[i]<map.length&&curPos.y+dcH[i]>=0&&curPos.y+dcH[i]<map[0].length) {
						for (int j=0;j<=curPos.jump+1;j++) if (v[curPos.x+drH[i]][curPos.y+dcH[i]][j]) continue L;
						if(map[curPos.x+drH[i]][curPos.y+dcH[i]]==0) {
							Pos1600 nextPos = new Pos1600(curPos.x+drH[i], curPos.y+dcH[i], curPos.jump+1, curPos.move+1);
							que.offer(nextPos);
							v[curPos.x+drH[i]][curPos.y+dcH[i]][curPos.jump+1] = true;
						}
					}
				}
			}
			for (int i=0;i<4;i++) {
				if (curPos.x+dr[i]>=0&&curPos.x+dr[i]<map.length&&curPos.y+dc[i]>=0&&curPos.y+dc[i]<map[0].length) {
					if (v[curPos.x+dr[i]][curPos.y+dc[i]][curPos.jump]) continue;
					if (map[curPos.x+dr[i]][curPos.y+dc[i]]==0) {
						Pos1600 nextPos = new Pos1600(curPos.x+dr[i], curPos.y+dc[i], curPos.jump,curPos.move+1);
						que.offer(nextPos);
						v[curPos.x+dr[i]][curPos.y+dc[i]][curPos.jump] = true;
					}
				}
			}
		}
		System.out.println(-1);
		return;
	}
}

class Pos1600 {
	int x;
	int y;
	int jump;
	int move;
	
	Pos1600(int x, int y, int jump, int move) {
		this.x = x;
		this.y = y;
		this.jump = jump;
		this.move = move;
	}
}
