import java.util.*;
@SuppressWarnings("unchecked")
public class MyHeap<T extends Comparable<T>>
{
   private int size;
   private T[] data;

   public MyHeap(){
       data = (T[]) new Comparable[size];
   }
   public MyHeap(T[] array){
       T[] temp = (T[]) new Comparable[array.length];
       data = array;
   }
   private void pushDown(int k){}
   private void pushUp(int k){}
   private void heapify(){}
   public T delete(){
       return null;
   }
   public void add(T x){}
   private void doubleSize(){}
   public String toString(){
       String ret = "{ ";
       for(T element : data){
	   ret += element + " , ";
       }
       return ret + " } ";
   }
	       /*/do this last
   public MyHeap(boolean isMax)
   public MyHeap(T[] array, boolean isMax)	      
	       */
   public static void main(String[] args){
       int[] n = new int[]{1,2,3,4,5,6};
       MyHeap a = new MyHeap(n);
       System.out.println(a.toString());
   }
}

