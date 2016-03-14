import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class WhichJavaCollections {

	public static void main(String[] args) {
		
		// Which Java Collections to use
		// Consider insertion / deletion, retrieval and traversal
		// This code I wrote is from http://courses.caveofprogramming.com
		// Thanks for great free videos.
		
		// =======================================
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
		// It manages array
		// [0][1][2][3][4]...
		// Time complexity - Adding O(n)
		List<String> list1 = new ArrayList<String>();
		
		
		// Removing or adding items elsewhere in the list, use LinkedList
		// It manages a double linked list which has a reference to previous and next elements
		// [0]<->[1]<->[2]<->[3]<->[4]...
		// Time complexity - Adding O(1)
		List<String> list2 = new LinkedList<String>();
		
		
		
		// =======================================
		// 2. SET
		// Only store unique values.
		// Great for removing duplicates.
		// Not indexed like lists.
		// Very fast to check if a particular object exists.
		// If you want to use your own objects, you must implement hashCode() and equals().
		
		
		// Order is unimportant and okay if it changes.
		// HashSet is not ordered.
		Set<String> set1 = new HashSet<String>();
		
		// Sorted in natural order. Use TreeSet - must implement Comparable for custom types.
		// (1,2,3 ... , a,b,c ... )
		Set<String> set2 = new TreeSet<String>();
		
		// Elements remain in order they wear added.
		Set<String> set3 = new LinkedHashSet<String>();
		
		
		
		// =======================================
		// 3.MAP
		// <Key, Value> pairs.
		// Like lookup tables.
		// Retrieving a value by key is fast.
		// Iterating over map values is very slow.
		// Maps not really optimized for iteration
		// If you want to use your own objects as keys, you must implement hashCode() and equals().
		
		// Keys not in any particular order.
		// No guarantee the order even if sometimes show it by ordering.
		Map<Integer, String> map1 = new HashMap<Integer, String>();
		
		// Keys sorted in natural order.
		Map<Integer, String> map2 = new TreeMap<Integer, String>();
		
		// Keys remain in order added.
		Map<Integer, String> map3 = new LinkedHashMap<Integer, String>();
		
	}

}
