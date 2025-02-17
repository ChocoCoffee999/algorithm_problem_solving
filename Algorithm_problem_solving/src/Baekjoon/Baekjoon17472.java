package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;
/*
 * 1. 지역구분 bfs;
 * 2. 지역간 거리 bfs;
 * 3. 거리중 가장 짧은 것 구하기 dfs;
 */
public class Baekjoon17472 {
	static int[] dr = {0,0,1,-1};
	static int[] dc = {1,-1,0,0};
	static int[][] map;
	static int[][] dis;
	static int N;
	static int M;
	static BufferedReader br;
	
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().trim().split(" ");
		
		N = Integer.parseInt(input[0]);
		M = Integer.parseInt(input[1]);
		
		map = new int[N][M];
		
		for (int i=0;i<N;i++) {
			input = br.readLine().trim().split(" ");
			for (int j=0;j<M;j++) {
				map[i][j] = Integer.parseInt(input[j]);
			}
		}
		
		int count = islandCount();
		dis = new int[count+1][count+1];
		for (int i=0;i<=count;i++) {
			for (int j=0;j<=count;j++) dis[i][j] = Integer.MAX_VALUE;
		}
		
//		for (int i=0;i<N;i++) {
//			for (int j=0;j<M;j++) {
//				System.out.print(map[i][j]);
//			}
//			System.out.println();
//		}
		
		calBridgeLen();
		
		for (int i=1;i<=count;i++) {
			for (int j=1;j<=count;j++) {
				System.out.print(dis[i][j]);
				System.out.print(" ");
			}
			System.out.println();
		}
		
		boolean[] visit = new boolean[count+1];
		int[] dist = new int[count+1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		
		dist[1] = 0;
		
		for (int step=0;step<count-1;step++) {
			int minIdx = -1;
			int minD = Integer.MAX_VALUE;
			for (int i=1;i<dist.length;i++) {
				if (dist[i] < minD && !visit[i]) {
					minIdx = i;
					minD = dist[i];
				}
			}
			if (minIdx == -1) break;
			visit[minIdx] =true;
			
			for (int i=1;i<visit.length;i++) {
				if (dis[minIdx][i] != 0 && !visit[i] && dis[minIdx][i]<dist[i]) {
					dist[i] = dis[minIdx][i];
				}
			}
		}
		
		int sum = 0;
		for (int i=1;i<dist.length;i++) {
			if (dist[i]==Integer.MAX_VALUE) {
				System.out.println(-1);
				break;
			}
			sum +=dist[i];
			
			if(i==dist.length-1) System.out.println(sum); 
		}
	}
	
	static class Pos17472 {
		int r;
		int c;
		int type;
		int dis;
		
		Pos17472(int r, int c) {
			this.r = r;
			this.c = c;
		}
		
		Pos17472(int r, int c, int type, int dis) {
			this.r = r;
			this.c = c;
			this.type = type;
			this.dis = dis;
		}
	}
	
	static int islandCount() {
		Queue<Pos17472> que = new ArrayDeque<>();
		boolean[][] visit = new boolean[N][M];
		int count=0;
		for (int i=0;i<N;i++) {
			for (int j=0;j<M;j++) {
				if (map[i][j]==1&&!visit[i][j]) {
					count++;
					map[i][j]=count;
					visit[i][j] = true;
					que.offer(new Pos17472(i,j));
					
					while (que.size()>0) {
						Pos17472 curPos = que.poll();
						for (int k=0;k<4;k++) {
							if (curPos.r+dr[k]>=0&&curPos.r+dr[k]<N&&curPos.c+dc[k]>=0&&curPos.c+dc[k]<M) {
								if (map[curPos.r+dr[k]][curPos.c+dc[k]]==1&&!visit[curPos.r+dr[k]][curPos.c+dc[k]]) {
									map[curPos.r+dr[k]][curPos.c+dc[k]] = count;
									visit[curPos.r+dr[k]][curPos.c+dc[k]] = true;
									que.add(new Pos17472(curPos.r+dr[k], curPos.c+dc[k]));
								}
							}
						}
					}
				}
			}
		}
		return count;
	}
	
	static void calBridgeLen() {
		Queue<Pos17472> que = new ArrayDeque<>();
		for (int i=0;i<N;i++) {
			for (int j=0;j<M;j++) {
				System.out.printf("i: %d, j: %d, map: %d\n", i, j, map[i][j]);
				if (map[i][j]!=0) {
					for (int k=0;k<4;k++) {
						if (i+dr[k]>=0&&i+dr[k]<N&&j+dc[k]>=0&&j+dc[k]<M) {
							System.out.printf("k: %d\n", k);
							if (map[i+dr[k]][j+dc[k]]==0) {
								System.out.printf("k: %d\n", k);
								que.offer(new Pos17472(i+dr[k],j+dc[k],k,1));
							}
						}
					}

					while(que.size()>0) {
						Pos17472 curPos = que.poll();
//						System.out.printf("%d %d : %d %d %d\n", i, j, curPos.r, curPos.c, curPos.type);
						if (curPos.r+dr[curPos.type]>=0&&curPos.r+dr[curPos.type]<N&&
								curPos.c+dc[curPos.type]>=0&&curPos.c+dc[curPos.type]<M) {
							if (map[curPos.r+dr[curPos.type]][curPos.c+dc[curPos.type]]==0) {
								que.offer(new Pos17472(curPos.r+dr[curPos.type],curPos.c+dc[curPos.type],
										curPos.type, curPos.dis+1));
							}
							else if (map[curPos.r+dr[curPos.type]][curPos.c+dc[curPos.type]]!=map[i][j]&&
									map[curPos.r+dr[curPos.type]][curPos.c+dc[curPos.type]]>0) {
								System.out.printf("%d %d %d\n", map[i][j], map[curPos.r+dr[curPos.type]][curPos.c+dc[curPos.type]], curPos.dis);
								if (curPos.dis>=2) {
									dis[map[i][j]][map[curPos.r+dr[curPos.type]][curPos.c+dc[curPos.type]]] =
											Math.min(dis[map[i][j]][map[curPos.r+dr[curPos.type]][curPos.c+dc[curPos.type]]], curPos.dis);
								}
							}
						}
//						br.readLine();
					}
//					System.out.printf("%d %d-------------\n", i, j);
				}
			}
		}
	}
}