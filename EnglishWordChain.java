package programmers;
import java.util.*;
public class EnglishWordChain {
	static class Solution {
	    public int[] solution(int n, String[] words) {
	        int[] answer = new int[2];
	        Set<String> set = new HashSet<>();
	        List<HashSet<String>> setlist = new ArrayList<>();
	        for(int i=0;i<n;i++){
	            setlist.add(new HashSet<String>());
	        }
	        char targetc = words[0].charAt(0);
	        for(int i=0;i<words.length;i++){
	            if(set.add(words[i]) && targetc == words[i].charAt(0)){
	            	targetc = words[i].charAt(words[i].length()-1);
	            	setlist.get(i%n).add(words[i]);
	            }else{
	                answer[0] = (i%n)+1;
	                answer[1] = setlist.get(i%n).size()+1;
	                break;
	            }
	        }
	        return answer;
	    }
	}
	public static void main(String[] args) {
		Solution s = new Solution();
		int n =  2;
		String[] words = {"hello", "one", "even", "never", "now", "world", "draw"}; 
		System.out.println(Arrays.toString(s.solution(n, words)));
		//  [1, 3]

	}

}
