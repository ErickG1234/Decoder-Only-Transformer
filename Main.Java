import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        double[][] dataA = { { 1, 2, 3 }, { 4, 5, 6 } };
        double[][] dataB = { { 7, 8 }, { 9, 10 }, { 11, 12 } };
        double[][] softmax = { { 1, 2, 3 }, { 1, 1, 1 } };
        Matrix matrixA = new Matrix(dataA);
        Matrix matrixB = new Matrix(dataB);
        Matrix matrixC = new Matrix(softmax);

        Matrix product = Matrix.multiply(matrixA, matrixB);

        matrixC.softmax();

        System.out.println("Matrix Multiplication product: " + product);
        System.out.println("Softmax data: " + matrixC);

        Tokenizer token = new Tokenizer("hello");

        int[] encoded = token.encode("hello");
        // Print memory address so need to call toString inthe print statement to print
        // the actual array
        String decoded = token.decode(encoded);

        System.out.println("Encoded: " + Arrays.toString(encoded));
        System.out.println("Decoded: " + decoded);

        Embedding matrixEmbedding = new Embedding(4, token.getSize());
        Matrix embeddedMatrix = matrixEmbedding.forward(encoded);
        
        // TODO (After Lunch): Test positional encoding! 
        // 1. Print the raw token embeddings (maybe print tokenArray from inside Embedding temporarily, or comment out the add step)
        // 2. Print embeddedMatrix (which now has positional encoding added) 
        // 3. See how the values changed!
        System.out.println("Embedded Matrix: " + embeddedMatrix);    }
}