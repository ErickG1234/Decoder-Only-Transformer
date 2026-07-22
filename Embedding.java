// You have a weight matrix of shape [vocabSize × embeddingDim]
// /Each row is the embedding vector for one token
// To "embed" a token, you just look up its row in the matrix
// row 0: [0.23, -0.14, 0.87]   ← this is h's embedding
// row 1: [0.55,  0.01, -0.32]  ← this is e's embedding
// row 2: ...

public class Embedding {
    private Matrix weightMatrix;
    private int embeddingDimension; // Same as weightMatrix.getCol() - 16 or 32
    private int vocabSize;

    public Embedding(int userDimension, int userVocabSize) {
        embeddingDimension = userDimension; // how man cols should there be in the matrix?
        vocabSize = userVocabSize;
        weightMatrix = Matrix.random(userVocabSize, embeddingDimension);
    }

    public int getDimension() {
        return embeddingDimension;
    }

    public int getSize() {
        return vocabSize;
    }

    // Converting token indeces into vecotrs (2D array or Matrix)
    public Matrix forward(int[] tokens) {
        double[][] tokenArray = new double[tokens.length][embeddingDimension];
        for (int i = 0; i < tokens.length; i++) {
            for (int j = 0; j < embeddingDimension; j++) {
                tokenArray[i][j] = weightMatrix.getData(tokens[i], j);
            }
        }
        // generaed a fixed positionally encoded Matrix
        Matrix positionEncoded = generatePositionalEncoding(tokens.length);
        Matrix tokenMatrix = new Matrix(tokenArray);

        // Adds the tokenMatrix to the positionMatrix to get a combined Matrix with both
        // elements
        Matrix posEncodedTokenMatrix = Matrix.add(positionEncoded, tokenMatrix);

        return posEncodedTokenMatrix;
    }

    // "dog bites man" vs "man bites dog" — same words, totally different meaning.
    // The model needs to know order.
    // Uses sine anc cosine waves to give each row a richer context even if they are
    // the same word.
    private Matrix generatePositionalEncoding(int seqLength) {
        double[][] matrixData = new double[seqLength][embeddingDimension];
        double doubleDimension = (double) embeddingDimension;
        for (int r = 0; r < seqLength; r++) {
            for (int c = 0; c < embeddingDimension; c++) {
                if (c % 2 == 0) {
                    // 10000^(col / embeddingDim) = controls the frequency (how fast the wave
                    // oscillates).
                    matrixData[r][c] = Math.sin(r / Math.pow(10000, (c / doubleDimension)));
                } else {
                    matrixData[r][c] = Math.cos(r / Math.pow(10000, ((c - 1) / doubleDimension)));
                }
            }
        }
        Matrix positionallyEncodedMatrix = new Matrix(matrixData);
        return positionallyEncodedMatrix;
    }
}
