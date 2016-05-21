import java.util.HashMap;

public class StringUtil {

	public static Character findNonRepeated(String str) {

		HashMap<Character, Integer> charHash = new HashMap<Character, Integer>();

		Character c;
		for (int i = 0; i < str.length(); i++) {
			c = str.charAt(i);
			if (charHash.containsKey(c))
				charHash.put(c, charHash.get(c) + 1);
			else
				charHash.put(c, 1);
		}
		for (int i = 0; i < str.length(); i++) {
			c = str.charAt(i);
			if (charHash.get(c) == 1)
				return c;
		}
		return null;
	}
	
	
}
