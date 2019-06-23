package tensor;

import java.util.ArrayList;
import java.util.List;

class VectorImpl implements Vector {
    List<Scalar> list;

    private VectorImpl() {
        list = new ArrayList<>();
    }

    VectorImpl(int dimension, Double value) throws SizeLessThanZeroException {
        this();
        setVector(dimension, value);
    }

    VectorImpl(int dimension, Scalar scalar) throws SizeLessThanZeroException {
        this();
        setVector(dimension, scalar);
    }

    VectorImpl(int dimension, Double i, Double j) throws SizeLessThanZeroException {
        this();
        setVector(dimension, i, j);
    }

    VectorImpl(int dimension, Scalar i, Scalar j) throws SizeLessThanZeroException {
        this();
        setVector(dimension, i, j);
    }

    VectorImpl(Double[] arr) throws SizeLessThanZeroException {
        this();
        setVector(arr);
    }

    VectorImpl(Scalar[] arr) throws SizeLessThanZeroException {
        this();
        setVector(arr);
    }

    //전달받은 두 벡터의 덧셈이 가능하다. (길이가 같을 때)
    static Vector add(Vector a, Vector b) throws SizeMismatchException, CloneNotSupportedException {
        if (a.getSize() != b.getSize()) {
            throw new SizeMismatchException();
        }
        return ((Vector) a.clone()).add(b);
    }

    //전달받은 스칼라와 벡터의 곱셈이 가능하다. (벡터의 모든 요소에 스칼라를 곱한다.)
    static Vector mul(Vector a, Scalar b) throws CloneNotSupportedException {
        return ((Vector) a.clone()).mul(b);
    }

    @Override
    public void setVector(int dimension, Double value) throws SizeLessThanZeroException {
        list = new ArrayList<>();
        for (int i = 0; i < dimension; i++) {
            list.add(new ScalarImpl(value));
        }
    }

    @Override
    public void setVector(int dimension, Scalar scalar) throws SizeLessThanZeroException {
        list = new ArrayList<>();

        for (int i = 0; i < dimension; i++) {
            list.add(scalar);
        }
    }

    @Override
    public void setVector(int dimension, Double i, Double j) throws SizeLessThanZeroException {
        list = new ArrayList<>();

        for (int k = 0; k < dimension; k++) {
            Double value = Math.random() * (j - i) + i;
            list.add(new ScalarImpl(value));
        }
    }

    @Override
    public void setVector(int dimension, Scalar i, Scalar j) throws SizeLessThanZeroException {
        list = new ArrayList<>();

        for (int k = 0; k < dimension; k++) {
            Double value = Math.random() * (j.getValue() - i.getValue()) + i.getValue();
            list.add(new ScalarImpl(value));
        }
    }

    @Override
    public void setVector(Double[] arr) throws SizeLessThanZeroException {
        list = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            list.add(new ScalarImpl(arr[i]));
        }
    }

    @Override
    public void setVector(Scalar[] arr) throws SizeLessThanZeroException {
        list = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            list.add(new ScalarImpl(arr[i]));
        }
    }

    @Override
    public void update(int col, Scalar scalar) throws IndexOutOfBoundException {
        list.get(col).setValue(scalar.getValue());
    }

    @Override
    public Scalar getScalar(int col) throws IndexOutOfBoundException {
        return list.get(col);
    }

    @Override
    public int getSize() {
        return list.size();
    }

    @Override
    public Vector add(Vector vector) throws SizeMismatchException {
        if (this.getSize() != vector.getSize()) {
            throw new SizeMismatchException();
        }

        Vector v = new VectorImpl(this.getSize(), 0.0);

        for (int i = 0; i < this.getSize(); i++) {
            v.update(i, vector.getScalar(i));
        }

        return v;
    }

    @Override
    public Vector mul(Scalar scalar) {
        Vector v = new VectorImpl(this.getSize(), 0.0);

        for (int i = 0; i < this.getSize(); i++) {
            v.update(i, new ScalarImpl(v.getScalar(i).getValue() * scalar.getValue()));
        }
        return v;
    }

    @Override
    public Matrix toMatrixNx1() {
        Matrix matrix = new MatrixImpl(1, this.getSize(), 0.0);

        for (int i = 0; i < this.getSize(); i++) {
            matrix.getVectorRow(0).update(i, this.getScalar(i));
        }

        return matrix;
    }

    @Override
    public Matrix toMatrix1xN() {
        // TODO 맞는건가? 확실하지 않음..
        Matrix matrix = new MatrixImpl(this.getSize(), 1, 0.0);

        for (int i = 0; i < this.getSize(); i++) {
            matrix.getVectorCol(0).update(i, this.getScalar(i));
        }

        return matrix;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        Vector v = (Vector) super.clone();
        v.setVector(getSize(), 0.0);
        for (int i = 0; i < getSize(); i++) {
            v.update(i, getScalar(i));
        }
        return v;
    }

    @Override
    public boolean equals(Object obj) {
        Vector vector = (Vector) obj;

        if (this.getSize() == vector.getSize()) {
            for (int i = 0; i < this.getSize(); i++) {
                if (this.getScalar(i).getValue() != vector.getScalar(i).getValue()) {
                    return false;
                }
            }
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        String str = "";

        for (int i = 0; i < getSize(); i++) {
            str += this.getScalar(i).getValue() + " ";
        }

        return str;
    }
}
