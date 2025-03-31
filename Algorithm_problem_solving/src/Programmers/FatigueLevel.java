package Programmers;

import java.util.Stack;

public class FatigueLevel {
	static int[][] dungeons = {{80,20},{50,40},{30,10}};
	static int k = 80;
	public static void main(String[] args) {
		Stack<Node> s = new Stack<>();
		s.push(new Node(k, 0));
        int dungeonNum = dungeons.length;
        int count = 0;
        while (!s.isEmpty()) {
            Node n = s.pop();
            if (Integer.bitCount(n.bitmask)==dungeonNum) count = dungeonNum;
            for (int i=0;i<dungeonNum;i++) {
                if ((n.bitmask&1<<i)==0) {
                    if (n.k>=dungeons[i][0]) {
                        int nb = n.bitmask|1<<i;
                        s.push(new Node(n.k-dungeons[i][1], nb));
                    }
                    else {
                    	count = Math.max(Integer.bitCount(n.bitmask), count);
                    }
                }
            }
        }
        int answer = -1;
        System.out.println(count);
    }
    static class Node {
        public int k;
        public int bitmask;
        
        Node(int k, int bitmask) {
            this.k = k;
            this.bitmask = bitmask;
        }
    }
}
