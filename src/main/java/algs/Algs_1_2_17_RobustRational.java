package algs;

/*
    1.2.17 Robust implementation of rational numbers. Use assertions to develop an im-
    plementation of  Rational (see Exercise 1.2.16) that is immune to overflow.
* */

public class Algs_1_2_17_RobustRational
{
    public static void main(String[] args) throws Exception
    {
        boolean negative = false;
//        boolean negative = true;
        String testMode = "plus";
//        String testMode = "minus";
//        String testMode = "times";
//        String testMode = "divides";

        int num = negative ? -1 : 1;
        int modifierNum = 2;
        if (testMode.equals("plus") || testMode.equals("minus"))
            modifierNum = 20000;

        Rational r = new Rational(num, 1);
        Rational modifier = new Rational(modifierNum, 1);
        while (true)
        {
            System.out.println(r);
            if (testMode.equals("plus"))
                r = r.plus(modifier);
            if (testMode.equals("minus"))
                r = r.minus(modifier);
            if (testMode.equals("times"))
                r = r.times(modifier);
            if (testMode.equals("divides"))
                r = r.divides(modifier);
        }
    }

    public static class Rational
    {
        private final int num;
        private final int den;

        public Rational(int num, int den)
        {
            int gcd = gcd(num, den);
            this.num = num / gcd;
            this.den = den / gcd;
        }

        private static int gcd(int p, int q)
        {
            if (q == 0) return p;
            int r = p % q;
            return gcd(q, r);
        }

        public Rational plus(Rational b)
        {
            long num = this.num;
            long den = this.den;
            long bNum = b.num;
            long bDen = b.den;
            if (den != b.den)
            {
                num *= bDen;
                den *= bDen;
                bNum *= this.den;
                bDen *= this.den;

                assert num >= Integer.MIN_VALUE && num <= Integer.MAX_VALUE : "overflow";
                assert den >= Integer.MIN_VALUE && den <= Integer.MAX_VALUE : "overflow";
                assert bNum >= Integer.MIN_VALUE && bNum <= Integer.MAX_VALUE : "overflow";
                assert bDen >= Integer.MIN_VALUE && bDen <= Integer.MAX_VALUE : "overflow";
            }
            assert (num + bNum) >= Integer.MIN_VALUE && (num + bNum) <= Integer.MAX_VALUE : "overflow";
            return new Rational((int) (num + bNum), (int) den);
        }

        public Rational minus(Rational b)
        {
            long num = this.num;
            long den = this.den;
            long bNum = b.num;
            long bDen = b.den;
            if (den != b.den)
            {
                num *= bDen;
                den *= bDen;
                bNum *= this.den;
                bDen *= this.den;

                assert num >= Integer.MIN_VALUE && num <= Integer.MAX_VALUE : "overflow";
                assert den >= Integer.MIN_VALUE && den <= Integer.MAX_VALUE : "overflow";
                assert bNum >= Integer.MIN_VALUE && bNum <= Integer.MAX_VALUE : "overflow";
                assert bDen >= Integer.MIN_VALUE && bDen <= Integer.MAX_VALUE : "overflow";
            }
            assert (num - bNum) >= Integer.MIN_VALUE && (num - bNum) <= Integer.MAX_VALUE : "overflow";
            return new Rational((int) (num - bNum), (int) den);
        }

        public Rational times(Rational b)
        {
            long num = this.num;
            long den = this.den;
            long bNum = b.num;
            long bDen = b.den;
            assert (num * bNum) >= Integer.MIN_VALUE && (num * bNum) <= Integer.MAX_VALUE : "overflow";
            assert (den * bDen) >= Integer.MIN_VALUE && (den * bDen) <= Integer.MAX_VALUE : "overflow";
            return new Rational((int) (num * b.num), (int) (den * b.den));
        }

        public Rational divides(Rational b)
        {
            long num = this.num;
            long den = this.den;
            long bNum = b.num;
            long bDen = b.den;
            assert (num * bDen) >= Integer.MIN_VALUE && (num * bDen) <= Integer.MAX_VALUE : "overflow";
            assert (den * bNum) >= Integer.MIN_VALUE && (den * bNum) <= Integer.MAX_VALUE : "overflow";
            return new Rational((int) (num * bDen), (int) (den * bNum));
        }

        @Override
        public boolean equals(Object o)
        {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Rational rational = (Rational) o;

            if (num != rational.num) return false;
            return den == rational.den;
        }

        @Override
        public int hashCode()
        {
            int result = num;
            result = 31 * result + den;
            return result;
        }

        @Override
        public String toString()
        {
            return "num=" + num +", den=" + den + ", dec=" + (double)num/den;
        }
    }
}
