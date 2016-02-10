public class Board{
    int size;
    int[][] board;
    
    public void makeBoard(int n){
	int[][] a = new int[n][n];
	for(int i = 0; i < n; i++){
	    for(int j = 0; j < n; j++){
		a[i][j] = 0;
	    }
	}
	size = n;
	board = a;
    }
    public String printBoard(){
        String ret = "";
	for(int i = 0; i < size; i++){
	    //ret += "[";
	    ret += "\n";
	    for(int j = 0; j < size; j++){
		ret += board[i][j];
		ret += " , ";
	    }
	}
	return ret; //+= "]";
    }
    
    public boolean addQueen(){
	for(int i = 0; i < size; i++){
	    for(int j = 0; j < size; j++){
		if(board[j][i] == 0){
		    board[j][i] = 1;
		    return true;
		}
	    }
	}
	return false;
    }

}