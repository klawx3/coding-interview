package cl.klawx3.elementsofprogramminginterview;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;


public class ArraysExe {

    public static int deleteDuplicatedByBook(List<Integer> list){
        if(list.isEmpty()){
            return 0;
        }

        int writeIndex = 1;
        for (int i = 1; i < list.size(); i++) {
            if(!list.get(writeIndex - 1).equals(list.get(i))){
                list.set(writeIndex++, list.get(i));
            }
        }

        return writeIndex;

    }

    public static void duplicatedAsAMinimunOf(List<Integer> list, int m){
        int integerCount = 1;
        int lastNumber = list.get(0);
        int deletedElements = 0;
        int addedElements = 0;
        boolean isANewNumber = false;
        for(int i = 1 ; i <= list.size() - deletedElements + addedElements; i++){
            isANewNumber = list.get(i) != lastNumber && integerCount >= m ;

            if(isANewNumber){
                integerCount = 1;
            }

            if(!isANewNumber){
                if(integerCount >= m){
                    list.remove(i);
                    i--;
                    deletedElements++;
                    integerCount--;
                }else{
                    list.add(i,lastNumber);
                    addedElements++;
                    integerCount++;
                }
            }
            lastNumber = list.get(i);
        }
        
    }


    public static int[] deleteDuplicatesFromOrdererArrayV2(int[] arr){
        Map<Integer,Boolean> m = new TreeMap<>();
        for (int i = 0; i < arr.length; i++) {
            m.put(arr[i],true);
        }
        int[] f = new int[m.size()];
        int i = 0;
        for(Integer integer: m.keySet()){
            f[i++] = integer;
        }
        return f;

    }

    public static int[] deleteDuplicatesFromOrdererArray(int[] arr){

        int lastElement = arr[0];
        int deletedElements = 0;
        for (int i = 1; i < arr.length - deletedElements; i++) {
            if(arr[i] == lastElement){
                deletedElements++;
                for(int j = i ; j < arr.length - 1; j++){
                    arr[j] = arr[j + 1];
                }
                i--;
            }
            lastElement = arr[i];
        }
        int[] rVal =  Arrays.copyOfRange(arr, 0, arr.length - deletedElements);
        return rVal;
    }

    public static int[] multiply2ArraysOfIntegers(int[] number1,int[] number2){
        boolean isNegative = number1[0] * number2[0] < 0;
        number1 = normalizeArray(number1);
        number2 = normalizeArray(number2);
        var logResult = number1.length + number2.length;
        int numberLenght =  (int)(logResult) + 1;
        int[] finalResult = new int[numberLenght];
        int shift = 0;
        for(int i = number1.length - 1 ; i >= 0 ; i--){
            for(int j = number2.length - 1, finalArrayIndex = finalResult.length - 1 ; j >= 0 ; j-- , finalArrayIndex--){
                int result = number2[j] * number1[i];
                finalResult[finalArrayIndex - shift] += result;
            }
            shift++;
            
            int leftOver = 0;
            for(int k = finalResult.length - 1 ; k >= 0 ; k--){ //FIXME: for values greater than 3 digits
                int finalResInside = finalResult[k];
                int thisDigitresult = (int) ((finalResInside + leftOver) % 10);
                finalResult[k] = thisDigitresult;
                leftOver = (int) ((int)(finalResInside / 10)) % 10;
            }
        }

        if(finalResult[0] == 0){
            int zeroShift = getZeroQuantity(finalResult);
            int[] newFinalResult = new int[finalResult.length - zeroShift];
            for(int i = 0 ; i < newFinalResult.length; i++){
                newFinalResult[i] = finalResult[i + zeroShift];
            }
            if(isNegative){
                newFinalResult[0] *= -1; 
            }
            return newFinalResult;
        }else{
            if(isNegative){
                finalResult[0]  *= -1;
            }
            return finalResult;
        }        
    }

    public static int getZeroQuantity(int[] numbers){
        int zeroCount = 0;
        int lastNumber = 0;
        for(int i = 0 ; i < numbers.length ; i++){
            if(lastNumber == 0 && numbers[i] == 0){
                zeroCount++;
            }else{
                break;
            }
            lastNumber = numbers[i];
        }
        return zeroCount;
    }

    public static int[] normalizeArray(int[] numbers){
        for(int i = 0 ; i < numbers.length ; i++){
            numbers[i] = numbers[i] < 0 ? numbers[i] * -1  : numbers[i];
        }
        return numbers;
    }

    public static int[] getIncrementOfArrNumber(int[] numbers){
        int leftover = 0;
        for(int i = numbers.length - 1 ; i >= 0 ; i--){
            int n = numbers[i] + leftover;
            if(i == numbers.length - 1){
                n += 1;
            }
            leftover = (n >= 10) ? 1 : 0;
            numbers[i] = n % 10;
        }
        return numbers;
    }
    public static int[] getEvenThenOddV1(int[] arr){
        int[] even = new int[arr.length];
        int[] odd = new int[arr.length];
        int evenIndex = 0,oddIndex = 0;
        
        for(int i = 0 ; i < arr.length ; i++){
            if(arr[i] % 2 == 0){
                even[evenIndex++] = arr[i];
            }else{
                odd[oddIndex++] = arr[i];
            }
        }
            
        int[] finalArr = new int[arr.length];
        boolean insertingEven = true;
        for(int i = 0, evenI = 0, oddI = 0 ; i < arr.length ; i++){
            if(insertingEven && evenI >= evenIndex) insertingEven = false;
            if(insertingEven){
                finalArr[i] = even[evenI++];
            }else{
                finalArr[i] = odd[oddI++];
            }
        }

        return finalArr;
    }

    public static int[] getEvenThenOddV2(int arr[]){

        int oddIndex = arr.length -1;
        for(int i = 0 ; i < arr.length ; i++){
            if(i == oddIndex) break;
            if(arr[i] % 2 != 0){
                int aux = arr[oddIndex];
                arr[oddIndex--] = arr[i];
                arr[i] = aux;
                i--;
            }
        }
        return arr;
    }
}
