package programmers;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class GameMapShortest {

	
	
	static class Solution {
		class Point{
			int x, y;
			public Point(int x, int y) {
				this.x = x;
				this.y = y;
			}
		}
	    public int solution(int[][] maps) {
	        boolean[][] visited = new boolean[maps.length][maps[0].length];
	        Queue<Point> q = new LinkedList<>();
	        q.add(new Point(0, 0));
	        int[][] d = {
	        		{0, 1},{-1, 0},{0, -1}, {1, 0}
	        };
	        
	        while(!q.isEmpty()) {
	        	Point p = q.poll();
	        	visited[p.x][p.y] = true;
	        	
	        	for(int i=0;i<d.length;i++) {
	        		if(p.x+d[i][0] < 0 || p.x+d[i][0] >= maps.length || p.y+d[i][1] < 0 || p.y + d[i][1] >= maps[0].length)
	        			continue;
	        		if(maps[p.x+d[i][0]][p.y+d[i][1]] == 0 || visited[p.x+d[i][0]][p.y+d[i][1]])
	        			continue;
	        		if(maps[p.x+d[i][0]][p.y+d[i][1]] == 1) {
	        			maps[p.x+d[i][0]][p.y+d[i][1]] = maps[p.x][p.y] + 1;
	        			q.add(new Point(p.x+d[i][0], p.y+d[i][1]));
	        		}
	        	}
	        }
	        
	        return maps[maps.length-1][maps[0].length-1];
	    }
	}
	
	public static void main(String[] args) {
		int[][] maps = {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}};
		for(int i=0;i<maps.length;i++) System.out.println(Arrays.toString(maps[i]));
		Solution s = new Solution();
		System.out.println(s.solution(maps));
		// 테케 1, 5, 6, 10 17 효율성 2, 3, 4
	}

}
