package cl.klawx3;


import java.util.*;

public class ChapterOne {
    // string have all unique characters
    public boolean stringHaveUniqueCharacters(String string) {
        for (int i = 0; i < string.length(); ++i) {
            char char1 = string.charAt(i);
            for (int j = i + 1; j < string.length(); j++) {
                char char2 = string.charAt(j);
                if (char1 == char2)
                    return false;
            }
        }
        return true;
    }

    public boolean stringHaveUniqueCharactersImproved(String string) {
        Map<Character, Integer> m = new HashMap<>();
        for (int i = 0; i < string.length(); ++i) {
            char char1 = string.charAt(i);
            if (m.get(char1) != null)
                return false;
            m.put(char1, 1);
        }
        return true;
    }

    public boolean stringHaveUniqueCharactersNoDataStructuresOnlyAscii(String string) {
        int buffer = 128;

        boolean[] m = new boolean[buffer];
        for (int i = 0; i < string.length(); ++i) {
            int val = (int) string.charAt(i);
            if (m[val]) return false;
            m[val] = true;
        }
        return true;
    }

    public char[] URLify(char[] string, int length) {
        char SPACE_CHAR = ' ';

        List<Integer> postion = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            if (string[i] == SPACE_CHAR) {
                postion.add(i);
            }
        }

        char[] newString = new char[length + postion.size() * 2];
        int listIndex = 0;
        int steps = 0;
        for (int i = 0; i < length + postion.size() * 2; i++) {
            if (i - steps == postion.get(listIndex)) {
                newString[i++] = '%';
                newString[i++] = '2';
                newString[i] = '0';
                steps += 2;
                if (postion.size() - 1 != listIndex)
                    listIndex++;
            } else {
                newString[i] = string[i - steps];
            }
        }
        return newString;
    }

    public Optional<List<String>> getPalidromePermutation(String word){
        char[] preparedWord = word.toLowerCase(Locale.ROOT).toCharArray();
        int startValidChar = (int) 'a';
        int endValidChar = (int) 'z';
        int INVALID_CHAR = -1;


        // fill invalid as -1
        int[] invalidChar = new int[preparedWord.length];
        for(int i = 0 ; i < invalidChar.length ; i++){
            invalidChar[i] = INVALID_CHAR;
        }

        //invalid char index
        int invalidCharI = 0;
        for(int i = 0; i < invalidChar.length ; i++){
            if( ((int)preparedWord[i]) < startValidChar || ((int)preparedWord[i]) > endValidChar){
                invalidChar[invalidCharI++] = i;
            }
        }
        //sanitize charArr
        char[] sanetizedWord = new char[preparedWord.length - invalidCharI];
        int skipingCharIndex = 0;
        for(int i = 0; i< preparedWord.length;i++){
            if(invalidChar[skipingCharIndex] != -1){
                if(invalidChar[skipingCharIndex] == i){
                   skipingCharIndex++;
                }else{
                    sanetizedWord[i - skipingCharIndex] = preparedWord[i];
                }
            }else{
                sanetizedWord[i - skipingCharIndex] = preparedWord[i];
            }
        }
        // permute palindrome
        for(int i = 0 ; i < sanetizedWord.length ; i++){
            for(int j = 0; j < sanetizedWord.length; j--){

            }
        }
        //check palindrome
        boolean palindrome = true;
        for(int i = 0 , j = preparedWord.length - 1 ; i != j ; i++ , j--){
            if(preparedWord[i] != preparedWord[j]){
                palindrome = false;
                break;
            }
        }

        return null;
    }

    public boolean oneAway(String originalString,String modifiedString){
        // inserted character
        if(modifiedString.length() - originalString.length() == 1) {
            for (int i = 0, j = 0; i < modifiedString.length(); ) {
                char originalChar = originalString.charAt(i);
                char modifiedChar = modifiedString.charAt(j);
                if (originalChar == modifiedChar) {
                    j++;
                    i++;
                } else {
                    if (j - i == 1) return false;
                    j++;
                }
            }
        }

        if(originalString.length() - modifiedString.length() == 1){
            for(int i = 0 , j = 0; j < modifiedString.length() ; ){
                char originalChar = originalString.charAt(i);
                char modifiedChar = modifiedString.charAt(j);
                if(originalChar == modifiedChar ){
                    j++;
                    i++;
                }else{
                    if(i - j == 1) return false;
                    i++;
                }
            }
        }

        if(originalString.length() == modifiedString.length()){
            int changedChars = 0;
            for(int i = 0 ; i < originalString.length() ; i++){
                char originalChar = originalString.charAt(i);
                char modifiedChar = modifiedString.charAt(i);
                if(originalChar != modifiedChar ){
                    changedChars++;
                    if(changedChars > 1) return false;
                }
            }
        }

        return true;

    }

    public String stringCompression(String originalString){
        char[] compressedString = new char[originalString.length()];
        char lastCharacter = ' ';
        int compressedStringIndex = 0;
        int charBufferCount = 1;
        for(int i = 0 ; i < originalString.length() ; i++){
             //if(i == 0) lastCharacter = originalString.charAt(i);
            if(originalString.charAt(i) != lastCharacter && i != 0){
                compressedString[compressedStringIndex++] = lastCharacter;
                if (compressedStringIndex > originalString.length()) return originalString;
                compressedString[compressedStringIndex++] = (char) (charBufferCount + '0');
                if (compressedStringIndex > originalString.length()) return originalString;
                charBufferCount = 1;
            }else if(i != 0){
                charBufferCount++;
            }
            lastCharacter = originalString.charAt(i);
        }
        compressedString[compressedStringIndex++] = lastCharacter;
        if (compressedStringIndex > originalString.length()) return originalString;
        compressedString[compressedStringIndex++] = (char) (charBufferCount + '0');
        if (compressedStringIndex > originalString.length()) return originalString;
        return new String(compressedString).trim();
    }

    public int[][] zeroMatrix(int[][] matrix) {
        List<int[]> listOfZeros = new ArrayList<int[]>();
        int[][] result = new int[matrix.length][matrix[0].length];
        for(int i = 0 ; i < matrix.length ; ++i){
            for(int j = 0 ; j < matrix[0].length; ++j){
                result[i][j] = matrix[i][j];
                if(matrix[i][j] == 0){
                    listOfZeros.add(new int[]{i,j});
                }
            }
        }
        for(int[] values : listOfZeros){
            int i = values[0];
            int j = values[1];
            for(int m = 0; m < matrix[0].length ; m++){
                result[i][m] = 0;
            }
            for(int m = 0; m < matrix.length ; m++){
                result[m][j] = 0;
            }
        }
        printMatrix(result);
        return result;
    }

    private void printMatrix(int[][] m){
        for(int i = 0 ; i < m.length ; i++){
            for(int j = 0 ; j < m[i].length ; j++){
                System.out.print(m[i][j]+"\t");
            }
            System.out.println();
        }
    }
}
