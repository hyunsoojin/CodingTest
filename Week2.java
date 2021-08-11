package programmers;
import java.util.*;
public class Week2 {

	
	static class Solution {
	    public String solution(int[][] scores) {
	        String answer = "";
	        StringBuffer sb = new StringBuffer();
	        for(int i=0;i<scores.length;i++){
	        	List<Integer> list = new ArrayList<Integer>();
	            int target = scores[i][i];
	            
	            for(int j=0;j<scores.length;j++) {
	            	if(i==j) continue;
	            	list.add(scores[j][i]);
	            }
	            
	            Collections.sort(list);
	            if(list.get(0) <= target && target <= list.get(list.size()-1))
	            	list.add(target);
	            int average = list.stream().mapToInt(Integer::intValue).sum() / list.size();
	            if(average >= 90)	sb.append("A");
	            else if(average >= 80) sb.append("B");
	            else if(average >= 70) sb.append("C");
	            else if(average >= 50) sb.append("D");
	            else sb.append("F");
	        }
	        answer = sb.toString();
	        return answer;
	    }
	}
	
	public static void main(String[] args) {
		Solution s = new Solution();
		int[][] scores = {{100,90,98,88,65},{50,45,99,85,77},{47,88,95,80,67},{61,57,100,80,65},{24,90,94,75,65}};
		System.out.println(s.solution(scores)); 
	}

}
