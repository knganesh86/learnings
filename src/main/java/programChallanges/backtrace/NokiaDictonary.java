package programChallanges.backtrace;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class NokiaDictonary {
	public static void main(String[] args) {
		HashMap<Character, Set<Character>> map = new HashMap<>();
		for(int i=1;i<9;i++) {
			char x=(char)(48+i+1);
			Set<Character> a = map.computeIfAbsent(x, k->new HashSet<Character>());
			char c = (char)((i-1)*3+97);
			if(i>6) {
				c++;
			}
			a.add(c);
			a.add((char)(c+1));
			a.add((char)(c+2));
			if(i==6|| i==8) {
				a.add((char)(c+3));
			}
		}
		map.computeIfAbsent('0', k->new HashSet<Character>()).add('0');
		map.computeIfAbsent('1', k->new HashSet<Character>()).add('1');
		ArrayList<String> result = new ArrayList<>();
		calculateCombo("9".toCharArray(), 0, "", map, result);
		
		System.out.println(result);
	
	}

	private static void calculateCombo(char[] charArray, int i, String str, HashMap<Character, Set<Character>> map, ArrayList<String> result) {
		if(i==charArray.length) {
			
			result.add(str);
			return;
		}
		Set<Character> charSet = map.get(charArray[i]);
		for( char c: charSet) {
			calculateCombo(charArray, i+1, str+c, map, result);
		}
	}
}
