package algs;

/*
    1.2.12  Add a method  dayOfTheWeek() to  SmartDate that returns a  String value
    Monday ,  Tuesday ,  Wednesday ,  Thursday ,  Friday ,  Saturday , or  Sunday , giving the ap-
    propriate day of the week for the date. You may assume that the date is in the 21st
    century.
* */

import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Locale;

public class Algs_1_2_12_SmartDate2
{
    public static void main(String[] args) throws Exception
    {
        SmartDate smartDate1 = new SmartDate(6, 3, 2017);
        SmartDate smartDate2 = new SmartDate(1, 3, 2017);

        System.out.println(smartDate1.dayOfTheWeek());
        System.out.println(smartDate2.dayOfTheWeek());
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

        // no way I would want to do this without using the built-in functionality
        public String dayOfTheWeek()
        {
            return LocalDate.of(year, month, day).getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.getDefault());
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
