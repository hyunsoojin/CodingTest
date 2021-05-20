package programmers;

import java.util.*;
public class KakaoFriendsColorBook {

	public static void main(String[] args) {
		class Solution {
		    class Customint{
		    	int sum;
		    	public Customint(int sum) {
					this.sum = sum;
				}
		    }
		    public void dfs(int x, int y, int[][] pictures, boolean[][] visited, Customint ci, int color) {
		    	if(x < 0 || x > pictures.length-1 || y < 0 || y > pictures[0].length-1 || 
		    			visited[x][y] || pictures[x][y] == 0 || pictures[x][y] != color)
		    		return;
		    	
		    	visited[x][y] = true;
		    	ci.sum += 1;
	    		
		    	dfs(x+1, y, pictures, visited, ci, color);
		    	dfs(x, y+1, pictures, visited, ci, color);
		    	dfs(x-1, y, pictures, visited, ci, color);
		    	dfs(x, y-1, pictures, visited, ci, color);
		    	
		    }
		    public int[] solution(int m, int n, int[][] picture) {

		        int[] answer = new int[2];
		        boolean[][] visited = new boolean[m][n];
		        ArrayList<Integer> list = new ArrayList<Integer>();
		        for(int i=0;i<m;i++) {
		        	for(int j=0;j<n;j++) {
		        		Customint ci = new Customint(0);
		        		dfs(i, j, picture, visited, ci, picture[i][j]);
		        		if(ci.sum > 0) list.add(ci.sum);
		        	}
		        }
		        list.sort(Comparator.reverseOrder());
		        answer[0] = list.size();
		        answer[1] = list.get(0);
		        
		        return answer;
		    }
		}
		Solution s = new Solution();
		int[][] picture = {{1, 1, 1, 0}, {1, 2, 2, 0}, {1, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 3}, {0, 0, 0, 3}};
		int m = 6;
		int n = 4;
		System.out.println(Arrays.toString(s.solution(m, n, picture)));
	}

}
