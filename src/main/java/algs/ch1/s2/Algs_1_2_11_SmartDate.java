package algs.ch1.s2;

/*
    1.2.11  Develop an implementation  SmartDate of our  Date API that raises an excep-
    tion if the date is not legal.
* */

public class Algs_1_2_11_SmartDate
{
    public static void main(String[] args) throws Exception
    {
        SmartDate smartDate1 = new SmartDate(6, 3, 2017);
        SmartDate smartDate2 = null;
        try
        {
            smartDate2 = new SmartDate(6, 31, 2017);
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }

        SmartDate smartDate3 = new SmartDate(6, 3, 2017);

        System.out.println(smartDate1.equals(smartDate2));
        System.out.println(smartDate1.equals(smartDate3));
    }

    private static class SmartDate
    {
        private static int[] days = new int[]{31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        private final int month;
        private final int day;
        private final int year;

        public SmartDate(int month, int day, int year) throws Exception
        {
            if (month < 1 || month > 12)
                throw new Exception("invalid month: " + month + "/" + day + "/" + year);
            if (day < 1 || day > days[month - 1])
                throw new Exception("invalid day: " + month + "/" + day + "/" + year);

            this.month = month;
            this.day = day;
            this.year = year;
        }

        public int month()
        {
            return month;
        }

        public int day()
        {
            return day;
        }

        public int year()
        {
            return year;
        }

        public String toString()
        {
            return month() + "/" + day() + "/" + year();
        }

        public boolean equals(Object x)
        {
            if (this == x) return true;
            if (x == null) return false;
            if (this.getClass() != x.getClass()) return false;
            SmartDate that = (SmartDate) x;
            if (this.day != that.day) return false;
            if (this.month != that.month) return false;
            if (this.year != that.year) return false;
            return true;
        }
    }
}
