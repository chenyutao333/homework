import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class homework3 {
	public static Map<String, Integer> map = new HashMap<String, Integer>();
	public static boolean check(String s,Map<String, Integer> map) {
		Iterator<String> iterator = map.keySet().iterator();
		while (iterator.hasNext()) {
			if(s.equals(iterator.next())) {
				return true;
			}
		}
		return false;
	}
	public static Map<String, Integer> count(String[] s){
		for(int i=0;i<s.length;i++) {
			if(!check(s[i],map)){
				map.put(s[i], (Integer)1);
			}else {
				int n =1 + map.get(s[i]);
				map.remove(s[i]);
				map.put(s[i], (Integer)n);
			}	
		}
		return map;
	}
	public static void main(String[] args) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		
		map = count(args);
		Iterator<String> iterator = map.keySet().iterator();
		while (iterator.hasNext()) {
		    String key = iterator.next();
		    System.out.println(key + "¡¡= " + map.get(key));
		}
	}

}
