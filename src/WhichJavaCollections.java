import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class WhichJavaCollections {

	public static void main(String[] args) {
		
		// Which Java Collections to use
		// Consider insertion / deletion, retrieval and traversal
		
		// 1. LIST
		// Store list of objects.
		// Duplicates are allowed.
		// Objects remain in order.
		// Elements are indexed by an integer.
		// cf. shopping list
		// Checking for particular item in list is slow.
		// Looking an item up by index is fast.
		// Iteration through list is relatively fast.
		// Note: You can sort lists if you want.
		
		// If you only add or remove items at end of list, use ArrayList
		List<String> list1 = new ArrayList<String>();
		
		// Removing or adding items elsewhere in the list, use LinkedList
		List<String> list2 = new LinkedList<String>();
		
		
		
		
		// 2. SET
		// 
		Set<String> set1 = new HashSet<String>();
		Set<String> set2 = new TreeSet<String>();
		Set<String> set3 = new LinkedHashSet<String>();
		
		
		
		
		// 3.MAP
		Map<Integer, String> map1 = new HashMap<Integer, String>();
		Map<Integer, String> map2 = new LinkedHashMap<Integer, String>();
		
		

	}

}
