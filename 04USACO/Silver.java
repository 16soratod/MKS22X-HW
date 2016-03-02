import java.util.*;
import java.io.*; 
import java.io.FileNotFoundException;

public class Silver{
	int[][] pasture;
	int result = 0;
	int t, c, r;
	int startR, startC, endR, endC;
	Scanner in;

	public Silver(){
		try{
			File file = new File("ctravel.in");
			in = new Scanner(file);
		}catch(FileNotFoundException e){
			System.out.println("file not in directory");
		}
			t = Integer.parseInt(in.next());
			r = Integer.parseInt(in.next());
			c = Integer.parseInt(in.next());
			String ret = "";
			pasture = new int[r][c];
			for (int i = 0; i < r; i++) {
				ret += in.next();
			}
			for (int i = 0; i < r; i++) {
				for (int j = 0; j < c; j++) {
					char a = ret.charAt(0);
					if (a == '*') {
						pasture[i][j] = -1;					
					}else{
						pasture[i][j] = 0;
					}
					ret = ret.substring(1);
				}
			}
			startR = Integer.parseInt(in.next()) - 1;
			startC = Integer.parseInt(in.next()) - 1;
			endR = Integer.parseInt(in.next()) - 1;
			endC = Integer.parseInt(in.next()) - 1;
			pasture[startR][startC] = 1;
	}
	public void printPasture(){
		String ret  = "";
		for (int i = 0; i < pasture.length; i ++){
			for (int j = 0; j < pasture[0].length; j ++){
				if (pasture[i][j] >= 100){
					ret = ret + " " + pasture[i][j] + "  ";
				}else if (pasture[i][j] >= 10){
					ret = ret + " " + pasture[i][j] + "   ";
				}else{
					ret = ret + " " +  pasture[i][j] + "    ";
				}
			}
			ret += "\n";
		}
		System.out.println(ret);
	}
	//were we supposed to have a solveH?? I don't think we needed one...
	public boolean solve(){
		int[][] newPasture = new int[r][c];
		while(t > 0){
			for(int i = 0; i < r; i++){
				for(int j = 0; j < c; j++){
					if(pasture[i][j] >= 0){
						int sum = 0;
						if(i + 1 < r && pasture[i][j] > 0){
							sum += pasture[i + 1][j];
						}
						if(j + 1 < c && pasture[i][j + 1] > 0){
							sum += pasture[i][j + 1];
						}
						if(i - 1 >= 0 && pasture[i - 1][j] > 0){
							sum += pasture[i - 1][j];
						}
						if(j - 1 >= 0 && pasture[i][j - 1] > 0){
							sum += pasture[i][j - 1];
						}
						newPasture[i][j] = sum;
					}else{
						newPasture[i][j] = -1;
					}
				}
			}
			t -= 1;
			pasture = newPasture;
		}
		result = pasture[endR][endC];
		return true;
	}
	public static void main(String[] args) {
		Silver a = new Silver();
		a.solve();
		a.printPasture();
		System.out.println(a.result);
	}
}