package auto;
import java.util.Arrays;
import java.util.Comparator;
import edu.princeton.cs.algs4.StdOut;


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
    	throwException(a, key, comparator);
		return 0;//FIXME
    	
    }

	private static <Key> void throwException(Key[] a, Key key, Comparator<Key> comparator) {
		if(a ==null || key == null || comparator == null) {
    		throw new java.lang.NullPointerException("Can not have any null arguments: (Key[], key, comparator)");
    	}
	}

    // Return the index of the last key in a[] that equals the search key, or -1 if no such key.
    public static <Key> int lastIndexOf(Key[] a, Key key, Comparator<Key> comparator) {
    	throwException(a, key, comparator);
		return 0;//FIXME
    	
    }
    
    /*==========================================================
     * Used for Testing
     */
    private static class IntComp implements Comparator<Integer>{
		public int compare(Integer a, Integer b) {
			return a.compareTo(b);
		}
	}
    
    private static Integer[] toInteger(int[] inputInts) {
    	int N = inputInts.length;
    	Integer [] outputInts = new Integer[N];    	
    	for(int i = 0; i < N; i++) 
    		outputInts[i]= new Integer(inputInts[i]);
    	return outputInts;
    	  	
    }
    
    public static void main(String[] args) {
    	int [] ints = {10,10,20,30,30,30,40,50,60,70,70,80,90,90,90};
    	Integer[] intsObj = toInteger(ints);
    	
    	Comparator<Integer> intComp = new IntComp();
    	
    	for(int i = 0; i<intsObj.length; i++) {
    		System.out.println(intsObj[i]);
    	}
    	
    	Arrays.sort(intsObj, intComp);
    	
    	int first30 = firstIndexOf(intsObj, 30, intComp);
    	int last30 = lastIndexOf(intsObj, 30, intComp);
    }
}