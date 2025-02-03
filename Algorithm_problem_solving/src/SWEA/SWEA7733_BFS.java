package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class SWEA7733_BFS {
	static int[][] map;
	static int count;
	static int[] dx = {0,0,1,-1};
	static int[] dy = {1,-1,0,0};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine().trim());
		
		for (int test_case=1;test_case<=T;test_case++) {
			int n = Integer.parseInt(br.readLine());
			map = new int[n][n];
			int maxTaste = 0;
			int dollop = 1;
			for (int i=0;i<n;i++) {
				String[] input = br.readLine().trim().split(" ");
				for (int j=0;j<n;j++) {
					map[i][j] = Integer.parseInt(input[j]);
					maxTaste = Math.max(maxTaste, map[i][j]);
				}
				
			}
			System.out.println("Start!");
			
			for (int day=1; day<maxTaste;day++) {
				for (int i=0;i<n;i++) {
					for (int j=0;j<n;j++) {
						if (map[i][j]==day) map[i][j] = -1;
					}
				}
				int tmp = bfs(new boolean[n][n], n);
				dollop = Math.max(dollop, tmp);
			}
			System.out.printf("#%d %d\n", test_case, dollop);
		}
	}
	
	public static int bfs(boolean[][] v, int n) {
		int dollop = 0;
		Queue<Position> que = new LinkedList<Position>();
		for (int i=0;i<n;i++) {
			for (int j=0;j<n;j++) {
				if (map[i][j]==-1) continue;
				if (v[i][j]) continue;
				que.add(new Position(i,j));
				dollop++;
				while (que.size()>0) {
					Position p = que.remove();
					v[p.getX()][p.getY()] = true;
					for (int k=0;k<4;k++) {
						if(p.getX()+dx[k]>=0&&p.getX()+dx[k]<n&&p.getY()+dy[k]>=0&&p.getY()+dy[k]<n) {
							if (map[p.getX()+dx[k]][p.getY()+dy[k]]==-1) continue;
							if (v[p.getX()+dx[k]][p.getY()+dy[k]]) continue;
							que.add(new Position(p.getX()+dx[k],p.getY()+dy[k]));
							v[p.getX()+dx[k]][p.getY()+dy[k]]=true;
						}
					}
				}
			}
		}
		return dollop;
	}
	
}

class Position {
	private int x;
	private int y;
	
	Position() {
		x = 0;
		y = 0;
	}
	
	
	public Position(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}


	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
}
