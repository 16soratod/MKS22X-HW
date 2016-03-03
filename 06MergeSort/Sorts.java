public class Sorts{
    public static void printArray(int[] data){
        String ret = "";//empty string to concatenate elements in array                                            
        for(int i = 0; i < data.length-1; i++){//data.length-1 since you don't want the last element to have ','   
            ret += data[i] + ", ";//loops that add each element along with a comma to ret                          
        }
        System.out.println("{ " + ret + data[data.length-1] + " }");//print out brackets + elements + last element
    }

    public static void insertionSort(int[] data){
        for(int i = 1; i < data.length; i++){//start off with a for loop                                           
            if(data[i] < data[i-1] && i != -1){//if element on right is less than the one on left, and when i isn'\
t -1 (there will be an error for out of bounds if not for this)                                                    
                int n = data[i];//remember the element that you will be replacing                                  
                data[i] = data[i-1];//replace element on right to the left                                         
                data[i-1] = n;//move up the element on the left                                                    
                insertionSort(data);//recursion: continue the above process until i reaches -1 and goes out of the\
 for loop or if the element on right is larger than the left. Basically keeps comparing the element on the right t\
o the left.                                                                                                        
            }
        }

    }

    public static void main(String[]args){
        int[] ary = { 8, 6, 7, 5, 3, 0, 9};
        int[] ary2 = { 2, 5, 8, 90, 1, 0, 0, 0, 24, 5, 8};
        System.out.println("First test case");
        Sorts.printArray(ary);
        Sorts.insertionSort(ary);
        Sorts.printArray(ary);
        System.out.println("Second test case");
        Sorts.printArray(ary2);
        Sorts.insertionSort(ary2);
        Sorts.printArray(ary2);
    }
}