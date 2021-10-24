package cl.klawx3.other;

public class ArrayOrder {
    public static void orderArray(int[] arr){
        quickSort(arr,0,arr.length - 1);
    }

    private static void quickSort(int[] arr, int leftPointer, int rightPointer){
        if(rightPointer - leftPointer <= 0) return;

        int pivot = pivot(arr,leftPointer, rightPointer);

        quickSort(arr, leftPointer, pivot - 1);
        quickSort(arr, pivot + 1, rightPointer);
    }

    private static int pivot(int[] arr , int leftPointer , int rightPointer){
        int pivotValue = arr[rightPointer];
        int pivotIndex = rightPointer;
        rightPointer--;
        while(true){
            while(leftPointer < arr.length - 1 && arr[leftPointer] < pivotValue){
                leftPointer++;
            }
            while(rightPointer >= 0 && arr[rightPointer] > pivotValue){
                rightPointer--;
            }
            if(leftPointer >= rightPointer){
                break;
            }else{
                int aux = arr[leftPointer];
                arr[leftPointer] = arr[rightPointer];
                arr[rightPointer] = aux;
                leftPointer++;
            }
        }
        int aux = arr[leftPointer];
        arr[leftPointer] = arr[pivotIndex];
        arr[pivotIndex] = aux;

        return leftPointer;
    }
}
