package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA5644 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(st.nextToken());
		
		for(int test_case=1; test_case<=T; test_case++) {
			st = new StringTokenizer(br.readLine());
			int M = Integer.parseInt(st.nextToken());
			int A = Integer.parseInt(st.nextToken());
			
			int[] moveA = new int[M];
			int[] moveB = new int[M];
			User userA = new User(1,1);
			User userB = new User(10,10);
			Charger[] charger = new Charger[A];
			
			st = new StringTokenizer(br.readLine());
			for (int i=0; i<M; i++) {
				moveA[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for (int i=0; i<M; i++) {
				moveB[i] = Integer.parseInt(st.nextToken());
			}
			
			for (int i=0; i<A; i++) {
				st = new StringTokenizer(br.readLine());
				charger[i] = new Charger(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
			}
			
			Arrays.sort(charger, (c1, c2) -> Integer.compare(c2.p, c1.p));
			
			int Ans = 0;
			int maxP = 0;
			Charger selA=null;
			Charger selB=null;
			for (int i=0; i<A; i++) {
				for (int j=0; j<A; j++) {
					selA=null;
					selB=null;
					if (userA.checkDist(charger[i], charger[i].l)) {
						selA = charger[i];
					}
					if (userB.checkDist(charger[j], charger[j].l)) {
						selB = charger[j];
					}
					if (selA!=null&&selB!=null&&selA==selB) {
						maxP = Math.max(maxP, selA.p);
						continue;
					}
					int sum = 0;
					if (selA!=null) sum+=selA.p;
					if (selB!=null) sum+=selB.p;
					maxP = Math.max(sum, maxP);
				}
			}
			Ans+=maxP;
			for (int step=0; step<M; step++) {
				maxP = 0;
				userA.move(moveA[step]);
				userB.move(moveB[step]);
				for (int i=0; i<A; i++) {
					for (int j=0; j<A; j++) {
						selA=null;
						selB=null;
						if (userA.checkDist(charger[i], charger[i].l)) {
							selA = charger[i];
						}
						if (userB.checkDist(charger[j], charger[j].l)) {
							selB = charger[j];
						}
						if (selA!=null&&selB!=null&&selA==selB) {
							maxP = Math.max(maxP, selA.p);
							continue;
						}
						int sum = 0;
						if (selA!=null) sum+=selA.p;
						if (selB!=null) sum+=selB.p;
						maxP = Math.max(sum, maxP);
					}
				}
				Ans+=maxP;
			}
			sb.append("#"+test_case+" "+(Ans)+"\n");
		}
		System.out.print(sb.toString());
	}
	static class Pos {
		int x;
		int y;
		
		Pos(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
		public boolean checkDist(Pos o, int dist) {
			if (Math.abs(this.x-o.x)+Math.abs(this.y-o.y)<=dist) return true;
			else return false;
		}
	}
	
	static int[] dr = {0,-1,0,1,0};
	static int[] dc = {0,0,1,0,-1};
	
	static class User extends Pos{
		int e=0;
		
		User(int x, int y) {
			super(x, y);
			
		}
		public void move(int d) {
			this.x+=dc[d];
			this.y+=dr[d];
		}
	}
	
	static class Charger extends Pos{
		int l;
		int p;
		
		Charger(int x, int y, int l, int p) {
			super(x, y);
			this.l = l;
			this.p = p;
		}
	}
}
