package weeklychallenge;

public class Week1 {

	static class Solution {
	    public long solution(int price, int money, int count) {
	        return Math.max((long)price*(count*(count+1)/2)-money, 0);
	    }
	}
	
	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.solution(3, 20, 4)); 
	}

}
