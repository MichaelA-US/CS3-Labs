public class RunnerLol
{
	public static void main(String[] args) 
	{
		MinHeap heap = new MinHeap();
		
		int[] nums = {8, 42, 35, 4, -1, 99, 76, 20};
		
		for (int i = 0; i < nums.length; i++) 
			heap.insert(nums[i]);
		
		System.out.println("Heap toString: " + heap);
		System.out.println("\ninitial state of the heap");
		heap.display();
		
		heap.insert(36); System.out.println("inserting 36 into the heap...");
		heap.display();
		
		heap.insert(3); System.out.println("inserting 3 into the heap...");
		heap.display();
		
		System.out.println("Pop min (new min at root) = " + heap.popMinimum());
		heap.display();

		System.out.println("Peek min (shouldn't change) = " + heap.peekMinimum());
		heap.display();
		
		heap = new MinHeap(); 
		heap.insert(2);
		heap.insert(5);
		heap.insert(6);
		heap.insert(7);
		heap.insert(456);
		heap.insert(23);
		heap.insert(88);
		heap.display();
	}
}
