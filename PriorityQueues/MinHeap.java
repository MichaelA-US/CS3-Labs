

public class MinHeap {

    public Integer[] heap;
    private int size;
    private static final int DEFAULT_CAPACITY = 8;

    public MinHeap()
    {
       heap = new Integer[DEFAULT_CAPACITY + 1];
    }

    public MinHeap(Integer... vals)
    {
        heap = new Integer[vals.length+1];
        for (int i = 0; i < vals.length; i++)
        {
            heap[i + 1] = vals[i];
        }
        buildHeap();
    }
    private void buildHeap() 
    {
		for(int i = this.heap.length/2; i >= 1; i--) 
		{
			heapify(i);
		}
    }
    private void heapify(int index)
    {
		int temp = index;
		if(inBounds(getLeftChildIndex(index)) && heap[(index * 2)] != null && getLeftChildIndex(index) < heap[temp]) 
		{
			temp = getLeftChildIndex(index);
		}
		if(inBounds(getRightChildIndex(index)) && heap[(index * 2) + 1] != null && getRightChildIndex(index) < heap[temp]) 
		{
			temp = getRightChildIndex(index);
		}
		if(temp != index)
		{
			swap(index, temp);
			heapify(temp);
		}
	}
	private boolean inBounds(int index)
	{
		return index < size;
	}
    public void insert(int num) 
    {
        if (size == heap.length - 1) 
        {
        	doubleCapacity();
        }
        int temp = size + 1;
        heap[temp] = num;
        bubbleUp(temp);
        size++;
    }

    public int popMinimum() 
    {
        int pop = peekMinimum();
        int lastVal = heap[size];
        heap[size] = null;
        size--;
        heap[1] = lastVal;
        siftDown(1);
        return pop;
    }

    public int peekMinimum() 
    {
        return heap[1];
    }

    public int getSize() 
    {
        return size;
    }

    public boolean isEmpty() 
    {
        return size == 0;
    }

    private int getLeftChildIndex(int index) 
    {
        return index * 2;
    }

    private int getRightChildIndex(int index)
    {
        return index * 2 + 1;
    }

    private int getParentIndex(int index) 
    {
        return index / 2;
    }

    private void doubleCapacity() 
    {
        Integer[] dubArr = new Integer[heap.length * 2];
        for (int i = 1; i < heap.length; i++) 
        {
        	dubArr[i] = heap[i];
        }
        heap = dubArr;
    }

    private void bubbleUp(int index) {
        if (heap[getParentIndex(index)] == null) 
        {
        	return;
        }
        if (heap[index] < heap[getParentIndex(index)])
        {
            swap(index, getParentIndex(index));
            bubbleUp(getParentIndex(index));
        }
    }

    private void siftDown(int index) {
        if (heap[getLeftChildIndex(index)] == null && heap[getRightChildIndex(index)] == null) 
        {
        	return;
        }
        if (heap[getLeftChildIndex(index)] != null && heap[getRightChildIndex(index)] == null) 
        {
            if (heap[index] > heap[getLeftChildIndex(index)])
            {
                swap(index, getLeftChildIndex(index));
            }
            return;
        } else if (heap[getLeftChildIndex(index)] == null && heap[getRightChildIndex(index)] != null)
        {
            if (heap[index] > heap[getRightChildIndex(index)])
            {
                swap(index, getRightChildIndex(index));
            }
            return;
        }
        if (heap[index] > Math.min(heap[getLeftChildIndex(index)], heap[getRightChildIndex(index)])) 
        {
        	int sIndex = 0;
           if(heap[getLeftChildIndex(index)] < heap[getRightChildIndex(index)])
           {
        	   sIndex = getLeftChildIndex(index);
           }
           else
           {
        	   sIndex = getRightChildIndex(index);
           }
            swap(index, sIndex);
            siftDown(sIndex);
        }
    }

    private void swap(int index1, int index2)
    {
        int temp = heap[index2];
        heap[index2] = heap[index1];
        heap[index1] = temp;
    }

    @Override
    public String toString() {
        String output = "";
        for (int i = 1; i <= getSize(); i++)
            output += heap[i] + ", ";
        return output.substring(0, output.lastIndexOf(","));
    }

    public void display() {
        int nBlanks = 32, itemsPerRow = 1, column = 0, j = 1;
        String dots = "...............................";
        System.out.println(dots + dots);
        while (j <= this.getSize()) {
            if (column == 0)
                for (int k = 0; k < nBlanks; k++)
                    System.out.print(' ');
            System.out.print((heap[j] == null) ? "" : heap[j]);
            if (++column == itemsPerRow) {
                nBlanks /= 2;
                itemsPerRow *= 2;
                column = 0;
                System.out.println();
            } else
                for (int k = 0; k < nBlanks * 2 - 2; k++)
                    System.out.print(' ');
            j++;
        }
        System.out.println("\n" + dots + dots);
    }
}
