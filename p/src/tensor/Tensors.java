package tensor;

public class Tensors {
    public static int CONCAT_DIRECTION_HORIZONTAL = 0;
    public static int CONCAT_DIRECTION_VERTICAL = 1;

    //전달받은 두 스칼라의 덧셈이 가능하다.
    public static Scalar add(Scalar a, Scalar b) throws CloneNotSupportedException {
        return ScalarImpl.add(a, b);
    }

    //전달받은 두 스칼라의 곱셈이 가능하다.
    public static Scalar mul(Scalar a, Scalar b) throws CloneNotSupportedException {
        return ScalarImpl.mul(a, b);
    }

    //전달받은 두 벡터의 덧셈이 가능하다. (길이가 같을 때)
    public static Vector add(Vector a, Vector b) throws SizeMismatchException, CloneNotSupportedException {
        return VectorImpl.add(a, b);
    }

    //전달받은 스칼라와 벡터의 곱셈이 가능하다. (벡터의 모든 요소에 스칼라를 곱한다.)
    public static Vector mul(Vector a, Scalar b) throws CloneNotSupportedException {
        return VectorImpl.mul(a, b);
    }

    //전달받은 두 행렬의 덧셈이 가능하다. (크기가 같을 때)
    public static Matrix add(Matrix a, Matrix b) throws SizeMismatchException, CloneNotSupportedException {
        return MatrixImpl.add(a, b);
    }

    //전달받은 두 행렬의 곱셈이 가능하다. ((mxn)x(nxl)일 때)
    public static Matrix mul(Matrix a, Matrix b) throws SizeMismatchException, CloneNotSupportedException {
        return MatrixImpl.mul(a, b);
    }

    //행렬은 다른 행렬과 가로로 합쳐질 수 있다. (두 행렬의 행 수가 같아야 가능)
    //행렬은 다른 행렬과 세로로 합쳐질 수 있다. (두 행렬의 열 수가 같아야 가능)
    //concat(a,b,Tensors.CONCAT_DIRECTION_HORIZONTAL)이런식으로 사용
    public static Matrix concat(Matrix a, Matrix b, int direction) throws SizeMismatchException {
        return MatrixImpl.concat(a, b, direction);
    }

}
