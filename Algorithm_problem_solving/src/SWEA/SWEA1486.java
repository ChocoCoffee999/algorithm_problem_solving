package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA1486 {
	static int[] talls;
	static int N, B;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(st.nextToken());
		
		for (int test_case=1;test_case<=T;test_case++) {
			st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			talls = new int[N];
			for (int i=0;i<N;i++) {
				talls[i] = Integer.parseInt(st.nextToken());
			}
			int s;
			int Ans=Integer.MAX_VALUE;
			for (int i=1;i<1<<N;i++) {
				s=0;
				for (int j=0;j<N;j++) {
					if ((i&1<<j)!=0) {
						s+=talls[j];
					}
				}
				if (s>=B) Ans = Math.min(Ans, s);
			}
//			int ans = bfs();
			
			sb.append("#").append(test_case).append(" ").append(Ans-B).append("\n");
		}
		System.out.print(sb);
	}
	
	public static int bfs() {
		Queue<Node> que = new ArrayDeque<>();
		que.add(new Node(0,0));
		int ans = Integer.MAX_VALUE;
		while (que.size()>0) {
			Node node = que.poll();
			if (node.idx == N) {
				int s = 0;
				for (int i=0;i<N;i++) {
					if ((node.bitmask&1<<i)!=0) {
						s+=talls[i];
					}
					if (s>=B) ans = Math.min(ans, s);
				}
				continue;
			}
			que.offer(new Node(node.idx+1, node.bitmask|1<<node.idx));
			que.offer(new Node(node.idx+1, node.bitmask));
		}
		
		return ans;
	}
	
	static class Node {
		int idx;
		int bitmask;
		
		Node(int idx, int bitmask) {
			this.idx = idx;
			this.bitmask = bitmask;
		}
	}
}
