package test;

import tensor.*;

import static tensor.Factory.*;

public class Test implements Cloneable {

    public static void main(String[] args) {
        // 1. 값(double 혹은 Double)을 지정하여 스칼라를 생성할 수 있다.
        Scalar scalar1 = Factory.getScalar(1.0);
        System.out.println("(1) " + scalar1);

        // 2. i 이상 j 미만의 무작위 값을 요소로 하는 스칼라를 생성할 수 있다.
        Scalar scalar2 = Factory.getScalar(1.0, 10.0);
        System.out.println("(2) " + scalar2);

        // 3. 지정한 하나의 값을 모든 요소의 값으로 하는 n-차원 벡터를 생성할 수 있다.
        Vector vector1 = Factory.getVector(5, 1.0);
        System.out.println("(3) " + vector1);

        // 4. i 이상 j 미만의 무작위 값을 요소로 하는 n-차원 벡터를 생성할 수 있다.
        Vector vector2 = Factory.getVector(5, 1.0, 10.0);
        System.out.println("(4) " + vector2);

        // 5. 1차원 배열로부터 n-차원 벡터를 생성할 수 있다.
        Double[] arr = new Double[] {3.0, 3.0, 3.0, 3.0, 3.0};
        Vector vector3 = Factory.getVector(arr);
        System.out.println("(5) " + vector3);

        // 6. 지정한 하나의 값을 모든 요소의 값으로 하는 m x n 행렬을 생성할 수 있다.
        Matrix matrix1 = Factory.getMatrix(4, 4, 1.0);
        System.out.println("(6)");
        System.out.println(matrix1);

        // 7. i 이상 j 미만의 무작위 값을 요소로 하는 n-차원 벡터를 생성할 수 있다.
        Matrix matrix2 = Factory.getMatrix(3, 4, 1.0, 10.0);
        System.out.println("(7)" + matrix2);

        // 8. csv 파일로부터 m x n 행렬을 생성할 수 있다.
        // TODO csv

        // 9. 2차원 배열로부터 m x n 행렬을 생성할 수 있다.
        Double[][] arr2 = {{1.0, 2.0, 3.0, 4.0}, {5.0, 6.0, 7.0, 8.0}};
        Matrix matrix4 = Factory.getMatrix(arr2);
        System.out.println("(9) " + matrix4);

        // 10. 단위 행렬을 생성할 수 있다.
        Matrix matrix5 = Factory.getMatrix(4);
        System.out.println("(10) " + matrix5);

        // 11v1. 특정 위치의 요소를 지정할 수 있다.
        vector1.update(3, getScalar(4.0));
        System.out.println("(11v1) " + vector1);

        // 11v2. 특정 위치의 요소를 조회할 수 있다.
        System.out.println("(11v2) " + vector1.getScalar(3));

        // 11m1. 특정 위치의 요소를 지정할 수 있다.
        matrix1.update(1, 1, getScalar(10.0));
        System.out.println("(11m1) " + matrix1.getScalar(1, 1));

        // 11m2. 특정 위치의 요소를 조회할 수 있다.
        System.out.println("(11m2) " + matrix1.getScalar(1, 3));

        // 12s1. 값을 지정할 수 있다.
        scalar1.setValue(5.0);
        System.out.println("(12s1) " + scalar1);

        // 12s2. 값을 조회할 수 있다.
        System.out.println("(12s2) " + scalar2);

        // 13v. 크기 정보를 조회할 수 있다. ( 벡터는 차원 )
        System.out.println("(13v) " + vector1.getSize());

        // 13m. 크기 정보를 조회할 수 있다. ( 행렬은 행 개수 / 열 개수 )
        System.out.println("(13m) 행 : " + matrix2.getSizeRow() + " 열 : " + matrix2.getSizeCol());

        // 14s. double 값 하나 출력
        System.out.println("(14s) " + scalar1);

        // 14v. double 값들을 1차원 배열 모양으로 출력
        System.out.println("(14v) " + vector3);

        // 14m. double 값들을 2차원 배열 모양으로 출력
        System.out.println("(14m) " + matrix5);

        // 15s. 객체의 동등성 판단할 수 있다.
        System.out.println("(15s) " + scalar1.equals(scalar1));

        // 15v. 객체의 동등성 판단할 수 있다.
        System.out.println("(15v) " + vector1.equals(vector2));

        // 15m. 객체의 동등성 판단할 수 있다.
        System.out.println("(15m) " + matrix1.equals(matrix2));

        // 16. 스칼라의 경우 값의 대소 비교를 할 수 있다.
        System.out.println("(16) " + scalar1.compareTo(scalar2));

        // 17s. 객체 복제를 할 수 있다.
        try {
            Scalar scalar0 = (Scalar) scalar1.clone();
            System.out.println("(17s) " + scalar0);
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        // 17v. 객체 복제를 할 수 있다.
        try {
            Vector vector0 = (Vector) vector1.clone();
            System.out.println("(17v) " + vector0);
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        // 17m. 객체 복제를 할 수 있다.
        try {
            Matrix matrix0 = (Matrix) matrix1.clone();
            System.out.println("(17s) " + matrix0);
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        // 18. 스칼라는 다른 스칼라와 덧셈이 가능하다.
        System.out.println("(18) " + scalar1 + " + " + scalar2 + " = " + scalar1.add(scalar2));

        // 19. 스칼라는 다른 스칼라와 곱셈이 가능하다.
        System.out.println("(19) " + scalar1 + " * " + scalar2 + " = " + scalar1.mul(scalar2));

        // 20. 벡터는 다른 벡터와 덧셈이 가능하다. ( 길이가 같을 때 )
        System.out.println("(20) " + vector1 + " + " + vector2 + " = " + vector1.add(vector2));

        // 21. 벡터는 다른 스칼라와 곱셈이 가능하다. ( 벡터의 모든 요소에 스칼라를 곱함 )
        System.out.println("(21) " + vector1 + " * " + scalar2 + " = " + vector1.mul(scalar2));

        // 22. 행렬은 다른 행렬과 덧셈이 가능하다. ( 크기가 같을 때 )
        System.out.println("(22) " + matrix1 + " + " + matrix5 + " = " + matrix1.add(matrix5));

        // 23. 행렬은 다른 행렬과 곱셈이 가능하다. ( (m x n) x (n x l) 일 때 )
        System.out.println("(23) " + matrix1 + " * " + matrix5 + " = " + matrix1.mul(matrix5, true));
        System.out.println("(23) " + matrix5 + " * " + matrix1 + " = " + matrix1.mul(matrix5, false));

        // 24. 전달 받은 두 스칼라의 덧셈이 가능하다.
        try {
            System.out.println("(24) " + scalar1 + " + " + scalar2 + " = " + Tensors.add(scalar1,scalar2));
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        // 25. 전달 받은 두 스칼라의 곱셈이 가능하다.
        try {
            System.out.println("(25) " + scalar1 + " * " + scalar2 + " = " + Tensors.mul(scalar1,scalar2));
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        // 26. 전달 받은 두 벡터의 덧셈이 가능하다. ( 길이가 같을 때 )
        try {
            System.out.println("(26) " + vector1 + " + " + vector2 + " = " + Tensors.add(vector1, vector2));
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        // 27. 전달 받은 스칼라와 벡터의 곱셈이 가능하다. ( 벡터의 모든 요소에 스칼라를 곱함 )
        try {
            System.out.println("(27) " + vector1 + " * " + scalar2 + " = " + Tensors.mul(vector1, scalar2));
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        // 28. 전달 받은 두 행렬의 덧셈이 가능하다. ( 크기가 같을 때 )
        try {
            System.out.println("(28) " + matrix1 + " + " + matrix5 + " = " + Tensors.add(matrix1, matrix5));
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        // 29. 전달 받은 두 행렬의 곱셈이 가능하다. ( (m x n) x (n x l) 일 때 )
        try {
            System.out.println("(29) " + matrix1 + " * " + matrix5 + " = " + Tensors.mul(matrix1, matrix5));
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        // 30. n-차원 벡터 객체는 자신으로부터 n x 1 행렬을 생성하여 반환할 수 있다.
        System.out.println("(30) " +vector1.toMatrixNx1());
        // 31. n-차원 벡터 객체는 자신으로부터 1 x n 행렬을 생성하여 반환할 수 있다.
        System.out.println("(31) " +vector1.toMatrix1xN());

        // 32. 행렬은 다른 행렬과 가로로 합쳐질 수 있다. ( 두 행렬의 행 수가 같아야 가능 )
        System.out.println("(32) +" + matrix1.concat(matrix5, 1));
        // 33. 행렬은 다른 행렬과 세로로 합쳐질 수 있다. ( 두 행렬의 열 수가 같아야 가능 )
        System.out.println("(33) " + matrix1.concat(matrix5, 0));

        // 34. 행렬은 특정 행을 벡터 형태로 추출해 줄 수 있다. ( 행 벡터 추출 )
        System.out.println("(34) " + matrix1.getVectorRow(2));

        // 35. 행렬은 특정 열을 벡터 형태로 추출해 줄 수 있다. ( 열 벡터 추출 )
        System.out.println("(35) " + matrix1.getVectorCol(2));

        // 36. 행렬은 특정 범위의 부분 행렬을 추출해 줄 수 있다.
        System.out.println("(36)" + matrix5.getSubMatrix(1, 2, 2, 3));

        // 37. 행렬은 특정 하나의 행과 하나의 열을 제외한 행렬을 추출해 줄 수 있다.
        System.out.println("(37) " + matrix5.getMinorMatrix(1, 2));

        // 38. 행렬은 전치 행렬을 새로 생성하여 구해줄 수 있다.
        System.out.println("(38) " + matrix5.getTranspose());

        // 39. 행렬은 대각 요소의 합을 구해줄 수 있다. ( n xn 행렬 )
        System.out.println("(39) " + matrix5.getTrace());

        // 40. 행렬은 자신이 정사각 행렬인지 여부를 판별해 줄 수 있다.
        System.out.println("(40) " + matrix1.isSquareMatrix());

        // 41.
        System.out.println("(41) " + matrix1.isUpperTriangleMatrix());

        // 42.
        System.out.println("(42) " + matrix1.isLowerTriangleMatrix());

        // 43.
        System.out.println("(43) " + matrix1.isIdentityMatrix());

        // 44.
        System.out.println("(44) " + matrix1.isZeroMatrix());

        // 45.
        matrix1.rowSwitchTransform(1, 2);
        System.out.println("(45) " + matrix1);

        // 46.
        matrix1.colSwitchTransform(2, 3);
        System.out.println("(46) " + matrix1);

        // 47.
        matrix1.rowMultiplyTransform(2, scalar1);
        System.out.println("(47) " + matrix1);

        // 48.
        matrix1.colMultiplyTransform(3, scalar2);
        System.out.println("(48) " + matrix1);

        // 49.
        matrix1.rowAdditionTransform(0, 1, scalar2);
        System.out.println("(49) " + matrix1);

        // 50.
        matrix1.colAdditionTransform(2, 3, scalar1);
        System.out.println("(50) " + matrix1);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
