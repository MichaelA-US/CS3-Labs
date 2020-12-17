/**
 * This class implements the abstract class MazeSolver and
 * overrides the abstract methods to implement basic
 * operations for a stack using the MyStack class
 *
 */
public class MazeSolverStack extends MazeSolver
{
    private MyStack workList;

    /**
     * Basic constructor that calls upon the super maze
     * @param maze
     */
    public MazeSolverStack(Maze maze)
    {
        super(maze);
    }

    /**
     * Makes the stack empty
     */
    @Override
    void makeEmpty()
    {
        workList = new MyStack();
    }

    /**
     * Checks if the stack is empty
     * @return true or false depending on if the stack is empty or not
     */
    @Override
    boolean isEmpty()
    {
        return workList.isEmpty();
    }

    /**
     * Push the square onto the stack and print
     * @param s
     */
    @Override
    public void add(Square s)
    {
        workList.push(s);
        //System.out.println(workList); Test to make sure it's working
    }

    /**
     * Returns the next square using pop
     * @return
     */
    @Override
    Square next()
    {

        return workList.pop();
    }
}