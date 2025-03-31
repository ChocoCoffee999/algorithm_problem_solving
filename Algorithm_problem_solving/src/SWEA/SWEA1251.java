package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA1251 {
	static class Edge implements Comparable<Edge> {
		int f, t;
		double w;

		public Edge(int f, int t, double w) {
			super();
			this.f = f;
			this.t = t;
			this.w = w;
		}

		@Override
		public int compareTo(Edge o) {
			return Double.compare(this.w, o.w);
		}
	}

	static Edge[] edgeList;
	static int[] parent;
	static int[] X;
	static int[] Y;
	static int V, E;
	static double D;

	public static void make() {
		edgeList = new Edge[E];
		parent = new int[V];
		X = new int[V];
		Y = new int[V];
		for (int i = 0; i < V; i++) {
			parent[i] = i;
		}
	}

	public static int find(int x) {
		if (x == parent[x])
			return x;
		return parent[x] = find(parent[x]);
	}

	public static boolean union(int x, int y) {
		int xRoot = find(x);
		int yRoot = find(y);

		if (yRoot == xRoot)
			return false;

		parent[yRoot] = xRoot;
		return true;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(st.nextToken());

		for (int test_case = 1; test_case <= T; test_case++) {
			sb.append("#" + test_case + " ");
			st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken());
			E = V * (V - 1) / 2;
			make();
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < V; i++) {
				X[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < V; i++) {
				Y[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			D = Double.parseDouble(st.nextToken());

			int count = 0;
			for (int i = 0; i < V - 1; i++) {
				for (int j = i + 1; j < V; j++) {
					edgeList[count++] = new Edge(i, j, (Math.pow(X[i] - X[j], 2) + Math.pow(Y[i] - Y[j], 2)) * D);
				}
			}

			Arrays.sort(edgeList);

			double sum = 0.0d;
			count = 0;
			for (Edge e : edgeList) {

				if (union(e.f, e.t)) {
					sum += e.w;
					if (++count == V - 1)
						break;
				}
			}

			sb.append(Math.round(sum)).append("\n");
		}
		System.out.print(sb.toString());
	}
}
