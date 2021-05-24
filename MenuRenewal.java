package programmers;

import java.util.*;
import java.util.Map.Entry;

public class MenuRenewal {
	static class Solution {
	    public void comb1(String arr, boolean[] visited, int start, int n, int r, HashMap<String,Integer> menu) {
	    	if(r == 0) {
	    		String str = "";
	    		for(int i=0;i<visited.length;i++) {
	    			if(visited[i])
	    				str += arr.charAt(i);
	    		}
	    		if(menu.containsKey(str)) menu.put(str, menu.get(str)+1);
	    		else menu.put(str, 1);
	    		return;
	    	} else {
	    		for(int i = start; i < n; i++) {
	    			visited[i] = true;
	    			comb1(arr, visited, i + 1, n, r - 1, menu);
	    			visited[i] = false;
	    		}
	    	}
	    }
	    public String[] solution(String[] orders, int[] course) {
	        String[] answer = {};
	        boolean[] visited;
	        for(int i =0;i<orders.length;i++){
	            ArrayList<Character> list = new ArrayList<Character>();
	            String order = orders[i];
	            for(int j=0;j<order.length();j++)
	                list.add(order.charAt(j));
	            Collections.sort(list);
	            String neworder = "";
	            for(int j=0;j<list.size();j++){
	                neworder += list.get(j);
	            }
	            orders[i] = neworder;
	        }
	        Arrays.sort(orders);
	        
	        HashMap<String,Integer> menu = new HashMap<String,Integer>();
	        for(int i=0;i<orders.length;i++){
	            for(int j=0;j<course.length;j++){
	                visited = new boolean[orders[i].length()];
	                comb1(orders[i], visited, 0, orders[i].length(), course[j], menu);
	            }
	        }

			List<Entry<String, Integer>> list_entries = new ArrayList<Entry<String, Integer>>(menu.entrySet());

			Collections.sort(list_entries, new Comparator<Entry<String, Integer>>() {
				public int compare(Entry<String, Integer> obj1, Entry<String, Integer> obj2)
				{
					return obj2.getValue().compareTo(obj1.getValue());
				}
			});
			ArrayList<String> res = new ArrayList<String>();
			boolean[] chk = new boolean[course[course.length-1]+1];
			for(Entry<String, Integer> entry : list_entries) {
				if(res.isEmpty() && entry.getValue() >= 2) res.add(entry.getKey());
				else {
					boolean flag = false;
					for(int i=0;i<res.size();i++) {
						if(res.get(i).length() == entry.getKey().length()) {
							flag = true;
							if(menu.get(res.get(i)) == entry.getValue()) res.add(entry.getKey());
							break;
						}
					}
					if(!flag && entry.getValue() >= 2) res.add(entry.getKey());
				}
			}
			
	        Collections.sort(res);
	        answer = (String[])res.toArray(new String[0]);
	        return answer;
	    }
	}
	public static void main(String[] args) {
		Solution s = new Solution();
		String[] orders = {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
		int[] course = {2,3,4};
		
		System.out.println(Arrays.toString(s.solution(orders, course)));
		// ["AC", "ACDE", "BCFG", "CDE"]
		
		
	}

}
