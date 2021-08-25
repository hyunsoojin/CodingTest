package programmers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Week4 {
	static class Solution {
		class Field{
			String field;
			int score;
			public Field(String field, int score) {
				this.field = field;
				this.score = score;
			}
		}
	    public String solution(String[] table, String[] languages, int[] preference) {
	        String answer = "";
	        Map<String, HashMap<String, Integer>> map = new HashMap<String, HashMap<String,Integer>>();
	        for(int i=0;i<table.length;i++) {
	        	String[] tableArr = table[i].split(" ");
	        	
	        	HashMap<String, Integer> tempMap = new HashMap<String, Integer>();
	        	for(int j=1;j<tableArr.length;j++) {
	        		tempMap.put(tableArr[j], tableArr.length-j);
	        	}
	        	map.put(tableArr[0], tempMap);
	        }
	        Comparator<Field> myComp = new Comparator<Week4.Solution.Field>() {
				@Override
				public int compare(Field o1, Field o2) {
					if(o1.score != o2.score) return o2.score - o1.score;
					else return o1.field.compareTo(o2.field);
				}
			};
	        List<Field> list = new ArrayList<>(); 
	        
	        for(String key : map.keySet()) {
	        	HashMap<String,Integer> val = map.get(key);
	        	int score = 0;
	        	for(int j=0;j<languages.length;j++) {
	        		if(val.containsKey(languages[j])) {
	        			score += val.get(languages[j]) * preference[j]; 
	        		}
	        	}
	        	list.add(new Field(key, score));
	        }
	        
	        Collections.sort(list, myComp);
	        
	        answer = list.get(0).field;
	        
	        return answer;
	    }
	}
	public static void main(String[] args) {
		Solution s = new Solution();
		String[] table = {"SI JAVA JAVASCRIPT SQL PYTHON C#", "CONTENTS JAVASCRIPT JAVA PYTHON SQL C++", "HARDWARE C C++ PYTHON JAVA JAVASCRIPT", "PORTAL JAVA JAVASCRIPT PYTHON KOTLIN PHP", "GAME C++ C# JAVASCRIPT C JAVA"};
		String[] languages =  {"JAVA", "JAVASCRIPT"};
		int[] preference = {7, 5};
		System.out.println(s.solution(table, languages, preference)); 

	}

}
