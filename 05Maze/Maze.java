import java.util.*;
import java.io.*; 
import java.util.Scanner;	
import java.io.FileNotFoundException;

public class Maze{

    private char[][]maze;
    private int startx,starty;
    private boolean animate;

    private int rows,cols;
    private String touch;

    /*Constructor loads a maze text file.
      1. The file contains a rectangular ascii maze, made with the following 4 characters:
      '#' - locations that cannot be moved onto
      ' ' - locations that can be moved onto
      'E' - the location of the goal (only 1 per file)
      'S' - the location of the start(only 1 per file)

      2. The maze has a border of '#' around the edges. So you don't have to check for out of bounds!

      3. When the file is not found, print an error and exit the program.
    */
    public Maze(String filename, boolean ani){
        //COMPLETE CONSTRUTOR
    try{
            int row = 0;
            int col = 0;
            String r;
            String c;
            String text = "";
            File file = new File(filename);
            Scanner in = new Scanner(file);
            LineNumberReader read = new LineNumberReader(new FileReader(filename));
            //text += in.next();
            //row = Integer.parseInt(in.next());
            //col = Integer.parseInt(in.next());
            //row = read.getLineNumber();
            //rows = row;
            Scanner in2 = new Scanner(file);
            //col = in2.nextLine().length(); 
            //cols = col;
            //maze = new char[row][col];
            //for(int i = 0; i < row; i++){
            //    for (int j = 0; j < col; j++){
            //        maze[i][j] = text.charAt(i+j);
            //    }
            //}
            while(in.hasNext()){
                if(in.hasNextLine()){
                    col++;
                }
                text += in.next();
            }
            touch = text;
            cols = col;
            for(int i = 0; i < row; i++){
                for(int j = 0; j < col; j++){
                    if(maze[i][j] == 'S'){
                        startx = i;
                        starty = j;
                        //System.out.println(startx);
                        //System.out.println(starty);
                    }
                }
            }
        }catch(FileNotFoundException e){
            System.out.println("File not found");
        }
    }

    public void getStuff(){
        System.out.println(startx);
        System.out.println(starty);
        System.out.println(touch);
        System.out.println(rows);
        System.out.println(cols);
    }

    public void printmaze(){
        String ret = "";
            for(int i = 0; i < rows; i++){
                for(int j = 0; j < cols; j++){
                    ret += maze[i][j];

                }
            }
            System.out.println(ret);
    }
    /*Main Solve Function

      Things to note:
       When no S is contained in maze, print an error and return false.
    */
    public boolean solve(){
        if(startx < 0){
            System.out.println("No starting point 'S' found in maze.");
            return false;
        }else{
            maze[startx][starty] = ' ';
            return solve(startx,starty);
        }
    }

    /*
      Recursive Solve function:

      A solved maze has a path marked with '@' from S to E.
      The S is replaced with '@' but the 'E' is not.

      Postcondition:
        Returns true when the maze is solved,
        Returns false when the maze has no solution.

        All visited spots that were not part of the solution are changed to '.'
        All visited spots that are part of the solution are changed to '@'

    */
    private boolean solve(int row, int col){
        if(animate){
            System.out.println(this);
            wait(20);
        }

        //COMPLETE SOLVE
        /*
        for(int x = 0; x < 9; x++){    
        }*/
        if (maze[row][col] == 'E') {
        		return true;
        	}else{
        		maze[row][col] = '@';
        		if(maze[row - 1][col] != '#' && maze[row - 1][col] != '.' && maze[row - 1][col] != '@' && solve(row - 1,col)){
        			return true;
        		}else if(maze[row][col - 1] != '#' && maze[row][col - 1] != '.' && maze[row][col - 1] != '@' && solve(row,col - 1)){
        			return true;
        		}else if(maze[row][col + 1] != '#' && maze[row][col + 1] != '.' && maze[row][col + 1] != '@' && solve(row,col + 1)){
        			return true;
        		}else if(maze[row + 1][col] != '#' && maze[row + 1][col] != '.' && maze[row + 1][col] != '@' && solve(row + 1,col)){
        			return true;
        		}else{
        			maze[row][col] = '.';
        		}
        	}
        return false; //so it compiles
    }


    //FREE STUFF!!! *you should be aware of this*

    public void clearTerminal(){
        System.out.println(CLEAR_SCREEN);
    }

    public String toString(){
        int maxx = maze.length;
        int maxy = maze[0].length;
        String ans = "";
        if(animate){
            ans = "Solving a maze that is " + maxx + " by " + maxy + "\n";
        }
        for(int i = 0; i < maxx * maxy; i++){
            if(i % maxx == 0 && i != 0){
                ans += "\n";
            }
            char c =  maze[i % maxx][i / maxx];
            if(c == '#'){
                ans += color(38,47)+c;
            }else{
                ans += color(33,40)+c;
            }
        }
        return HIDE_CURSOR + go(0,0) + ans + "\n" + SHOW_CURSOR + color(37,40);
    }

    //MORE FREE STUFF!!! *you can ignore all of this*
    //Terminal keycodes to clear the terminal, or hide/show the cursor
    private static final String CLEAR_SCREEN =  "\033[2J";
    private static final String HIDE_CURSOR =  "\033[?25l";
    private static final String SHOW_CURSOR =  "\033[?25h";
    //terminal specific character to move the cursor
    private String go(int x,int y){
        return ("\033[" + x + ";" + y + "H");
    }

    private String color(int foreground,int background){
        return ("\033[0;" + foreground + ";" + background + "m");
    }

    private void wait(int millis){
        try {
            Thread.sleep(millis);
        }
        catch (InterruptedException e) {
        }
    }

    
    //END FREE STUFF
    public static void main(String[]args){
        Maze a = new Maze("data1.dat", true);
        a.getStuff();
        a.printmaze();
    }


}