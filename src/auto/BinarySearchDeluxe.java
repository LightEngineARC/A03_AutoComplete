package auto;
import java.util.Comparator;

/*Part 2: binary search. When binary searching a sorted array that contains more than one key 
 * equal to the search key, the client may want to know the index of either the first or the 
 * last such key. Accordingly, implement the following API:
 * 
 * Corner cases.  Each static method should throw a java.lang.NullPointerException if any of its 
 * arguments is null. You should assume that the argument array is in sorted order (with respect 
 * to the supplied comparator).
 * 
 * Performance requirements.  
 * The firstIndexOf() and lastIndexOf() methods should make at most 1 + log2 N compares in the worst case.
 */
public class BinarySearchDeluxe {

    // Return the index of the first key in a[] that equals the search key, or -1 if no such key.
    public static <Key> int firstIndexOf(Key[] a, Key key, Comparator<Key> comparator) {
		return 0;//FIXME
    	
    }

    // Return the index of the last key in a[] that equals the search key, or -1 if no such key.
    public static <Key> int lastIndexOf(Key[] a, Key key, Comparator<Key> comparator) {
		return 0;//FIXME
    	
    }
}