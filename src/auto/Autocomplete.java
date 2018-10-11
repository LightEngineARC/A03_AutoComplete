package auto;

import edu.princeton.cs.algs4.Merge;

/*
 * Part 3: autocomplete. In this part, you will implement an immutable data type that 
 * provides autocomplete functionality for a given set of string and weights, using Term 
 * and BinarySearchDeluxe. To do so, sort the terms in lexicographic order; use binary search
 *  to find the set of terms that start with a given prefix; and sort the matching terms in 
 *  descending order by weight. Organize your program by creating an immutable data type 
 *  Autocomplete with the following API:
 * 
 * Corner cases.  The constructor and each method should throw a 
 * java.lang.NullPointerException its argument is null.
 * Performance requirements.  
 * The constructor should make proportional to N log N compares (or better) in the worst case,
 *  where N is the number of terms.
 * The allMatches() method should make proportional to log N + M log M compares (or better) 
 * in the worst case, where M is the number of matching terms. The numberOfMatches() method
 *  should make proportional to log N compares (or better) in the worst case. In this context,
 *   a compare is one call to any of the compare() or compareTo() methods defined in Term.
 */
public class Autocomplete {
	private Term[] terms;

    // Initialize the data structure from the given array of terms.
    public Autocomplete(Term[] terms) {
    	if(terms==null)
    		throw new java.lang.NullPointerException("Array of Terms cannot be null");
    	Merge.sort(terms);
    	this.terms = terms;
    }

    // Return all terms that start with the given prefix, in descending order of weight.
    public Term[] allMatches(String prefix) {
    	int len = prefix.length();
		return null;//FIXME
    }

    // Return the number of terms that start with the given prefix.
    public int numberOfMatches(String prefix) {
    	int first = BinarySearchDeluxe.firstIndexOf(terms, key, terms[0].byPrefixOrder(prefix.length()));//TODO creating comparator may need to be static
    	int last = BinarySearchDeluxe.lastIndexOf(terms, key, terms[0].byPrefixOrder(prefix.length()));//TODO creating comparator may need to be static
		return last-first;//FIXME
    	
    }
}
