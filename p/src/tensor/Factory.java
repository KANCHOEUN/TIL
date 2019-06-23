package tensor;

public class Factory {

    public static Scalar getScalar(double value) {
        return new ScalarImpl(value);
    }

    public static Scalar getScalar(Scalar value) {
        return new ScalarImpl(value);
    }

    public static Scalar getScalar(double i, double j) {
        return new ScalarImpl(i, j);
    }

    public static Scalar getScalar(Scalar i, Scalar j) {
        return new ScalarImpl(i, j);
    }

    public static Vector getVector(int dimension, Double value) throws SizeLessThanZeroException {
        return new VectorImpl(dimension, value);
    }

    public static Vector getVector(int dimension, Scalar scalar) throws SizeLessThanZeroException {
        return new VectorImpl(dimension, scalar);
    }

    public static Vector getVector(int dimension, Double i, Double j) throws SizeLessThanZeroException {
        return new VectorImpl(dimension, i, j);
    }

    public static Vector getVector(int dimension, Scalar i, Scalar j) throws SizeLessThanZeroException {
        return new VectorImpl(dimension, i, j);
    }

    public static Vector getVector(Double[] arr) throws SizeLessThanZeroException {
        return new VectorImpl(arr);
    }

    public static Vector getVector(Scalar[] arr) throws SizeLessThanZeroException {
        return new VectorImpl(arr);
    }

    public static Matrix getMatrix(int row, int col, Double value) throws SizeMismatchException {
        return new MatrixImpl(row, col, value);
    }

    public static Matrix getMatrix(int row, int col, Scalar scalar) throws SizeMismatchException {
        return new MatrixImpl(row, col, scalar);
    }

    public static Matrix getMatrix(int row, int col, Double i, Double j) throws SizeMismatchException {
        return new MatrixImpl(row, col, i, j);
    }

    public static Matrix getMatrix(int row, int col, Scalar i, Scalar j) throws SizeMismatchException {
        return new MatrixImpl(row, col, i, j);
    }

    public static Matrix getMatrix(String csv) throws SizeMismatchException, WrongCSVFormatException {
        return new MatrixImpl(csv);
    }

    public static Matrix getMatrix(Double[][] arr) throws SizeMismatchException {
        return new MatrixImpl(arr);
    }

    public static Matrix getMatrix(Scalar[][] arr) throws SizeMismatchException {
        return new MatrixImpl(arr);
    }

    public static Matrix getMatrix(int n) throws SizeLessThanZeroException {
        return new MatrixImpl(n);
    }

}
