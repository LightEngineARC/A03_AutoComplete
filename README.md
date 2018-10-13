/******************************************************************************
 *  Name:     Ashton Chatelain
 *
 *  Partner Name:  Joseph Dimmick        
 *
 *  Hours to complete assignment (optional):
 *
 ******************************************************************************/

Programming Assignment 3: Autocomplete


/******************************************************************************
 *  Describe how your firstIndexOf() method in BinarySearchDeluxe.java
 *  finds the first index of a key that equals the search key.
 *****************************************************************************/
this is a modified version of the algs4 binary search with 2 major modifications. 

1.uses an If statement to catch the special case where arr[0] and key are equal (we found without this we get an index out of bounds error).
2. we compare our mid and mid-1 positions to see if they are equal. If true (or comp returns 0) we reset the hi value to mid-1. until we find an index where mid == key but mid -1 != key. that is how we know we have the first idex of the key.

/******************************************************************************
 *  What is the order of growth of the number of compares (in the
 *  worst case) that each of the operations in the Autocomplete
 *  data type make, as a function of the number of terms n and the
 *  number of matching terms m?
 *
 *  Recall that with order-of-growth notation, you should discard
 *  leading coefficients and lower-order terms, e.g., m^2 + m log n.
 *****************************************************************************/

constructor: N log N

allMatches(): log N 

numberOfMatches(): log N




/******************************************************************************
 *  Known bugs / limitations.
 *****************************************************************************/


/******************************************************************************
 *  Describe whatever help (if any) that you received.
 *  Don't include readings, lectures, and precepts, but do
 *  include any help from people (including course staff, lab TAs,
 *  classmates, and friends) and attribute them by name.
 *
 *  Also include any resources (including the web) that you may
 *  may have used in creating your design.
 *****************************************************************************/
Joe - https://stackoverflow.com/questions/4948162/how-can-i-better-understand-the-one-comparison-per-iteration-binary-search

this stackoverflow topic got me started down the path after i used the algs4 binary search as a template. Had to seek help to figure out how to use a comparator with a generic key. help with that was provided by one Elson Huang.

Ashton - Niles gave me advice in class to focus on learning comparators.

/******************************************************************************
 *  Describe any serious problems you encountered.                    
 *****************************************************************************/
Joe- I had difficulty using comparator with a generic. also needed input to overcome a couple of indexoutofbounds errors.

/******************************************************************************
 *  If you worked with a partner, assert below that you followed
 *  the protocol as described on the assignment page. Give one
 *  sentence explaining what each of you contributed.
 *****************************************************************************/
Joe- Worked on the BinarySearchDeluxe and had to seek some insight from Ashton on a
bug that was happening.

Ashton implemented Term and Autocomplete. 
/******************************************************************************
 *  List any other comments here. Feel free to provide any feedback   
 *  on how much you learned from doing the assignment, and whether    
 *  you enjoyed doing it.                                             
 *****************************************************************************/
I would like to Thank Ashton for teaching me how to use GitHub with this project and hooking me up with a decent list of commands to work with. 
  