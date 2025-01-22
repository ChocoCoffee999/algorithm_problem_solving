package Baekjoon;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Baekjoon17136 {
	static int minPaper = 100;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[][] map = new int[10][10];
		for (int i=0;i<10;i++) {
			String[] input = br.readLine().trim().split(" ");
			for (int j=0;j<10;j++) {
				map[i][j] = Integer.parseInt(input[j]);
			}
		}
		int[] coloredPaperNum = new int[5];
		int minPapers=0;
		paste(map, coloredPaperNum, 0,0,minPapers);
		if (minPaper!=100) System.out.println(minPaper);
		else System.out.println(-1);
		
	}
	
	public static void paste(int[][] map, int[] papers, int x, int y, int minPapers){
		if (map[x][y]==1) {
			for (int i = 0;i<5;i++) {
				boolean f = false;
				if(x+i<10&&y+i<10) {
					for (int j = 0;j<=i;j++) {
						for (int k = 0;k<=i;k++) {
							if (map[x+j][y+k] != 1) {
								f = true;
								break;
							}
							if (j==i&&k==i) {
								
								if (++papers[i]>5) {
									papers[i]--;
									break;
								}
								for (int l= 0;l<=i;l++) {
									for (int m = 0;m<=i;m++) {
										map[x+l][y+m] = 0;
									}
								}
								if (y+1<10) {
									paste(map, papers,x, y+1, minPapers);
								}
								else if(x+1<10) {
									paste(map, papers, x+1, 0, minPapers);
								}
								else {
	//								int paper = papers[0]+papers[1]+papers[2]+papers[3]+papers[4];
	//								if (minPapers > paper) minPapers = paper;
	//								System.out.println(paper);
									
									for (int vx = 0;vx<10;vx++) {
										boolean vf = false;
										for (int vy = 0; vy<10;vy++) {
											if (map[vx][vy]==1) {
												vf = true;
												break;
											}
											if (vx==9&&vy==9) {
//												System.out.println("A"+papers[0]+papers[1]+papers[2]+papers[3]+papers[4]);
												int paper = papers[0]+papers[1]+papers[2]+papers[3]+papers[4];
												if (paper!=0&& minPaper >paper) minPaper=paper;
											}
											
										}
										if (vf) {
//											System.out.println(-1);
											break;
										}
									}
								}
								for (int l= 0;l<=i;l++) {
									for (int m = 0;m<=i;m++) {
										map[x+l][y+m] = 1;
									}
								}
								papers[i]--;
								
							}
						}
						if (f) break;
					}
					if (f) break;
				}
			}
		}
		else {
			if (x==9&&y==9) {
				for (int vx = 0;vx<10;vx++) {
					boolean vf = false;
					for (int vy = 0; vy<10;vy++) {
						if (map[vx][vy]==1) {
							vf = true;
							break;
						}
						
						if (vx==9&&vy==9) {
//							System.out.println("B"+papers[0]+papers[1]+papers[2]+papers[3]+papers[4]);
							int paper = papers[0]+papers[1]+papers[2]+papers[3]+papers[4];
							if (paper!=0) {
								if (minPaper >paper) minPaper=paper;
							}
							else minPaper = 0;
						
						}
					}
					if (vf) {
//						System.out.println(-1);
						break;
					}
				}
				
			}
			if (y+1<10) {
				paste(map, papers,x, y+1, minPapers);
			}
			else if(x+1<10) {
				paste(map, papers, x+1, 0, minPapers);
			}
		}
	}
}
