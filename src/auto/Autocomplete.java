package auto;

import java.util.Arrays;

import edu.princeton.cs.algs4.Merge;

/*
 * Part 3: autocomplete. In this part, you will implement an immutable data type that 
 * provides autocomplete functionality for a given set of string and weights, using Term 
 * and BinarySearchDeluxe. 
 * 
 * To do so, sort the terms in lexicographic order;
 *  use binary search to find the set of terms that start with a given prefix;
 *   and sort the matching terms in descending order by weight. 
 *   Organize your program by creating an immutable data type Autocomplete

 */
public class Autocomplete {
	private final Term[] terms;

    // Initialize the data structure from the given array of terms.
    public Autocomplete(Term[] terms) {
    	if(terms==null)
    		throw new java.lang.NullPointerException("Array of Terms cannot be null");
    	Merge.sort(terms);
    	this.terms = terms.clone();
    }

    // Return all terms that start with the given prefix, in descending order of weight.
    public Term[] allMatches(String prefix) {
    	if (prefix == null) {
    		throw new java.lang.NullPointerException();
    	}
    	Term temp = new Term(prefix, 0);

    	int start = BinarySearchDeluxe.firstIndexOf(terms, temp, Term.byPrefixOrder(prefix.length()));
    	int end = BinarySearchDeluxe.lastIndexOf(terms, temp, Term.byPrefixOrder(prefix.length()));
    	if (start == -1 || end == -1) {
    		throw new java.lang.NullPointerException();
    	}
		Term[] matches = new Term[end - start + 1];
		matches = Arrays.copyOfRange(terms, start, end);
		Arrays.sort(matches, Term.byReverseWeightOrder());
		return matches;

    }

    // Return the number of terms that start with the given prefix.
    public int numberOfMatches(String prefix) {
    	if (prefix == null) {
    		throw new java.lang.NullPointerException();
    	}
    	Term term = new Term(prefix, -1);
    	int first = BinarySearchDeluxe.firstIndexOf(terms, term, Term.byPrefixOrder(prefix.length()));
    	int last = BinarySearchDeluxe.lastIndexOf(terms, term, Term.byPrefixOrder(prefix.length()));
		return last-first;
    	
    }
    
    /*
     * ===========================================
     * TEST CLIENT
     * ===========================================
     */
    public static void main(String[] args) {
    	//Create array of new terms
    	Term[] terms = {new Term("test",6.0 ), new Term("test2", 7),new Term("tes", 8),new Term("te", 9)};
    	//add array to an Autocomplete object
    	Autocomplete auto = new Autocomplete(terms);
    	
    	//Test various prefixes.
    	assert (auto.numberOfMatches("t")==4);
    	assert (auto.numberOfMatches("tes")==3);
    	assert (auto.numberOfMatches("test2")==1);
    	assert (auto.numberOfMatches("x")==0);
    	
    	//Test all matches returns an array of terms that matches what is asked for
    	Term[] testTerm = {new Term("test",6.0),new Term("test2", 7)};
    	assert (auto.allMatches("test") == testTerm);
    	assert (auto.allMatches("te") == terms);
    	assert (auto.allMatches("x").length == 0);
    	assert (auto.allMatches("").length == 4);
    	System.out.println("\nAutocomplete TESTS PASS");
    }
}
