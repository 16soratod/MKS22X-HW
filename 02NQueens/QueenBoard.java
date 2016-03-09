public class QueenBoard{
    private int[][]board;
    
    public static String name(){
    	return " 7, Doken, Sorato";
    }

    public QueenBoard(int size){
	board = new int[size][size];
    }

    /**
     *precondition: board is filled with 0's only.
     *postcondition: 
     *-return false, and board is still filled
     *with 0's for a board that cannot be solved.
     *-return true, and board is filled with the 
     *final configuration of the board after adding 
     *all n queens.
     */
    public boolean solve()
    {
	return solveH(0);
    }

    /**
     *Helper method fr solve. 
     */
    private boolean solveH(int col){
	//boolean queen = true;
	int rowStart = 0;
	if(col>=board.length){
	    return true;
	//}else if(col < 0 || board.length == 2 || board.length == 3){
	   // return false;
	}else{
	    for(int row = 0; row < board.length; row++){
		if(board[row][col] >= 0){
		    //rowStart = row;
		    addQueen(row,col);
		    if(solveH(col+1)){
		    	return true;
			}else{
				removeQueen(row,col);
			}
	    }
		//}
	    // if(board[Row][col] != 0){
	    //for(int row = 0; row < board.length; row++){
		//if(board[row][col] == 1){
		  //  removeQueen(row,col-1);
		    //board[row][col] = -1;
		    //queen = false;
		    //return solveH(col-1);
		//}
	    }
	}
	return false;
    }


    public void printSolution(){
	String ans = "";
        for(int r = 0; r < board.length; r++){
            for(int c = 0; c < board[0].length; c++){
		if(board[r][c] == 1){
		    ans += "Q" + "\t";;
		}else{
		    ans += "_"+"\t";
		}
	    }
            ans+="\n";
        }
	System.out.println(ans);
    }

    /********Do Not Edit Below This Line**********************************/

    private boolean addQueen(int row, int col){
	if(board[row][col] != 0){
	    return false;
	}
	board[row][col] = 1;
	int offset = 1;
	while(col+offset < board[row].length){
	    board[row][col+offset]--;
	    if(row - offset >= 0){
		board[row-offset][col+offset]--;
	    }
	    if(row + offset < board.length){
		board[row+offset][col+offset]--;
	    }
	    offset++;
	}
	return true;
    }

    private boolean removeQueen(int row, int col){
	if(board[row][col] != 1){
	    return false;
	}
	board[row][col] = 0;
	int offset = 1;
	while(col+offset < board[row].length){
	    board[row][col+offset]++;
	    if(row - offset >= 0){
		board[row-offset][col+offset]++;
	    }
	    if(row + offset < board.length){
		board[row+offset][col+offset]++;
	    }
	    offset++;
	}
	return true;
    }

    public String  toString(){
	String ans = "";
	for(int r = 0; r < board.length; r++){
	    for(int c = 0; c < board[0].length; c++){
		ans+= board[r][c]+"\t";
	    }
	    ans+="\n";
	}
	return ans;
    }
    
    public static void main(String[]args){
	QueenBoard b = new QueenBoard(5);
        System.out.println("Pre-Test Cases:");
	System.out.println(b);
	b.addQueen(3,0);
	b.addQueen(0,1);
        System.out.println(b);
	b.removeQueen(3,0);
        System.out.println(b);
	QueenBoard a = new QueenBoard(2);
        System.out.println("2 * 2");
        System.out.println(a);
        a.solve();
        System.out.println(a);
        a.printSolution();
	QueenBoard b1 = new QueenBoard(3);
        System.out.println("3 * 3");
        System.out.println(b1);
        b1.solve();
        System.out.println(b1);
        b1.printSolution();
	QueenBoard c = new QueenBoard(4);
	System.out.println("4 * 4");
	System.out.println(c);
	c.solve();
	System.out.println(c);
	c.printSolution();
	QueenBoard d = new QueenBoard(10);
        System.out.println("10 * 10");
        System.out.println(d);
        d.solve();
        System.out.println(d);
        d.printSolution();
	QueenBoard e = new QueenBoard(52);
        System.out.println("52 * 52");
        System.out.println(e);
        e.solve();
        System.out.println(e);
        e.printSolution();
    }
    
    
}