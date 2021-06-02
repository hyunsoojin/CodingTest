package programmers;

import java.util.Arrays;

public class RepeatBinaryTransformation {

	static class Solution {
	    public int[] solution(String s) {
	        int[] answer = new int [2];
	        while(!s.equals("1")){
	            int blength = s.length();
	        	s = s.replaceAll("0", "");
	        	int alength = s.length();
	            answer[0] += 1;
	        	answer[1] += blength-alength;
	        	s = Integer.toBinaryString(alength);
	        }
	        return answer;
	    }
	}
	
	public static void main(String[] args) {
		Solution s = new Solution();
		
		System.out.println(Arrays.toString(s.solution("110010101001")));

	}

}
