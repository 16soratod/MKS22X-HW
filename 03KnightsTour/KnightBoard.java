public class KnightBoard{
    private int[][] board;
    private int[][] rBoard;
    
    public KnightBoard(int size){
	board = new int[size+4][size+4];
	for(int r = 0; r < board.length; r++){
            for(int c = 0; c < board[0].length; c++){
		if(r < 3 && c < 3){
		    board[r][c] = -1;
		}
	    }
	}
	rBoard = new int[size][size];
    }

    public boolean addKnight(int row, int col){
	if(board[row][col] != 0){
	    return false;
	}
	board[row][col] ++;
	return true;
    }

    public String toString(){
	String ans = "";
	for(int r = 0; r < board.length; r++){
	    for(int c = 0; c < board[0].length; c++){
		ans+= board[r][c]+"\t";
	    }
	    ans+="\n";
	}
	return ans;
    }

    public boolean solve(){
	return solveH(1,0,0);
    }

    public boolean solveH(int start, int x, int y){
	if(x < 0 || x >= rboard.length || y < 0 || y >= board.length){
	    return false;
	}
	if(board[x][y] >= 1){
	    return false;
	}
	
	if(start == rboard.length * board.length){
	    board[x][y] = moveNum;
	    return true;
	}
	
	board[x][y] = start;
	if (solveH(start + 1, x + 1, y - 2) ||
	    solveH(start + 1, x + 2, y - 1) ||
	    solveH(start + 1, x + 2, y + 1) ||
	    solveH(start + 1, x + 1, y + 2) ||
	    solveH(start + 1, x - 1, y + 2) ||
	    solveH(start + 1, x - 2, y + 1) ||
	    solveH(start + 1, x - 2, y - 1) ||
	    solveH(start + 1, x - 1, y - 2)){
	    return true;
	}else{
	    board[x][y] = 0;
	    return false;
	}
    }

    public void printSolution(){
	String ret  = "";
	for (int x = 0; x < board.length; x ++){
	    for (int y = 0; y < board[0].length; y ++){
		if (board[x][y] >= 1000){
		    ret = ret + " " + board[x][y] + " ";
		}else if (board[x][y] >= 100){
		    ret = ret + " " + board[x][y] + "  ";
		}else if (board[x][y] >= 10){
		    ret = ret + " " + board[x][y] + "   ";
		}else{
		    ret = ret + " " +  board[x][y] + "    ";
		}
	    }
	    ret += "\n";
	}
    public static void main(String[]args){
	KnightBoard a = new KnightBoard(4);
	System.out.println(a);
    }
}