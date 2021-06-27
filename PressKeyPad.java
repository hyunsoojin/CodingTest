package programmers;

import java.util.HashMap;
import java.util.Map;

public class PressKeyPad {

	static class Solution {
	    public int distPos(Integer[] a, Integer[] b) {
	    	int dist = Math.abs(a[0] - b[0]) * Math.abs(a[0] - b[0]) +
	    			Math.abs(a[1] - b[1]) * Math.abs(a[1] - b[1]);
	    	return dist;
	    }
		public String solution(int[] numbers, String hand) {
	        String answer = "";
	        StringBuffer sb = new StringBuffer();
	        
	        Map<Character, Integer[]> map = new HashMap<Character, Integer[]>();
	        int num = 1;
	        for(int i=0;i<3;i++) {
	        	for(int j=0;j<3;j++) {
	        		Integer[] tempArr = {i, j};
	        		map.put(Integer.toString(num++).charAt(0), tempArr);
	        	}
	        }
	        map.put('*', new Integer[]{3,0});
	        map.put('0', new Integer[]{3,1});
	        map.put('#', new Integer[]{3,2});
	        char left = '*';
	        char right = '#';
	        for(int i=0;i<numbers.length;i++) {
	        	if(numbers[i] == 1 || numbers[i] == 4 || numbers[i] == 7) {
	        		sb.append("L");
	        		left = Integer.toString(numbers[i]).charAt(0); 
	        	}else if(numbers[i] == 3 || numbers[i] == 6 || numbers[i] == 9) {
	        		sb.append("R");
	        		right = Integer.toString(numbers[i]).charAt(0); 
	        	}else {
	        		Integer[] targetPos = map.get(Integer.toString(numbers[i]).charAt(0));
	        		Integer[] leftPos = map.get(left);
	        		Integer[] rightPos = map.get(right);
	        		int dis =  distPos(leftPos, targetPos) - distPos(rightPos, targetPos);
	        		if(dis < 0){
	        			sb.append("L");
	        			left = Integer.toString(numbers[i]).charAt(0); 
	        		}else if(dis > 0){
	        			sb.append("R");
	        			right = Integer.toString(numbers[i]).charAt(0);
	        		}else {
	        			if(hand.equals("right")) {
	        				sb.append("R");
		        			right = Integer.toString(numbers[i]).charAt(0);
	        			}else {
	        				sb.append("L");
		        			left = Integer.toString(numbers[i]).charAt(0);
	        			}
	        		}
	        	}
	        }
	        answer = sb.toString();
	        return answer;
	    }
	}
	
	public static void main(String[] args) {
		Solution s = new Solution();
		int[] numbers = {1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5};
		String hand = "right";
		System.out.println(s.solution(numbers, hand)); 

	}

}
