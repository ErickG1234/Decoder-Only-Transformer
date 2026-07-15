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

    }
}