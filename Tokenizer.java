import java.util.Map;
import java.util.HashMap;

public class Tokenizer {
    private char[] numToChar;
    private HashMap<Character, Integer> charToNum;
    private int vocabSize;

    public Tokenizer(String text) {
        int charCounter = 0;
        charToNum = new HashMap<Character, Integer>();
        numToChar = new char[text.length()];

        numToChar = text.toCharArray();

        for (int i = 0; i < numToChar.length; i++) {
            // if char not in text
            if (!(charToNum.containsKey(numToChar[i]))) {
                charToNum.put(numToChar[i], charCounter);
                charCounter++;
            }
        }

        // ==========================================
        // TODO (After Lunch! 🌮):
        // 1. Right now, `numToChar` is initialized to the size of the whole text, and
        // holds every character (including duplicates). We want it to be exactly
        // the size of our vocabulary, and only hold unique characters.
        // 2. Hint: After the loop above finishes, what does `charToNum.size()` tell us?
        // 3. Set `vocabSize` to that number.
        // 4. Re-initialize `numToChar` to be that exact size.
        // 5. Loop through the `charToNum` map to populate `numToChar` so that
        // the array index matches the ID assigned to each character.
        // ==========================================
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

    public int[] encode() { // text to numbers
        return null;
    }

    public String decode() { // numbers to text
        return null;
    }

}
