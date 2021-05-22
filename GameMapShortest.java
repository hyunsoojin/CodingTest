package programmers;

public class GameMapShortest {

	static class Solution {
		public void dfs(int x, int y, int[][] maps, boolean[][] visited, int sum) {
			if(x < 0 || x >= maps.length || y < 0 || y >= maps[0].length || visited[x][y] || maps[x][y] == 0)
				return;
			
			visited[x][y] = true;
			
			if(maps[x][y] != 1 && maps[x][y] >= sum) return;
			else maps[x][y] += sum;
			
			dfs(x+1, y, maps, visited, maps[x][y]);
			dfs(x , y+1, maps, visited, maps[x][y]);
			dfs(x-1, y, maps, visited, maps[x][y]);
			dfs(x, y-1, maps, visited, maps[x][y]);
			
		}
		
	    public int solution(int[][] maps) {
	        int answer = 0;
	        boolean[][] visited = new boolean[maps.length][maps[0].length];
	        
	        dfs(0, 0, maps, visited, 0);
	        
	        if(maps[maps.length-1][maps[0].length-1] <= 1) answer = -1;
	        else answer = maps[maps.length-1][maps[0].length-1];
	        
	        return answer;
	    }
	}
	
	public static void main(String[] args) {
		int[][] maps = {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}};
		
		Solution s = new Solution();
		System.out.println(s.solution(maps)); 

	}

}
