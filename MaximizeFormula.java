package programmers;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MaximizeFormula {
	static class Solution {
		public void perm(char[] arr, char[] output, boolean[] visited, int depth, int n, int r, List<Long> numlist, List<Character> operlist, List<Long> result) {
		    if (depth == r) {
		        List<Long> tempnumlist = new ArrayList<Long>();
		        tempnumlist.addAll(numlist);
		        List<Character> tempoperlist = new ArrayList<Character>();
		        tempoperlist.addAll(operlist);
		    	
		        while(!tempoperlist.isEmpty()) {
			        for(int i=0;i<output.length;i++) {
			        	for(int j=0;j<tempoperlist.size();) {
				        	if(tempoperlist.get(j) == output[i]) {
				        		long l = 0;
				        		switch (tempoperlist.get(j)) {
								case '+': l = tempnumlist.get(j) + tempnumlist.get(j+1); break;
								case '-': l = tempnumlist.get(j) - tempnumlist.get(j+1); break;
								case '*': l = tempnumlist.get(j) * tempnumlist.get(j+1); break;
				        		}
				        		tempnumlist.add(j, l);
				        		tempnumlist.remove(j+1);
								tempnumlist.remove(j+1);
				        		tempoperlist.remove(j);
				        	}else j++;
				        }
			        }
		        }
		        result.add(Math.abs(tempnumlist.get(0)));
		        
		        return;
		    }
		 
		    for (int i=0; i<n; i++) {
		        if (visited[i] != true) {
		            visited[i] = true;
		            output[depth] = arr[i];
		            perm(arr, output, visited, depth + 1, n, r, numlist, operlist, result);       
		            visited[i] = false;
		        }
		    }
		}
		
		public long solution(String expression) {
	        long answer = 0;
	        
	        char[] arr = {'+', '-', '*'};
	        char[] output = new char[arr.length];
	        boolean[] visited = new boolean[arr.length];
	        List<Long> numlist = new ArrayList<Long>();
	        List<Character> operlist = new ArrayList<Character>();
	        List<Long> result = new ArrayList<Long>();
	        String str = "";
	        for(int i=0;i<expression.length();i++) {
	        	char c = expression.charAt(i);
	        	if(c == arr[0] || c == arr[1] || c == arr[2]) {
	        		operlist.add(c);
	        		numlist.add(Long.parseLong(str));
	        		str = "";
	        	}else {
	        		str += c;
	        	}
	        	if(i == expression.length()-1) numlist.add(Long.parseLong(str));
	        }
	        
	        perm(arr, output, visited, 0, arr.length, output.length, numlist, operlist, result);
	        result.sort(Comparator.reverseOrder());
	        answer = result.get(0);
	        
	        return answer;
	    }
	}
	public static void main(String[] args) {
		Solution s = new Solution();
		String expression = "2*2*2*2*2-2*2*2";
		System.out.println(s.solution(expression));

	}

}
