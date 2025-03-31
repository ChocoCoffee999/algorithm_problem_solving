package Programmers;

import java.util.Arrays;

public class TravelRoute {
	static String[][] tickets = {{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}};
//	static String[][] tickets = {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL","SFO"}};
	static String[] sel = new String[tickets.length+1];
	static String[] ans = new String[tickets.length+1];
	static String path=null;
	static boolean[] visit = new boolean[tickets.length];
	public static void main(String[] args) {
		for (int i=0;i<tickets.length;i++) {
			if (tickets[i][0].equals("ICN")) {
				sel[0] = "ICN";
				visit[i] = true;
				dfs(i, 1);
				visit[i] = false;
			}
		}
		System.out.println(Arrays.toString(ans));
	}
	
	public static void dfs(int node, int count) {
		for (int i=0;i<visit.length;i++) {
			if (!visit[i]) break;
			if (i==visit.length-1) {
				sel[count] = tickets[node][1];
				if (path==null) {
					path = Arrays.toString(sel);
					ans = Arrays.copyOf(sel, sel.length);
				}
				else {
					String curPath = Arrays.toString(sel);
					int com = path.compareTo(curPath);
					if (com>0) path=curPath;
					ans = Arrays.copyOf(sel, sel.length);
				}
				return;
			}
		}
		
		for (int i=0;i<tickets.length;i++) {
			if (visit[i]) continue;
			if (tickets[node][1].equals(tickets[i][0])) {
				sel[count] = tickets[i][0];
				visit[i] = true;
				dfs(i, count+1);
				visit[i] = false;
			}
		}
		
		return;
	}
}
