package programmers;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class MakeSosu {
	static class Solution {
	    int answer = 0;
	    
		public void comb(Integer[] nums, boolean[] visited, int start, int n, int r, boolean[] sosu) {
	    	if(r == 0) {
	    		Set<Integer> set = new HashSet<Integer>(); 
	            int num = 0;
	    		for(int i=0;i<visited.length;i++) {
	            	if(visited[i]) {
	            		set.add(num);
	            		num += nums[i];
	            	}
	            }
	    		if(set.size() == 3 && sosu[num])
	    			answer++;
	            return;
	        } 

	        for(int i=start; i<n; i++) {
	            visited[i] = true;
	            comb(nums, visited, i + 1, n, r - 1, sosu);
	            visited[i] = false;
	        }
	    }
		public int solution(int[] nums) {
			Arrays.sort(nums);
			boolean[] visited = new boolean[nums.length];
			boolean[] sosu = new boolean[3004];
			Set<Integer> set = Arrays.stream(nums).boxed().collect(Collectors.toSet());
			
			
	        Arrays.fill(sosu, true);
	        for(int i=2; i*i<=3003; i+=1) {
	            for(int j=i*i; j<=3003; j+=i) {
	            	sosu[j] = false;
	            }
	        }
	        Integer[] numsArr = new Integer[set.size()];
			set.toArray(numsArr);
	        comb(numsArr, visited, 0, nums.length, 3, sosu);
	        
	        return answer;
	    }
	}
	public static void main(String[] args) {
		Solution s = new Solution();
		int[] nums = {1,2,7,6,4};
		System.out.println(s.solution(nums));

	}

}
