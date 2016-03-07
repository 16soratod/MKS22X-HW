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
//t -1 (there will be an error for out of bounds if not for this)                                                    
                int n = data[i];//remember the element that you will be replacing                                  
                data[i] = data[i-1];//replace element on right to the left                                         
                data[i-1] = n;//move up the element on the left                                                    
                insertionSort(data);//recursion: continue the above process until i reaches -1 and goes out of the\
 //for loop or if the element on right is larger than the left. Basically keeps comparing the element on the right t\
//o the left.                                                                                                        
            }
        }

    }

    public static void mergeSort(int[] data){
        mergeH(data, 0, half(data.length), half(data.length) + 1, data.length - 1);
    }

//////////////////////////////////////////////////////////////////////////////////////
    public static void merge(int[] data, int start, int end, int start1, int end1){
        int[] nData = new int[(end1 - start1) + (end - start) + 2];
        int count = start;
        if(start == start1){
            return;
        }
        if(start1 < start){
            count = start1;
        }
        for(int i = 0; i < nData.length; i++){
            if(start > end){
                nData[i] = data[start1];
                start1++;
            }else if(start1 > end1){
                nData[i] = data[start];
                start++;
            }else if(data[start] <= data[start1]){
                nData[i] = data[start];
                start++;
            }else if(data[start1] < data[start]){
                nData[i] = data[start1];
                start1++;
            }
        }
        for(int i = 0; i < nData.length; i++){
            data[i + count] = nData[i];
        }
    }
    public static int half(int a){
        if(a % 2 != 0){
            return (a-1)/2;
        }else{
            return a/2;
        }
    }
    public static void mergeH(int[] data, int start, int end, int start1, int end1){
        if(start == end && start1 == end1){
            merge(data, start, end, start1, end1);
        }else if(start == end){
            mergeH(data, start, end, start1, end1);
            mergeH(data, start1, start1 + half(end1-start1), start1 + half(end1-start1)+1, end1);
            merge(data, start, end, start1, end1);
        }else if(start1 == end1){
            mergeH(data, start, start + half(end-start), start + half(end-start) + 1, end);
            mergeH(data, start1, end1, start1, end1);
            merge(data,start,end,start1,end1);
        }else{
            mergeH(data, start1, start1 + half(end-start), start + half(end-start) + 1, end);
            mergeH(data, start1, start1 + half(end1-start1), start1 + half(end1 - start1) + 1, end1);
            merge(data, start, end, start1, end1);
        }
    }

    public static void main(String[]args){
        int[] ary = { 8, 6, 7, 5, 3, 0, 9};
        int[] ary2 = { 2, 5, 8, 90, 1, 0, 0, 0, 24, 5, 8};
        int[] ary3 = { 2, 5, 8, 90, 1, 0, 0, 0, 24, 5, 8};
        System.out.println("First test case");
        Sorts.printArray(ary);
        Sorts.insertionSort(ary);
        Sorts.printArray(ary);
        System.out.println("Second test case");
        Sorts.printArray(ary2);
        Sorts.insertionSort(ary2);
        Sorts.printArray(ary2);
        System.out.println("Third test case");
        Sorts.printArray(ary3);
        Sorts.mergeSort(ary3);
        Sorts.printArray(ary3);
    }
}