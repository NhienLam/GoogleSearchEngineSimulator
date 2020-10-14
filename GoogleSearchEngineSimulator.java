package searchengine;

public class GoogleSearchEngineSimulator {

	/**
	 * Maintains the max-heap property
	 * @param A an array A
	 * @param i an index in array A
	 */
	public void MaxHeapify(int A[], int i, int heapsize)
	{
		int l = 2*i+1; // left child 
 		int r = 2*i+2; // right child
		int largest = i;
		
		// Check left child
		// if left child > largest
		if(l < heapsize && A[l] > A[i])
		{
			largest = l; // largest = left child 
		}
		else
		{
			largest = i;
		}
	
		//Check right child
		// if right child > largest
		if(r < heapsize && A[r] > A[largest])
		{
			largest = r; // largest = right child 
		}
		
		// largest is not the root
		if(largest != i)
		{
			// swap A[i] with A[largest]
			int temp = A[i];
			A[i] = A[largest];
			A[largest] = temp;
			
			// recursively call MaxHeapify
			MaxHeapify(A, largest, heapsize);
		}
	}
	
	/**
	 * Produces a max-heap from an unordered input array
	 * @param A an array A
	 */
	public void BuildMaxHeap(int A[])
	{
		int heapSize = A.length;
	
		//Call Max-Heapify on each element in a bottom-up manner
		for(int i = (heapSize/2)-1; i >= 0; i--)
		{
			MaxHeapify(A, i, heapSize);
		}
	}
	
	/**
	 * Sorts an array in place
	 * @param A array A
	 */
	public void Heapsort(int A[])
	{
		BuildMaxHeap(A);
		for (int i = A.length-1; i > 0; i--)
		{
			// swap A[1] with A[i]
			int temp = A[0];
			A[0] = A[i];
			A[i] = temp;
			
			MaxHeapify(A, 0, i);
		}
	}
	
	public static void main(String[] args)
	{
		int[] a = {9,8,7,6,1,2,4,5,10,100,10,0,-2,-10};
		GoogleSearchEngineSimulator gg = new GoogleSearchEngineSimulator();
		gg.Heapsort(a);
		
		for (int i=0; i<a.length; ++i) 
		{
            System.out.print(a[i]+" "); 	
         }
		System.out.println();
	}
}
