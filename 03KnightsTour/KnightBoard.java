public class KnightBoard{
    private int[][] board;
    private int[][] rBoard;
    private int r;
    private int c;
    
    public KnightBoard(int size){
		board = new int[size][size];
		/*
		for(int r = 0; r < board.length; r++){
   	         for(int c = 0; c < board[0].length; c++){
				if(r < 3 && c < 3){
			    board[r][c] = -1;
			}
	    	}	
		}*/
		rBoard = new int[size][size];
		r = size;
		c = size;
    }

    public KnightBoard(int cols, int rows){
    	board = new int[rows][cols];
    	r = rows;
    	c = cols;
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
    if(r <= c){
    	if((r%2 != 0 && c%2 != 0) || r == 1 || r == 2 || r == 4 || (r == 3 && c == 4) || 
    		(r == 3 && c == 6) || (r == 3 && c == 8)){
    		return false;
    	}
  	  }else if(c <= r){
  	  	if((c%2 != 0 && r%2 != 0) || c == 1 || c == 2 || c == 4 || (c == 3 && r == 4) || 
    		(c == 3 && r == 6) || (c == 3 && r == 8)){
    		return false;
    	}	
  	  }
    return solveH(1,0,0);
    }

    public boolean solveH(int start, int x, int y){
	if(y < 0 || x < 0 || x >= r || y >= c){
	    return false; 
	}
	if(board[x][y] != 0){
	    return false;
	}
	board[x][y] = start;
	if(start == r*c){
		return true;
	}
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
		for (int i = 0; i < board.length; i ++){
	 	   for (int j = 0; j < board[0].length; j ++){
			if (board[i][j] >= 1000){
			    ret = ret + " " + board[i][j] + " ";
			}else if (board[i][j] >= 100){
			    ret = ret + " " + board[i][j] + "  ";
			}else if (board[i][j] >= 10){
			    ret = ret + " " + board[i][j] + "   ";
			}else{
		   		ret = ret + " " +  board[i][j] + "    ";
			}
	    }
	    ret += "\n";
        }
    	System.out.println(ret);
    }
    public static void main(String[] args){
        KnightBoard a = new KnightBoard(5);
        System.out.println(a);
        a.solve();
        a.printSolution();
        }     
    }   