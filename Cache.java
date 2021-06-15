package programmers;

import java.util.LinkedList;
import java.util.Queue;

public class Cache {
	static class Solution {
	    public int solution(int cacheSize, String[] cities) {
	        int answer = 0;
	        
	        if(cacheSize == 0) {
	        	return cities.length * 5;
	        }
	        
	        Queue<String> queue = new LinkedList<>();
	        
	        for(int i=0;i<cities.length;i++) {
	        	boolean hit = ((LinkedList<String>) queue).removeFirstOccurrence(cities[i].toUpperCase());
	        	queue.add(cities[i].toUpperCase());
	        	if(hit) answer += 1;
	        	else {
	        		answer += 5;
	        		if(queue.size() > cacheSize) {
	        			((LinkedList<String>) queue).removeFirst();
	        		}
	        	}
	        }
	        return answer;
	    }
	}
	public static void main(String[] args) {
		Solution s = new Solution();
		int cacheSize = 3;
		String[] cities = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"};
		System.out.println(s.solution(cacheSize, cities));
	}

}
