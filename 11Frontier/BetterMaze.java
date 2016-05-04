import java.io*;
import java.util*;
public class BetterMaze{

    private char[][] maze;
    private int[]    solution;
    private int      startRow,startCol;
    private Frontier<Node> placesToGo;
    private boolean  animate;//default to false

    private class Node{
        private int r,c;
        private Node prev;

        public Node(int row, int col, Node p){
            r = row;
            c = col;
            prev = p;
        }

        public int getRow(){
            return r;
        }
        public int getCol(){
            return c;
        }
        public Node getPrevious(){
            return prev;
        }
        public String toString(){
            return "Row: " + r + " , Col: " + c;
        }
    }

   /**return a COPY of solution.
     *This should be : [x1,y1,x2,y2,x3,y3...]
     *the coordinates of the solution from start to end.
     *Precondition : one of the solveXXX methods has already been 
     * called (solveBFS OR solveDFS OR solveAStar)
     *(otherwise an empty array is returned)
     *Postcondition:  the correct solution is in the returned array
    **/
    public int[] solutionCoordinates(){
        /** IMPLEMENT THIS **/      
        if(solved){

        }
    }    

    /**initialize the frontier as a queue and call solve
    **/
    public boolean solveBFS(){  
        /** IMPLEMENT THIS **/ 
        placesToGo = new FrontierQueue<Node>();
        Node local =  new Node(startCol,startRow,null);
        placesToGo.add(local);
        while(!(local.getRow() == endRow && local.getCol() == endCol)){
            maze[current.getY()][current.getX()] = '.';
            for(Node cur : getNeighbors(current) ){ 
                placesToGo.add(cur);
            }
            if (animate) {
                System.out.println(this.toString());  
                wait(5);
            }
            try{
                current = placesToGo.next();
            }catch(NoSuchElementException e){
                return false;
            }
    }   

   /**initialize the frontier as a stack and call solve
    **/ 
    public boolean solveDFS(){  
        /** IMPLEMENT THIS **/  
        placesToGo = new FrontierStack<Node>();
        return solve();        
    }    

   /**Search for the end of the maze using the frontier. 
      Keep going until you find a solution or run out of 
      elements on the frontier.
    When animate is true, print the maze each time you 
    process a new node.
    **/
    public boolean solve(){  
        /** IMPLEMENT THIS **/  
    }    
     
   /**mutator for the animate variable  **/
    public void setAnimate(boolean b){  animate = b; }   

	//print out # of solution coordinates lenght / 2 = steps

    /*while(placesToGo.hasNext()){
        Node next = placesToGo.next();

        //process neighbors
        for(Node n : process(next)){
            //is it the end?
            if(checkEnd(n)){
                makeSolution(n);
                return true;
            }
        }
    }
    for(Node n : getNeighbors(current)){
    
    }
    */
}