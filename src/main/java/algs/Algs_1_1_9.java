package algs;

public class Algs_1_1_9
{
    public static void main(String[] args)
    {
        int n = 8;
        String s = "";
        while (n > 0)
        {
            s = (n % 2) + s;
            n /= 2;
        }
        System.out.println(s);
    }
}