package Baekjoon;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Baekjoon17135 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] input = br.readLine().trim().split(" ");
		int n = Integer.parseInt(input[0]);
		int m = Integer.parseInt(input[1]);
		int d = Integer.parseInt(input[2]);
		int maxKilledEnemyNum = 0;
		
		if (3<=n&&n<=15&&3<=m&&m<=15&&1<=d&&d<=10) {
			int[][] map = new int[n+1][m];
			for (int i = 0; i<n;i++) {
				input = br.readLine().trim().split(" ");
				for (int j = 0; j<m;j++) {
					map[i][j] = Integer.parseInt(input[j]);
				}
			}
			
			for (int i = 0; i<m-2;i++) {
				for (int j = i+1;j<m-1;j++) {
					for (int k = j+1;k<m;k++) {
						int[][] tmpMap = new int[n][map[0].length];
						int killedEnemyNum =0;
						for (int o = 0;o<n;o++) {
							tmpMap[o] = Arrays.copyOf(map[o], map[o].length);
						}
						for (int l = n-1;l>=0;l--) {
							Location Archer = new Location(l+1,i);
							Location destination1 = new Location(30,30);
							Location destination2 = new Location(30,30);
							Location destination3 = new Location(30,30);
							
							boolean[][] vMap = new boolean[l+1][tmpMap[0].length];
							search(Archer, destination1, tmpMap,l,i,d, vMap);
							
							Archer = new Location(l+1,j);
							vMap = new boolean[l+1][tmpMap[0].length];
							search(Archer, destination2, tmpMap,l,j,d, vMap);
							
							Archer = new Location(l+1,k);
							vMap = new boolean[l+1][tmpMap[0].length];
							search(Archer, destination3, tmpMap,l,k,d, vMap);
	
							int killed = 0;
							
							if (destination1.getX()!=30) {
								tmpMap[destination1.getX()][destination1.getY()] = 0;
								killed++;
							}
							if (destination2.getX()!=30) {
								tmpMap[destination2.getX()][destination2.getY()] = 0;
								killed++;
							}
							if (destination3.getX()!=30) {
								tmpMap[destination3.getX()][destination3.getY()] = 0;
								killed++;
							}
							
							if (destination1.getX()!=30&&destination2.getX()!=30&&destination1.equals(destination2)) killed--;
							if (destination2.getX()!=30&&destination3.getX()!=30&&destination2.equals(destination3)) killed--;
							if (destination3.getX()!=30&&destination1.getX()!=30&&destination3.equals(destination1)) killed--;
							
							if (destination1.getX()!=30&&destination2.getX()!=30&&destination3.getX()!=30&&destination1.equals(destination2)&&destination2.equals(destination3)) killed++;
							killedEnemyNum+=killed;
						}
						if (killedEnemyNum>maxKilledEnemyNum) maxKilledEnemyNum = killedEnemyNum;
					}
				}
			}
			System.out.println(maxKilledEnemyNum);
		}
		else System.out.println(-1);
	}


	public static class Location {
		private int x, y;
		
		public Location(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
		@Override
	    public boolean equals(Object obj) {
	        if (this == obj) {
	            return true;
	        }

	        if (obj == null || getClass() != obj.getClass()) {
	            return false;
	        }

	        Location other = (Location) obj;
	        return this.x == other.x && this.y == other.y;
	    }
		
		public int getX() {
	        return x;
	    }

	    public int getY() {
	        return y;
	    }
	    
	    public void setXY(int x, int y) {
	    	this.x = x;
	    	this.y = y;
	    }
	    
	    public int distanceTo(int x1, int y1) {
	        return Math.abs(this.x - x1) + Math.abs(this.y - y1);
	    }
	    
	    public int distanceTo(Location other) {
	        return Math.abs(this.x - other.x) + Math.abs(this.y - other.y);
	    }
	}


	public static void search(Location location, Location destination, int[][] map, int x, int y, int d, boolean[][] v) {
		if (! v[x][y]) {
			v[x][y]=true;
		
			if (map[x][y]==1) {
				if (location.distanceTo(destination) > location.distanceTo(x, y)) {
					destination.setXY(x,y);
				}
				else if (location.distanceTo(destination) == location.distanceTo(x, y)) {
					if (destination.getY() > y) {
						destination.setXY(x, y);
					}
				}
			}
		}
		
		if (--d>0) {
			if (0<=x-1) {
				if (!v[x-1][y]) search(location, destination, map, x-1, y, d, v);
			}
			if (0<=y-1) {
				if (!v[x][y-1]) search(location, destination, map, x, y-1, d, v);
			}
			if (y+1<map[0].length) {
				if (!v[x][y+1]) search(location, destination, map, x, y+1, d, v);
			}
		}
	}
}