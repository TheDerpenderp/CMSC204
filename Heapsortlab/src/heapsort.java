
public class heapsort {

	public static void main(String[] args) {
		int[] heap = {5,22,9,76,63,81,48,92,54,28};

		int index = heap.length/2-1;

		heapify(heap,index,heap.length);
		

		sort(heap,heap.length-1);
		System.out.println("NOW FOR THE SORT ________________");


	}




	private static void sort(int[] heap, int length) {
		if(length == 0)
			return;

		int temp = heap[length];
		heap[length] = heap[0];
		heap[0] = temp;
		for(int i: heap)
			System.out.print(i+"  ");
		System.out.println();
		int index = (length)/2-1;
		heapify(heap,index, length);
		
		sort(heap,length-1);
	}




	public static void heapify(int[] heap, int index, int maxSize) {

		if(index == -1)
			return;
		maxswap(heap,index, maxSize);
		for(int i: heap)
			System.out.print(i+"  ");
		System.out.println();
		heapify(heap,index-1, maxSize);
	}

	public static void maxswap(int[] heap, int index, int maxSize) {
		if(index>maxSize)
			return;

		int interestin = 0;
		if(index*2+2>=maxSize) {
			if(index*2+1>=maxSize)
				return;
			else
				interestin = heap[index*2+1];
		}
		else
			interestin = Math.max(heap[index*2+1], heap[index*2+2]);

		int indeeex = 0;
		if(interestin == heap[index*2+1]) {
			indeeex = index*2+1;
		}
		else 
			indeeex = index*2+2;

		if(heap[index]<heap[indeeex]) {
			int temp = heap[index];
			heap[index] = heap[indeeex];
			heap[indeeex] = temp;
			if(indeeex*2+1<maxSize)
				maxswap(heap,indeeex, maxSize);
		}
	}


}
