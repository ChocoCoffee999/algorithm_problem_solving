package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA2383 {
	static class User {
		int r, c, t;

		User(int r, int c) {
			this.r = r;
			this.c = c;
			this.t = 0;
		}

		public boolean move(int r, int c, int t) {
			if (this.r != r) {
				this.r -= (this.r - r) / Math.abs(this.r - r);
				return false;
			}
			if (this.c != c) {
				this.c -= (this.c - c) / Math.abs(this.c - c);
				return false;
			}
			if (this.t == t)
				return true;
			else {
				this.t++;
				return false;
			}
		}
	}

	static int sCount, uCount, N, s1, s2;
	static int[][] user, stair;
	static User[] users;
	static boolean[] end;
	static int ans;
	static boolean[] down1;
	static boolean[] down2;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		user = new int[10][2];
		stair = new int[2][3];
		users = new User[10];
		end = new boolean[10];
		down1 = new boolean[10];
		down2 = new boolean[10];
		s1 = 0;
		s2 = 0;
		int n;

		int T = Integer.parseInt(st.nextToken());

		for (int test_case = 1; test_case <= T; test_case++) {
			st = new StringTokenizer(br.readLine());

			N = Integer.parseInt(st.nextToken());
			sCount = 0;
			uCount = 0;
			ans = Integer.MAX_VALUE;

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					n = Integer.parseInt(st.nextToken());
					if (n == 1) {
						user[uCount][0] = i;
						user[uCount][1] = j;
						uCount++;
					} else if (n != 0) {
						stair[sCount][0] = i;
						stair[sCount][1] = j;
						stair[sCount][2] = n;
						sCount++;
					}
				}
			}

			combination(0, new boolean[uCount]);

			System.out.println(ans);
		}
	}

	public static void combination(int idx, boolean[] v) {
		if (idx == uCount) {
			int time = 0;
			Arrays.fill(end, false);
			for (int i = 0; i < uCount; i++) {
				users[i] = new User(user[i][0], user[i][1]);
			}
			System.out.println("v : " + Arrays.toString(v));

			do {
				time++;
				for (int i = 0; i < uCount; i++) {
					if (!end[i]) {
						if (v[i]) {
							if (s1 < 3) {
								if (!down1[i]) {
									s1++;
									down1[i] = true;
								}
								end[i] = users[i].move(stair[0][0], stair[0][1], stair[0][2]);
								if (end[i]) {
									s1--;
									down1[i] = false;
								}
							}
						} else {
							if (s2 < 3) {
								if (!down2[i]) {
									s2++;
									down2[i] = true;
								}
								if (end[i]) {
									s2--;
									down2[i] = false;
								}
							}
							if (down2[i])
								end[i] = users[i].move(stair[1][0], stair[1][1], stair[1][2]);
						}
						System.out.print(end[i] + " ");
					}
				}
				System.out.println();
			} while (check());
			System.out.println(time);
			ans = Math.min(ans, time);
			return;
		}

		v[idx] = true;
		combination(idx + 1, v);
		v[idx] = false;
		combination(idx + 1, v);
	}

	public static boolean check() {
		for (int i = 0; i < uCount; i++) {
			if (!end[i])
				return true;
		}
		return false;
	}
}
