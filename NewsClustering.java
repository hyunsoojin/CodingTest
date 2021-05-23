package programmers;

import java.util.ArrayList;
import java.util.Collections;

public class NewsClustering {
	static class Solution {
	    public int solution(String str1, String str2) {
	        int answer = 0;
	        ArrayList<String> list1 = new ArrayList<String>();
	        ArrayList<String> list2 = new ArrayList<String>();
	        ArrayList<String> templist = new ArrayList<String>();
	        ArrayList<String> templi = new ArrayList<String>();
	        String reg = "^[a-zA-Z]*$";
	        
	        for(int i=0;i<str1.length()-1;i++) {
	        	String target = str1.substring(i,i+2);
	        	if(!target.matches(reg))
	        		continue;
	        	target = target.toLowerCase();
	        	list1.add(target);
	        }
	        for(int i=0;i<str2.length()-1;i++) {
	        	String target = str2.substring(i,i+2);
	        	if(!target.matches(reg))
	        		continue;
	        	target = target.toLowerCase();
	        	list2.add(target);
	        }
	        
	        Collections.sort(list1);
	        Collections.sort(list2);
	        
	        templist.addAll(list1);
	        templist.addAll(list2);
	        
	        templi.addAll(list1);
	        
	        for(int i=0;i<list2.size();i++) {
	        	list1.remove(list2.get(i));
	        }
	        for(int i=0;i<templi.size();i++) {
	        	list2.remove(templi.get(i));
	        }
	        for(int i=0;i<list1.size();i++)
	        	templist.remove(list1.get(i));
	        for(int i=0;i<list2.size();i++)
	        	templist.remove(list2.get(i));
	        
	        int dif = templist.size()/2;
	        int union = list1.size() + list2.size() + dif;
	        
	        if(dif == 0 && union == 0) 
	        	answer = 65536;
	        else 
	        	answer = (int) Math.floor((float)dif * 65536 / (float)union );
	        
	        return answer;
	    }
	}
	public static void main(String[] args) {
		Solution s = new Solution();
		String str1 = "ababab";
		String str2 = "abab";
		
		System.out.println(s.solution(str1, str2)); 

	}

}
