package auto;

import java.util.Comparator;

import edu.princeton.cs.algs4.Heap;
import edu.princeton.cs.algs4.Insertion;
import edu.princeton.cs.algs4.Merge;

/*
 * Part 1: autocomplete term. Write an immutable data type Term.java that represents an autocomplete term: 
 * a string query and an associated real-valued weight. 
 * 
 * You must implement the following API, which supports
 * comparing terms by three different orders: 
 *  
 *  lexicographic order by query string (the natural order); 
 *  in descending order by weight (an alternate order); 
 *  and lexicographic order by query string but using only the first r characters (a family of alternate orderings). 
 *  The last order may seem a bit odd, but you 
 *  will use it in Part 3 to find all terms that start with a given prefix (of length r).
 *   
 *   The constructor should throw a java.lang.NullPointerException if query is null and a 
 *   java.lang.IllegalArgumentException unless weight is nonnegative. The byPrefixOrder() method should 
 *   throw a java.lang.IllegalArgumentException if r is negative.
 */
public class Term implements Comparable<Term> {
	private String query;
	private double weight;

    // Initialize a term with the given query string and weight.
    public Term(String query, double weight) {
    	if(query==null) 
    		throw new IllegalArgumentException("query must be not null");
    	if(weight<0) 
    		throw new IllegalArgumentException("Weight must be positive");
    	this.query = query;
    	this.weight = weight;
    }

    // Compare the terms in descending order by weight.
    public static Comparator<Term> byReverseWeightOrder(){
    	return new Comparator<Term>(){
            public int compare(Term first, Term second) {
                if (first.weight > second.weight) {
                    return -1;
                } else if (first.weight == second.weight) {
                    return 0;
                } else {
                    return 1;
                }
            } 
        };
        
    }

    // Compare the terms in lexicographic order but using only the first r characters of each query.
    public static Comparator<Term> byPrefixOrder(int length){
    	final int r = length;
        return new Comparator<Term>(){
            public int compare(Term t1, Term t2) {
                String s1 = t1.query;
                String s2 = t2.query;
                int minlength = s1.length() < s2.length() ? s1.length() : s2.length();
                if (minlength >= r) {
                    return s1.substring(0, r).compareTo(s2.substring(0, r));
                } else if (s1.substring(0, minlength).compareTo(s2.substring(0, minlength)) == 0) {
                    if (s1.length() == minlength) return -1;
                    else return 1;
                } else return s1.substring(0, minlength).compareTo(s2.substring(0, minlength));
            } 
        };
        
    }

    // Compare the terms in lexicographic order by query.
    public int compareTo(Term that) {
		return this.getQuery().compareTo(that.getQuery());
    }

    /**
     * Return a string representation of the term in the following format:
     * the weight, followed by a tab, followed by the query.
     */
    public String toString() {
		return " " + this.weight + "	" + this.query ; //FIXME
    }

	private String getQuery(){
		return query;
	}

	private double getWeight(){
		return weight;
	}
	
	/**
	 * Supposed to return a comparator for descending order by weight.
	 */
	private class ByReverse implements Comparator<Term> {
		@Override
		public int compare(Term arg0, Term arg1){
			//TODO TEST THIS
			return (int) (arg1.getWeight() - arg0.getWeight());
		}
	}
	/**
	 * Supposed to return a comparator for descending order by prefix.
	 */
	private class byPrefixOrder implements Comparator<Term> {
		int r;
		
		public byPrefixOrder(int r) {
			this.r=r;
		}
		
		@Override
		public int compare(Term arg0, Term arg1){
			//FIXME missing a way to check substrings
			return (int) (arg1.getQuery().substring(r).compareTo(arg0.getQuery().substring(r)));
		}
	}
	
	/* -----------------------------------------------------------------------
	 * TEST CLIENT
	 * -----------------------------------------------------------------------
	 */
	public static void main(String[] args) {
		
		Term a2 = new Term("A",2);
		Term b1 = new Term("B",1);
		
		assert (a2.compareTo(b1)<0);//initial compare based on natural order
		
		Term[] tray = {b1,a2};
		System.out.println(tray[0]+" "+ tray[1]);
		assert (tray[0].compareTo(tray[1])<0);//adding to the array out of order
		Merge.sort(tray);//sort the array on natural order
		assert (tray[0].compareTo(tray[1])>0);
		
		Comparator<Term> comp = a2.new ByReverse();
		Insertion.sort(tray, comp);
		System.out.println(tray[0]+" "+ tray[1]);
		assert (tray[0].compareTo(tray[1])<0);
		
		Comparator<Term> comp2 = a2.new byPrefixOrder(1);
		Insertion.sort(tray, comp2);
		assert (tray[0].compareTo(tray[1])<0);
		System.out.println(tray[0]+" "+ tray[1]);
		
		System.out.println("\ntests pass\n");
	}
}



