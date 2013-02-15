package com.bengreenier.utils.core;


public class Sorters {

	//call this method
	public static <T> T[] quicksort(SorterCondition<T> sc, T[] array) {
		if (array == null)
			return array;
		else if (array.length <= 1)
			return array;

		return quicksort(sc,array,0,array.length-1,(int)(array.length/2));
	}

	//the "call this" method, calls this recursively, internally. this is the magic
	private static <T> T[] quicksort(SorterCondition<T> sc, T[] array, int left, int right, int pivot) {
		int i=left,j=right;
		while (i <= j) {
			// If the current value from the left list is smaller then the pivot
			// element then get the next element from the left list
			while (sc.isLess(array[i], array[pivot])) {
				i++;
			}
			// If the current value from the right list is larger then the pivot
			// element then get the next element from the right list
			while (sc.isMore(array[j], array[pivot])) {
				j--;
			}


			// If we have found a values in the left list which is larger then
			// the pivot element and if we have found a value in the right list
			// which is smaller then the pivot element then we exchange the
			// values.
			// As we are done we can increase i and j
			if (i <= j) {

				//exchange
				T temp = array[i];
			    array[i] = array[j];
			    array[j] = temp;
			    
				i++;
				j--;
			}
		}
		
		// Recursion---poor recursion. doesn't work right.
		if (left < j)
			return quicksort(sc,array,left, j,pivot);

		if (i < right)
			return quicksort(sc,array,i, right,pivot);

		return array;
		
	}



	public static void main(String[] args) {
		Integer[] test = new Integer[]{6,3,4,2,1,5};

		Integer[] res = quicksort(new SorterCondition<Integer>(){
			//define the logic of the evaluations, what we check to do the swaps

			@Override
			public boolean isLess(Integer element, Integer compare) {
				return (element.intValue() < compare.intValue()) ? true : false;
			}

			@Override
			public boolean isMore(Integer element, Integer compare) {
				return (element.intValue() > compare.intValue()) ? true : false;
			}

			@Override
			public boolean isEqual(Integer element, Integer compare) {
				return (element.intValue() == compare.intValue()) ? true : false;
			}},test);

		for (Integer i : res)
			System.out.println(i);
	}
}
