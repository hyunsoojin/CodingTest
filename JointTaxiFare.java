package programmers;
import java.util.*;
public class JointTaxiFare {
	
	static class Solution {
	    int INF = (int) 1e9;
	    
	    public int solution(int n, int s, int a, int b, int[][] fares) {
	        int answer = INF;
	        
	        int[][] d = new int[n+1][n+1];
	        
	        for(int i=0;i<d.length;i++){
	            Arrays.fill(d[i], INF);
	            d[i][i] = 0;
	        }
	        
	        for(int i=0;i<fares.length;i++) {
	        	d[fares[i][0]][fares[i][1]] = fares[i][2];
	            d[fares[i][1]][fares[i][0]] = fares[i][2];
	        }
	        
	        for(int k=1;k<=n;k++){
	            for(int i=1;i<=n;i++){
	                for(int j=1;j<=n;j++){
	                    d[i][j] = Math.min(d[i][j], d[i][k]+d[k][j]);
	                }
	            }
	        }
	        
	        for(int i=1;i<=n;i++) {
	            if(d[i][s] < INF && d[i][a] < INF && d[i][b] < INF){
	                answer = Math.min(answer, d[i][s]+d[i][a]+d[i][b]);
	            }
	        }
	        
	        return answer;
	    }
	}
	public static void main(String[] args) {
		Solution sol = new Solution();
		int n = 6;
		int s = 4;
		int a = 6;
		int b = 2;	
		int[][] fares = {{4, 1, 10}, {3, 5, 24}, {5, 6, 2}, {3, 1, 41}, {5, 1, 24}, {4, 6, 50}, {2, 4, 66}, {2, 3, 22}, {1, 6, 25}};
		System.out.println(sol.solution(n, s, a, b, fares));

	}

}
