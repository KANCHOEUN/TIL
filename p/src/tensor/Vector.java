package tensor;

/*
예외 클래스들 설명
- 전체
    - 0보다 작은 크기 : SizeLessThanZeroException
    - (벡터,행렬 범위 넘은 접근) : IndexOutOfBoundException
- 행렬
    - csv형식 틀린거 : WrongCSVFormatException
    - 곱셈 : 크기 다른거 : SizeMismatchException
    - 덧셈 : 크기 다른거 : SizeMismatchException
    - 역행렬 : 판별식 0인거 : NonInvertibleMatrixException
    - 정방행렬 아닌거 : NonSquareMatrixException
- 벡터
    - 덧셈 : 크기 다른거 : SizeMismatchException
 */
/*
    (implements Comparable) 스칼라의 경우 값의 대소 비교를 할 수 있다.
    주의 : clone()함수 오버라이딩 꼭 하세요.
 */
public interface Vector extends Cloneable {


    //지정한 하나의 값을 모든 요소의 값으로 하는 n-차원 벡터를 생성할 수 있다.
    void setVector(int dimension, Double value) throws SizeLessThanZeroException;

    //지정한 하나의 값을 모든 요소의 값으로 하는 n-차원 벡터를 생성할 수 있다.
    void setVector(int dimension, Scalar scalar) throws SizeLessThanZeroException;

    //i 이상 j 미만의 무작위 값을 요소로 하는 n-차원 벡터를 생성할 수 있다.
    void setVector(int dimension, Double i, Double j) throws SizeLessThanZeroException;

    //i 이상 j 미만의 무작위 값을 요소로 하는 n-차원 벡터를 생성할 수 있다.
    void setVector(int dimension, Scalar i, Scalar j) throws SizeLessThanZeroException;

    //1차원 배열로부터 n-차원 벡터를 생성할 수 있다.
    void setVector(Double[] arr) throws SizeLessThanZeroException;

    //1차원 배열로부터 n-차원 벡터를 생성할 수 있다.
    void setVector(Scalar[] arr) throws SizeLessThanZeroException;

    // 특정 위치의 요소를 지정/조회할 수 있다. (스칼라로 입출력)
    void update(int col, Scalar scalar) throws IndexOutOfBoundException;

    // 특정 위치의 요소를 지정/조회할 수 있다. (스칼라로 입출력)
    Scalar getScalar(int col) throws IndexOutOfBoundException;

    //크기 정보를 조회할 수 있다. (벡터는 차원, 행렬은 행개수, 열개수)
    int getSize();

    //벡터는 다른 벡터와 덧셈이 가능하다. (길이가 같을 때)
    Vector add(Vector vector) throws SizeMismatchException;

    //벡터는 다른 스칼라와 곱셈이 가능하다. (벡터의 모든 요소에 스칼라를 곱한다.)
    Vector mul(Scalar scalar);

    //n-차원 벡터 객체는 자신으로부터 nx1 행렬을 생성하여 반환할 수 있다.
    Matrix toMatrixNx1();

    //n-차원 벡터 객체는 자신으로부터 1xn 행렬을 생성하여 반환할 수 있다.
    Matrix toMatrix1xN();

    //클론 함수 오버라이딩
    Object clone() throws CloneNotSupportedException;
}
