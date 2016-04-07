import java.util.*;
public class MyDeque<T>{
	//generic array
    T[] data;
    int start, end, size;

    //suppress this ONE function from
    //having warnings.
    @SuppressWarnings("unchecked")	    
    public MyDeque(){
		//typecast object array to generic array
		data = (T[]) new Object[10];
		size = 10;
		start = 0;
		end = 9;

    }
    
    /*
    public void add(T n){
		data[0]=n;
		start = 0;
		end = 0;	
    }

    public T get(){
		return data[0];
    }*/
    
    public boolean isEmpty(){
    	if(data.length == 0){
    		return true;
    	}else{
    		return false;
    	}
    }

    @SuppressWarnings("unchecked")
    private void resize(){
    	T[] temp;
    	temp = (T[]) new Object[data.length*2];
    	for(int i = 0; i < data.length; i++){
    		temp[i] = data[i];
    	}
    	data = temp;
    }

    public void addFirst(T value){
    	if(data.length == 1){
    		data[0] = value;
    		start = 0;
    		end = 0;
    	}else if(start==0){
    		start = data.length-1;
    		data[start]=value;
    	}else{
    		data[start-1] = value;
    		start--;
    	}
    }

    public void addLast(T value){
    	if(data.length == 1){
    		data[0] = value;
    		start = 0;
    		end = 0;
    	}else if(end == data.length){
    		resize();
    		data[end+1] = value;
    		end++;
    	}else{
    		data[end+1] = value;
    		end++;
    	}
    }

    public T removeFirst(){
    	if(data.length == 0){
    		throw new NoSuchElementException();
    	}else{
    		T temp = data[start];
    		data[start] = null;
    		start++;
    		return temp;
    	}
    }

    public T removeLast(){
    	if(data.length == 0){
    		throw new NoSuchElementException();
    	}else{
    		T temp = data[end];
    		data[end] = null;
    		if(end == 0){
    			end = data.length;
    		}else{
    			end--; 
    		}
    		return temp;
    	}
    }

    public T getFirst(){
    	if(data.length == 0){
    		throw new NoSuchElementException();
    	}else{
    		return data[start];
    	}
    }

    public T getLast(){
    	if(data.length == 0){
    		throw new NoSuchElementException();
    	}else{
    		return data[end+1];
    	}
    }
/*
    public static void main(String[]args){
		MyDeque<String> x = new MyDeque<String>();
		x.add("fish");
		System.out.println(x.get());
    }
    */
}