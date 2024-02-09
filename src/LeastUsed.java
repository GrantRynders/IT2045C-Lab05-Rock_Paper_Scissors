public class LeastUsed implements Strategy
{
    @Override
    public int determineMove(int playerChoice)
    {
        RockPaperScissorsRunner rps = new RockPaperScissorsRunner();
        System.out.println("COMPUTER USES LEAST USED");
        int leastUsedInt = rps.GetLeastUsed();
        return rps.CounterTo(leastUsedInt);
    }
}
