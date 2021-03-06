import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class MatrixTest {

    @Test
    void addN() {
        double n = 1;
        int rows = 2;
        int cols = 3;

        Matrix m = new Matrix(rows, cols);
        double[][] originalMatrix = new double[][]{{1.0, 2.0, 3.0}, {4.0, 5.0, 6.0}};

        m.setMatrix(originalMatrix);
        Matrix result = m.add(n);

        double[][] resultMatrix = result.getMatrix();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                assertEquals(resultMatrix[i][j], originalMatrix[i][j]+n);
            }
        }
    }

    @Test
    void addMatrix() {
        int rows = 2;
        int cols = 3;

        Matrix a = new Matrix(rows, cols);
        double[][] aMatrix = new double[][]{{1.0, 2.0, 3.0}, {4.0, 5.0, 6.0}};
        a.setMatrix(aMatrix);

        Matrix b = new Matrix(rows, cols);
        double[][] bMatrix = new double[][]{{2.0, 3.5, 1.0}, {1.2, 1.3, 0.8}};
        b.setMatrix(bMatrix);

        Matrix result = a.add(b);
        double[][] resultMatrix = result.getMatrix();
        double[][] expected = new double[][]{{3.0, 5.5, 4.0}, {5.2, 6.3, 6.8}};

        for (int i = 0; i < resultMatrix.length; i++) {
            for (int j = 0; j < resultMatrix[0].length; j++) {
                assertEquals(resultMatrix[i][j], expected[i][j]);
            }
        }
    }

    @Test
    void multiplyByN() {
        double n = 2;
        int rows = 2;
        int cols = 3;

        Matrix m = new Matrix(rows, cols);
        double[][] originalMatrix = new double[][]{{1.0, 2.0, 3.0}, {4.0, 5.0, 6.0}};

        m.setMatrix(originalMatrix);
        Matrix result = m.multiply(n);

        double[][] resultMatrix = result.getMatrix();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                assertEquals(resultMatrix[i][j], originalMatrix[i][j]*n);
            }
        }
    }

    @Test
    void multiplyByMatrix() {
        int rows = 2;
        int cols = 3;

        Matrix a = new Matrix(rows, cols);
        double[][] aMatrix = new double[][]{{1.0, 2.0, 3.0}, {4.0, 5.0, 6.0}};
        a.setMatrix(aMatrix);

        Matrix b = new Matrix(cols, rows);
        double[][] bMatrix = new double[][]{{7.0, 8.0}, {9.0, 10.0}, {11.0, 12.0}};
        b.setMatrix(bMatrix);

        Matrix result = a.multiply(b);
        double[][] resultMatrix = result.getMatrix();
        double[][] expected = new double[][]{{58, 64}, {139, 154}};

        for (int i = 0; i < resultMatrix.length; i++) {
            for (int j = 0; j < resultMatrix[0].length; j++) {
                assertEquals(resultMatrix[i][j], expected[i][j]);
            }
        }
    }

    @Test
    void subtractN() {
        double n = 1;
        int rows = 2;
        int cols = 2;

        Matrix m = new Matrix(rows, cols);
        double[][] originalMatrix = new double[][]{{1.0, 2.0}, {4.0, 5.0}};

        m.setMatrix(originalMatrix);
        Matrix result = m.subtract(n);

        double[][] resultMatrix = result.getMatrix();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                assertEquals(resultMatrix[i][j], originalMatrix[i][j]-n);
            }
        }
    }

    @Test
    void subtractMatrix() {
        int rows = 2;
        int cols = 2;

        Matrix a = new Matrix(rows, cols);
        double[][] aMatrix = new double[][]{{0.0, 1.0}, {3.0, 2.0}};
        a.setMatrix(aMatrix);

        Matrix b = new Matrix(cols, rows);
        double[][] bMatrix = new double[][]{{-1.0, 3.0}, {0.0, 5.0}};
        b.setMatrix(bMatrix);

        Matrix result = a.subtract(b);
        double[][] resultMatrix = result.getMatrix();
        double[][] expected = new double[][]{{1, -2}, {3, -3}};

        for (int i = 0; i < resultMatrix.length; i++) {
            for (int j = 0; j < resultMatrix[0].length; j++) {
                assertEquals(resultMatrix[i][j], expected[i][j]);
            }
        }
    }

    @Test
    void transpose() {
        int rows = 4;
        int cols = 3;

        Matrix a = new Matrix(rows, cols);
        double[][] aMatrix = new double[][]{{1, 0, -1}, {2, 7, -5}, {4, -3, 2}, {-1, 3, 0}};
        a.setMatrix(aMatrix);

        Matrix result = a.transpose();
        double[][] resultMatrix = result.getMatrix();

        double[][] expected = new double[][]{{1, 2, 4, -1}, {0, 7, -3, 3}, {-1, -5, 2, 0}};

        for (int i = 0; i < cols; i++) {
            for (int j = 0; j < rows; j++) {
                assertEquals(expected[i][j], resultMatrix[i][j]);
            }
        }
    }

}
