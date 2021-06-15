package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class FarthestNode {
	static class Solution {
	    class Node{
	    	int index, distance;
	    	public Node(int index, int distance) {
				this.index = index;
				this.distance = distance;
			}
	    }
		public int solution(int n, int[][] edge) {
	        int answer = 0;
	        
	        ArrayList<ArrayList<Node>> graph = new ArrayList<>();
	        for(int i=0;i<n+1;i++) {
	        	graph.add(new ArrayList<Node>());
	        }
	        int[] d = new int[n+1];
	        
	        Arrays.fill(d, (int)1e9);
	        
	        for(int i=0;i<edge.length;i++) {
	        	graph.get(edge[i][0]).add(new Node(edge[i][1], 1));
	        	graph.get(edge[i][1]).add(new Node(edge[i][0], 1));
	        }
	        
	        Queue<Integer> q = new LinkedList<Integer>();
	        q.add(1);
	        d[1] = 0;
	        boolean[] visited = new boolean[n+1];
	        int max = 0;
	        while(!q.isEmpty()) {
	        	int start = q.poll();
	        	if(visited[start]) continue;
	        	visited[start] = true;
	        	for(int i=0;i<graph.get(start).size();i++) {
	        		int dist = d[start] + graph.get(start).get(i).distance;
	        		int targetIdx = graph.get(start).get(i).index;
	        		d[targetIdx] = Math.min(d[targetIdx], dist);
	        		max = Math.max(max, d[targetIdx]);
	        		q.add(targetIdx);
	        	}
	        }
	        Arrays.sort(d);
	        for(int i=n;i>=0;i--) {
	        	if(d[i] == max) answer++;
	        	else if(d[i] < max) break;
	        }
	        
	        return answer;
	    }
	}
	public static void main(String[] args) {
		Solution s = new Solution();
		int n = 6;
		int[][] edge = {{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}};
		System.out.println(s.solution(n, edge)); 

	}

}
