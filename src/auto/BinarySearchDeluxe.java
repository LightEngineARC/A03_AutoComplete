package auto;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
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
    	//FIXME Not working if the key is in the 0th index
    	//used algs4.jar binarysearch as a template and modified to work with generic keys
    	throwException(a, key, comparator);
    	int lo = 0;
    	int hi = a.length;
    	if(comparator.compare(a[0], key)==0)
    		return 0;
    	while(lo <= hi) {
    		int mid = lo + (hi - lo) / 2;
    		int comp = comparator.compare(a[mid], key);
    		
    		if (comp > 0) hi = mid - 1; // comp returned 1 reset the hi
    		else if (comp < 0) lo = mid + 1; // if comp returns -1 reset the lo
    		else if (comparator.compare(a[mid - 1], a[mid]) == 0) hi = mid - 1;//'key' found, find first index of 'key'
    		else return mid;
    	}
		return -1;    	
    }

	private static <Key> void throwException(Key[] a, Key key, Comparator<Key> comparator) {
		if(a ==null || key == null || comparator == null) {
    		throw new java.lang.NullPointerException("Can not have any null arguments: (Key[], key, comparator)");
    	}
	}

    // Return the index of the last key in a[] that equals the search key, or -1 if no such key.
    public static <Key> int lastIndexOf(Key[] a, Key key, Comparator<Key> comparator) {
    	//FIXME not working if the Key is in the last position of the array
    	//used algs4.jar binarysearch as a template and modified to work with generic keys
    	throwException(a, key, comparator);
    	int lo = 0;
    	int hi = a.length;
    	if(comparator.compare(a[a.length-1],key)==0)
    		return a.length-1;
    	while(lo <= hi) {
    		int mid = lo + (hi - lo) / 2;
    		int comp = comparator.compare(a[mid], key);
    		
    		if (comp > 0) hi = mid - 1;
    		else if (comp < 0) lo = mid + 1;
    		else if (comparator.compare(a[mid + 1], a[mid]) == 0) lo = mid + 1; //'key' found, find the last index of 'key'
    		else return mid;
    	}
		return -1;    	
    }
    
    /*==========================================================
     * Used for Testing- Test client code provided in video.
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
    	
//    	for(int i = 0; i<intsObj.length; i++) {
//    		System.out.println(intsObj[i]);
//    	}

    	Arrays.sort(intsObj, intComp);
    	
    	int first10 = firstIndexOf(intsObj, 10, intComp); //causing index out of bounds error because this is the first index in the array
    	int last10 = lastIndexOf(intsObj, 10, intComp);
    	int first30 = firstIndexOf(intsObj, 30, intComp);
    	int last30 = lastIndexOf(intsObj, 30, intComp);
    	int first90 = firstIndexOf(intsObj,90,intComp);
    	int last90 = lastIndexOf(intsObj, 90, intComp); // causing index out of bounds error because this is the last index in the array
    	
    	System.out.println(first10); //results should be 0
    	System.out.println(last10);// results should be 1
    	
    	System.out.println(first30); //results should be 3
    	System.out.println(last30);// results should be 5
    	
    	System.out.println(first90);// 12
    	System.out.println(last90);// 14
    	//System.out.println(intsObj[14]);
    }
}