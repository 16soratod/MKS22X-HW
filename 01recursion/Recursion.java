public class Recursion implements hw01{
    
    public String name(){
	return "Doken,Sorato";
    }

    public double sqrt(double n){
	if(n < 0){
	    throw new IllegalArgumentException("n must be positive");
	}else if(n == 0){
	    return 0.0;
	}
	return sqrtH(n, 1);
    }

    public double sqrtH(double n, double guess){
	//guess = sqrtH(n, ((n/guess + guess)/2));
	if(Math.abs(((guess*guess)/n)*100 - 100) < 0.0001){
	    return guess;
	}else{
	    return sqrtH(n, ((n/guess + guess)/2));
	}
    }
    /*
    public static void main(String[]args){
	Recursion a = new Recursion();
	System.out.println("Start: "+a.name());
      	System.out.println(a.sqrt(-1));
	System.out.println(a.sqrt(49));
	System.out.println(a.sqrt(1));
	}
    */
}