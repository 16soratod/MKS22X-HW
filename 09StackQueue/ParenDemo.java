import java.util.*;
public class ParenDemo{
	MyStack<Character> stack = new MyStack<Character>();

    public static boolean isMatching(String s){
    	MyStack<Character> n = new MyStack<Character>();
    	for( char next : s.toCharArray() ){
    		if(next == '(' || next == '{' || next == '[' || next == '<' ){
    			n.push(next);
    		}
    		if(next == ')' || next == '}' || next == ']' || next == '>' ){
    			char temp = getMatch(next);
    			try{
    				char open = n.pop();
    				if( temp != open ){
    					return false;
    				}
    			}catch(NoSuchElementException e){
    				return false;
    			}
    		}
    	}
    		if(!n.isEmpty()){
    			return false;
    		}
    	/*
        for(int i = 0; i < s.length(); i++){
            n.push(s.charAt(i));
        }*/
        //System.out.println(n);
        return n.isEmpty();
    }

    public static char getMatch(char c){
    	char match = 0;
    	if(c == '}'){
    		match = '{';
    	}
    	if(c == ']'){
    		match = '[';
    	}
    	if(c == ')'){
    		match = '(';
    	}
    	if(c == '>'){
    		match = '<';
    	}
    	return match;
    }

    public static void main(String[]args){
        String input = "()()(([[]]))";
        //String input = "sorato";
        if(args.length > 0){
            input = args[0];
            //System.out.println(makeStack(input));
            System.out.println(isMatching(input)); 
        }else{
            System.out.println("Usage:"); 
            System.out.println("java ParenDemo \"text\""); 
            System.out.println(isMatching(input));
        }
        //System.out.println(input.split("[()]+"));
    }

}