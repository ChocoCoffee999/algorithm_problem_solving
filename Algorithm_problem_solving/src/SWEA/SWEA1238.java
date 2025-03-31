package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA1238 {
	static List<Integer>[] list;
	static int[] depth;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		for (int test_case = 1; test_case <= 10; test_case++) {
			sb.append("#" + test_case + " ");
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int target = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			list = new List[101];
			while (st.hasMoreTokens()) {
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				if (list[from] == null) {
					list[from] = new ArrayList<>();
				}
				if (list[to] == null)
					list[to] = new ArrayList<>();
				list[from].add(to);
			}

			depth = new int[101];
			bfs(new boolean[101], target);
			int maxD = Integer.MIN_VALUE;
			int maxN = -1;
			for (int i = 1; i <= 100; i++) {
				if (depth[i] == 0)
					continue;
				if (maxD < depth[i]) {
					maxD = depth[i];
					maxN = i;
				} else if (maxD == depth[i] && maxN < i) {
					maxN = i;
				}
			}

			sb.append(maxN).append("\n");
		}
		System.out.print(sb.toString());
	}

	public static void bfs(boolean[] v, int s) {
		Queue<Integer> que = new ArrayDeque<>();
		v[s] = true;
		depth[s] = 0;
		que.add(s);

		while (!que.isEmpty()) {
			int cur = que.poll();
			for (int next : list[cur]) {
				if (v[next])
					continue;
				v[next] = true;
				depth[next] = depth[cur] + 1;
				que.add(next);
			}
		}
	}
}
