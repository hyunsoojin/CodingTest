package programmers;

public class EstimatedMatchTable {
	static class Solution
	{
	    public int solution(int n, int a, int b)
	    {
	        int answer = 0;
	        
	        while(a != b) {
	        	a = (a + 1)/2;
	        	b = (b + 1)/2;
	        	answer++;
	        }

	        return answer;
	    }
	}
	
	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.solution(8, 4, 7));

	}

}
