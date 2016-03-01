public class Driver02{
	public static void main(String[]args){
		QueenBoard a = new QueenBoard(3);
		a.solve();
		a.printSolution();
		QueenBoard b = new QueenBoard(5);
		b.solve();
		b.printSolution();
		QueenBoard c = new QueenBoard(10);
		c.solve();
		c.printSolution();
		QueenBoard d = new QueenBoard(52);
		d.solve();
		d.printSolution();
	}
}