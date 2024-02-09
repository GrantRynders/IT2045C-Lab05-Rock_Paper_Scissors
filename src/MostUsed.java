public class MostUsed implements Strategy
{

    @Override
    public int determineMove(int playerChoice)
    {
        RockPaperScissorsRunner rps = new RockPaperScissorsRunner();
        System.out.println("COMPUTER USES MOST USED");
        int mostUsedInt = rps.GetMostUsed();
        return rps.CounterTo(mostUsedInt);
    }
}
