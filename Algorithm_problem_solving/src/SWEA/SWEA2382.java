package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class SWEA2382 {
	static int N, M, K;

	public static void main(String[] args) throws Exception {
		System.setIn(new java.io.FileInputStream(
				"C:\\Users\\SSAFY\\git\\algorithm_problem_solving\\Algorithm_problem_solving\\src\\SWEA\\sample_input\\SWEA2382_sample_input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(st.nextToken());

		for (int test_case = 1; test_case <= T; test_case++) {
			st = new StringTokenizer(br.readLine());

			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());

			List<Node> nodes = new LinkedList<>();
			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				nodes.add(new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
						Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()) - 1));
			}

			for (int i = 0; i < M; i++) {
				move(nodes);
				check(nodes);
			}
			int sum = 0;
			for (Node n : nodes) {
				sum += n.n;
			}
			System.out.printf("#%d %d\n", test_case, sum);
		}
	}

	public static void move(List<Node> nodes) {
		Iterator<Node> it = nodes.iterator();
		while (it.hasNext()) {
			Node n = it.next();
			n.move();
			if (n.n == 0)
				it.remove();
		}
	}

	public static void check(List<Node> nodes) {
		Iterator<Node> it = nodes.iterator();
		while (it.hasNext()) {
			Node n = it.next();
			Node w = new Node(0, 0, 0, 0);
			for (Node n2 : nodes) {
				if (n.r == n2.r && n.c == n2.c) {
					if (n.n < n2.n) {
						if (w.n < n2.n)
							w = n2;
					}
				}
			}
			if (w.n != 0) {
				w.n += n.n;
				it.remove();
			}
		}
	}

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	static class Node implements Comparable<Node> {
		int r, c, n, k;

		Node(int r, int c, int n, int k) {
			this.r = r;
			this.c = c;
			this.n = n;
			this.k = k;
		}

		@Override
		public int compareTo(Node o) {
			if (this.r == o.r) {
				if (this.c == o.c) {
					return Integer.compare(this.n, o.n);
				} else
					return Integer.compare(this.c, o.c);
			} else
				return Integer.compare(this.r, o.r);
		}

		public void move() {
			r = r + dr[k];
			c = c + dc[k];
			if (r == 0 || r == N - 1) {
				this.n = n / 2;
				if (k == 0)
					k = 1;
				else
					k = 0;
			}

			if (c == 0 || c == N - 1) {
				this.n = n / 2;
				if (k == 2)
					k = 3;
				else
					k = 2;
			}
		}

		public boolean check(Node o) {
			return (this.r == o.r && this.c == o.c);
		}
	}
}
