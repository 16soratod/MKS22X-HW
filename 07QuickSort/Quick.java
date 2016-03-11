//import java.lang.Object;
import java.util.*;
import java.util.Random;
public class Quick{
	//private int[] list;
	private int pivot;

	public static String name(){
		return " 7, Doken, Sorato";
	}

	private static void swap(int[]data, int a, int b){
		int t = data[a];
		data[a] = data[b];
		data[b] = t;
	}
	private static int partition(int[] data, int left, int right){
		//random
		int index = (int)(Math.random()*(right-left+1));
		//int index = (right-left+1) / 2;
		System.out.println(index);
		//write a swap fxn
		swap(data, index, left);
		//loop through all values, and leave them alone, or swap to end
		int start = left + 1;
		int end = right;
		while(start < end){
			if (data[start] > data[left] && data[end]<data[left]){
				swap(data, start, end);
				end--;
			}else{
				start++;
			}
		}
		//look at the value you converged on
		//and decide how to swap the partition element into place
		if(data[start] > data[left]){
			swap(data,left,start-1);
			return start-1;
		}else{
			swap(data,left,start);
			return start;
		}
	}

	public static int quickselect(int[]data, int k){
		return quickselect(data,k,0,data.length-1);
	}
	private static int quickselect(int[]data, int k, int left, int right){
		if(left==right){
			return data[left];
		}
		if(k == partition(data, left, right)){
			return data[k];
		}else if(k > partition(data, left, right)){
			return quickselect(data, k, left, partition(data, left, right)-1);
		}else{
			return quickselect(data, k, partition(data,left,right)+1,right);
		}
	}

/////////////////////////~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~/////////////////////////
	
	public static void quickSort(int[]data){
		quickSort(data,0,data.length-1);
	}

	private static void quickSort(int[]data,int left,int right){
		if(left < right){
			int index = partition(data,left,right);
			quickSort(data, left, index-1);
			quickSort(data, index+1,right);
		}
	}

	public static void main(String[]args){
		int[] ary = new int[6000000];
		for(int i = 0; i < ary.length; i++){
			ary[i] = (int)(Math.random()*7);
		}
		Quick a = new Quick();
		int[] array = new int[]{7,8,4,5,6,9,0,2,3,1};
		//System.out.println(a.partition(array,0,array.length));
		System.out.println("array before: 7,8,4,5,6,9,0,2,3,1");
		//System.out.println("array after: 0,2,3,5,7,8,9 Answer should be 5");
		a.partition(array,0,array.length-1);
		//System.out.println(a.quickselect(array, 3));
		System.out.println(Arrays.toString(array));
		//int[] array2 = new int[]{7,8,4,5,6,9,0,2,3,1};
		a.quickSort(array);
		System.out.println(Arrays.toString(array));
		
	}

}