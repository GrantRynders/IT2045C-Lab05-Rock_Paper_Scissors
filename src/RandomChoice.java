public class RandomChoice implements Strategy
{
    @Override
    public int determineMove(int playerChoice)
    {
        RockPaperScissorsRunner rps = new RockPaperScissorsRunner();
        System.out.println("COMPUTER USES RANDOM CHOICE");
        return rps.GenerateRandom(2, 0);
    }
}
