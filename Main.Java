public class Main {
    public static void main(String[] args) {

        double[][] dataA = { { 1, 2, 3 }, { 4, 5, 6 } };
        double[][] dataB = { { 7, 8 }, { 9, 10 }, { 11, 12 } };
        Matrix matrixA = new Matrix(dataA);
        Matrix matrixB = new Matrix(dataB);

        Matrix product = Matrix.multiplication(matrixA, matrixB);

        System.out.println("Matrix Multiplication product: " + product);

    }
}