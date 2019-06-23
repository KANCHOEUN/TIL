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
public interface Matrix extends Cloneable {
    //지정한 하나의 값을 모든 요소의 값으로 하는 m x n 행렬을 생성할 수 있다.
    void setMatrix(int row, int col, Double value) throws SizeLessThanZeroException;

    //지정한 하나의 값을 모든 요소의 값으로 하는 m x n 행렬을 생성할 수 있다.
    void setMatrix(int row, int col, Scalar scalar) throws SizeLessThanZeroException;

    //i 이상 j 미만의 무작위 값을 요소로 하는 m x n 행렬을 생성할 수 있다.
    void setMatrix(int row, int col, Double i, Double j) throws SizeLessThanZeroException;

    //i 이상 j 미만의 무작위 값을 요소로 하는 m x n 행렬을 생성할 수 있다.
    void setMatrix(int row, int col, Scalar i, Scalar j) throws SizeLessThanZeroException;

    //csv 파일로부터 m x n 행렬을 생성할 수 있다. csv 파일 형식: comma(,)는 열 구분자, 라인은 행 구분자 2 x 4 행렬 예) 1, 2, 3, 4, 2 x 4 행렬 예) 5, 6, 7, 8
    void setMatrix(String csv) throws SizeLessThanZeroException, WrongCSVFormatException;

    //2차원 배열로부터 m x n 행렬을 생성할 수 있다.
    void setMatrix(Double[][] arr) throws SizeLessThanZeroException;

    //2차원 배열로부터 m x n 행렬을 생성할 수 있다.
    void setMatrix(Scalar[][] arr) throws SizeLessThanZeroException;

    //단위 행렬을 생성할 수 있다.
    void setMatrix(int n) throws SizeLessThanZeroException;//단위 행

    // 특정 위치의 요소를 지정/조회할 수 있다. (스칼라로 입출력)
    void update(int row, int col, Scalar scalar) throws IndexOutOfBoundException;

    // 특정 위치의 요소를 지정/조회할 수 있다. (스칼라로 입출력)
    Scalar getScalar(int row, int col) throws IndexOutOfBoundException;

    //크기 정보(행 개수)를 조회할 수 있다. (벡터는 차원, 행렬은 행개수, 열개수)
    int getSizeRow();

    //크기 정보(열 개수)를 조회할 수 있다. (벡터는 차원, 행렬은 행개수, 열개수)
    int getSizeCol();

    //행렬은 다른 행렬과 덧셈이 가능하다. (크기가 같을 때)
    Matrix add(Matrix matrix) throws SizeMismatchException;

    //행렬은 다른 행렬과 곱셈이 가능하다. ((mxn)x(nxl)일 때)
    // 다른 행렬이 왼쪽 행렬로서 곱해지는 경우와 오른쪽 행렬로서 곱해지는 경우 모두 지원 => isOperand=true -> this.matrix * matrix, isOperand=false -> matrix * this.matrix
    Matrix mul(Matrix matrix, boolean isOperand) throws SizeMismatchException;

    //행렬은 다른 행렬과 가로로 합쳐질 수 있다. (두 행렬의 행 수가 같아야 가능)
    //행렬은 다른 행렬과 세로로 합쳐질 수 있다. (두 행렬의 열 수가 같아야 가능)
    //concat(b,Tensors.CONCAT_DIRECTION_HORIZONTAL)이런식으로 사용
    //해당 객체가 가로로 합쳐질때는 왼쪽, 인자로 받은 행렬이 오른쪽
    //해당 객체가 세로로 합쳐질때는 위쪽, 인자로 받은 행렬이 아래쪽
    Matrix concat(Matrix a, int direction) throws SizeMismatchException;


    //행렬은 특정 행을 벡터 형태로 추출해 줄 수 있다. (행 벡터 추출)
    Vector getVectorRow(int row) throws IndexOutOfBoundException;

    //행렬은 특정 열을 벡터 형태로 추출해 줄 수 있다. (열 벡터 추출)
    Vector getVectorCol(int col) throws IndexOutOfBoundException;

    //행렬은 특정 범위의 부분 행렬을 추출해 줄 수 있다.
    Matrix getSubMatrix(int startRow, int startCol, int endRow, int endCol) throws IndexOutOfBoundException;

    //행렬은 특정 범위의 부분 행렬을 추출해 줄 수 있다.
    Matrix getMinorMatrix(int row, int col) throws IndexOutOfBoundException;

    //행렬은 전치행렬을 (새로 생성하여) 구해줄 수 있다. (transpose)
    Matrix getTranspose();

    //행렬은 대각 요소의 합을 구해줄 수 있다. (nxn 행렬) (trace)
    Scalar getTrace() throws NonSquareMatrixException;

    //행렬은 자신이 정사각 행렬인지 여부를 판별해 줄 수 있다.
    boolean isSquareMatrix();

    //행렬은 자신이 상삼각 행렬인지 여부를 판별해 줄 수 있다. (nxn 행렬) (upper triangular matrix)
    boolean isUpperTriangleMatrix();

    //행렬은 자신이 하삼각 행렬인지 여부를 판별해 줄 수 있다. (nxn 행렬) (lower triangular matrix)
    boolean isLowerTriangleMatrix();

    //행렬은 자신이 단위 행렬인지 여부를 판별해 줄 수 있다. (nxn 행렬) (identity matrix)
    boolean isIdentityMatrix();

    //행렬은 자신이 영 행렬인지 여부를 판별해 줄 수 있다. (zero matrix)
    boolean isZeroMatrix();

    /* TIP : 아래 6개 기능은 기본행렬 곱해서 만들면 쉽다. */
    //행렬은 특정 두 행의 위치를 맞교환할 수 있다.
    Matrix rowSwitchTransform(int row1, int row2) throws IndexOutOfBoundException;

    //행렬은 특정 두 열의 위치를 맞교환할 수 있다.
    Matrix colSwitchTransform(int col1, int col2) throws IndexOutOfBoundException;

    //행렬은 특정 행에 상수배(스칼라)를 할 수 있다.
    Matrix rowMultiplyTransform(int row, Scalar scalar) throws IndexOutOfBoundException;

    //행렬은 특정 열에 상수배(스칼라)를 할 수 있다.
    Matrix colMultiplyTransform(int col, Scalar scalar) throws IndexOutOfBoundException;

    //행렬은 특정 행에 다른 행의 상수배를 더할 수 있다.
    Matrix rowAdditionTransform(int destinationRow, int sourceRow, Scalar scalar) throws IndexOutOfBoundException; // M[destinationRow] += scalar * M[sourceRow]

    //행렬은 특정 열에 다른 열의 상수배를 더할 수 있다.
    Matrix colAdditionTransform(int destinationCol, int sourceCol, Scalar scalar) throws IndexOutOfBoundException; // M[destinationCol] += scalar * M[sourceCol]

    //행렬은 자신으로부터 RREF 행렬을 구해서 반환해 줄 수 있다. (row reduced echelon form)
    Matrix getRREF();

    //행렬은 자신이 RREF 행렬인지 여부를 판별해 줄 수 있다.
    boolean isRREF();

    //행렬은 자신의 행렬식을 구해줄 수 있다. (nxn 행렬) (determinant)
    Scalar getDeterminant() throws NonSquareMatrixException;

    //행렬은 자신의 역행렬을 구해줄 수 있다. (nxn 행렬) ## 예외 클래스 정의
    Matrix getInverseMatrix() throws NonSquareMatrixException, NonInvertibleMatrixException;

    //클론 함수 오버라이딩
    Object clone() throws CloneNotSupportedException;


}
