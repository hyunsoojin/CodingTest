package programmers;

import java.util.Arrays;

public class Delivery {
	static class Solution {
		public int solution(int N, int[][] road, int K) {
	        int answer = 0;
	        
	        int[][] dist = new int[N+1][N+1];
	        for(int i=0;i<dist.length;i++) {
	        	Arrays.fill(dist[i], (int)1e9);
	        }
	        for(int i=1;i<dist.length;i++) {
	        	dist[i][i] = 0;
	        }
	        
	        for(int i=0;i<road.length;i++) {
	        	dist[road[i][0]][road[i][1]] = Math.min(dist[road[i][0]][road[i][1]], road[i][2]);
	        	dist[road[i][1]][road[i][0]] = Math.min(dist[road[i][1]][road[i][0]], road[i][2]);
	        }
	        
	        for (int k = 1; k <= N; k++) {
	            for (int a = 1; a <= N; a++) {
	                for (int b = 1; b <= N; b++) {
	                	dist[a][b] = Math.min(dist[a][b], dist[a][k] + dist[k][b]);
	                }
	            }
	        }
	        
	        for(int i=1;i<dist.length;i++) {
	        	if(dist[1][i] <= K) answer++;
	        }
	        
	        return answer;
	    }
	}
	public static void main(String[] args) {
		Solution s = new Solution();
				
		int N = 6;
		int[][] road = {{1, 2, 1}, {1, 3, 2}, {2, 3, 2}, {3, 4, 3}, {3, 5, 2}, {3, 5, 3}, {5, 6, 1}};
		int K = 4;
		s.solution(N, road, K);

	}

}
