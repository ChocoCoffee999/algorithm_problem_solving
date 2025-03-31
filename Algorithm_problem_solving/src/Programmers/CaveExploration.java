package Programmers;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

public class CaveExploration {
	static int[][] paths = { { 0, 1 }, { 0, 3 }, { 0, 7 }, { 8, 1 }, { 3, 6 }, { 1, 2 }, { 4, 7 }, { 7, 5 } };
	static int[][] orders = { { 4, 1 }, { 8, 5 }, { 6, 7 } };
	static int N = 9;

	public static void main(String[] args) {
		boolean[] visit = new boolean[N];
		List<Integer>[] list = new List[N];

		for (int i = 0; i < N; i++) {
			list[i] = new ArrayList<>();
		}
		for (int[] path : paths) {
			list[path[0]].add(path[1]);
			list[path[1]].add(path[0]);
		}
		int[] keyUnlock = new int[N];
		Arrays.fill(keyUnlock, -1);
		boolean[] locked = new boolean[N];

		for (int[] order : orders) {
			keyUnlock[order[0]] = order[1];
			locked[order[1]] = true;
		}
		Integer[] waiting = new Integer[N];
		Queue<Integer> que = new ArrayDeque<>();

		que.offer(0);
		if (locked[0])
			;
		else {
			visit[0] = true;

			while (!que.isEmpty()) {
				int cur = que.poll();
				int unlock = keyUnlock[cur];

				if (unlock != -1) {
					locked[unlock] = false;
					if (waiting[unlock] != null) {
						que.offer(unlock);
						waiting[unlock] = null;
					}
				}
				for (int next : list[cur]) {
					if (!visit[next]) {
						visit[next] = true;
						if (locked[next]) {
							waiting[next] = next;
						} else {
							que.offer(next);
						}
					}
				}
			}

			boolean f = true;
			for (boolean v : visit) {
				if (!v) {
					f = false;
					break;
				}
			}
//			return f;
		}
	}
}