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

    // Zero-Filled Constructor - decided to change for multiplication and addition
    // method
    // Will use the Static method random for predictablity and testing
    public Matrix(int row, int col) {
        this.row = row;
        this.col = col;
        data = new double[row][col];
    }

    public static Matrix random(int row, int col) {
        Matrix randomMatrix = new Matrix(row, col);

        Random randomSeed = new Random(67);
        for (int rows = 0; rows < row; rows++) {
            for (int cols = 0; cols < col; cols++) {
                randomMatrix.data[rows][cols] = randomSeed.nextDouble();
            }
        }
        return randomMatrix;
    }

    // @Override replaces the default Object.toString() (which prints
    // ClassName@address)
    // with our own version. println(matrix) automatically calls matrix.toString().
    // This method BUILDS and RETURNS a String — it doesn't print anything itself.
    @Override
    public String toString() {
        String result = "";
        for (int i = 0; i < this.row; i++) {
            for (int j = 0; j < this.col; j++) {
                result += data[i][j] + " "; // Java auto-converts double to String via +
            }
            result += "\n"; // newline after each row
        }
        return result;
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
    // Then, MatrixA row and MatrixB col make up the dimensions for the new matrix
    // (2x2)
    // Multiple each element in the row of Matrix A to each element in Column B
    // Ex: ([0][0] * [0][0]) + ([0][1] + [1][0]) + ([0][2] + [2][0]) ... ect
    // Do this for all rows and columns then you have your new array!!
    public static Matrix multiply(Matrix matrixA, Matrix matrixB) {
        if (matrixA.col != matrixB.row) {
            throw new IllegalArgumentException("Matrix A's cols must equal Matrix B's rows.");
        }
        Matrix matrixProduct = new Matrix(matrixA.row, matrixB.col);
        for (int r = 0; r < matrixA.row; r++) {
            for (int c = 0; c < matrixB.col; c++) {
                for (int pair = 0; pair < matrixB.row; pair++) {
                    matrixProduct.data[r][c] += matrixA.data[r][pair] * matrixB.data[pair][c];
                }
            }
        }
        return matrixProduct;
    }

    // Mutates in place — during the transformer forward pass, we scale values
    // (e.g., dividing attention scores by √d_k) and don't need the originals.
    // Returns 'this' to allow method chaining (e.g.,
    // matrix.scalarMultiply(0.5).transpose())
    public Matrix scalarMultiply(double scalarNum) {
        for (int r = 0; r < this.row; r++) {
            for (int c = 0; c < this.col; c++) {
                this.data[r][c] = this.data[r][c] * scalarNum;
            }
        }
        return this;
    }

    // Left off here
    // Answer to previous prompt: Should'nt softmax be applied to each row? Since
    // each row kind of holds the attntions for the tokens i think, it makes more
    // sense to apply it to each row rather than the whole matrix, atleast thats
    // what i think but what do you think?
    public Matrix softmax(double[][] attentionScores) {
        double softmaxNum = 0;
        int endOfScores = attentionScores.length - 1;
        double[] probabilityDistribution = new double[attentionScores.length];

        for (int r = 0; r < attentionScores.length; r++) {
            for (int j = 0; j < attentionScores[0].length; j++) {
                if (endOfScores == j) {
                    softmaxNum += Math.exp // finish this
                    probabilityDistribution[r] = softmaxNum;
                    softmaxNum = 0;



                }
                attentionScores[r][j] = Math.exp
            }
        }

    }

}
