package algs;

import edu.princeton.cs.algs4.StdRandom;

public class RPS {
    public static void main(String[] args) {
        int n = 100;

        double bestWinRate = 0;
        double bestFirstCutoff = 0;
        double bestSecondCutoff = 0;
        for (int i = 0; i < n; i++)
           for (int j = i; j < n; j++)
           {
               double winRate = playGame(i, j);
               if (winRate > bestWinRate)
               {
                   bestWinRate = winRate;
                   bestFirstCutoff = i;
                   bestSecondCutoff = j;
               }
               System.out.printf("%d %d %.3f\r\n", i, j, winRate);
           }

        System.out.println("bestWinRate: " + bestWinRate);
        System.out.println("bestFirstCutoff: " + bestFirstCutoff);
        System.out.println("bestSecondCutoff: " + bestSecondCutoff);
    }

    // rock=2, paper=1, scissor=0
    private static double playGame(int firstCutoff, int secondCutoff) {
        int p1Wins = 0;
        int p2Wins = 0;

        for (int i = 0; i< 10_000; i++)
        {
            int p1Move = getP1Move(firstCutoff, secondCutoff);
            int p2Move = getP2Move();

            if (p1Move == p2Move) continue;
            if (p1Move == 2)
            {
                if (p2Move == 1) p2Wins++;
                else p1Wins++;
            }
            if (p1Move == 1)
            {
                if (p2Move == 0) p2Wins++;
                else p1Wins++;
            }
            if (p1Move == 0)
            {
                if (p2Move == 2) p2Wins++;
                else p1Wins++;
            }
        }

        return (double) p1Wins / (p1Wins + p2Wins);
    }

    public static int getP1Move(int firstCutoff, int secondCutoff)
    {
        double roll = StdRandom.uniform();
        if (roll < (double) firstCutoff / 100) return 0;
        if (roll < (double) secondCutoff / 100) return 1;
        return 2;
    }

    public static int getP2Move()
    {
        double roll = StdRandom.uniform();
        if (roll < .25) return 0;
        if (roll < .6) return 1;
        return 2;
    }
}
