import java.io*;
import java.util*;
public class PathFinding{
	public interface Frontier<T>{
   		public void add(T element);
   		public T next();
 	  	public boolean hasNext();

	}	

	public class FrontierStack<T> implements Frontier<T>{
		public Stack<T> data;
		public FrontierStack(){
			data = new Stack<T>();
		}
		public void add(T e){
			data.push(e);
		}
		public T next(){
			return data.pop();
		}
		public boolean hasNext(){
			if(data.empty){
				return false;
			}else{
				return true;
			}
		}
    	/***Make This Work This Weekend!***/
    	/***You can use your classes or built in ones***/
    	/***You can extend another class OR wrap around it***/

	}
	public class FrontierQueue<T> implements Frontier<T>{	
		public ArrayDeque<T> data;
		public FrontierQueue(){
			data = new ArrayDeque<T>();
		}
		public void add(T e){
			data.addLast(e);
		}
		public T next(){
			return data.removeFirst();
		}
		public boolean hasNext(){
			if(data.isEmpty()){
				return false;
			}else{
				return true;
			}
		}
    	/***Make This Work This Weekend!***/
    	/***You can use your classes or built in ones***/
    	/***You can extend another class OR wrap around it***/

	}
}	
