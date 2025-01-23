package Baekjoon;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Baekjoon2563_fail {
	public static int factorial(int n) {
		if (n==1) return 1;
		return n*factorial(n-1);
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine().trim());
		List<int[]> list = new ArrayList<int[]>();
//		int[][] paper = new int[n][2];
		
		for (int i=0;i<n;i++) {
			String[] input = br.readLine().trim().split(" ");
			list.add(new int[] {Integer.parseInt(input[0]),Integer.parseInt(input[1]),10,10});
//			paper[i][0] = Integer.parseInt(input[0]);
//			paper[i][1] = Integer.parseInt(input[1]);
		}
		
//		List<int[]> list = new ArrayList<int[]>();
		
//		for (int i=0;i<n-1;i++) {
//			for (int j=i+1;j<n;j++) {
//				Integer x = null;
//				Integer y = null;
//				if (paper[i][0]>paper[j][0]) if(paper[i][0]<paper[j][0]+10) x=paper[i][0];
//				else if (paper[i][0]<paper[j][0]) if(paper[i][0]+10>paper[j][0]) x=paper[j][0];
//				else x=paper[i][0];
//				if (paper[i][1]>paper[j][1]) if (paper[i][1]<paper[j][1]+10) y=paper[i][1];
//				else if (paper[i][1]<paper[j][1]) if (paper[i][1]+10>paper[j][1]) y=paper[j][1];
//				else y=paper[i][1];
//				if (x != null && y != null) list.add(new int[] {x.intValue(), y.intValue()});
//			}
//		}
		int type = -1;
		int area=100*list.size();
		while (list.size()>0) {
			int size = list.size();
			System.out.printf("Size : %d\n", size);
			for (int i=0;i<size-1;i++) {
				for (int j=i+1;j<size;j++) {
					Integer x = null;
					Integer y = null;
					int lengthX=0;
					int lengthY=0;
					int[] position1 = list.get(i);
					int[] position2 = list.get(j);
					System.out.printf("%d, %d, %d, %d\n", position1[0], position1[1], position1[2], position1[3]);
					System.out.printf("%d, %d, %d, %d\n", position2[0], position2[1], position2[2], position2[3]);
					if (position1[0]>position2[0]) {
						if (position1[0]<position2[0]+position2[2]) {
							System.out.println("A");
							x=position1[0];
							lengthX=position2[2]-Math.abs(position1[0]-position2[0]);
						}
					}
					else if (position1[0]<position2[0]) { 
						if (position1[0]+position1[2]> position2[0]) {
							System.out.println("A2");
							x=position2[0];
							lengthX=position1[2]-Math.abs(position1[0]-position2[0]);
						}
					}
					else {
						System.out.println("A3");
						x=position1[0];
						lengthX=Math.min(position1[2], position2[2]);
					}
					if (position1[1]>position2[1]) { 
						if (position1[1]<position2[1]+position2[3]) {
							System.out.println("A4");
							y=position1[1];
							lengthY=position2[3]-Math.abs(position1[1]-position2[1]);
						}
					}
					else if (position1[1]<position2[1]) { 
						if (position1[1]+position1[3]> position2[1]) {
							System.out.println("A5");
							y=position2[1];
							lengthY=position1[3]-Math.abs(position1[1]-position2[1]);
						}
					}
					else {
						System.out.println("A6");
						y=position1[1];
						lengthY=Math.min(position1[3], position2[3]);
					}
					if (x != null && y != null && lengthX!=0&&lengthY!=0) {
						System.out.printf("%d %d %d %d\n",x, y, lengthX, lengthY);
						list.add(new int[] {x.intValue(), y.intValue(), lengthX, lengthY});
					}
					
				}
			}
			
//			for (int i=0;i<size;i++) {
//				list.remove(0);
//			}
//			for (int i=0;i<list.size();i++) {
//				int count = 1;
//				for (int j=list.size()-1;j>=i;j--) {
//					if (i==j) continue;
//					int[] position1 = list.get(i);
//					int[] position2 = list.get(j);
//					System.out.printf(" %d, %d, %d, %d\n", position1[0], position1[1], position1[2], position1[3]);
//					System.out.printf(" %d, %d, %d, %d\n", position2[0], position2[1], position2[2], position2[3]);
//					if (list.get(i)[0]==list.get(j)[0]&&list.get(i)[1]==list.get(j)[1]&&list.get(i)[2]==list.get(j)[2]&&list.get(i)[3]==list.get(j)[3]) {
////						area+=type*list.get(j)[2]*list.get(j)[3];
//						list.remove(j);
//						count++;
//						
//					}
//				}
//				area+=type*list.get(i)[2]*list.get(i)[3]*count;
//				System.out.printf("hash : %d\n", list.get(i).hashCode());
//			}
			type*=-1;
			System.out.println("Area : "+area);
//			br.readLine();
		}
		System.out.println(area);
	}

}
