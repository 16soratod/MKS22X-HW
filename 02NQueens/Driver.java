public class Driver{
    public static void main(String[]args){
	System.out.println("Test 1:");
	Board test = new Board();
       	test.makeBoard(3);
	test.addQueen();
	System.out.println(test.printBoard());
	test.removeQueen();
	System.out.println(test.printBoard());
	System.out.println();
	System.out.println("Test 2:");
	Board test2 = new Board();
	test2.makeBoard(10);
	test2.addQueen();
	System.out.println(test2.printBoard());
	test2.removeQueen();
	System.out.println(test2.printBoard());
    }
}
	