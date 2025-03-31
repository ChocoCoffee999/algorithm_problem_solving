package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Baekjoon1753 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int V = Integer.parseInt(st.nextToken());  
		int E = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(br.readLine().trim())-1;
		
		HashMap<Integer, Integer>[] edge = new HashMap[V];
		for (int i=0; i<V; i++) {
			edge[i] = new HashMap<>();
		}
		for (int i=0; i<E; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken())-1;
			int e = Integer.parseInt(st.nextToken())-1;
			int w = Integer.parseInt(st.nextToken());
			
			if (edge[s].containsKey(e)) {
				edge[s].put(e, Math.min(edge[s].get(e), w));
			}
			else edge[s].put(e, w);
		}
		
		PriorityQueue<Vertex> que = new PriorityQueue<>();
		int[] dist = new int[V];
		boolean[] v = new boolean[V];
		Arrays.fill(dist, Integer.MAX_VALUE);
		
		que.offer(new Vertex(S,0));
		dist[S] = 0;
		
		while (!que.isEmpty()) {
			Vertex p = que.poll();
			
			int minV = p.e;
			
			if (v[minV]) continue;
			
			v[minV] = true;
			
			for (Map.Entry<Integer, Integer> entry : edge[minV].entrySet()) {
				if (!v[entry.getKey()]&&dist[minV]+entry.getValue()<dist[entry.getKey()]) {
					dist[entry.getKey()] = dist[minV]+entry.getValue();
					que.offer(new Vertex(entry.getKey(), dist[entry.getKey()]));
				}
			}
		}
		for (int n:dist) {
			if (n==Integer.MAX_VALUE) sb.append("INF").append("\n");
			else sb.append(n).append("\n");
		}
		System.out.print(sb);
	}
	
	static class Vertex implements Comparable<Vertex> {
		public int e;
		public int w;
		
		Vertex(int e, int w) {
			this.e = e;
			this.w = w;
		}
		
		@Override
		public int compareTo(Vertex o) {
			return Integer.compare(this.w,  o.w);
		}
		
	}
}
