package Programmers;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class PickingUpItem {
	static int[][] rectangle = {{2,2,5,5},{1,3,6,4},{3,1,4,6}};
	public static void main(String[] args) {
		int characterX = 1;
		int characterY = 4;
		int itemX = 6;
		int itemY = 3;
		long[] bitmask = mask();
		
		System.out.println(bfs(characterX, characterY, itemX, itemY, bitmask));
	}
	
	static int[] dr = {0,0,1,-1};
	static int[] dc = {1,-1,0,0};
	public static int bfs(int cX, int cY, int iX, int iY, long[] bitmask) {
		Queue<Pos> que = new ArrayDeque<>();
		que.offer(new Pos(cX, cY, 0));
		bitmask[cX]|=1L<<cY;
		while(que.size()>0) {
			Pos cur = que.poll();
			int curRec = checkRec(cur.r,cur.c);
			if (cur.r==iX&&cur.c==iY) return cur.dis;
			for (int d=0;d<4;d++) {
				int nr = cur.r+dr[d];
				int nc = cur.c+dc[d];
				if (check(nr, nc)) continue;
				int nRec = checkRec(nr, nc);
				if (checkJump(curRec, nRec, d, cur.r, cur.c, nr, nc)) continue;
				if (nRec==0) continue;
				if ((curRec&nRec)!=0) {
					if ((bitmask[nr]&1L<<nc)==0L) {
						bitmask[nr]|=1L<<nc;
						que.offer(new Pos(nr, nc, cur.dis+1));
					}
				}
			}
		}
		return -1;
	}
	
	public static boolean checkJump(int bit1, int bit2, int d, int r, int c, int nr, int nc) {
		int mul = bit1&bit2;
		int count = 0;
		while(mul>0) {
			if ((mul&1)==1) {
				if ((d==2||d==3)&&((rectangle[count][0]==r&&rectangle[count][2]==nr)||
					(rectangle[count][2]==r&&rectangle[count][0]==nr))) {
					if (c>rectangle[count][1]&&c<rectangle[count][3]) return true;
				}
				else if ((d==0||d==1)&&((rectangle[count][1]==c&&rectangle[count][3]==nc)||
						(rectangle[count][3]==c&&rectangle[count][1]==nc))) {
					if (r>rectangle[count][0]&&r<rectangle[count][2]) return true;
				}
			}
			count++;
			mul=mul>>1;
		}
		return false;
	}
	
	public static boolean check(int r, int c) {
		for (int i=0; i<rectangle.length; i++) {
			if (r>rectangle[i][0]&&r<rectangle[i][2]&&c>rectangle[i][1]&&c<rectangle[i][3]) return true;
		}
		return false;
	}
	
	public static int checkRec(int r, int c) {
		int recs = 0;
		for (int i=0; i<rectangle.length; i++) {
			if (r==rectangle[i][0]||r==rectangle[i][2]) {
				if (c>=rectangle[i][1]&&c<=rectangle[i][3]) {
					recs |= 1<<i;
				}
			}
			else if (c==rectangle[i][1]||c==rectangle[i][3]) {
				if (r>=rectangle[i][0]&&r<=rectangle[i][2]) {
					recs |= 1<<i;
				}
			}
		}
		return recs;
	}
	
	public static long[] mask() {
		int maxR = 0;
		for (int i=0;i<rectangle.length;i++) {
			maxR = Math.max(rectangle[i][2],maxR);
		}
		return new long[maxR+1];
	}
	
	static class Pos {
		public int r;
		public int c;
		public int dis;
		
		Pos(int r, int c, int dis) {
			this.r=r;
			this.c=c;
			this.dis=dis;
		}
	}
}
