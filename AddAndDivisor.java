package programmers;

public class AddAndDivisor {

	static class Solution {
	    public int solution(int left, int right) {
	        int answer = 0;
	        int[] count = new int[right+1];
	        for (int i = 1; i <= right; i++){ 
	            for(int j = 1; j <= right / i; j++){ 
	                count[i*j]++;
	            }
	        }
	        for(int i=left;i<=right;i++){
	            if(count[i]%2 == 0) answer+=i;
	            else    answer-=i;
	        }
	        return answer;
	    }
	}
	
	public static void main(String[] args) {
		Solution s = new Solution();
		int left = 13;
		int right = 17;	
		System.out.println(s.solution(left, right)); 

	}

}
