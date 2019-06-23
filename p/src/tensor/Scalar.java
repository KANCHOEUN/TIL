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
//s,v,m. (@Override clone()) 객체 복제를 할 수 있다.
public interface Scalar extends Comparable<Scalar>, Cloneable {

    //값을 지정/조회할 수 있다. (Double로 입출력, 오토박싱 가능(double로 입력가능))
    Double getValue();

    //Scalar value를 설정
    void setValue(Double value);

    //i 이상 j 미만의 무작위 값을 요소로 하는 value를 설정
    void setValue(Double i, Double j);

    //스칼라는 다른 스칼라와 덧셈이 가능하다.
    Scalar add(Scalar scalar);

    //스칼라는 다른 스칼라와 곱셈이 가능하다.
    Scalar mul(Scalar scalar);

    //클론 함수 오버라이딩
    Object clone() throws CloneNotSupportedException;

}
