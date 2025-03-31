package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon2042 {
	static int N;
	static int M;
	static int K;
	static int H;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		DynamicSegmentTree segTree = new DynamicSegmentTree(1, N);

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			long n = Long.parseLong(st.nextToken());
			segTree.update(i, n);
		}

		for (int i = 0; i < M + K; i++) {
			st = new StringTokenizer(br.readLine());
			int command = Integer.parseInt(st.nextToken());
			switch (command) {
			case 1: {
				long idx = Long.parseLong(st.nextToken());
				long num = Long.parseLong(st.nextToken());
				segTree.update(idx, num);
				break;

			}
			case 2: {
				long start = Long.parseLong(st.nextToken());
				long end = Long.parseLong(st.nextToken());
				System.out.println(segTree.query(start, end));
				break;
			}
			default:
				break;

			}
		}
	}

	static class DynamicSegmentTree {
		Node root;
		long start;
		long end;

		class Node {
			Node left;
			Node right;
			long data;
		}

		DynamicSegmentTree(long start, long end) {
			this.start = start;
			this.end = end;
			root = new Node();
		}

		public void update(long idx, long data) {
			update(root, this.start, this.end, idx, data);
		}

		public void update(Node node, long start, long end, long idx, long data) {
			if (start == end) {
				node.data = data;
				return;
			}

			long mid = start + (end - start) / 2;
			if (idx <= mid) {
				if (node.left == null) {
					node.left = new Node();
				}

				update(node.left, start, mid, idx, data);
			} else {
				if (node.right == null) {
					node.right = new Node();
				}

				update(node.right, mid + 1, end, idx, data);
			}

			long leftSum = (node.left != null) ? node.left.data : 0;
			long rightSum = (node.right != null) ? node.right.data : 0;
			node.data = leftSum + rightSum;
		}

		public long query(long l, long r) {
			return query(root, start, end, l, r);
		}

		public long query(Node node, long start, long end, long l, long r) {
			if (node == null || r < start || end < l)
				return 0;
			if (l <= start && end <= r)
				return node.data;
			long mid = start + (end - start) / 2;
			long leftSum = query(node.left, start, mid, l, r);
			long rightSum = query(node.right, mid + 1, end, l, r);
			return leftSum + rightSum;
		}
	}
}
