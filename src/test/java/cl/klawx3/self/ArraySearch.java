package cl.klawx3.self;

public class ArraySearch {
    public static int binarySearch(int[] arr,int numberToSearch){
        int minIndex = 0;
        int maxIndex = arr.length - 1;
        
        int lastIndex = -1;
        int index = 0;
        while(lastIndex != index){
            lastIndex = index;
            index =  minIndex + (maxIndex - minIndex) / 2;
            if(arr[index] == numberToSearch){
                return index;
            }else{
                if(arr[index] > numberToSearch){
                    maxIndex = index; 
                }else{
                    minIndex = index;
                }
            }
        }
        return -1;
    }
}
