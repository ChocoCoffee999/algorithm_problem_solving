package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon16935 {
	static int N;
	static int M;
	static int[][] mapD;
	static int[][] mapR;
	
	static boolean r = false;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		
		mapD = new int[N][M];
		mapR = new int[M][N];
		for (int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<M; j++) {
				mapD[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		st = new StringTokenizer(br.readLine());
		for (int i=0;i<R;i++) {
			switch (Integer.parseInt(st.nextToken())) {
			case 1: {
				verticalFlip();
				break;
			}
			case 2: {
				horizontalFlip();
				break;
			}
			case 3: {
				rightRotate();
				break;
			}
			case 4: {
				leftRotate();
				break;
			}
			case 5: {
				rightRotateSection();
				break;
			}
			case 6: {
				leftRotateSection();
				break;
			}
			default:
				break;
			}
		}
		
		int[][] map = selMap();

		int I = r ? M:N;
		int J = r ? N:M;
		for (int i=0;i<I;i++) {
			for (int j=0;j<J;j++) sb.append(map[i][j]).append(" ");
			sb.append("\n");
		}
		System.out.print(sb.toString());

	}
	public static int[][] selMap() {
		if (r) return mapR;
		else return mapD;
	}
	
	public static int[][] rotMap() {
		if (r) return mapD;
		else return mapR;
	}
	
	public static void verticalFlip() {
		int n = r ? M/2:N/2;
		int R = r ? M:N;
		int C = r ? N:M;
		int[][] map = selMap();
		for (int i=0;i<n;i++) {
			for (int j=0;j<C;j++) {
				int tmp = map[i][j];
				map[i][j] = map[R-1-i][j];
				map[R-1-i][j] = tmp;
			}
		}
	}
	
	public static void horizontalFlip() {
		int n = r ? N/2:M/2;
		int R = r ? M:N;
		int C = r ? N:M;
		int[][] map = selMap();
		for (int i=0;i<n;i++) {
			for (int j=0;j<R;j++) {
				int tmp = map[j][i];
				map[j][i] = map[j][C-1-i];
				map[j][C-1-i] = tmp;
			}
		}
	}
	
	public static void rightRotate() {
		int R = r ? M:N;
		int C = r ? N:M;
		int[][] map = selMap();
		int[][] rMap = rotMap();
		for (int i=0; i<R; i++) {
			for (int j=0; j<C; j++) {
				rMap[j][R-1-i] = map[i][j];
			}
		}
		r = !r;
	}
	
	public static void leftRotate() {
		int R = r ? M:N;
		int C = r ? N:M;
		int[][] map = selMap();
		int[][] rMap = rotMap();
		
		for (int i=0; i<R; i++) {
			for (int j=0; j<C; j++) {
				rMap[C-1-j][i] = map[i][j];
			}
		}
		r = !r;
	}
	
	public static void rightRotateSection() {
		int R = r ? M:N;
		int C = r ? N:M;
		int r = R/2;
		int c = C/2;

		int[][] map = selMap();
		int tmp;
		for (int i=0;i<r;i++) {
			for (int j=0;j<c;j++) {
				tmp = map[i][j];
				map[i][j] = map[i+r][j];
				map[i+r][j] = tmp;
			}
		}
		for (int i=r;i<R;i++) {
			for (int j=0;j<c;j++) {
				tmp = map[i][j];
				map[i][j] = map[i][j+c];
				map[i][j+c] = tmp;
			}
		}
		for (int i=r;i<R;i++) {
			for (int j=c;j<C;j++) {
				tmp = map[i][j];
				map[i][j] = map[i-r][j];
				map[i-r][j] = tmp;
			}
		}
	}
	
	public static void leftRotateSection() {
		int R = r ? M:N;
		int C = r ? N:M;
		int r = R/2;
		int c = C/2;

		int[][] map = selMap();
		int tmp;
		for (int i=0;i<r;i++) {
			for (int j=0;j<c;j++) {
				tmp = map[i][j];
				map[i][j] = map[i][j+c];
				map[i][j+c] = tmp;
			}
		}
		for (int i=0;i<r;i++) {
			for (int j=c;j<C;j++) {
				tmp = map[i][j];
				map[i][j] = map[i+r][j];
				map[i+r][j] = tmp;
			}
		}
		for (int i=r;i<R;i++) {
			for (int j=c;j<C;j++) {
				tmp = map[i][j];
				map[i][j] = map[i][j-c];
				map[i][j-c] = tmp;
			}
		}
	}
}
