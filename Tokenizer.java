import java.util.Map;
import java.util.HashMap;

public class Tokenizer {
    private char[] numToChar;
    private HashMap<Character, Integer> charToNum;
    private int vocabSize;

    public Tokenizer(String text) {
        int charCounter = 0;
        charToNum = new HashMap<Character, Integer>();

        numToChar = text.toCharArray();

        for (int i = 0; i < numToChar.length; i++) {
            // if char not in text
            if (!(charToNum.containsKey(numToChar[i]))) {
                charToNum.put(numToChar[i], charCounter);
                charCounter++;
            }
        }

        numToChar = new char[charToNum.size()];
        // Returns a Set view of the mappings contained in this map.
        // each Entry has a .getValue() and .getKey() function
        for (Map.Entry<Character, Integer> entry : charToNum.entrySet()) {
            numToChar[entry.getValue()] = entry.getKey();
        }

        vocabSize = charToNum.size();
    }

    public char getChar(int index) {
        return numToChar[index];
    }

    public int getInt(char letter) {
        return charToNum.get(letter);
    }

    public int getSize() {
        return vocabSize;
    }

    public int[] encode(String word) { // text to numbers
        char[] wordChars = word.toCharArray();
        int[] wordValues = new int[word.length()];
        for (int i = 0; i < word.length(); i++) {
            wordValues[i] = token.getInt(wordChars[i]);
        }
        return wordValues;
    }

    public String decode(int[] nums) { // numbers to text
        String word = "";
        char[] charArray = new char[nums.length - 1];
        for (int i = 0; i < nums.length; i++) {
            char letter = token.getChar(nums[i]);
            charArray[i] = letter;
            word += letter;
        }
        return word;
    }

}
