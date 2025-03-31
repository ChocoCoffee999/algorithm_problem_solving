package Programmers;

public class TargetNumber {
	static int[] arr;
    static int t;
    static int count = 0;
    static int[] numbers = {1, 1, 1, 1, 1};
    static int target = 3;
	public static void main(String[] args) {
		arr = numbers;
        t = target;
        dfs(0,0);
        System.out.println(count);
    }
    
    public static void dfs(int sum, int idx) {
        if (idx==arr.length) {
            if (sum==t) count++;
            return;
        }
        
        dfs(sum+arr[idx], idx+1);
        dfs(sum-arr[idx], idx+1);
    }
}
