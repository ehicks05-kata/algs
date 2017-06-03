package algs;

/*
    1.2.14  Using our implementation of  equals() in  Date as a model (page 103), develop
    implementations of  equals() for  Transaction
* */

import edu.princeton.cs.algs4.StdRandom;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Algs_1_2_14_TransactionEquals
{
    public static void main(String[] args) throws Exception
    {
        List<Transaction> transactions = new ArrayList<>();
        for (int i = 0; i < 10; i++)
        {
            int year = StdRandom.uniform(2000, 2016);
            int month = StdRandom.uniform(1, 12);
            int day = StdRandom.uniform(1, 31);
            Transaction t = new Transaction("Anon", LocalDate.of(year, month, day), StdRandom.uniform(0.01, 10000));
            transactions.add(t);
        }

        System.out.println("unsorted");
        transactions.forEach(System.out::println);
        transactions.sort(Comparator.naturalOrder());
        System.out.println("sorted");
        transactions.forEach(System.out::println);
    }

    private static class Transaction implements Comparable<Transaction>
    {
        private final String who;
        private final LocalDate when;
        private final double amount;

        public Transaction(String who, LocalDate when, double amount)
        {
            this.who = who;
            this.when = when;
            this.amount = amount;
        }

        public String who()
        {
            return who;
        }

        public LocalDate when()
        {
            return when;
        }

        public double amount()
        {
            return amount;
        }

        @Override
        public int compareTo(Transaction o)
        {
            double difference = amount - o.amount;
            if (difference > 0) return 1;
            if (difference < 0) return -1;
            return 0;
        }

        @Override
        public String toString()
        {
            return "Transaction{" +
                    "who='" + who + '\'' +
                    ", when=" + when +
                    ", amount=" + amount +
                    '}';
        }

        @Override
        public boolean equals(Object o)
        {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Transaction that = (Transaction) o;

            if (Double.compare(that.amount, amount) != 0) return false;
            if (who != null ? !who.equals(that.who) : that.who != null) return false;
            return when != null ? when.equals(that.when) : that.when == null;
        }

        @Override
        public int hashCode()
        {
            int result;
            long temp;
            result = who != null ? who.hashCode() : 0;
            result = 31 * result + (when != null ? when.hashCode() : 0);
            temp = Double.doubleToLongBits(amount);
            result = 31 * result + (int) (temp ^ (temp >>> 32));
            return result;
        }
    }
}
