package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA3421 {
	static int N;
	static int M;
	static boolean[][] map;
	static int ans;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		
		for (int test_case=1;test_case<=T;test_case++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			map = new boolean[N][N];
			ans = 0;
			for (int i=0;i<M;i++) {
				st = new StringTokenizer(br.readLine());
				int i1 = Integer.parseInt(st.nextToken())-1;
				int i2 = Integer.parseInt(st.nextToken())-1;
				
				map[i1][i2]=true;
				map[i2][i1]=true;
			}
			powerSet(0, new boolean[N]);
			System.out.printf("#%d %d\n", test_case, ans);
		}

	}
	
	public static void powerSet(int idx, boolean[] v) {
		if (idx==N) {
//			System.out.println(Arrays.toString(v));
			int count =0;
			for (int i=0;i<v.length;i++) {
				if (v[i]) count++;
			}
			int[] ingredient = new int[count];
			count = 0;
			for (int i=0;i<v.length;i++) {
				if (v[i]) {
					ingredient[count] = i;
					count++;
				}
			}
			for (int i=0;i<ingredient.length-1;i++) {
				for (int j=i+1;j<ingredient.length;j++) {
					if (map[ingredient[i]][ingredient[j]]) return;
				}
			}
			ans++;
			return;
		}
		v[idx]=true;
		powerSet(idx+1,v);
		v[idx]=false;
		powerSet(idx+1,v);
	}

}
