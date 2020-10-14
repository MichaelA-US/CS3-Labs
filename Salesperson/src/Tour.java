/**
 * @author Michael Ades
 * This class implements the algorithim for the "Travelling Salesman Problem" using
 * a private node class
 */
public class Tour {
	/**
	 * This class implements initializes nodes in order to represent
	 * the points to calculate the algorithm for
	 */
	private class Node
	{
		public Point p; //point var
		public Node next; //next node var

		/**
		 * Basic constructor that initializes the point and the next point to null
		 * @param p
		 */
		public Node(Point p)
		{
			this.p = p; //initalizing point var to p
			this.next = null; //next node var to null (default)
		}
	}
	public Node head; //Start of the nodes in Tour var
	private int size; //Size of all the nodes in Tour var

	/**
	 * Basic constructor for Tour that initalizes the head and the size
	 */
	public Tour()
	{
		head = null; //initalizing start of Tour (empty)
		size = 0; //initalizing size of tour (empty)
	}
	/**
	 * Secondary constructor that initializes a four point tour to test
	 * the methods
	 */
	/** create a four-point tour, for debugging */
	public Tour(Point a, Point b, Point c, Point d)
	{
		head = new Node(a); //Creating new node obj
		Node node = head; //Getting the start of Tour (test)
		node.next = new Node(b); //Next node
		node.next = new Node(c); //next
		node.next = new Node(d); //next
	}
	/**
	 * Basic print statement that shows that the coordinates are working in
	 * the Tour
	 */
	/** print tour (one point per line) to std output */
	public void show()
	{
		Node temp = head;
		while(temp != null) //Going through the tour
		{
			System.out.println(temp.p); //Printing out each node
			temp = temp.next; //Getting next node
		}
	}
	/**
	 * Visually draws the Tour
	 */
	/** draw the tour using StdDraw */
	public void draw()
	{
		Node eachNode = head;
		while(eachNode.next != null) //Going through each node in Tour until there are none left
		{
			eachNode.p.drawTo(eachNode.next.p); //Drawing the node line to its next node
			eachNode = eachNode.next; //Getting next node
		}
		eachNode.p.drawTo(head.p); //Drawing last node to head
	}
	/**
	 * Returns the size of the Tour /nodes
	 */
	/** return number of nodes in the tour */
	public int size()
	{
		return size; //returning size of tour
	}
	/**
	 * Loops through each node in the Tour and calculates the distance between each node
	 */
	/** return the total distance "traveled", from start to all nodes and back to start */
	public double distance()
	{
		//Essentially the same as draw(), but adding the total distance instead
		double distance = 0.0; //distance var
		Node eachNode = head;
		while(eachNode.next != null) //Adding the distance until no nodes are left in the tour
		{
			distance += eachNode.p.distanceTo(eachNode.next.p); //adding the distance from the node to its next one
			eachNode = eachNode.next; //updating the node to have the next one
		}
		distance += eachNode.p.distanceTo(head.p); //End distance to first
		return distance;
	}
	/**
	 * Determines the closest points in the tour to the previous point
	 */
	/** insert p using nearest neighbor heuristic */
	public void insertNearest(Point p)
	{
		double nearDist = 0.0;
		Node store = new Node(p); //Getting the first point
		Node nextNode = head; //Getting the first index of the node
		Node nearNode = nextNode; //Storing the node

		while(nextNode != null) //looping through the tour
		{
			double dist = nextNode.p.distanceTo(store.p); //Getting the distance from the node to the point
			if (dist < nearDist || nearDist == 0.0) //If that distance is less than the current nearest
				//replace them
			{
				nearNode = nextNode; //nearest node = new nearest node
				nearDist = dist; // nearest distance = the newest distance
			}

			nextNode = nextNode.next; //getting next node to check
		}
		if (nearNode != null) //If the nearest node is not null
		{
			Node end = nearNode.next; //storing the nearest node into the tour
			nearNode.next = store;
			store.next = end;
		}
		else
		{
			head = store; //retrying first point
		}
		size++; //increasing size
	}
	/**
	 * Determines the smallest distance on the Tour between each node and stores it
	 */
	/** insert p using smallest increase heuristic */
	public void insertSmallest(Point p) {
		if(size == 0)
		{
			head = new Node(p);
			head.next = null;
		}
		else
		{
			double smallDist = Double.MAX_VALUE;
			int smallNode = -1;
			int nextNode = 0;
			Node store = head;
			Node point = new Node(p);
			while(store != null) {
				Node storeNext = store.next;
				point.next = storeNext;
				store.next = point;
				double distance = this.distance();
				if(distance < smallDist)
				{
					smallNode = nextNode;
					smallDist = distance;
				}
				store.next = storeNext;
				nextNode++;
				store = store.next;
		}
			store = this.head;
			Node tempNext = store.next;
			while(smallNode != 0)
			{
				store = store.next;
				tempNext = store.next;
				smallNode--;
			}
			point.next = tempNext;
			store.next = point;
		}
		size++; //increasing size
	}
	public static void main(String[] args)
	{
		Point a = new Point(100.0, 100.0);
		Point b = new Point(500.0, 100.0);
		Point c = new Point(500.0, 500.0);
		Point d = new Point(100.0, 500.0);
		Tour squareTour = new Tour(a, b, c, d);
		squareTour.show();
		System.out.println(squareTour.distance());
		StdDraw.setXscale(0, 600);
		StdDraw.setYscale(0, 600);
		squareTour.draw();
	}
}