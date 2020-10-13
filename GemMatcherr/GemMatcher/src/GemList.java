public class GemList
{

    public static void main(String [] args)
    {
        GemList list = new GemList();
        System.out.println(list);
        System.out.println("size = " + list.size() + ", score = " + list.score());
        list.draw(0.9);

        list.insertBefore(new Gem(GemType.BLUE, 10), 0);
        System.out.println("\n" + list);
        System.out.println("size = " + list.size() + ", score = " + list.score());
        list.draw(0.8);

		list.insertBefore(new Gem(GemType.BLUE, 20), 99);  //not a mistake, should still work
	    System.out.println("\n" + list);
		System.out.println("size = " + list.size() + ", score = " + list.score());
		list.draw(0.7);

        list.insertBefore(new Gem(GemType.ORANGE, 10), 1);
        System.out.println("\n" + list);
        System.out.println("size = " + list.size() + ", score = " + list.score());
        list.draw(0.6);

		list.insertBefore(new Gem(GemType.ORANGE, 10), 2);
		System.out.println("\n" + list);
		System.out.println("size = " + list.size() + ", score = " + list.score());
		list.draw(0.5);

		list.insertBefore(new Gem(GemType.ORANGE, 50), 3);
		System.out.println("\n" + list);
		System.out.println("size = " + list.size() + ", score = " + list.score());
		list.draw(0.4);

        list.insertBefore(new Gem(GemType.GREEN, 10), 2);
        System.out.println("\n" + list);
        System.out.println("size = " + list.size() + ", score = " + list.score());
        list.draw(0.3);
    }

    /**
     * Private class that creates nodes in order
     * to get the next gem in the game
     */
    private class Node
    {
        public Gem gem;
        public Node next;

        /**
         * Basic constructor that initalizes the gem and the next
         * node
         */
        public Node()
        {
            gem = null;
            next = null;
        }

        /**
         * Secondary constructor that sets the gem object
         * to the gem
         * @param gem
         */
        public Node(Gem gem)
        {
            this.gem = gem;
            next = null;
        }
    }

    private int size;
    private Node head;
    private Node tail;

    /**
     * Basic constructor that initalizes the size, tail, and head of the gem list
     */
    public GemList()
    {
        int size = 0;
        tail = null;
        head = null;
    }

    /**
     * Inserts the gem into the list with the index given
     * @param gem - gem to move
     * @param index - index to shift to
     */
    public void insertBefore(Gem gem, int index)
    {
        Node store = tail;
        if (index == 0 || size == 0) //if index is at the bottom or its the first gem
        {
            tail = new Node(gem);
            if (size != 0)
            {
                tail.next = store;
            }
            else
            {
                head = tail;
            }
            size++;
        }

        else if (index >= size) //if index is at the top
        {
            head.next = new Node(gem);
            store = head.next;
            head = store;
            size++;
        }
        else //if index is somewhere in the middle
        {
            for(int i = 0; i < index-1; i++)
            {
                store = store.next;
            }
            Node store2 = store.next;
            store.next = new Node(gem);
            store.next.next = store2;
            size++;
        }
    }

    /**
     * Returns the number of gems in the list
     * @return the num of gems
     */
    public int size()
    {
        return size;
    }

    /**
     * Returns a string representation of the list
     * @return the string
     */
    @Override
    public String toString()
    {
        String str = "[";
        Node store = tail;
        for(int i = 0; i < size; i++)
        {
            str += store.gem.toString()+ " ";
            store = store.next;
        }
        str += "]";
        return str;
    }

    /**
     * Draw all gems in the list at the given y coord
     * @param y coordinate
     */
    public void draw(double y)
    {
        int count = 0;
        Node store = this.tail;
        while(store != null)
        {
            store.gem.draw(GemGame.indexToX(count), y);
            store = store.next;
            count++;
        }
    }

    /**
     * Calculates the total score of the list
     * @return the score of all the gems
     */
    public int score ()
    {
        int score = 0;
        Node store = tail;
        if(this.size == 0) //Checks if there are gems in the list
        {
            return 0;
        }
            GemType storeType = tail.gem.getType(); //Getting the type of the gem
            int count = 0;
            int tmpScr = 0;
            for(int i = 0; i < size(); i++) //looping through the list
            {
                Gem storeGem = store.gem; //Storing the gem object into a temp var
                if(storeGem.getType() == storeType)  //Checking if the the type of the gem equals the temp gem type
                {
                    count++; //increasing count of score
                    tmpScr += storeGem.getPoints(); //storing it into total score
                }
                else
                {
                    storeType = store.gem.getType();
                    score += tmpScr * count;
                    count = 1;
                    tmpScr = storeGem.getPoints();
                }
                store = store.next;
            }
            score += tmpScr * count;
        return score;

    }
}