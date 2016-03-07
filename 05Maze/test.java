import java.util.*;
import java.io.*; 
import java.util.Scanner;
import java.io.FileNotFoundException;

public class test{
 	private char[][]maze;
    private int startx,starty;
    private boolean animate;
    private String file;
	/*public test(String filename){
		try{
            int row;
            int col;
            String r;
            String c;
            String text = "";
            File file = new File(filename);
            Scanner in = new Scanner(file);
            LineNumberReader read = new LineNumberReader(new FileReader(filename));
            text = in.next();
            //row = Integer.parseInt(in.next());
            //col = Integer.parseInt(in.next());
            row = read.getLineNumber();
            Scanner in2 = new Scanner(file);
            col = in2.nextLine().length(); 
            maze = new char[row][col];
            for(int i = 0; i < row; i++){
                for (int j = 0; j < col; j++){
                    maze[i][j] = text.charAt(i+j);
                }
            }
        }catch(FileNotFoundException e){
            System.out.println("File not found");
        }
    }
    */
    public test(String filename){
        filename = file;
    }
    public static int countLines(String filename) throws IOException {
    //filename = file;
        InputStream is = new BufferedInputStream(new FileInputStream(filename));
        try {
            byte[] c = new byte[1024];
            int count = 0;
            int readChars = 0;
            boolean empty = true;
            while ((readChars = is.read(c)) != -1) {
                empty = false;
                for (int i = 0; i < readChars; ++i) {
                    if (c[i] == '\n') {
                        ++count;
                    }
                }
            }
            return (count == 0 && !empty) ? 1 : count;
        }catch(IOException e){
        System.err.println("Caught IOException: " + e.getMessage());
        }
        finally {
            is.close();
        }
    }
    public static void main(String[]args){
    	test a = new test("data1.dat");
        System.out.println(a.countLines("data1.dat"));
    	
    }
}