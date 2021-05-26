package programmers;

import java.util.Arrays;
import java.util.Comparator;

public class LifeBoat {
	static class Solution {
	    public int solution(int[] people, int limit) {
	        int answer = 0;
	        Arrays.sort(people);
	        int tempSum = people[people.length-1];
	        int num = 1;
	        for(int end = people.length-1; end > 0;){
	            if(tempSum + people[--end] > limit || num >= 2){
	            	answer++;
	            	tempSum = people[end];
	            	num = 1;
	            }else{
	                tempSum += people[end];
	                num+=1;
	            }
	            if(end == 0) 
	            	answer++;
	        }
	        return answer;
	    }
	}
	public static void main(String[] args) {
		Solution s = new Solution();
		int[] people = {70, 50, 80, 50};
		int limit = 100;
		System.out.println(s.solution(people, limit));

	}

}
