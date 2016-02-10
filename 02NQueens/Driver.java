public class Driver{
    public static void main(String[]args){
	Board test = new Board();
       	test.makeBoard(3);
	test.addQueen();
	System.out.println(test.printBoard());
	
	/*Board n = new Board();
	System.out.println(n.printBoard(n.makeBoard(2)));
	System.out.println();
	System.out.println(n.printBoard(n.makeBoard(9)));
	Board test1 = new Board();
	test1 = n.makeBoard(3);
	test1.addQueen();
	System.out.println(n.printBoard(test1));
	*/
    }
}
	