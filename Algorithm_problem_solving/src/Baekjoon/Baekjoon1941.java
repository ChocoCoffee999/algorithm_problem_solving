package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Baekjoon1941 {
	static String[][] map = new String[5][];
	static int Ans = 0;
	static int[] dr = {0,0,1,-1};
	static int[] dc = {1,-1,0,0};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int i=0;i<5;i++) {
			map[i] = br.readLine().trim().split("");
		}
		
		int[] array = new int[25];
		for (int i=0;i<array.length;i++) {
			array[i]=i;
		}
		
		conbination(array, 0, 0, new int[7]);
		
		System.out.println(Ans);
	}

	
	static public void bfs(int[] sel) {
		Queue<Pos1941> que = new LinkedList<>();
		que.offer(new Pos1941(sel[0]/5,sel[0]%5));
		boolean[] v = new boolean[7];
		v[0] = true;
		int count = map[sel[0]/5][sel[0]%5].equals("Y") ? 1:0;
		while (que.size()>0) {
			Pos1941 curPos = que.poll();
			for (int i=0;i<4;i++) {
				if (curPos.x+dr[i]>=0&&curPos.x+dr[i]<5&&curPos.y+dc[i]>=0&&curPos.y+dc[i]<5) {
					for (int j=1;j<7;j++) {
						if (v[j]) continue;
						if (curPos.x+dr[i]==sel[j]/5&&curPos.y+dc[i]==sel[j]%5) {
							count += map[sel[j]/5][sel[j]%5].equals("Y") ? 1:0;
							if (count>3) return;
							que.offer(new Pos1941(sel[j]/5,sel[j]%5));
							v[j] = true;
						}
					}
				}
			}
		}
		
		for (int i=0;i<7;i++) {
			if (!v[i]) return;
		}
		Ans++;
	}
	
	static public void conbination(int[] arr, int idx, int depth, int[] sel) {
		if (depth == sel.length) {
			bfs(sel);
			return;
		}
		
		if (idx == arr.length) return;
		
		sel[depth] = arr[idx];
		conbination(arr,idx+1,depth+1,sel);
		conbination(arr,idx+1,depth,sel);
		
	}
}

class Pos1941 {
	public int x = 0;
	public int y = 0;
	
	Pos1941(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
