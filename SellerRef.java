package programmers;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class SellerRef {
	static class Solution {
	    class Seller{
	        String name, ref;
	        int tempAmount;
	        int amount;
	        public Seller(String name, String ref, int amount){
	            this.name = name;
	            this.ref = ref;
	            this.amount = amount;
	        }
	        public String toString() {
	        	StringBuffer sb = new StringBuffer();
	        	sb.append(name);
	        	sb.append(" ");
	        	sb.append(ref);
	        	sb.append(" ");
	        	sb.append(tempAmount);
	        	sb.append(" ");
	        	sb.append(amount);
	        	return sb.toString();
	        }
	    }
	    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
	        int[] answer = new int[enroll.length];
	        Map<String, Seller> map = new HashMap<>(); 
	        for(int i=0;i<enroll.length;i++) {
	        	map.put(enroll[i], new Seller(enroll[i], referral[i], 0));
	        }
	        
	        for(int i=0;i<seller.length;i++) {
	        	Seller s = map.get(seller[i]);
	        	Queue<String> q = new LinkedList<String>();
	        	int depth = 0;
	        	while(true) {
	        		q.add(s.name);
	        		if(depth == 0 && !s.ref.equals("-")) {
		        		s.tempAmount = amount[i] * 90;
		        		map.get(s.ref).tempAmount = amount[i] * 10;
		        		s = map.get(s.ref);
		        	}else if(depth == 0 && s.ref.equals("-")) {
		        		s.tempAmount = amount[i] * 90;
		        		break;
		        	}else if(!s.ref.equals("-")) {
		        		if(s.tempAmount < 10) {
		        			break;
		        		}
		        		map.get(s.ref).tempAmount = s.tempAmount / 10;
		        		s.tempAmount = s.tempAmount - map.get(s.ref).tempAmount;
		        		s = map.get(s.ref);
		        	}else {
		        		if(s.tempAmount < 10) {
		        			break;
		        		}
		        		s.tempAmount = s.tempAmount - s.tempAmount / 10;
		        		break;
		        	}
	        		depth++;
	        	}
	        	
	        	while(!q.isEmpty()) {
	        		String name = q.poll();
	        		map.get(name).amount += map.get(name).tempAmount;
	        		map.get(name).tempAmount = 0;
	        	}
	        	
	        }
	        for(int i=0;i<enroll.length;i++) {
	        	answer[i] = map.get(enroll[i]).amount;
	        	System.out.println(answer[i]);
	        }
	        
	        return answer;
	    }
	}
	public static void main(String[] args) {
		Solution s = new Solution();
		String[] enroll = {"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"};
		String[] referral = {"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"};
		String[] seller = {"young", "john", "tod", "emily", "mary"};
		int[] amount = {12, 4, 2, 5, 10};
		
		s.solution(enroll, referral, seller, amount);

	}

}
