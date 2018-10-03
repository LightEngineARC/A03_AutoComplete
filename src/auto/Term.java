package auto;
import java.util.Comparator;
/*
 * Part 1: autocomplete term. Write an immutable data type Term.java that represents an autocomplete term: 
 * a string query and an associated real-valued weight. You must implement the following API, which supports
 *  comparing terms by three different orders: lexicographic order by query string (the natural order); in 
 *  descending order by weight (an alternate order); and lexicographic order by query string but using only
 *   the first r characters (a family of alternate orderings). The last order may seem a bit odd, but you 
 *   will use it in Part 3 to find all terms that start with a given prefix (of length r).
 *   
 *   The constructor should throw a java.lang.NullPointerException if query is null and a 
 *   java.lang.IllegalArgumentException unless weight is nonnegative. The byPrefixOrder() method should 
 *   throw a java.lang.IllegalArgumentException if r is negative.
 */
public class Term implements Comparable<Term> {

    // Initialize a term with the given query string and weight.
    public Term(String query, double weight) {
    	//TODO
    	
    }

    // Compare the terms in descending order by weight.
    public static Comparator<Term> byReverseWeightOrder(){
		return null;//FIXME
    	
    }

    // Compare the terms in lexicographic order but using only the first r characters of each query.
    public static Comparator<Term> byPrefixOrder(int r){
		return null;//FIXME
    	
    }

    // Compare the terms in lexicographic order by query.
    public int compareTo(Term that) {
		return 0;//FIXME
    	
    }

    // Return a string representation of the term in the following format:
    // the weight, followed by a tab, followed by the query.
    public String toString() {
		return null; //FIXME
    	
    }
}
