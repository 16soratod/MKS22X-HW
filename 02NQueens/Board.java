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
    //ADD QUEEN METHOD WITH HELPER FXNs
    public boolean addQueen(){
	boolean added = false;
	for(int i = 0; i < size; i++){
	    for(int j = 0; j < size; j++){
		if(board[j][i] == 0){
		    board[j][i] = 1;
		    addHorizontal(j,i);
		    addDiagonal(j,i);
		    return true;
		}
	    }
	}
	return added;
    }

    public void addHorizontal(int row, int col){
	for(int k = 1; k+col < size; k++){
            board[row][col+k] -= 1;
        }
    }
    public void addDiagonal(int row, int col){
	for(int k = 1; k+row < size && k+col < size; k++){
	    board[row+k][col+k] -= 1;
	}
    }

    //REMOVE QUEEN METHOD WITH HELPER FXNs
    public boolean removeQueen(){
	boolean removed = false;
	for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                if(board[j][i] == 1){
                    board[j][i] = 0;
                    removeHorizontal(j,i);
                    removeDiagonal(j,i);
                    return true;
                }
            }
        }
        return removed;
    }
    public void removeHorizontal(int row, int col){
	for(int k = 1; k+col < size; k++){
	    board[row][col+k] += 1;
	}
    }
    public void removeDiagonal(int row, int col){
	for(int k = 1; k+row < size && k+col < size; k++){
	    board[row+k][col+k] += 1;
	}
    }

    

}