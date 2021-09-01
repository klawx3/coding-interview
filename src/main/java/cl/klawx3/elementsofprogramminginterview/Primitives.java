package cl.klawx3.elementsofprogramminginterview;

public class Primitives {

    public static boolean isNumberAPalindrome(int number){
        int numberOfBits = Math.log(number) / Math.log(2) + 1;
        
    }

    public static int swapBit(int value, int bit1, int bit2) {
        System.out.println("VALUE: " + Integer.toBinaryString(value));

        int mask_1 = (1 << bit1);
        int mask_2 = (1 << bit2);

        int result1 = mask_1 & value;
        int result2 = mask_2 & value;

        if (result1 != 0 && result2 != 0 || result1 == 0 && result2 == 0) {
        } else {
            value = (result1 == 0) ? value | mask_1 : value ^ mask_1;
            value = (result2 == 0) ? value | mask_2 : value ^ mask_2;
        }
        System.out.println("VALUE: " + Integer.toBinaryString(value));
        return value;
    }

    public static int findAClosetIntegerWithTheSameWeight(int number) {
        
        int weight = getBitWeight(number);

        for (int i = number + 1,j = number - 1; ;i++ , j--) {
            int pos = getBitWeight(i);
            int neg = getBitWeight(j);
            if(pos == weight){
                return i;
            }else if(neg == weight){
                return j;
            }
        }
    }

    public static int findAClosetIntegerWithTheSameWeightV2(int number) {
        int weight = getBitWeight(number);
        int highOnBit = (int) (Math.log(number) / Math.log(2) + 1);
       // int lowOnBit = 

        return 0;
    }

    // public static int getLowOnBit(number){
        
    // }

    public static int getBitWeight(int number){
        int weight = 0;
        while (number != 0) {
            if ((number & 1) == 1) {
                weight++;
            }
            number >>= 1;
        }
        return weight;
    }

}
