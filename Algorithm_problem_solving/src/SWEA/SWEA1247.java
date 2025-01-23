package SWEA;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SWEA1247 {

	public static void main(String[] args) throws Exception {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine().trim());
		
		for (int test_case=1;test_case<=T;test_case++) {
			int n = Integer.parseInt(br.readLine().trim());
			
			int[][] map = new int[n+2][2];
			
			String[] input = br.readLine().trim().split(" ");
			for (int i =0;i<(n+2)*2;i++) {
				map[i/2][i%2] = Integer.parseInt(input[i]);
			}
			int distance = Integer.MAX_VALUE;
			distance = recursive(map, new int[n][2], 0, new boolean[n],distance);
			System.out.printf("#%d %d\n", test_case, distance);
		}
				
	}
	
	public static int recursive(int[][] arr,int[][] arr2, int idx,boolean[]v, int minDistance) {
		if (idx==arr2.length) {
			int sum = 0;
			sum+=distance(arr[0],arr2[0]);
			for (int i = 0;i<arr2.length-1;i++) {
				sum+=distance(arr2[i],arr2[i+1]);
			}
			sum+=distance(arr2[arr2.length-1],arr[1]);
			return Math.min(minDistance, sum);
		}
		
		for (int i=0;i<arr.length-2;i++) {
			if (!v[i]) {
				v[i]= true;
				arr2[idx] = arr[i+2];
				int distance = recursive(arr,arr2,idx+1,v, minDistance);
				minDistance=Math.min(distance, minDistance);
				v[i]=false;
			}
		}
		return minDistance;
	}

	public static int distance(int[] arr1, int[] arr2) {
		return Math.abs(arr1[0]-arr2[0]) + Math.abs(arr1[1]-arr2[1]);
	}
}
