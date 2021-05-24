package programmers;

public class RotateParentheses {
	static class Solution {
	    public boolean checkPattern(String s) {
	    	boolean chk = true;
	    	
	    	int before = 0;
		    int after = 0;
	    	
	    	while(chk) {
	    		before = s.length();
	    		char left = ' ';
	    		char right = ' ';
	    		int leftidx = 0;
	    		int rightidx = 0;
	    		for(int i=0;i<s.length();i++) {
	    			char target = s.charAt(i);
	    			if(target == '[' || target == '{' || target == '(') {
	    				left = target;
	    				leftidx = i;
	    			}else {
	    				right = target;
	    				rightidx = i;
	    			}
	    			if(left != ' ' && right != ' ') {
	    				if(left == '[' && right == ']') 
	    					s = s.substring(0, leftidx) + s.substring(rightidx+1, s.length());
	    				if(left == '(' && right == ')') 
	    					s = s.substring(0, leftidx) + s.substring(rightidx+1, s.length());
	    				if(left == '{' && right == '}') 
	    					s = s.substring(0, leftidx) + s.substring(rightidx+1, s.length());
	    				break;
	    			}
	    			
	    		}
	    		
	    		after = s.length();
	    		if(s.length() == 0) break;
	    		if(before == after) {
	    			chk = false;
	    			break;
	    		}
	    	}
	    	
	    	return chk;
	    }
		public int solution(String s) {
	        int answer = 0;
	        
	        
	        for(int i=0;i<s.length();i++) {
	        	StringBuffer sb = new StringBuffer();
	        	sb.append(s.substring(i));
	        	sb.append(s.substring(0,i));
	        	
	        	if(checkPattern(sb.toString())) answer++; 
	        }
	        
	        return answer;
	    }
	}
	public static void main(String[] args) {
		Solution s = new Solution();
		
		System.out.println(s.solution("[](){}")); 
		
		/*
			0	"[](){}"	O
			1	"](){}["	X
			2	"(){}[]"	O
			3	"){}[]("	X
			4	"{}[]()"	O
			5	"}[](){"	X
		 */
	}

}
