package algs.ch1.s2;

/*
1.2.19 Parsing. Develop the parse constructors for your  Date and  Transaction im-
plementations of Exercise 1.2.13 that take a single  String argument to specify the
initialization values, using the formats given in the table below.

Partial solution:

public Date(String date)
{
    String[] fields = date.split("/");
    month = Integer.parseInt(fields[0]);
    day = Integer.parseInt(fields[1]);
    year = Integer.parseInt(fields[2]);
}

Date - integers separated by slashes
    5/22/1939
Transaction - customer, date, and amount, separated by whitespace
    Turing 5/22/1939 11.99
    
* */

public class Algs_1_2_19_StringParsing
{
    public static void main(String[] args) throws Exception
    {
        Transaction transaction = new Transaction("Anon 6/4/2017 500.77");
        System.out.println(transaction);
    }

    public static class Date
    {
        private final int month;
        private final int day;
        private final int year;

        public Date(String date)
        {
            String[] fields = date.split("/");
            this.month = Integer.parseInt(fields[0]);
            this.day = Integer.parseInt(fields[1]);
            this.year = Integer.parseInt(fields[2]);
        }

        public String toString()
        {
            return month + "/" + day + "/" + year;
        }
    }

    private static class Transaction
    {
        private final String who;
        private final Date when;
        private final double amount;

        public Transaction(String transaction)
        {
            String[] fields = transaction.split(" ");

            this.who = fields[0];
            this.when = new Date(fields[1]);
            this.amount = Double.parseDouble(fields[2]);
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
    }
}
