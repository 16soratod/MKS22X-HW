import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class Bronze{

	public static void main(String[] args){
		int[][] field;
		int[] stompD;
		int[] stompR;
		int[] stompC;
		int r;
		int c;
		int elev;
		int stomps;

		if(args.length < 1){
			System.out.println("Enter file name");
		}else{
			try
			{
				String name = "makelake.in";
				File file = new File(name);
				Scanner in = new Scanner(file);
				int r;
				int c;
				field = new int[r][c];
				r = Integer.parseInt(in.next());
				c = Integer.parseInt(in.next());
				elev = Integer.parseInt(in.next());
				stomps = Integer.parseInt(in.next());
				for (int i = 0; i < r; i++) {
					for (int j = 0; j < c; j++) {
						field[r][c] = Integer.parseInt(in.next());	
					}
				}
				stompR = new int[stomps];
				stompC = new int[stomps];
				stompD = new int[stomps];
				for (int i = 0; i < stomps; i++) {
					stompR[i] = Integer.parseInt(in.next());
					stompC[i] = Integer.parseInt(in.next());					
					stompD[i] = Integer.parseInt(in.next());
				}

				field = stomp(field,stompR,stompC,stompD);
				System.out.println(getVol(field,elev) + ",7,Doken,Sorato");

			}
			catch (FileNotFoundException e)
			{
				System.out.println("File not found");
			}
		}
	}

	public static void print(int[][] b){
		String ret  = "";
		for (int i = 0; i < b.length; i ++){
			for (int j = 0; j < b[0].length; j ++){
				if (b[i][j] >= 1000){
					ret = ret + " " + b[i][j] + " ";
				}else if (b[i][j] >= 100){
					ret = ret + " " + b[i][j] + "  ";
				}else if (b[i][j] >= 10){
					ret = ret + " " + b[i][j] + "   ";
				}else{
					ret = ret + " " +  b[i][j] + "    ";
				}
			}
			ret += "\n";
		}
		System.out.println(ret);
	}

	public static int[][] stomp(int[][] field, int[] stompR, int[] stompC, int[] stompD){
		for(int i = 0; i < stompR.length; i++){
			int hi = 0;
			for(int row = stompR[i] - 1; row < stompR[i] + 2 && row < field.length; row++){
				for(int col = stompC[i] - 1; col < stompC[i] + 2 && col < field[0].length; col++){
					if(field[row][col] > hi){
						hi = field[row][col];
					}
				}
			}
			int newHi= hi- stompD[i];
			for(int row = stompR[i] - 1; row < stompR[i] + 2 && row < field.length; row++){
				for(int col = stompC[i] - 1; col < stompC[i] + 2 && col < field[0].length; col++){
					if(field[row][col] > newHi){
						field[row][col] = newHi;
					}
				}
			}
		}
		return field;
	}


	public static int getVol(int[][] field, int elev){
		int[][] fieldDep = new int[field.length][field[0].length];
		for(int row = 0; row < field.length; row++){
			for(int col = 0; col < field[0].length; col++){
				int depth = elev - field[row][col];
				if(depth < 0){
					fieldDep[row][col] = 0;
				}else{
					fieldDep[row][col] = depth;
				}
			}
		}
		int newDep = 0;
		for(int row = 0; row < field.length; row++){
			for(int col = 0; col < field[0].length; col++){
				newDep += fieldDep[row][col];
			}
		}
		return newDep;
	}
}
