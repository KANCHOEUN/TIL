package tensor;

import java.util.Comparator;

class ScalarImpl implements Scalar {
    Double s;

    ScalarImpl(Double value) {
        setValue(value);
    }

    ScalarImpl(Scalar scalar) {
        setValue(scalar.getValue());
    }

    ScalarImpl(double i, double j) {
        setValue(i, j);
    }

    ScalarImpl(Scalar i, Scalar j) {
        setValue(i.getValue(), j.getValue());
    }

    //전달받은 두 스칼라의 덧셈이 가능하다.
    static Scalar add(Scalar a, Scalar b) throws CloneNotSupportedException {
        return ((Scalar) a.clone()).add(b);
    }

    //전달받은 두 스칼라의 곱셈이 가능하다.
    static Scalar mul(Scalar a, Scalar b) throws CloneNotSupportedException {
        return ((Scalar) a.clone()).mul(b);
    }

    @Override
    public Double getValue() {
        return this.s;
    }

    @Override
    public void setValue(Double value) {
        s = Double.valueOf(value);
    }

    @Override
    public void setValue(Double i, Double j) {
        Double value = Math.random() * (j - i) + i;
        s = Double.valueOf(value);
    }

    @Override
    public Scalar add(Scalar scalar) {
        Scalar s = new ScalarImpl(this.s);
        s.setValue(s.getValue() + scalar.getValue());
        return s;
    }

    @Override
    public Scalar mul(Scalar scalar) {
        Scalar s = new ScalarImpl(this.s);
        s.setValue(s.getValue() * scalar.getValue());
        return s;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        Scalar o = (Scalar) super.clone();
        o.setValue(getValue());
        return o;
    }

    @Override
    public int compareTo(Scalar o) {
        return (int) (s - o.getValue());
    }

    @Override
    public boolean equals(Object obj) {
        Scalar scalar = (Scalar)obj;

        if(this.s == scalar.getValue()) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        String str = "";

        str += this.getValue();

        return str;
    }
}
