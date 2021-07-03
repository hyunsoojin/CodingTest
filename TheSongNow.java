package programmers;

import java.util.ArrayList;
import java.util.Comparator;

public class TheSongNow {
	static class Music{
		int time;
		int index;
		String music;
		String sheet;
		public Music(int time, int index, String music, String sheet) {
			this.time = time;
			this.index = index;
			this.music = music;
			this.sheet = sheet;
		}
	}
	public static String addSheet(int time, String sheet) {
		
		StringBuffer sb = new StringBuffer();
		for(int j=0;sb.length()<time;) {
			j %= sheet.length();
			if(j+1 <sheet.length() && sheet.charAt(j+1) == '#') {
				sb.append(Character.toLowerCase(sheet.charAt(j)));
				j+=2;
			}else {
				sb.append(sheet.charAt(j++));
			}
		}
		return sb.toString();
	}
	public static String addSheet(String sheet) {
		StringBuffer sb = new StringBuffer();
		for(int j=0;j<sheet.length();) {
			if(j+1 <sheet.length() && sheet.charAt(j+1) == '#') {
				sb.append(Character.toLowerCase(sheet.charAt(j)));
				j+=2;
				continue;
			}
			sb.append(sheet.charAt(j));
			j++;
		}
		return sb.toString();
	}
	
	public static void main(String[] args) {
		
		String m = "CC#BCC#BCC#BCC#B";
		String[] musicinfos = {"03:00,03:30,FOO,CC#B", "04:00,04:08,BAR,CC#BCC#BCC#B"};
		
		ArrayList<Music> list = new ArrayList<>();
		
		Comparator<Music> myComp = new Comparator<>() {
			@Override
			public int compare(Music o1, Music o2) {
				if(o1.time != o2.time) return o2.time - o1.time;
				else return o1.index - o2.index;
			}
		};
		
		for(int i=0;i<musicinfos.length;i++) {
			//0 1 2 3
			String[] arr = musicinfos[i].split(",");
			int time = (Integer.parseInt(arr[1].split(":")[0]) - Integer.parseInt(arr[0].split(":")[0])) * 60;
			time += Integer.parseInt(arr[1].split(":")[1]) - Integer.parseInt(arr[0].split(":")[1]);
			String sheet = addSheet(time, arr[3]);
			
			list.add(new Music(time, i, arr[2], sheet));
			
		}
		
		m = addSheet(m);
		ArrayList<Music> result = new ArrayList<>();
		for(Music music  : list) {
			if(music.sheet.contains(m)) result.add(music);  
		}
		if(result.size() == 0) System.out.println("None");
		else {
			result.sort(myComp);
			System.out.println(result.get(0).music); 
		}
	}

}
