package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Baekjoon2206 {
	static int[] dr = {0,0,1,-1};
	static int[] dc = {1,-1,0,0};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] input = br.readLine().trim().split(" ");
		
		int n = Integer.parseInt(input[0]);
		int m = Integer.parseInt(input[1]);
		
		int[][] map = new int[n][m];
		
		for (int i=0;i<n;i++) {
			input =br.readLine().trim().split("");
			for (int j=0;j<m;j++) map[i][j] = Integer.parseInt(input[j]);
		}
		int distance = bfs(map, new boolean[n][m][2]);
		int minDistance = distance==-1?Integer.MAX_VALUE:distance;
		
//		for (int i=0;i<n;i++) {
//			for (int j=0;j<m;j++) {
//				if(map[i][j]==1) {
//					map[i][j]=0;
//					distance = bfs(map, new boolean[n][m][2]);
//					if (distance!=-1) minDistance = distance;
//					map[i][j]=1;
//				}
//			}
//		}
		
		System.out.println(minDistance==Integer.MAX_VALUE? -1:minDistance);
		
	}
	
	public static int bfs(int[][] map, boolean[][][] v) {
		Queue<Pos2206> que = new LinkedList<>();
		Pos2206 start = new Pos2206(0,0,0,0);
		que.offer(start);
		v[0][0][0] = true;
		while (que.size()>0) {
			Pos2206 curPos = que.poll();
			if (curPos.x==map.length-1&&curPos.y==map[0].length-1) return curPos.distance+1;
			for (int i=0;i<4;i++) {
				if (curPos.x+dr[i]>=0&&curPos.x+dr[i]<map.length&&curPos.y+dc[i]>=0&&curPos.y+dc[i]<map[0].length) {
					if (curPos.bre==1) if(v[curPos.x+dr[i]][curPos.y+dc[i]][0]) continue; 
					if (v[curPos.x+dr[i]][curPos.y+dc[i]][curPos.bre]) continue;
					if (map[curPos.x+dr[i]][curPos.y+dc[i]]==0) {
						Pos2206 nextPos = new Pos2206(curPos.x+dr[i], curPos.y+dc[i], curPos.distance+1,curPos.bre);
						que.offer(nextPos);
						v[curPos.x+dr[i]][curPos.y+dc[i]][curPos.bre]=true;
					}
					if (map[curPos.x+dr[i]][curPos.y+dc[i]]==1&&curPos.bre<1) {
						Pos2206 nextPos = new Pos2206(curPos.x+dr[i], curPos.y+dc[i], curPos.distance+1,1);
						que.offer(nextPos);
						v[curPos.x+dr[i]][curPos.y+dc[i]][curPos.bre]=true;
					}
				}
			}
		}
		
		return -1;
		
	}

}
class Pos2206 {
	public int x;
	public int y;
	public int distance;
	public int bre;
	
	Pos2206(int x, int y, int distance, int bre) {
		this.x=x;
		this.y=y;
		this.distance=distance;
		this.bre=bre;
	}
}