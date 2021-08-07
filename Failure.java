package programmers;
import java.util.*;
import java.util.Map.Entry;

public class Failure {

	static class Solution {
	    public int[] solution(int N, int[] stages) {
	    	int[] answer = new int[N];
	        Arrays.sort(stages);

	        Map<Integer, Double> map = new HashMap<Integer, Double>();

	        for(int i=1;i<=N;i++) map.put(i, 0.0);

	        int stage = stages[0];
	        int sum = stages.length;
	        int target = 0;

	        for(int i=0;i<stages.length;i++) {
	            if(stage > N) break;
	            if(stages[i] == stage) target++;
	            else {
	                map.put(stage, (double)target/sum);

	                if(stages[i] > N) break;

	                stage = stages[i];
	                sum -= target;
	                
	                if(sum == 0) break;
	                
	                target = 1;
	            }
	            if(i == stages.length-1) {
	                map.put(stage, (double)target/sum);
	            }
	        }

	        List<Entry<Integer, Double>> list_entries = new ArrayList<Map.Entry<Integer,Double>>(map.entrySet());

	        Collections.sort(list_entries, new Comparator<Entry<Integer, Double>>() {

	            @Override
	            public int compare(Entry<Integer, Double> o1, Entry<Integer, Double> o2) {

	                if(o2.getValue() > o1.getValue())
	                    return 1;
	                else if(o2.getValue() < o1.getValue())
	                    return -1;
	                else
	                    return o1.getKey() - o2.getKey();
	            }
	        });
	        int i = 0;
	        for(Entry<Integer, Double> entry : list_entries) {
	            answer[i++] = entry.getKey();
	        }


	        return answer;
	    }
	}
	
	public static void main(String[] args) {
		Solution s = new Solution();
		int N = 4;
		int[] stages = {1, 2, 3, 3};
		System.out.println(Arrays.toString(s.solution(N, stages))); 

	}

}
