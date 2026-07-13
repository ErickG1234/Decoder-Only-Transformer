import java.util.Random;

public class Matrix {
    private int row;
    private int col;
    private double[][] data;

    public Matrix(double[][] userData) {
        // Instead of row = user row, user already has the userData 2D array, so we can
        // do this instead to prevent errors and reduce redundancy
        row = userData.length;
        col = userData[0].length;
        data = new double[row][col];
        for (int rows = 0; rows < data.length; rows++) {
            for (int cols = 0; cols < data[rows].length; cols++) {
                data[rows][cols] = userData[rows][cols];
            }
        }
    }

    // Random Constructor for actual testing (Could use random seeds for testing and
    // predictability, then switch for functionality)
    public Matrix(int row, int col) {
        this.row = row;
        this.col = col;
        data = new double[row][col];

        Random randomSeed = new Random(67);
        for (int rows = 0; rows < data.length; rows++) {
            for (int cols = 0; cols < data[rows].length; cols++) {
                data[rows][cols] = randomSeed.nextDouble();
            }
        }
    }

    public int getRow() {
        return this.row;
    }

    public int getCol() {
        return this.col;
    }

    public double getData(int row, int col) {
        return data[row][col];
    }

    // [1 2] [1 3 5]
    // [3 4] --> [2 4 6]
    // [5 6]
    // From (3x2) --> (2x3)

    public Matrix transpose() {
        Matrix myMatrix = new Matrix(this.col, this.row);

        for (int row = 0; row < data.length; row++) {
            for (int col = 0; col < data[row].length; col++) {
                myMatrix.data[col][row] = this.data[row][col];
            }
        }

        return myMatrix;
    }

    public static Matrix add(Matrix matrix1, Matrix matrix2) {
        if (matrix1.row != matrix2.row || matrix1.col != matrix2.col) {
            throw new IllegalArgumentException("Matrices need to have the same dimensions.");
        }

        Matrix arraySum = new Matrix(matrix1.row, matrix1.col);
        for (int r = 0; r < matrix1.row; r++) {
            for (int c = 0; c < matrix1.col; c++) {
                arraySum.data[r][c] = matrix1.data[r][c] + matrix2.data[r][c];
            }
        }
        return arraySum;
    }

    // Matrix A's cols must equal Matrix B's rows for matrices to be multiplied: 2x3
    // * 3x2 ✅
    // Multiply Matrix A row to Matrix B column: write stuff here
    // LEFT OFF HERE
    public static Matrix multiplication(Matrix matrixA, Matrix matrixB) {
        if (matrixA.col != matrixB.row) {
            throw new IllegalArgumentException("Matrix A's cols must equal Matrix B's rows.");
        }
        Matrix matrixProduct = new Matrix(matrixA.row, matrixB.col);
        for (int r = 0; r < matrixA.row; r++) {
            for (int c = 0; c < matrixB.col; c++) {
                matrixProduct.data[r][c] = matrixA.data[r][c] * matrixB.data[r][c];
            }
        }
        return matrixProduct;
    }

}
