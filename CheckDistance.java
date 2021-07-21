package programmers;

import java.util.Arrays;

public class CheckDistance {
	static class Solution {
	    public boolean check(int i, int j, int k, String[][] places){
	        for(int y = k-2; y <= k+2; y++){
	        	if(y < 0 || y >= 5)
	        		continue;
	            for(int x = j-2; x <= j+2; x++){
	            	if(x < 0 || x >= 5)
	            		continue;
	                if(Math.abs(k-y) + Math.abs(j-x) > 2 || (y == k && x == j))
	                    continue;
	                else if(places[i][x].charAt(y) == 'P'){
	                	if(Math.abs(k-y) + Math.abs(j-x) == 1) return false;
                        for(int ty = Math.min(k, y); ty <= Math.max(k, y); ty++){
                            for(int tx = Math.min(j, x); tx <= Math.max(j, x); tx++){
                                if(places[i][tx].charAt(ty) == 'O')
                                    return false;
                            }
                        }
	                }
	            }
	        }
	        return true;
	        
	    }
	    public int[] solution(String[][] places) {
	        int[] answer = new int[places.length];
	        
	        for(int i=0;i<places.length;i++){
	            boolean chk = true;
	            loop: for(int j=0;j<5;j++){
	                for(int k=0;k<5;k++){
	                	System.out.println(i + ", " + j + ", " + k);
	                    if(places[i][j].charAt(k) == 'P'){
	                    	if(!check(i, j, k, places)) {
	                    		chk = false;
		                        break loop;
	                    	}
	                    }
	                }
	            }
	            if(chk) answer[i] = 1;
	        }
	        
	        return answer;
	    }
	}
	public static void main(String[] args) {
		Solution s = new Solution();
		String[][] places = {{"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"}, {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"}, {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"}, {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"}, {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}};
		System.out.println(Arrays.toString(s.solution(places))); 

	}

}
