import java.lang.reflect.Array;
import java.util.Arrays;

/*Program SortedIntList.java
-------------------------*/
// Class SortedIntList can be used to store a list of integers.

public class SortedIntList {
    private int[] elementData; // list of integers
    private int size;          // current number of elements in the list
    private boolean unique;    //boolean if uniqueness is allowed in array or not
    
    public static final int DEFAULT_CAPACITY = 100;
    
    public void sort(int[] elementData){
    	Arrays.sort(elementData);
    }
    
    //binary search method
    public int BinarySearch(int chosenNumber) {
    	int index = Arrays.binarySearch(elementData, 0, size, chosenNumber);
    	return index;
    }
    
    public void display() {    // display array contents
    	for(int j=0; j<size; j++)
    		System.out.println(elementData[j] + " ");
    	System.out.println("");
    }
    
    
    // post: constructs an empty list of default capacity
    public SortedIntList() {
        this(DEFAULT_CAPACITY);
    }
    
    
    // pre : capacity >= 0
    // post: constructs an empty list with the given capacity
    public SortedIntList(int capacity) {
        elementData = new int[capacity];
        size = 0;
    }

    // post: returns the current number of elements in the list
    public int size() {
        return size;
    }

    // pre : 0 <= index < size()
    // post: returns the integer at the given index in the list
    public int get(int index) {
        return elementData[index];
    }

    // post: creates a comma-separated, bracketed version of the list
    public String toString() {
        if (size == 0) {
            return "[]";
        } else {
            String result = "[" + elementData[0];
            for (int i = 1; i < size; i++)
                result += ", " + elementData[i];
            result += "]";
            return result;
        }
    }

    // post : returns the position of the first occurence of the given
    //        value (-1 if not found)
    public int indexOf(int value) {
    	int index = Arrays.binarySearch(elementData, 0, size, value);
    		if (index >= 0) {
    			System.out.println("Found " + value + " at element " + index);
    			return index;
    		} else {
    			System.out.println("Sorry, cannot find the element " + value + ".");
    			return index;
    		}
    }

    // pre : size() < capacity (elementData.length)
    // post: appends the given value to its appropriate spot.
    public void add(int value) {
	    if (getUnique() == false)	{  						//unique doesn't matter
    		int i;
	    	for (i=0; i<size; i++) 					//try to find where it goes
	    		if(elementData[i] > value)
	    			break;
	    	for(int j=size; j>i; j--)  				//shuffle up
	    		elementData[j] = elementData[j-1];
	    	elementData[i] = value;					//insert it
	    	size++;
	    	System.out.println(value + " has been added!");
	    } else {
	    	if (BinarySearch(value) < 0){
		    	int i;
		    	for (i=0; i<size; i++) 					//try to find where it goes
		    		if(elementData[i] > value)
		    			break;
		    	for(int j=size; j>i; j--)  				//shuffle up
		    		elementData[j] = elementData[j-1];
		    	elementData[i] = value;					//insert it
		    	size++;
		    	System.out.println(value + " has been added!");
	    	} else {
	    		System.out.println(value + " is already in the array!");
	    	}
	    }
    }

    // pre: size() < capacity (elementData.length) && 0 <= index <= size()
    // post: inserts the given value at the given index, shifting subsequent
    //       values right
    private void add(int index, int value) {
        for (int i = size; i > index; i--)
            elementData[i] = elementData[i - 1];
        elementData[index] = value;
        size++;
    }

    // pre : 0 <= index < size()
    // post: removes value at the given index, shifting subsequent values left
    public void remove(int index) {
        for (int i = index; i < size - 1; i++)
            elementData[i] = elementData[i + 1];
        size--;
    }
    
    public boolean getUnique() {
    	System.out.println("Uniqueness is " + unique + ".");
    	return unique;
    }
    
    public void setUnique(boolean value) {  // Toggle uniqueness in array. Needs to delete any copies of vaules if set to true.
    	unique = value;
    	if (value = true){			//need to delete duplicates in array.
    		
    	}
    }
}

class SortedIntListApp {
	public static void main(String[] args)
	{
		int maxSize = 100;
		SortedIntList arr;
		arr = new SortedIntList(maxSize);
		
		arr.setUnique(true);
		
		arr.add(12);
		arr.add(54);
		arr.add(38);
		arr.add(97);
		arr.add(11);
		arr.add(3);
		arr.add(11111);
		arr.add(11111);
		
		arr.display();
		
		int chosenNumber = 38;
		if( arr.BinarySearch(chosenNumber) >= 0)
			System.out.println("Found " + chosenNumber);
		else
			System.out.println("Can't find " + chosenNumber);
		
		int chosenNumber2 = 77;
		if( arr.BinarySearch(chosenNumber2) >= 0)
			System.out.println("Found " + chosenNumber2);
		else
			System.out.println("Can't find " + chosenNumber2);
		
		int value = 12;
		arr.indexOf(value);
		
		int value2 = 44;
		arr.indexOf(value2);
		
		arr.size();
		arr.setUnique(false);
		arr.add(11111);
		
		arr.setUnique(true);
		arr.display();
	}	
}