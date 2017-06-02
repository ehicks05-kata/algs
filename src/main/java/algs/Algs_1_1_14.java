package algs;

public class Algs_1_1_14
{
    public static int lg(int n)
    {
        int lg = 0;
        while (n > 1)
        {
            lg++;
            n /= 2;
        }
        return lg;
    }
}