package tensor;

import java.util.ArrayList;
import java.util.List;

class MatrixImpl implements Matrix {

    private List<List<Scalar>> matrix;
    private int row, col;

    MatrixImpl() {
        matrix = new ArrayList<>();
        row = col = 0;
    }

    MatrixImpl(int row, int col, double v) throws SizeMismatchException {
        this();
        setMatrix(row, col, v);
    }


    MatrixImpl(int row, int col, Scalar scalar) throws SizeMismatchException {
        this();
        setMatrix(row, col, scalar);
    }

    MatrixImpl(int row, int col, Double i, Double j) throws SizeMismatchException {
        this();
        setMatrix(row, col, i, j);
    }

    MatrixImpl(int row, int col, Scalar i, Scalar j) throws SizeMismatchException {
        this();
        setMatrix(row, col, i, j);
    }

    MatrixImpl(String csv) throws SizeMismatchException, WrongCSVFormatException {
        this();
        setMatrix(csv);
    }


    MatrixImpl(Double[][] value) throws SizeMismatchException {
        this();
        setMatrix(value);
    }

    MatrixImpl(Scalar[][] arr) throws SizeMismatchException {
        this();
        setMatrix(arr);
    }

    MatrixImpl(int n) throws SizeLessThanZeroException {
        this();
        setMatrix(n);
    }

    static int CONCAT_DIRECTION_HORIZONTAL = 0;
    static int CONCAT_DIRECTION_VERTICAL = 1;

    //전달받은 두 행렬의 덧셈이 가능하다. (크기가 같을 때)
    static Matrix add(Matrix a, Matrix b) throws SizeMismatchException, CloneNotSupportedException {
        if (a.getSizeRow() != b.getSizeRow() || a.getSizeCol() != b.getSizeCol())
            throw new SizeMismatchException();
        return ((Matrix) a.clone()).add(b);
    }

    //전달받은 두 행렬의 곱셈이 가능하다. ((mxn)x(nxl)일 때)
    static Matrix mul(Matrix a, Matrix b) throws SizeMismatchException, CloneNotSupportedException {
        if (a.getSizeCol() != b.getSizeRow())
            throw new SizeMismatchException();
        return ((Matrix) a.clone()).mul(b, true);
    }

    //행렬은 다른 행렬과 가로로 합쳐질 수 있다. (두 행렬의 행 수가 같아야 가능)
    //행렬은 다른 행렬과 세로로 합쳐질 수 있다. (두 행렬의 열 수가 같아야 가능)
    //concat(a,b,Matrix.CONCAT_DIRECTION_HORIZONTAL)이런식으로 사용
    static Matrix concat(Matrix a, Matrix b, int direction) throws SizeMismatchException {
        if (direction == CONCAT_DIRECTION_HORIZONTAL) {
            if (a.getSizeRow() != b.getSizeRow())
                throw new SizeMismatchException();
            Matrix matrix = new MatrixImpl(a.getSizeRow(), a.getSizeCol() + b.getSizeCol(), 0.0);
            for (int i = 0; i < a.getSizeRow(); i++) {
                for (int j = 0; j < a.getSizeCol(); j++) {
                    matrix.update(i, j, a.getScalar(i, j));
                }
                for (int j = 0; j < b.getSizeCol(); j++) {
                    matrix.update(i, a.getSizeCol() + j, b.getScalar(i, j));
                }
            }
            return matrix;
        } else {
            if (a.getSizeCol() != b.getSizeCol())
                throw new SizeMismatchException();
            Matrix matrix = new MatrixImpl(a.getSizeRow() + b.getSizeRow(), a.getSizeCol(), 0.0);
            for (int j = 0; j < a.getSizeCol(); j++) {
                for (int i = 0; i < a.getSizeRow(); i++) {
                    matrix.update(i, j, a.getScalar(i, j));
                }
                for (int i = 0; i < b.getSizeRow(); i++) {
                    matrix.update(i + a.getSizeRow(), j, b.getScalar(i, j));
                }
            }
            return matrix;
        }
    }

    @Override
    public void setMatrix(int row, int col, Double value) throws SizeLessThanZeroException {
        if (row < 0 || col < 0) {
            throw new SizeLessThanZeroException();
        }
        this.row = row;
        this.col = col;
        matrix = new ArrayList<>();
        for (int i = 0; i < row; i++) {
            List<Scalar> al = new ArrayList<>();
            for (int j = 0; j < col; j++) {
                al.add(new ScalarImpl(value));
            }
            matrix.add(al);
        }
    }

    @Override
    public void setMatrix(int row, int col, Scalar scalar) throws SizeLessThanZeroException {
        if (row < 0 || col < 0) {
            throw new SizeLessThanZeroException();
        }
        this.row = row;
        this.col = col;
        matrix = new ArrayList<>();
        for (int i = 0; i < row; i++) {
            List<Scalar> al = new ArrayList<>();
            for (int j = 0; j < col; j++) {
                al.add(scalar);
            }
            matrix.add(al);
        }
    }

    @Override
    public void setMatrix(int row, int col, Double i, Double j) throws SizeLessThanZeroException {
        if (row < 0 || col < 0) {
            throw new SizeLessThanZeroException();
        }
        this.row = row;
        this.col = col;
        matrix = new ArrayList<>();
        for (int k = 0; k < row; k++) {
            List<Scalar> al = new ArrayList<>();
            for (int l = 0; l < col; l++) {
                Double value = Math.random() * (j - i) + i;
                al.add(new ScalarImpl(value));
            }
            matrix.add(al);
        }
    }

    @Override
    public void setMatrix(int row, int col, Scalar i, Scalar j) throws SizeLessThanZeroException {
        if (row < 0 || col < 0) {
            throw new SizeLessThanZeroException();
        }
        this.row = row;
        this.col = col;
        matrix = new ArrayList<>();
        for (int k = 0; k < row; k++) {
            List<Scalar> al = new ArrayList<>();
            for (int l = 0; l < col; l++) {
                Double value = Math.random() * (j.getValue() - i.getValue()) + i.getValue();
                al.add(new ScalarImpl(value));
            }
            matrix.add(al);
        }
    }

    @Override
    public void setMatrix(String csv) throws SizeLessThanZeroException, WrongCSVFormatException {
        if (csv == null) {
            throw new SizeLessThanZeroException();
        }
        /*if() {
            // TODO CSVFormatException 부분 구현할 것
        }

        while() {

        }*/
    }

    @Override
    public void setMatrix(Double[][] arr) throws SizeLessThanZeroException {
        if (arr.length < 0 || arr[0].length < 0) {
            throw new SizeLessThanZeroException();
        }
        this.row = arr.length;
        this.col = arr[0].length;
        matrix = new ArrayList<>();
        for (int i = 0; i < row; i++) {
            List<Scalar> al = new ArrayList<>();
            for (int j = 0; j < col; j++) {
                al.add(new ScalarImpl(arr[i][j]));
            }
            matrix.add(al);
        }
    }

    @Override
    public void setMatrix(Scalar[][] arr) throws SizeLessThanZeroException {
        if (arr.length < 0 || arr[0].length < 0) {
            throw new SizeLessThanZeroException();
        }
        this.row = arr.length;
        this.col = arr[0].length;
        matrix = new ArrayList<>();
        for (int i = 0; i < row; i++) {
            List<Scalar> al = new ArrayList<>();
            for (int j = 0; j < col; j++) {
                al.add(arr[i][j]);
            }
            matrix.add(al);
        }

    }

    @Override
    public void setMatrix(int n) throws SizeLessThanZeroException {
        if (n < 0) {
            throw new SizeLessThanZeroException();
        }
        col = row = n;
        if (matrix.size() > 0) {
            matrix.clear();
        }
        for (int i = 0; i < n; i++) {
            List<Scalar> l = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    l.add(new ScalarImpl(1.0));
                } else {
                    l.add(new ScalarImpl(0.0));
                }
            }
            matrix.add(l);
        }
    }

    @Override
    public void update(int row, int col, Scalar scalar) throws IndexOutOfBoundException {
        if (row < 0 || col < 0 || row >= this.row || col >= this.col) {
            throw new IndexOutOfBoundException();
        }
        matrix.get(row).get(col).setValue(scalar.getValue());
    }

    @Override
    public Scalar getScalar(int row, int col) throws IndexOutOfBoundException {
        if (row < 0 || col < 0 || row >= this.row || col >= this.col) {
            throw new IndexOutOfBoundException();
        }
        return matrix.get(row).get(col);
    }

    @Override
    public int getSizeRow() {
        return row;
    }

    @Override
    public int getSizeCol() {
        return col;
    }

    @Override
    public Matrix add(Matrix matrix) throws SizeMismatchException {
        Matrix m = new MatrixImpl(this.getSizeRow(), this.getSizeCol(), 0.0);
        if (m.getSizeRow() != matrix.getSizeRow() || m.getSizeCol() != matrix.getSizeRow()) {
            throw new SizeMismatchException();
        }
        for (int i = 0; i < m.getSizeRow(); i++) {
            for (int j = 0; j < m.getSizeCol(); j++) {
                m.update(i, j, new ScalarImpl(m.getScalar(i, j).getValue() + matrix.getScalar(i, j).getValue()));
            }
        }
        return this;
    }

    @Override
    public Matrix mul(Matrix matrix, boolean isOperand) throws SizeMismatchException {
        Matrix m = new MatrixImpl(this.getSizeRow(), matrix.getSizeCol(), 0.0);

        if (isOperand) {
            if (getSizeCol() != matrix.getSizeRow()) {
                throw new SizeMismatchException();
            }
            Double[][] ret = new Double[this.row][matrix.getSizeCol()];
            for (int i = 0; i < this.row; i++) {
                for (int j = 0; j < matrix.getSizeCol(); j++) {
                    ret[i][j] = 0.0;
                    for (int l = 0; l < this.col; l++) {
                        ret[i][j] += getScalar(i, l).getValue() * matrix.getScalar(l, j).getValue();
                    }
                }
            }
            m.setMatrix(ret);
        } else {
            if (matrix.getSizeCol() != getSizeRow()) {
                throw new SizeMismatchException();
            }
            Double[][] ret = new Double[matrix.getSizeRow()][this.col];
            for (int i = 0; i < matrix.getSizeRow(); i++) {
                for (int j = 0; j < this.col; j++) {
                    ret[i][j] = 0.0;
                    for (int l = 0; l < matrix.getSizeCol(); l++) {
                        ret[i][j] += matrix.getScalar(i, l).getValue() * getScalar(l, j).getValue();
                    }
                }
            }
            m.setMatrix(ret);
        }

        return m;
    }

    @Override
    public Matrix concat(Matrix a, int direction) throws SizeMismatchException {
        if (direction == CONCAT_DIRECTION_HORIZONTAL) {
            if (this.getSizeRow() != a.getSizeRow())
                throw new SizeMismatchException();
            Matrix matrix = new MatrixImpl(this.getSizeRow(), this.getSizeCol() + a.getSizeCol(), 0.0);
            for (int i = 0; i < this.getSizeRow(); i++) {
                for (int j = 0; j < this.getSizeCol(); j++) {
                    matrix.update(i, j, this.getScalar(i, j));
                }
                for (int j = 0; j < a.getSizeCol(); j++) {
                    matrix.update(i, this.getSizeCol() + j, a.getScalar(i, j));
                }
            }
            return matrix;
        } else {
            if (this.getSizeCol() != a.getSizeCol())
                throw new SizeMismatchException();
            Matrix matrix = new MatrixImpl(this.getSizeRow() + a.getSizeRow(), this.getSizeCol(), 0.0);
            for (int j = 0; j < this.getSizeCol(); j++) {
                for (int i = 0; i < this.getSizeRow(); i++) {
                    matrix.update(i, j, this.getScalar(i, j));
                }
                for (int i = 0; i < a.getSizeRow(); i++) {
                    matrix.update(i + this.getSizeRow(), j, a.getScalar(i, j));
                }
            }
            return matrix;
        }
    }

    @Override
    public Vector getVectorRow(int row) throws IndexOutOfBoundException {
        if (row < 0 || row >= this.row) {
            throw new IndexOutOfBoundException();
        }
        Vector vector = new VectorImpl(this.col, 0.0);
        for (int i = 0; i < this.col; i++) {
            vector.update(i, getScalar(row, i));
        }
        return vector;
    }

    @Override
    public Vector getVectorCol(int col) throws IndexOutOfBoundException {
        if (col < 0 || col >= this.col) {
            throw new IndexOutOfBoundException();
        }
        Vector vector = new VectorImpl(this.row, 0.0);
        for (int i = 0; i < this.row; i++) {
            vector.update(i, getScalar(i, col));
        }
        return vector;
    }

    @Override
    public Matrix getSubMatrix(int startRow, int startCol, int endRow, int endCol) throws IndexOutOfBoundException {
        if (startRow < 0 || startCol < 0 || endRow < 0 || endCol < 0) {
            throw new IndexOutOfBoundException();
        }

        if (startRow >= row || endRow >= row || startCol >= col || endCol >= col) {
            throw new IndexOutOfBoundException();
        }

        if (endRow - startRow < 0 || endCol - startCol < 0) {
            throw new IndexOutOfBoundException();
        }

        int newRow = endRow - startRow + 1;
        int newCol = endCol - startCol + 1;

        Matrix matrix = new MatrixImpl(newRow, newCol, 0.0);
        for (int i = 0; i < newRow; i++) {
            for (int j = 0; j < newCol; j++) {
                matrix.update(i, j, getScalar(startRow + i, startCol + j));
            }
        }
        return matrix;
    }

    @Override
    public Matrix getMinorMatrix(int row, int col) throws IndexOutOfBoundException {
        if (row < 0 || col < 0) {
            throw new IndexOutOfBoundException();
        }

        if (row >= this.row || col >= this.col) {
            throw new IndexOutOfBoundException();
        }

        Matrix matrix = new MatrixImpl(this.row - 1, this.col - 1, 0.0);
        for (int i = 0; i < this.row - 1; i++) {
            for (int j = 0; j < this.col - 1; j++) {
                if (i != row && j != col) {
                    matrix.update(i, j, getScalar(i, j));
                }
            }
        }

        return matrix;
    }

    @Override
    public Matrix getTranspose() {
        Matrix matrix = new MatrixImpl(col, row, 0.0);
        for (int i = 0; i < col; i++) {
            for (int j = 0; j < row; j++) {
                matrix.update(col, row, getScalar(j, i));
            }
        }
        return matrix;
    }

    @Override
    public Scalar getTrace() throws NonSquareMatrixException {
        if (isSquareMatrix()) {
            double sum = 0.0;
            for (int i = 0; i < row; i++) {
                sum += getScalar(i, i).getValue();
            }
            return new ScalarImpl(sum);
        } else {
            throw new NonSquareMatrixException();
        }
    }

    @Override
    public boolean isSquareMatrix() {
        if (getSizeRow() == getSizeCol()) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean isUpperTriangleMatrix() {
        boolean flag = true;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (i > j) {
                    if (getScalar(i, j).getValue() != 0.0) {
                        flag = false;
                    }
                }
            }
        }

        return flag;
    }

    @Override
    public boolean isLowerTriangleMatrix() {
        boolean flag = true;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (i < j) {
                    if (getScalar(i, j).getValue() != 0.0) {
                        flag = false;
                    }
                }
            }
        }

        return flag;
    }

    @Override
    public boolean isIdentityMatrix() {
        boolean flag = true;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (i == j) {
                    if (getScalar(i, j).getValue() != 1.0) {
                        flag = false;
                    }
                } else {
                    if (getScalar(i, j).getValue() != 0.0) {
                        flag = false;
                    }
                }
            }
        }
        return flag;
    }

    @Override
    public boolean isZeroMatrix() {
        boolean flag = true;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (getScalar(i, j).getValue() != 0.0) {
                    flag = false;
                }
            }
        }
        return flag;
    }

    @Override
    public Matrix rowSwitchTransform(int row1, int row2) throws IndexOutOfBoundException {
        if (row1 < 0 || row2 < 0) {
            throw new IndexOutOfBoundException();
        }
        if (row1 >= row || row2 >= row) {
            throw new IndexOutOfBoundException();
        }

        Vector tmp = getVectorRow(row1);
        for (int i = 0; i < col; i++) {
            update(row1, i, getScalar(row2, i));
            update(row2, i, tmp.getScalar(i));
        }
        return this;
    }

    @Override
    public Matrix colSwitchTransform(int col1, int col2) throws IndexOutOfBoundException {
        if (col1 < 0 || col2 < 0) {
            throw new IndexOutOfBoundException();
        }
        if (col1 >= col || col2 >= col) {
            throw new IndexOutOfBoundException();
        }

        Vector tmp = getVectorCol(col1);
        for (int i = 0; i < row; i++) {
            update(i, col1, getScalar(i, col2));
            update(i, col2, tmp.getScalar(i));
        }
        return this;
    }

    @Override
    public Matrix rowMultiplyTransform(int row, Scalar scalar) throws IndexOutOfBoundException {
        if (row < 0 || row >= this.row) {
            throw new IndexOutOfBoundException();
        }
        for (int i = 0; i < col; i++) {
            update(row, i, new ScalarImpl(getScalar(row, i).getValue() * scalar.getValue()));
        }
        return this;
    }

    @Override
    public Matrix colMultiplyTransform(int col, Scalar scalar) throws IndexOutOfBoundException {
        if (col < 0 || col >= this.col) {
            throw new IndexOutOfBoundException();
        }
        for (int i = 0; i < row; i++) {
            update(i, col, new ScalarImpl(getScalar(i, col).getValue() * scalar.getValue()));
        }
        return this;
    }

    @Override
    public Matrix rowAdditionTransform(int destinationRow, int sourceRow, Scalar scalar) throws IndexOutOfBoundException {
        if (destinationRow < 0 || sourceRow < 0 || destinationRow >= row || sourceRow >= row) {
            throw new IndexOutOfBoundException();
        }

        for (int i = 0; i < col; i++) {
            update(destinationRow, i, new ScalarImpl(getScalar(destinationRow, i).getValue() + scalar.getValue() * getScalar(sourceRow, i).getValue()));
        }
        return this;
    }

    @Override
    public Matrix colAdditionTransform(int destinationCol, int sourceCol, Scalar scalar) throws IndexOutOfBoundException {
        if (destinationCol < 0 || sourceCol < 0 || destinationCol >= col || sourceCol >= col) {
            throw new IndexOutOfBoundException();
        }

        for (int i = 0; i < row; i++) {
            update(i, destinationCol, new ScalarImpl(getScalar(i, destinationCol).getValue() + scalar.getValue() * getScalar(i, sourceCol).getValue()));
        }

        return this;
    }

    @Override
    public Matrix getRREF() {
        Matrix matrix = new MatrixImpl(this.getSizeRow(), this.getSizeCol(), 0.0);

        // TODO 기약 행 사다리꼴로 정렬하는 것 다시 확인하기
        // 행 사이의 정렬 : 0 을 포함한 행렬은 아래로 기약행사다리꼴로 만들기 -> rowSwitchTransform 을 활용할 것
        for (int i = 0; i < matrix.getSizeRow(); i++) {
            for (int j = 0; j < matrix.getSizeCol(); j++) {
                if (j == 0 && matrix.getScalar(i, j).getValue() == 0.0) {
                    for (int k = i + 1; k < matrix.getSizeRow(); k++) {
                        if (matrix.getScalar(k, j).getValue() != 0.0) {
                            matrix.rowSwitchTransform(i, k);
                            break;
                        }
                    }
                } else if (j != 0 && matrix.getScalar(i, j).getValue() == 0.0) {
                    if (matrix.getScalar(i - 1, j).getValue() == 0.0) {
                        for (int k = i + 1; k < matrix.getSizeRow(); k++) {
                            if (matrix.getScalar(k, j).getValue() != 0.0) {
                                matrix.rowSwitchTransform(i, k);
                                break;
                            }
                        }
                    } else {
                        break;
                    }
                }
            }
        }

        // 최초의 1 만들기 -> rowMultiplyTransform 활용할 것
        for (int i = 0; i < matrix.getSizeRow(); i++) {
            for (int j = 0; j < matrix.getSizeCol(); i++) {
                if (matrix.getScalar(i, j).getValue() != 0.0) {
                    //  0 이 아닌 최초의 수 딱 한 번 발견 후 1 로 만들기
                    matrix.rowMultiplyTransform(i, new ScalarImpl(1 / matrix.getScalar(i, j).getValue()));
                    break;
                }
            }
        }

        // col 의 관점에서 1 이외에 모두 0 으로 만들기 -> rowAdditionTransform 을 활용할 것
        for (int i = matrix.getSizeRow() - 1; i >= 0; i--) {
            // 최초 1 발견하기
            int j; // 최초 1 의 col 값
            for (j = 0; j < matrix.getSizeCol(); j++) {
                if (matrix.getScalar(i, j).getValue() != 0.0) {
                    break;
                }
            }

            // 1 이외의 col 을 모두 0 으로 만들기
            for (int k = i - 1; k >= 0; k--) {
                if (matrix.getScalar(k, j).getValue() == 0.0) {
                    continue;
                } else {
                    matrix.rowAdditionTransform(k, i, new ScalarImpl(-1 * matrix.getScalar(i, k).getValue()));
                }
            }
        }

        return matrix;
    }

    @Override
    public boolean isRREF() {
        // 0이 아닌 원소를 갖는 행에서 맨 처음 나오는 0이 아닌 수는 1 이어야 한다.
        for (int i = 0; i < this.getSizeRow(); i++) {
            for (int j = 0; j < this.getSizeCol(); j++) {
                if (this.getScalar(i, j).getValue() != 0.0) {
                    if (this.getScalar(i, j).getValue() == 1) {
                        break;
                    } else {
                        return false;
                    }
                }
            }
        }

        // 0이 아닌 원소를 갖는 연속된 두 행은 해당 행의 leading 1이 윗 행의 leading 1 보다 오른쪽에 있어야 한다.
        boolean flag1 = false;
        boolean flag2 = false;
        int row1 = 0;
        int row2 = 0;

        for (int i = 0; i < this.getSizeRow() - 1; i++) {
            for (int j = 0; j < this.getSizeCol(); j++) {
                if (this.getScalar(i, j).getValue() != 0.0) {
                    row1 = j;
                    flag1 = true;
                    break;
                }
            }
            for (int j = 0; j < this.getSizeCol(); j++) {
                if (this.getScalar(i + 1, j).getValue() != 0.0) {
                    row2 = j;
                    flag2 = true;
                    break;
                }
            }

            if (flag1 && flag2) {
                if (row1 > row2) {
                    return false;
                }
            }
        }

        // leading 1이 있는 열의 나머지 원소들은 모두 0 이어야 한다.
        int col;
        for (int i = this.getSizeRow(); i >= 0; i--) {
            for (int j = 0; j < this.getSizeCol(); j++) {
                if (this.getScalar(i, j).getValue() != 0.0) {
                    col = j;
                    for (int k = this.getSizeRow() - 1; k >= 0; k--) {
                        if (this.getScalar(k, col).getValue() != 0.0) {
                            return false;
                        }
                    }
                    break;
                }
            }
        }

        return true;
    }

    @Override
    public Scalar getDeterminant() throws NonSquareMatrixException {
        if (!isSquareMatrix()) {
            throw new NonSquareMatrixException();
        }
        return new ScalarImpl(Determinant(this));
    }

    double Determinant(Matrix matrix) {
        int num = matrix.getSizeRow();
        double det = 0;

        if (num == 1) {
            return matrix.getScalar(0, 0).getValue();
        } else if (num == 2) {
            Scalar a = matrix.getScalar(0, 0);
            Scalar b = matrix.getScalar(0, 1);
            Scalar c = matrix.getScalar(1, 0);
            Scalar d = matrix.getScalar(1, 1);
            return a.getValue() * d.getValue() - b.getValue() * c.getValue();
        } else {
            int row = 0;
            for (int i = 0; i < getSizeCol(); i++) {
                if ((row + i) % 2 == 0) {
                    det += 1 * Determinant(getMinorMatrix(row, i));
                } else {
                    det += -1 * Determinant(getMinorMatrix(row, i));
                }
            }
            return det;
        }
    }

    @Override
    public Matrix getInverseMatrix() throws NonSquareMatrixException, NonInvertibleMatrixException {
        if (!isSquareMatrix()) {
            throw new NonSquareMatrixException();
        }

        Matrix matrix = this.getTranspose();
        double det = this.getDeterminant().getValue();

        for (int i = 0; i < matrix.getSizeRow(); i++) {
            for (int j = 0; j < matrix.getSizeCol(); j++) {
                matrix.getVectorRow(i).update(j, new ScalarImpl(matrix.getScalar(i, j).getValue() / det));
            }
        }

        return matrix;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        Matrix m = (Matrix) super.clone();
        m.setMatrix(getSizeRow(), getSizeCol(), 0.0);
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                m.update(i,j,getScalar(i, j));
            }
        }

        return m;
    }

    @Override
    public boolean equals(Object obj) {
        Matrix matrix = (Matrix) obj;

        if (this.getSizeRow() == matrix.getSizeRow() && this.getSizeCol() == matrix.getSizeCol()) {
            for (int i = 0; i < this.getSizeRow(); i++) {
                for (int j = 0; j < this.getSizeCol(); j++) {
                    if (this.getScalar(i, j).getValue() != matrix.getScalar(i, j).getValue()) {
                        return false;
                    }
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
        for (int i = 0; i < getSizeRow(); i++) {
            for (int j = 0; j < getSizeCol(); j++) {
                str += getScalar(i, j).getValue() + " ";
            }
            str += "\n";
        }
        return str;
    }
}
