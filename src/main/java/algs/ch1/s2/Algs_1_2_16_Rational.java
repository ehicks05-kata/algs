package algs.ch1.s2;

/*
    1.2.16 Rational numbers. Implement an immutable data type  Rational for rational
    numbers that supports addition, subtraction, multiplication, and division.

    public class Rational
        Rational(int numerator. int denominator)
        Rational plus(Rational b)  sum of this number and b
        Rational minus(Rational b) difference of this number and b
        Rational times(Rational b) product of this number and b
        Rational divides(Rational b) quotient of this number and b
        boolean equals(Rational that) is this number equal to  that ?
        String toString() string representation

    You do not have to worry about testing for overflow (see Exercise 1.2.17), but use as
    instance variables two  long values that represent the numerator and denominator to
    limit the possibility of overflow. Use Euclid’s algorithm (see page 4) to ensure that the
    numerator and denominator never have any common factors. Include a test client that
    exercises all of your methods
* */

public class Algs_1_2_16_Rational
{
    public static void main(String[] args) throws Exception
    {
        Rational r1 = new Rational(2, 3);
        Rational r2 = new Rational(-3, 4);

        System.out.println(r1.plus(r2));
        System.out.println(r1.minus(r2));
        System.out.println(r1.times(r2));
        System.out.println(r1.divides(r2));
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
            int num = this.num;
            int den = this.den;
            int bNum = b.num;
            int bDen = b.den;
            if (den != b.den)
            {
                num *= bDen;
                den *= bDen;
                bNum *= this.den;
                bDen *= this.den;
            }
            return new Rational(num + bNum, den);
        }

        public Rational minus(Rational b)
        {
            int num = this.num;
            int den = this.den;
            int bNum = b.num;
            int bDen = b.den;
            if (den != b.den)
            {
                num *= bDen;
                den *= bDen;
                bNum *= this.den;
                bDen *= this.den;
            }
            return new Rational(num - bNum, den);
        }

        public Rational times(Rational b)
        {
            return new Rational(num * b.num, den * b.den);
        }

        public Rational divides(Rational b)
        {
            return new Rational(num * b.den, den * b.num);
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
            int result = (int) (num ^ (num >>> 32));
            result = 31 * result + (int) (den ^ (den >>> 32));
            return result;
        }

        @Override
        public String toString()
        {
            return "num=" + num +", den=" + den + ", dec=" + (double)num/den;
        }
    }
}
