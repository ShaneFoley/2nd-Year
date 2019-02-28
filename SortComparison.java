

/**
 *  This class contains static methods that implementing sorting of an array of numbers
 *  using different sort algorithms.
 *
 *  @author Shane Foley
 *  @version HT 2019
 */


 class SortComparison {
	 //Use comparable T to use ints and chars (only used in partition)
	 //may be redundant if all using doubles
    /**
     * Sorts an array of doubles using InsertionSort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     * @param a: An unsorted array of doubles.
     * @return array sorted in ascending order.
     *
     */
	 static double[] insertionSort (double a[]){
    	double temp;
    	if(a==null) {
    		return a;
    	}
		for (int i = 1; i < a.length; i++) 
		{
			for(int j = i ; j > 0 ; j--)
			{
				if(a[j] < a[j-1])	//if it is less then an preceding entry
				{
					temp = a[j];	//swap 
					a[j] = a[j-1];
					a[j-1] = temp;
				}
			}
		}
		return a;
    }

    /**
     * Sorts an array of doubles using Quick Sort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     * @param a: An unsorted array of doubles.
     * @return array sorted in ascending order
     *
     */
	 static double[] quickSort(double a[]){
		 if(a==null) {
			 return a;
		 }
		 else {
			 quickSortRecursion(a,0,a.length-1);
			 return a;
		 }
	 }
    private static void quickSortRecursion (double a[],double lo, double hi){
    	//recursive implementation of quickSort

    	if(hi <= lo) {
    		return;
    		}
    	int pivot = partition(a, lo, hi);
    	quickSortRecursion(a, lo, pivot-1);
    	quickSortRecursion(a, pivot+1, hi);
    }

    private static int partition(double[] numbers, double lo, double hi) {
    	//find the pivot in quickSort
    	//the int casts for the double array
    	int i = (int) lo;
    	int j = (int) (hi+1);
    	double pivot = numbers[(int) lo];
    	while(true) {
    		while(numbers[++i]<pivot) {
    			if(i == hi) {
    				break;
    			}
    		}
    		while(pivot<numbers[--j]) {
    			if(j == lo) {
    				break;
    			}
    		}
    		if(i >= j) {
    			break;
    		}
    		double temp = numbers[i];
    		numbers[i] = numbers[j];
    		numbers[j] = temp;
    		}
    	numbers[(int) lo] = numbers[j];
    	numbers[j] = pivot;
    	return j;
    	}
    /**
     * Sorts an array of doubles using Merge Sort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     * @param a: An unsorted array of doubles.
     * @return array sorted in ascending order
     *
     */
    /**
     * Sorts an array of doubles using iterative implementation of Merge Sort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     *
     * @param a: An unsorted array of doubles.
     * @return after the method returns, the array must be in ascending sorted order.
     */

    public static double[] mergeSortIterative (double a[]) {
      	if(a==null) {
    		return a;
    	}
    	mergeSortIterativeSort(a);
    	return a;
    }
    
    private static void mergeSortIterativeSort(double[] a) {
    	int N = a.length;
    	double[] copy = new double[N];
    	for(int k=1;k<N;k=k+k) {
    		for(int lo=0;lo<N-k;lo+=k+k) {
    			mergeSortIterativeMerge(a,copy,lo,lo+k-1,Math.min(lo+k+k-1, N-1));
    		}
    	}
    }
    
    private static void mergeSortIterativeMerge(double[]a,double[]copy,int lo,int mid, int hi) {
    	for(int k=lo;k<=hi;k++) {
    		copy[k]=a[k];
    	}
    	int i=lo;
    	int j=mid+1;
    	for(int k=lo;k<=hi;k++) {
    		if(i>mid) {
    			a[k] = copy[j++];
    		}else if(j>hi){
    			a[k]=copy[i++];
    		}else if(copy[j]<copy[i]) {
    			a[k]=copy[j++];
    		}else {
    			a[k]=copy[i++];
    		}
    	}
    }
    
    
    /**
     * Sorts an array of doubles using recursive implementation of Merge Sort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     *
     * @param a: An unsorted array of doubles.
     * @return after the method returns, the array must be in ascending sorted order.
     */
    public static double[] mergeSortRecursive (double a[]) {
    	if(a==null) {
    		return a;
    	}
    	double[] copy = new double[a.length];
    	mergeSortRecursiveSort(a,copy,0,a.length-1);
    	return a;
   }
    	
    private static void mergeSortRecursiveSort(double[]a,double[]copy,int lo,int hi) {
    	if(hi<=lo) {
    		return;
    	}
    	int mid = lo+(hi-lo)/2;
    	mergeSortRecursiveSort(a,copy,lo,mid);
    	mergeSortRecursiveSort(a,copy,mid+1,hi);
    	mergeSortRecursiveMerge(a,copy,lo,mid,hi);
    }
    
    private static void mergeSortRecursiveMerge(double[]a,double[]copy,int lo,int mid, int hi) {
    	for(int k=lo;k<=hi;k++) {
    		copy[k]=a[k];
    	}
    	int i=lo;
    	int j=mid+1;
    	for(int k=lo;k<=hi;k++) {
    		if(i>mid) {
    			a[k] = copy[j++];
    		}else if(j>hi){
    			a[k]=copy[i++];
    		}else if(copy[j]<copy[i]) {
    			a[k]=copy[j++];
    		}else {
    			a[k]=copy[i++];
    		}
    	}
    }
    
    
    /**
     * Sorts an array of doubles using Selection Sort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     * @param a: An unsorted array of doubles.
     * @return array sorted in ascending order
     *
     */
   public static double [] selectionSort (double a[]){
    	if(a==null) {
    		return a;
    	}
    	selectionSortSort(a);
    	return a;

    }

    private static void selectionSortSort(double a[]) {
    	int n = a.length;
    	// One by one move boundary of unsorted subarray
    	for (int i = 0; i < n-1; i++)
    	{
    		// minimum element in unsorted array
    		int min_idx = i;
    		for (int j = i+1; j < n; j++)
    			if (a[j] < a[min_idx]) {
    				min_idx = j;
    			}
    		// Swap the found minimum element with the first element
    		double temp = a[min_idx];
    		a[min_idx] = a[i];
    		a[i] = temp;
    	}

    }

 }
