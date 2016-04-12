public class BetterMaze{
	pricate char[][] maze;
	int[] solution;
	int startRow, startCol;
	FrontierQ<Node> placesToGo;
	boolean animate; //default false

	public int[] solutionCoordinates(){

	}
	public boolean solveBFS(){
		placesToGo = new FrontierQ<Node>;
		return solve();
	}

	public void setAnimate(boolean b){ animate = b;}
	private void makeSolution
}