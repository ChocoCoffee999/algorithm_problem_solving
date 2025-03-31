package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA3124 {
	static class Edge implements Comparable<Edge> {
		int f, t, w;

		Edge(int f, int t, int w) {
			this.f = f;
			this.t = t;
			this.w = w;
		}

		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.w, o.w);
		}
	}

	static Edge[] edgeList;
	static int[] parents;
	static int V, E;

	static void make() {
		parents = new int[V + 1];
		for (int i = 1; i <= V; i++) {
			parents[i] = i;
		}
	}

	static int find(int x) {
		if (x == parents[x])
			return x;
		return parents[x] = find(parents[x]);
	}

	static boolean union(int x, int y) {
		int xRoot = find(x);
		int yRoot = find(y);

		if (xRoot == yRoot)
			return false;
		parents[yRoot] = xRoot;
		return true;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(st.nextToken());

		for (int test_case = 1; test_case <= T; test_case++) {
			st = new StringTokenizer(br.readLine());
			sb.append("#" + test_case + " ");
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());

			edgeList = new Edge[E];
			make();
			for (int i = 0; i < E; i++) {
				st = new StringTokenizer(br.readLine());
				edgeList[i] = new Edge(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
						Integer.parseInt(st.nextToken()));
			}

			Arrays.sort(edgeList);
			long result = 0, count = 0;
			for (Edge e : edgeList) {
				if (union(e.f, e.t)) {
					result += e.w;
					if (++count == V - 1)
						break;
				}
			}
			sb.append(result + "\n");
		}
		System.out.print(sb.toString());
	}
}